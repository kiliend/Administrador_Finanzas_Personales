package EditarGasto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * La clase {@code ConexionDB} se encarga de gestionar las conexiones a las
 * bases de datos para la gestión de ingresos y gastos. Utiliza JDBC para
 * conectarse a las bases de datos MySQL y SLF4J para el manejo de logs.
 * <p>
 * Las conexiones se obtienen a partir de las URLs definidas en las constantes
 * {@code URL_INGRESOS} y {@code URL_GASTOS}.
 * </p>
 * <p>
 * Nota: Cambia los valores de las constantes {@code URL_INGRESOS},
 * {@code URL_GASTOS}, {@code USER}, y {@code PASSWORD} según la configuración
 * de tu base de datos.
 * </p>
 *
 * @author Rodney Piers Salazar Arapa
 *
 */
public class GastosConexionDB {

    private static final Logger logger = LoggerFactory.getLogger(GastosConexionDB.class);

    // Cambia estos valores según tu configuración
    private static final String URL_INGRESOS = "jdbc:mysql://localhost:3306/finanzas";
    private static final String URL_GASTOS = "jdbc:mysql://localhost:3306/gastos";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    /**
     * Obtiene una conexión a la base de datos de ingresos.
     *
     * @return un objeto {@code Connection} si la conexión fue exitosa;
     * {@code null} si ocurre un error.
     */
    public static Connection getConnection() {
        return getConnection(URL_INGRESOS);
    }

    /**
     * Obtiene una conexión a la base de datos de gastos.
     *
     * @return un objeto {@code Connection} si la conexión fue exitosa;
     * {@code null} si ocurre un error.
     */
    public static Connection getConnectionGastos() {
        return getConnection(URL_GASTOS);
    }

    /**
     * Establece una conexión a la base de datos especificada por la URL.
     *
     * @param url la URL de la base de datos a la que se desea conectar.
     * @return un objeto {@code Connection} si la conexión fue exitosa;
     * {@code null} si ocurre un error.
     */
    private static Connection getConnection(String url) {
        try {
            return DriverManager.getConnection(url, USER, PASSWORD);
        } catch (SQLException e) {
            logger.error("Error al conectar a la base de datos: {}", e.getMessage());
            return null;
        }
    }
}
