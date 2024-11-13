package Clases;
/**
 *clase que representa a un usurio 
 *Proporciona métodos para acceder y modificar estos
 * valores.
 * @author ANDREI KENDRICK YAIR BERNAOLA SANDOVAL
 */

public class Usuario {

    private int idUsuario;
    private String nombre;
    private String apellidos;
    private String dni;
    private String telefono;
    private String correoElectronico;
    private String usuario;
    private String contrasena;

/**
 *
 *constructor para registrar un usuario
 * 
 * 
 * @param nombre nombre del usuario
 * @param apellidos apellidos del usuario 
 * @param dni DNI del usuario
 * @param telefono Telefono del usuario
 * @param correoElectronico Correo del usuario 
 * @param usuario Identificador del usurio 
 * @param contrasena Contraseña del usuario
 */
    public Usuario(String nombre, String apellidos, String dni, String telefono, 
            String correoElectronico, String usuario, String contrasena) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

        /**
     * obtiene el id del usuario
     * @return id del usuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }
    
    /**
     *obtiene el nombre del usuario 
     * 
     * @return nombre de usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * obtiene los apellidos del usuario
     * 
     * @return apellidos del usuario
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * obtiene el DNI del usuario
     * 
     * @return DNI del usuario
     */
    public String getDni() {
        return dni;
    }

    /**
     * obtiene el telefono del usuario
     * 
     * @return telefono del usuario
     * 
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * obtiene el correo del usuario
     * 
     * @return correo del usuario
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * obtiene el Usuario
     * 
     * @return Usuario 
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * obtiene la contrasena del usuario
     * 
     * @return contrasena del usuario
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * establece el id del usuaario 
     * @param idUsuario 
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    /**
     * establece el nombre del usuario
     * 
     * @param nombre nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * establece los apellidos del usuario
     * 
     * @param apellidos apellidos del usuario
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * establece el DNI del usuario
     * 
     * @param dni DNI del usuario
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * establece el telefono del usurio 
     * 
     * @param telefono 
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * establece el correo del usuario
     * 
     * @param correoElectronico correo del usuario
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * establece el Usuario
     * 
     * @param usuario 
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /** 
     * establece la contrasena del usurio
     * 
     * @param contrasena 
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
