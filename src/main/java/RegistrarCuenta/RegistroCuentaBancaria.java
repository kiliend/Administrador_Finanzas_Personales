package RegistrarCuenta;

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

    public boolean registrarCuenta(CuentaBancaria cuenta) {
        try {
            logger.info("Iniciando el registro de la cuenta: {}", cuenta.getNumeroTarjeta());

            // Conexión a la base de datos
            RegistrarCuentaConexionDB conexion = new RegistrarCuentaConexionDB();
            Connection conn = conexion.getConnection();

            // Verificar si la tarjeta ya existe
            String checkSql = "SELECT COUNT(*) FROM cuentas_bancarias WHERE numero_tarjeta = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, cuenta.getNumeroTarjeta());
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                logger.warn("La tarjeta {} ya está registrada.", cuenta.getNumeroTarjeta());
                JOptionPane.showMessageDialog(null, "El número de tarjeta ya está registrado.");
                conn.close();
                return false;
            }

            // Insertar la nueva cuenta
            String sql = "INSERT INTO cuentas_bancarias (titular, dni, numero_tarjeta, banco, fecha_vencimiento) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cuenta.getTitular());
            stmt.setString(2, cuenta.getDni());
            stmt.setString(3, cuenta.getNumeroTarjeta());
            stmt.setString(4, cuenta.getBanco());
            stmt.setDate(5, new java.sql.Date(cuenta.getFechaVencimiento().getTime()));

            int rowsInserted = stmt.executeUpdate();
            conn.close();

            if (rowsInserted > 0) {
                logger.info("Cuenta registrada exitosamente {}", cuenta.getNumeroTarjeta());
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
