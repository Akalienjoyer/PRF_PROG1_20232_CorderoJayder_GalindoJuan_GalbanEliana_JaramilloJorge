package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import co.edu.unbosque.model.ApostadorDTO;
import co.edu.unbosque.model.persistence.ApostadorDAO;
import co.edu.unbosque.model.persistence.SedeDAO;
import co.edu.unbosque.util.CellPhoneFormatException;
import co.edu.unbosque.util.UnvalidNameException;
import co.edu.unbosque.view.VentanaApostadores;
import co.edu.unbosque.view.VentanaBaloto;
import co.edu.unbosque.view.VentanaBetplay;
import co.edu.unbosque.view.VentanaChance;
import co.edu.unbosque.view.VentanaCreacionApostador1;
import co.edu.unbosque.view.VentanaDigitSede;
import co.edu.unbosque.view.VentanaGachapon;
import co.edu.unbosque.view.VentanaGestionesAdmin;
import co.edu.unbosque.view.VentanaInformacion;
import co.edu.unbosque.view.VentanaPrincipal;
import co.edu.unbosque.view.VentanaRegistroAtributos;
import co.edu.unbosque.view.VentanaRegistroContrasenia;
import co.edu.unbosque.view.VentanaSearchApostador;
import co.edu.unbosque.view.VentanaSearchSede;
import co.edu.unbosque.view.VentanaSedes;
import co.edu.unbosque.view.VentanaSeleccionAdministrador;
import co.edu.unbosque.view.VentanaSeleccionJuegos;
import co.edu.unbosque.view.VentanaShowApostador;
import co.edu.unbosque.view.VentanaShowSede;
import co.edu.unbosque.view.VentanaSuperAstro;
import co.edu.unbosque.view.VentanaTablaApostadores;
import co.edu.unbosque.view.VentanaTablaSedes;
import co.edu.unbosque.view.VentanaTragaMoneda;
import co.edu.unbosque.view.VentanaInicioUsuario;
import co.edu.unbosque.view.VentanaLogin;
import co.edu.unbosque.view.VentanaLoteria;

public class Controller implements ActionListener {

	private VentanaPrincipal vPrincipal;
	private VentanaInformacion vInfo;
	
	private VentanaSeleccionAdministrador vSeleccionAdmin;
	private VentanaGestionesAdmin vGestionesAdmin;
	
	private VentanaInicioUsuario vUsuario;
	private VentanaSeleccionJuegos vSeleccionJuegos;
	
	private VentanaBaloto vBaloto;
	private VentanaSuperAstro vSuperAstro;
	private VentanaChance vChance;
	private VentanaLoteria vLoteria;
	private VentanaGachapon vGachapon;
	private VentanaBetplay vBetplay;
	private VentanaTragaMoneda vTragaMonedas;
	
	private VentanaLogin vLogin;
	
	private VentanaRegistroAtributos vAtributos;
	private VentanaRegistroContrasenia vContrasenias;
	
	private VentanaSedes vSedes;
	private VentanaDigitSede vDigitSede;
	private VentanaDigitSede vDigitSedeA;
	private VentanaSearchSede vSearchSede;
	private VentanaSearchSede vSearchSedeA;
	private VentanaSearchSede vSearchSedeD;
	private VentanaShowSede vShowSede;
	private VentanaTablaSedes vTablaSedes;
	
	private VentanaApostadores vApostadores;
	private VentanaCreacionApostador1 vCApostador1;	
	private VentanaCreacionApostador1 vCApostador1A;	
	private VentanaTablaApostadores vTablaApostadores;
	private VentanaSearchApostador vSearchApostador;
	private VentanaSearchApostador vSearchApostadorA;
	private VentanaSearchApostador vSearchApostadorD;
	private VentanaShowApostador vShowApostador;
	
	private ApostadorDAO apostadorDAO;
	
	private ApostadorDTO currentUser;
	
	private SedeDAO sedeDAO;
	
	public Controller() {
		
		vPrincipal = new VentanaPrincipal();
		vInfo = new VentanaInformacion();
		
		vSeleccionAdmin = new VentanaSeleccionAdministrador();
		vGestionesAdmin = new VentanaGestionesAdmin();
		
		vUsuario = new VentanaInicioUsuario();
		vSeleccionJuegos = new VentanaSeleccionJuegos();
		
		vBaloto = new VentanaBaloto();
		vSuperAstro = new VentanaSuperAstro();
		vChance = new VentanaChance();
		vLoteria = new VentanaLoteria();
		vGachapon = new VentanaGachapon();
		vBetplay = new VentanaBetplay();
		vTragaMonedas = new VentanaTragaMoneda();
		
		vSedes = new VentanaSedes();
		vDigitSede = new VentanaDigitSede("Crear");
		vSearchSede = new VentanaSearchSede("buscar");
		vSearchSedeA= new VentanaSearchSede("actualizar");
		vSearchSedeD= new VentanaSearchSede("borrar");
		vShowSede = new VentanaShowSede();
		vDigitSedeA = new VentanaDigitSede("Actualizar");
		
		vApostadores = new VentanaApostadores();
		vCApostador1 = new VentanaCreacionApostador1("creacion");
		vCApostador1A = new VentanaCreacionApostador1("  edicion");
		vSearchApostador = new VentanaSearchApostador("buscar");
		vSearchApostadorA = new VentanaSearchApostador("actualizar");
		vSearchApostadorD = new VentanaSearchApostador("borrar");
		vShowApostador = new VentanaShowApostador();
		
		vLogin = new VentanaLogin();
		
		vAtributos = new VentanaRegistroAtributos();
		vContrasenias = new VentanaRegistroContrasenia();
		
		apostadorDAO = new ApostadorDAO();
		
		currentUser = new ApostadorDTO();
		
		sedeDAO = new SedeDAO();
		agregarLectores();

	}

