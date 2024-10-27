/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Luan Condori
 */
public class CategoriaGasto 
{
    private int idCategoria;
    private String nombre;
    private double asignacion;

    public CategoriaGasto(int idCategoria, String nombre, double asignacion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.asignacion = asignacion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(double asignacion) {
        this.asignacion = asignacion;
    }
    
}
