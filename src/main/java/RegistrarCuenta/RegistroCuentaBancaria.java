/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RegistrarCuenta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author familia4
 */
public class RegistroCuentaBancaria {

    public boolean registrarCuenta(CuentaBancaria cuenta) {
        try {
            // Conexión a la base de datos
            ConexionDB conexion = new ConexionDB();
            Connection conn = conexion.getConnection();

            // Verificar si la tarjeta ya existe
            String checkSql = "SELECT COUNT(*) FROM cuentas_bancarias WHERE numero_tarjeta = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, cuenta.getNumeroTarjeta());
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
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
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
