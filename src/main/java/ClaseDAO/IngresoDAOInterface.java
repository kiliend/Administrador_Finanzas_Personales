/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ClaseDAO;

import Clases.Ingreso;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Luan Condori
 */
public interface IngresoDAOInterface {
    
    /**
     * Método para agregar un ingreso a la base de datos.
     * 
     * @param ingreso El objeto Ingreso que contiene los datos a agregar.
     * @throws SQLException Si ocurre un error en la consulta.
     */
    void agregarIngreso(Ingreso ingreso) throws SQLException;

    /**
     * Método para obtener todos los ingresos de un usuario, ordenados por el ID del usuario.
     * 
     * @param idUsuario El ID del usuario para filtrar los ingresos.
     * @return Lista de objetos Ingreso con los datos de los ingresos.
     * @throws SQLException Si ocurre un error en la consulta.
     */
    List<Ingreso> obtenerIngresosPorUsuario(int idUsuario) throws SQLException;

    /**
     * Método para obtener el último ingreso registrado por un usuario.
     * 
     * @param idUsuario El ID del usuario.
     * @return El último objeto Ingreso registrado.
     * @throws SQLException Si ocurre un error en la consulta.
     */
    Ingreso obtenerUltimoIngreso(int idUsuario) throws SQLException;

    /**
     * Método para obtener el ingreso más alto registrado por un usuario en un mes.
     * 
     * @param idUsuario El ID del usuario.
     * @param mes El mes en el cual se quiere consultar el ingreso más alto.
     * @return El objeto Ingreso con el ingreso más alto en el mes.
     * @throws SQLException Si ocurre un error en la consulta.
     */
    Ingreso obtenerIngresoMasAltoDelMes(int idUsuario, String mes) throws SQLException;

    /**
     * Método para obtener el total de ingresos de un usuario en un mes.
     * 
     * @param idUsuario El ID del usuario.
     * @param mes El mes en el cual se desea consultar el total de ingresos.
     * @return El total de ingresos del usuario en el mes.
     * @throws SQLException Si ocurre un error en la consulta.
     */
    double obtenerTotalIngresosDelMes(int idUsuario, String mes) throws SQLException;

    /**
     * Método para actualizar un ingreso en la base de datos.
     * 
     * @param ingreso El objeto Ingreso con los datos actualizados.
     * @throws SQLException Si ocurre un error en la consulta.
     */
    public void actualizarIngreso(int idIngreso, double nuevoMonto, String nuevaDescripcion) throws SQLException;

    /**
     * Método para eliminar un ingreso de la base de datos.
     * 
     * @param idIngreso El ID del ingreso que se desea eliminar.
     * @throws SQLException Si ocurre un error en la consulta.
     */
    void eliminarIngreso(int idIngreso) throws SQLException;

    
}
