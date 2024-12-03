package ClaseDAOImpl;

import ClaseDAO.ObjetivoDAO;
import Clases.Objetivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementación de la interfaz ObjetivoDAO para la gestión de
 * operaciones CRUD relacionadas con la entidad Objetivo.
 * Esta clase se encarga de interactuar con la base de datos para 
 * insertar, actualizar, eliminar y obtener registros de objetivos.
 * 
 * @author Luan Condori
 */
public class ObjetivoDAOImpl implements ObjetivoDAO {
    
    private static final Logger logger = Logger.getLogger(ObjetivoDAOImpl.class.getName());
    private final Connection conexion;

    public ObjetivoDAOImpl(Connection conexion) {
        this.conexion = conexion;
}

@Override
public void insertar(Objetivo objetivo) {
    String sql = "INSERT INTO Objetivo (descripcion, fecha_inicio, fecha_fin, cantidad, id_usuario) VALUES (?, ?, ?, ?, ?)";
    try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        stmt.setString(1, objetivo.getDescripcion());
        stmt.setString(2, objetivo.getFechaInicio().toString()); // Convertir LocalDate a String
        stmt.setString(3, objetivo.getFechaFin().toString());     // Convertir LocalDate a String
        stmt.setDouble(4, objetivo.getCantidad());
        stmt.setInt(5, objetivo.getIdUsuario());

        // Ejecutar la inserción
        stmt.executeUpdate();

        // Obtener el ID generado automáticamente (el id_objetivo)
        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int idGenerado = generatedKeys.getInt(1);
                objetivo.setIdObjetivo(idGenerado); // Asignar el id generado al objeto
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    @Override
    public void actualizar(Objetivo objetivo) {
        String sql = "UPDATE Objetivo SET descripcion = ?, fecha_inicio = ?, fecha_fin = ?, cantidad = ?, id_usuario = ? WHERE id_objetivo = ?";
        
        // Registrar la ejecución del método de actualización
        logger.info("Ejecutando actualización para el objetivo con ID: " + objetivo.getIdObjetivo());
        logger.info("Nuevos datos: descripcion=" + objetivo.getDescripcion() + 
                    ", fecha_inicio=" + objetivo.getFechaInicio() + 
                    ", fecha_fin=" + objetivo.getFechaFin() + 
                    ", cantidad=" + objetivo.getCantidad() + 
                    ", id_usuario=" + objetivo.getIdUsuario());
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, objetivo.getDescripcion());
            stmt.setString(2, objetivo.getFechaInicio().toString()); // Convertir LocalDate a String
            stmt.setString(3, objetivo.getFechaFin().toString());     // Convertir LocalDate a String
            stmt.setDouble(4, objetivo.getCantidad());
            stmt.setInt(5, objetivo.getIdUsuario());
            stmt.setInt(6, objetivo.getIdObjetivo());

            int rowsAffected = stmt.executeUpdate();

            // Si se actualizaron filas, registrar el éxito
            if (rowsAffected > 0) {
                logger.info("Objetivo con ID " + objetivo.getIdObjetivo() + " actualizado exitosamente.");
            } else {
                // Si no se actualizaron filas, registrar que no se encontró el objetivo
                logger.warning("No se encontró el objetivo con ID " + objetivo.getIdObjetivo() + " para actualizar.");
            }
        } catch (SQLException e) {
            // Registrar el error en caso de fallo
            logger.log(Level.SEVERE, "Error al actualizar el objetivo con ID " + objetivo.getIdObjetivo(), e);
        }
    }
    /**
     * Elimina un objetivo de la base de datos según su ID.
     * 
     * @param idObjetivo El ID del objetivo a eliminar.
     */
   @Override
