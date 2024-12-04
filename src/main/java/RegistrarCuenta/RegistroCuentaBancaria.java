package RegistrarCuenta;

import ConexionBD.ConexionDB;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Rodney Piers Salazar Arapa
 */
public class RegistroCuentaBancaria {

 private static final Logger logger = LoggerFactory.getLogger(RegistroCuentaBancaria.class);

 // Método para obtener el DNI del usuario por su ID
    public String obtenerDniUsuario(int userId) {
        String dni = null;
        Connection conn = null;
        try {
            // Obtener la conexión desde ConexionDB
            conn = ConexionDB.getConexion();
            if (conn == null) {
                logger.error("No se pudo establecer conexión con la base de datos.");
                JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos.");
                return null;
            }

            // Realizar la consulta para obtener el DNI del usuario
            String sql = "SELECT dni FROM usuario WHERE id_usuario = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                dni = rs.getString("dni");  // Obtener el DNI del usuario
            }

        } catch (Exception e) {
            logger.error("Error al obtener el DNI del usuario", e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                logger.error("Error al cerrar la conexión", e);
            }
        }

        return dni;
    }
    
    
   // Método para registrar la cuenta bancaria
    public boolean registrarCuenta(CuentaBancaria cuenta, int userId) {
        try {
            logger.info("Iniciando el registro de la cuenta: {}", cuenta.getNumeroTarjeta());

            // Obtener el DNI del usuario
            String dniUsuario = obtenerDniUsuario(userId);
            if (dniUsuario == null) {
                logger.error("No se pudo obtener el DNI del usuario con ID: {}", userId);
                JOptionPane.showMessageDialog(null, "No se pudo obtener el DNI del usuario.");
                return false;
            }

            // Obtener la conexión desde ConexionDB
            Connection conn = ConexionDB.getConexion();
            if (conn == null) {
                logger.error("No se pudo establecer conexión con la base de datos.");
                JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos.");
                return false;
            }

            // Verificar si la cuenta ya existe
            String checkSql = "SELECT COUNT(*) FROM cuenta_bancaria WHERE numero_cuenta = ?"; 
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, cuenta.getNumeroTarjeta());  // Asumiendo que "numero_tarjeta" se usa como "numero_cuenta"
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                logger.warn("La cuenta {} ya está registrada.", cuenta.getNumeroTarjeta());
                JOptionPane.showMessageDialog(null, "El número de cuenta ya está registrado.");
                conn.close();
                return false;
            }

            // Insertar la nueva cuenta, ahora con los campos correctos
            String sql = "INSERT INTO cuenta_bancaria (numero_cuenta, titular, banco, codigo_seguridad, fecha_vencimiento, id_usuario) "
                       + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cuenta.getNumeroTarjeta());  // Asumo que "numero_tarjeta" se usa como "numero_cuenta"
            stmt.setString(2, cuenta.getTitular());
            stmt.setString(3, cuenta.getBanco());
            stmt.setString(4, cuenta.getCodigoSeguridad());  // Aquí se pasa el código de seguridad generado
            stmt.setDate(5, new java.sql.Date(cuenta.getFechaVencimiento().getTime()));
            stmt.setInt(6, userId);  // Asociamos el id_usuario

            int rowsInserted = stmt.executeUpdate();
            conn.close();

            if (rowsInserted > 0) {
                logger.info("Cuenta registrada exitosamente: {}", cuenta.getNumeroTarjeta());
            } else {
                logger.error("No se pudo registrar la cuenta para la tarjeta: {}", cuenta.getNumeroTarjeta());
            }

            return rowsInserted > 0;
        } catch (Exception e) {
            logger.error("Error al registrar la cuenta bancaria", e);
            e.printStackTrace();
            return false;
        }
    }
}
