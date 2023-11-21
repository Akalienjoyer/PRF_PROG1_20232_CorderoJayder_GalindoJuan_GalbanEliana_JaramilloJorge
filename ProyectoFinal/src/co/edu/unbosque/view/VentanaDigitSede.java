package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaDigitSede extends JFrame {

	private JButton ingresar, regresar;
	private JTextField ubicacion, empleados;
	private JLabel imagenFondo;
	private String icon;

	public VentanaDigitSede(String acccion) {
		// TODO Auto-generated constructor stub
		setSize(700, 700);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setUndecorated(true);

		regresar = new JButton("REGRESAR");
		regresar.setFont(new Font("Nue Gothic", 1, 12));
		regresar.setForeground(Color.WHITE);
		regresar.setBackground(new Color(200, 200, 200));
		regresar.setOpaque(false);
		regresar.setContentAreaFilled(false);
		regresar.setBorderPainted(false);
		regresar.setBounds(-4, 660, 120, 30);
		regresar.setToolTipText("Regresa al Menu Anterior");
		add(regresar);

		ubicacion = new JTextField();
		ubicacion.setBorder(null); 
        ubicacion.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		ubicacion.setBackground(new java.awt.Color(0, 0, 0, 1));
		ubicacion.setBounds(196, 280, 328, 60); 
		ubicacion.setToolTipText("Ingresa la ubicacion"); 
		

		empleados = new JTextField();
		empleados.setBorder(null); 
		empleados.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		empleados.setBackground(new java.awt.Color(0, 0, 0, 1));
		empleados.setBounds(196, 382, 328, 60);
		empleados.setToolTipText("Ingresa la cantidad de empleados"); 
		

		if(acccion.equals("Crear")) {
			icon = "DigitSede";
			add(ubicacion);
			add(empleados);
		}else if(acccion.equals("Actualizar")) {
			icon = "DigitSedeA";
			empleados.setBounds(196, 322, 328, 60);
			empleados.setFont(new Font("Nue Gothic", Font.PLAIN, 24)); 
			add(empleados);
		}
		
		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, getWidth(), getHeight());
		Image temp;
		temp = new ImageIcon("src/Imagenes/"+icon+".png").getImage();
		ImageIcon img;
		img = new ImageIcon(
				temp.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
		imagenFondo.setIcon(img);
		add(imagenFondo);
		
		ingresar = new JButton();
		ingresar.setOpaque(false);
		ingresar.setBounds(175, 474, 352, 55);
		ingresar.setToolTipText("Ingresar datos");
		add(ingresar);
		
	}

	public JButton getIngresar() {
		return ingresar;
	}

	public void setIngresar(JButton ingresar) {
		this.ingresar = ingresar;
	}

	public JButton getRegresar() {
		return regresar;
	}

	public void setRegresar(JButton regresar) {
		this.regresar = regresar;
	}

	public JTextField getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(JTextField ubicacion) {
		this.ubicacion = ubicacion;
	}

	public JTextField getempleados() {
		return empleados;
	}

	public void setempleados(JTextField empleados) {
		this.empleados = empleados;
	}

	public JLabel getImagenFondo() {
		return imagenFondo;
	}

	public void setImagenFondo(JLabel imagenFondo) {
		this.imagenFondo = imagenFondo;
	}

		
}
