/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import ClaseDAOImpl.CategoriaGastoDAOImpl;
import Clases.CategoriaGasto;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Luan Condori
 */
public class CategoriaGastoDAOImplTest {

    private Connection connection;
    private CategoriaGastoDAOImpl categoriaGastoDAO;
    
    @BeforeEach
    public void setUp() throws SQLException {
        // Configurar la conexión a la base de datos de prueba
        String url = "jdbc:mysql://localhost:3306/mi_base_de_datos"; // Cambia según tu configuración
        String usuario = "root"; // Cambia según tu configuración
        String contrasena = "mi_contrasena"; // Cambia según tu configuración
        connection = DriverManager.getConnection(url, usuario, contrasena);
        
        // Crear la instancia del DAO
        categoriaGastoDAO = new CategoriaGastoDAOImpl(connection);
    }

    @AfterEach
    public void tearDown() throws SQLException {
        // Limpiar la base de datos o cerrar la conexión después de cada prueba
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    public void testActualizarCategoriaGasto() throws SQLException {
        // Crear una categoría de gasto de prueba
        CategoriaGasto categoriaGasto = new CategoriaGasto(1, "Transporte", 150.0);
        categoriaGastoDAO.actualizar(categoriaGasto);

        // Obtener la categoría actualizada
        CategoriaGasto categoriaGastoObtenida = categoriaGastoDAO.obtenerPorId(1);
        
        // Verificar que los datos han sido actualizados correctamente
        assertNotNull(categoriaGastoObtenida);
        assertEquals("Transporte", categoriaGastoObtenida.getNombre());
        assertEquals(150.0, categoriaGastoObtenida.getAsignacion());
    }

    @Test
    public void testObtenerPorId() throws SQLException {
        // Crear y insertar una categoría de gasto
        CategoriaGasto categoriaGasto = new CategoriaGasto(1, "Alimentación", 200.0);
        categoriaGastoDAO.actualizar(categoriaGasto);  // Simulando inserción con el método actualizar

        // Obtener la categoría por ID
        CategoriaGasto categoriaObtenida = categoriaGastoDAO.obtenerPorId(1);

        // Verificar que la categoría fue obtenida correctamente
        assertNotNull(categoriaObtenida);
        assertEquals("Alimentación", categoriaObtenida.getNombre());
        assertEquals(200.0, categoriaObtenida.getAsignacion());
    }

    @Test
    public void testObtenerTodos() throws SQLException {
        // Insertar algunas categorías de prueba
        CategoriaGasto categoria1 = new CategoriaGasto(1, "Comida", 100.0);
        CategoriaGasto categoria2 = new CategoriaGasto(2, "Ropa", 50.0);
        categoriaGastoDAO.actualizar(categoria1); // O también puedes tener un método de inserción
        categoriaGastoDAO.actualizar(categoria2); // O crear uno para insertar categorías

        // Obtener todas las categorías
        List<CategoriaGasto> categorias = categoriaGastoDAO.obtenerTodos();

        // Verificar que se recuperaron las categorías insertadas
        assertTrue(categorias.size() > 0);
        boolean encontrado1 = false;
        boolean encontrado2 = false;

        for (CategoriaGasto categoria : categorias) {
            if (categoria.getNombre().equals("Comida")) {
                encontrado1 = true;
            }
            if (categoria.getNombre().equals("Ropa")) {
                encontrado2 = true;
            }
        }

        assertTrue(encontrado1);
        assertTrue(encontrado2);
    }

    @Test
    public void testUpdateCategoriaGasto() throws SQLException {
        // Crear una categoría de gasto de prueba
        CategoriaGasto categoriaGasto = new CategoriaGasto(3, "Varios", 250.0);
        categoriaGastoDAO.actualizar(categoriaGasto);

        // Actualizar la asignación
        categoriaGastoDAO.updateCategoriaGasto("Varios", 300.0);

        // Obtener la categoría actualizada
        CategoriaGasto categoriaActualizada = categoriaGastoDAO.obtenerPorId(3);

        // Verificar que la asignación se actualizó correctamente
        assertEquals(300.0, categoriaActualizada.getAsignacion());
    }
}
