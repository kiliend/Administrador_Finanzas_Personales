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

    public void actualizarIngreso(int id, double nuevoMonto, String nuevaCategoria, LocalDate nuevaFecha) {
        String sql = "UPDATE ingresos SET monto = ?, categoria = ?, fecha = ? WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, nuevoMonto);
            pstmt.setString(2, nuevaCategoria);
            pstmt.setDate(3, java.sql.Date.valueOf(nuevaFecha));
            pstmt.setInt(4, id);

            int filasActualizadas = pstmt.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Ingreso actualizado correctamente.");
            } else {
                System.out.println("No se encontró el ingreso con el ID proporcionado.");
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar el ingreso.");
            e.printStackTrace();
        }
    }

    public void eliminarIngreso(int id) {
        String sql = "DELETE FROM ingresos WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            pstmt.executeUpdate();
            System.out.println("Ingreso eliminado de la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el ingreso.");
            e.printStackTrace();
        }
    }

}
