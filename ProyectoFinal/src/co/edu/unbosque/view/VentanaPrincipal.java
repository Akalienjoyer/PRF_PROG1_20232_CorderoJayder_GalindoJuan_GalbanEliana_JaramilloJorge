package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class VentanaPrincipal extends JFrame{

	private JButton jugador, gerente, salir;
	private JLabel imagenFondo;

	public VentanaPrincipal() {
		// TODO Auto-generated constructor stub
		
		setSize(1150, 700);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
		
		setDefaultLookAndFeelDecorated(true);
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}

		} catch (Exception e) {
		}
		
		salir = new JButton("SALIR");
		salir.setFont(new Font("Nue Gothic", 1, 22));
		salir.setForeground(Color.WHITE);
		salir.setBackground(new Color(200, 200, 200));
		salir.setOpaque(false);
		salir.setContentAreaFilled(false);
		salir.setBorderPainted(false);
		salir.setBounds(-7, 20, 120, 30);
		salir.setToolTipText("Ciera el Aplicativo Completamente");
		add(salir);
		
		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, getWidth(), getHeight());
		Image temp;
		temp = new ImageIcon("src/Imagenes/InicioSeleccion.png").getImage();
		ImageIcon img;
		img = new ImageIcon(
				temp.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
		imagenFondo.setIcon(img);
		add(imagenFondo);
		
		jugador = new JButton();
		jugador.setFont(new Font("Nue Gothic", 1, 40));
        jugador.setOpaque(false); 
		jugador.setBounds(469, 437, 212, 58);
		jugador.setToolTipText("Ingresa como Jugador");
		add(jugador);
		
		gerente = new JButton();
		gerente.setFont(new Font("Nue Gothic", 1, 40));
		gerente.setOpaque(false); 
		gerente.setBounds(467, 553, 213, 58);
		jugador.setToolTipText("Ingresa como Gerente");
		add(gerente);
		
		
	}

	public JButton getJugador() {
		return jugador;
	}

	public void setJugador(JButton jugador) {
		this.jugador = jugador;
	}

	public JButton getGerente() {
		return gerente;
	}

	public void setGerente(JButton gerente) {
		this.gerente = gerente;
	}

	public JButton getSalir() {
		return salir;
	}

	public void setSalir(JButton salir) {
		this.salir = salir;
	}

	public JLabel getImagenFondo() {
		return imagenFondo;
	}

	public void setImagenFondo(JLabel imagenFondo) {
		this.imagenFondo = imagenFondo;
	}
	
	
}