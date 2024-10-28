/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ClaseDAO;

import Clases.CategoriaGasto;
import java.util.List;

/**
 * Interfaz para definir las operaciones de acceso a datos relacionadas con la
 * entidad {@link CategoriaGasto}.
 * 
 * <p>
 * Esta interfaz especifica los métodos para realizar operaciones CRUD (Actualizar
 * y Obtener) sobre las categorías de gasto en la base de datos.
 * </p>
 * 
 * @author Luan Condori
 */
public interface CategoriaGastoDAO
{
    /**
     * Actualiza la información de una categoría de gasto existente.
     * 
     * @param categoriaGasto el objeto {@link CategoriaGasto} con la información
     *                       actualizada que se debe guardar en la base de datos.
     */
    void actualizar(CategoriaGasto categoriaGasto);
    
    /**
     * Obtiene una categoría de gasto por su ID.
     * 
     * @param idCategoria el identificador único de la categoría de gasto que se
     *                    desea obtener.
     * @return un objeto {@link CategoriaGasto} si se encuentra en la base de datos,
     *         {@code null} en caso contrario.
     */
    CategoriaGasto obtenerPorId(int idCategoria);
    
     /**
     * Obtiene todas las categorías de gasto almacenadas en la base de datos.
     * 
     * @return una lista de objetos {@link CategoriaGasto} que representan todas las
     *         categorías de gasto registradas.
     */
    List<CategoriaGasto> obtenerTodos();
    
    
}
