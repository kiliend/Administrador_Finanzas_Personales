import ClaseDAOImpl.ObjetivoDAOImpl;
import Clases.Objetivo;
import ConexionBD.ConexionDB;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Luan Condori
 */
public class ObjetivoDAOImplTest {

    private Connection conexion;
    private ObjetivoDAOImpl objetivoDAO;

    @BeforeEach
    public void setUp() {
        // Aquí puedes usar una conexión a una base de datos en memoria como H2
        conexion = ConexionDB.getConexion(); // Asegúrate de tener un método que devuelva la conexión a la BD de prueba
        objetivoDAO = new ObjetivoDAOImpl(conexion);
    }

    @AfterEach
    public void tearDown() {
        // Liberar recursos después de cada prueba, como cerrar la conexión
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsertar() {
        Objetivo objetivo = new Objetivo(0, "Objetivo de prueba", LocalDate.now(), LocalDate.now().plusMonths(1), 1000.0, 1);

        // Insertar objetivo
        objetivoDAO.insertar(objetivo);

        // Verificar que el objetivo fue insertado correctamente
        Objetivo objetivoInsertado = objetivoDAO.obtenerPorId(1); // Asumiendo que se asigna ID 1
        assertNotNull(objetivoInsertado, "El objetivo debe ser insertado correctamente.");
        assertEquals("Objetivo de prueba", objetivoInsertado.getDescripcion(), "La descripción debe coincidir.");
    }

    @Test
    public void testActualizar() {
        // Insertar un objetivo primero
        Objetivo objetivo = new Objetivo(0, "Objetivo original", LocalDate.now(), LocalDate.now().plusMonths(1), 500.0, 1);
        objetivoDAO.insertar(objetivo);

        // Obtener y actualizar el objetivo
        Objetivo objetivoActualizado = new Objetivo(1, "Objetivo actualizado", LocalDate.now(), LocalDate.now().plusMonths(2), 1500.0, 1);
        objetivoDAO.actualizar(objetivoActualizado);

        // Verificar que el objetivo fue actualizado
        Objetivo objetivoRecuperado = objetivoDAO.obtenerPorId(1);
        assertNotNull(objetivoRecuperado, "El objetivo debe existir.");
        assertEquals("Objetivo actualizado", objetivoRecuperado.getDescripcion(), "La descripción debe ser actualizada.");
        assertEquals(1500.0, objetivoRecuperado.getCantidad(), "La cantidad debe ser actualizada.");
    }

    @Test
    public void testEliminar() {
        // Insertar un objetivo para luego eliminarlo
        Objetivo objetivo = new Objetivo(0, "Objetivo para eliminar", LocalDate.now(), LocalDate.now().plusMonths(1), 2000.0, 1);
        objetivoDAO.insertar(objetivo);

        // Eliminar el objetivo
        objetivoDAO.eliminar(1);

        // Verificar que el objetivo fue eliminado
        Objetivo objetivoEliminado = objetivoDAO.obtenerPorId(1);
        assertNull(objetivoEliminado, "El objetivo debe ser eliminado.");
    }

    @Test
    public void testObtenerPorId() {
        // Insertar un objetivo
        Objetivo objetivo = new Objetivo(0, "Objetivo de prueba", LocalDate.now(), LocalDate.now().plusMonths(1), 1000.0, 1);
        objetivoDAO.insertar(objetivo);

        // Obtener el objetivo por ID
        Objetivo objetivoRecuperado = objetivoDAO.obtenerPorId(1);
        assertNotNull(objetivoRecuperado, "El objetivo debe ser recuperado.");
        assertEquals("Objetivo de prueba", objetivoRecuperado.getDescripcion(), "La descripción debe coincidir.");
    }
}
