package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import co.edu.unbosque.model.SedeDTO;

public class VentanaShowCasa extends JFrame{

	private JButton regresar;
	private JLabel imagenFondo, nombre, presupuesto, cantSedes;
	
	public VentanaShowCasa() {
	
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
		
		nombre = new JLabel();
		nombre.setText("Null");
		nombre.setBounds(200, 238, 500, 50);
		nombre.setForeground(Color.BLACK);
		nombre.setFont(new Font("Nue Gothic", 1, 35));
		add(nombre);

		presupuesto = new JLabel();
		presupuesto.setText("Null");
		presupuesto.setBounds(228, 315, 500, 50);
		presupuesto.setForeground(Color.BLACK);
		presupuesto.setFont(new Font("Nue Gothic", 1, 35));
		add(presupuesto);
		
		cantSedes = new JLabel();
		cantSedes.setText("Null");
		cantSedes.setBounds(270,400,500,50);
		cantSedes.setForeground(Color.BLACK);
		cantSedes.setFont(new Font("Nue Gothic", 1, 35));
		add(cantSedes);
		
		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, getWidth(), getHeight());
		Image temp;
		temp = new ImageIcon("src/Imagenes/ShowCasa.png").getImage();
		ImageIcon img;
		img = new ImageIcon(
				temp.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
		imagenFondo.setIcon(img);
		add(imagenFondo);
		
	}
	public void uploadData(String name,String budget, String sedes) {
		nombre.setText(name);
		presupuesto.setText(budget);
		cantSedes.setText(sedes);
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

	public JLabel getnombre() {
		return nombre;
	}

	public void setnombre(JLabel nombre) {
		this.nombre = nombre;
	}

	public JLabel getpresupuesto() {
		return presupuesto;
	}

	public void setpresupuesto(JLabel presupuesto) {
		this.presupuesto = presupuesto;
	}
	
}
