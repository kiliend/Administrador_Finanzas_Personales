/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import ConexionBD.ConexionDB;
/**
 * Implementación de la interfaz ObjetivoDAO para la gestión de
 * operaciones CRUD relacionadas con la entidad Objetivo.
 * Esta clase se encarga de interactuar con la base de datos para 
 * insertar, actualizar, eliminar y obtener registros de objetivos.
 * 
 * @author Luan Condori
 */
public class ObjetivoDAOImpl implements ObjetivoDAO
{

    private Connection conexion;

    public ObjetivoDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    public ObjetivoDAOImpl() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     /**
     * Inserta un nuevo objetivo en la base de datos.
     * 
     * @param objetivo El objetivo a insertar.
     */
    @Override
    public void insertar(Objetivo objetivo) {
        String sql = "INSERT INTO Objetivo (descripcion, fecha_inicio, fecha_fin, cantidad, id_usuario) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, objetivo.getDescripcion());
            stmt.setString(2, objetivo.getFechaInicio());
            stmt.setString(3, objetivo.getFechaFin());
            stmt.setDouble(4, objetivo.getCantidad());
            stmt.setInt(5, objetivo.getIdUsuario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     /**
     * Actualiza un objetivo existente en la base de datos.
     * 
     * @param objetivo El objetivo con los nuevos datos para actualizar.
     */
    @Override
    public void actualizar(Objetivo objetivo) {
        String sql = "UPDATE Objetivo SET descripcion = ?, fecha_inicio = ?, fecha_fin = ?, cantidad = ?, id_usuario = ? WHERE id_objetivo = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, objetivo.getDescripcion());
            stmt.setString(2, objetivo.getFechaInicio());
            stmt.setString(3, objetivo.getFechaFin());
            stmt.setDouble(4, objetivo.getCantidad());
            stmt.setInt(5, objetivo.getIdUsuario());
            stmt.setInt(6, objetivo.getIdObjetivo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     /**
     * Elimina un objetivo de la base de datos según su ID.
     * 
     * @param idObjetivo El ID del objetivo a eliminar.
     */
    @Override
    public void eliminar(int idObjetivo) {
        String sql = "DELETE FROM Objetivo WHERE id_objetivo = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idObjetivo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idObjetivo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                objetivo = new Objetivo(
                    rs.getInt("id_objetivo"),
                    rs.getString("descripcion"),
                    rs.getString("fecha_inicio"),
                    rs.getString("fecha_fin"),
                    rs.getDouble("cantidad"),
                    rs.getInt("id_usuario")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objetivo;
    }

      /**
     * Obtiene todos los objetivos almacenados en la base de datos.
     * 
     * @return Una lista con todos los objetivos.
     */
    @Override
    public List<Objetivo> obtenerTodos() {
        String sql = "SELECT * FROM Objetivo";
        List<Objetivo> objetivos = new ArrayList<>();
        try (Statement stmt = conexion.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Objetivo objetivo = new Objetivo(
                    rs.getInt("id_objetivo"),
                    rs.getString("descripcion"),
                    rs.getString("fecha_inicio"),
                    rs.getString("fecha_fin"),
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
     * Agrega un nuevo objetivo a la base de datos.
     * 
     * @param objetivo El objetivo a agregar.
     */
        public void addObjetivo(Objetivo objetivo) {
        String sql = "INSERT INTO Objetivo (descripcion, fecha_inicio, fecha_fin, cantidad) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, objetivo.getDescripcion());
           // pstmt.setDate(2, objetivo.getFechaInicio());
          //  pstmt.setDate(3, objetivo.getFechaFin());
            pstmt.setDouble(4, objetivo.getCantidad());

            pstmt.executeUpdate(); // Ejecutar la inserción
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
