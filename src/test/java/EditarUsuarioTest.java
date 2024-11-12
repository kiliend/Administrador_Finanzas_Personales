
import Clases.RegistroUsuario;
import Clases.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ANDREI KENDRICK YAIR BERNAOLA SANDOVAL
 */
public class EditarUsuarioTest {
    
    @Test
    public void testEditarUsuarioExitoso() {
        RegistroUsuario registroUsuario = new RegistroUsuario();
        
        // Crear un usuario de prueba para editar
        Usuario usuarioOriginal = new Usuario("Pedro", "Dias", "907584367", 
                "903674583", "Pedro.Dias@example.com", "PedroDias",
                "Pedro");
        registroUsuario.registrarUsuario(usuarioOriginal); // Asegurarse de que el usuario está registrado
        
        // Crear un nuevo usuario con los datos actualizados
        Usuario usuarioEditado = new Usuario("Pedro", "Dias", "907584367", 
                "912345678", "Pedro.Nuevo@example.com", "PedroNuevo", 
                "NuevaContrasena");

        // Intentar editar el usuario
        boolean resultado = registroUsuario.editarUsuario(usuarioEditado);
        assertTrue(resultado, "el usuario deberia ser editado exitosamente");
    }
}
