/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RegistrarIngreso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;  // Aquí se importa ResultSet
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorFinanzas {

    // Método para registrar el ingreso en la base de datos
    public void registrarIngreso(double monto, String categoria, LocalDate fecha) {
        String sql = "INSERT INTO ingresos (monto, categoria, fecha) VALUES (?, ?, ?)";

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, monto);
            pstmt.setString(2, categoria);
            pstmt.setDate(3, java.sql.Date.valueOf(fecha));  // Convierte LocalDate a java.sql.Date

            pstmt.executeUpdate();
            System.out.println("Ingreso registrado en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al registrar ingreso.");
            e.printStackTrace();
        }
    }

    // Método para mostrar ingresos desde la base de datos
    public void mostrarIngresos() {
        String sql = "SELECT * FROM ingresos";

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {  // Ejecutar la consulta y obtener ResultSet

            while (rs.next()) {
                double monto = rs.getDouble("monto");
                String categoria = rs.getString("categoria");
                LocalDate fecha = rs.getDate("fecha").toLocalDate();
                System.out.println("Ingreso: " + monto + ", Categoria: " + categoria + ", Fecha: " + fecha);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener ingresos.");
            e.printStackTrace();
        }
    }

    public List<Object[]> obtenerIngresos() {
        List<Object[]> ingresos = new ArrayList<>(); // Lista de objetos para almacenar los datos

        String sql = "SELECT * FROM ingresos";  // Consulta para obtener todos los ingresos
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            // Recorrer los resultados y almacenarlos en la lista
            while (rs.next()) {
                int id = rs.getInt("id");
                double monto = rs.getDouble("monto");
                String categoria = rs.getString("categoria");
                LocalDate fecha = rs.getDate("fecha").toLocalDate();

                // Añadir cada fila como un arreglo de objetos
                ingresos.add(new Object[]{id, monto, categoria, fecha});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ingresos;  // Devolver la lista de ingresos
    }
}
