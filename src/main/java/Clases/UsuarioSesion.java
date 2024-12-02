/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

public class UsuarioSesion {

    private static String nombre;
    private static String dni;
    private static String correoElectronico;
    private static String telefono;
    private static int userId;

    public static void setUserId(int id) {
        userId = id;
    }

    public static int getUserId() {
        return userId;
    }
    private static String numeroCuenta;

    public static String getNumeroCuenta() {
        return numeroCuenta;
    }

    public static void setNumeroCuenta(String numeroCuenta) {
        UsuarioSesion.numeroCuenta = numeroCuenta;
    }
    public static void setNombre(String nombre) {
        UsuarioSesion.nombre = nombre;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setDni(String dni) {
        UsuarioSesion.dni = dni;
    }

    public static String getDni() {
        return dni;
    }

    public static void setCorreoElectronico(String correoElectronico) {
        UsuarioSesion.correoElectronico = correoElectronico;
    }

    public static String getCorreoElectronico() {
        return correoElectronico;
    }

    public static void setTelefono(String telefono) {
        UsuarioSesion.telefono = telefono;
    }

    public static String getTelefono() {
        return telefono;
    }
}
