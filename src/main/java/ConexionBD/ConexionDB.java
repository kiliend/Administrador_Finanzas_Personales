/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para gestionar la conexión a la base de datos MySQL. Proporciona
 * métodos para obtener y cerrar la conexión.
 *
 * <p>
 * Esta clase se utiliza para conectar la aplicación a la base de datos
 * "FinanzasPersonales" mediante el driver JDBC de MySQL.
 * </p>
 *
 * @author Luan Condori
 */
public class ConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/administrador";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "root";

    /**
     * Obtiene una conexión a la base de datos.
     *
     * <p>
     * Este método carga el driver JDBC de MySQL y establece una conexión con la
     * base de datos especificada en la URL. Si la conexión es exitosa, se
     * devuelve un objeto {@link Connection}. En caso de error, se captura y
     * maneja la excepción.
     * </p>
     *
     * @return un objeto {@link Connection} si la conexión es exitosa,
     * {@code null} en caso contrario.
     */
    public static Connection getConexion() {
        Connection conexion = null;
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver de MySQL: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return conexion;
    }

    /**
     * Cierra la conexión a la base de datos.
     *
     * <p>
     * Este método cierra la conexión especificada, si no es {@code null}. Si
     * ocurre un error al cerrar la conexión, la excepción se captura y se
     * imprime un mensaje de error.
     * </p>
     *
     * @param conexion el objeto {@link Connection} a cerrar.
     */
    public static void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
