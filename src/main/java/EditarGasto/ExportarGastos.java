package EditarGasto;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * La clase {@code ExportarGastos} permite exportar una lista de gastos a un
 * archivo Excel (.xlsx) y crear una copia de respaldo de dicho archivo.
 * <p>
 * Utiliza Apache POI para la creación del archivo Excel y Apache Commons IO
 * para la copia del archivo.
 * </p>
 *
 * @author Rodney Piers Salazar Arapa
 *
 */
public class ExportarGastos {

    private static final Logger logger = LoggerFactory.getLogger(ExportarGastos.class);

    /**
     * Exporta una lista de gastos a un archivo Excel en el directorio
     * especificado. También realiza una copia de respaldo del archivo.
     *
     * @param gastos una lista de arrays de objetos, donde cada array representa
     * un gasto con los campos: ID (int), Monto (double), Categoría (String),
     * Fecha (String) y Descripción (String). La descripción puede ser
     * {@code null}.
     */
    public void exportarGastosAExcel(List<Object[]> gastos) {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Gastos");
            int rowCount = 0;

            // Encabezado
            Row headerRow = sheet.createRow(rowCount++);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Monto");
            headerRow.createCell(2).setCellValue("Categoría");
            headerRow.createCell(3).setCellValue("Fecha");
            headerRow.createCell(4).setCellValue("Descripción");

            // Añadir gastos
            for (Object[] gasto : gastos) {
                Row row = sheet.createRow(rowCount++);
                row.createCell(0).setCellValue((int) gasto[0]);
                row.createCell(1).setCellValue((double) gasto[1]);
                row.createCell(2).setCellValue((String) gasto[2]);
                row.createCell(3).setCellValue(gasto[3].toString());
                row.createCell(4).setCellValue(gasto[4] != null ? gasto[4].toString() : ""); // Manejar descripción
            }

            // Guardar archivo Excel
            String filePath = "D:\\Gastos.xlsx";
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
                logger.info("Archivo Excel creado exitosamente en: {}", filePath);
            }

            // Copiar archivo a otra ubicación (ejemplo de uso de Commons IO)
            File excelFile = new File(filePath);
            File backupFile = new File("D:\\Gastos_Backup.xlsx"); // Ruta de backup
            FileUtils.copyFile(excelFile, backupFile);
            logger.info("Archivo Excel copiado exitosamente a: {}", backupFile.getPath());

        } catch (IOException e) {
            logger.error("Error al exportar los gastos a Excel", e);
        }
    }
}
