/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.opencsv.CSVWriter;
import ConexionBD.ConexionDB;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
public class ReporteService 
{

    // Método para obtener los datos de la base de datos
    public ResultSet obtenerDatos(String categoria, String tiempo) throws SQLException {
        Connection conexion = ConexionDB.getConexion();
        String consulta = "SELECT * FROM tu_tabla WHERE categoria = ? AND tiempo = ?";
        PreparedStatement statement = conexion.prepareStatement(consulta);
        statement.setString(1, categoria);
        statement.setString(2, tiempo);
        return statement.executeQuery();
    }

    // Método para generar el reporte en formato PDF
    public void generarPDF(String categoria, String tiempo) throws Exception {
        ResultSet datos = obtenerDatos(categoria, tiempo);
        Document documento = new Document();
        PdfWriter.getInstance(documento, new FileOutputStream("reporte_" + categoria + "_" + tiempo + ".pdf"));
        documento.open();
        documento.add(new Paragraph("Reporte de " + categoria + " - " + tiempo));
        documento.add(new Paragraph(" "));

        PdfPTable tabla = new PdfPTable(datos.getMetaData().getColumnCount());
        for (int i = 1; i <= datos.getMetaData().getColumnCount(); i++) {
            tabla.addCell(datos.getMetaData().getColumnName(i));
        }
        while (datos.next()) {
            for (int i = 1; i <= datos.getMetaData().getColumnCount(); i++) {
                tabla.addCell(datos.getString(i));
            }
        }
        documento.add(tabla);
        documento.close();
        datos.getStatement().getConnection().close();
    }

    // Método para generar el reporte en formato CSV
    public void generarCSV(String categoria, String tiempo) throws Exception {
        ResultSet datos = obtenerDatos(categoria, tiempo);
        CSVWriter writer = new CSVWriter(new FileWriter("reporte_" + categoria + "_" + tiempo + ".csv"));

        String[] encabezados = new String[datos.getMetaData().getColumnCount()];
        for (int i = 1; i <= datos.getMetaData().getColumnCount(); i++) {
            encabezados[i - 1] = datos.getMetaData().getColumnName(i);
        }
        writer.writeNext(encabezados);

        while (datos.next()) {
            String[] fila = new String[datos.getMetaData().getColumnCount()];
            for (int i = 1; i <= datos.getMetaData().getColumnCount(); i++) {
                fila[i - 1] = datos.getString(i);
            }
            writer.writeNext(fila);
        }
        writer.close();
        datos.getStatement().getConnection().close();
    } 
}
