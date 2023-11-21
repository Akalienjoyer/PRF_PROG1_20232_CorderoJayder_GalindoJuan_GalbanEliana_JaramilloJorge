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
import co.edu.unbosque.view.VentanaBaloto;
import co.edu.unbosque.view.VentanaBetplay;
import co.edu.unbosque.view.VentanaChance;
import co.edu.unbosque.view.VentanaDigitSede;
import co.edu.unbosque.view.VentanaGachapon;
import co.edu.unbosque.view.VentanaGestionesAdmin;
import co.edu.unbosque.view.VentanaInformacion;
import co.edu.unbosque.view.VentanaPrincipal;
import co.edu.unbosque.view.VentanaRegistroAtributos;
import co.edu.unbosque.view.VentanaRegistroContrasenia;
import co.edu.unbosque.view.VentanaSearchSede;
import co.edu.unbosque.view.VentanaSedes;
import co.edu.unbosque.view.VentanaSeleccionAdministrador;
import co.edu.unbosque.view.VentanaSeleccionJuegos;
import co.edu.unbosque.view.VentanaShowSede;
import co.edu.unbosque.view.VentanaSuperAstro;
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
				JOptionPane.showMessageDialog(vContrasenias, "La cedula solo consiste de numeros."
						,"Error",JOptionPane.ERROR_MESSAGE);
				vAtributos.getCedula().setText("");
				allInOrder = false;
			}
			String direccion = vAtributos.getDireccion().getText();
			String sede = vAtributos.getSedeJuego().getText();
			
			if(nombre.isEmpty()||cedula.isEmpty()||sede.isEmpty()||direccion.isEmpty()||celular.isEmpty()||
					nombre.isBlank()||cedula.isBlank()||sede.isBlank()||direccion.isBlank()||celular.isBlank()) {
				JOptionPane.showMessageDialog(vContrasenias, "Debe llenar todos los datos."
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
			int index = sedeDAO.returnIndex(vSearchSedeD.getUbicacion().getText());
			if(sedeDAO.delete(index)) {
				JOptionPane.showMessageDialog(vSearchSedeD, " Borrado con exito","Validacion",
						JOptionPane.INFORMATION_MESSAGE);
				vSearchSedeD.getUbicacion().setText("");
				vSearchSedeD.setVisible(false);
				vSedes.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(vSearchSedeD, "No existe una sede en esta ubicacion."
						,"Error",JOptionPane.ERROR_MESSAGE);
			}
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
