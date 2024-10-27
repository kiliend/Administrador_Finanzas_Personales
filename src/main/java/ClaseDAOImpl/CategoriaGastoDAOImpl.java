/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author Luan Condori
 */
public class CategoriaGastoDAOImpl implements CategoriaGastoDAO
{
    private Connection conexion;

    public CategoriaGastoDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    // Actualizar una categoría de gasto
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

    // Obtener una categoría de gasto por su ID
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

    // Obtener todas las categorías de gasto
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

