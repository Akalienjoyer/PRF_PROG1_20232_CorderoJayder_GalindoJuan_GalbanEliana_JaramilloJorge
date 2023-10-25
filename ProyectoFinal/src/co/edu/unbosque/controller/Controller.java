package co.edu.unbosque.controller;

import java.util.Scanner;

import co.edu.unbosque.model.persistence.ApuestaDAO;

/**
 * Controlador del aplicativo, conecta el modelo 
 * con la interfaz grafica
 * @author JorgeJ
 */
public class Controller {
	/**
	 * Instancias de clases y ventanas
	 */
	private ApuestaDAO apDao;
	private Scanner sc;
	/**
	 * Constructor que inicializa las clases y ventanas
	 */
	public Controller() {
		apDao = new ApuestaDAO();
		sc = new Scanner(System.in);
	}
	/**
	 * Metodo que da inicio al aplicativo, visibiliza la 
	 * primera ventana.
	 */
	public void run() {
		/*String ubicacion = sc.nextLine();
		String empl = sc.nextLine();
		sDao.create(ubicacion, empl);
		System.out.println(sDao.readAll());*/
		
		/*String nombre = sc.nextLine();
		String cedula = sc.nextLine();
		String sede = sc.nextLine();
		String direccion = sc.nextLine();
		String celular = sc.nextLine();
		aDao.create(nombre,cedula,sede,direccion,celular);
		System.out.println(aDao.readAll());*/
		
		String nombre = sc.nextLine();
		String cedula = sc.nextLine();
		String diaSemana = sc.nextLine();
		String valorApuesta = sc.nextLine();
		apDao.create(nombre,cedula,diaSemana,valorApuesta);
		System.out.println(apDao.readAll());
	}
}
