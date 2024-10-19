/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.administrador_finanzas_personales;
import JFrames.FormLogin;
/**
 *
 * @author Luan Condori
 */
public class Administrador_Finanzas_Personales {

    public static void main(String[] args) {
         // Crea una instancia de la ventana de login
        FormLogin login = new FormLogin();
        
        // Configurar que se vea centrada en la pantalla
        login.setLocationRelativeTo(null);
        
        // Hacer visible la ventana de login
        login.setVisible(true);
    }
}
