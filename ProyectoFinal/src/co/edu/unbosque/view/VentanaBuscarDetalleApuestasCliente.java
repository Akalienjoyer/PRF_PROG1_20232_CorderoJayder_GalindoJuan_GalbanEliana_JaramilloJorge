package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaBuscarDetalleApuestasCliente extends JFrame{
	private JButton ingresar, regresar;
	private JTextField cedula;
	private JLabel imagenFondo, action;

	public VentanaBuscarDetalleApuestasCliente(String accion) {
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

		cedula = new JTextField();
		cedula.setBorder(null); 
        cedula.setFont(new Font("Nue Gothic", Font.PLAIN, 28)); 
		cedula.setBackground(new java.awt.Color(0, 0, 0, 1));
		cedula.setBounds(195, 339, 350, 60); 
		cedula.setToolTipText("Ingresa la cedula"); 
		add(cedula);
		
		action = new JLabel();
		action.setText(accion);
//		add(action);
		
		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, getWidth(), getHeight());
		Image temp;
		temp = new ImageIcon("src/Imagenes/BuscarApostador.png").getImage();
		ImageIcon img;
		img = new ImageIcon(
				temp.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
		imagenFondo.setIcon(img);
		add(imagenFondo);
		
		ingresar = new JButton();
		ingresar.setOpaque(false);
		ingresar.setBounds(175, 423, 352, 55);
		ingresar.setToolTipText("Buscar Apostador");
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

	public JTextField getcedula() {
		return cedula;
	}

	public void setcedula(JTextField cedula) {
		this.cedula = cedula;
	}

	public JLabel getImagenFondo() {
		return imagenFondo;
	}

	public void setImagenFondo(JLabel imagenFondo) {
		this.imagenFondo = imagenFondo;
	}
	
}
