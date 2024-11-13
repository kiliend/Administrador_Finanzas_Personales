package RegistrarIngreso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para manejar la conexión a la base de datos MySQL.
 *
 * Esta clase proporciona un método estático para obtener una conexión a la base
 * de datos especificada, utilizando el controlador JDBC de MySQL.
 *
 * @author Rodney Piers Salazar Arapa
 *
 */
public class IngresoConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/administrador"; // Cambia "finanzas" por el nombre de tu base de datos
    private static final String USER = "root"; // Cambia según tu configuración
    private static final String PASSWORD = "root"; // Cambia según tu configuración

    /**
     * Obtiene una conexión a la base de datos MySQL.
     *
     * @return La conexión a la base de datos, o null si no se pudo establecer
     * la conexión.
     */
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

