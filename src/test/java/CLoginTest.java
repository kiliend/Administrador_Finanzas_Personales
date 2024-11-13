
import Clases.CLogin;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull; // Para verificar que no sea null
import static org.junit.jupiter.api.Assertions.assertNull;   // Para verificar que sea null

/**
 *
 * @author ANDREI KENDRICK YAIR BERNAOLA SANDOVAL
 */
public class CLoginTest {

    @Test
    public void testValidarUsuarioExitoso() {
        CLogin cLogin = new CLogin();

        // el usuario debe existir en la base de datos con la contraseña
        String usuario = "josen";
        String contrasena = "andrei";

        // Llamamos al método que devuelve el userId (dni)
        String userId = cLogin.validarUsuario(usuario, contrasena);

        // Verificamos que el userId no sea null si las credenciales son correctas
        assertNotNull(userId, "El inicio de sesión debería ser exitoso y devolver un ID de usuario");
    }

    @Test
    public void testValidarUsuarioIncorrecto() {
        CLogin cLogin = new CLogin();

        // Probar con un usuario y contraseña incorrectos
        String usuario = "josen";
        String contrasena = "wrongpassword";

        // Llamamos al método
        String userId = cLogin.validarUsuario(usuario, contrasena);

        // Verificamos que el userId sea null si las credenciales son incorrectas
        assertNull(userId, "El inicio de sesión debería fallar y no devolver un ID de usuario");
    }
}
