package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ApuestaDTO;
/**
 * Data Access Object de Apuesta.
 * @author JorgeJ
 */
public class ApuestaDAO implements CRUDOperation{

	private ArrayList<ApuestaDTO> apuestas;
	private final String SERIAL_FILENAME = "apuestas.dat";
	
	/**
	 * Constructor que inicializa la lista apuestas
	 */
	public ApuestaDAO() {
		apuestas = new ArrayList<>();
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
			apuestas = (ArrayList<ApuestaDTO>) temp;
		} else {
			apuestas= new ArrayList<>();
		}
	}
	/**
	 * Sobreescribe los datos serealizados con los datos de los objetos
	 * en la lista apuestas
	 */
	public void writeSerializable() {
		FileHandler.serializableOpenAndWriteFile(SERIAL_FILENAME, apuestas);
	}
	/**
	 * Creacion de un objeto para ingresarlo en la lista apuestas
	 * Toma como parametros los argumentos con los valores
	 * de los atributos de un objeto apuesta
	 */
	@Override
	public void create(String... args) {
		ApuestaDTO temp = new ApuestaDTO();
		temp.setNombre(args[0]);
		temp.setCedula(Long.parseLong(args[1]));
		temp.setDiaSemana(args[2]);
		temp.setValorApuesta(Double.parseDouble(args[3]));
		apuestas.add(temp);
		writeSerializable(); 
	}
	/**
	 * Creacion de un objeto para ingresarlo en la lista apuestas
	 * Toma como parametro un objeto para ingresar a la lista
	 */
	@Override
	public void create(Object o) {
		apuestas.add((ApuestaDTO)o);
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
		for (ApuestaDTO s : apuestas) {
			print += "\n" + index + ": " + s.toString();
			index++;
		}
		return print;
	}
	/**
	 * Update toma el indice index y llama al objeto de esa posicion
	 * en la lista apuestas. 
	 * Se toman los atributos de los objetos y se actualizan por los 
	 * ingresados en los parametros de la funcion update, si no se 
	 * modifica un atributo, este se queda intacto.
	 */
	@Override
	public boolean update(int index, String... args) {
		if(index<0||index>=apuestas.size())
			return false;
		else {
			if(!args[0].isBlank()||!args[1].isEmpty())
				apuestas.get(index).setNombre(args[0]);
			if(!args[1].isBlank()||!args[1].isEmpty())
				apuestas.get(index).setCedula(Long.parseLong(args[1]));
			if(!args[2].isBlank()||!args[2].isEmpty())
				apuestas.get(index).setDiaSemana(args[2]);
			if(!args[3].isBlank()||!args[3].isEmpty())
				apuestas.get(index).setValorApuesta(Double.parseDouble(args[3]));
		}
		writeSerializable();
		return true;
	}
	/**
	 * Update toma el objeto o y lo busca en la lista apuestas. 
	 * Se reemplaza el objeto en la posicion encontrada por el nuevo objeto o.
	 */
	@Override
	public void update(Object o) {
		int index = 0;
		for (int i = 0; i < apuestas.size(); i++) {
			if (((ApuestaDTO) o).equals(apuestas.get(i))) {
				index = i;
			}
		}
		apuestas.set(index, (ApuestaDTO) o);
		writeSerializable();
	}
	/**
	 * Delete toma el indice index y elimina el objeto de esa posicion
	 * en la lista apuestas
	 */
	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= apuestas.size())
			return false;
		else {
			apuestas.remove(index);
			writeSerializable();
			return true;
		}
	}
	/**
	 * Delete toma el objeto y verifica si esta en la
	 * en la lista apuestas, si se encuentra en la lista
	 * este es eliminado
	 */
	@Override
	public boolean delete(Object o) {
		if (o == null)
			return false;
		else if (apuestas.remove((ApuestaDTO) o)) {
			writeSerializable();
			return true;
		} else {
			return false;
		}
	}
}