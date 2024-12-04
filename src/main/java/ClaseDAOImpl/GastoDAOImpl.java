/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClaseDAOImpl;

import ClaseDAO.GastoDAO;
import Clases.Gasto;
import Clases.UsuarioSesion;
import ConexionBD.ConexionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luan Condori
 */
public class GastoDAOImpl implements GastoDAO {

    private static final Logger logger = Logger.getLogger(GastoDAOImpl.class.getName());
    
    
@Override
public void registrarGasto(Gasto gasto) throws SQLException {
    String sql = "INSERT INTO gasto (cantidad, descripcion, fecha, id_usuario, id_categoria) VALUES (?, ?, ?, ?, ?)";
    logger.info("Iniciando el proceso de registro del gasto...");
    
    try (Connection conexion = ConexionDB.getConexion(); 
         PreparedStatement ps = conexion.prepareStatement(sql)) {

        // Log detallado de los valores antes de hacer el set
        logger.fine("Cantidad del gasto: " + gasto.getCantidad());
        logger.fine("Descripción del gasto: " + gasto.getDescripcion());
        logger.fine("Fecha del gasto: " + gasto.getFecha());
        logger.fine("ID del usuario: " + gasto.getIdUsuario());
        logger.fine("ID de la categoría: " + gasto.getIdCategoria());

        // Convertir la fecha si es un String en formato 'yyyy-MM-dd'


        // Establecer los parámetros del PreparedStatement
        ps.setDouble(1, gasto.getCantidad());
        ps.setString(2, gasto.getDescripcion());
        ps.setDate(3, new java.sql.Date(gasto.getFecha().getTime()));
        ps.setInt(4, gasto.getIdUsuario());
        ps.setInt(5, gasto.getIdCategoria());

        // Ejecutar la inserción
        ps.executeUpdate();
        logger.info("Gasto registrado correctamente: " + gasto.getDescripcion());

    } catch (SQLException e) {
        logger.log(Level.SEVERE, "Error al registrar el gasto", e);
        throw e; // Propagar la excepción después de registrar el error
    }
}


 @Override
    public List<Gasto> obtenerGastosPorUsuario(int idUsuario) throws SQLException {
        List<Gasto> listaGastos = new ArrayList<>();
        String sql = "SELECT id_gasto, descripcion, cantidad, fecha, id_categoria FROM gasto WHERE id_usuario = ?";

        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);  // Establecer el ID del usuario en el PreparedStatement
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idGasto = rs.getInt("id_gasto");
                String descripcion = rs.getString("descripcion");
                double cantidad = rs.getDouble("cantidad");
                Date fecha = rs.getDate("fecha");
                int idCategoria = rs.getInt("id_categoria");

                // Crear un objeto Gasto y añadirlo a la lista
                Gasto gasto = new Gasto(idGasto, cantidad, descripcion, fecha, idUsuario, idCategoria);
                listaGastos.add(gasto);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al obtener los gastos del usuario con ID " + idUsuario, e);
        }

        return listaGastos;
    }

    @Override
    public double obtenerTotalGastosPorUsuario(int idUsuario) throws SQLException {
        String sql = "SELECT SUM(cantidad) FROM gasto WHERE id_usuario = ?";
        try (Connection conexion = ConexionDB.getConexion(); 
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener el total de gastos", e);
            throw e;
        }
        return 0;
    } 
    @Override
    public void actualizarGasto(Gasto gasto) throws SQLException {
        String sql = "UPDATE gasto SET descripcion = ?, cantidad = ? WHERE id_gasto = ?";

        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            // Establecemos los parámetros del PreparedStatement
            ps.setString(1, gasto.getDescripcion());  // Descripción
            ps.setDouble(2, gasto.getCantidad());     // Monto
            ps.setInt(3, gasto.getIdGasto());         // ID del gasto

            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Gasto actualizado correctamente.");
            } else {
                System.out.println("No se encontró el gasto para actualizar.");
            }
        } catch (SQLException e) {
            throw new SQLException("Error al actualizar el gasto", e);
        }
    }
     @Override
    public void eliminarGasto(int idGasto) throws SQLException {
        // Primero verificamos si el gasto es del mismo día
        String sqlVerificar = "SELECT fecha FROM gasto WHERE id_gasto = ?";
        
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement psVerificar = conexion.prepareStatement(sqlVerificar)) {
            
            psVerificar.setInt(1, idGasto);
            ResultSet rs = psVerificar.executeQuery();
            
            if (rs.next()) {
                Date fechaGasto = rs.getDate("fecha");
                LocalDate fechaGastoLocal = fechaGasto.toLocalDate();
                LocalDate fechaActual = LocalDate.now();
                
                // Si la fecha del gasto no es la misma que la fecha actual, no se puede eliminar
                if (!fechaGastoLocal.isEqual(fechaActual)) {
                    throw new SQLException("Solo se pueden eliminar gastos del día de hoy.");
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error al verificar el gasto", e);
        }

        // Si la fecha es del mismo día, procedemos a eliminar el gasto
        String sqlEliminar = "DELETE FROM gasto WHERE id_gasto = ?";
        
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement psEliminar = conexion.prepareStatement(sqlEliminar)) {
            
            psEliminar.setInt(1, idGasto);
            int filasEliminadas = psEliminar.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Gasto eliminado correctamente.");
            } else {
                System.out.println("No se encontró el gasto para eliminar.");
            }
        } catch (SQLException e) {
            throw new SQLException("Error al eliminar el gasto", e);
        }
    }


}
