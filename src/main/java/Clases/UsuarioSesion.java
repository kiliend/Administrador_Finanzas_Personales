/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

public class UsuarioSesion {

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
}
