/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ClaseDAO;

import Clases.Objetivo;
import java.util.List;

/**
 *
 * @author Luan Condori
 */
public interface ObjetivoDAO {
    
    void insertar(Objetivo objetivo);
    void actualizar(Objetivo objetivo);
    void eliminar(int idObjetivo);
    Objetivo obtenerPorId(int idObjetivo);
    List<Objetivo> obtenerTodos();
    
}
