/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ClaseDAO;

import Clases.CategoriaGasto;
import java.util.List;

/**
 *
 * @author Luan Condori
 */
public interface CategoriaGastoDAO
{
    void actualizar(CategoriaGasto categoriaGasto);
    CategoriaGasto obtenerPorId(int idCategoria);
    List<CategoriaGasto> obtenerTodos();
    
    
}
