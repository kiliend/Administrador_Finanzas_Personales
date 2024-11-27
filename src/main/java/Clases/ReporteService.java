/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.opencsv.CSVWriter;
import ConexionBD.ConexionDB;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.sql.*;
import java.util.Calendar;
public class ReporteService 
{

// Método para obtener los datos de la base de datos
public ResultSet obtenerDatos(String categoria, String tiempo) throws SQLException {
   
    // Obtener la conexión
    Connection conexion = ConexionDB.getConexion();

    // Validamos la categoría
    if (categoria == null || categoria.isEmpty()) {
        throw new SQLException("La categoría no puede ser nula o vacía.");
    }

    // Calculamos las fechas según el valor de 'tiempo'
    String fechaInicio = obtenerFechaInicio(tiempo);

    // Construimos la consulta con un rango de fechas
    String consulta = "SELECT * FROM " + categoria + " WHERE fecha >= ?";

    // Preparamos la consulta
    PreparedStatement statement = conexion.prepareStatement(consulta);
    statement.setString(1, fechaInicio); // Establecemos la fecha de inicio en la consulta

    return statement.executeQuery();
}

private String obtenerFechaInicio(String tiempo) {
    // Obtiene la fecha actual
    Calendar calendario = Calendar.getInstance();
    String fechaInicio = null;

    switch (tiempo.toLowerCase()) {
        case "dia":
            // Solo necesitamos la fecha de hoy
            fechaInicio = new java.text.SimpleDateFormat("yyyy-MM-dd").format(calendario.getTime());
            break;
        case "semana":
            // Restamos 7 días a la fecha de hoy
            calendario.add(Calendar.DAY_OF_MONTH, -7);
            fechaInicio = new java.text.SimpleDateFormat("yyyy-MM-dd").format(calendario.getTime());
            break;
        case "mes":
            // Restamos 1 mes a la fecha de hoy
            calendario.add(Calendar.MONTH, -1);
            fechaInicio = new java.text.SimpleDateFormat("yyyy-MM-dd").format(calendario.getTime());
            break;
         case "año":
            // Restamos 1 año a la fecha de hoy
            calendario.add(Calendar.YEAR, -1);
            fechaInicio = new java.text.SimpleDateFormat("yyyy-MM-dd").format(calendario.getTime());
            break;
        default:
            throw new IllegalArgumentException("Valor de tiempo no válido. Debe ser 'DIA', 'Semana' o 'Mes'.");
    }

    return fechaInicio;
}

 public void generarPDF(String categoria, String tiempo) throws Exception {
    // Obtener los datos de la base de datos
    ResultSet datos = null;
    try {
        datos = obtenerDatos(categoria, tiempo);
        Document documento = new Document();
        String archivoPDF = "reporte_" + categoria + "_" + tiempo + "_" + System.currentTimeMillis() + ".pdf";
        PdfWriter.getInstance(documento, new FileOutputStream(archivoPDF));
        documento.open();
        
        // Título principal del reporte
        documento.add(new Paragraph("Administrador de Finanzas - Reporte de " + categoria));
        documento.add(new Paragraph(" "));
        
        // Texto adicional con la fecha de creación
        String fechaHoy = new java.text.SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        documento.add(new Paragraph("Reporte realizado: " + fechaHoy));
        documento.add(new Paragraph(" "));
        
        // Texto con el rango de tiempo
        String fechaInicio = obtenerFechaInicio(tiempo); // Obtenemos la fecha inicial
        documento.add(new Paragraph("Rango de tiempo: " + tiempo.toUpperCase() + " (del " + fechaInicio + " al " + fechaHoy + ")"));
        documento.add(new Paragraph(" "));

        // Crear la tabla con los datos obtenidos
        PdfPTable tabla = new PdfPTable(datos.getMetaData().getColumnCount());
        
        // Encabezados de la tabla
        for (int i = 1; i <= datos.getMetaData().getColumnCount(); i++) {
            tabla.addCell(datos.getMetaData().getColumnName(i));
        }
        
        // Rellenar la tabla con los datos
        while (datos.next()) {
            for (int i = 1; i <= datos.getMetaData().getColumnCount(); i++) {
                tabla.addCell(datos.getString(i));
            }
        }
        
        documento.add(tabla);
        documento.close();
    } finally {
        // Cerrar los recursos de la base de datos
        if (datos != null) {
            datos.getStatement().getConnection().close();
        }
    }
}

    // Método para generar el reporte en formato CSV
    public void generarCSV(String categoria, String tiempo) throws Exception {
        // Obtener los datos de la base de datos
        ResultSet datos = null;
        CSVWriter writer = null;
        try {
            datos = obtenerDatos(categoria, tiempo);
            String archivoCSV = "reporte_" + categoria + "_" + tiempo + "_" + System.currentTimeMillis() + ".csv";
            writer = new CSVWriter(new FileWriter(archivoCSV));

            // Escribir encabezados
            String[] encabezados = new String[datos.getMetaData().getColumnCount()];
            for (int i = 1; i <= datos.getMetaData().getColumnCount(); i++) {
                encabezados[i - 1] = datos.getMetaData().getColumnName(i);
            }
            writer.writeNext(encabezados);

            // Escribir los datos
            while (datos.next()) {
                String[] fila = new String[datos.getMetaData().getColumnCount()];
                for (int i = 1; i <= datos.getMetaData().getColumnCount(); i++) {
                    fila[i - 1] = datos.getString(i);
                }
                writer.writeNext(fila);
            }
        } finally {
            // Cerrar los recursos
            if (writer != null) {
                writer.close();
            }
            if (datos != null) {
                datos.getStatement().getConnection().close();
            }
        }
    }
}
