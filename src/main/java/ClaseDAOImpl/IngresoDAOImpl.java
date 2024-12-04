/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClaseDAOImpl;

import ClaseDAO.IngresoDAOInterface;
import Clases.Conexion;
import Clases.Ingreso;
import Clases.UsuarioSesion;
import ConexionBD.ConexionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luan Condori
 * Implementación de la interfaz IngresoDAOInterface.
 * Esta clase maneja las operaciones relacionadas con la entidad 'Ingreso' en la base de datos.
 * Las operaciones incluyen la inserción, actualización, eliminación, obtención del último ingreso,
 * obtención del ingreso más alto del mes, y el cálculo del total de ingresos del mes.
 */
 
public class IngresoDAOImpl implements IngresoDAOInterface {
   // Logger para registrar las actividades realizadas en la clase
    private static final Logger logger = Logger.getLogger(IngresoDAOImpl.class.getName());
    private Connection conexion;

    /**
     * Constructor de la clase IngresoDAOImpl.
     * Inicializa la conexión a la base de datos a través de ConexionDB.
     */
    public IngresoDAOImpl() {
        this.conexion = ConexionDB.getConexion(); // Obtiene la conexión a la base de datos
    }

    /**
     * Agrega un nuevo ingreso a la base de datos.
     * 
     * @param ingreso El objeto Ingreso que contiene los datos a insertar.
     * @throws SQLException Si ocurre algún error al interactuar con la base de datos.
     */
@Override
public void agregarIngreso(Ingreso ingreso) throws SQLException {
           Connection conexion = ConexionDB.getConexion();  // Correcto
        if (conexion != null) {
            String query = "INSERT INTO ingreso (cantidad, fecha, descripcion, id_usuario) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setDouble(1, ingreso.getCantidad());
                ps.setDate(2, (Date) ingreso.getFecha());
                ps.setString(3, ingreso.getDescripcion());
                ps.setInt(4, UsuarioSesion.getUserId());
                ps.executeUpdate();
                System.out.println("Ingreso agregado exitosamente");
            } catch (SQLException e) {
                System.out.println("Error al agregar el ingreso: " + e.getMessage());
                throw e;
            } finally {
                ConexionDB.cerrarConexion(conexion);
            }
        }
    }



    /**
     * Obtiene una lista de ingresos de un usuario específico.
     * Los resultados son ordenados por el campo 'id_usuario'.
     * 
     * @param idUsuario El ID del usuario cuyo ingreso se quiere obtener.
     * @return Una lista de objetos Ingreso que representan los ingresos del usuario.
     * @throws SQLException Si ocurre algún error al interactuar con la base de datos.
     */
 @Override
