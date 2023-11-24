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

public class VentanaFacturarBaloto extends JFrame {

	private JTextField cedula, valor, num1, num2, num3, num4, num5, num6;
	private JButton salir, ingresar;
	private JComboBox<String> sede;
	private JComboBox<String> diaSemana;
	private String[] localidadesBogota = { "Chapinero", "Usaquén", "Kennedy", "Suba", "Fontibón", "Engativá",
			"Teusaquillo", "Santa Fe" };
	private String[] diasSemana = { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };
	private JLabel imagenFondo;

	public VentanaFacturarBaloto() {

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
		num1.setBounds(708, 227, 75, 45);
		num1.setBorder(null); 
		num1.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		num1.setBackground(new java.awt.Color(0, 0, 0, 1));
		num1.setToolTipText("Ingresa el Numero #1 a Jugar");
		add(num1);

		num2 = new JTextField();
		num2.setBounds(708, 278, 75, 45);
		num2.setBorder(null); 
		num2.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		num2.setBackground(new java.awt.Color(0, 0, 0, 1));
		num2.setToolTipText("Ingresa el Numero #2 a Jugar");
		add(num2);

		num3 = new JTextField();
		num3.setBounds(708, 329, 75, 45);
		num3.setBorder(null); 
		num3.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		num3.setBackground(new java.awt.Color(0, 0, 0, 1));
		num3.setToolTipText("Ingresa el Numero #3 a Jugar");
		add(num3);

		num4 = new JTextField();
		num4.setBounds(708, 380, 75, 45);
		num4.setBorder(null); 
		num4.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		num4.setBackground(new java.awt.Color(0, 0, 0, 1));
		num4.setToolTipText("Ingresa el Numero #4 a Jugar");
		add(num4);
		
		num5 = new JTextField();
		num5.setBounds(708, 431, 75, 45);
		num5.setBorder(null); 
		num5.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		num5.setBackground(new java.awt.Color(0, 0, 0, 1));
		num5.setToolTipText("Ingresa el Numero #5 a Jugar");
		add(num5);
		
		num6 = new JTextField();
		num6.setBounds(708, 482, 75, 45);
		num6.setBorder(null); 
		num6.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		num6.setBackground(new java.awt.Color(0, 0, 0, 1));
		num6.setToolTipText("Ingresa el Numero #6 a Jugar");
		add(num6);

		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, getWidth(), getHeight());
		Image temp;
		temp = new ImageIcon("src/Imagenes/FacturarBaloto.png").getImage();
		ImageIcon img;
		img = new ImageIcon(
				temp.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
		imagenFondo.setIcon(img);
		add(imagenFondo);

		ingresar = new JButton();
		ingresar.setOpaque(false);
		ingresar.setBounds(594, 558, 362, 45);
		ingresar.setToolTipText("Ingresar datos");
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

	public JTextField getNum5() {
		return num5;
	}

	public void setNum5(JTextField num5) {
		this.num5 = num5;
	}

	public JTextField getNum6() {
		return num6;
	}

	public void setNum6(JTextField num6) {
		this.num6 = num6;
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

	public JLabel getImagenFondo() {
		return imagenFondo;
	}

	public void setImagenFondo(JLabel imagenFondo) {
		this.imagenFondo = imagenFondo;
	}
	
}