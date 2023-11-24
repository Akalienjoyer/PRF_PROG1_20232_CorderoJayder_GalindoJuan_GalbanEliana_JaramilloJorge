package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import co.edu.unbosque.model.SedeDTO;

public class VentanaDigitFacturaSuperastro extends JFrame{
	
	private JTextField sede,cedula,diaSemana,valor,num1,num2,num3,num4,signo;
	private JButton salir, ingresar;
	private JLabel imagenFondo;
    
    public VentanaDigitFacturaSuperastro() {
	
    	setSize(742, 677);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
        setUndecorated(true);
        
        salir = new JButton("INICIO");
        salir.setFont(new Font("Nue Gothic", 1, 20));
        salir.setForeground(Color.WHITE);
        salir.setBackground(new Color(200, 200, 200));
        salir.setOpaque(false);
        salir.setContentAreaFilled(false);
        salir.setBorderPainted(false);
        salir.setBounds(-6, 600, 120, 30);
        salir.setToolTipText("Regresa al Menu Anterior");
		add(salir);
		
		sede = new JTextField();
		sede.setBounds(20,20,100,100);
		add(sede);
		
		cedula = new JTextField();
		cedula.setBounds(20,100,100,100);
		add(cedula);
		
		diaSemana = new JTextField();
		diaSemana.setBounds(20,180,100,100);
		add(diaSemana);
		
		valor = new JTextField();
		valor.setBounds(20,260,100,100);
		add(valor);
		
		num1 = new JTextField();
		num1.setBounds(20,340,100,100);
		add(num1);
		
		num2 = new JTextField();
		num2.setBounds(20,420,100,100);
		add(num2);
		
		num3 = new JTextField();
		num3.setBounds(120,20,100,100);
		add(num3);
		
		num4 = new JTextField();
		num4.setBounds(120,100,100,100);
		add(num4);
		
		signo = new JTextField();
		signo.setBounds(120,180,100,100);
		add(signo);
		
		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, getWidth(), getHeight());
		Image temp;
		temp = new ImageIcon("src/Imagenes/TablaSedes.png").getImage();
		ImageIcon img;
		img = new ImageIcon(
				temp.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
		imagenFondo.setIcon(img);
		add(imagenFondo);
		
		ingresar = new JButton();
		ingresar.setOpaque(true);
		ingresar.setBounds(0, 0, 352, 45);
		ingresar.setToolTipText("Siguiente para Registrar Usuario y Contrasenia");
		add(ingresar);
    }

	public JTextField getsede() {
		return sede;
	}

	public void setsede(JTextField sede) {
		this.sede = sede;
	}

	public JTextField getCedula() {
		return cedula;
	}

	public void setCedula(JTextField cedula) {
		this.cedula = cedula;
	}

	public JTextField getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(JTextField diaSemana) {
		this.diaSemana = diaSemana;
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

	public JTextField getSigno() {
		return signo;
	}

	public void setSigno(JTextField signo) {
		this.signo = signo;
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

	public JLabel getImagenFondo() {
		return imagenFondo;
	}

	public void setImagenFondo(JLabel imagenFondo) {
		this.imagenFondo = imagenFondo;
	}
}