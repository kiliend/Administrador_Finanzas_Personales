package RegistrarCuenta;

import java.util.Date;

public class CuentaBancaria {

    private String titular;
    private String dni;
    private String numeroTarjeta;
    private String banco;
    private java.util.Date fechaVencimiento;

    public CuentaBancaria(String titular, String dni, String numeroTarjeta, String banco, java.util.Date fechaVencimiento) {
        this.titular = titular;
        this.dni = dni;
        this.numeroTarjeta = numeroTarjeta;
        this.banco = banco;
        this.fechaVencimiento = fechaVencimiento;
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
