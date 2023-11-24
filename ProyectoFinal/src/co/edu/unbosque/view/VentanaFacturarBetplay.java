package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import co.edu.unbosque.model.SedeDTO;

public class VentanaFacturarBetplay extends JFrame {

	private JTextField cedula, valor;
	private JButton salir, ingresar;
	private JComboBox<String> sede;
	private JComboBox<String> diaSemana;
	private JComboBox<String> equipos1;
	private JComboBox<String> equipos2;
	private JComboBox<String> resultados;
	private String[] localidadesBogota = { "Chapinero", "Usaquén", "Kennedy", "Suba", "Fontibón", "Engativá",
			"Teusaquillo", "Santa Fe" };
	private String[] diasSemana = { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };
	private String[] partidoRespuestas = { "Local", "Empate", "Visitante" };
	private String[] equiposPaises = { "Colombia", "Venezuela", "Chile", "Francia", "Argentina", "Portugal", "Corea",
				"Brasil", "Espania", "USA", "Alemania", "Croacia" };
	private JLabel imagenFondo;

	public VentanaFacturarBetplay() {

		setSize(1150, 700);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setUndecorated(true);

		salir = new JButton("REGRESAR");
		salir.setFont(new Font("Nue Gothic", 1, 20));
		salir.setForeground(Color.WHITE);
		salir.setBackground(new Color(200, 200, 200));
		salir.setOpaque(false);
		salir.setContentAreaFilled(false);
		salir.setBorderPainted(false);
		salir.setBounds(-6, 660, 120, 30);
		salir.setToolTipText("Regresa al Menu Anterior");
		add(salir);

		sede = new JComboBox<>(localidadesBogota);
		sede.setFont(new Font("Nue Gothic", Font.PLAIN, 18));
		sede.setBounds(220, 248, 325, 50);
		sede.setToolTipText("Selecciona la Sede del Juego");
		add(sede);

		cedula = new JTextField();
		cedula.setBounds(635, 235, 300, 50);
		cedula.setBorder(null); 
		cedula.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		cedula.setBackground(new java.awt.Color(0, 0, 0, 1));
		cedula.setToolTipText("Ingresa la Cedula del Jugador");
		add(cedula);

		diaSemana = new JComboBox<>(diasSemana);
		diaSemana.setFont(new Font("Nue Gothic", Font.PLAIN, 18));
		diaSemana.setBounds(220, 360, 325, 50);
		diaSemana.setToolTipText("Selecciona el Día de la Semana");
		add(diaSemana);
		
		equipos1 = new JComboBox<>(equiposPaises);
		equipos1.setFont(new Font("Nue Gothic", Font.PLAIN, 18));
		equipos1.setBounds(210, 480, 140, 50);
		equipos1.setToolTipText("Selecciona el Equipo Local");
		add(equipos1);
		
		equipos2 = new JComboBox<>(equiposPaises);
		equipos2.setFont(new Font("Nue Gothic", Font.PLAIN, 18));
		equipos2.setBounds(410, 480, 140, 50);
		equipos2.setToolTipText("Selecciona el Equipo Visitante");
		add(equipos2);
		
		valor = new JTextField();
		valor.setBounds(635, 352, 300, 50);
		valor.setBorder(null); 
		valor.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		valor.setBackground(new java.awt.Color(0, 0, 0, 1));
		valor.setToolTipText("Ingresa el Valor a Apostar");
		add(valor);
		
		resultados = new JComboBox<>(partidoRespuestas);
		resultados.setFont(new Font("Nue Gothic", Font.PLAIN, 18));
		resultados.setBounds(630, 480, 300, 50);
		resultados.setToolTipText("Selecciona el Equipo Visitante");
		add(resultados);
		
		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, getWidth(), getHeight());
		Image temp;
		temp = new ImageIcon("src/Imagenes/FacturarBetplay.png").getImage();
		ImageIcon img;
		img = new ImageIcon(
				temp.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
		imagenFondo.setIcon(img);
		add(imagenFondo);
		
		ingresar = new JButton();
		ingresar.setOpaque(false);
		ingresar.setBounds(225, 554, 698, 52);
		ingresar.setToolTipText("Siguiente para Registrar Usuario y Contrasenia");
		add(ingresar);
		
	}

	public JTextField getCedula() {
		return cedula;
	}

	public void setCedula(JTextField cedula) {
		this.cedula = cedula;
	}

	public JTextField getValor() {
		return valor;
	}

	public void setValor(JTextField valor) {
		this.valor = valor;
	}

	public JButton getSalir() {
		return salir;
	}

	public void setSalir(JButton salir) {
		this.salir = salir;
	}

	public JButton getIngresar() {
		return ingresar;
	}

	public void setIngresar(JButton ingresar) {
		this.ingresar = ingresar;
	}

	public JComboBox<String> getSede() {
		return sede;
	}

	public void setSede(JComboBox<String> sede) {
		this.sede = sede;
	}

	public JComboBox<String> getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(JComboBox<String> diaSemana) {
		this.diaSemana = diaSemana;
	}

	public JComboBox<String> getEquipos1() {
		return equipos1;
	}

	public void setEquipos1(JComboBox<String> equipos1) {
		this.equipos1 = equipos1;
	}

	public JComboBox<String> getEquipos2() {
		return equipos2;
	}

	public void setEquipos2(JComboBox<String> equipos2) {
		this.equipos2 = equipos2;
	}

	public JComboBox<String> getResultados() {
		return resultados;
	}

	public void setResultados(JComboBox<String> resultados) {
		this.resultados = resultados;
	}

	public String[] getLocalidadesBogota() {
		return localidadesBogota;
	}

	public void setLocalidadesBogota(String[] localidadesBogota) {
		this.localidadesBogota = localidadesBogota;
	}

	public String[] getDiasSemana() {
		return diasSemana;
	}

	public void setDiasSemana(String[] diasSemana) {
		this.diasSemana = diasSemana;
	}

	public String[] getPartidoRespuestas() {
		return partidoRespuestas;
	}

	public void setPartidoRespuestas(String[] partidoRespuestas) {
		this.partidoRespuestas = partidoRespuestas;
	}

	public String[] getEquiposPaises() {
		return equiposPaises;
	}

	public void setEquiposPaises(String[] equiposPaises) {
		this.equiposPaises = equiposPaises;
	}

	public JLabel getImagenFondo() {
		return imagenFondo;
	}

	public void setImagenFondo(JLabel imagenFondo) {
		this.imagenFondo = imagenFondo;
	}
	
}