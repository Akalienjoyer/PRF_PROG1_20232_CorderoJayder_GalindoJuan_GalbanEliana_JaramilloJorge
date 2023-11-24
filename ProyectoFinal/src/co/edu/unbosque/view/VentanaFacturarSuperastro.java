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

public class VentanaFacturarSuperastro extends JFrame {

	private JTextField cedula, valor, num1, num2, num3, num4;
	private JButton salir, ingresar;
	private JComboBox<String> sede;
	private JComboBox<String> signo;
	private JComboBox<String> diaSemana;
	private String[] localidadesBogota = { "Chapinero", "Usaquén", "Kennedy", "Suba", "Fontibón", "Engativá",
			"Teusaquillo", "Santa Fe" };
	private String[] signosZodiacales = { "Aries", "Tauro", "Géminis", "Cáncer", "Leo", "Virgo", "Libra", "Escorpio",
			"Sagitario", "Capricornio", "Acuario", "Piscis" };
	private String[] diasSemana = { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };
	private JLabel imagenFondo;

	public VentanaFacturarSuperastro() {

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
		sede.setBounds(184, 228, 325, 50);
		sede.setToolTipText("Selecciona la Sede del Juego");
		add(sede);

		cedula = new JTextField();
		cedula.setBounds(195, 336, 300, 50);
		cedula.setBorder(null); 
		cedula.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		cedula.setBackground(new java.awt.Color(0, 0, 0, 1));
		cedula.setToolTipText("Ingresa la Cedula del Jugador");
		add(cedula);

		diaSemana = new JComboBox<>(diasSemana);
		diaSemana.setFont(new Font("Nue Gothic", Font.PLAIN, 18));
		diaSemana.setBounds(184, 450, 325, 50);
		diaSemana.setToolTipText("Selecciona el Día de la Semana");
		add(diaSemana);
		
		valor = new JTextField();
		valor.setBounds(195, 558, 300, 50);
		valor.setBorder(null); 
		valor.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		valor.setBackground(new java.awt.Color(0, 0, 0, 1));
		valor.setToolTipText("Ingresa el Valor a Apostar");
		add(valor);

		num1 = new JTextField();
		num1.setBounds(595, 274, 75, 50);
		num1.setBorder(null); 
		num1.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		num1.setBackground(new java.awt.Color(0, 0, 0, 1));
		num1.setToolTipText("Ingresa el Numero #1 a Jugar");
		add(num1);

		num2 = new JTextField();
		num2.setBounds(698, 274, 75, 50);
		num2.setBorder(null); 
		num2.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		num2.setBackground(new java.awt.Color(0, 0, 0, 1));
		num2.setToolTipText("Ingresa el Numero #2 a Jugar");
		add(num2);

		num3 = new JTextField();
		num3.setBounds(803, 274, 75, 50);
		num3.setBorder(null); 
		num3.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		num3.setBackground(new java.awt.Color(0, 0, 0, 1));
		num3.setToolTipText("Ingresa el Numero #3 a Jugar");
		add(num3);

		num4 = new JTextField();
		num4.setBounds(906, 274, 75, 50);
		num4.setBorder(null); 
		num4.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		num4.setBackground(new java.awt.Color(0, 0, 0, 1));
		num4.setToolTipText("Ingresa el Numero #4 a Jugar");
		add(num4);

		signo = new JComboBox<>(signosZodiacales);
		signo.setFont(new Font("Nue Gothic", Font.PLAIN, 18));
		signo.setToolTipText("Selecciona el Signo a Jugar");
		signo.setBounds(620, 418, 325, 50);
		add(signo);

		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, getWidth(), getHeight());
		Image temp;
		temp = new ImageIcon("src/Imagenes/FacturarSuperAstro.png").getImage();
		ImageIcon img;
		img = new ImageIcon(
				temp.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
		imagenFondo.setIcon(img);
		add(imagenFondo);

		ingresar = new JButton();
		ingresar.setOpaque(false);
		ingresar.setBounds(594, 558, 362, 45);
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

	public JTextField getNum1() {
		return num1;
	}

	public void setNum1(JTextField num1) {
		this.num1 = num1;
	}

	public JTextField getNum2() {
		return num2;
	}

	public void setNum2(JTextField num2) {
		this.num2 = num2;
	}

	public JTextField getNum3() {
		return num3;
	}

	public void setNum3(JTextField num3) {
		this.num3 = num3;
	}

	public JTextField getNum4() {
		return num4;
	}

	public void setNum4(JTextField num4) {
		this.num4 = num4;
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

	public JComboBox<String> getSigno() {
		return signo;
	}

	public void setSigno(JComboBox<String> signo) {
		this.signo = signo;
	}

	public JComboBox<String> getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(JComboBox<String> diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String[] getLocalidadesBogota() {
		return localidadesBogota;
	}

	public void setLocalidadesBogota(String[] localidadesBogota) {
		this.localidadesBogota = localidadesBogota;
	}

	public String[] getSignosZodiacales() {
		return signosZodiacales;
	}

	public void setSignosZodiacales(String[] signosZodiacales) {
		this.signosZodiacales = signosZodiacales;
	}

	public String[] getDiasSemana() {
		return diasSemana;
	}

	public void setDiasSemana(String[] diasSemana) {
		this.diasSemana = diasSemana;
	}

	public JLabel getImagenFondo() {
		return imagenFondo;
	}

	public void setImagenFondo(JLabel imagenFondo) {
		this.imagenFondo = imagenFondo;
	}
	
}