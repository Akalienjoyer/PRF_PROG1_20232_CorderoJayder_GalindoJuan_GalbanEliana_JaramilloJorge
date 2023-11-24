package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import co.edu.unbosque.model.ApostadorDTO;
import co.edu.unbosque.model.ApuestaBalotoDTO;
import co.edu.unbosque.model.ApuestaBetPlayDTO;
import co.edu.unbosque.model.ApuestaChanceDTO;
import co.edu.unbosque.model.ApuestaDTO;
import co.edu.unbosque.model.ApuestaLoteriaDTO;
import co.edu.unbosque.model.ApuestaSuperastroDTO;
import co.edu.unbosque.model.ReciboDTO;
import co.edu.unbosque.model.persistence.ApostadorDAO;
import co.edu.unbosque.model.persistence.ApuestaBalotoDAO;
import co.edu.unbosque.model.persistence.ApuestaBetPlayDAO;
import co.edu.unbosque.model.persistence.ApuestaChanceDAO;
import co.edu.unbosque.model.persistence.ApuestaDAO;
import co.edu.unbosque.model.persistence.ApuestaLoteriaDAO;
import co.edu.unbosque.model.persistence.ApuestaSuperastroDAO;
import co.edu.unbosque.model.persistence.JuegoDAO;
import co.edu.unbosque.model.persistence.ReciboDAO;
import co.edu.unbosque.model.persistence.SedeDAO;
import co.edu.unbosque.util.CellPhoneFormatException;
import co.edu.unbosque.util.UnvalidNameException;
import co.edu.unbosque.util.UnvalidSerieFormatException;
import co.edu.unbosque.view.VentanaActualizarSede;
import co.edu.unbosque.view.VentanaApostadores;
import co.edu.unbosque.view.VentanaBaloto;
import co.edu.unbosque.view.VentanaBetplay;
import co.edu.unbosque.view.VentanaBuscarActualizarApostador;
import co.edu.unbosque.view.VentanaBuscarActualizarSede;
import co.edu.unbosque.view.VentanaChance;
import co.edu.unbosque.view.VentanaClientesSede;
import co.edu.unbosque.view.VentanaConsultas;
import co.edu.unbosque.view.VentanaCreacionApostador;
import co.edu.unbosque.view.VentanaCrearSede;
import co.edu.unbosque.view.VentanaDetalleApuestas;
import co.edu.unbosque.view.VentanaBuscarDetalleApuestas;
import co.edu.unbosque.view.VentanaBuscarDetalleApuestasCliente;
import co.edu.unbosque.view.VentanaBuscarDetallerApuestasJuego;
import co.edu.unbosque.view.VentanaBuscarDetallerApuestasSede;
import co.edu.unbosque.view.VentanaFacturarSuperastro;
import co.edu.unbosque.view.VentanaEditarCasa;
import co.edu.unbosque.view.VentanaFacturarApuesta;
import co.edu.unbosque.view.VentanaFacturarBaloto;
import co.edu.unbosque.view.VentanaFacturarBetplay;
import co.edu.unbosque.view.VentanaFacturarChance;
import co.edu.unbosque.view.VentanaFacturarLoteria;
import co.edu.unbosque.view.VentanaEdicionApostador;
import co.edu.unbosque.view.VentanaGachapon;
import co.edu.unbosque.view.VentanaGestionesAdmin;
import co.edu.unbosque.view.VentanaInformacion;
import co.edu.unbosque.view.VentanaPrincipal;
import co.edu.unbosque.view.VentanaTablaRecibo;
import co.edu.unbosque.view.VentanaRegistroAtributos;
import co.edu.unbosque.view.VentanaRegistroContrasenia;
import co.edu.unbosque.view.VentanaBuscarApostador;
import co.edu.unbosque.view.VentanaBuscarApuestaTotalCliente;
import co.edu.unbosque.view.VentanaBuscarClientePorSede;
import co.edu.unbosque.view.VentanaBuscarEliminarApostador;
import co.edu.unbosque.view.VentanaBuscarEliminarSede;
import co.edu.unbosque.view.VentanaBuscarForRecibo;
import co.edu.unbosque.view.VentanaBuscarSede;
import co.edu.unbosque.view.VentanaCasa;
import co.edu.unbosque.view.VentanaSedes;
import co.edu.unbosque.view.VentanaSeleccionAdministrador;
import co.edu.unbosque.view.VentanaSeleccionJuegos;
import co.edu.unbosque.view.VentanaSeleccionJuegosAdmin;
import co.edu.unbosque.view.VentanaMostrarCasa;
import co.edu.unbosque.view.VentanaMostrarApostador;
import co.edu.unbosque.view.VentanaMostrarSede;
import co.edu.unbosque.view.VentanaSuperAstro;
import co.edu.unbosque.view.VentanaTablaApostadores;
import co.edu.unbosque.view.VentanaTablaJuegos;
import co.edu.unbosque.view.VentanaTablaSedes;
import co.edu.unbosque.view.VentanaTotalApuestas;
import co.edu.unbosque.view.VentanaTragaMoneda;
import co.edu.unbosque.view.VentanaInicioUsuario;
import co.edu.unbosque.view.VentanaJuegos;
import co.edu.unbosque.view.VentanaLogin;
import co.edu.unbosque.view.VentanaLoteria;

public class Controller implements ActionListener {

	private VentanaPrincipal vPrincipal;
	private VentanaInformacion vInfo;

	private VentanaSeleccionAdministrador vSeleccionAdmin;
	private VentanaGestionesAdmin vGestionesAdmin;

	private VentanaInicioUsuario vUsuario;
	private VentanaSeleccionJuegos vSeleccionJuegos;
	private VentanaSeleccionJuegosAdmin vSeleccionJuegosAdmin;

	private VentanaBaloto vBaloto;
	private VentanaSuperAstro vSuperAstro;
	private VentanaChance vChance;
	private VentanaLoteria vLoteria;
	private VentanaGachapon vGachapon;
	private VentanaBetplay vBetplay;
	private VentanaTragaMoneda vTragaMonedas;
	
	private VentanaJuegos vJuegos;
	private VentanaTablaJuegos vTablaJuegos;

	private VentanaLogin vLogin;

	private VentanaRegistroAtributos vAtributos;
	private VentanaRegistroContrasenia vContrasenias;

	private VentanaSedes vSedes;

	private VentanaCrearSede vCrearSede;
	private VentanaActualizarSede vDigitActualizarSede;

	private VentanaBuscarSede vBuscarSede;
	private VentanaBuscarActualizarSede vActualizarSede;
	private VentanaBuscarEliminarSede vBorrarSede;

	private VentanaMostrarSede vShowSede;
	private VentanaTablaSedes vTablaSedes;

	private VentanaApostadores vApostadores;
	private VentanaCreacionApostador vCrearApostador;
	private VentanaEdicionApostador vEdicionApostador;
	private VentanaTablaApostadores vTablaApostadores;

	private VentanaBuscarApostador vBuscarApostador;
	private VentanaBuscarActualizarApostador vBuscarActualizarApostador;
	private VentanaBuscarEliminarApostador vEliminarApostador;

	private VentanaMostrarApostador vShowApostador;
	private JuegoDAO juegoDAO;

	private VentanaCasa vCasas;
	private VentanaMostrarCasa vShowCasa;
	private VentanaEditarCasa vDigitCasa;
	private Properties configProperties;

	private ApostadorDAO apostadorDAO;
	private ApuestaSuperastroDAO apuestaSuperastroDAO;
	private ApuestaChanceDAO apuestaChanceDAO;
	private ApostadorDTO currentUser;
	private ApuestaBetPlayDAO apuestaBetPlayDAO;
	private ApuestaBalotoDAO apuestaBalotoDAO;
	private ApuestaLoteriaDAO apuestaLoteriaDAO;
	
	private SedeDAO sedeDAO;
	private ReciboDAO reciboDAO;
	private ApuestaDAO apuestaDAO;
	private VentanaBuscarForRecibo vBuscarForRecibo;
	
	private VentanaFacturarApuesta vFacturar;
	private VentanaFacturarSuperastro vFacturarSuperastro;
	private VentanaFacturarBaloto vFacturarBaloto;
	private VentanaFacturarBetplay vFacturarBetplay;
	private VentanaFacturarLoteria vFacturarLoteria;
	private VentanaFacturarChance vFacturarChance;
	
	private VentanaTablaRecibo vRecibo;
	private VentanaConsultas vSeleccionConsultas;
	private VentanaClientesSede vClientesSede;
	private VentanaBuscarDetalleApuestas vDetalleApuestas;
	private VentanaBuscarDetalleApuestas vDetalleApuestas2;
	private VentanaTotalApuestas vTotalApuestas;
	private VentanaBuscarDetallerApuestasSede vDetallesSede;
	private VentanaBuscarDetallerApuestasSede vDetallesSede2;
	private VentanaDetalleApuestas vDetallesApuestaSede;
	private VentanaBuscarDetalleApuestasCliente vDetalleCliente;
	private VentanaBuscarDetallerApuestasJuego vDetalleJuego;
	
	private VentanaBuscarClientePorSede vClientePorSede;
	private VentanaBuscarApuestaTotalCliente vTotalCliente;
	