	public void run() {
		vPrincipal.setVisible(true);
	}

	public void agregarLectores() {

		// VENTANA PRINCIPAL ---------------------------------------

		vPrincipal.getJugador().addActionListener(this);
		vPrincipal.getJugador().setActionCommand("vPrincipalUsuario");

		vPrincipal.getGerente().addActionListener(this);
		vPrincipal.getGerente().setActionCommand("vPrincipalGerente");

		vPrincipal.getSalir().addActionListener(this);
		vPrincipal.getSalir().setActionCommand("vPrincipalSalir");

		// VENTANA USUARIO ---------------------------------------

		vUsuario.getInfo().addActionListener(this);
		vUsuario.getInfo().setActionCommand("vUsuarioInfo");

		vUsuario.getLogin().addActionListener(this);
		vUsuario.getLogin().setActionCommand("vUsuarioLogin");

		vUsuario.getRegister().addActionListener(this);
		vUsuario.getRegister().setActionCommand("vUsuarioRegister");
		
		vUsuario.getRegresar().addActionListener(this);
		vUsuario.getRegresar().setActionCommand("vUsuarioRegresar");
		
		// VENTANA ADMINISTRADOR ---------------------------------------
		
		vSeleccionAdmin.getGestionesAdmin().addActionListener(this);
		vSeleccionAdmin.getGestionesAdmin().setActionCommand("vGestionesAdmin");

		vSeleccionAdmin.getFacturarApuesta().addActionListener(this);
		vSeleccionAdmin.getFacturarApuesta().setActionCommand("vFacturarApuesta");
		
		vSeleccionAdmin.getGenerarRecibo().addActionListener(this);
		vSeleccionAdmin.getGenerarRecibo().setActionCommand("vGenerarRecibo");
		
		vSeleccionAdmin.getRegresar().addActionListener(this);
		vSeleccionAdmin.getRegresar().setActionCommand("vAdminRegresar");
		
		vGestionesAdmin.getRegresar().addActionListener(this);
		vGestionesAdmin.getRegresar().setActionCommand("vGestionesRegresar");
		
		vGestionesAdmin.getGesSedes().addActionListener(this);
		vGestionesAdmin.getGesSedes().setActionCommand("vGestionesSedes");
		
		vGestionesAdmin.getGesApostadores().addActionListener(this);
		vGestionesAdmin.getGesApostadores().setActionCommand("vGestionesApostadores");
		
		// VENTANA INFORMACION
		
		vInfo.getLogin().addActionListener(this);
		vInfo.getLogin().setActionCommand("vIngresarJuego");
		
		// VENTANA LOGIN INGRESAR ---------------------------------------
		
		vLogin.getIngresar().addActionListener(this);
		vLogin.getIngresar().setActionCommand("vLoginIngresar");
		
		vLogin.getRegresar().addActionListener(this);
		vLogin.getRegresar().setActionCommand("vLoginRegresar");
		
		
		// VENTANA REGISTER USUARIO ---------------------------------------
		
		vAtributos.getIngresar().addActionListener(this);
		vAtributos.getIngresar().setActionCommand("vRegistrarSiguiente");
		
		vAtributos.getRegresar().addActionListener(this);
		vAtributos.getRegresar().setActionCommand("vRegistrarRegresar");
			
			// CONTRASENIA -------------
		
		vContrasenias.getIngresar().addActionListener(this);
		vContrasenias.getIngresar().setActionCommand("vContraseniaSiguiente");
		
		vContrasenias.getRegresar().addActionListener(this);
		vContrasenias.getRegresar().setActionCommand("vContraseniaRegresar");
		
		// SELECCION DE JUEGOS
		
		vSeleccionJuegos.getBaloto().addActionListener(this);
		vSeleccionJuegos.getBaloto().setActionCommand("vBaloto");
		
		vSeleccionJuegos.getSuperAstro().addActionListener(this);
		vSeleccionJuegos.getSuperAstro().setActionCommand("vSuperAstro");
		
		vSeleccionJuegos.getChance().addActionListener(this);
		vSeleccionJuegos.getChance().setActionCommand("vChance");
		
		vSeleccionJuegos.getLoteria().addActionListener(this);
		vSeleccionJuegos.getLoteria().setActionCommand("vLoteria");
		
		vSeleccionJuegos.getGachapon().addActionListener(this);
		vSeleccionJuegos.getGachapon().setActionCommand("vGachapon");
		
		vSeleccionJuegos.getBetplay().addActionListener(this);
		vSeleccionJuegos.getBetplay().setActionCommand("vBetplay");
		
		vSeleccionJuegos.getTragaMonedas().addActionListener(this);
		vSeleccionJuegos.getTragaMonedas().setActionCommand("vTragaMonedas");
		
		vSeleccionJuegos.getVolverInicio().addActionListener(this);
		vSeleccionJuegos.getVolverInicio().setActionCommand("vSeleccionJuegosInicio");
		
		// VENTANAS YA DE LOS JUEGOS --------------------------------------
		
		// BALOTO
		
		vBaloto.getRegresar().addActionListener(this);
		vBaloto.getRegresar().setActionCommand("vBalotoRegresar");
		
		// SUPER ASTRO
		
		vSuperAstro.getRegresar().addActionListener(this);
		vSuperAstro.getRegresar().setActionCommand("vSuperAstroRegresar");
		
		// CHANCE
		
		vChance.getRegresar().addActionListener(this);
		vChance.getRegresar().setActionCommand("vChanceRegresar");
		
		// LOTERIA
		
		vLoteria.getRegresar().addActionListener(this);
		vLoteria.getRegresar().setActionCommand("vLoteriaRegresar");
		
		// GACHAPON
		
		vGachapon.getRegresar().addActionListener(this);
		vGachapon.getRegresar().setActionCommand("vGachaponRegresar");
		
		// BETPLAY
		
		vBetplay.getRegresar().addActionListener(this);
		vBetplay.getRegresar().setActionCommand("vBetplayRegresar");
		
		// TRAGA MONEDAS
		
		vTragaMonedas.getRegresar().addActionListener(this);
		vTragaMonedas.getRegresar().setActionCommand("vTragaMonedasRegresar");
		
		// VENTANA SEDES
		
		vSedes.getRegresar().addActionListener(this);
		vSedes.getRegresar().setActionCommand("vSedesRegresar");;
		
		vSedes.getCrear().addActionListener(this);
		vSedes.getCrear().setActionCommand("vSedesCrear");
		
		vDigitSede.getRegresar().addActionListener(this);
		vDigitSede.getRegresar().setActionCommand("vDigitSedeRegresar");
		
		vDigitSede.getIngresar().addActionListener(this);
		vDigitSede.getIngresar().setActionCommand("vDigitSedeIngresar");
		
		vSedes.getBuscar().addActionListener(this);
		vSedes.getBuscar().setActionCommand("vSedesBuscar");
		
		vSearchSede.getRegresar().addActionListener(this);
		vSearchSede.getRegresar().setActionCommand("vSearchSedeRegresar");
		
		vSearchSede.getIngresar().addActionListener(this);
		vSearchSede.getIngresar().setActionCommand("vSearchSedeIngresar");
		
		vShowSede.getRegresar().addActionListener(this);
		vShowSede.getRegresar().setActionCommand("vShowSedeRegresar");
		
		vSedes.getMostrar().addActionListener(this);
		vSedes.getMostrar().setActionCommand("vSedesMostrar");
		
		vSedes.getActualizar().addActionListener(this);
		vSedes.getActualizar().setActionCommand("vSedesActualizar");
		
		vSedes.getBorrar().addActionListener(this);
		vSedes.getBorrar().setActionCommand("vSedesBorrar");
		
		vSearchSedeA.getRegresar().addActionListener(this);
		vSearchSedeA.getRegresar().setActionCommand("vSearchSedeARegresar");
		
		vSearchSedeA.getIngresar().addActionListener(this);
		vSearchSedeA.getIngresar().setActionCommand("vSearchSedeAIngresar");
		
		vDigitSedeA.getIngresar().addActionListener(this);
		vDigitSedeA.getIngresar().setActionCommand("vDigitSedeAIngresar");
		
		vDigitSedeA.getRegresar().addActionListener(this);
		vDigitSedeA.getRegresar().setActionCommand("vDigitSedeARegresar");
		
		vSearchSedeD.getRegresar().addActionListener(this);
		vSearchSedeD.getRegresar().setActionCommand("vSearchSedeDRegresar");
		
		vSearchSedeD.getIngresar().addActionListener(this);
		vSearchSedeD.getIngresar().setActionCommand("vSearchSedeDIngresar");
		
		//VENTANAS APOSTADORES ----------------------------------------
		
		vApostadores.getRegresar().addActionListener(this);
		vApostadores.getRegresar().setActionCommand("vApostadoresRegresar");
		
		vApostadores.getCrear().addActionListener(this);
		vApostadores.getCrear().setActionCommand("vApostadoresCrear");
		
		vCApostador1.getRegresar().addActionListener(this);
		vCApostador1.getRegresar().setActionCommand("vCApostador1Regresar");
		
		vCApostador1.getIngresar().addActionListener(this);
		vCApostador1.getIngresar().setActionCommand("vCApostadorIngresar");
		
		vApostadores.getMostrar().addActionListener(this);
		vApostadores.getMostrar().setActionCommand("vApostadoresMostar");
		
		vApostadores.getActualizar().addActionListener(this);
		vApostadores.getActualizar().setActionCommand("vApostadoresActualizar");
		
		vCApostador1A.getRegresar().addActionListener(this);
		vCApostador1A.getRegresar().setActionCommand("vCApostadorARegresar");
		
		vCApostador1A.getIngresar().addActionListener(this);
		vCApostador1A.getIngresar().setActionCommand("vCApostadorAIngresar");
		
		vSearchApostadorA.getRegresar().addActionListener(this);
		vSearchApostadorA.getRegresar().setActionCommand("vSearchApostadorARegresar");
		
		vSearchApostadorA.getIngresar().addActionListener(this);
		vSearchApostadorA.getIngresar().setActionCommand("vSearchApostadorAIngresar");
		
		vSearchApostadorD.getRegresar().addActionListener(this);
		vSearchApostadorD.getRegresar().setActionCommand("vSearchApostadorDRegresar");
		
		vSearchApostadorD.getIngresar().addActionListener(this);
		vSearchApostadorD.getIngresar().setActionCommand("vSearchApostadorDIngresar");
		
		vSearchApostador.getRegresar().addActionListener(this);
		vSearchApostador.getRegresar().setActionCommand("vSearchApostadorRegresar");
		
		vSearchApostador.getIngresar().addActionListener(this);
		vSearchApostador.getIngresar().setActionCommand("vSearchApostadorIngresar");
		
		vApostadores.getBorrar().addActionListener(this);
		vApostadores.getBorrar().setActionCommand("vApostadoresBorrar");
		
		vApostadores.getBuscar().addActionListener(this);
		vApostadores.getBuscar().setActionCommand("vApostadoresBuscar");
		
		vShowApostador.getRegresar().addActionListener(this);
		vShowApostador.getRegresar().setActionCommand("vShowApostadorRegresar");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		// VENTANA PRINCIPAL -----------------------------------------

		case "vPrincipalUsuario": {
			vPrincipal.setVisible(false);
			vUsuario.setVisible(true);
			break;
		}

		case "vPrincipalGerente": {
			vPrincipal.setVisible(false);
			vSeleccionAdmin.setVisible(true);
			
			break;
		}

		case "vPrincipalSalir": {
			vPrincipal.setVisible(false);
			vPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			System.exit(0);
			break;
		}
		
		// VENTANA USUARIO -----------------------------------------

		case "vUsuarioInfo": {
			vUsuario.setVisible(false);
			vInfo.setVisible(true);
			break;
		}

		case "vUsuarioLogin": {
			vUsuario.setVisible(false);
			vLogin.setVisible(true);
			break;
		}
		case "vUsuarioRegister": {
			vUsuario.setVisible(false);
			vAtributos.setVisible(true);
			break;
		}
		
		case "vUsuarioRegresar": {
			vUsuario.setVisible(false);
			vPrincipal.setVisible(true);
			break;
		}
		
		// VENTANA LOGIN USUARIO ---------------------------------------
		
		case "vLoginIngresar": {
			String user = vLogin.getCampoUsuario().getText();
			String pass = vLogin.getCampoContrasenia().getText();
			currentUser = apostadorDAO.logIn(user, pass);
			if(currentUser==null) {
				JOptionPane.showMessageDialog(vLogin, "Contraseña y/o usuario incorrectos."
						,"Error",JOptionPane.ERROR_MESSAGE);
				vLogin.getCampoContrasenia().setText("");
			}else {
				JOptionPane.showMessageDialog(vLogin, " Ingresado con exito!","Validacion",JOptionPane.INFORMATION_MESSAGE);
				vLogin.getCampoUsuario().setText("");
				vLogin.getCampoContrasenia().setText("");
				vLogin.setVisible(false);
				vSeleccionJuegos.setVisible(true);
			}
			break;
		}
		
		case "vLoginRegresar": {
			vLogin.setVisible(false);
			vUsuario.setVisible(true);
			break;
		}
		
		// VENTANA REGISTER USUARIO ---------------------------------------
		
		case "vRegistrarSiguiente": {
			
			boolean allInOrder = true;
			String nombre = vAtributos.getNombreCompleto().getText();
			try {
				checkName(nombre);
			} catch (UnvalidNameException e1) {
				vAtributos.getNombreCompleto().setText("");
				allInOrder=false;
			}
			String celular = vAtributos.getCelular().getText();
			try {
				checkCellFormat(celular);
			} catch (Exception e1) {
				vAtributos.getCelular().setText("");
				allInOrder = false;
			}
			String cedula = vAtributos.getCedula().getText();
			try {
				Long.parseLong(cedula);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(vAtributos, "La cedula solo consiste de numeros."
						,"Error",JOptionPane.ERROR_MESSAGE);
				vAtributos.getCedula().setText("");
				allInOrder = false;
			}
			String direccion = vAtributos.getDireccion().getText();
			String sede = vAtributos.getSedeJuego().getText();
			if(sedeDAO.checkSede(sede)) {
				JOptionPane.showMessageDialog(vAtributos, "No existe esta sede."
						,"Error",JOptionPane.ERROR_MESSAGE);
				vAtributos.getSedeJuego().setText("");
				allInOrder = false;
			}
			
			if(nombre.isEmpty()||cedula.isEmpty()||sede.isEmpty()||direccion.isEmpty()||celular.isEmpty()||
					nombre.isBlank()||cedula.isBlank()||sede.isBlank()||direccion.isBlank()||celular.isBlank()) {
				JOptionPane.showMessageDialog(vAtributos, "Debe llenar todos los datos."
						,"Error",JOptionPane.ERROR_MESSAGE);
				allInOrder = false;
			}
			if(allInOrder) {
			vAtributos.setVisible(false);
			vContrasenias.setVisible(true);
			}
			break;
		}
		
		case "vRegistrarRegresar": {
			vAtributos.setVisible(false);
			vUsuario.setVisible(true);
			break;
		}
		
			// CONTRASENIA --------------
		
		case "vContraseniaSiguiente": {

			boolean allInOrder = true;
			String nombre = vAtributos.getNombreCompleto().getText();
			String cedula = vAtributos.getCedula().getText();
			String sede = vAtributos.getSedeJuego().getText();
			String direccion = vAtributos.getDireccion().getText();
			String celular = vAtributos.getCelular().getText();
			String contraseña = vContrasenias.getCampoContrasenia().getText();
			String respContraseña = vContrasenias.getCampoContraseniaVerificacion().getText();
			String user = vContrasenias.getCampoUsuario().getText();
			if(!apostadorDAO.checkUser(user)) {
				JOptionPane.showMessageDialog(vContrasenias, "Usuario existente."
						,"Error",JOptionPane.ERROR_MESSAGE);
				vContrasenias.getCampoUsuario().setText("");
				allInOrder = false;
			}
			if(apostadorDAO.checkPass(contraseña, respContraseña)==1) {
				JOptionPane.showMessageDialog(vContrasenias, "Las contraseñas no coinciden."
						,"Error",JOptionPane.ERROR_MESSAGE);
				vContrasenias.getCampoContrasenia().setText("");
				vContrasenias.getCampoContraseniaVerificacion().setText("");
				allInOrder = false;
			}else if(apostadorDAO.checkPass(contraseña, respContraseña)==2){
				JOptionPane.showMessageDialog(vContrasenias, "La contraseña debe tener 7 o  mas digitos."
						,"Error",JOptionPane.ERROR_MESSAGE);
				vContrasenias.getCampoContrasenia().setText("");
				vContrasenias.getCampoContraseniaVerificacion().setText("");
				allInOrder = false;
			}
			
			if(contraseña.isEmpty()||respContraseña.isEmpty()||user.isEmpty()||
					contraseña.isBlank()||respContraseña.isBlank()||user.isBlank()) {
				JOptionPane.showMessageDialog(vContrasenias, "Debe llenar todos los datos."
						,"Error",JOptionPane.ERROR_MESSAGE);
				allInOrder = false;
			}
			
			if(allInOrder) {
				apostadorDAO.create(nombre,cedula,sede,direccion,celular,contraseña,user);
				JOptionPane.showMessageDialog(vContrasenias, " Creado con exito!","Validacion",JOptionPane.INFORMATION_MESSAGE);
				vAtributos.getNombreCompleto().setText("");
				vAtributos.getCedula().setText("");
				vAtributos.getSedeJuego().setText("");
				vAtributos.getDireccion().setText("");
				vAtributos.getCelular().setText("");
				vContrasenias.getCampoContrasenia().setText("");
				vContrasenias.getCampoContraseniaVerificacion().setText("");
				vContrasenias.getCampoUsuario().setText("");
				vContrasenias.setVisible(false);
				vUsuario.setVisible(true);
			}
			
			break;
		}
		
		case "vContraseniaRegresar": {
			vContrasenias.setVisible(false);
			vAtributos.setVisible(true);
			break;
		}
		
		// SELECCION DE ADMINISTRADOR ---------------------------------------
		
		case "vGestionesAdmin": {
			vSeleccionAdmin.setVisible(false);
			vGestionesAdmin.setVisible(true);
			break;
		}
		
		case "vFacturarApuesta": {
			break;
		}
		
		case "vGenerarRecibo": {
			break;
		}
		
		case "vAdminRegresar": {
			vSeleccionAdmin.setVisible(false);
			vPrincipal.setVisible(true);
			break;
		}
		
		// SELECCION DE GESTIONES ---------------------------------------
		
		case "vGestionesRegresar": {
			vGestionesAdmin.setVisible(false);
			vSeleccionAdmin.setVisible(true);
			break;
		}
		
		case "vGestionesSedes":{
			vGestionesAdmin.setVisible(false);
			vSedes.setVisible(true);
			 break;
		}
		// VENTANA SEDES ------------------------------------------------
		
		case "vSedesRegresar":{
			vSedes.setVisible(false);
			vGestionesAdmin.setVisible(true);
			break;
		}
		
		case "vSedesCrear":{
			vSedes.setVisible(false);
			vDigitSede.setVisible(true);
			break;
		}
		
		case "vDigitSedeRegresar":{
			vDigitSede.setVisible(false);
			vSedes.setVisible(true);
			break;
		}
		
		case "vDigitSedeIngresar":{
			boolean allInOrder = true;
			String ubicacion = vDigitSede.getUbicacion().getText();
			String empleados = vDigitSede.getempleados().getText();
			try {
				Integer.parseInt(empleados);
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(vDigitSede, "Digite un numero entero en al casilla de empleados."
						,"Error",JOptionPane.ERROR_MESSAGE);
				vDigitSede.getempleados().setText("");
				allInOrder = false;
			}
			if(ubicacion.isEmpty()||empleados.isEmpty()||ubicacion.isBlank()||empleados.isBlank()) {
				JOptionPane.showMessageDialog(vDigitSede, "Debe llenar todos los datos."
						,"Error",JOptionPane.ERROR_MESSAGE);
				allInOrder = false;
			}
			if(!sedeDAO.checkSede(ubicacion)) {
				JOptionPane.showMessageDialog(vDigitSede, "Ya existe una sede en esa ubicacion."
						,"Error",JOptionPane.ERROR_MESSAGE);
				vDigitSede.getUbicacion().setText("");
				allInOrder = false;
			}
			if(allInOrder) {
				sedeDAO.create(ubicacion,empleados);
				JOptionPane.showMessageDialog(vDigitSede, " Creado con exito!","Validacion",JOptionPane.INFORMATION_MESSAGE);
				vDigitSede.getUbicacion().setText("");
				vDigitSede.getempleados().setText("");
				vDigitSede.setVisible(false);
				vSedes.setVisible(true);
			}
			break;
		}
		
		case "vSedesBuscar":{
			vSedes.setVisible(false);
			vSearchSede.setVisible(true);
			break;
		}
		case "vSearchSedeRegresar":{
			vSearchSede.setVisible(false);
			vSedes.setVisible(true);
			break;
		}
		case "vSearchSedeIngresar":{
			String ubicacion = vSearchSede.getUbicacion().getText();
			if(sedeDAO.getSede(ubicacion)!=null) {
				vShowSede.uploadData(sedeDAO.getSede(ubicacion));
				vSearchSede.setVisible(false);
				vShowSede.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(vSearchSede, "No existe una sede en esta ubicacion."
						,"Error",JOptionPane.ERROR_MESSAGE);
				vSearchSede.getUbicacion().setText("");
			}
			break;
		}
		case "vShowSedeRegresar":{
			vShowSede.setVisible(false);
			vSearchSede.setVisible(true);
			break;
		}
		case "vSedesMostrar":{
			vTablaSedes = new VentanaTablaSedes(sedeDAO.returnList());
			
			vTablaSedes.setVisible(true);
			break;
		}
		case "vSedesActualizar":{
			vSedes.setVisible(false);
			vSearchSedeA.setVisible(true);
			break;
		}
		case "vSearchSedeARegresar":{
			vSearchSedeA.setVisible(false);
			vSedes.setVisible(true);
			break;
		}
		case "vSearchSedeAIngresar":{
			String ubicacion = vSearchSedeA.getUbicacion().getText();
			if(sedeDAO.getSede(ubicacion)!=null) {
				
				JOptionPane.showMessageDialog(vSearchSedeA, " A continuacion digite los nuevos datos","Validacion",
						JOptionPane.INFORMATION_MESSAGE);
				vSearchSedeA.setVisible(false);
				vDigitSedeA.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(vSearchSedeA, "No existe una sede en esta ubicacion."
						,"Error",JOptionPane.ERROR_MESSAGE);
				
			}
			break;
		}
		case "vDigitSedeAIngresar":{
			boolean allInOrder = true;
			int index = sedeDAO.returnIndex(vSearchSedeA.getUbicacion().getText());
			String empleados = vDigitSedeA.getempleados().getText();
			try {
				Integer.parseInt(empleados);
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(vDigitSedeA, "Digite un numero entero en al casilla de empleados."
						,"Error",JOptionPane.ERROR_MESSAGE);
				vDigitSedeA.getempleados().setText("");
				allInOrder = false;
			}
			if(allInOrder) {
			if(sedeDAO.update(index, empleados)) {
			JOptionPane.showMessageDialog(vDigitSedeA, " Actualizado con exito","Validacion",
					JOptionPane.INFORMATION_MESSAGE);
			vSearchSedeA.getUbicacion().setText("");
			vDigitSedeA.getUbicacion().setText("");
			vDigitSedeA.setVisible(false);
			vSedes.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(vDigitSedeA, "No se pudo actualizar."
						,"Error",JOptionPane.ERROR_MESSAGE);
			}
			}
			break;
		}
		case "vDigitSedeARegresar":{
			vDigitSedeA.setVisible(false);
			vSearchSedeA.setVisible(true);
			break;
		}
		case "vSedesBorrar":{
			vSedes.setVisible(false);
			vSearchSedeD.setVisible(true);
			break;
		}
		case "vSearchSedeDRegresar":{
			vSearchSedeD.setVisible(false);
			vSedes.setVisible(true);
			break;
		}
		case "vSearchSedeDIngresar":{
			int index =  sedeDAO.returnIndex(vSearchSedeD.getUbicacion().getText());
			if(sedeDAO.delete(index)) {
				JOptionPane.showMessageDialog(vSearchSedeD, " Borrado con exito","Validacion",
						JOptionPane.INFORMATION_MESSAGE);
				vSearchSedeD.getUbicacion().setText("");
				vSearchSedeD.setVisible(false);
				vSedes.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(vSearchSedeD, "No se pudo borrar."
						,"Error",JOptionPane.ERROR_MESSAGE);
			}
			break;
		}
		
		// VENTANAS APOSTADORES ----------------------------------------
		
		case "vApostadoresRegresar":{
			vApostadores.setVisible(false);
			vGestionesAdmin.setVisible(true);
			break;
		}
		case "vGestionesApostadores":{
			vGestionesAdmin.setVisible(false);
			vApostadores.setVisible(true);
			break;
		}
		case "vApostadoresCrear":{
			vApostadores.setVisible(false);
			vCApostador1.setVisible(true);
			break;
		}
		case "vCApostador1Regresar":{
			vCApostador1.setVisible(false);
			vApostadores.setVisible(true);
			break;
		}
		case "vCApostadorIngresar":{
			boolean allInOrder = true;
			String nombre = vCApostador1.getNombreCompleto().getText();
			try {
				checkName(nombre);
			} catch (UnvalidNameException e1) {
				vCApostador1.getNombreCompleto().setText("");
				allInOrder=false;
			}
			String celular = vCApostador1.getCelular().getText();
			try {
				checkCellFormat(celular);
			} catch (Exception e1) {
				vCApostador1.getCelular().setText("");
				allInOrder = false;
			}
			String cedula = vCApostador1.getCedula().getText();
			try {
				Long.parseLong(cedula);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(vCApostador1, "La cedula solo consiste de numeros."
						,"Error",JOptionPane.ERROR_MESSAGE);
				vCApostador1.getCedula().setText("");
				allInOrder = false;
			}
			String direccion = vCApostador1.getDireccion().getText();
			String sede = vCApostador1.getSedeJuego().getText();
			if(sedeDAO.checkSede(sede)) {
				JOptionPane.showMessageDialog(vCApostador1, "No existe esta sede."
						,"Error",JOptionPane.ERROR_MESSAGE);
				vCApostador1.getSedeJuego().setText("");
				allInOrder= false;
			}
			if(nombre.isEmpty()||cedula.isEmpty()||sede.isEmpty()||direccion.isEmpty()||celular.isEmpty()||
					nombre.isBlank()||cedula.isBlank()||sede.isBlank()||direccion.isBlank()||celular.isBlank()) {
				JOptionPane.showMessageDialog(vCApostador1, "Debe llenar todos los datos."
						,"Error",JOptionPane.ERROR_MESSAGE);
				allInOrder = false;
			}
			if(allInOrder) {
				apostadorDAO.create(nombre,cedula,sede,direccion,celular,"N/A","N/A");
				JOptionPane.showMessageDialog(vCApostador1, " Creado con exito!","Validacion",JOptionPane.INFORMATION_MESSAGE);
				vCApostador1.getNombreCompleto().setText("");
				vCApostador1.getCedula().setText("");
				vCApostador1.getSedeJuego().setText("");
				vCApostador1.getDireccion().setText("");
				vCApostador1.getCelular().setText("");
			vCApostador1.setVisible(false);
			vApostadores.setVisible(true);
			}
		break;
		}
		case "vApostadoresMostar":{
			vTablaApostadores = new VentanaTablaApostadores(apostadorDAO.returnList());
			vTablaApostadores.setVisible(true);
			break;
		}
		case "vApostadoresActualizar":{
			vApostadores.setVisible(false);
			vSearchApostadorA.setVisible(true);
			break;
		}
		case "vCApostadorARegresar":{
			vCApostador1A.setVisible(false);
			vSearchApostador.setVisible(true);
			break;
		}
		case "vCApostadorAIngresar":{
			boolean allInOrder = true;
			String nombre = vCApostador1A.getNombreCompleto().getText();
			try {
				checkName(nombre);
			} catch (UnvalidNameException e1) {
				vCApostador1A.getNombreCompleto().setText("");
				allInOrder=false;
			}
			String celular = vCApostador1A.getCelular().getText();
			try {
				checkCellFormat(celular);
			} catch (Exception e1) {
				vCApostador1A.getCelular().setText("");
				allInOrder = false;
			}
			String cedula = vCApostador1A.getCedula().getText();
			try {
				Long.parseLong(cedula);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(vCApostador1A, "La cedula solo consiste de numeros."
						,"Error",JOptionPane.ERROR_MESSAGE);
				vCApostador1A.getCedula().setText("");
				allInOrder = false;
			}
			String direccion = vCApostador1A.getDireccion().getText();
			String sede = vCApostador1A.getSedeJuego().getText();
			if(sedeDAO.checkSede(sede)) {
				JOptionPane.showMessageDialog(vCApostador1A, "No existe esta sede."
						,"Error",JOptionPane.ERROR_MESSAGE);
				vCApostador1A.getSedeJuego().setText("");
				allInOrder= false;
			}
			
			if(nombre.isEmpty()||cedula.isEmpty()||sede.isEmpty()||direccion.isEmpty()||celular.isEmpty()||
					nombre.isBlank()||cedula.isBlank()||sede.isBlank()||direccion.isBlank()||celular.isBlank()) {
				JOptionPane.showMessageDialog(vCApostador1A, "Debe llenar todos los datos."
						,"Error",JOptionPane.ERROR_MESSAGE);
				allInOrder = false;
			}
			if(allInOrder) {
				apostadorDAO.create(nombre,cedula,sede,direccion,celular,"N/A","N/A");
				JOptionPane.showMessageDialog(vCApostador1A, " Actualizado con exito!","Validacion",JOptionPane.INFORMATION_MESSAGE);
				vCApostador1A.getNombreCompleto().setText("");
				vCApostador1A.getCedula().setText("");
				vCApostador1A.getSedeJuego().setText("");
				vCApostador1A.getDireccion().setText("");
				vCApostador1A.getCelular().setText("");
				vCApostador1A.setVisible(false);
				vApostadores.setVisible(true);
			}
		break;
		}
		case "vSearchApostadorARegresar":{
			vSearchApostadorA.setVisible(false);
			vApostadores.setVisible(true);
			break;
		}
		case "vSearchApostadorAIngresar":{
			boolean allInOrder = true;
			String cedula = vSearchApostadorA.getcedula().getText();
			try {
				Long.parseLong(cedula);
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(vSearchApostadorA, "La cedula solo consiste de numeros."
						,"Error",JOptionPane.ERROR_MESSAGE);
				vSearchApostadorA.getcedula().setText("");
				allInOrder = false;
			}
			if(allInOrder) {
			if(apostadorDAO.getApostador(cedula)!=null) {
				
				JOptionPane.showMessageDialog(vSearchApostadorA, " A continuacion digite los nuevos datos","Validacion",
						JOptionPane.INFORMATION_MESSAGE);
				vSearchApostadorA.setVisible(false);
				vCApostador1A.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(vSearchApostadorA, "No existe este apostador."
						,"Error",JOptionPane.ERROR_MESSAGE);
				
			}
			}
			break;
		}
		case "vApostadoresBorrar":{
			vApostadores.setVisible(false);
			vSearchApostadorD.setVisible(true);
			break;
		}
		case "vSearchApostadorDRegresar":{
			vSearchApostadorD.setVisible(false);
			vApostadores.setVisible(true);
			break;
		}
		case "vSearchApostadorDIngresar":{
			int index =  apostadorDAO.returnIndex(vSearchApostadorD.getcedula().getText());
			if(apostadorDAO.delete(index)) {
				JOptionPane.showMessageDialog(vSearchApostadorD, " Borrado con exito","Validacion",
						JOptionPane.INFORMATION_MESSAGE);
				vSearchApostadorD.getcedula().setText("");
				vSearchApostadorD.setVisible(false);
				vApostadores.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(vSearchApostadorD, "No se pudo borrar."
						,"Error",JOptionPane.ERROR_MESSAGE);
				vSearchApostadorD.getcedula().setText("");
			}
			break;
		}
		case "vApostadoresBuscar":{
			vApostadores.setVisible(false);
			vSearchApostador.setVisible(true);
			break;
		}
		
		case "vSearchApostadorRegresar":{
			vSearchApostador.setVisible(false);
			vApostadores.setVisible(true);
			break;
		}
		
		case "vSearchApostadorIngresar":{
			String cedula = vSearchApostador.getcedula().getText();
			if(apostadorDAO.getApostador(cedula)!=null) {
				vShowApostador.uploadData(apostadorDAO.getApostador(cedula));
				vSearchApostador.setVisible(false);
				vShowApostador.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(vSearchApostador, "No existe una sede en esta ubicacion."
						,"Error",JOptionPane.ERROR_MESSAGE);
				vSearchApostador.getcedula().setText("");
			}
			break;
		}
		case "vShowApostadorRegresar":{
			vShowApostador.setVisible(false);
			vSearchApostador.setVisible(true);
			break;
		}
		
		// VENTANA INFORMACION  ---------------------------------------
		
		case "vIngresarJuego": {
			vInfo.setVisible(false);
			vUsuario.setVisible(true);
			break;
		}
		
		// VENTANA SELECCION DE JUEGOS   ---------------------------------------
		
		case "vBaloto": {
			vSeleccionJuegos.setVisible(false);
			vBaloto.setVisible(true);
			break;
		}
		
		case "vSuperAstro": {
			vSeleccionJuegos.setVisible(false);
			vSuperAstro.setVisible(true);
			break;
		}
		
		case "vChance": {
			vSeleccionJuegos.setVisible(false);
			vChance.setVisible(true);
			break;
		}
		
		case "vLoteria": {
			vSeleccionJuegos.setVisible(false);
			vLoteria.setVisible(true);
			break;
		}
		
		case "vBetplay": {
			vSeleccionJuegos.setVisible(false);
			vBetplay.setVisible(true);
			break;
		}
		
		case "vGachapon": {
			vSeleccionJuegos.setVisible(false);
			vGachapon.setVisible(true);
			break;
		}
		
		case "vTragaMonedas": {
			vSeleccionJuegos.setVisible(false);
			vTragaMonedas.setVisible(true);
			break;
		}
		
		case "vSeleccionJuegosInicio": {
			vSeleccionJuegos.setVisible(false);
			vUsuario.setVisible(true);
			break;
		}
		
		// VENTANAS YA DE LOS JUEGOS -------------------------------------------------------------------
		
		// VENTANA BALOTO
		
		case "vBalotoRegresar": {
			vBaloto.setVisible(false);
			vSeleccionJuegos.setVisible(true);
			break;
		}
		
		// VENTANA SUPER ASTRO
		
		case "vSuperAstroRegresar": {
			vSuperAstro.setVisible(false);
			vSeleccionJuegos.setVisible(true);
			break;
		}
		
		// VENTANA CHANCE
		
		case "vChanceRegresar": {
			vChance.setVisible(false);
			vSeleccionJuegos.setVisible(true);
			break;
		}
		
		// VENTANA LOTERIA
		
		case "vLoteriaRegresar": {
			vLoteria.setVisible(false);
			vSeleccionJuegos.setVisible(true);
			break;
		}
		
		// VENTANA GACHAPON
		
		case "vGachaponRegresar": {
			vGachapon.setVisible(false);
			vSeleccionJuegos.setVisible(true);
			break;
		}
		
		// VENTANA BETPLAY
		
		case "vBetplayRegresar": {
			vBetplay.setVisible(false);
			vSeleccionJuegos.setVisible(true);
			break;
		}
		
		// VENTANA TRAGA MONEDAS
		
		case "vTragaMonedasRegresar": {
			vTragaMonedas.setVisible(false);
			vSeleccionJuegos.setVisible(true);
			break;
		}
		
		// DEFAULT ---------------------------------------

		default: {
			JOptionPane.showMessageDialog(vPrincipal, "INGRESA UNA OPCION VALIDA");
		}

		}
	}
	
	// EXCEPTIONS ------------------------------------------
	public void checkName(String data) throws UnvalidNameException{
		for (char c: data.toCharArray()) {
			if(!Character.isAlphabetic(c)&&!Character.isWhitespace(c)) {
				JOptionPane.showMessageDialog(vContrasenias, "Ningun nombre puede tener numeros o simbolos."
						,"Error - Name",JOptionPane.ERROR_MESSAGE);
				throw new UnvalidNameException("Ningun nombre puede tener numeros o simbolos.");
			}
		}
	}
	public void checkCellFormat(String data) throws CellPhoneFormatException{
		int count = 0;
		try {
			Long.parseLong(data);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(vContrasenias, "Un numero de celular solo consiste de numeros."
					,"Error - Name",JOptionPane.ERROR_MESSAGE);
			throw new CellPhoneFormatException("Un numero de celular solo consiste de numeros.");
		}
		int n = data.toCharArray().length;
		for (int i = 0; i<n;i++) {
				count++;
		}
		if(count!=10) {
			JOptionPane.showMessageDialog(vContrasenias, "Un numero de celular Colombiano tiene 10 digitos."
					,"Error - Name",JOptionPane.ERROR_MESSAGE);
			throw new CellPhoneFormatException("Un numero de celular Colombiano tiene 10 digitos.");
		}
		
	}
	
}
