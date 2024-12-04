/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.util.Date;

public class Gasto {
    private int idGasto;
    private double cantidad;
    private String descripcion;
    private Date fecha; // Asegúrate de que sea java.sql.Date
    private int idUsuario;
    private int idCategoria;

    // Constructor, getters y setters...

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    // Constructor
    public Gasto(int idGasto, double cantidad, String descripcion, Date fecha, int idUsuario, int idCategoria) {
        this.idGasto = idGasto;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
        this.idCategoria = idCategoria;
    }

    // Getters y Setters
    public int getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(int idGasto) {
        this.idGasto = idGasto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
}