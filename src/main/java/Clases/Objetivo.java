/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Luan Condori
 */
public class Objetivo {
    
    private int idObjetivo;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double cantidad;
    private int idUsuario;    

    public Objetivo(int idObjetivo, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, double cantidad, int idUsuario) {
        this.idObjetivo = idObjetivo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidad = cantidad;
        this.idUsuario = idUsuario;
    }
    // Constructor sin el idObjetivo (para cuando es autoincremental)
    public Objetivo(String descripcion, LocalDate fechaInicio, LocalDate fechaFin, double cantidad, int idUsuario) {
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidad = cantidad;
        this.idUsuario = idUsuario;
}


    public int getIdObjetivo() {
        return idObjetivo;
    }

    public void setIdObjetivo(int idObjetivo) {
        this.idObjetivo = idObjetivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}