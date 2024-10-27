package RegistrarIngreso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import java.io.FileOutputStream;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils; // Importar Commons IO
import java.io.File; // Asegúrate de importar File si no está importado

/**
 * Clase que gestiona las operaciones relacionadas con los ingresos financieros.
 *
 * Esta clase permite registrar nuevos ingresos en la base de datos y mostrar
 * los ingresos existentes.
 *
 * @author Rodney Piers Salazar Arapa
 *
 */
public class GestorFinanzas {

    private static final Logger logger = LoggerFactory.getLogger(GestorFinanzas.class);

    /**
     * Registra un nuevo ingreso en la base de datos.
     *
     * @param monto El monto del ingreso a registrar.
     * @param categoria La categoría del ingreso.
     * @param fecha La fecha del ingreso.
     *
     *
     */
    // Método para registrar el ingreso en la base de datos
    public void registrarIngreso(double monto, String categoria, LocalDate fecha) {
        String sql = "INSERT INTO ingresos (monto, categoria, fecha) VALUES (?, ?, ?)";

        try (Connection conn = IngresoConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, monto);
            pstmt.setString(2, categoria);
            pstmt.setDate(3, java.sql.Date.valueOf(fecha));

            pstmt.executeUpdate();
            logger.info("Ingreso registrado en la base de datos: Monto = {}, Categoria = {}, Fecha = {}", monto, categoria, fecha);
        } catch (SQLException e) {
            logger.error("Error al registrar ingreso: {}", e.getMessage());
        }
    }

    /**
     * Obtiene todos los ingresos registrados en la base de datos.
     *
     * @return Una lista de objetos que representan los ingresos, donde cada
     * objeto es un arreglo que contiene el ID, monto, categoría y fecha.
     *
     *
     */
    public List<Object[]> obtenerIngresos() {
        List<Object[]> ingresos = Lists.newArrayList();
        String sql = "SELECT * FROM ingresos";

        try (Connection conn = IngresoConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            logger.info("Conexión establecida con la base de datos para obtener ingresos.");

            while (rs.next()) {
                int id = rs.getInt("id");
                double monto = rs.getDouble("monto");
                String categoria = rs.getString("categoria");
                LocalDate fecha = rs.getDate("fecha").toLocalDate();
                ingresos.add(new Object[]{id, monto, categoria, fecha});
            }

            logger.info("Ingresos obtenidos de la base de datos. Total de registros: {}", ingresos.size());

        } catch (SQLException e) {
            logger.error("Error al obtener ingresos: {}", e.getMessage(), e);
        }

        return ingresos;
    }

    /**
     * Actualiza un ingreso existente en la base de datos.
     *
     * @param id El ID del ingreso a actualizar.
     * @param nuevoMonto El nuevo monto del ingreso.
     * @param nuevaCategoria La nueva categoría del ingreso.
     * @param nuevaFecha La nueva fecha del ingreso.
     *
     *
     */
    public void actualizarIngreso(int id, double nuevoMonto, String nuevaCategoria, LocalDate nuevaFecha) {
        String sql = "UPDATE ingresos SET monto = ?, categoria = ?, fecha = ? WHERE id = ?";

        try (Connection conn = IngresoConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, nuevoMonto);
            pstmt.setString(2, nuevaCategoria);
            pstmt.setDate(3, java.sql.Date.valueOf(nuevaFecha));
            pstmt.setInt(4, id);

            int filasActualizadas = pstmt.executeUpdate();
            if (filasActualizadas > 0) {
                logger.info("Ingreso con ID {} actualizado correctamente. Nuevo monto = {}, Nueva categoría = {}, Nueva fecha = {}", id, nuevoMonto, nuevaCategoria, nuevaFecha);
            } else {
                logger.warn("No se encontró el ingreso con el ID proporcionado: {}", id);
            }

        } catch (SQLException e) {
            logger.error("Error al actualizar el ingreso con ID {}: {}", id, e.getMessage(), e);
        }
    }

    /**
     * Elimina un ingreso de la base de datos.
     *
     * @param id El ID del ingreso a eliminar.
     *
     *
     */
    public void eliminarIngreso(int id) {
        String sql = "DELETE FROM ingresos WHERE id = ?";

        try (Connection conn = IngresoConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int filasEliminadas = pstmt.executeUpdate();
            if (filasEliminadas > 0) {
                logger.info("Ingreso con ID {} eliminado de la base de datos.", id);
            } else {
                logger.warn("No se encontró el ingreso con ID {} para eliminar.", id);
            }
        } catch (SQLException e) {
            logger.error("Error al eliminar el ingreso con ID {}: {}", id, e.getMessage(), e);
        }
    }

    /**
     * Exporta una lista de ingresos a un archivo Excel.
     *
     * @param ingresos La lista de ingresos a exportar, donde cada ingreso es un
     * arreglo de objetos que contiene el ID, monto, categoría y fecha.
     *
     *
     */
    public void exportarIngresosAExcel(List<Object[]> ingresos) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Ingresos");
            int rowCount = 0;

            // Encabezado
            Row headerRow = sheet.createRow(rowCount++);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Monto");
            headerRow.createCell(2).setCellValue("Categoría");
            headerRow.createCell(3).setCellValue("Fecha");

            // Añadir ingresos
            for (Object[] ingreso : ingresos) {
                Row row = sheet.createRow(rowCount++);
                row.createCell(0).setCellValue((int) ingreso[0]);
                row.createCell(1).setCellValue((double) ingreso[1]);
                row.createCell(2).setCellValue((String) ingreso[2]);
                row.createCell(3).setCellValue(ingreso[3].toString());
            }

            // Guardar archivo Excel
            String filePath = "D:\\Ingresos.xlsx";
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
                logger.info("Archivo Excel creado exitosamente en: {}", filePath);
            }

            // Copiar archivo a otra ubicación (ejemplo de uso de Commons IO)
            File excelFile = new File(filePath);
            File backupFile = new File("D:\\Ingresos_Backup.xlsx"); // Ruta de backup
            FileUtils.copyFile(excelFile, backupFile);
            logger.info("Archivo Excel copiado exitosamente a: {}", backupFile.getPath());

        } catch (IOException e) {
            logger.error("Error al exportar los ingresos a Excel", e);
        }
    }

    /**
     * Exporta los ingresos obtenidos de la base de datos a un archivo Excel.
     * Este método orquesta la obtención de ingresos y llama a
     * {@link #exportarIngresosAExcel(List<Object[]>)} para realizar la
     * exportación.
     *
     *
     */
    public void exportarIngresos() {
        List<Object[]> ingresos = obtenerIngresos(); // Obtener los ingresos de la base de datos
        exportarIngresosAExcel(ingresos); // Llamar al método para exportar a Excel
    }

    /**
     * Nos permite verificar si se está ejecutando satisfactoriamente el Google
     * Guava
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        GestorFinanzas gestorFinanzas = new GestorFinanzas();
        List<Object[]> ingresos = gestorFinanzas.obtenerIngresos();

        for (Object[] ingreso : ingresos) {
            System.out.println("ID: " + ingreso[0] + ", Monto: " + ingreso[1] + ", Categoria: " + ingreso[2] + ", Fecha: " + ingreso[3]);
        }
    }

}