	public Controller() {

		// PRINCIPAL
		vPrincipal = new VentanaPrincipal();
		vInfo = new VentanaInformacion();

		// USUARIO
		vUsuario = new VentanaInicioUsuario();
		vSeleccionJuegos = new VentanaSeleccionJuegos();
		
		// ADMIN
		vSeleccionAdmin = new VentanaSeleccionAdministrador();
		vGestionesAdmin = new VentanaGestionesAdmin();
		vSeleccionJuegosAdmin = new VentanaSeleccionJuegosAdmin();

		// JUEGOS
		vJuegos = new VentanaJuegos();
		juegoDAO = new JuegoDAO();

		vBaloto = new VentanaBaloto();
		vSuperAstro = new VentanaSuperAstro();
		vChance = new VentanaChance();
		vLoteria = new VentanaLoteria();
		vGachapon = new VentanaGachapon();
		vBetplay = new VentanaBetplay();
		vTragaMonedas = new VentanaTragaMoneda();
		
		// SEDES
		vSedes = new VentanaSedes();
		sedeDAO = new SedeDAO();
		vCrearSede = new VentanaCrearSede("");
		vBuscarSede = new VentanaBuscarSede("");
		vActualizarSede = new VentanaBuscarActualizarSede("");
		vBorrarSede = new VentanaBuscarEliminarSede("");
		vShowSede = new VentanaMostrarSede();
		vDigitActualizarSede = new VentanaActualizarSede("");

		// APOSTADORES
		vApostadores = new VentanaApostadores();
		apostadorDAO = new ApostadorDAO();
		vCrearApostador = new VentanaCreacionApostador("");
		vEdicionApostador = new VentanaEdicionApostador("");
		vBuscarApostador = new VentanaBuscarApostador("");
		vBuscarActualizarApostador = new VentanaBuscarActualizarApostador("");
		vEliminarApostador = new VentanaBuscarEliminarApostador("");
		vShowApostador = new VentanaMostrarApostador();

		// LOGIN USER
		vLogin = new VentanaLogin();
		vAtributos = new VentanaRegistroAtributos();
		vContrasenias = new VentanaRegistroContrasenia();

		// CASAS
		vCasas = new VentanaCasa();
		vShowCasa = new VentanaMostrarCasa();
		vDigitCasa = new VentanaEditarCasa();
		currentUser = new ApostadorDTO();
		apuestaDAO = new ApuestaDAO();
		configProperties = new Properties();
		
		// RECIBO
		reciboDAO = new ReciboDAO();
		vBuscarForRecibo = new VentanaBuscarForRecibo("buscar");
		
		// APUESTAS
		
		apuestaSuperastroDAO = new ApuestaSuperastroDAO();
		apuestaChanceDAO = new ApuestaChanceDAO();
		apuestaBetPlayDAO = new ApuestaBetPlayDAO();
		apuestaBalotoDAO = new ApuestaBalotoDAO();
		apuestaLoteriaDAO = new ApuestaLoteriaDAO();
		
		// CONSULTAS
		vSeleccionConsultas = new VentanaConsultas();
		vDetalleApuestas = new VentanaBuscarDetalleApuestas("buscar");
		
		vDetalleApuestas2 = new VentanaBuscarDetalleApuestas("buscar");
		vDetallesSede2 = new VentanaBuscarDetallerApuestasSede("buscar");
		
		vClientePorSede = new VentanaBuscarClientePorSede("buscar");
		vTotalCliente = new VentanaBuscarApuestaTotalCliente("buscar");
		vDetallesSede = new VentanaBuscarDetallerApuestasSede("buscar");
		vDetalleCliente = new VentanaBuscarDetalleApuestasCliente("buscar");
		
		vDetalleJuego = new VentanaBuscarDetallerApuestasJuego("buscar");
		// FACTURAR APUESTA
		vFacturar = new VentanaFacturarApuesta();
		vFacturarSuperastro = new VentanaFacturarSuperastro();
		vFacturarBaloto = new VentanaFacturarBaloto();
		vFacturarBetplay = new VentanaFacturarBetplay();
		vFacturarChance = new VentanaFacturarChance();
		vFacturarLoteria = new VentanaFacturarLoteria();
		
		agregarLectores();
		loadConfig();

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
		
		vSeleccionAdmin.getConsultas().addActionListener(this);
		vSeleccionAdmin.getConsultas().setActionCommand("vAdminConsultar");

		vGestionesAdmin.getRegresar().addActionListener(this);
		vGestionesAdmin.getRegresar().setActionCommand("vGestionesRegresar");

		vGestionesAdmin.getGesSedes().addActionListener(this);
		vGestionesAdmin.getGesSedes().setActionCommand("vGestionesSedes");
		
		vGestionesAdmin.getGesJuegos().addActionListener(this);
		vGestionesAdmin.getGesJuegos().setActionCommand("vGestionesJuegos");

		vGestionesAdmin.getGesApostadores().addActionListener(this);
		vGestionesAdmin.getGesApostadores().setActionCommand("vGestionesApostadores");
		
		vGestionesAdmin.getGesCasa().addActionListener(this);
		vGestionesAdmin.getGesCasa().setActionCommand("vGestionCasas");
		
		vGestionesAdmin.getGesJuegos().addActionListener(this);
		vGestionesAdmin.getGesJuegos().setActionCommand("vGestionJuegos");

		// VENTANA INFORMACION ---------------------------------------

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

		// SELECCION DE JUEGOS ---------------------------------------

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

		// BALOTO -------------

		vBaloto.getRegresar().addActionListener(this);
		vBaloto.getRegresar().setActionCommand("vBalotoRegresar");

		// SUPER ASTRO -------------

		vSuperAstro.getRegresar().addActionListener(this);
		vSuperAstro.getRegresar().setActionCommand("vSuperAstroRegresar");

		// CHANCE -------------

		vChance.getRegresar().addActionListener(this);
		vChance.getRegresar().setActionCommand("vChanceRegresar");

		// LOTERIA -------------

		vLoteria.getRegresar().addActionListener(this);
		vLoteria.getRegresar().setActionCommand("vLoteriaRegresar");

		// GACHAPON -------------

		vGachapon.getRegresar().addActionListener(this);
		vGachapon.getRegresar().setActionCommand("vGachaponRegresar");

		// BETPLAY -------------

		vBetplay.getRegresar().addActionListener(this);
		vBetplay.getRegresar().setActionCommand("vBetplayRegresar");

		// TRAGA MONEDAS -------------

		vTragaMonedas.getRegresar().addActionListener(this);
		vTragaMonedas.getRegresar().setActionCommand("vTragaMonedasRegresar");

		// VENTANA SEDES -------------

		vSedes.getRegresar().addActionListener(this);
		vSedes.getRegresar().setActionCommand("vSedesRegresar");

		vSedes.getCrear().addActionListener(this);
		vSedes.getCrear().setActionCommand("vSedesCrear");

		vCrearSede.getRegresar().addActionListener(this);
		vCrearSede.getRegresar().setActionCommand("vDigitSedeRegresar");

		vCrearSede.getIngresar().addActionListener(this);
		vCrearSede.getIngresar().setActionCommand("vDigitSedeIngresar");

		vSedes.getBuscar().addActionListener(this);
		vSedes.getBuscar().setActionCommand("vSedesBuscar");

		vBuscarSede.getRegresar().addActionListener(this);
		vBuscarSede.getRegresar().setActionCommand("vSearchSedeRegresar");

		vBuscarSede.getIngresar().addActionListener(this);
		vBuscarSede.getIngresar().setActionCommand("vSearchSedeIngresar");

		vShowSede.getRegresar().addActionListener(this);
		vShowSede.getRegresar().setActionCommand("vShowSedeRegresar");

		vSedes.getMostrar().addActionListener(this);
		vSedes.getMostrar().setActionCommand("vSedesMostrar");

		vSedes.getActualizar().addActionListener(this);
		vSedes.getActualizar().setActionCommand("vSedesActualizar");

		vSedes.getBorrar().addActionListener(this);
		vSedes.getBorrar().setActionCommand("vSedesBorrar");

		vActualizarSede.getRegresar().addActionListener(this);
		vActualizarSede.getRegresar().setActionCommand("vSearchSedeARegresar");

		vActualizarSede.getIngresar().addActionListener(this);
		vActualizarSede.getIngresar().setActionCommand("vSearchSedeAIngresar");

		vDigitActualizarSede.getIngresar().addActionListener(this);
		vDigitActualizarSede.getIngresar().setActionCommand("vDigitSedeAIngresar");

		vDigitActualizarSede.getRegresar().addActionListener(this);
		vDigitActualizarSede.getRegresar().setActionCommand("vDigitSedeARegresar");

		vBorrarSede.getRegresar().addActionListener(this);
		vBorrarSede.getRegresar().setActionCommand("vSearchSedeDRegresar");

		vBorrarSede.getIngresar().addActionListener(this);
		vBorrarSede.getIngresar().setActionCommand("vSearchSedeDIngresar");

		// VENTANAS APOSTADORES ----------------------------------------

		vApostadores.getRegresar().addActionListener(this);
		vApostadores.getRegresar().setActionCommand("vApostadoresRegresar");

		vApostadores.getCrear().addActionListener(this);
		vApostadores.getCrear().setActionCommand("vApostadoresCrear");

		vCrearApostador.getRegresar().addActionListener(this);
		vCrearApostador.getRegresar().setActionCommand("vCApostador1Regresar");

		vCrearApostador.getIngresar().addActionListener(this);
		vCrearApostador.getIngresar().setActionCommand("vCApostadorIngresar");

		vApostadores.getMostrar().addActionListener(this);
		vApostadores.getMostrar().setActionCommand("vApostadoresMostar");

		vApostadores.getActualizar().addActionListener(this);
		vApostadores.getActualizar().setActionCommand("vApostadoresActualizar");

		vEdicionApostador.getRegresar().addActionListener(this);
		vEdicionApostador.getRegresar().setActionCommand("vCApostadorARegresar");

		vEdicionApostador.getIngresar().addActionListener(this);
		vEdicionApostador.getIngresar().setActionCommand("vCApostadorAIngresar");

		vBuscarActualizarApostador.getRegresar().addActionListener(this);
		vBuscarActualizarApostador.getRegresar().setActionCommand("vSearchApostadorARegresar");

		vBuscarActualizarApostador.getIngresar().addActionListener(this);
		vBuscarActualizarApostador.getIngresar().setActionCommand("vSearchApostadorAIngresar");

		vEliminarApostador.getRegresar().addActionListener(this);
		vEliminarApostador.getRegresar().setActionCommand("vSearchApostadorDRegresar");

		vEliminarApostador.getIngresar().addActionListener(this);
		vEliminarApostador.getIngresar().setActionCommand("vSearchApostadorDIngresar");

		vBuscarApostador.getRegresar().addActionListener(this);
		vBuscarApostador.getRegresar().setActionCommand("vSearchApostadorRegresar");

		vBuscarApostador.getIngresar().addActionListener(this);
		vBuscarApostador.getIngresar().setActionCommand("vSearchApostadorIngresar");

		vApostadores.getBorrar().addActionListener(this);
		vApostadores.getBorrar().setActionCommand("vApostadoresBorrar");

		vApostadores.getBuscar().addActionListener(this);
		vApostadores.getBuscar().setActionCommand("vApostadoresBuscar");

		vShowApostador.getRegresar().addActionListener(this);
		vShowApostador.getRegresar().setActionCommand("vShowApostadorRegresar");

		// GESTOR APUESTAS ADMIN --------------------------

		vSeleccionJuegosAdmin.getRegresar().addActionListener(this);
		vSeleccionJuegosAdmin.getRegresar().setActionCommand("vRegresarFacturarApuesta");

		// VENTANA CASA -----------------------------------------------

		vCasas.getRegresar().addActionListener(this);
		vCasas.getRegresar().setActionCommand("vCasaRegresar");

		vCasas.getMostrar().addActionListener(this);
		vCasas.getMostrar().setActionCommand("vCasaMostrar");

		vShowCasa.getRegresar().addActionListener(this);
		vShowCasa.getRegresar().setActionCommand("vShowCasaRegresar");

		vCasas.getEditar().addActionListener(this);
		vCasas.getEditar().setActionCommand("vCasaEditar");

		vDigitCasa.getRegresar().addActionListener(this);
		vDigitCasa.getRegresar().setActionCommand("vDigitCasaRegresar");

		vDigitCasa.getIngresar().addActionListener(this);
		vDigitCasa.getIngresar().setActionCommand("vDigitCasaIngresar");
		
		// VENTANA CONSULTAS -----------------------------------------------
		
		vSeleccionConsultas.getClientesSede().addActionListener(this);
		vSeleccionConsultas.getClientesSede().setActionCommand("vConsultasClientesSede");
		
		vSeleccionConsultas.getApuestasTotales().addActionListener(this);
		vSeleccionConsultas.getApuestasTotales().setActionCommand("vConsultasApuestasTotales");
		
		vSeleccionConsultas.getDetalleApuestas().addActionListener(this);
		vSeleccionConsultas.getDetalleApuestas().setActionCommand("vConsultasDetalleApuestas");
		
		vSeleccionConsultas.getTotalApuestas().addActionListener(this);
		vSeleccionConsultas.getTotalApuestas().setActionCommand("vConsultasTotalApuestas");		
		
		vSeleccionConsultas.getRegresar().addActionListener(this);
		vSeleccionConsultas.getRegresar().setActionCommand("vSeleccionConsultasRegresar");		
		
		vClientePorSede.getRegresar().addActionListener(this);
		vClientePorSede.getRegresar().setActionCommand("vClientePorSedeRegresar");
		
		vClientePorSede.getIngresar().addActionListener(this);
		vClientePorSede.getIngresar().setActionCommand("vClientePorSedeIngresar");
		
		vTotalCliente.getRegresar().addActionListener(this);
		vTotalCliente.getRegresar().setActionCommand("vTotalClienteRegresar");
		
		vTotalCliente.getIngresar().addActionListener(this);
		vTotalCliente.getIngresar().setActionCommand("vTotalClienteIngresar");
		
		vDetalleApuestas.getsede().addActionListener(this);
		vDetalleApuestas.getsede().setActionCommand("vDetalletApuestasSede");
		
		vDetalleApuestas.getApostador().addActionListener(this);
		vDetalleApuestas.getApostador().setActionCommand("vDetalletApuestasApostador");
		
		vDetalleApuestas.getRegresar().addActionListener(this);
		vDetalleApuestas.getRegresar().setActionCommand("vDetalletApuestasRegresar");
		
		vDetalleApuestas2.getsede().addActionListener(this);
		vDetalleApuestas2.getsede().setActionCommand("vTotalApuestasSede");
		
		vDetalleApuestas2.getApostador().addActionListener(this);
		vDetalleApuestas2.getApostador().setActionCommand("vTotalApuestasJuego");
		
		vDetalleApuestas2.getRegresar().addActionListener(this);
		vDetalleApuestas2.getRegresar().setActionCommand("vTotalApuestasRegresar");
		
		vDetallesSede.getRegresar().addActionListener(this);
		vDetallesSede.getRegresar().setActionCommand("vDetallesSedeRegresar");
		
		vDetallesSede.getIngresar().addActionListener(this);
		vDetallesSede.getIngresar().setActionCommand("vDetallesSedeIngresar");
		
		vDetallesSede2.getRegresar().addActionListener(this);
		vDetallesSede2.getRegresar().setActionCommand("vTotalSedeRegresar");
		
		vDetallesSede2.getIngresar().addActionListener(this);
		vDetallesSede2.getIngresar().setActionCommand("vTotalSedeIngresar");
		
		vDetalleCliente.getRegresar().addActionListener(this);
		vDetalleCliente.getRegresar().setActionCommand("vDetallerClienteRegresar");
		
		vDetalleCliente.getIngresar().addActionListener(this);
		vDetalleCliente.getIngresar().setActionCommand("vDetallerClienteIngresar");
		
		vDetalleJuego.getRegresar().addActionListener(this);
		vDetalleJuego.getRegresar().setActionCommand("vTotalJuegoRegresar");
		
		vDetalleJuego.getIngresar().addActionListener(this);
		vDetalleJuego.getIngresar().setActionCommand("vTotalJuegoIngresar");
		
		// VENTANA DE GESTION JUEGOS 
		
		vJuegos.getRegresar().addActionListener(this);
		vJuegos.getRegresar().setActionCommand("vJuegosRegresar");
		
		vJuegos.getIngresar().addActionListener(this);
		vJuegos.getIngresar().setActionCommand("vJuegosIngresar");
		
		vJuegos.getConsultar().addActionListener(this);
		vJuegos.getConsultar().setActionCommand("vJuegosConsultar");

		// VENTANA FACTURAR 
		
		vFacturar.getVolverInicio().addActionListener(this);
		vFacturar.getVolverInicio().setActionCommand("vFacturarRegresar");
		
		vFacturar.getSuperAstro().addActionListener(this);
		vFacturar.getSuperAstro().setActionCommand("vFacturarSuperastro");
		
		vFacturarSuperastro.getSalir().addActionListener(this);
		vFacturarSuperastro.getSalir().setActionCommand("vFacturarSuperAstroSalir");
		
		vFacturarSuperastro.getIngresar().addActionListener(this);
		vFacturarSuperastro.getIngresar().setActionCommand("vFacturarSuperAstroIngresar");
		
		vFacturar.getBaloto().addActionListener(this);
		vFacturar.getBaloto().setActionCommand("vFacturarBaloto");
		
		vFacturarBaloto.getSalir().addActionListener(this);
		vFacturarBaloto.getSalir().setActionCommand("vFacturarBalotoSalir");
		
		vFacturarBaloto.getIngresar().addActionListener(this);
		vFacturarBaloto.getIngresar().setActionCommand("vFacturarBalotoIngresar");
		
		vFacturar.getLoteria().addActionListener(this);
		vFacturar.getLoteria().setActionCommand("vFacturarLoteria");
		
		vFacturarLoteria.getSalir().addActionListener(this);
		vFacturarLoteria.getSalir().setActionCommand("vFacturarLoteriaSalir");
		
		vFacturarLoteria.getIngresar().addActionListener(this);
		vFacturarLoteria.getIngresar().setActionCommand("vFacturarLoteriaIngresar");
		
		vFacturar.getChance().addActionListener(this);
		vFacturar.getChance().setActionCommand("vFacturarChance");

		vFacturarChance.getSalir().addActionListener(this);
		vFacturarChance.getSalir().setActionCommand("vFacturarChanceSalir");
		
		vFacturarChance.getIngresar().addActionListener(this);
		vFacturarChance.getIngresar().setActionCommand("vFacturarChanceIngresar");
		
		vFacturar.getBetplay().addActionListener(this);
		vFacturar.getBetplay().setActionCommand("vFacturarBetplay");
		
		vFacturarBetplay.getSalir().addActionListener(this);
		vFacturarBetplay.getSalir().setActionCommand("vFacturarBetplaySalir");
		
		vFacturarBetplay.getIngresar().addActionListener(this);
		vFacturarBetplay.getIngresar().setActionCommand("vFacturarBetplayIngresar");
		
		// VENTANA RECIBO
		
		vBuscarForRecibo.getRegresar().addActionListener(this);
		vBuscarForRecibo.getRegresar().setActionCommand("vReciboRegresar");
		
		vBuscarForRecibo.getIngresar().addActionListener(this);
		vBuscarForRecibo.getIngresar().setActionCommand("vGenerarReciboPropio");
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
			if (currentUser == null) {
				JOptionPane.showMessageDialog(vLogin, "Contraseña y/o usuario incorrectos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vLogin.getCampoContrasenia().setText("");
			} else {
				JOptionPane.showMessageDialog(vLogin, " Ingresado con exito!", "Validacion",
						JOptionPane.INFORMATION_MESSAGE);
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
				allInOrder = false;
			}
			String celular = vAtributos.getCelular().getText();
			try {
				checkCellFormat(celular);
			} catch (Exception e1) {
				vAtributos.getCelular().setText("");
				allInOrder = false;
			}
			String cedula = vAtributos.getCedula().getText();
			if(!cedula.isBlank()||!cedula.isEmpty()) {
			try {
				Long.parseLong(cedula);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(vAtributos, "La cedula solo consiste de numeros.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vAtributos.getCedula().setText("");
				allInOrder = false;
			}
			if(!apostadorDAO.checkCedula(cedula)) {
				JOptionPane.showMessageDialog(vAtributos, "Cedula ya registrada en el sitema.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vAtributos.getCedula().setText("");
				allInOrder = false;
			}
			}
			String direccion = vAtributos.getDireccion().getText();
			String sede = vAtributos.getSedeJuego().getSelectedItem().toString();
			if (sedeDAO.checkSede(sede)) {
				JOptionPane.showMessageDialog(vAtributos, "No existe esta sede.", "Error", JOptionPane.ERROR_MESSAGE);
				vAtributos.getSedeJuego().getSelectedItem().toString();
				allInOrder = false;
			}

			if (nombre.isEmpty() || cedula.isEmpty() || sede.isEmpty() || direccion.isEmpty() || celular.isEmpty()
					|| nombre.isBlank() || cedula.isBlank() || sede.isBlank() || direccion.isBlank()
					|| celular.isBlank()) {
				JOptionPane.showMessageDialog(vAtributos, "Debe llenar todos los datos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				allInOrder = false;
			}
			if (allInOrder) {
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
			String sede = vAtributos.getSedeJuego().getSelectedItem().toString();
			String direccion = vAtributos.getDireccion().getText();
			String celular = vAtributos.getCelular().getText();
			String contraseña = vContrasenias.getCampoContrasenia().getText();
			String respContraseña = vContrasenias.getCampoContraseniaVerificacion().getText();
			String user = vContrasenias.getCampoUsuario().getText();
			if (!apostadorDAO.checkUser(user)) {
				JOptionPane.showMessageDialog(vContrasenias, "Usuario existente.", "Error", JOptionPane.ERROR_MESSAGE);
				vContrasenias.getCampoUsuario().setText("");
				allInOrder = false;
			}
			if (apostadorDAO.checkPass(contraseña, respContraseña) == 1) {
				JOptionPane.showMessageDialog(vContrasenias, "Las contraseñas no coinciden.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vContrasenias.getCampoContrasenia().setText("");
				vContrasenias.getCampoContraseniaVerificacion().setText("");
				allInOrder = false;
			} else if (apostadorDAO.checkPass(contraseña, respContraseña) == 2) {
				JOptionPane.showMessageDialog(vContrasenias, "La contraseña debe tener 7 o  mas digitos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vContrasenias.getCampoContrasenia().setText("");
				vContrasenias.getCampoContraseniaVerificacion().setText("");
				allInOrder = false;
			}

			if (contraseña.isEmpty() || respContraseña.isEmpty() || user.isEmpty() || contraseña.isBlank()
					|| respContraseña.isBlank() || user.isBlank()) {
				JOptionPane.showMessageDialog(vContrasenias, "Debe llenar todos los datos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				allInOrder = false;
			}

			if (allInOrder) {
				apostadorDAO.create(nombre, cedula, sede, direccion, celular, contraseña, user);
				JOptionPane.showMessageDialog(vContrasenias, " Creado con exito!", "Validacion",
						JOptionPane.INFORMATION_MESSAGE);
				vAtributos.getNombreCompleto().setText("");
				vAtributos.getCedula().setText("");
				vAtributos.getSedeJuego().getSelectedItem().toString();
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

		case "vAdminRegresar": {
			vSeleccionAdmin.setVisible(false);
			vPrincipal.setVisible(true);
			break;
		}

		case "vRegresarFacturarApuesta": {
			vGestionesAdmin.setVisible(true);
			vSeleccionJuegosAdmin.setVisible(false);
			break;
		}

		// GENERAR RECIBOS

		case "vGenerarRecibo":{
			vSeleccionAdmin.setVisible(false);
			vBuscarForRecibo.setVisible(true);
			break;
		}
		
		case "vGenerarReciboPropio": {
			boolean allInOrder = true;
			String cedula = vBuscarForRecibo.getcedula().getText();
			if(!cedula.isBlank()||!cedula.isEmpty()) {
			try {
				Long.parseLong(cedula);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(vTotalCliente, "La cedula solo consiste de numeros.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vTotalCliente.getcedula().setText("");
				allInOrder = false;
			}
			if(apostadorDAO.checkCedula(cedula)) {
				JOptionPane.showMessageDialog(vTotalCliente, "No existe esta cedula en el sistema.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vTotalCliente.getcedula().setText("");
				allInOrder = false;
			}
			}
			if(cedula.isEmpty()||cedula.isBlank()) {
				JOptionPane.showMessageDialog(vTotalCliente, "Digite todos los datos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vTotalCliente.getcedula().setText("");
				allInOrder = false;
			}
			if(allInOrder) {
			reciboDAO.trueCreate(cedula, apuestaDAO.getAllBets(apuestaBalotoDAO.returnCarrito(), apuestaLoteriaDAO.returnCarrito(),
					apuestaSuperastroDAO.returnCarrito(), apuestaChanceDAO.returnCarrito(), apuestaBetPlayDAO.returnCarrito()));
			vRecibo = new VentanaTablaRecibo(reciboDAO.getLastRecibo(cedula));
			vRecibo.setVisible(true);
			}
			break;
		}
		
		case "vReciboRegresar":{
			vBuscarForRecibo.setVisible(false);
			vSeleccionAdmin.setVisible(true);
			break;
		}
		
		// SELECCION CONSULTAS
		
		case "vAdminConsultar": {
			vSeleccionAdmin.setVisible(false);
			vSeleccionConsultas.setVisible(true);
			break;
		}
		
		// VENTANA CONSULTAS ---------------------------------------
		
		case "vConsultasClientesSede": {
			vSeleccionConsultas.setVisible(false);
			vClientePorSede.setVisible(true);
			break;
		}
		case "vClientePorSedeRegresar":{
			vClientePorSede.setVisible(false);
			vSeleccionConsultas.setVisible(true);
			break;
		}
		case "vClientePorSedeIngresar":{
			
			String sede = vClientePorSede.getUbicacion().getSelectedItem().toString();
			if (sedeDAO.getSede(sede) != null) {
				vClientesSede = new VentanaClientesSede(apostadorDAO.returnClientBySede(sede));
				vClientesSede.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(vBuscarSede, "No existe una sede en esta ubicacion.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vClientePorSede.getUbicacion().getSelectedItem().toString();
			}
			break;
		}
		case "vConsultasApuestasTotales": {
			vSeleccionConsultas.setVisible(false);
			vTotalCliente.setVisible(true);
			break;
		}
		case "vTotalClienteRegresar":{
			vTotalCliente.setVisible(false);
			vSeleccionConsultas.setVisible(true);
			break;
		}
		
		case "vTotalClienteIngresar":{
			boolean allInOrder = true;
			String cedula = vTotalCliente.getcedula().getText();
			try {
				Long.parseLong(cedula);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(vTotalCliente, "La cedula solo consiste de numeros.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vTotalCliente.getcedula().setText("");
				allInOrder = false;
			}
			if(apostadorDAO.checkCedula(cedula)) {
				JOptionPane.showMessageDialog(vTotalCliente, "No existe esta cedula en el sistema.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vTotalCliente.getcedula().setText("");
				allInOrder = false;
			}
			if(cedula.isEmpty()||cedula.isBlank()) {
				JOptionPane.showMessageDialog(vTotalCliente, "Digite todos los datos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vTotalCliente.getcedula().setText("");
				allInOrder = false;
			}
			if(allInOrder) {
				vTotalApuestas = new VentanaTotalApuestas(Float.toString(apuestaDAO.returnTotalBet(cedula)));
				vTotalApuestas.setVisible(true);
			}
			break;
		}
		
		case "vConsultasDetalleApuestas": {
			vSeleccionConsultas.setVisible(false);
			vDetalleApuestas.setVisible(true);
			break;
		}
		
		case "vDetalletApuestasRegresar":{
			vDetalleApuestas.setVisible(false);
			vSeleccionConsultas.setVisible(true);
			break;
		}
		case "vDetalletApuestasSede":{
			vDetalleApuestas.setVisible(false);
			vDetallesSede.setVisible(true);
			break;
		}
		case "vDetalletApuestasApostador":{
			vDetalleApuestas.setVisible(false);
			vDetalleCliente.setVisible(true);
			break;
		}
		case "vDetallerClienteRegresar":{
			vDetalleCliente.setVisible(false);
			vDetalleApuestas.setVisible(true);
			break;
		}
		case "vDetallerClienteIngresar":{
			boolean allInOrder = true;
			String cedula = vDetalleCliente.getcedula().getText();
			try {
				Long.parseLong(cedula);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(vDetalleCliente, "La cedula solo consiste de numeros.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vDetalleCliente.getcedula().setText("");
				allInOrder = false;
			}
			if(apostadorDAO.checkCedula(cedula)) {
				JOptionPane.showMessageDialog(vDetalleCliente, "No existe esta cedula en el sistema.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vDetalleCliente.getcedula().setText("");
				allInOrder = false;
			}
			if(cedula.isEmpty()||cedula.isBlank()) {
				JOptionPane.showMessageDialog(vDetalleCliente, "Digite todos los datos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vDetalleCliente.getcedula().setText("");
				allInOrder = false;
			}
			if(allInOrder) {
			vDetallesApuestaSede = new VentanaDetalleApuestas(apuestaDAO.getAllBets(apuestaBalotoDAO.returnByClient(cedula), 
			apuestaLoteriaDAO.returnByClient(cedula), apuestaSuperastroDAO.returnByClient(cedula), apuestaChanceDAO.returnByClient(cedula)
					,apuestaBetPlayDAO.returnByClient(cedula)));
			vDetallesApuestaSede.setVisible(true);
			}
			break;
		}
		case "vDetallesSedeRegresar":{
			vDetallesSede.setVisible(false);
			vDetalleApuestas.setVisible(true);
			break;
		}
		case "vDetallesSedeIngresar":{
			String sede = vDetallesSede.getUbicacion().getSelectedItem().toString();
			if (sedeDAO.getSede(sede) != null) {
				vDetallesApuestaSede = new VentanaDetalleApuestas(apuestaDAO.getAllBets(apuestaBalotoDAO.returnBySede(sede), 
						apuestaLoteriaDAO.returnBySede(sede), apuestaSuperastroDAO.returnBySede(sede), apuestaChanceDAO.returnBySede(sede)
						,apuestaBetPlayDAO.returnBySede(sede)));
				vDetallesApuestaSede.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(vDetallesSede, "No existe una sede en esta ubicacion.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			break;
		}
		case "vConsultasTotalApuestas": {
			vSeleccionConsultas.setVisible(false);
			vDetalleApuestas2.setVisible(true);
			break;
		}
		
		case "vTotalApuestasRegresar":{
			vDetalleApuestas2.setVisible(false);
			vSeleccionConsultas.setVisible(true);
			break;
		}
		case "vTotalApuestasSede":{
			vDetalleApuestas2.setVisible(false);
			vDetallesSede2.setVisible(true);
			break;
		}
		case "vTotalApuestasJuego":{
			vDetalleApuestas2.setVisible(false);
			vDetalleJuego.setVisible(true);
			break;
		}
		case "vTotalSedeRegresar":{
			vDetallesSede2.setVisible(false);
			vDetalleApuestas2.setVisible(true);
			break;
		}
		case "vTotalSedeIngresar":{
			String sede = vDetallesSede2.getUbicacion().getSelectedItem().toString();
			if (sedeDAO.getSede(sede) != null) {
				vTotalApuestas = new VentanaTotalApuestas(Float.toString(apuestaDAO.returnTotalBetSede(sede)));
				vTotalApuestas.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(vDetallesSede, "No existe una sede en esta ubicacion.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			break;
		}
		case "vTotalJuegoRegresar":{
			vDetalleJuego.setVisible(false);
			vDetalleApuestas2.setVisible(true);
			break;
		}
		case "vTotalJuegoIngresar":{
			String juego = vDetalleJuego.getjuego().getSelectedItem().toString();
			if(juego.equals("Baloto")) {
				vTotalApuestas = new VentanaTotalApuestas(Float.toString(apuestaBalotoDAO.returnTotalBetGame()));
			}else if(juego.equals("BetPlay")) {
				vTotalApuestas = new VentanaTotalApuestas(Float.toString(apuestaBetPlayDAO.returnTotalBetGame()));
			}else if(juego.equals("Loteria")) {
				vTotalApuestas = new VentanaTotalApuestas(Float.toString(apuestaLoteriaDAO.returnTotalBetGame()));
			}else if(juego.equals("SuperAstro")) {
				vTotalApuestas = new VentanaTotalApuestas(Float.toString(apuestaSuperastroDAO.returnTotalBetGame()));
			}else if(juego.equals("Chance")) {
				vTotalApuestas = new VentanaTotalApuestas(Float.toString(apuestaChanceDAO.returnTotalBetGame()));
			}
			vTotalApuestas.setVisible(true);
			break;
		}
		case "vSeleccionConsultasRegresar": {
			vSeleccionConsultas.setVisible(false);
			vSeleccionAdmin.setVisible(true);
			break;
		}


		// SELECCION DE GESTIONES ---------------------------------------

		case "vGestionesRegresar": {
			vGestionesAdmin.setVisible(false);
			vSeleccionAdmin.setVisible(true);
			break;
		}

		case "vGestionesSedes": {
			vGestionesAdmin.setVisible(false);
			vSedes.setVisible(true);
			break;
		}
		
		// VENTANA FACTURAR -----------------------------------
		case "vFacturarRegresar":{
			vFacturar.setVisible(false);
			vSeleccionAdmin.setVisible(true);
			break;
		}

		case "vFacturarApuesta": {
			vSeleccionAdmin.setVisible(false);
			vFacturar.setVisible(true);
			apuestaSuperastroDAO.deleteCarrito();
			apuestaBalotoDAO.deleteCarrito();
			apuestaChanceDAO.deleteCarrito();
			apuestaBetPlayDAO.deleteCarrito();
			apuestaLoteriaDAO.deleteCarrito();
			break;
		}
		
		case "vFacturarSuperastro":{
			vFacturar.setVisible(false);
			vFacturarSuperastro.setVisible(true);
			break;
		}
		
		case "vFacturarSuperAstroSalir":{
			vFacturarSuperastro.setVisible(false);;
			vFacturar.setVisible(true);
			break;
		}
		case "vFacturarSuperAstroIngresar":{
			boolean allInOrder = true;
			String sede = vFacturarSuperastro.getSede().getSelectedItem().toString();
			if (sedeDAO.checkSede(sede)) {
				JOptionPane.showMessageDialog(vFacturarSuperastro, "No existe esta sede.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarSuperastro.getSede().getSelectedItem().toString();
				allInOrder = false;
			}
			String cedula = vFacturarSuperastro.getCedula().getText();
			if(cedula.isBlank()||cedula.isEmpty()) {
				JOptionPane.showMessageDialog(vFacturarSuperastro, "La cedula solo consiste de numeros.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarSuperastro.getCedula().setText("");
				break;
			}
			try {
				Long.parseLong(cedula);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(vFacturarSuperastro, "La cedula solo consiste de numeros.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarSuperastro.getCedula().setText("");
				allInOrder = false;
			}
			if(apostadorDAO.checkCedula(cedula)) {
				JOptionPane.showMessageDialog(vFacturarSuperastro, "La cedula no esta registrada en nuestro sitema.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarSuperastro.getCedula().setText("");
				allInOrder = false;
				break;
			}
			String dSemana = vFacturarSuperastro.getDiaSemana().getSelectedItem().toString();
			String valor = vFacturarSuperastro.getValor().getText();
			if(!valor.isBlank()||!valor.isEmpty()) {
			if(apuestaSuperastroDAO.checkValor(valor, apostadorDAO.getApostador(cedula).getSaldo())==1){
				JOptionPane.showMessageDialog(vFacturarSuperastro, "Saldo insuficiente.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarSuperastro.getValor().setText("");
				allInOrder = false;
			}else if(apuestaSuperastroDAO.checkValor(valor, apostadorDAO.getApostador(cedula).getSaldo())==0) {
				JOptionPane.showMessageDialog(vFacturarSuperastro, "La minima apuesta son 200 pesos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarSuperastro.getValor().setText("");
				allInOrder = false;
			}
			try {
				Long.parseLong(valor);
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(vFacturarSuperastro, "Digite solo numeros en el valor.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarSuperastro.getValor().setText("");
				allInOrder = false;
			}
			}
			String num1 = vFacturarSuperastro.getNum1().getText();
			String num2 = vFacturarSuperastro.getNum2().getText();
			String num3 = vFacturarSuperastro.getNum3().getText();
			String num4 = vFacturarSuperastro.getNum4().getText();
			try {
				Integer.parseInt(num1);
				Integer.parseInt(num2);
				Integer.parseInt(num3);
				Integer.parseInt(num4);
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(vFacturarSuperastro, "Digite solo numeros enteros en los numeros.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarSuperastro.getNum1().setText("");
				vFacturarSuperastro.getNum2().setText("");
				vFacturarSuperastro.getNum3().setText("");
				vFacturarSuperastro.getNum4().setText("");
				allInOrder = false;
			}
			
			if(valor.isEmpty()||cedula.isEmpty()||num1.isEmpty()||num2.isEmpty()||num3.isEmpty()||num4.isEmpty()||
					valor.isBlank()||cedula.isBlank()||num1.isBlank()||num2.isBlank()||num3.isBlank()||num4.isBlank()) {
				JOptionPane.showMessageDialog(vFacturarSuperastro, "Digite todos los datos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarSuperastro.getNum1().setText("");
				vFacturarSuperastro.getNum2().setText("");
				vFacturarSuperastro.getNum3().setText("");
				vFacturarSuperastro.getNum4().setText("");
				vFacturarSuperastro.getValor().setText("");
				vFacturarSuperastro.getCedula().setText("");
				allInOrder = false;
			}
			
			String signo = vFacturarSuperastro.getSigno().getSelectedItem().toString();
			
			if(allInOrder) {
			double payment = Double.parseDouble(valor)*-1;
			apuestaSuperastroDAO.create(sede,cedula,dSemana,valor,num1,num2,num3,num4,signo);
			apuestaDAO.create(sede,cedula,dSemana,valor);
			apuestaSuperastroDAO.addCarrito();
			apostadorDAO.actualizarSaldo(payment, cedula);
			JOptionPane.showMessageDialog(vFacturarSuperastro, " Facturado con exito!", "Validacion",
					JOptionPane.INFORMATION_MESSAGE);
			}
			break;
		}
		
		case "vFacturarBaloto":{
			vFacturar.setVisible(false);
			vFacturarBaloto.setVisible(true);
			break;
		}
		
		case "vFacturarBalotoSalir":{
			vFacturarBaloto.setVisible(false);;
			vFacturar.setVisible(true);
			break;
		}
		case "vFacturarBalotoIngresar":{
			boolean allInOrder = true;
			String sede = vFacturarBaloto.getSede().getSelectedItem().toString();
			if (sedeDAO.checkSede(sede)) {
				JOptionPane.showMessageDialog(vFacturarBaloto, "No existe esta sede.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarBaloto.getSede().getSelectedItem().toString();
				allInOrder = false;
			}
			String cedula = vFacturarBaloto.getCedula().getText();
			if(cedula.isBlank()||cedula.isEmpty()) {
				JOptionPane.showMessageDialog(vFacturarBaloto, "Digite la cedula.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarBaloto.getCedula().setText("");
				break;
			}
			try {
				Long.parseLong(cedula);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(vFacturarBaloto, "La cedula solo consiste de numeros.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarBaloto.getCedula().setText("");
				allInOrder = false;
			}
			if(apostadorDAO.checkCedula(cedula)) {
				JOptionPane.showMessageDialog(vFacturarBaloto, "La cedula no esta registrada en nuestro sitema.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarBaloto.getCedula().setText("");
				allInOrder = false;
				break;
			}
			String dSemana = vFacturarBaloto.getDiaSemana().getSelectedItem().toString();
			String valor = vFacturarBaloto.getValor().getText();
			if(!valor.isBlank()||!valor.isEmpty()) {
			if(apuestaBalotoDAO.checkValor(valor, apostadorDAO.getApostador(cedula).getSaldo())==1){
				JOptionPane.showMessageDialog(vFacturarBaloto, "Saldo insuficiente.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarBaloto.getValor().setText("");
				allInOrder = false;
			}else if(apuestaBalotoDAO.checkValor(valor, apostadorDAO.getApostador(cedula).getSaldo())==0) {
				JOptionPane.showMessageDialog(vFacturarBaloto, "La minima apuesta son 200 pesos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarBaloto.getValor().setText("");
				allInOrder = false;
			}
			try {
				Long.parseLong(valor);
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(vFacturarBaloto, "Digite solo numeros en el valor.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarBaloto.getValor().setText("");
				allInOrder = false;
			}
			}
			String num1 = vFacturarBaloto.getNum1().getText();
			String num2 = vFacturarBaloto.getNum2().getText();
			String num3 = vFacturarBaloto.getNum3().getText();
			String num4 = vFacturarBaloto.getNum4().getText();
			String num5 = vFacturarBaloto.getNum5().getText();
			String num6 = vFacturarBaloto.getNum6().getText();
			try {
				Integer.parseInt(num1);
				Integer.parseInt(num2);
				Integer.parseInt(num3);
				Integer.parseInt(num4);
				Integer.parseInt(num5);
				Integer.parseInt(num6);
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(vFacturarBaloto, "Digite solo numeros enteros en los numeros.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarBaloto.getNum1().setText("");
				vFacturarBaloto.getNum2().setText("");
				vFacturarBaloto.getNum3().setText("");
				vFacturarBaloto.getNum4().setText("");
				vFacturarBaloto.getNum5().setText("");
				vFacturarBaloto.getNum6().setText("");
				allInOrder = false;
			}
			
			if(valor.isEmpty()||cedula.isEmpty()||num1.isEmpty()||num2.isEmpty()||num3.isEmpty()||num4.isEmpty()||
					valor.isBlank()||cedula.isBlank()||num1.isBlank()||num2.isBlank()||num3.isBlank()||num4.isBlank()||
					     num5.isEmpty()||num6.isEmpty()||num5.isBlank()||num6.isBlank()) {
				JOptionPane.showMessageDialog(vFacturarBaloto, "Digite todos los datos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarBaloto.getNum1().setText("");
				vFacturarBaloto.getNum2().setText("");
				vFacturarBaloto.getNum3().setText("");
				vFacturarBaloto.getNum5().setText("");
				vFacturarBaloto.getNum6().setText("");
				vFacturarBaloto.getNum4().setText("");
				vFacturarBaloto.getValor().setText("");
				vFacturarBaloto.getCedula().setText("");
				allInOrder = false;
			}

			if(allInOrder) {
			double payment = Double.parseDouble(valor)*-1;
			apuestaBalotoDAO.create(sede,cedula,dSemana,valor,num1,num2,num3,num4,num5,num6);
			apuestaDAO.create(sede,cedula,dSemana,valor);
			apuestaBalotoDAO.addCarrito();
			apostadorDAO.actualizarSaldo(payment, cedula);
			JOptionPane.showMessageDialog(vFacturarBaloto, " Facturado con exito!", "Validacion",
					JOptionPane.INFORMATION_MESSAGE);
			}
			break;
		}
		
		case "vFacturarBetplay":{
			vFacturar.setVisible(false);
			vFacturarBetplay.setVisible(true);
			break;
		}
		
		case "vFacturarBetplaySalir":{
			vFacturarBetplay.setVisible(false);;
			vFacturar.setVisible(true);
			break;
		}
		case "vFacturarBetplayIngresar":{
			boolean allInOrder = true;
			String sede = vFacturarBetplay.getSede().getSelectedItem().toString();
			if (sedeDAO.checkSede(sede)) {
				JOptionPane.showMessageDialog(vFacturarBetplay, "No existe esta sede.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarBetplay.getSede().getSelectedItem().toString();
				allInOrder = false;
			}
			String cedula = vFacturarBetplay.getCedula().getText();
			if(cedula.isBlank()||cedula.isEmpty()) {
				JOptionPane.showMessageDialog(vFacturarBetplay, "Digite la cedula.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarBetplay.getCedula().setText("");
				break;
			}
			try {
				Long.parseLong(cedula);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(vFacturarBetplay, "La cedula solo consiste de numeros.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarBetplay.getCedula().setText("");
				allInOrder = false;
			}
			if(apostadorDAO.checkCedula(cedula)) {
				JOptionPane.showMessageDialog(vFacturarBetplay, "La cedula no esta registrada en nuestro sitema.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarBetplay.getCedula().setText("");
				allInOrder = false;
				break;
			}
			String dSemana = vFacturarBetplay.getDiaSemana().getSelectedItem().toString();
			String valor = vFacturarBetplay.getValor().getText();
			if(!valor.isBlank()||!valor.isEmpty()) {
			if(apuestaBetPlayDAO.checkValor(valor, apostadorDAO.getApostador(cedula).getSaldo())==1){
				JOptionPane.showMessageDialog(vFacturarBetplay, "Saldo insuficiente.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarBetplay.getValor().setText("");
				allInOrder = false;
			}else if(apuestaBetPlayDAO.checkValor(valor, apostadorDAO.getApostador(cedula).getSaldo())==0) {
				JOptionPane.showMessageDialog(vFacturarBetplay, "La minima apuesta son 200 pesos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarBetplay.getValor().setText("");
				allInOrder = false;
			}
			}
			String partido1 = vFacturarBetplay.getEquipos1().getSelectedItem().toString();
			String partido2 = vFacturarBetplay.getEquipos2().getSelectedItem().toString();
			if(partido1.equals(partido2)) {
				JOptionPane.showMessageDialog(vFacturarBetplay, "No se pueden enfrentar los mismo equipos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				allInOrder = false;
			}
			String partido = partido1+" VS "+partido2;
			String resultado = vFacturarBetplay.getResultados().getSelectedItem().toString();
			if(valor.isEmpty()||cedula.isEmpty()||valor.isBlank()||cedula.isBlank()) {
				JOptionPane.showMessageDialog(vFacturarBaloto, "Digite todos los datos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarBetplay.getValor().setText("");
				vFacturarBetplay.getCedula().setText("");
				allInOrder = false;
			}
			if(allInOrder) {
				double payment = Double.parseDouble(valor)*-1;
				apuestaBetPlayDAO.create(sede,cedula,dSemana,valor,partido,resultado);
				apuestaDAO.create(sede,cedula,dSemana,valor);
				apuestaBetPlayDAO.addCarrito();
				apostadorDAO.actualizarSaldo(payment, cedula);
				JOptionPane.showMessageDialog(vFacturarBetplay, " Facturado con exito!", "Validacion",
						JOptionPane.INFORMATION_MESSAGE);
				}
			break;
		}
		
		case "vFacturarChance":{
			vFacturar.setVisible(false);
			vFacturarChance.setVisible(true);
			break;
		}
		
		case "vFacturarChanceSalir":{
			vFacturarChance.setVisible(false);;
			vFacturar.setVisible(true);
			break;
		}

		case "vFacturarChanceIngresar":{
			boolean allInOrder = true;
			String sede = vFacturarChance.getSede().getSelectedItem().toString();
			if (sedeDAO.checkSede(sede)) {
				JOptionPane.showMessageDialog(vFacturarChance, "No existe esta sede.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarChance.getSede().getSelectedItem().toString();
				allInOrder = false;
			}
			String cedula = vFacturarChance.getCedula().getText();
			if(cedula.isBlank()||cedula.isEmpty()) {
				JOptionPane.showMessageDialog(vFacturarChance, "Digite la cedula.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarChance.getCedula().setText("");
				break;
			}
			try {
				Long.parseLong(cedula);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(vFacturarChance, "La cedula solo consiste de numeros.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarChance.getCedula().setText("");
				allInOrder = false;
			}
			if(apostadorDAO.checkCedula(cedula)) {
				JOptionPane.showMessageDialog(vFacturarChance, "La cedula no esta registrada en nuestro sitema.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarChance.getCedula().setText("");
				allInOrder = false;
				break;
			}
			String dSemana = vFacturarChance.getDiaSemana().getSelectedItem().toString();
			String valor = vFacturarChance.getValor().getText();
			if(!valor.isBlank()||!valor.isEmpty()) {
			if(apuestaChanceDAO.checkValor(valor, apostadorDAO.getApostador(cedula).getSaldo())==1){
				JOptionPane.showMessageDialog(vFacturarChance, "Saldo insuficiente.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarChance.getValor().setText("");
				allInOrder = false;
			}else if(apuestaChanceDAO.checkValor(valor, apostadorDAO.getApostador(cedula).getSaldo())==0) {
				JOptionPane.showMessageDialog(vFacturarChance, "La minima apuesta son 200 pesos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarChance.getValor().setText("");
				allInOrder = false;
			}
			try {
				Long.parseLong(valor);
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(vFacturarChance, "Digite solo numeros en el valor.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarChance.getValor().setText("");
				allInOrder = false;
			}
			}
			String num1 = vFacturarChance.getNum1().getText();
			String num2 = vFacturarChance.getNum2().getText();
			String num3 = vFacturarChance.getNum3().getText();
			String num4 = vFacturarChance.getNum4().getText();
			try {
				Integer.parseInt(num1);
				Integer.parseInt(num2);
				Integer.parseInt(num3);
				Integer.parseInt(num4);
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(vFacturarChance, "Digite solo numeros enteros en los numeros.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarChance.getNum1().setText("");
				vFacturarChance.getNum2().setText("");
				vFacturarChance.getNum3().setText("");
				vFacturarChance.getNum4().setText("");
				allInOrder = false;
			}
			String lotoName = vFacturarChance.getNombreLoteria().getText();
			if(valor.isEmpty()||cedula.isEmpty()||num1.isEmpty()||num2.isEmpty()||num3.isEmpty()||num4.isEmpty()||
					valor.isBlank()||cedula.isBlank()||num1.isBlank()||num2.isBlank()||num3.isBlank()||num4.isBlank()||
					     lotoName.isEmpty()||lotoName.isBlank()) {
				JOptionPane.showMessageDialog(vFacturarChance, "Digite todos los datos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarChance.getNum1().setText("");
				vFacturarChance.getNum2().setText("");
				vFacturarChance.getNum3().setText("");
				vFacturarChance.getNombreLoteria().setText("");
				vFacturarChance.getNum4().setText("");
				vFacturarChance.getValor().setText("");
				vFacturarChance.getCedula().setText("");
				allInOrder = false;
			}
			if(allInOrder) {
				double payment = Double.parseDouble(valor)*-1;
				apuestaChanceDAO.create(sede,cedula,dSemana,valor,lotoName,num1,num2,num3,num4);
				apuestaDAO.create(sede,cedula,dSemana,valor);
				apuestaChanceDAO.addCarrito();
				apostadorDAO.actualizarSaldo(payment, cedula);
				JOptionPane.showMessageDialog(vFacturarChance, " Facturado con exito!", "Validacion",
						JOptionPane.INFORMATION_MESSAGE);
				}
			break;
		}
		case "vFacturarLoteria":{
			vFacturar.setVisible(false);
			vFacturarLoteria.setVisible(true);
			break;
		}
		
		case "vFacturarLoteriaSalir":{
			vFacturarLoteria.setVisible(false);;
			vFacturar.setVisible(true);
			break;
		}
		case "vFacturarLoteriaIngresar":{
			boolean allInOrder = true;
			String sede = vFacturarLoteria.getSede().getSelectedItem().toString();
			if (sedeDAO.checkSede(sede)) {
				JOptionPane.showMessageDialog(vFacturarLoteria, "No existe esta sede.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarLoteria.getSede().getSelectedItem().toString();
				allInOrder = false;
			}
			String cedula = vFacturarLoteria.getCedula().getText();
			if(cedula.isBlank()||cedula.isEmpty()) {
				JOptionPane.showMessageDialog(vFacturarLoteria, "Digite la cedula.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarLoteria.getCedula().setText("");
				break;
			}
			try {
				Long.parseLong(cedula);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(vFacturarLoteria, "La cedula solo consiste de numeros.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarLoteria.getCedula().setText("");
				allInOrder = false;
			}
			if(apostadorDAO.checkCedula(cedula)) {
				JOptionPane.showMessageDialog(vFacturarLoteria, "La cedula no esta registrada en nuestro sitema.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarLoteria.getCedula().setText("");
				allInOrder = false;
				break;
			}
			String dSemana = vFacturarLoteria.getDiaSemana().getSelectedItem().toString();
			String valor = vFacturarLoteria.getValor().getText();
			if(!valor.isBlank()||!valor.isEmpty()) {
			if(apuestaLoteriaDAO.checkValor(valor, apostadorDAO.getApostador(cedula).getSaldo())==1){
				JOptionPane.showMessageDialog(vFacturarLoteria, "Saldo insuficiente.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarLoteria.getValor().setText("");
				allInOrder = false;
			}else if(apuestaLoteriaDAO.checkValor(valor, apostadorDAO.getApostador(cedula).getSaldo())==0) {
				JOptionPane.showMessageDialog(vFacturarLoteria, "La minima apuesta son 200 pesos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarLoteria.getValor().setText("");
				allInOrder = false;
			}
			try {
				Long.parseLong(valor);
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(vFacturarChance, "Digite solo numeros en el valor.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarChance.getValor().setText("");
				allInOrder = false;
			}
			}
			String num1 = vFacturarLoteria.getNum1().getText();
			String num2 = vFacturarLoteria.getNum2().getText();
			String num3 = vFacturarLoteria.getNum3().getText();
			String num4 = vFacturarLoteria.getNum4().getText();
			String ser = vFacturarLoteria.getSerie().getText();
			try {
				checkSerieFormat(ser);
			} catch (UnvalidSerieFormatException e2) {
				allInOrder = false;
			}
			try {
				Integer.parseInt(num1);
				Integer.parseInt(num2);
				Integer.parseInt(num3);
				Integer.parseInt(num4);
				Integer.parseInt(ser);
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(vFacturarLoteria, "Digite solo numeros enteros en los numeros.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarLoteria.getNum1().setText("");
				vFacturarLoteria.getNum2().setText("");
				vFacturarLoteria.getNum3().setText("");
				vFacturarLoteria.getNum4().setText("");
				vFacturarLoteria.getSerie().setText("");
				allInOrder = false;
			}
			String lotoName = vFacturarLoteria.getNombreLoteria().getText();
			if(valor.isEmpty()||cedula.isEmpty()||num1.isEmpty()||num2.isEmpty()||num3.isEmpty()||num4.isEmpty()||
					valor.isBlank()||cedula.isBlank()||num1.isBlank()||num2.isBlank()||num3.isBlank()||num4.isBlank()||
					     lotoName.isEmpty()||lotoName.isBlank()||ser.isBlank()||ser.isEmpty()) {
				JOptionPane.showMessageDialog(vFacturarLoteria, "Digite todos los datos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vFacturarLoteria.getNum1().setText("");
				vFacturarLoteria.getNum2().setText("");
				vFacturarLoteria.getNum3().setText("");
				vFacturarLoteria.getNombreLoteria().setText("");
				vFacturarLoteria.getNum4().setText("");
				vFacturarLoteria.getValor().setText("");
				vFacturarLoteria.getCedula().setText("");
				vFacturarLoteria.getSerie().setText("");
				allInOrder = false;
			}
			if(allInOrder) {
				double payment = Double.parseDouble(valor)*-1;
				apuestaLoteriaDAO.create(sede,cedula,dSemana,valor,lotoName,num1,num2,num3,num4,ser);
				apuestaDAO.create(sede,cedula,dSemana,valor);
				apuestaLoteriaDAO.addCarrito();
				apostadorDAO.actualizarSaldo(payment, cedula);
				JOptionPane.showMessageDialog(vFacturarLoteria, " Facturado con exito!", "Validacion",
						JOptionPane.INFORMATION_MESSAGE);
				}
			break;
		}
		
		// VENTANA RECIBO -----------------------------
		
		
		// VENTANA SEDES ------------------------------------------------

		case "vSedesRegresar": {
			vSedes.setVisible(false);
			vGestionesAdmin.setVisible(true);
			break;
		}

		case "vSedesCrear": {
			vSedes.setVisible(false);
			vCrearSede.setVisible(true);
			break;
		}

		case "vDigitSedeRegresar": {
			vCrearSede.setVisible(false);
			vSedes.setVisible(true);
			break;
		}

		case "vDigitSedeIngresar": {
			boolean allInOrder = true;
			String ubicacion = vCrearSede.getUbicacion().getSelectedItem().toString();
			String empleados = vCrearSede.getEmpleados().getText();
			try {
				Integer.parseInt(empleados);
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(vCrearSede, "Digite un numero entero en al casilla de empleados.",
						"Error", JOptionPane.ERROR_MESSAGE);
				vCrearSede.getEmpleados().setText("");
				allInOrder = false;
			}
			if (ubicacion.isEmpty() || empleados.isEmpty() || ubicacion.isBlank() || empleados.isBlank()) {
				JOptionPane.showMessageDialog(vCrearSede, "Debe llenar todos los datos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				allInOrder = false;
			}
			if (!sedeDAO.checkSede(ubicacion)) {
				JOptionPane.showMessageDialog(vCrearSede, "Ya existe una sede en esa ubicacion.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vCrearSede.getUbicacion().getSelectedItem().toString();
				allInOrder = false;
			}
			if(!sedeDAO.maxSedes(configProperties.getProperty(
					"PRF_PROG1_20232_CorderoJayder_GalindoJuan_GalvanEliana_JaramilloJorge.properties.numeroDeSedes"))) {
					JOptionPane.showMessageDialog(vCrearSede, "Se ha alcansado el numero maximo de sedes permitidas.", "Error",
							JOptionPane.ERROR_MESSAGE);
					vCrearSede.getUbicacion().getSelectedItem().toString();
					allInOrder = false;
			}
			if (allInOrder) {
				sedeDAO.create(ubicacion, empleados);
				JOptionPane.showMessageDialog(vCrearSede, " Creado con exito!", "Validacion",
						JOptionPane.INFORMATION_MESSAGE);
				vCrearSede.getUbicacion().getSelectedItem().toString();
				vCrearSede.getEmpleados().setText("");
				vCrearSede.setVisible(false);
				vSedes.setVisible(true);
			}
			break;
		}

		case "vSedesBuscar": {
			vSedes.setVisible(false);
			vBuscarSede.setVisible(true);
			break;
		}
		case "vSearchSedeRegresar": {
			vBuscarSede.setVisible(false);
			vSedes.setVisible(true);
			break;
		}
		case "vSearchSedeIngresar": {
			String ubicacion = vBuscarSede.getUbicacion().getSelectedItem().toString();
			if (sedeDAO.getSede(ubicacion) != null) {
				vShowSede.uploadData(sedeDAO.getSede(ubicacion));
				vBuscarSede.setVisible(false);
				vShowSede.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(vBuscarSede, "No existe una sede en esta ubicacion.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vBuscarSede.getUbicacion().getSelectedItem().toString();
			}
			break;
		}
		case "vShowSedeRegresar": {
			vShowSede.setVisible(false);
			vBuscarSede.setVisible(true);
			break;
		}
		case "vSedesMostrar": {
			vTablaSedes = new VentanaTablaSedes(sedeDAO.returnList());

			vTablaSedes.setVisible(true);
			break;
		}
		case "vSedesActualizar": {
			vSedes.setVisible(false);
			vActualizarSede.setVisible(true);
			break;
		}
		case "vSearchSedeARegresar": {
			vActualizarSede.setVisible(false);
			vSedes.setVisible(true);
			break;
		}
		case "vSearchSedeAIngresar": {
			String ubicacion = vActualizarSede.getUbicacion().getSelectedItem().toString();
			if (sedeDAO.getSede(ubicacion) != null) {

				JOptionPane.showMessageDialog(vActualizarSede, " A continuacion digite los nuevos datos", "Validacion",
						JOptionPane.INFORMATION_MESSAGE);
				vActualizarSede.setVisible(false);
				vDigitActualizarSede.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(vActualizarSede, "No existe una sede en esta ubicacion.", "Error",
						JOptionPane.ERROR_MESSAGE);

			}
			break;
		}
		case "vDigitSedeAIngresar": {
			boolean allInOrder = true;
			int index = sedeDAO.returnIndex(vActualizarSede.getUbicacion().getSelectedItem().toString());
			String empleados = vDigitActualizarSede.getEmpleados().getText();
			try {
				Integer.parseInt(empleados);
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(vDigitActualizarSede,
						"Digite un numero entero en al casilla de empleados.", "Error", JOptionPane.ERROR_MESSAGE);
				vDigitActualizarSede.getEmpleados().setText("");
				allInOrder = false;
			}
			if (allInOrder) {
				if (sedeDAO.update(index, empleados)) {
					JOptionPane.showMessageDialog(vDigitActualizarSede, " Actualizado con exito", "Validacion",
							JOptionPane.INFORMATION_MESSAGE);
					vActualizarSede.getUbicacion().getSelectedItem().toString();
					vDigitActualizarSede.getEmpleados().setText("");
					vDigitActualizarSede.setVisible(false);
					vSedes.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(vDigitActualizarSede, "No se pudo actualizar.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
			break;
		}
		case "vDigitSedeARegresar": {
			vDigitActualizarSede.setVisible(false);
			vActualizarSede.setVisible(true);
			break;
		}
		case "vSedesBorrar": {
			vSedes.setVisible(false);
			vBorrarSede.setVisible(true);
			break;
		}
		case "vSearchSedeDRegresar": {
			vBorrarSede.setVisible(false);
			vSedes.setVisible(true);
			break;
		}
		case "vSearchSedeDIngresar": {
			int index = sedeDAO.returnIndex(vBorrarSede.getUbicacion().getSelectedItem().toString());
			if (sedeDAO.delete(index)) {
				JOptionPane.showMessageDialog(vBorrarSede, " Borrado con exito", "Validacion",
						JOptionPane.INFORMATION_MESSAGE);
				vBorrarSede.getUbicacion().getSelectedItem().toString();
				vBorrarSede.setVisible(false);
				vSedes.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(vBorrarSede, "No se pudo borrar.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		}

		// VENTANAS APOSTADORES ----------------------------------------

		case "vApostadoresRegresar": {
			vApostadores.setVisible(false);
			vGestionesAdmin.setVisible(true);
			break;
		}
		case "vGestionesApostadores": {
			vGestionesAdmin.setVisible(false);
			vApostadores.setVisible(true);
			break;
		}
		case "vApostadoresCrear": {
			vApostadores.setVisible(false);
			vCrearApostador.setVisible(true);
			break;
		}
		case "vCApostador1Regresar": {
			vCrearApostador.setVisible(false);
			vApostadores.setVisible(true);
			break;
		}
		case "vCApostadorIngresar": {
			boolean allInOrder = true;
			String nombre = vCrearApostador.getNombreCompleto().getText();
			try {
				checkName(nombre);
			} catch (UnvalidNameException e1) {
				vCrearApostador.getNombreCompleto().setText("");
				allInOrder = false;
			}
			String celular = vCrearApostador.getCelular().getText();
			try {
				checkCellFormat(celular);
			} catch (Exception e1) {
				vCrearApostador.getCelular().setText("");
				allInOrder = false;
			}
			String cedula = vCrearApostador.getCedula().getText();
			if(!cedula.isBlank()||!cedula.isEmpty()) {
			try {
				Long.parseLong(cedula);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(vCrearApostador, "La cedula solo consiste de numeros.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vCrearApostador.getCedula().setText("");
				allInOrder = false;
			}
			if(!apostadorDAO.checkCedula(cedula)) {
				JOptionPane.showMessageDialog(vCrearApostador, "Cedula ya resgistrada en el sistema.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vCrearApostador.getCedula().setText("");
				allInOrder = false;
			}
			}
			String direccion = vCrearApostador.getDireccion().getText();
			String sede = vCrearApostador.getSedeJuego().getSelectedItem().toString();

			if (sedeDAO.checkSede(sede)) {
				JOptionPane.showMessageDialog(vCrearApostador, "No existe esta sede.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vAtributos.getSedeJuego().getSelectedItem().toString();
				allInOrder = false;
			}
			if (nombre.isEmpty() || cedula.isEmpty() || sede.isEmpty() || direccion.isEmpty() || celular.isEmpty()
					|| nombre.isBlank() || cedula.isBlank() || sede.isBlank() || direccion.isBlank()
					|| celular.isBlank()) {
				JOptionPane.showMessageDialog(vCrearApostador, "Debe llenar todos los datos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				allInOrder = false;
			}
			if (allInOrder) {
				apostadorDAO.create(nombre, cedula, sede, direccion, celular, "N/A", "N/A");
				JOptionPane.showMessageDialog(vCrearApostador, " Creado con exito!", "Validacion",
						JOptionPane.INFORMATION_MESSAGE);
				vCrearApostador.getNombreCompleto().setText("");
				vCrearApostador.getCedula().setText("");
				vAtributos.getSedeJuego().getSelectedItem().toString();
				vCrearApostador.getDireccion().setText("");
				vCrearApostador.getCelular().setText("");
				vCrearApostador.setVisible(false);
				vApostadores.setVisible(true);
			}
			break;
		}
		case "vApostadoresMostar": {
			vTablaApostadores = new VentanaTablaApostadores(apostadorDAO.returnList());
			vTablaApostadores.setVisible(true);
			break;
		}
		case "vApostadoresActualizar": {
			vApostadores.setVisible(false);
			vBuscarActualizarApostador.setVisible(true);
			break;
		}
		case "vCApostadorARegresar": {
			vEdicionApostador.setVisible(false);
			vBuscarApostador.setVisible(true);
			break;
		}
		case "vCApostadorAIngresar": {
			boolean allInOrder = true;
			String nombre = vEdicionApostador.getNombreCompleto().getText();
			try {
				checkName(nombre);
			} catch (UnvalidNameException e1) {
				vEdicionApostador.getNombreCompleto().setText("");
				allInOrder = false;
			}
			String celular = vEdicionApostador.getCelular().getText();
			try {
				checkCellFormat(celular);
			} catch (Exception e1) {
				vEdicionApostador.getCelular().setText("");
				allInOrder = false;
			}
			String cedula = vEdicionApostador.getCedula().getText();
			try {
				Long.parseLong(cedula);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(vEdicionApostador, "La cedula solo consiste de numeros.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vEdicionApostador.getCedula().setText("");
				allInOrder = false;
			}
			String direccion = vEdicionApostador.getDireccion().getText();
			String sede = vEdicionApostador.getSedeJuego().getSelectedItem().toString();
			if (sedeDAO.checkSede(sede)) {
				JOptionPane.showMessageDialog(vEdicionApostador, "No existe esta sede.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vEdicionApostador.getSedeJuego().getSelectedItem().toString();
				allInOrder = false;
			}

			if (nombre.isEmpty() || cedula.isEmpty() || sede.isEmpty() || direccion.isEmpty() || celular.isEmpty()
					|| nombre.isBlank() || cedula.isBlank() || sede.isBlank() || direccion.isBlank()
					|| celular.isBlank()) {
				JOptionPane.showMessageDialog(vEdicionApostador, "Debe llenar todos los datos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				allInOrder = false;
			}
			if (allInOrder) {
				apostadorDAO.create(nombre, cedula, sede, direccion, celular, "N/A", "N/A");
				JOptionPane.showMessageDialog(vEdicionApostador, " Actualizado con exito!", "Validacion",
						JOptionPane.INFORMATION_MESSAGE);
				vEdicionApostador.getNombreCompleto().setText("");
				vEdicionApostador.getCedula().setText("");
				vEdicionApostador.getSedeJuego().getSelectedItem().toString();
				vEdicionApostador.getDireccion().setText("");
				vEdicionApostador.getCelular().setText("");
				vEdicionApostador.setVisible(false);
				vApostadores.setVisible(true);
			}
			break;
		}
		case "vSearchApostadorARegresar": {
			vBuscarActualizarApostador.setVisible(false);
			vApostadores.setVisible(true);
			break;
		}
		case "vSearchApostadorAIngresar": {
			boolean allInOrder = true;
			String cedula = vBuscarActualizarApostador.getcedula().getText();
			try {
				Long.parseLong(cedula);
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(vBuscarActualizarApostador, "La cedula solo consiste de numeros.",
						"Error", JOptionPane.ERROR_MESSAGE);
				vBuscarActualizarApostador.getcedula().setText("");
				allInOrder = false;
			}
			if (allInOrder) {
				if (apostadorDAO.getApostador(cedula) != null) {

					JOptionPane.showMessageDialog(vBuscarActualizarApostador, " A continuacion digite los nuevos datos",
							"Validacion", JOptionPane.INFORMATION_MESSAGE);
					vBuscarActualizarApostador.setVisible(false);
					vEdicionApostador.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(vBuscarActualizarApostador, "No existe este apostador.", "Error",
							JOptionPane.ERROR_MESSAGE);

				}
			}
			break;
		}
		case "vApostadoresBorrar": {
			vApostadores.setVisible(false);
			vEliminarApostador.setVisible(true);
			break;
		}
		case "vSearchApostadorDRegresar": {
			vEliminarApostador.setVisible(false);
			vApostadores.setVisible(true);
			break;
		}
		case "vSearchApostadorDIngresar": {
			
			try {
				Long.parseLong(vEliminarApostador.getcedula().getText());
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(vEliminarApostador, "Digite solo numeros en la cedula.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vEliminarApostador.getcedula().setText("");
			}
			
			int index = apostadorDAO.returnIndex(vEliminarApostador.getcedula().getText());
			
			
			if (apostadorDAO.delete(index)) {
				JOptionPane.showMessageDialog(vEliminarApostador, " Borrado con exito", "Validacion",
						JOptionPane.INFORMATION_MESSAGE);
				vEliminarApostador.getcedula().setText("");
				vEliminarApostador.setVisible(false);
				vApostadores.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(vEliminarApostador, "No se pudo borrar.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vEliminarApostador.getcedula().setText("");
			}
			break;
		}
		case "vApostadoresBuscar": {
			vApostadores.setVisible(false);
			vBuscarApostador.setVisible(true);
			break;
		}

		case "vSearchApostadorRegresar": {
			vBuscarApostador.setVisible(false);
			vApostadores.setVisible(true);
			break;
		}

		case "vSearchApostadorIngresar": {
			String cedula = vBuscarApostador.getcedula().getText();
			if (apostadorDAO.getApostador(cedula) != null) {
				vShowApostador.uploadData(apostadorDAO.getApostador(cedula));
				vBuscarApostador.setVisible(false);
				vShowApostador.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(vBuscarApostador, "No existe una sede en esta ubicacion.", "Error",
						JOptionPane.ERROR_MESSAGE);
				vBuscarApostador.getcedula().setText("");
			}
			break;
		}
		case "vShowApostadorRegresar": {
			vShowApostador.setVisible(false);
			vBuscarApostador.setVisible(true);
			break;
		}

		// VENTANA CASA --------------------------------------------
		case "vGestionCasas": {
			vGestionesAdmin.setVisible(false);
			vCasas.setVisible(true);
			break;
		}
		case "vCasaRegresar": {
			vCasas.setVisible(false);
			vGestionesAdmin.setVisible(true);
			break;
		}
		case "vCasaMostrar": {
			vShowCasa.uploadData(configProperties.getProperty(
					"PRF_PROG1_20232_CorderoJayder_GalindoJuan_GalvanEliana_JaramilloJorge.properties.nombreDeCasa"),
					configProperties.getProperty(
							"PRF_PROG1_20232_CorderoJayder_GalindoJuan_GalvanEliana_JaramilloJorge.properties.presupuesto"),
					configProperties.getProperty(
							"PRF_PROG1_20232_CorderoJayder_GalindoJuan_GalvanEliana_JaramilloJorge.properties.numeroDeSedes"));
			vCasas.setVisible(false);
			vShowCasa.setVisible(true);
			break;
		}
		case "vShowCasaRegresar": {
			vShowCasa.setVisible(false);
			vCasas.setVisible(true);
			break;
		}
		case "vCasaEditar": {
			vCasas.setVisible(false);
			vDigitCasa.setVisible(true);
			break;
		}
		case "vDigitCasaRegresar": {
			vDigitCasa.setVisible(false);
			vCasas.setVisible(true);
			break;
		}
		case "vDigitCasaIngresar": {
			String nombre = vDigitCasa.getnombre().getText();
			String presupuesto = vDigitCasa.getpresupuesto().getText();
			String cantSedes = vDigitCasa.getcantSedes().getText();

			configProperties.setProperty(
					"PRF_PROG1_20232_CorderoJayder_GalindoJuan_GalvanEliana_JaramilloJorge.properties.nombreDeCasa",
					nombre);
			configProperties.setProperty(
					"PRF_PROG1_20232_CorderoJayder_GalindoJuan_GalvanEliana_JaramilloJorge.properties.presupuesto",
					presupuesto);
			configProperties.setProperty(
					"PRF_PROG1_20232_CorderoJayder_GalindoJuan_GalvanEliana_JaramilloJorge.properties.numeroDeSedes",
					cantSedes);

			if (cantSedes != null && presupuesto != null && nombre != null) {
				JOptionPane.showMessageDialog(vDigitCasa, " Actualizado con exito!", "Validacion",
						JOptionPane.INFORMATION_MESSAGE);
				Config();
				vDigitCasa.setVisible(false);
				vCasas.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(vDigitCasa, "Error al actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		}

		// VENTANA INFORMACION ---------------------------------------

		case "vIngresarJuego": {
			vInfo.setVisible(false);
			vUsuario.setVisible(true);
			break;
		}
		
		// VENTANA SELECCION DE JUEGOS ---------------------------------------

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

		//VENTANA JUEGOS ----------------------------------------
				case "vGestionJuegos":{
					
					vJuegos.updateData(configProperties.getProperty(
							"PRF_PROG1_20232_CorderoJayder_GalindoJuan_GalvanEliana_JaramilloJorge.properties.presupuesto"));
					vGestionesAdmin.setVisible(false);
					vJuegos.setVisible(true);
					break;
				}
				case "vJuegosRegresar":{
					vJuegos.setVisible(false);
					vGestionesAdmin.setVisible(true);
					break;
				}
				case "vJuegosIngresar":{

					boolean allInOrder = true;
					String data1 = vJuegos.getBaloto().getText();
					String data2 = vJuegos.getSuperastro().getText();
					String data3 = vJuegos.getBetPlay().getText();
					String data4 = vJuegos.getChance().getText();
					String data5 = vJuegos.getLoteria().getText();
					String total = "100";
					
					try {
						Float.parseFloat(data1);
						Float.parseFloat(data2);
						Float.parseFloat(data3);
						Float.parseFloat(data4);
						Float.parseFloat(data5);
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(vJuegos, "Ingrese solo numeros en los pocentajes."
								,"Error",JOptionPane.ERROR_MESSAGE);
						vJuegos.getBaloto().setText("");
						vJuegos.getSuperastro().setText("");
						vJuegos.getBetPlay().setText("");
						vJuegos.getChance().setText("");
						vJuegos.getLoteria().setText("");
						allInOrder = false;
					}
					
					if(data1.isEmpty()||data1.isBlank()||data2.isEmpty()||data2.isBlank()||data3.isEmpty()||data3.isBlank()||
							data4.isEmpty()||data4.isBlank()||data5.isEmpty()||data5.isBlank()) {
						JOptionPane.showMessageDialog(vJuegos, "Digite todos los datos."
								,"Error",JOptionPane.ERROR_MESSAGE);
						allInOrder = false;
					}
					
					if(allInOrder) {
					float rData1 = (Float.parseFloat(data1)/100)*Float.parseFloat(configProperties.getProperty(
							"PRF_PROG1_20232_CorderoJayder_GalindoJuan_GalvanEliana_JaramilloJorge.properties.presupuesto"));
					float rData2 = (Float.parseFloat(data2)/100)*Float.parseFloat(configProperties.getProperty(
							"PRF_PROG1_20232_CorderoJayder_GalindoJuan_GalvanEliana_JaramilloJorge.properties.presupuesto"));
					float rData3 = (Float.parseFloat(data3)/100)*Float.parseFloat(configProperties.getProperty(
							"PRF_PROG1_20232_CorderoJayder_GalindoJuan_GalvanEliana_JaramilloJorge.properties.presupuesto"));
					float rData4 = (Float.parseFloat(data4)/100)*Float.parseFloat(configProperties.getProperty(
							"PRF_PROG1_20232_CorderoJayder_GalindoJuan_GalvanEliana_JaramilloJorge.properties.presupuesto"));
					float rData5 = (Float.parseFloat(data5)/100)*Float.parseFloat(configProperties.getProperty(
							"PRF_PROG1_20232_CorderoJayder_GalindoJuan_GalvanEliana_JaramilloJorge.properties.presupuesto"));
					
					
					if(juegoDAO.checkBudget(data1, data2, data3, data4, data5, total)&&(juegoDAO.returnLits().size()==0)) {
						juegoDAO.create("Baloto","Baloto", Float.toString(rData1));
						juegoDAO.create("SuperAstro","SuperAstro",Float.toString(rData2));
						juegoDAO.create("BetPlay","BetPlay",Float.toString(rData3));
						juegoDAO.create("Chance","Chance",Float.toString(rData4));
						juegoDAO.create("Loteria","Loteria",Float.toString(rData5));
						JOptionPane.showMessageDialog(vJuegos, "Presupuestos actualizados!","Validacion",JOptionPane.INFORMATION_MESSAGE);
					}else if(juegoDAO.checkBudget(data1, data2, data3, data4, data5, total)&&(juegoDAO.returnLits().size()>0)) {
						juegoDAO.update(0,"Baloto","Baloto", Float.toString(rData1));
						juegoDAO.update(1,"SuperAstro","SuperAstro",Float.toString(rData2));
						juegoDAO.update(2,"BetPlay","BetPlay", Float.toString(rData3));
						juegoDAO.update(3,"Chance","Chance", Float.toString(rData4));
						juegoDAO.update(4,"Loteria","Loteria", Float.toString(rData5));
						JOptionPane.showMessageDialog(vJuegos, "Presupuestos actualizados","Validacion",JOptionPane.INFORMATION_MESSAGE);
					}else if(!juegoDAO.checkBudget(data1, data2, data3, data4, data5, total)) {
						JOptionPane.showMessageDialog(vJuegos, "La suma de los porcentajes debe ser igual al 100%."
								,"Error",JOptionPane.ERROR_MESSAGE);
						vJuegos.getBaloto().setText("");
						vJuegos.getSuperastro().setText("");
						vJuegos.getBetPlay().setText("");
						vJuegos.getChance().setText("");
						vJuegos.getLoteria().setText("");
					}else {
						JOptionPane.showMessageDialog(vJuegos, "Error al actualizar."
								,"Error",JOptionPane.ERROR_MESSAGE);
					}
					}
					break;
				}
				case "vJuegosConsultar":{
					vTablaJuegos = new VentanaTablaJuegos(juegoDAO.returnLits());
					vTablaJuegos.setVisible(true);
					break;
				}
				
		// VENTANAS YA DE LOS JUEGOS
		// -------------------------------------------------------------------

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
	
	public void loadConfig() {
		try {
			configProperties.load(new BufferedReader(new FileReader("src/co/edu/unbosque/model/persistence/config.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void Config() {
		try {
			configProperties.store(new FileWriter("src/co/edu/unbosque/model/persistence/config.properties"),"");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// EXCEPTIONS ------------------------------------------
	public void checkName(String data) throws UnvalidNameException {
		for (char c : data.toCharArray()) {
			if (!Character.isAlphabetic(c) && !Character.isWhitespace(c)) {
				JOptionPane.showMessageDialog(vContrasenias, "Ningun nombre puede tener numeros o simbolos.",
						"Error - Name", JOptionPane.ERROR_MESSAGE);
				throw new UnvalidNameException("Ningun nombre puede tener numeros o simbolos.");
			}
		}
	}

	public void checkCellFormat(String data) throws CellPhoneFormatException {
		int count = 0;
		try {
			Long.parseLong(data);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(vContrasenias, "Un numero de celular solo consiste de numeros.",
					"Error - Name", JOptionPane.ERROR_MESSAGE);
			throw new CellPhoneFormatException("Un numero de celular solo consiste de numeros.");
		}
		int n = data.toCharArray().length;
		for (int i = 0; i < n; i++) {
			count++;
		}
		if (count != 10) {
			JOptionPane.showMessageDialog(vContrasenias, "Un numero de celular Colombiano tiene 10 digitos.",
					"Error - Name", JOptionPane.ERROR_MESSAGE);
			throw new CellPhoneFormatException("Un numero de celular Colombiano tiene 10 digitos.");
		}

	}
	public void checkSerieFormat(String data) throws UnvalidSerieFormatException{
		int count = 0;
		for (int i = 0; i < data.toCharArray().length; i++) {
			count++;
		}
		if(count!=3) {
			JOptionPane.showMessageDialog(vFacturarLoteria, "La serie consiste de 3 numeros enteros.",
					"Error - Name", JOptionPane.ERROR_MESSAGE);
			throw new UnvalidSerieFormatException("La serie consiste de 3 numeros enteros.");
		}
	}

}
