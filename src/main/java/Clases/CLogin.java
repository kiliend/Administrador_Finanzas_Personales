package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * clase encargada del inicio de sesion
 *
 * @author ANDREI KENDRICK YAIR
 */
public class CLogin {

    /**
     * metodo para la verificacion de usuario y contraseña
     *
     * @param usuario identificador del usuario
     * @param contrasena contraseña del usuario
     * @return inicio de sesion exitoso
     */
    public String validarUsuario(String usuario, String contrasena) {
        Conexion conexion = new Conexion();
        Connection con = conexion.estableceConexion();
        String sql = "SELECT id_usuario FROM Usuario WHERE usuario = ? AND contrasena = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("id_usuario"); // Retorna el identificador único (id_usuario en este caso)
            } else {
                return null; // Usuario no encontrado
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
