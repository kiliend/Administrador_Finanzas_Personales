package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private static final String USUARIO = "root"; //poner usuario de mysql
    private static final String CONTRASENA = "root"; //poner contraseña de mysql
    private static final String BD = "administrador";
    private static final String IP = "localhost";
    private static final String PUERTO = "3306";

    private static final String CADENA = "jdbc:mysql://" + IP + ":" + PUERTO + "/" + BD;

    public Connection estableceConexion() {
        Connection conectar = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(CADENA, USUARIO, CONTRASENA);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage());
        }
        return conectar;
    }
}

