package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaActualizarSede extends JFrame {

	private JButton ingresar, regresar;
	private JTextField empleados;
	private JLabel imagenFondo;
	private String icon;

	public VentanaActualizarSede(String acccion) {
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
		
		empleados = new JTextField();
		empleados.setBorder(null); 
		empleados.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		empleados.setBackground(new java.awt.Color(0, 0, 0, 1));
		empleados.setBounds(196, 332, 328, 60);
		empleados.setToolTipText("Ingresa la cantidad de empleados"); 
		add(empleados);
		
		ingresar = new JButton();
		ingresar.setOpaque(false);
		ingresar.setBounds(175, 431, 352, 48);
		ingresar.setToolTipText("Ingresar datos");
		add(ingresar);
		
		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, getWidth(), getHeight());
		Image temp;
		temp = new ImageIcon("src/Imagenes/EditarSedeAtributos.png").getImage();
		ImageIcon img;
		img = new ImageIcon(
				temp.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
		imagenFondo.setIcon(img);
		add(imagenFondo);
		
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


	public JTextField getEmpleados() {
		return empleados;
	}


	public void setEmpleados(JTextField empleados) {
		this.empleados = empleados;
	}


	public JLabel getImagenFondo() {
		return imagenFondo;
	}


	public void setImagenFondo(JLabel imagenFondo) {
		this.imagenFondo = imagenFondo;
	}


	public String getIcon() {
		return icon;
	}


	public void setIcon(String icon) {
		this.icon = icon;
	}

}
