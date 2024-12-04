/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ClaseDAO;

import Clases.Gasto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Luan Condori
 */
public interface GastoDAO {
    void registrarGasto(Gasto gasto) throws SQLException;
    List<Gasto> obtenerGastosPorUsuario(int idUsuario) throws SQLException;
    double obtenerTotalGastosPorUsuario(int idUsuario) throws SQLException;
    void actualizarGasto(Gasto gasto) throws SQLException;
        // Método para eliminar un gasto
    void eliminarGasto(int idGasto) throws SQLException;
}
