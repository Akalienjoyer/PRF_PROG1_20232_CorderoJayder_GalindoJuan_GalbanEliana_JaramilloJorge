package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.JuegoDTO;

/**
 * Data Access Object de Juego.
 * @author JorgeJ
 */
public class JuegoDAO implements CRUDOperation{

	private ArrayList<JuegoDTO> juegos;
	private final String SERIAL_FILENAME = "juegos.dat";
	
	/**
	 * Constructor que inicializa la lista juegos
	 */
	public JuegoDAO() {
		juegos = new ArrayList<>();
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
			juegos = (ArrayList<JuegoDTO>) temp;
		} else {
			juegos= new ArrayList<>();
		}
	}
	/**
	 * Sobreescribe los datos serealizados con los datos de los objetos
	 * en la lista juegos
	 */
	public void writeSerializable() {
		FileHandler.serializableOpenAndWriteFile(SERIAL_FILENAME, juegos);
	}
	/**
	 * Creacion de un objeto para ingresarlo en la lista juegos
	 * Toma como parametros los argumentos con los valores
	 * de los atributos de un objeto juego
	 */
	@Override
	public void create(String... args) {
		JuegoDTO temp = new JuegoDTO();
		temp.setNombre(args[0]);
		temp.setTipo(args[1]);
		temp.setPresupuesto(Double.parseDouble(args[2]));
		juegos.add(temp);
		writeSerializable(); 
	}
	/**
	 * Creacion de un objeto para ingresarlo en la lista juegos
	 * Toma como parametro un objeto para ingresar a la lista
	 */
	@Override
	public void create(Object o) {
		juegos.add((JuegoDTO)o);
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
		for (JuegoDTO s : juegos) {
			print += "\n" + index + ": " + s.toString();
			index++;
		}
		return print;
	}
	/**
	 * Update toma el indice index y llama al objeto de esa posicion
	 * en la lista juegos. 
	 * Se toman los atributos de los objetos y se actualizan por los 
	 * ingresados en los parametros de la funcion update, si no se 
	 * modifica un atributo, este se queda intacto.
	 */
	@Override
	public boolean update(int index, String... args) {
		if(index<0||index>=juegos.size())
			return false;
		else {
			if(!args[0].isBlank()||!args[1].isEmpty())
				juegos.get(index).setNombre(args[0]);
			if(!args[1].isBlank()||!args[1].isEmpty())
				juegos.get(index).setTipo(args[1]);
			if(!args[2].isBlank()||!args[2].isEmpty())
				juegos.get(index).setPresupuesto(Double.parseDouble(args[2]));
		}
		writeSerializable();
		return true;
	}
	/**
	 * Update toma el objeto o y lo busca en la lista juegos. 
	 * Se reemplaza el objeto en la posicion encontrada por el nuevo objeto o.
	 */
	@Override
	public void update(Object o) {
		int index = 0;
		for (int i = 0; i < juegos.size(); i++) {
			if (((JuegoDTO) o).equals(juegos.get(i))) {
				index = i;
			}
		}
		juegos.set(index, (JuegoDTO) o);
		writeSerializable();
	}
	/**
	 * Delete toma el indice index y elimina el objeto de esa posicion
	 * en la lista juegos
	 */
	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= juegos.size())
			return false;
		else {
			juegos.remove(index);
			writeSerializable();
			return true;
		}
	}
	/**
	 * Delete toma el objeto y verifica si esta en la
	 * en la lista juegos, si se encuentra en la lista
	 * este es eliminado
	 */
	@Override
	public boolean delete(Object o) {
		if (o == null)
			return false;
		else if (juegos.remove((JuegoDTO) o)) {
			writeSerializable();
			return true;
		} else {
			return false;
		}
	}
}
