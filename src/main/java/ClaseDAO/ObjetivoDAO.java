package ClaseDAO;

import Clases.Objetivo;
import java.util.List;

/**
 * Interfaz para la gestión de objetivos en la base de datos.
 * 
 * <p>
 * Proporciona métodos para insertar, actualizar, eliminar y recuperar objetivos.
 * Las implementaciones de esta interfaz deben manejar las interacciones con la
 * base de datos para cada una de estas operaciones.
 * </p>
 * 
 * @author Luan Condori
 */
public interface ObjetivoDAO {
    
    /**
     * Inserta un nuevo objetivo en la base de datos.
     *
     * @param objetivo el objetivo a insertar
     * @throws SQLException si ocurre un error al insertar el objetivo
     */
    void insertar(Objetivo objetivo);

    /**
     * Actualiza un objetivo existente en la base de datos.
     *
     * @param objetivo el objetivo con la información actualizada
     */
    void actualizar(Objetivo objetivo);

    /**
     * Elimina un objetivo de la base de datos por su ID.
     *
     * @param idObjetivo el ID del objetivo a eliminar
     */
    void eliminar(int idObjetivo);

    /**
     * Obtiene un objetivo específico de la base de datos por su ID.
     *
     * @param idObjetivo el ID del objetivo a recuperar
     * @return el objetivo correspondiente al ID especificado, o null si no existe
     */
    Objetivo obtenerPorId(int idObjetivo);

    /**
     * Recupera una lista de todos los objetivos en la base de datos.
     *
     * @return una lista de todos los objetivos
     */
    List<Objetivo> obtenerTodos();
    
    /**
     * Obtiene una lista de los objetivos relacionados con un id_usuario específico.
     *
     * @param idUsuario el ID del usuario cuyos objetivos se desean recuperar
     * @return una lista de objetivos del usuario
     */
    List<Objetivo> obtenerPorUsuario(int idUsuario);
}
