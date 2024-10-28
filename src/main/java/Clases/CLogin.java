package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * clase encargada del inicio de sesion
 * @author ANDREI KENDRICK YAIR
 */
public class CLogin {

    /**
     * metodo para la verificacion de usuario y contraseña 
     * @author ANDREI KENDRICK YAIR BERNAOLA SANDOVAL
     * 
     * @param usuario identificador del usuario
     * @param contrasena contraseña del usuario 
     * @return inicio de sesion exitoso
     */
    public boolean validarUsuario(String usuario, String contrasena) {
        Conexion conexion = new Conexion();
        Connection con = conexion.estableceConexion();
        String sql = "SELECT * FROM Usuario WHERE usuario = ? AND contrasena = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            ResultSet rs = ps.executeQuery();
            return rs.next();  
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
