package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ApuestaBetPlayDTO;

public class ApuestaBetPlayDAO implements CRUDOperation{

	private ArrayList<ApuestaBetPlayDTO> betPlays;
	private final String SERIAL_FILENAME = "apuestas-chance.dat";
	
	/**
	 * Constructor que inicializa la lista betPlays
	 */
	public ApuestaBetPlayDAO() {
		betPlays = new ArrayList<>();
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
			betPlays = (ArrayList<ApuestaBetPlayDTO>) temp;
		} else {
			betPlays= new ArrayList<>();
		}
	}
	/**
	 * Sobreescribe los datos serealizados con los datos de los objetos
	 * en la lista betPlays
	 */
	public void writeSerializable() {
		FileHandler.serializableOpenAndWriteFile(SERIAL_FILENAME, betPlays);
	}
	/**
	 * Creacion de un objeto para ingresarlo en la lista betPlays
	 * Toma como parametros los argumentos con los valores
	 * de los atributos de un objeto betPlays
	 */
	@Override
	public void create(String... args) {
		ApuestaBetPlayDTO temp = new ApuestaBetPlayDTO();
		temp.setNombre(args[0]);
		temp.setCedula(Long.parseLong(args[1]));
		temp.setDiaSemana(args[2]);
		temp.setValorApuesta(Double.parseDouble(args[3]));
		temp.setPartido(args[4]);
		temp.setResultado(args[5]);
		betPlays.add(temp);
		writeSerializable(); 
	}
	/**
	 * Creacion de un objeto para ingresarlo en la lista betPlays
	 * Toma como parametro un objeto para ingresar a la lista
	 */
	@Override
	public void create(Object o) {
		betPlays.add((ApuestaBetPlayDTO)o);
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
		for (ApuestaBetPlayDTO s : betPlays) {
			print += "\n" + index + ": " + s.toString();
			index++;
		}
		return print;
	}
	/**
	 * Update toma el indice index y llama al objeto de esa posicion
	 * en la lista betPlays. 
	 * Se toman los atributos de los objetos y se actualizan por los 
	 * ingresados en los parametros de la funcion update, si no se 
	 * modifica un atributo, este se queda intacto.
	 */
	@Override
	public boolean update(int index, String... args) {
		if(index<0||index>=betPlays.size())
			return false;
		else {
			if(!args[0].isBlank()||!args[0].isEmpty())
				betPlays.get(index).setNombre(args[0]);
			if(!args[1].isBlank()||!args[1].isEmpty())
				betPlays.get(index).setCedula(Long.parseLong(args[1]));
			if(!args[2].isBlank()||!args[2].isEmpty())
				betPlays.get(index).setDiaSemana(args[2]);
			if(!args[3].isBlank()||!args[3].isEmpty())
				betPlays.get(index).setValorApuesta(Integer.parseInt(args[3]));
			if(!args[4].isBlank()||!args[4].isEmpty())
				betPlays.get(index).setPartido(args[4]);
			if(!args[5].isBlank()||!args[5].isEmpty())
				betPlays.get(index).setResultado(args[5]);
		}
		writeSerializable();
		return true;
	}
	/**
	 * Update toma el objeto o y lo busca en la lista betPlays. 
	 * Se reemplaza el objeto en la posicion encontrada por el nuevo objeto o.
	 */
	@Override
	public void update(Object o) {
		int index = 0;
		for (int i = 0; i < betPlays.size(); i++) {
			if (((ApuestaBetPlayDTO) o).equals(betPlays.get(i))) {
				index = i;
			}
		}
		betPlays.set(index, (ApuestaBetPlayDTO) o);
		writeSerializable();
	}
	/**
	 * Delete toma el indice index y elimina el objeto de esa posicion
	 * en la lista betPlays
	 */
	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= betPlays.size())
			return false;
		else {
			betPlays.remove(index);
			writeSerializable();
			return true;
		}
	}
	/**
	 * Delete toma el objeto y verifica si esta en la
	 * en la lista betPlays, si se encuentra en la lista
	 * este es eliminado
	 */
	@Override
	public boolean delete(Object o) {
		if (o == null)
			return false;
		else if (betPlays.remove((ApuestaBetPlayDTO) o)) {
			writeSerializable();
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Retorna una nueva lista de objetos apuestaBetPlay, con
	 * las apuestas de este tipo realizadas por una persona con cedula 
	 * en concreto
	 * @param cedula - valor a comparar
	 * @return String con los datos de las apuestas unicas del usuario
	 */
	public String getBetPlay(String cedula) {
		ArrayList<ApuestaBetPlayDTO> propBetPlays = new ArrayList<>();
		for (ApuestaBetPlayDTO o : betPlays) {
			if(Long.parseLong(cedula)==o.getCedula()) {
				propBetPlays.add(o);
			}
		}
		String print = "";
		int index = 0;
		for (ApuestaBetPlayDTO s : propBetPlays) {
			print += "\n" + index + ": " + s.toString();
			index++;
		}
		writeSerializable();
		return print;
	}
	public ApuestaBetPlayDTO getThisBaloto(int index, String cedula) {
		ArrayList<ApuestaBetPlayDTO> propBetPlays = new ArrayList<>();
		for (ApuestaBetPlayDTO o : betPlays) {
			if(Long.parseLong(cedula)==o.getCedula()) {
				propBetPlays.add(o);
			}
		}
		return propBetPlays.get(index);
	}
	
	public ArrayList<ApuestaBetPlayDTO> returnPropLoto(String cedula){
		ArrayList<ApuestaBetPlayDTO> propBetPlays = new ArrayList<>();
		for (ApuestaBetPlayDTO o : betPlays) {
			if(Long.parseLong(cedula)==o.getCedula()) {
				propBetPlays.add(o);
			}
		}
		return propBetPlays;
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
}
