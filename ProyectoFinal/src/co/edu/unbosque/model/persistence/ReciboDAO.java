package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ApuestaBalotoDTO;
import co.edu.unbosque.model.ApuestaDTO;
import co.edu.unbosque.model.ReciboDTO;

public class ReciboDAO implements CRUDOperation{
	private ArrayList<ReciboDTO> recibos;
	private final String SERIAL_FILENAME = "recibos.dat";
	
	/**
	 * Constructor que inicializa la lista recibos
	 */
	public ReciboDAO() {
		recibos = new ArrayList<>();
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
			recibos = (ArrayList<ReciboDTO>) temp;
		} else {
			recibos = new ArrayList<>();
		}
	}
	/**
	 * Sobreescribe los datos serealizados con los datos de los objetos
	 * en la lista recibos
	 */
	public void writeSerializable() {
		FileHandler.serializableOpenAndWriteFile(SERIAL_FILENAME, recibos);
	}
	
	@Override
	public void create(String... args) {
		
	}
	/**
	 * Creacion de un objeto para ingresarlo en la lista recibos
	 * Toma como parametros los argumentos con los valores
	 * de los atributos de un objeto recibo
	 */
	public void trueCreate(String cedula, ArrayList<ApuestaDTO> apuestas) {
		ReciboDTO temp = new ReciboDTO();
		temp.setCedula(Long.parseLong(cedula));
		temp.setApuestas(apuestas);
		recibos.add(temp);
		writeSerializable(); 
	}
	/**
	 * Creacion de un objeto para ingresarlo en la lista recibos
	 * Toma como parametro un objeto para ingresar a la lista
	 */
	@Override
	public void create(Object o) {
		recibos.add((ReciboDTO)o);
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
		for (ReciboDTO s : recibos) {
			print += "\n" + index + ": " + s.toString();
			index++;
		}
		return print;
	}
	
	@Override
	public boolean update(int index, String... args) {
		return false;
	}
	/**
	 * Update toma el objeto o y lo busca en la lista recibos. 
	 * Se reemplaza el objeto en la posicion encontrada por el nuevo objeto o.
	 */
	@Override
	public void update(Object o) {
		int index = 0;
		for (int i = 0; i < recibos.size(); i++) {
			if (((ReciboDTO) o).equals(recibos.get(i))) {
				index = i;
			}
		}
		recibos.set(index, (ReciboDTO) o);
		writeSerializable();
	}
	/**
	 * Update toma el indice index y llama al objeto de esa posicion
	 * en la lista recibos. 
	 * Se toman los atributos de los objetos y se actualizan por los 
	 * ingresados en los parametros de la funcion update, si no se 
	 * modifica un atributo, este se queda intacto.
	 */
	public boolean trueUpdate(int index,String cedula, ArrayList<ApuestaDTO> apuestas) {
		if(index<0||index>=recibos.size())
			return false;
		else {
			if(!cedula.isBlank()||!cedula.isEmpty())
				recibos.get(index).setCedula(Long.parseLong(cedula));
			if(!apuestas.isEmpty()||apuestas!=null) 
				recibos.get(index).setApuestas(apuestas);
		}
		writeSerializable();
		return true;
	}
	/**
	 * Delete toma el indice index y elimina el objeto de esa posicion
	 * en la lista recibos
	 */
	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= recibos.size())
			return false;
		else {
			recibos.remove(index);
			writeSerializable();
			return true;
		}
	}
	/**
	 * Delete toma el objeto y verifica si esta en la
	 * en la lista recibos, si se encuentra en la lista
	 * este es eliminado
	 */
	@Override
	public boolean delete(Object o) {
		if (o == null)
			return false;
		else if (recibos.remove((ReciboDTO) o)) {
			writeSerializable();
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Retorna la lista recibos
	 * @return apostadores - lista
	 */
	public ArrayList<ReciboDTO> returnList(){
		writeSerializable();
		return recibos;
	}
	/**
	 * Retorna una nueva lista de objetos recibos, con
	 * los recibos de este tipo realizadas por una persona con cedula 
	 * en concreto
	 * @param cedula - valor a comparar
	 * @return String con los datos de los recibos unicos del usuario
	 */
	public String getAllRecibos(String cedula) {
		ArrayList<ReciboDTO> propRecibos = new ArrayList<>();
		for (ReciboDTO o : recibos) {
			if(Long.parseLong(cedula)==o.getCedula()) {
				propRecibos.add(o);
			}
		}
		String print = "";
		int index = 0;
		for (ReciboDTO s : propRecibos) {
			print += "\n" + index + ": " + s.toString();
			index++;
		}
		return print;
	}
	public String getLastRecibo(String cedula) {
		ArrayList<ReciboDTO> propRecibos = new ArrayList<>();
		for (ReciboDTO o : recibos) {
			if(Long.parseLong(cedula)==o.getCedula()) {
				propRecibos.add(o);
			}
		}
		String print = propRecibos.get(propRecibos.size()-1).toString();
		return print;
	}
}
