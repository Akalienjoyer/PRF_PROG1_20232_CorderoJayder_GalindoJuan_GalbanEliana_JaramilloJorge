package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaGestionesAdmin extends JFrame{
	
	private JButton gesSedes, gesApostadores, gesCasa, gesJuegos, regresar;
	private JLabel imagenFondo;

	public VentanaGestionesAdmin() {
		// TODO Auto-generated constructor stub
		setSize(700, 700);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setUndecorated(true);

		regresar = new JButton("REGRESAR");
		regresar.setFont(new Font("Nue Gothic", 1, 16));
		regresar.setForeground(Color.WHITE);
		regresar.setBackground(new Color(200, 200, 200));
		regresar.setOpaque(false);
		regresar.setContentAreaFilled(false);
		regresar.setBorderPainted(false);
		regresar.setBounds(-4, 660, 120, 30);
		regresar.setToolTipText("Regresa al Menu Anterior");
		add(regresar);

		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, getWidth(), getHeight());
		Image temp;
		temp = new ImageIcon("src/Imagenes/SelectorGestiones.png").getImage();
		ImageIcon img;
		img = new ImageIcon(
				temp.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
		imagenFondo.setIcon(img);
		add(imagenFondo);
		
		gesSedes = new JButton();
		gesSedes.setOpaque(false);
		gesSedes.setBounds(177, 279, 345, 52);
		gesSedes.setToolTipText("Ingresar para Gestionar las Sedes de la Compañia");
		add(gesSedes);
		
		gesApostadores = new JButton();
		gesApostadores.setOpaque(false);
		gesApostadores.setBounds(177, 356, 345, 52);
		gesApostadores.setToolTipText("Ingresar para Gestionar los Apostadores");
		add(gesApostadores);
		
		gesCasa = new JButton();
		gesCasa.setOpaque(false);
		gesCasa.setBounds(177, 434, 345, 52);
		gesCasa.setToolTipText("Ingresar para Gestionar la Casa de Apuestas");
		add(gesCasa);
		
		gesJuegos = new JButton();
		gesJuegos.setOpaque(false);
		gesJuegos.setBounds(177, 504, 345, 52);
		gesJuegos.setToolTipText("Ingresar para Gestionar los juegos");
		add(gesJuegos);
	}

	public JButton getGesSedes() {
		return gesSedes;
	}

	public void setGesSedes(JButton gesSedes) {
		this.gesSedes = gesSedes;
	}

	public JButton getGesApostadores() {
		return gesApostadores;
	}

	public void setGesApostadores(JButton gesApostadores) {
		this.gesApostadores = gesApostadores;
	}

	public JButton getGesCasa() {
		return gesCasa;
	}

	public void setGesCasa(JButton gesCasa) {
		this.gesCasa = gesCasa;
	}

	public JButton getGesJuegos() {
		return gesJuegos;
	}

	public void setGesJuegos(JButton gesJuegos) {
		this.gesJuegos = gesJuegos;
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

}
