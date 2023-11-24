package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ApuestaBalotoDTO;

public class ApuestaBalotoDAO implements CRUDOperation{
	private ArrayList<ApuestaBalotoDTO> balotos;
	private ArrayList<ApuestaBalotoDTO> carritoBalotos;
private final String SERIAL_FILENAME = "apuestas-baloto.dat";
	
	/**
	 * Constructor que inicializa la lista balotos
	 */
	public ApuestaBalotoDAO() {
		balotos = new ArrayList<>();
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
			balotos = (ArrayList<ApuestaBalotoDTO>) temp;
		} else {
			balotos= new ArrayList<>();
		}
	}
	/**
	 * Sobreescribe los datos serealizados con los datos de los objetos
	 * en la lista balotos
	 */
	public void writeSerializable() {
		FileHandler.serializableOpenAndWriteFile(SERIAL_FILENAME, balotos);
	}
	/**
	 * Creacion de un objeto para ingresarlo en la lista balotos
	 * Toma como parametros los argumentos con los valores
	 * de los atributos de un objeto baloto
	 */
	@Override
	public void create(String... args) {
		ApuestaBalotoDTO temp = new ApuestaBalotoDTO();
		temp.setNombre(args[0]);
		temp.setCedula(Long.parseLong(args[1]));
		temp.setDiaSemana(args[2]);
		temp.setValorApuesta(Double.parseDouble(args[3]));
		temp.setNum1(Integer.parseInt(args[4]));
		temp.setNum2(Integer.parseInt(args[5]));
		temp.setNum3(Integer.parseInt(args[6]));
		temp.setNum4(Integer.parseInt(args[7]));
		temp.setNum5(Integer.parseInt(args[8]));
		temp.setNum6(Integer.parseInt(args[9]));
		balotos.add(temp);
		writeSerializable(); 
	}
	/**
	 * Creacion de un objeto para ingresarlo en la lista balotos
	 * Toma como parametro un objeto para ingresar a la lista
	 */
	@Override
	public void create(Object o) {
		balotos.add((ApuestaBalotoDTO)o);
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
		for (ApuestaBalotoDTO s : balotos) {
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
		if(index<0||index>=balotos.size())
			return false;
		else {
			if(!args[0].isBlank()||!args[0].isEmpty())
				balotos.get(index).setNombre(args[0]);
			if(!args[1].isBlank()||!args[1].isEmpty())
				balotos.get(index).setCedula(Long.parseLong(args[1]));
			if(!args[2].isBlank()||!args[2].isEmpty())
				balotos.get(index).setDiaSemana(args[2]);
			if(!args[3].isBlank()||!args[3].isEmpty())
				balotos.get(index).setValorApuesta(Integer.parseInt(args[3]));
			if(!args[4].isBlank()||!args[4].isEmpty())
				balotos.get(index).setNum1(Integer.parseInt(args[4]));
			if(!args[5].isBlank()||!args[5].isEmpty())
				balotos.get(index).setNum2(Integer.parseInt(args[5]));
			if(!args[6].isBlank()||!args[6].isEmpty())
				balotos.get(index).setNum3(Integer.parseInt(args[6]));
			if(!args[7].isBlank()||!args[7].isEmpty())
				balotos.get(index).setNum4(Integer.parseInt(args[7]));
			if(!args[8].isBlank()||!args[8].isEmpty())
				balotos.get(index).setNum5(Integer.parseInt(args[8]));
			if(!args[9].isBlank()||!args[9].isEmpty())
				balotos.get(index).setNum6(Integer.parseInt(args[9]));
		}
		writeSerializable();
		return true;
	}
	/**
	 * Update toma el objeto o y lo busca en la lista balotos. 
	 * Se reemplaza el objeto en la posicion encontrada por el nuevo objeto o.
	 */
	@Override
	public void update(Object o) {
		int index = 0;
		for (int i = 0; i < balotos.size(); i++) {
			if (((ApuestaBalotoDTO) o).equals(balotos.get(i))) {
				index = i;
			}
		}
		balotos.set(index, (ApuestaBalotoDTO) o);
		writeSerializable();
	}
	/**
	 * Delete toma el indice index y elimina el objeto de esa posicion
	 * en la lista balotos
	 */
	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= balotos.size())
			return false;
		else {
			balotos.remove(index);
			writeSerializable();
			return true;
		}
	}
	/**
	 * Delete toma el objeto y verifica si esta en la
	 * en la lista balotos, si se encuentra en la lista
	 * este es eliminado
	 */
	@Override
	public boolean delete(Object o) {
		if (o == null)
			return false;
		else if (balotos.remove((ApuestaBalotoDTO) o)) {
			writeSerializable();
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Retorna una nueva lista de objetos apuestaBalotos, con
	 * las apuestas de este tipo realizadas por una persona con cedula 
	 * en concreto
	 * @param cedula - valor a comparar
	 * @return String con los datos de las apuestas unicas del usuario
	 */
	public String getBaloto(String cedula) {
		ArrayList<ApuestaBalotoDTO> propBalotos = new ArrayList<>();
		for (ApuestaBalotoDTO o : balotos) {
			if(Long.parseLong(cedula)==o.getCedula()) {
				propBalotos.add(o);
			}
		}
		String print = "";
		int index = 0;
		for (ApuestaBalotoDTO s : propBalotos) {
			print += "\n" + index + ": " + s.toString();
			index++;
		}
		writeSerializable();
		return print;
	}
	public ApuestaBalotoDTO getThisBaloto(int index, String cedula) {
		ArrayList<ApuestaBalotoDTO> propBalotos = new ArrayList<>();
		for (ApuestaBalotoDTO o : balotos) {
			if(Long.parseLong(cedula)==o.getCedula()) {
				propBalotos.add(o);
			}
		}
		return propBalotos.get(index);
	}
	
	public String getLastBaloto(String cedula) {
		ArrayList<ApuestaBalotoDTO> propBalotos = new ArrayList<>();
		for (ApuestaBalotoDTO o : balotos) {
			if(Long.parseLong(cedula)==o.getCedula()) {
				propBalotos.add(o);
			}
		}
		String print = "-> "+propBalotos.get(propBalotos.size()-1).toString();
		return print;
	}
	
	public ArrayList<ApuestaBalotoDTO> returnPropLoto(String cedula){
		ArrayList<ApuestaBalotoDTO> propBalotos = new ArrayList<>();
		for (ApuestaBalotoDTO o : balotos) {
			if(Long.parseLong(cedula)==o.getCedula()) {
				propBalotos.add(o);
			}
		}
		return propBalotos;
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
		carritoBalotos.add(balotos.get(balotos.size()-1));
		writeSerializable();
	}
	public ArrayList<ApuestaBalotoDTO> returnCarrito() {
		return carritoBalotos;
	}
}
