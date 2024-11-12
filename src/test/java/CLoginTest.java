
import Clases.CLogin;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 *
 * @author ANDREI KENDRICK YAIR BERNAOLA SANDOVAL
 */
public class CLoginTest {
    

    @Test
    public void testValidarUsuarioExitoso() {
        CLogin cLogin = new CLogin();
        
        // el usuario deve existir en la base de datos con la contrasena
        String usuario = "josen";
        String contrasena = "andrei";
        
        boolean resultado = cLogin.validarUsuario(usuario, contrasena);
        assertTrue(resultado,"el inicio de sesion deberia ser exitoso");
    }
}
