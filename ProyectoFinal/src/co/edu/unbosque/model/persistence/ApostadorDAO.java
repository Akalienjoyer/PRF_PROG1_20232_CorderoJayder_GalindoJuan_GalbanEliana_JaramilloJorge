package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ApostadorDTO;

/**
 * Data Access Object de Apostador.
 * @author JorgeJ
 */

public class ApostadorDAO implements CRUDOperation{
	private ArrayList<ApostadorDTO> apostadores;
	private final String FILENAME = "datosApostadores.csv";
	private final String SERIAL_FILENAME = "apostadores.dat";
	
	/**
	 * Constructor que inicializa la lista apostadores
	 */
	public ApostadorDAO() {
		apostadores = new ArrayList<>();
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
			apostadores = (ArrayList<ApostadorDTO>) temp;
		} else {
			apostadores = new ArrayList<>();
		}
	}
	/**
	 * Sobreescribe los datos serealizados con los datos de los objetos
	 * en la lista apostadores
	 */
	public void writeSerializable() {
		FileHandler.serializableOpenAndWriteFile(SERIAL_FILENAME, apostadores);
	}
	/**
	 * Creacion de un objeto para ingresarlo en la lista apostadores
	 * Toma como parametros los argumentos con los valores
	 * de los atributos de un objeto apostador
	 */
	@Override
	public void create(String... args) {
		ApostadorDTO temp = new ApostadorDTO();
		temp.setNombre(args[0]);
		temp.setCedula(Long.parseLong(args[1]));
		temp.setSede(args[2]);
		temp.setDireccion(args[3]);
		temp.setCelular(Long.parseLong(args[4]));
		apostadores.add(temp);
		writeSerializable(); 
	}
	/**
	 * Creacion de un objeto para ingresarlo en la lista apostadores
	 * Toma como parametro un objeto para ingresar a la lista
	 */
	@Override
	public void create(Object o) {
		apostadores.add((ApostadorDTO)o);
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
		for (ApostadorDTO s : apostadores) {
			print += "\n" + index + ": " + s.toString();
			index++;
		}
		return print;
	}
	/**
	 * Update toma el indice index y llama al objeto de esa posicion
	 * en la lista apostadores. 
	 * Se toman los atributos de los objetos y se actualizan por los 
	 * ingresados en los parametros de la funcion update, si no se 
	 * modifica un atributo, este se queda intacto.
	 */
	@Override
	public boolean update(int index, String... args) {
		if(index<0||index>=apostadores.size())
			return false;
		else {
			if(!args[0].isBlank()||!args[1].isEmpty())
				apostadores.get(index).setNombre(args[0]);
			if(!args[1].isBlank()||!args[1].isEmpty())
				apostadores.get(index).setCedula(Long.parseLong(args[1]));
			if(!args[2].isBlank()||!args[2].isEmpty())
				apostadores.get(index).setSede(args[2]);
			if(!args[3].isBlank()||!args[3].isEmpty())
				apostadores.get(index).setDireccion(args[3]);
			if(!args[4].isBlank()||!args[4].isEmpty())
				apostadores.get(index).setCelular(Long.parseLong(args[4]));
		}
		writeSerializable();
		return true;
	}
	/**
	 * Update toma el objeto o y lo busca en la lista apostadores. 
	 * Se reemplaza el objeto en la posicion encontrada por el nuevo objeto o.
	 */
	@Override
	public void update(Object o) {
		int index = 0;
		for (int i = 0; i < apostadores.size(); i++) {
			if (((ApostadorDTO) o).equals(apostadores.get(i))) {
				index = i;
			}
		}
		apostadores.set(index, (ApostadorDTO) o);
		writeSerializable();
	}
	/**
	 * Delete toma el indice index y elimina el objeto de esa posicion
	 * en la lista apostadores
	 */
	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= apostadores.size())
			return false;
		else {
			apostadores.remove(index);
			writeSerializable();
			return true;
		}
	}
	/**
	 * Delete toma el objeto y verifica si esta en la
	 * en la lista apostadores, si se encuentra en la lista
	 * este es eliminado
	 */
	@Override
	public boolean delete(Object o) {
		if (o == null)
			return false;
		else if (apostadores.remove((ApostadorDTO) o)) {
			writeSerializable();
			return true;
		} else {
			return false;
		}
	}
	

}
