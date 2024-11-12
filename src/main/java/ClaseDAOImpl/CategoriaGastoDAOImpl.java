
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
        String sql = "UPDATE CategoriaGasto SET asignacion = ? WHERE nombre = ?";

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
        String sql = "UPDATE CategoriaGasto SET nombre = ?, asignacion = ? WHERE id_categoria = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, categoriaGasto.getNombre());
            stmt.setDouble(2, categoriaGasto.getAsignacion());
            stmt.setInt(3, categoriaGasto.getIdCategoria());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
        String sql = "SELECT * FROM CategoriaGasto WHERE id_categoria = ?";
        CategoriaGasto categoriaGasto = null;
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idCategoria);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                categoriaGasto = new CategoriaGasto(
                    rs.getInt("id_categoria"),
                    rs.getString("nombre"),
                    rs.getDouble("asignacion")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
        String sql = "SELECT * FROM CategoriaGasto";
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

