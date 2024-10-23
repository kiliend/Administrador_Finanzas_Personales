package RegistrarIngreso;

import java.time.LocalDate;

/**
 * Clase que representa un ingreso financiero.
 *
 * Esta clase encapsula la información sobre un ingreso, incluyendo su monto,
 * categoría y fecha. Proporciona métodos para acceder y modificar estos
 * valores.
 *
 * @author Rodney Piers Salazar Arapa
 */
public class Ingreso {

    private double monto;
    private String categoria;
    private LocalDate fecha;

    /**
     * Constructor para crear un nuevo ingreso.
     *
     * @param monto El monto del ingreso.
     * @param categoria La categoría del ingreso.
     * @param fecha La fecha en que se registró el ingreso.
     *
     * @author Rodney Piers Salazar Arapa
     *
     */
    public Ingreso(double monto, String categoria, LocalDate fecha) {
        this.monto = monto;
        this.categoria = categoria;
        this.fecha = fecha;
    }

    /**
     * Obtiene el monto del ingreso.
     *
     * @return el monto del ingreso.
     *
     * @author Rodney Piers Salazar Arapa
     *
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Establece el monto del ingreso.
     *
     * @param monto el nuevo monto del ingreso.
     *
     * @author Rodney Piers Salazar Arapa
     *
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * Obtiene la categoría del ingreso.
     *
     * @return la categoría del ingreso.
     *
     * @author Rodney Piers Salazar Arapa
     *
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría del ingreso.
     *
     * @param categoria la nueva categoría del ingreso.
     *
     * @author Rodney Piers Salazar Arapa
     *
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Obtiene la fecha del ingreso.
     *
     * @return la fecha del ingreso.
     *
     * @author Rodney Piers Salazar Arapa
     *
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del ingreso.
     *
     * @param fecha la nueva fecha del ingreso.
     *
     * @author Rodney Piers Salazar Arapa
     *
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}
