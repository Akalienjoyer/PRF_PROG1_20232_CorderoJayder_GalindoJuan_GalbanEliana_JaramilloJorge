package co.edu.unbosque.model.persistence;

/**
 * Interfaz que asgina las operaciones basicas que cumplen
 * las clases que la heredan 
 * @author JorgeJ
 */

public interface CRUDOperation {

	/**
	 * La funcion create recibe un numero de atributos
	 * Strings, los combierte, crea, y agrega a la lista correspondiente
	 * un objeto con los atributos especificados
	 * @param args - cantidad de atributos
	 */
	public void create(String...args);
	/**
	 * La funcion create recibe un objeto.
	 * Esta funcion crea y agrega a la lista correspondiente
	 * el objeto recibido por parametro
	 * @param o - Objeto
	 */
	public void create(Object o);
	/**
	 * readAll muestra los datos de una lista utilizando
	 * el to String de cada objeto
	 * @return Datos impresos de los objetos de una lista
	 */
	public String readAll();
	/**
	 * Update toma el indice index y llama al objeto de esa posicion
	 * en la lista correspondiente. 
	 * Se toman los atributos de los objetos y se actualizan por los 
	 * ingresados en los parametros de la funcion update, si no se 
	 * modifica un atributo, este se queda intacto.
	 * @param index - posicion en la lista del objeto a actualizar
	 * @param args - valores de los atributos a modifica
	 * @return booleano de verificacion
	 */
	public boolean update(int index, String...args);
	/**
	 * Update toma el objeto o y lo busca en laen la lista correspondiente. 
	 * Se reemplaza el objeto en la posicion encontrada por el nuevo objeto o
	 * @param o - Objeto
	 * @return booleano de verificacion
	 */
	public void update(Object o);
	/**
	 * Delete toma el indice index y elimina el objeto de esa posicion
	 * en la lista correspondiente
	 * @param index - posicion del objeto a eliminar
	 * @return booleando de verificacion
	 */
	public boolean delete(int index);
	/**
	 * Delete toma el objeto y verifica si esta en la
	 * en la lista correspondiente, si se encuentra en la lista
	 * este es eliminado
	 * @param index - posicion del objeto a eliminar
	 * @return booleando de verificacion
	 */
	public boolean delete(Object o);
}
