package co.edu.unbosque.controller;

import java.util.Properties;
import java.util.Scanner;

import co.edu.unbosque.model.ApostadorDTO;
import co.edu.unbosque.model.ApuestaLoteriaDTO;
import co.edu.unbosque.model.persistence.ApostadorDAO;
import co.edu.unbosque.model.persistence.ApuestaBalotoDAO;
import co.edu.unbosque.model.persistence.ApuestaChanceDAO;
import co.edu.unbosque.model.persistence.ApuestaDAO;
import co.edu.unbosque.model.persistence.ApuestaLoteriaDAO;
import co.edu.unbosque.model.persistence.JuegoDAO;
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
	private ApuestaDAO apuestaDAO;
	private ApuestaLoteriaDAO apuestaLoteriaDAO;
	private ApostadorDAO apostadorDAO;
	private ReciboDAO reciboDAO;
	private JuegoDAO juegoDAO;
	/**
	 * Constructor que inicializa las clases y ventanas
	 */
	public Controller() {
		sc = new Scanner(System.in);
		apostadorDAO = new ApostadorDAO();
		apuestaLoteriaDAO = new ApuestaLoteriaDAO();
		
		reciboDAO = new ReciboDAO();
		apuestaDAO = new ApuestaDAO();
		juegoDAO = new JuegoDAO();
	}
	/**
	 * Metodo que da inicio al aplicativo, visibiliza la 
	 * primera ventana.
	 */
	public void run() {
		
		/*System.out.println(apostadorDAO.readAll());
		System.out.println("Crear usuario: ");
		String nombre = sc.nextLine();
		String cedula = sc.nextLine();
		String sede = sc.nextLine();
		String direccion = sc.nextLine();
		String celular = sc.nextLine();
		String usuario = sc.nextLine();
		String pass = sc.nextLine();
		apostadorDAO.create(nombre,cedula,sede,direccion,celular,pass,usuario);*/
					
		System.out.println(apostadorDAO.readAll());
				
		System.out.println("Log in: ");
		System.out.println("Usuario: ");
		String user = sc.nextLine();
		System.out.println("Contraseña: ");
		String con = sc.nextLine();
		ApostadorDTO currentUser = apostadorDAO.logIn(user, con);
		if(currentUser!=null) {
			System.out.println("Ingresado con exito");
		}
		System.out.println("Depocite dinero: ");
		double plusSaldo = sc.nextDouble();
		sc.nextLine();
		apostadorDAO.actualizarSaldo(plusSaldo, Long.toString(currentUser.getCedula()));
		
		System.out.println(currentUser.getSaldo());
		System.out.println("Realiar apuesta loteria: ");
		System.out.println("Dia de la semana: ");
		String dia = sc.nextLine();
		
		lotoLoop: while(true) {
		System.out.println("Valor: ");
		String valor = sc.nextLine();
		System.out.println("Nombre loteria: ");
		String loto = sc.nextLine();
		System.out.println("Numero 1:");
		String num1 = sc.nextLine();
		System.out.println("Numero 2:");
		String num2 = sc.nextLine();
		System.out.println("Numero 3:");
		String num3 = sc.nextLine();
		System.out.println("Numero 4:");
		String num4 = sc.nextLine();
		System.out.println("Serie: ");
		String ser = sc.nextLine();
		if(apuestaLoteriaDAO.checkValor(valor, currentUser.getSaldo())==0) {
			System.out.println("La puesta debe ser mayor a 200");
		}
		else if(apuestaLoteriaDAO.checkValor(valor, currentUser.getSaldo())==1){
			System.out.println("No tiene saldo suficiente para hacer la apuesta");
		}else {
			apuestaLoteriaDAO.create(currentUser.getSede(),Long.toString(currentUser.getCedula()),dia,valor,loto,num1,num2,num3,num4,ser);
			System.out.println("Creada con exito");
			break lotoLoop;
		}
		}
		System.out.println("Recibo:");
		reciboDAO.trueCreate(Long.toString(currentUser.getCedula()), apuestaDAO.getAllBets(null, 
				apuestaLoteriaDAO.returnPropLoto(Long.toString(currentUser.getCedula())), null, null, null));
		System.out.println(reciboDAO.getLastRecibo(Long.toString(currentUser.getCedula())));
		
		System.out.println("Resultados loteria !!!");
		System.out.println("\nSeleccione loteria");
		System.out.println(apuestaLoteriaDAO.getLoteria(Long.toString(currentUser.getCedula())));
		int opcLoto = sc.nextInt();
		int[] data = juegoDAO.doLotery(currentUser, apuestaLoteriaDAO.getThisLoteria(opcLoto, Long.toString(currentUser.getCedula())));
		System.out.println("Numeros ganadores: \n"+data[0]+" \n"+data[1]+" \n"+data[2]+" \n"+data[3]+"\nSeries ganadoras: \n"+data[4]+"\n"+data[5]+"\n"+data[6]);
		System.out.println("Se ha sumado a tu saldo "+data[7]+" pesos");
		double newSaldo = data[7];
		apostadorDAO.actualizarSaldo(newSaldo, Long.toString(currentUser.getCedula()));
		System.out.println(apostadorDAO.readAll());
		System.out.println(apostadorDAO.searchAndGet(Long.toString(currentUser.getCedula())).getSaldo());
		
		
	}
}
