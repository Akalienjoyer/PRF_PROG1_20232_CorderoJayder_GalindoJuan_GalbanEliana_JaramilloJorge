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

public class VentanaDigitCasa extends JFrame{

	private JButton ingresar, regresar;
	private JTextField nombre, presupuesto, cantSedes;
	private JLabel imagenFondo;

	public VentanaDigitCasa() {
		// TODO Auto-generated constructor stub
		setSize(700, 700);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setUndecorated(true);

		regresar = new JButton("REGRESAR");
		regresar.setFont(new Font("Nue Gothic", 1, 22));
		regresar.setForeground(Color.WHITE);
		regresar.setBackground(new Color(200, 200, 200));
		regresar.setOpaque(false);
		regresar.setContentAreaFilled(false);
		regresar.setBorderPainted(false);
		regresar.setBounds(-4, 660, 120, 30);
		regresar.setToolTipText("Regresa al Menu Anterior");
		add(regresar);

		nombre = new JTextField();
		nombre.setBorder(null); 
        nombre.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		nombre.setBackground(new java.awt.Color(0, 0, 0, 1));
		nombre.setBounds(196, 242, 328, 60); 
		nombre.setToolTipText("Ingresa el nombre"); 
		add(nombre);

		presupuesto = new JTextField();
		presupuesto.setBorder(null); 
		presupuesto.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		presupuesto.setBackground(new java.awt.Color(0, 0, 0, 1));
		presupuesto.setBounds(196, 329, 328, 60);
		presupuesto.setToolTipText("Ingresa el presupuesto"); 
		add(presupuesto);
		
		cantSedes = new JTextField();
		cantSedes.setBorder(null); 
		cantSedes.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		cantSedes.setBackground(new java.awt.Color(0, 0, 0, 1));
		cantSedes.setBounds(196, 412, 328, 60);
		cantSedes.setToolTipText("Ingresa el numero de sedes"); 
		add(cantSedes);

		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, getWidth(), getHeight());
		Image temp;
		temp = new ImageIcon("src/Imagenes/DigitCasa.png").getImage();
		ImageIcon img;
		img = new ImageIcon(
				temp.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
		imagenFondo.setIcon(img);
		add(imagenFondo);
		
		ingresar = new JButton();
		ingresar.setOpaque(false);
		ingresar.setBounds(175, 489, 352, 45);
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

	public JTextField getnombre() {
		return nombre;
	}

	public void setnombre(JTextField nombre) {
		this.nombre = nombre;
	}

	public JTextField getpresupuesto() {
		return presupuesto;
	}

	public void setpresupuesto(JTextField presupuesto) {
		this.presupuesto = presupuesto;
	}

	public JTextField getcantSedes() {
		return cantSedes;
	}

	public void setcantSedes(JTextField cantSedes) {
		this.cantSedes = cantSedes;
	}

	public JLabel getImagenFondo() {
		return imagenFondo;
	}

	public void setImagenFondo(JLabel imagenFondo) {
		this.imagenFondo = imagenFondo;
	}
	
}
