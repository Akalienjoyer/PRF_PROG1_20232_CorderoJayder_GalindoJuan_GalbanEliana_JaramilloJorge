package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ApuestaChanceDTO;
import co.edu.unbosque.model.ApuestaSuperastroDTO;

public class ApuestaSuperastroDAO implements CRUDOperation{

	private ArrayList<ApuestaSuperastroDTO> superastros;
	private final String SERIAL_FILENAME = "apuestas-superastro.dat";
	
	/**
	 * Constructor que inicializa la lista superastros
	 */
	public ApuestaSuperastroDAO() {
		superastros = new ArrayList<>();
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
			superastros = (ArrayList<ApuestaSuperastroDTO>) temp;
		} else {
			superastros= new ArrayList<>();
		}
	}
	/**
	 * Sobreescribe los datos serealizados con los datos de los objetos
	 * en la lista superastros
	 */
	public void writeSerializable() {
		FileHandler.serializableOpenAndWriteFile(SERIAL_FILENAME, superastros);
	}
	/**
	 * Creacion de un objeto para ingresarlo en la lista superastros
	 * Toma como parametros los argumentos con los valores
	 * de los atributos de un objeto superastro
	 */
	@Override
	public void create(String... args) {
		ApuestaSuperastroDTO temp = new ApuestaSuperastroDTO();
		temp.setNombre(args[0]);
		temp.setCedula(Long.parseLong(args[1]));
		temp.setDiaSemana(args[2]);
		temp.setValorApuesta(Double.parseDouble(args[3]));
		temp.setNum1(Integer.parseInt(args[4]));
		temp.setNum2(Integer.parseInt(args[5]));
		temp.setNum3(Integer.parseInt(args[6]));
		temp.setNum4(Integer.parseInt(args[7]));
		temp.setSigno(args[8]);
		superastros.add(temp);
		writeSerializable(); 
	}
	/**
	 * Creacion de un objeto para ingresarlo en la lista superastros
	 * Toma como parametro un objeto para ingresar a la lista
	 */
	@Override
	public void create(Object o) {
		superastros.add((ApuestaSuperastroDTO)o);
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
		for (ApuestaSuperastroDTO s : superastros) {
			print += "\n" + index + ": " + s.toString();
			index++;
		}
		return print;
	}
	/**
	 * Update toma el indice index y llama al objeto de esa posicion
	 * en la lista superastros. 
	 * Se toman los atributos de los objetos y se actualizan por los 
	 * ingresados en los parametros de la funcion update, si no se 
	 * modifica un atributo, este se queda intacto.
	 */
	@Override
	public boolean update(int index, String... args) {
		if(index<0||index>=superastros.size())
			return false;
		else {
			if(!args[0].isBlank()||!args[0].isEmpty())
				superastros.get(index).setNombre(args[0]);
			if(!args[1].isBlank()||!args[1].isEmpty())
				superastros.get(index).setCedula(Long.parseLong(args[1]));
			if(!args[2].isBlank()||!args[2].isEmpty())
				superastros.get(index).setDiaSemana(args[2]);
			if(!args[3].isBlank()||!args[3].isEmpty())
				superastros.get(index).setValorApuesta(Integer.parseInt(args[3]));
			if(!args[4].isBlank()||!args[4].isEmpty())
				superastros.get(index).setNum1(Integer.parseInt(args[4]));
			if(!args[5].isBlank()||!args[5].isEmpty())
				superastros.get(index).setNum2(Integer.parseInt(args[5]));
			if(!args[6].isBlank()||!args[6].isEmpty())
				superastros.get(index).setNum3(Integer.parseInt(args[6]));
			if(!args[7].isBlank()||!args[7].isEmpty())
				superastros.get(index).setNum4(Integer.parseInt(args[7]));
			if(!args[8].isBlank()||!args[8].isEmpty())
				superastros.get(index).setSigno(args[8]);
		}
		writeSerializable();
		return true;
	}
	/**
	 * Update toma el objeto o y lo busca en la lista superastros. 
	 * Se reemplaza el objeto en la posicion encontrada por el nuevo objeto o.
	 */
	@Override
	public void update(Object o) {
		int index = 0;
		for (int i = 0; i < superastros.size(); i++) {
			if (((ApuestaSuperastroDTO) o).equals(superastros.get(i))) {
				index = i;
			}
		}
		superastros.set(index, (ApuestaSuperastroDTO) o);
		writeSerializable();
	}
	/**
	 * Delete toma el indice index y elimina el objeto de esa posicion
	 * en la lista superastros
	 */
	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= superastros.size())
			return false;
		else {
			superastros.remove(index);
			writeSerializable();
			return true;
		}
	}
	/**
	 * Delete toma el objeto y verifica si esta en la
	 * en la lista superastros, si se encuentra en la lista
	 * este es eliminado
	 */
	@Override
	public boolean delete(Object o) {
		if (o == null)
			return false;
		else if (superastros.remove((ApuestaSuperastroDTO) o)) {
			writeSerializable();
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Retorna una nueva lista de objetos apuestaSuperastro, con
	 * las apuestas de este tipo realizadas por una persona con cedula 
	 * en concreto
	 * @param cedula - valor a comparar
	 * @return String con los datos de las apuestas unicas del usuario
	 */
	public String getSuperastro(String cedula) {
		ArrayList<ApuestaSuperastroDTO> propSuperastros = new ArrayList<>();
		for (ApuestaSuperastroDTO o : superastros) {
			if(Long.parseLong(cedula)==o.getCedula()) {
				propSuperastros.add(o);
			}
		}
		String print = "";
		int index = 0;
		for (ApuestaSuperastroDTO s : propSuperastros) {
			print += "\n" + index + ": " + s.toString();
			index++;
		}
		writeSerializable();
		return print;
	}
	public ApuestaSuperastroDTO getThisSuperastro(int index, String cedula) {
		ArrayList<ApuestaSuperastroDTO> propSuperastros = new ArrayList<>();
		for (ApuestaSuperastroDTO o : superastros) {
			if(Long.parseLong(cedula)==o.getCedula()) {
				propSuperastros.add(o);
			}
		}
		return propSuperastros.get(index);
	}
	
	public String getLastSuperastro(String cedula) {
		ArrayList<ApuestaSuperastroDTO> propSuperastros = new ArrayList<>();
		for (ApuestaSuperastroDTO o : superastros) {
			if(Long.parseLong(cedula)==o.getCedula()) {
				propSuperastros.add(o);
			}
		}
		String print = "-> "+propSuperastros.get(propSuperastros.size()-1).toString();
		return print;
	}
	
	public ArrayList<ApuestaSuperastroDTO> returnPropSuperastro(String cedula){
		ArrayList<ApuestaSuperastroDTO> propSuperastros = new ArrayList<>();
		for (ApuestaSuperastroDTO o : superastros) {
			if(Long.parseLong(cedula)==o.getCedula()) {
				propSuperastros.add(o);
			}
		}
		return propSuperastros;
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