public void eliminar(int idObjetivo) {
    String sqlSelect = "SELECT fecha_inicio FROM Objetivo WHERE id_objetivo = ?";
    
    // Registrar inicio de la operación de eliminación
    logger.info("Iniciando eliminación del objetivo con ID: " + idObjetivo);
    
    try (PreparedStatement stmt = conexion.prepareStatement(sqlSelect)) {
        stmt.setInt(1, idObjetivo);
        ResultSet rs = stmt.executeQuery();

        // Verificar si existe el objetivo y comparar la fecha
        if (rs.next()) {
            LocalDate fechaCreacion = rs.getDate("fecha_inicio").toLocalDate();
            LocalDate fechaActual = LocalDate.now();
            
            // Validar si la fecha de creación es el mismo día
            if (fechaCreacion.isEqual(fechaActual)) {
                String sqlDelete = "DELETE FROM Objetivo WHERE id_objetivo = ?";
                try (PreparedStatement deleteStmt = conexion.prepareStatement(sqlDelete)) {
                    deleteStmt.setInt(1, idObjetivo);
                    int rowsAffected = deleteStmt.executeUpdate();

                    // Registrar el resultado de la eliminación
                    if (rowsAffected > 0) {
                        logger.info("Objetivo con ID " + idObjetivo + " eliminado exitosamente.");
                    } else {
                        logger.warning("No se encontró el objetivo con ID " + idObjetivo + " para eliminar.");
                    }
                }
            } else {
                // Si la fecha no es el mismo día
                logger.warning("No se puede eliminar el objetivo con ID " + idObjetivo + " porque su fecha de creación no es hoy.");
            }
        } else {
            // Si no se encontró el objetivo con ese ID
            logger.warning("No se encontró el objetivo con ID " + idObjetivo + " para eliminar.");
        }
    } catch (SQLException e) {
        // Registrar el error en caso de fallo
        logger.log(Level.SEVERE, "Error al intentar eliminar el objetivo con ID " + idObjetivo, e);
    }
}
    /**
     * Obtiene un objetivo de la base de datos según su ID.
     * 
     * @param idObjetivo El ID del objetivo a obtener.
     * @return El objetivo encontrado o null si no existe.
     */
    @Override
    public Objetivo obtenerPorId(int idObjetivo) {
         String sql = "SELECT * FROM Objetivo WHERE id_objetivo = ?";
        Objetivo objetivo = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idObjetivo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                objetivo = new Objetivo(
                    rs.getInt("id_objetivo"),
                    rs.getString("descripcion"),
                    LocalDate.parse(rs.getString("fecha_inicio"), formatter),
                    LocalDate.parse(rs.getString("fecha_fin"), formatter),
                    rs.getDouble("cantidad"),
                    rs.getInt("id_usuario")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objetivo;
    }

    @Override
    public List<Objetivo> obtenerTodos() {
           String sql = "SELECT * FROM Objetivo";
        List<Objetivo> objetivos = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try (Statement stmt = conexion.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Objetivo objetivo = new Objetivo(
                    rs.getInt("id_objetivo"),
                    rs.getString("descripcion"),
                    LocalDate.parse(rs.getString("fecha_inicio"), formatter),
                    LocalDate.parse(rs.getString("fecha_fin"), formatter),
                    rs.getDouble("cantidad"),
                    rs.getInt("id_usuario")
                );
                objetivos.add(objetivo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objetivos;
    }
/**
 * Recupera una lista de objetivos de la base de datos filtrada por el ID de usuario.
 * 
 * <p>
 * Este método ejecuta una consulta SQL que selecciona todos los objetivos que tienen
 * un `id_usuario` específico. Se utiliza el parámetro `idUsuario` para filtrar los
 * objetivos en la base de datos.
 * </p>
 * 
 * @param idUsuario El ID del usuario cuyos objetivos se desean recuperar.
 * @return una lista de Objetivo asociados al `idUsuario` proporcionado. 
 *         Si no se encuentran objetivos, se devuelve una lista vacía.
 */
 @Override
    public List<Objetivo> obtenerPorUsuario(int idUsuario) {
        String sql = "SELECT * FROM Objetivo WHERE id_usuario = ?";
        List<Objetivo> objetivos = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Registrar que se va a ejecutar la consulta
        logger.info("Ejecutando consulta para obtener objetivos para el usuario con ID: " + idUsuario);
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario); // Filtrar por el id_usuario
            ResultSet rs = stmt.executeQuery();

            // Registrar que la consulta fue exitosa
            logger.info("Consulta ejecutada correctamente. Procesando resultados...");

            while (rs.next()) {
                Objetivo objetivo = new Objetivo(
                    rs.getInt("id_objetivo"),
                    rs.getString("descripcion"),
                    LocalDate.parse(rs.getString("fecha_inicio"), formatter),
                    LocalDate.parse(rs.getString("fecha_fin"), formatter),
                    rs.getDouble("cantidad"),
                    rs.getInt("id_usuario")
                );
                objetivos.add(objetivo);
            }
            
            // Registrar el número de objetivos obtenidos
            logger.info("Se han obtenido " + objetivos.size() + " objetivos para el usuario con ID: " + idUsuario);

        } catch (SQLException e) {
            // Registrar el error de la consulta
            logger.log(Level.SEVERE, "Error al obtener los objetivos para el usuario con ID: " + idUsuario, e);
        }

        return objetivos;
    }

    }
