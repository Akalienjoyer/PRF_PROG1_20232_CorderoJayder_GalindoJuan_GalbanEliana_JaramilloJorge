package co.edu.unbosque.controller;

import java.util.Properties;
import java.util.Scanner;

import co.edu.unbosque.model.ApostadorDTO;
import co.edu.unbosque.model.persistence.ApostadorDAO;
import co.edu.unbosque.model.persistence.ApuestaBalotoDAO;
import co.edu.unbosque.model.persistence.ApuestaChanceDAO;
import co.edu.unbosque.model.persistence.ApuestaDAO;
import co.edu.unbosque.model.persistence.ReciboDAO;


/**
 * Controlador del aplicativo, conecta el modelo 
 * con la interfaz grafica
 * @author JorgeJ
 */
public class Controller {
	/**
	 * Instancias de clases y ventanas
	 */
	private Scanner sc;
	private ApuestaChanceDAO apuestaChanceDAO;
	private ApuestaBalotoDAO apuestaBalotoDAO;
	private ApuestaDAO apuestaDAO;
	private ApostadorDAO apostadorDAO;
	private ReciboDAO reciboDAO;
	/**
	 * Constructor que inicializa las clases y ventanas
	 */
	public Controller() {
		sc = new Scanner(System.in);
		apostadorDAO = new ApostadorDAO();
		apuestaBalotoDAO = new ApuestaBalotoDAO();
		apuestaChanceDAO = new ApuestaChanceDAO();
		reciboDAO = new ReciboDAO();
		apuestaDAO = new ApuestaDAO();
	}
	/**
	 * Metodo que da inicio al aplicativo, visibiliza la 
	 * primera ventana.
	 */
	public void run() {
		
		
	}
}
