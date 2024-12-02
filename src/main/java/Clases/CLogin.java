package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
   private static final Logger logger = LoggerFactory.getLogger(CLogin.class);

    public String validarUsuario(String usuario, String contrasena) {
        Conexion conexion = new Conexion();
        Connection con = conexion.estableceConexion();
        String sql = "SELECT id_usuario FROM Usuario WHERE usuario = ? AND contrasena = ?";

        try {
            logger.info("Iniciando validación de usuario: {}", usuario);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                logger.info("Inicio de sesión exitoso para el usuario: {}", usuario); 
                return rs.getString("id_usuario");
            } else {
                logger.warn("contraseña incorrectos para el usuario: {}", usuario); 
                return null;
            }
        } catch (SQLException e) {
            logger.error("Error al validar usuario: {}", usuario, e); 
            return null;
        } 
    }
}
