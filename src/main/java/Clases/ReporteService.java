package Clases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

public class ReporteService {

    // Crear el logger
    private static final Logger logger = LoggerFactory.getLogger(ReporteService.class);

    // Método para obtener los datos de la base de datos
    public ResultSet obtenerDatos(String categoria, String tiempo) throws SQLException {
        // Loguear inicio del proceso
        logger.info("Iniciando obtención de datos para la categoría: " + categoria + " con tiempo: " + tiempo);

        // Obtener la conexión
        Connection conexion = ConexionDB.getConexion();

        // Validamos la categoría
        if (categoria == null || categoria.isEmpty()) {
            logger.error("La categoría no puede ser nula o vacía.");
            throw new SQLException("La categoría no puede ser nula o vacía.");
        }

        // Calculamos las fechas según el valor de 'tiempo'
        String fechaInicio = obtenerFechaInicio(tiempo);

        // Construimos la consulta con un rango de fechas
        String consulta = "SELECT * FROM " + categoria + " WHERE fecha >= ?";

        // Preparamos la consulta
        PreparedStatement statement = conexion.prepareStatement(consulta);
        statement.setString(1, fechaInicio); // Establecemos la fecha de inicio en la consulta

        // Loguear ejecución exitosa de la consulta
        logger.info("Consulta ejecutada exitosamente.");
        
        return statement.executeQuery();
    }

    private String obtenerFechaInicio(String tiempo) {
        // Loguear el inicio del cálculo de fecha
        logger.debug("Calculando fecha de inicio para el tiempo: " + tiempo);

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
                logger.error("Valor de tiempo no válido: " + tiempo);
                throw new IllegalArgumentException("Valor de tiempo no válido. Debe ser 'DIA', 'Semana' o 'Mes'.");
        }

        // Loguear fecha calculada
        logger.debug("Fecha de inicio calculada: " + fechaInicio);
        return fechaInicio;
    }

    // Método para generar el reporte en formato PDF
    public void generarPDF(String categoria, String tiempo) throws Exception {
        // Loguear inicio de la generación del PDF
        logger.info("Generando reporte en PDF para la categoría: " + categoria);

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

            // Loguear éxito
            logger.info("Reporte PDF generado exitosamente: " + archivoPDF);
        } catch (Exception e) {
            // Loguear el error
            logger.error("Error generando el reporte PDF", e);
        } finally {
            // Cerrar los recursos de la base de datos
            if (datos != null) {
                datos.getStatement().getConnection().close();
            }
        }
    }

    // Método para generar el reporte en formato CSV
    public void generarCSV(String categoria, String tiempo) throws Exception {
        // Loguear inicio de la generación del CSV
        logger.info("Generando reporte en CSV para la categoría: " + categoria);

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

            // Loguear éxito
            logger.info("Reporte CSV generado exitosamente: " + archivoCSV);
        } catch (Exception e) {
            // Loguear el error
            logger.error("Error generando el reporte CSV", e);
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
