package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ApuestaLoteriaDTO;

public class ApuestaLoteriaDAO implements CRUDOperation{

	ArrayList<ApuestaLoteriaDTO> loterias;
	ArrayList<ApuestaLoteriaDTO> carritoLoterias;
	private final String SERIAL_FILENAME = "apuestas-loteria.dat";
	
	/**
	 * Constructor que inicializa la lista loterias
	 */
	public ApuestaLoteriaDAO() {
		loterias = new ArrayList<>();
		carritoLoterias = new ArrayList<>();
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
			loterias = (ArrayList<ApuestaLoteriaDTO>) temp;
		} else {
			loterias= new ArrayList<>();
		}
	}
	/**
	 * Sobreescribe los datos serealizados con los datos de los objetos
	 * en la lista loterias
	 */
	public void writeSerializable() {
		FileHandler.serializableOpenAndWriteFile(SERIAL_FILENAME, loterias);
	}
	/**
	 * Creacion de un objeto para ingresarlo en la lista loterias
	 * Toma como parametros los argumentos con los valores
	 * de los atributos de un objeto loteria
	 */
	@Override
	public void create(String... args) {
		ApuestaLoteriaDTO temp = new ApuestaLoteriaDTO();
		temp.setNombre(args[0]);
		temp.setCedula(Long.parseLong(args[1]));
		temp.setDiaSemana(args[2]);
		temp.setValorApuesta(Double.parseDouble(args[3]));
		temp.setNombreLoto(args[4]);
		temp.setNum1(Integer.parseInt(args[5]));
		temp.setNum2(Integer.parseInt(args[6]));
		temp.setNum3(Integer.parseInt(args[7]));
		temp.setNum4(Integer.parseInt(args[8]));
		temp.setSer(Integer.parseInt(args[9]));
		loterias.add(temp);
		writeSerializable(); 
	}
	/**
	 * Creacion de un objeto para ingresarlo en la lista loterias
	 * Toma como parametro un objeto para ingresar a la lista
	 */
	@Override
	public void create(Object o) {
		loterias.add((ApuestaLoteriaDTO)o);
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
		for (ApuestaLoteriaDTO s : loterias) {
			print += "\n" + index + ": " + s.toString();
			index++;
		}
		return print;
	}
	/**
	 * Update toma el indice index y llama al objeto de esa posicion
	 * en la lista loterias. 
	 * Se toman los atributos de los objetos y se actualizan por los 
	 * ingresados en los parametros de la funcion update, si no se 
	 * modifica un atributo, este se queda intacto.
	 */
	@Override
	public boolean update(int index, String... args) {
		if(index<0||index>=loterias.size())
			return false;
		else {
			if(!args[0].isBlank()||!args[0].isEmpty())
				loterias.get(index).setNombre(args[0]);
			if(!args[1].isBlank()||!args[1].isEmpty())
				loterias.get(index).setCedula(Long.parseLong(args[1]));
			if(!args[2].isBlank()||!args[2].isEmpty())
				loterias.get(index).setDiaSemana(args[2]);
			if(!args[3].isBlank()||!args[3].isEmpty())
				loterias.get(index).setValorApuesta(Integer.parseInt(args[3]));
			if(!args[4].isBlank()||!args[4].isEmpty())
				loterias.get(index).setNombreLoto(args[4]);
			if(!args[5].isBlank()||!args[5].isEmpty())
				loterias.get(index).setNum1(Integer.parseInt(args[5]));
			if(!args[6].isBlank()||!args[6].isEmpty())
				loterias.get(index).setNum2(Integer.parseInt(args[6]));
			if(!args[7].isBlank()||!args[7].isEmpty())
				loterias.get(index).setNum3(Integer.parseInt(args[7]));
			if(!args[8].isBlank()||!args[8].isEmpty())
				loterias.get(index).setNum4(Integer.parseInt(args[8]));
			if(!args[9].isBlank()||!args[9].isEmpty())
				loterias.get(index).setSer(Integer.parseInt(args[9]));
		}
		writeSerializable();
		return true;
	}
	/**
	 * Update toma el objeto o y lo busca en la lista loterias. 
	 * Se reemplaza el objeto en la posicion encontrada por el nuevo objeto o.
	 */
	@Override
	public void update(Object o) {
		int index = 0;
		for (int i = 0; i < loterias.size(); i++) {
			if (((ApuestaLoteriaDTO) o).equals(loterias.get(i))) {
				index = i;
			}
		}
		loterias.set(index, (ApuestaLoteriaDTO) o);
		writeSerializable();
	}
	/**
	 * Delete toma el indice index y elimina el objeto de esa posicion
	 * en la lista loterias
	 */
	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= loterias.size())
			return false;
		else {
			loterias.remove(index);
			writeSerializable();
			return true;
		}
	}
	/**
	 * Delete toma el objeto y verifica si esta en la
	 * en la lista loterias, si se encuentra en la lista
	 * este es eliminado
	 */
	@Override
	public boolean delete(Object o) {
		if (o == null)
			return false;
		else if (loterias.remove((ApuestaLoteriaDTO) o)) {
			writeSerializable();
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Retorna una nueva lista de objetos apuestaloteria, con
	 * las apuestas de este tipo realizadas por una persona con cedula 
	 * en concreto
	 * @param cedula - valor a comparar
	 * @return String con los datos de las apuestas unicas del usuario
	 */
	public String getLoteria(String cedula) {
		ArrayList<ApuestaLoteriaDTO> propLoterias = new ArrayList<>();
		for (ApuestaLoteriaDTO o : loterias) {
			if(Long.parseLong(cedula)==o.getCedula()) {
				propLoterias.add(o);
			}
		}
		String print = "";
		int index = 0;
		for (ApuestaLoteriaDTO s : propLoterias) {
			print += "\n" + index + ": " + s.toString();
			index++;
		}
		writeSerializable();
		return print;
	}
	public ApuestaLoteriaDTO getThisLoteria(int index, String cedula) {
		ArrayList<ApuestaLoteriaDTO> propLoterias = new ArrayList<>();
		for (ApuestaLoteriaDTO o : loterias) {
			if(Long.parseLong(cedula)==o.getCedula()) {
				propLoterias.add(o);
			}
		}
		return propLoterias.get(index);
	}
	
	public String getLastLoteria(String cedula) {
		ArrayList<ApuestaLoteriaDTO> propLoterias = new ArrayList<>();
		for (ApuestaLoteriaDTO o : loterias) {
			if(Long.parseLong(cedula)==o.getCedula()) {
				propLoterias.add(o);
			}
		}
		String print = "-> "+propLoterias.get(propLoterias.size()-1).toString();
		return print;
	}
	
	public ArrayList<ApuestaLoteriaDTO> returnPropLoto(String cedula){
		ArrayList<ApuestaLoteriaDTO> propLoterias = new ArrayList<>();
		for (ApuestaLoteriaDTO o : loterias) {
			if(Long.parseLong(cedula)==o.getCedula()) {
				propLoterias.add(o);
			}
		}
		return propLoterias;
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
		carritoLoterias.add(loterias.get(loterias.size()-1));
		writeSerializable();
	}
	public ArrayList<ApuestaLoteriaDTO> returnCarrito() {
		return carritoLoterias;
	}
	public void deleteCarrito() {
		int x = carritoLoterias.size();
		for (int i = 0; i < x; i++) {
			carritoLoterias.remove(0);
		}
		writeSerializable();
	}
}
