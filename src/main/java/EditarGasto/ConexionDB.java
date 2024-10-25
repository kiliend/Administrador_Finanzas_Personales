package EditarGasto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConexionDB {

    private static final Logger logger = LoggerFactory.getLogger(ConexionDB.class);

    // Cambia estos valores según tu configuración
    private static final String URL_INGRESOS = "jdbc:mysql://localhost:3306/finanzas";
    private static final String URL_GASTOS = "jdbc:mysql://localhost:3306/gastos";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        return getConnection(URL_INGRESOS);
    }

    public static Connection getConnectionGastos() {
        return getConnection(URL_GASTOS);
    }

    private static Connection getConnection(String url) {
        try {
            return DriverManager.getConnection(url, USER, PASSWORD);
        } catch (SQLException e) {
            logger.error("Error al conectar a la base de datos: {}", e.getMessage());
            return null;
        }
    }
}
