package Clases;

import java.util.Date;

/**
 * Clase que representa un ingreso registrado por un usuario.
 * Esta clase se mapea a la tabla 'ingreso' en la base de datos.
 * 
 * Contiene la información sobre el ingreso, incluyendo la cantidad, 
 * la fecha, la descripción y el id del usuario asociado.
 * 
 * <p>Se utiliza para manejar los ingresos dentro del sistema, proporcionando
 * métodos para acceder y modificar los atributos de cada ingreso.</p>
 */
public class Ingreso {

    private int idIngreso;     // ID único del ingreso
    private double cantidad;   // Monto del ingreso
    private Date fecha;        // Fecha del ingreso
    private String descripcion; // Descripción del ingreso
    private int idUsuario;     // ID del usuario que registró el ingreso

    /**
     * Constructor vacío de la clase Ingreso.
     * Se utiliza para crear un objeto de ingreso sin inicializar los atributos.
     */
    public Ingreso() {}

    /**
     * Constructor con parámetros para crear un objeto Ingreso con valores específicos.
     * 
     * @param idIngreso    El ID único del ingreso.
     * @param cantidad     La cantidad de dinero registrada.
     * @param fecha        La fecha del ingreso.
     * @param descripcion  Una descripción del ingreso.
     * @param idUsuario    El ID del usuario que registró el ingreso.
     */
    public Ingreso(int idIngreso, double cantidad, Date fecha, String descripcion, int idUsuario) {
        this.idIngreso = idIngreso;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene el ID único del ingreso.
     * 
     * @return El ID del ingreso.
     */
    public int getIdIngreso() {
        return idIngreso;
    }

    /**
     * Establece el ID único del ingreso.
     * 
     * @param idIngreso El ID del ingreso.
     */
    public void setIdIngreso(int idIngreso) {
        this.idIngreso = idIngreso;
    }

    /**
     * Obtiene la cantidad del ingreso.
     * 
     * @return La cantidad del ingreso.
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad del ingreso.
     * 
     * @param cantidad La cantidad a registrar.
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene la fecha del ingreso.
     * 
     * @return La fecha en la que se registró el ingreso.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del ingreso.
     * 
     * @param fecha La fecha de registro del ingreso.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la descripción del ingreso.
     * 
     * @return Una breve descripción del ingreso.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del ingreso.
     * 
     * @param descripcion La descripción del ingreso.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el ID del usuario que registró el ingreso.
     * 
     * @return El ID del usuario.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el ID del usuario que registró el ingreso.
     * 
     * @param idUsuario El ID del usuario.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Método que genera una representación en forma de cadena de los datos
     * del ingreso. Se utiliza principalmente para propósitos de depuración
     * y visualización.
     * 
     * @return Un string que representa los datos del ingreso.
     */
    @Override
    public String toString() {
        return "Ingreso{" +
                "idIngreso=" + idIngreso +
                ", cantidad=" + cantidad +
                ", fecha=" + fecha +
                ", descripcion='" + descripcion + '\'' +
                ", idUsuario=" + idUsuario +
                '}';
    }
}
