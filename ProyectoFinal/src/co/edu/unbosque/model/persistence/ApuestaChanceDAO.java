package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ApuestaBalotoDTO;
import co.edu.unbosque.model.ApuestaBetPlayDTO;
import co.edu.unbosque.model.ApuestaChanceDTO;

public class ApuestaChanceDAO implements CRUDOperation{

	ArrayList<ApuestaChanceDTO> chances;
	ArrayList<ApuestaChanceDTO> carritoChances;
	private final String SERIAL_FILENAME = "apuestas-chance.dat";
	
	/**
	 * Constructor que inicializa la lista chances
	 */
	public ApuestaChanceDAO() {
		carritoChances = new ArrayList<>();
		chances = new ArrayList<>();
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
			chances = (ArrayList<ApuestaChanceDTO>) temp;
		} else {
			chances= new ArrayList<>();
		}
	}
	/**
	 * Sobreescribe los datos serealizados con los datos de los objetos
	 * en la lista loterias
	 */
	public void writeSerializable() {
		FileHandler.serializableOpenAndWriteFile(SERIAL_FILENAME, chances);
	}
	/**
	 * Creacion de un objeto para ingresarlo en la lista chances
	 * Toma como parametros los argumentos con los valores
	 * de los atributos de un objeto chance
	 */
	@Override
	public void create(String... args) {
		ApuestaChanceDTO temp = new ApuestaChanceDTO();
		temp.setNombre(args[0]);
		temp.setCedula(Long.parseLong(args[1]));
		temp.setDiaSemana(args[2]);
		temp.setValorApuesta(Double.parseDouble(args[3]));
		temp.setNombreLoto(args[4]);
		temp.setNum1(Integer.parseInt(args[5]));
		temp.setNum2(Integer.parseInt(args[6]));
		temp.setNum3(Integer.parseInt(args[7]));
		temp.setNum4(Integer.parseInt(args[8]));
		chances.add(temp);
		writeSerializable(); 
	}
	/**
	 * Creacion de un objeto para ingresarlo en la lista chances
	 * Toma como parametro un objeto para ingresar a la lista
	 */
	@Override
	public void create(Object o) {
		chances.add((ApuestaChanceDTO)o);
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
		for (ApuestaChanceDTO s : chances) {
			print += "\n" + index + ": " + s.toString();
			index++;
		}
		return print;
	}
	/**
	 * Update toma el indice index y llama al objeto de esa posicion
	 * en la lista chances. 
	 * Se toman los atributos de los objetos y se actualizan por los 
	 * ingresados en los parametros de la funcion update, si no se 
	 * modifica un atributo, este se queda intacto.
	 */
	@Override
	public boolean update(int index, String... args) {
		if(index<0||index>=chances.size())
			return false;
		else {
			if(!args[0].isBlank()||!args[0].isEmpty())
				chances.get(index).setNombre(args[0]);
			if(!args[1].isBlank()||!args[1].isEmpty())
				chances.get(index).setCedula(Long.parseLong(args[1]));
			if(!args[2].isBlank()||!args[2].isEmpty())
				chances.get(index).setDiaSemana(args[2]);
			if(!args[3].isBlank()||!args[3].isEmpty())
				chances.get(index).setValorApuesta(Integer.parseInt(args[3]));
			if(!args[4].isBlank()||!args[4].isEmpty())
				chances.get(index).setNombreLoto(args[4]);
			if(!args[5].isBlank()||!args[5].isEmpty())
				chances.get(index).setNum1(Integer.parseInt(args[5]));
			if(!args[6].isBlank()||!args[6].isEmpty())
				chances.get(index).setNum2(Integer.parseInt(args[6]));
			if(!args[7].isBlank()||!args[7].isEmpty())
				chances.get(index).setNum3(Integer.parseInt(args[7]));
			if(!args[8].isBlank()||!args[8].isEmpty())
				chances.get(index).setNum4(Integer.parseInt(args[8]));
		}
		writeSerializable();
		return true;
	}
	/**
	 * Update toma el objeto o y lo busca en la lista chances. 
	 * Se reemplaza el objeto en la posicion encontrada por el nuevo objeto o.
	 */
	@Override
	public void update(Object o) {
		int index = 0;
		for (int i = 0; i < chances.size(); i++) {
			if (((ApuestaChanceDTO) o).equals(chances.get(i))) {
				index = i;
			}
		}
		chances.set(index, (ApuestaChanceDTO) o);
		writeSerializable();
	}
	/**
	 * Delete toma el indice index y elimina el objeto de esa posicion
	 * en la lista chances
	 */
	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= chances.size())
			return false;
		else {
			chances.remove(index);
			writeSerializable();
			return true;
		}
	}
	/**
	 * Delete toma el objeto y verifica si esta en la
	 * en la lista chances, si se encuentra en la lista
	 * este es eliminado
	 */
	@Override
	public boolean delete(Object o) {
		if (o == null)
			return false;
		else if (chances.remove((ApuestaChanceDTO) o)) {
			writeSerializable();
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Retorna una nueva lista de objetos apuestaChance, con
	 * las apuestas de este tipo realizadas por una persona con cedula 
	 * en concreto
	 * @param cedula - valor a comparar
	 * @return String con los datos de las apuestas unicas del usuario
	 */
	public String getChance(String cedula) {
		ArrayList<ApuestaChanceDTO> propChances = new ArrayList<>();
		for (ApuestaChanceDTO o : chances) {
			if(Long.parseLong(cedula)==o.getCedula()) {
				propChances.add(o);
			}
		}
		String print = "";
		int index = 0;
		for (ApuestaChanceDTO s : propChances) {
			print += "\n" + index + ": " + s.toString();
			index++;
		}
		writeSerializable();
		return print;
	}
	public ApuestaChanceDTO getThisChance(int index, String cedula) {
		ArrayList<ApuestaChanceDTO> propChances = new ArrayList<>();
		for (ApuestaChanceDTO o : chances) {
			if(Long.parseLong(cedula)==o.getCedula()) {
				propChances.add(o);
			}
		}
		return propChances.get(index);
	}
	
	public String getLastChance(String cedula) {
		ArrayList<ApuestaChanceDTO> propChances = new ArrayList<>();
		for (ApuestaChanceDTO o : chances) {
			if(Long.parseLong(cedula)==o.getCedula()) {
				propChances.add(o);
			}
		}
		String print = "-> "+propChances.get(propChances.size()-1).toString();
		return print;
	}
	
	public ArrayList<ApuestaChanceDTO> returnPropChance(String cedula){
		ArrayList<ApuestaChanceDTO> propChances = new ArrayList<>();
		for (ApuestaChanceDTO o : chances) {
			if(Long.parseLong(cedula)==o.getCedula()) {
				propChances.add(o);
			}
		}
		return propChances;
	}
	public int checkValor(String valor, double saldo) {
			if(Double.parseDouble(valor) < 200) {
				return 0;
			}
			if(Double.parseDouble(valor)>saldo) {
				return 1;
			}
			return 2;
	}
	public void addCarrito() {
		carritoChances.add(chances.get(chances.size()-1));
		writeSerializable();
	}
	public ArrayList<ApuestaChanceDTO> returnCarrito() {
		return carritoChances;
	}
	public void deleteCarrito() {
		int x = carritoChances.size();
		for (int i = 0; i < x; i++) {
			carritoChances.remove(0);
		}
		writeSerializable();
	}
	public ArrayList<ApuestaChanceDTO> returnBySede(String sede){
		ArrayList<ApuestaChanceDTO> propChances = new ArrayList<>();
		for (ApuestaChanceDTO o : chances) {
			if(o.getNombre().equals(sede)) {
				propChances.add(o);
			}
		}
		return propChances;
	}
	public ArrayList<ApuestaChanceDTO> returnByClient(String cedula){
		ArrayList<ApuestaChanceDTO> propChances = new ArrayList<>();
		for (ApuestaChanceDTO o : chances) {
			if(o.getCedula()==Long.parseLong(cedula)) {
				propChances.add(o);
			}
		}
		return propChances;
	}
	public float returnTotalBetGame() {
		float exit = 0;
		for (ApuestaChanceDTO o : chances) {
			exit+=o.getValorApuesta();
		}
		return exit;
	}
}