public List<Ingreso> obtenerIngresosPorUsuario(int idUsuario) throws SQLException {
    // Usamos el parámetro idUsuario directamente
    logger.info("Obteniendo ingresos para el usuario con ID: " + idUsuario);

    List<Ingreso> ingresos = new ArrayList<>();
    String query = "SELECT * FROM ingreso WHERE id_usuario = ? ORDER BY id_usuario";

    try (Connection connection = ConexionDB.getConexion();
         PreparedStatement statement = connection.prepareStatement(query)) {

        // Establecer el parámetro id_usuario
        statement.setInt(1, idUsuario);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Ingreso ingreso = new Ingreso();
            ingreso.setIdIngreso(rs.getInt("id_ingreso"));
            ingreso.setCantidad(rs.getDouble("cantidad"));
            ingreso.setFecha(rs.getDate("fecha"));
            ingreso.setDescripcion(rs.getString("descripcion"));
            ingresos.add(ingreso);
        }

        logger.info("Ingresos obtenidos con éxito.");
    } catch (SQLException e) {
        logger.log(Level.SEVERE, "Error al obtener los ingresos", e);
    }

    return ingresos;
}


    /**
     * Obtiene el último ingreso registrado de un usuario.
     * 
     * @param idUsuario El ID del usuario cuyo último ingreso se desea obtener.
     * @return Un objeto Ingreso que contiene los detalles del último ingreso del usuario,
     *         o null si no se encuentra ningún ingreso.
     * @throws SQLException Si ocurre algún error al interactuar con la base de datos.
     */
    @Override
    public Ingreso obtenerUltimoIngreso(int idUsuario) throws SQLException {
        String sql = "SELECT * FROM ingreso WHERE id_usuario = ? ORDER BY fecha DESC LIMIT 1";
        logger.info("Obteniendo el último ingreso para el usuario ID: " + idUsuario);
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Ingreso ingreso = new Ingreso(
                    rs.getInt("id_ingreso"),
                    rs.getDouble("cantidad"),
                    rs.getDate("fecha"),
                    rs.getString("descripcion"),
                    rs.getInt("id_usuario")
                );
                logger.info("Último ingreso obtenido: " + ingreso);
                return ingreso;
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener el último ingreso", e);
            throw e;
        }
        return null; // Retorna null si no se encuentra ningún ingreso
    }

    /**
     * Obtiene el ingreso más alto registrado para un usuario en un mes específico.
     * 
     * @param idUsuario El ID del usuario cuyo ingreso más alto se desea obtener.
     * @param mes El mes para el cual se debe obtener el ingreso más alto (en formato 'YYYY-MM').
     * @return Un objeto Ingreso que contiene los detalles del ingreso más alto,
     *         o null si no se encuentra ningún ingreso en ese mes.
     * @throws SQLException Si ocurre algún error al interactuar con la base de datos.
     */
        @Override
        public Ingreso obtenerIngresoMasAltoDelMes(int idUsuario, String mes) throws SQLException {
            // Suponiendo que 'mes' viene en formato 'YYYY-MM', vamos a crear el rango de fechas
            String sql = "SELECT * FROM ingreso WHERE id_usuario = ? AND fecha >= ? AND fecha < ? ORDER BY cantidad DESC LIMIT 1";
            logger.info("Obteniendo el ingreso más alto para el usuario ID: " + idUsuario + " en el mes: " + mes);
            try (PreparedStatement ps = conexion.prepareStatement(sql)) {
                // Parsear el mes y agregar las fechas de inicio y fin del mes
                String inicioMes = mes + "-01"; // Primer día del mes
                String finMes = mes + "-31";   // Último día del mes (puedes ajustar este valor si el mes tiene menos de 31 días)

                // Establecemos las fechas de inicio y fin del mes en el PreparedStatement
                ps.setInt(1, idUsuario);
                ps.setString(2, inicioMes); // Fecha de inicio
                ps.setString(3, finMes);   // Fecha de fin
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    Ingreso ingreso = new Ingreso(
                        rs.getInt("id_ingreso"),
                        rs.getDouble("cantidad"),
                        rs.getDate("fecha"),
                        rs.getString("descripcion"),
                        rs.getInt("id_usuario")
                    );
                    logger.info("Ingreso más alto obtenido: " + ingreso);
                    return ingreso;
                }
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Error al obtener el ingreso más alto", e);
                throw e;
            }
            return null; // Retorna null si no se encuentra ningún ingreso
        }

    /**
     * Obtiene el total de ingresos de un usuario en un mes específico.
     * 
     * @param idUsuario El ID del usuario cuyo total de ingresos se desea obtener.
     * @param mes El mes para el cual se desea calcular el total de ingresos (en formato 'YYYY-MM').
     * @return El total de ingresos en formato de tipo double.
     * @throws SQLException Si ocurre algún error al interactuar con la base de datos.
     */
        @Override
        public double obtenerTotalIngresosDelMes(int idUsuario, String mes) throws SQLException {
            // Suponiendo que 'mes' viene en formato 'YYYY-MM', vamos a crear el rango de fechas
            String sql = "SELECT SUM(cantidad) FROM ingreso WHERE id_usuario = ? AND fecha >= ? AND fecha < ?";
            logger.info("Obteniendo el total de ingresos para el usuario ID: " + idUsuario + " en el mes: " + mes);
            try (PreparedStatement ps = conexion.prepareStatement(sql)) {
                // Parsear el mes y agregar las fechas de inicio y fin del mes
                String inicioMes = mes + "-01"; // Primer día del mes
                String finMes = mes + "-31";   // Último día del mes (ajustar según el mes)

                // Establecemos las fechas de inicio y fin del mes en el PreparedStatement
                ps.setInt(1, idUsuario);
                ps.setString(2, inicioMes); // Fecha de inicio
                ps.setString(3, finMes);   // Fecha de fin
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    double total = rs.getDouble(1);
                    logger.info("Total de ingresos en el mes: " + total);
                    return total; // Devuelve el total de ingresos
                }
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Error al obtener el total de ingresos", e);
                throw e;
            }
            return 0; // Retorna 0 si no se encuentran ingresos
        }


    /**
     * Actualiza los detalles de un ingreso existente en la base de datos.
     * 
     * @param ingreso El objeto Ingreso que contiene los nuevos detalles.
     * @throws SQLException Si ocurre algún error al interactuar con la base de datos.
     */
