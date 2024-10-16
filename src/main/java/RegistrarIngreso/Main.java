/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package RegistrarIngreso;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GestorFinanzas gestor = new GestorFinanzas(); // Crear una instancia de GestorFinanzas
        Scanner scanner = new Scanner(System.in); // Para leer entradas del usuario

        // Opción para registrar un ingreso
        System.out.println("Registrar un nuevo ingreso:");
        System.out.print("Monto: ");
        double monto = scanner.nextDouble(); // Leer monto
        scanner.nextLine(); // Limpiar el buffer de entrada
        System.out.print("Categoría: ");
        String categoria = scanner.nextLine(); // Leer categoría
        System.out.print("Fecha (YYYY-MM-DD): ");
        String fechaStr = scanner.nextLine(); // Leer fecha como string
        LocalDate fecha = LocalDate.parse(fechaStr); // Convertir el string a LocalDate

        // Registrar el ingreso en la base de datos
        gestor.registrarIngreso(monto, categoria, fecha);

        // Opción para mostrar todos los ingresos
        System.out.println("\nLista de ingresos:");
        gestor.mostrarIngresos();

        scanner.close(); // Cerrar el scanner
    }
}
