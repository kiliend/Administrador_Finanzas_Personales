package RegistrarIngreso;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

class GestorFinanzasTest {

    private static GestorFinanzas gestorFinanzas;

    @BeforeAll
    static void setup() {
        // Inicializar el gestor
        gestorFinanzas = new GestorFinanzas();
    }

    //@BeforeEach
   // void limpiarBaseDeDatosAntesDeCadaPrueba() {
        // Limpia la base de datos eliminando todos los ingresos antes de cada prueba
    //    gestorFinanzas.eliminarTodosLosIngresos();
   // }

    @Test
    @DisplayName("Obtener todos los ingresos registrados en la base de datos")
            //Test para Registrar Ingresos
    void testObtenerIngresos() {
        // Registrar ingresos de prueba
        gestorFinanzas.registrarIngreso(1000.0, "Sueldo", LocalDate.of(2024, 12, 1));
        gestorFinanzas.registrarIngreso(500.0, "Venta", LocalDate.of(2024, 12, 10));
        gestorFinanzas.registrarIngreso(1400.0, "Ahorro", LocalDate.of(2024, 12, 25));

        // //Test para Obtener Ingresos
        List<Object[]> ingresos = gestorFinanzas.obtenerIngresos();

        // Validar que la lista no está vacía
        assertFalse(ingresos.isEmpty(), "La lista de ingresos está vacía.");

        // Validar que la cantidad de ingresos es la esperada
        assertEquals(3, ingresos.size(), "El número de ingresos no coincide con lo esperado.");

        // Validar cada ingreso
        Object[] ingreso1 = ingresos.get(0);
        assertAll("Primer ingreso",
            () -> assertEquals(1000.0, (double) ingreso1[1], 0.01, "El monto del primer ingreso no coincide."),
            () -> assertEquals("Sueldo", (String) ingreso1[2], "La categoría del primer ingreso no coincide."),
            () -> assertEquals(LocalDate.of(2024, 12, 1), ingreso1[3], "La fecha del primer ingreso no coincide.")
        );

        Object[] ingreso2 = ingresos.get(1);
        assertAll("Segundo ingreso",
            () -> assertEquals(500.0, (double) ingreso2[1], 0.01, "El monto del segundo ingreso no coincide."),
            () -> assertEquals("Venta", (String) ingreso2[2], "La categoría del segundo ingreso no coincide."),
            () -> assertEquals(LocalDate.of(2024, 12, 10), ingreso2[3], "La fecha del segundo ingreso no coincide.")
        );

        Object[] ingreso3 = ingresos.get(2);
        assertAll("Tercer ingreso",
            () -> assertEquals(1400.0, (double) ingreso3[1], 0.01, "El monto del tercer ingreso no coincide."),
            () -> assertEquals("Ahorro", (String) ingreso3[2], "La categoría del tercer ingreso no coincide."),
            () -> assertEquals(LocalDate.of(2024, 12, 25), ingreso3[3], "La fecha del tercer ingreso no coincide.")
        );
    }
    
}
