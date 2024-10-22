package RegistrarIngreso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/finanzas"; // Cambia "finanzas" por el nombre de tu base de datos
    private static final String USER = "root"; // Cambia según tu configuración
    private static final String PASSWORD = "root"; // Cambia según tu configuración

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a MySQL.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a MySQL.");
            e.printStackTrace();
        }
        return conn;
    }
}
