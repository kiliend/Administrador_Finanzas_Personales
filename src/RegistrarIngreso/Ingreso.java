/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RegistrarIngreso;

import java.time.LocalDate;

/**
 *
 * @author familia4
 */
public class Ingreso {

    private double monto;
    private String categoria;
    private LocalDate fecha;

    public Ingreso(double monto, String categoria, LocalDate fecha) {
        this.monto = monto;
        this.categoria = categoria;
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}
