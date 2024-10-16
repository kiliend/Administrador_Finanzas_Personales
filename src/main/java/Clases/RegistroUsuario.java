package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroUsuario {

    public boolean registrarUsuario(Usuario usuario) {
        Conexion conexion = new Conexion();
        Connection con = conexion.estableceConexion();
        String sql = "INSERT INTO Usuario(nombre, apellidos, dni, telefono, correo_electronico, usuario, contrasena) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getDni());
            ps.setString(4, usuario.getTelefono());
            ps.setString(5, usuario.getCorreoElectronico());
            ps.setString(6, usuario.getUsuario());
            ps.setString(7, usuario.getContrasena());
            ps.executeUpdate();
            return true;
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