@Override
public void actualizarIngreso(int idIngreso, double nuevoMonto, String nuevaDescripcion) throws SQLException {
    String query = "UPDATE ingreso SET cantidad = ?, descripcion = ? WHERE id_ingreso = ?";
    try (Connection connection = ConexionDB.getConexion();
         PreparedStatement statement = connection.prepareStatement(query)) {
        
        statement.setDouble(1, nuevoMonto); // Establecemos el nuevo monto
        statement.setString(2, nuevaDescripcion); // Establecemos la nueva descripción
        statement.setInt(3, idIngreso); // Establecemos el id del ingreso que se va a actualizar
        statement.executeUpdate(); // Ejecutamos la actualización
        logger.info("Ingreso con ID " + idIngreso + " actualizado correctamente.");
    } catch (SQLException e) {
        logger.log(Level.SEVERE, "Error al actualizar el ingreso con ID " + idIngreso, e);
        throw e; // Re-lanzamos la excepción para manejarla en la interfaz
    }
}

    /**
     * Elimina un ingreso de la base de datos.
     * 
     * @param idIngreso El ID del ingreso que se desea eliminar.
     * @throws SQLException Si ocurre algún error al interactuar con la base de datos.
     */
public void eliminarIngreso(int idIngreso) throws SQLException {
    String query = "DELETE FROM ingreso WHERE id_ingreso = ?";
    try (Connection connection = ConexionDB.getConexion();
         PreparedStatement statement = connection.prepareStatement(query)) {
        
        statement.setInt(1, idIngreso);
        statement.executeUpdate();
        logger.info("Ingreso con ID " + idIngreso + " eliminado correctamente.");
    } catch (SQLException e) {
        logger.log(Level.SEVERE, "Error al eliminar el ingreso con ID " + idIngreso, e);
        throw e;  // Re-lanzamos la excepción para manejarla en la interfaz
    }
}
    /**
     * Obtiene el último id_ingreso registrado en la base de datos.
     * @return El último id_ingreso.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    public int obtenerUltimoIdIngreso() throws SQLException {
        int ultimoIdIngreso = 0;
        
        // Consulta SQL para obtener el último id_ingreso
        String query = "SELECT MAX(id_ingreso) FROM ingreso";
        
        // Conexión a la base de datos (asegúrate de tener una conexión establecida)
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(query); 
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                ultimoIdIngreso = rs.getInt(1);  // Obtiene el valor del primer (y único) campo: el máximo id_ingreso
            }
        }
        
        return ultimoIdIngreso;
    }
}
