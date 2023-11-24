package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaBuscarDetallerApuestasJuego extends JFrame{
	private JButton ingresar, regresar;
	private JLabel imagenFondo, action;
	private JComboBox<String> juego;
    private String[] juegos = {"Baloto", "BetPlay", "Loteria", "SuperAstro", "Chance"};


	public VentanaBuscarDetallerApuestasJuego(String accion) {
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

		juego = new JComboBox<>(juegos); 
        juego.setFont(new Font("Nue Gothic", Font.PLAIN, 18));
        juego.setBounds(181, 330, 336, 70);
        juego.setToolTipText("Ingresa el juego"); 
        add(juego);

        action = new JLabel();
		action.setText(accion);
//		add(action);
		
		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, getWidth(), getHeight());
		Image temp;
		temp = new ImageIcon("src/Imagenes/BuscarSede.png").getImage();
		ImageIcon img;
		img = new ImageIcon(
				temp.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
		imagenFondo.setIcon(img);
		add(imagenFondo);
		
		ingresar = new JButton();
		ingresar.setOpaque(false);
		ingresar.setBounds(175, 455, 352, 50);
		ingresar.setToolTipText("Buscar juego");
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


	public JLabel getImagenFondo() {
		return imagenFondo;
	}


	public void setImagenFondo(JLabel imagenFondo) {
		this.imagenFondo = imagenFondo;
	}


	public JLabel getAction() {
		return action;
	}


	public void setAction(JLabel action) {
		this.action = action;
	}


	public JComboBox<String> getjuego() {
		return juego;
	}


	public void setjuego(JComboBox<String> juego) {
		this.juego = juego;
	}


	public String[] getjuegos() {
		return juegos;
	}


	public void setjuegos(String[] juegos) {
		this.juegos = juegos;
	}
	
}
