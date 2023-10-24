package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.SedeDTO;

/**
 * Data Access Object de Sede.
 * @author JorgeJ
 *
 */

public class SedeDAO implements CRUDOperation{
	private ArrayList<SedeDTO> sedes;
	private final String FILENAME = "datosSedes.csv";
	private final String SERIAL_FILENAME = "sedes.dat";
	
	/**
	 * Constructor que inicializa la lista sedes
	 */
	public SedeDAO() {
		sedes = new ArrayList<>();
		loadSerializable();
	}
	/**
	 * Carga los datos del archivo serealizado al codigo
	 * fuente para su uso en las funciones
	 */
	@SuppressWarnings("unchecked")
	private void loadSerializable() {
		if (FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME) != null) {
			Object temp = FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME);
			sedes = (ArrayList<SedeDTO>) temp;
		} else {
			sedes = new ArrayList<>();
		}
	}
	/**
	 * Sobreescribe los datos serealizados con los datos de los objetos
	 * en la lista sedes
	 */
	public void writeSerializable() {
		FileHandler.serializableOpenAndWriteFile(SERIAL_FILENAME, sedes);
	}
	
	/**
	 * Creacion de un objeto para ingresarlo en la lista sedes
	 * Toma como parametros los argumentos con los valores
	 * de los atributos de un objeto Sede
	 */
	@Override
	public void create(String... args) {
		SedeDTO temp = new SedeDTO();
		temp.setUbicacion(args[0]);
		temp.setEmpleados(Integer.parseInt(args[1]));
		sedes.add(temp);
		writeSerializable(); 
	}
	/**
	 * Creacion de un objeto para ingresarlo en la lista sedes
	 * Toma como parametro un objeto para ingresar a la lista
	 */
	@Override
	public void create(Object o) {
		sedes.add((SedeDTO)o);
		writeSerializable();
	}
	/**
	 * Muestra todos los elementos de la lista. Se muestran sus
	 * atributos 
	 */
	@Override
	public String readAll() {
		String print = "";
		int index = 0;
		for (SedeDTO s : sedes) {
			print += "\n" + index + ": " + s.toString();
			index++;
		}
		return print;
	}
	/**
	 * Update toma el indice index y llama al objeto de esa posicion
	 * en la lista sedes. 
	 * Se toman los atributos de los objetos y se actualizan por los 
	 * ingresados en los parametros de la funcion update, si no se 
	 * modifica un atributo, este se queda intacto.
	 */
	@Override
	public boolean update(int index, String... args) {
		if(index<0||index>=sedes.size())
			return false;
		else {
			if(!args[0].isBlank()||!args[1].isEmpty())
				sedes.get(index).setUbicacion(args[0]);
			if(!args[1].isBlank()||!args[1].isEmpty())
				sedes.get(index).setEmpleados(Integer.parseInt(args[1]));
		}
		writeSerializable();
		return true;
	}
	/**
	 * Update toma el objeto o y lo busca en la lista sedes. 
	 * Se reemplaza el objeto en la posicion encontrada por el nuevo objeto o.
	 */
	@Override
	public void update(Object o) {
		int index = 0;
		for (int i = 0; i < sedes.size(); i++) {
			if (((SedeDTO) o).equals(sedes.get(i))) {
				index = i;
			}
		}
		sedes.set(index, (SedeDTO) o);
		writeSerializable();
	}
	/**
	 * Delete toma el indice index y elimina el objeto de esa posicion
	 * en la lista Sedes
	 */
	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= sedes.size())
			return false;
		else {
			sedes.remove(index);
			writeSerializable();
			return true;
		}
	}
	/**
	 * Delete toma el objeto y verifica si esta en la
	 * en la lista sdes, si se encuentra en la lista
	 * este es eliminado
	 */
	@Override
	public boolean delete(Object o) {
		if (o == null)
			return false;
		else if (sedes.remove((SedeDTO) o)) {
			writeSerializable();
			return true;
		} else {
			return false;
		}
	}
	

}
