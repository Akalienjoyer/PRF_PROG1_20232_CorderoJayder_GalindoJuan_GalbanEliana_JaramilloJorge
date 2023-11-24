package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaBuscarDetalleApuestas extends JFrame{
	private JButton sede, regresar, apostador;
	private JLabel imagenFondo, action;

	public VentanaBuscarDetalleApuestas(String accion) {
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
		
		sede = new JButton();
		sede.setOpaque(true);
		sede.setBounds(175, 423, 352, 55);
		sede.setToolTipText("Buscar");
		add(sede);
		
		apostador = new JButton();
		apostador.setOpaque(true);
		apostador.setBounds(175, 223, 352, 55);
		apostador.setToolTipText("Buscar");
		add(apostador);
	}

	public JButton getSede() {
		return sede;
	}

	public void setSede(JButton sede) {
		this.sede = sede;
	}

	public JButton getApostador() {
		return apostador;
	}

	public void setApostador(JButton apostador) {
		this.apostador = apostador;
	}

	public JButton getsede() {
		return sede;
	}

	public void setsede(JButton sede) {
		this.sede = sede;
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
