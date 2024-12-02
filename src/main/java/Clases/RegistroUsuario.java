package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * clase encargada del registro de un nuuevo usuario
 *
 * @author ANDREI KENDRICK YAIR BERNAOLA SANDOVAL
 */
public class RegistroUsuario {

    /**
     * metodo para registrar un nuevo usuario en la base de datos
     *
     * @param usuario un nuevo usuario
     * @return registro exitoso
     */
     private static final Logger logger = LoggerFactory.getLogger(RegistroUsuario.class);

    public boolean registrarUsuario(Usuario usuario) {
        Conexion conexion = new Conexion();
        Connection con = conexion.estableceConexion();
        String sql = "INSERT INTO Usuario(nombre, apellidos, dni, telefono, correo_electronico, usuario, contrasena) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            logger.info("Iniciando el registro de un nuevo usuario: {}", usuario.getUsuario()); 
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getDni());
            ps.setString(4, usuario.getTelefono());
            ps.setString(5, usuario.getCorreoElectronico());
            ps.setString(6, usuario.getUsuario());
            ps.setString(7, usuario.getContrasena());
            ps.executeUpdate();
            logger.info("Usuario registrado exitosamente: {}", usuario.getUsuario()); 
            return true;
        } catch (SQLException e) {
            logger.error("Error al registrar usuario: {}", usuario.getUsuario(), e); 
            return false;
        }    
    }

    /**
     * metodo para editar la informacion de un usuario existente.
     *
     * @param usuario usuario con datos validos
     * @return usuario editado
     */
    public boolean editarUsuario(Usuario usuario) {
        Conexion conexion = new Conexion();
        Connection con = conexion.estableceConexion();
        String sql = "UPDATE Usuario SET nombre = ?, correo_electronico = ?, dni = ?, telefono = ? WHERE id_usuario = ?";

        try {
            logger.info("Iniciando la edición de datos del usuario: {}", usuario.getIdUsuario()); 
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreoElectronico());
            ps.setString(3, usuario.getDni());
            ps.setString(4, usuario.getTelefono());
            ps.setInt(5, usuario.getIdUsuario());
            ps.executeUpdate();
            logger.info("Usuario editado exitosamente: {}", usuario.getIdUsuario()); 
            return true;
        } catch (SQLException e) {
            logger.error("Error al editar usuario: {}", usuario.getIdUsuario(), e); 
            return false;
        } 
    }

    public boolean existeUsuario(String nombreUsuario) {
        Conexion conexion = new Conexion();
        Connection con = conexion.estableceConexion();
        String sql = "SELECT COUNT(*) FROM Usuario WHERE usuario = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombreUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Retorna true si el usuario ya existe
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
