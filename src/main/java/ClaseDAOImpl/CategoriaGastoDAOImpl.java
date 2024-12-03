
package ClaseDAOImpl;

import ClaseDAO.CategoriaGastoDAO;
import Clases.CategoriaGasto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ConexionBD.ConexionDB;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementación de la interfaz {@link CategoriaGastoDAO} para acceder y 
 * gestionar los datos de la entidad {@link CategoriaGasto} en la base de datos.
 * 
 * <p>
 * Esta clase proporciona métodos para realizar operaciones CRUD (Actualizar
 * y Obtener) sobre la tabla de categorías de gasto.
 * </p>
 * 
 * @author Luan Condori
 */
public class CategoriaGastoDAOImpl implements CategoriaGastoDAO 
{
    private Connection conexion;
    private static final Logger logger = Logger.getLogger(CategoriaGastoDAOImpl.class.getName());

    
    public CategoriaGastoDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }


     /**
     * Actualiza la asignación de una categoría de gasto en la base de datos
     * basada en el nombre.
     * 
     * @param nombre     el nombre de la categoría de gasto.
     * @param asignacion la nueva asignación de la categoría.
     */
    public void updateCategoriaGasto(String nombre, double asignacion) {
        String sql = "UPDATE categoria_gasto SET asignacion = ? WHERE nombre = ?";

        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, asignacion);
            pstmt.setString(2, nombre);

            pstmt.executeUpdate(); // Ejecutar la actualización
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
   /**
     * Actualiza una categoría de gasto en la base de datos.
     * 
     * @param categoriaGasto el objeto {@link CategoriaGasto} con la información
     *                       actualizada.
     */
    @Override
    public void actualizar(CategoriaGasto categoriaGasto) {
    // Nombre de la tabla corregido
    String sql = "UPDATE categoria_gasto SET nombre = ?, asignacion = ? WHERE id_categoria = ?";
    
    // Crear un logger para registrar los eventos
    Logger logger = Logger.getLogger(CategoriaGastoDAOImpl.class.getName());
    
    // Registrar el inicio de la actualización
    logger.info("Iniciando actualización para la categoría de gasto con ID: " + categoriaGasto.getIdCategoria());
    
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        // Establecer los parámetros de la consulta
        stmt.setString(1, categoriaGasto.getNombre());
        stmt.setDouble(2, categoriaGasto.getAsignacion());
        stmt.setInt(3, categoriaGasto.getIdCategoria());
        
        // Ejecutar la actualización
        int rowsAffected = stmt.executeUpdate();
        
        // Registrar el resultado de la actualización
        if (rowsAffected > 0) {
            // Si se actualizó correctamente
            logger.info("Categoría de gasto con ID " + categoriaGasto.getIdCategoria() + " actualizada exitosamente.");
        } else {
            // Si no se actualizó ninguna fila
            logger.warning("No se encontró la categoría de gasto con ID " + categoriaGasto.getIdCategoria() + " para actualizar.");
        }
    } catch (SQLException e) {
        // Registrar el error en caso de fallo
        logger.log(Level.SEVERE, "Error al actualizar la categoría de gasto con ID: " + categoriaGasto.getIdCategoria(), e);
    }
    }

     /**
     * Obtiene una categoría de gasto por su ID desde la base de datos.
     * 
     * @param idCategoria el identificador único de la categoría de gasto.
     * @return un objeto {@link CategoriaGasto} si se encuentra en la base de datos,
     *         {@code null} en caso contrario.
     */
    @Override
    public CategoriaGasto obtenerPorId(int idCategoria) {
    // Consulta SQL para obtener la categoría de gasto por ID
    String sql = "SELECT * FROM categoria_gasto WHERE id_categoria = ?";
    CategoriaGasto categoriaGasto = null;
    
    // Registrar el inicio de la consulta
    logger.info("Iniciando consulta para obtener la categoría de gasto con ID: " + idCategoria);
    
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setInt(1, idCategoria);
        ResultSet rs = stmt.executeQuery();
        
        // Verificar si se encontró un registro
        if (rs.next()) {
            categoriaGasto = new CategoriaGasto(
                rs.getInt("id_categoria"),
                rs.getString("nombre"),
                rs.getDouble("asignacion")
            );
            
            // Log de éxito cuando se obtiene la categoría de gasto
            logger.info("Categoría de gasto encontrada: " + categoriaGasto.toString());
        } else {
            // Log si no se encuentra el registro
            logger.warning("No se encontró la categoría de gasto con ID: " + idCategoria);
        }
    } catch (SQLException e) {
        // Log del error en caso de fallo
        logger.log(Level.SEVERE, "Error al obtener la categoría de gasto con ID: " + idCategoria, e);
    }
    
    return categoriaGasto;
}
   /**
     * Obtiene todas las categorías de gasto almacenadas en la base de datos.
     * 
     * @return una lista de objetos {@link CategoriaGasto} que representan todas las
     *         categorías de gasto registradas.
     */
    @Override
    public List<CategoriaGasto> obtenerTodos() {
        String sql = "SELECT * FROM categoria_gasto";
        List<CategoriaGasto> categorias = new ArrayList<>();
        try (Statement stmt = conexion.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                CategoriaGasto categoriaGasto = new CategoriaGasto(
                    rs.getInt("id_categoria"),
                    rs.getString("nombre"),
                    rs.getDouble("asignacion")
                );
                categorias.add(categoriaGasto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categorias;
    }
}

