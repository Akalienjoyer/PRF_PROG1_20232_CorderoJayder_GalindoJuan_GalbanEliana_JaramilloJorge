package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ApostadorDTO;
import co.edu.unbosque.model.ApuestaBalotoDTO;
import co.edu.unbosque.model.ApuestaBetPlayDTO;
import co.edu.unbosque.model.ApuestaChanceDTO;
import co.edu.unbosque.model.ApuestaLoteriaDTO;
import co.edu.unbosque.model.ApuestaSuperastroDTO;
import co.edu.unbosque.model.JuegoDTO;

/**
 * Data Access Object de Juego.
 * @author JorgeJ
 */
public class JuegoDAO implements CRUDOperation{

	private ArrayList<JuegoDTO> juegos;
	private final String SERIAL_FILENAME = "juegos.dat";
	private String[] signos = { "Aries", "Acuario", "Sagitario", "Escorpio", "Leo", "Libra", "Virgo", "Piscis", "Geminis",
			"Tauro", "Cancer", "Capricornio" };
	private String[] betResults = {"Empate", "Local","Visitante"};
	private int[] resultados;
	/**
	 * Constructor que inicializa la lista juegos
	 */
	public JuegoDAO() {
		juegos = new ArrayList<>();
		resultados = new int[4];
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
			if(!args[0].isBlank()||!args[0].isEmpty())
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
	public String[] doLotery(ApuestaLoteriaDTO currentLoto) {
		double newSaldo = 0;
		int cif1 = (int) (Math.random() * 9 + 1), cif2 = (int) (Math.random() * 9 + 1),
				cif3 = (int) (Math.random() * 9 + 1), cif4 = (int) (Math.random() * 9 + 1);

		int dig1 = currentLoto.getNum1(), dig2 = currentLoto.getNum2(), dig3 = currentLoto.getNum3(), 
				dig4 = currentLoto.getNum4();

		while (true) {
			if (cif1 == dig1 && cif2 == dig2 && cif3 == dig3 && cif4 == dig4) {
				 newSaldo += 2000;
			}
			if (cif1 == dig1 || cif1 == dig2 || cif1 == dig3 || cif1 == dig4) {
				newSaldo += 100;
			}
			if (cif2 == dig1 || cif2 == dig2 || cif2 == dig3 || cif2 == dig4) {
				newSaldo += 100;
			}
			if (cif3 == dig1 || cif3 == dig2 || cif3 == dig3 || cif3 == dig4) {
				newSaldo += 100;
			}
			if (cif4 == dig1 || cif4 == dig2 || cif4 == dig3 || cif4 == dig4) {
				newSaldo += 100;
			}
			break;
		}
		
			int max = 999, min = 100;
			int ser1 = (int) (Math.random() * (max - min + 1) + min),
					ser2 = (int) (Math.random() * (max - min + 1) + min),
					ser3 = (int) (Math.random() * (max - min + 1) + min);

			if (currentLoto.getSer() == ser1 || currentLoto.getSer() == ser2 || currentLoto.getSer() == ser3) {
				newSaldo += 2000;
		
	}
			String[] data = new String[8];
			data[0] = Integer.toString(cif1); 
			data[1] = Integer.toString(cif2); 
			data[2] = Integer.toString(cif3); 
			data[3] = Integer.toString(cif4); 
			data[4] = Integer.toString(ser1); 
			data[5] = Integer.toString(ser2); 
			data[6] = Integer.toString(ser3); 
			data[7] = Double.toString(newSaldo); 
			
			resultados[0] = cif1;
			resultados[1] = cif2;
			resultados[2] = cif3;
			resultados[3] = cif4;
			writeSerializable();
			
	return data;
	}
	public String[] doSuperastro(ApuestaSuperastroDTO currentSuper) {
		double newSaldo = 0;
		int cif1 = (int) (Math.random() * 9 + 1), cif2 = (int) (Math.random() * 9 + 1),
				cif3 = (int) (Math.random() * 9 + 1), cif4 = (int) (Math.random() * 9 + 1);

		int dig1 = currentSuper.getNum1(), dig2 = currentSuper.getNum2(), dig3 = currentSuper.getNum3(), 
				dig4 = currentSuper.getNum4();

		while (true) {
			if (cif1 == dig1 && cif2 == dig2 && cif3 == dig3 && cif4 == dig4) {
				 newSaldo += 2000;
			}
			if (cif1 == dig1 || cif1 == dig2 || cif1 == dig3 || cif1 == dig4) {
				newSaldo += 100;
			}
			if (cif2 == dig1 || cif2 == dig2 || cif2 == dig3 || cif2 == dig4) {
				newSaldo += 100;
			}
			if (cif3 == dig1 || cif3 == dig2 || cif3 == dig3 || cif3 == dig4) {
				newSaldo += 100;
			}
			if (cif4 == dig1 || cif4 == dig2 || cif4 == dig3 || cif4 == dig4) {
				newSaldo += 100;
			}
			break;
		}
		
		int sigRan = (int) (Math.random() * 12);
		String signoAleatorio = signos[sigRan];
		if (currentSuper.getSigno().equalsIgnoreCase(signoAleatorio)) {
			newSaldo += 500;
			
	}
		String[] data = new String[6];
		data[0] = Integer.toString(cif1); 
		data[1] = Integer.toString(cif2); 
		data[2] = Integer.toString(cif3); 
		data[3] = Integer.toString(cif4); 
		data[4] = signoAleatorio;
		data[5] = Double.toString(newSaldo); 
		writeSerializable();
		
		return data;
	}
	public String[] doBaloto(ApuestaBalotoDTO currentBaloto) {
		double newSaldo = 0;
		int cif1 = (int) (Math.random() * 45 + 1), cif2 = (int) (Math.random() * 45 + 1),
				cif3 = (int) (Math.random() * 45 + 1), cif4 = (int) (Math.random() * 45 + 1),
				cif5 = (int) (Math.random() * 45 + 1), cif6 = (int) (Math.random() * 45 + 1);

		int dig1 = currentBaloto.getNum1(), dig2 = currentBaloto.getNum2(), dig3 = currentBaloto.getNum3(),
				dig4 = currentBaloto.getNum4(), dig5 = currentBaloto.getNum5(), dig6 = currentBaloto.getNum6();

		while (true) {
			if (cif1 == dig1 && cif2 == dig2 && cif3 == dig3 && cif4 == dig4 && cif5 == dig5 && cif5 == dig5) {
				newSaldo += 2000;
			}
			if (cif1 == dig1 || cif1 == dig2 || cif1 == dig3 || cif1 == dig4 || cif1 == dig5 || cif1 == dig6) {
				newSaldo += 100;
			}
			if (cif2 == dig1 || cif2 == dig2 || cif2 == dig3 || cif2 == dig4 || cif2 == dig5 || cif2 == dig6) {
				newSaldo += 100;
			}
			if (cif3 == dig1 || cif3 == dig2 || cif3 == dig3 || cif3 == dig4 || cif3 == dig5 || cif3 == dig6) {
				newSaldo += 100;
			}
			if (cif4 == dig1 || cif4 == dig2 || cif4 == dig3 || cif4 == dig4 || cif4 == dig5 || cif4 == dig6) {
				newSaldo += 100;
			}
			if (cif5 == dig1 || cif5 == dig2 || cif5 == dig3 || cif5 == dig4 || cif5 == dig5 || cif5 == dig6) {
				newSaldo += 100;
			}
			if (cif6 == dig1 || cif6 == dig2 || cif6 == dig3 || cif6 == dig4 || cif6 == dig5 || cif6 == dig6) {
				newSaldo += 100;
			}
			break;
		}
		String[] data = new String[7];
		data[0] = Integer.toString(cif1); 
		data[1] = Integer.toString(cif2); 
		data[2] = Integer.toString(cif3); 
		data[3] = Integer.toString(cif4);
		data[4] = Integer.toString(cif5);
		data[5] = Integer.toString(cif6);
		data[6] = Double.toString(newSaldo); 
		writeSerializable();
		
		return data;
	}
	public String[] doChance(ApuestaChanceDTO currentChance) {
		double newSaldo = 0;
		int cif1 = resultados[0], cif2 = resultados[1],
				cif3 = resultados[2], cif4 = resultados[3];

		int dig1 = currentChance.getNum1(), dig2 = currentChance.getNum2(), dig3 = currentChance.getNum3(), 
				dig4 = currentChance.getNum4();

		while (true) {
			if (cif1 == dig1 && cif2 == dig2 && cif3 == dig3 && cif4 == dig4) {
				 newSaldo += 2000;
			}
			if (cif1 == dig1 || cif1 == dig2 || cif1 == dig3 || cif1 == dig4) {
				newSaldo += 100;
			}
			if (cif2 == dig1 || cif2 == dig2 || cif2 == dig3 || cif2 == dig4) {
				newSaldo += 100;
			}
			if (cif3 == dig1 || cif3 == dig2 || cif3 == dig3 || cif3 == dig4) {
				newSaldo += 100;
			}
			if (cif4 == dig1 || cif4 == dig2 || cif4 == dig3 || cif4 == dig4) {
				newSaldo += 100;
			}
			break;
		}
		String[] data = new String[5];
		data[0] = Integer.toString(cif1); 
		data[1] = Integer.toString(cif2); 
		data[2] = Integer.toString(cif3); 
		data[3] = Integer.toString(cif4); 
		data[4] = Double.toString(newSaldo); 
		writeSerializable();
		return data;
	}
	public String[] doBetPlay(ApuestaBetPlayDTO currentBetPlay) {
		double newSaldo = 0;
		int res = (int) (Math.random() * 3);
		String resultado = betResults[res];
		if(currentBetPlay.getResultado().equals(resultado)) {
			newSaldo+=500;
		}
		String[] data = new String[3];
		data[0] = resultado;
		data[1] = currentBetPlay.getPartido();
		data[2] = Double.toString(newSaldo);
		return data;
	}
	public String showGameGudget(String game) {
		String print = "";
		for (JuegoDTO o : juegos) {
			if(o.getTipo().equals(game)) {
				print+=o.getPresupuesto();
			}
		}
		return print;
	}
}
