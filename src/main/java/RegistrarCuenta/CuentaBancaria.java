package RegistrarCuenta;

import java.util.Date;
/**
 *
 * @author Rodney Piers Salazar Arapa
 */
public class CuentaBancaria {

    private String titular;
    private String dni;
    private String numeroTarjeta;
    private String banco;
    private java.util.Date fechaVencimiento;
    private String codigoSeguridad;  // Nuevo campo

    // Constructor sin parámetros
    public CuentaBancaria() {
        // Inicialización predeterminada (puedes dejarla vacía o con valores por defecto si lo prefieres)
    }

    // Constructor con parámetros (ya existente)
    public CuentaBancaria(String titular, String dni, String numeroTarjeta, String banco, java.util.Date fechaVencimiento) {
        this.titular = titular;
        this.dni = dni;
        this.numeroTarjeta = numeroTarjeta;
        this.banco = banco;
        this.fechaVencimiento = fechaVencimiento;
    }

        // Método para generar el código de seguridad (los primeros tres dígitos de numeroTarjeta)
    private String generarCodigoSeguridad(String numeroTarjeta) {
        if (numeroTarjeta != null && numeroTarjeta.length() >= 3) {
            return numeroTarjeta.substring(0, 3);  // Extraemos los primeros tres caracteres
        } else {
            return "000";  // En caso de que el número de tarjeta sea más corto de lo esperado
        }
    }
        // Getters y setters...
    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
