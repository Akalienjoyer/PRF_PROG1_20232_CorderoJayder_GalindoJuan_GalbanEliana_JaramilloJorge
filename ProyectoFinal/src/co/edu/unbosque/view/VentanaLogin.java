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

public class VentanaLogin extends JFrame {

	private JButton ingresar, regresar;
	private JTextField campoUsuario;
	private JPasswordField campoContrasenia;
	private JLabel imagenFondo;

	public VentanaLogin() {
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

		campoUsuario = new JTextField();
		campoUsuario.setBorder(null); 
        campoUsuario.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		campoUsuario.setBackground(new java.awt.Color(0, 0, 0, 1));
		campoUsuario.setBounds(196, 280, 328, 60); 
		campoUsuario.setToolTipText("Ingresa el Usuario"); 
		add(campoUsuario);

		campoContrasenia = new JPasswordField();
		campoContrasenia.setBorder(null); 
		campoContrasenia.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		campoContrasenia.setBackground(new java.awt.Color(0, 0, 0, 1));
		campoContrasenia.setBounds(196, 382, 328, 60);
		campoContrasenia.setToolTipText("Ingresa la Contraseña"); 
		add(campoContrasenia);

		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, getWidth(), getHeight());
		Image temp;
		temp = new ImageIcon("src/Imagenes/Login.png").getImage();
		ImageIcon img;
		img = new ImageIcon(
				temp.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
		imagenFondo.setIcon(img);
		add(imagenFondo);
		
		ingresar = new JButton();
		ingresar.setOpaque(false);
		ingresar.setBounds(175, 474, 352, 55);
		ingresar.setToolTipText("Ingresar al Sistema");
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

	public JTextField getCampoUsuario() {
		return campoUsuario;
	}

	public void setCampoUsuario(JTextFieldFondo campoUsuario) {
		this.campoUsuario = campoUsuario;
	}

	public JPasswordField getCampoContrasenia() {
		return campoContrasenia;
	}

	public void setCampoContrasenia(JPasswordField campoContrasenia) {
		this.campoContrasenia = campoContrasenia;
	}

	public JLabel getImagenFondo() {
		return imagenFondo;
	}

	public void setImagenFondo(JLabel imagenFondo) {
		this.imagenFondo = imagenFondo;
	}
	
}
