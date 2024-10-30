
import Clases.RegistroUsuario;
import Clases.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ANDREI KENDRICK YAIR BERNAOLA SANDOVAL
 */
public class RegistroUsuarioTest {
    
    @Test
    public void testRegistrarUsuarioExitoso() {
        RegistroUsuario registroUsuario = new RegistroUsuario();
        
        // Crear un usuario de prueba
        Usuario usuario = new Usuario("Pedro", "Dias", "907584367", "903674583",
                "Pedro.Dias@example.com", "PedroDias", "Pedro");

        //registrar el usuario
        boolean resultado = registroUsuario.registrarUsuario(usuario);
        assertTrue(resultado,"el registro de usuario deberia ser exitoso");
    }
    
}
