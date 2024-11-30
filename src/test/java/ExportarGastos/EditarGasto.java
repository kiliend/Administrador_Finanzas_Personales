/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EditarGasto;

import org.junit.jupiter.api.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ExportarGastosTest {

    private static final String FILE_PATH = "D:\\Gastos.xlsx";
    private static final String BACKUP_FILE_PATH = "D:\\Gastos_Backup.xlsx";

    @BeforeEach
    void limpiarArchivosPrevios() {
        // Eliminar archivos existentes antes de cada prueba
        try {
            Files.deleteIfExists(Paths.get(FILE_PATH));
            Files.deleteIfExists(Paths.get(BACKUP_FILE_PATH));
        } catch (Exception e) {
            System.err.println("No se pudieron eliminar los archivos previos: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Prueba de exportación de gastos a Excel")
    void testExportarGastosAExcel() {
        ExportarGastos exportarGastos = new ExportarGastos();

        // Crear lista de gastos simulada
        List<Object[]> gastosSimulados = Arrays.asList(
            new Object[]{1, 100.0, "Alimentos", "2024-12-01", "Compra de frutas"},
            new Object[]{2, 50.0, "Transporte", "2024-12-02", "Taxi"},
            new Object[]{3, 200.0, "Entretenimiento", "2024-12-03", null}
        );

        // Exportar gastos a Excel
        exportarGastos.exportarGastosAExcel(gastosSimulados);

        // Verificar que los archivos existen
        File excelFile = new File(FILE_PATH);
        File backupFile = new File(BACKUP_FILE_PATH);
        assertTrue(excelFile.exists(), "El archivo principal no fue creado.");
        assertTrue(backupFile.exists(), "El archivo de respaldo no fue creado.");

        // Validar tamaño del archivo para confirmar que no está vacío
        assertTrue(excelFile.length() > 0, "El archivo principal está vacío.");
        assertTrue(backupFile.length() > 0, "El archivo de respaldo está vacío.");

        // Aquí podrías incluir validaciones más específicas para el contenido del archivo usando Apache POI.
    }
}

