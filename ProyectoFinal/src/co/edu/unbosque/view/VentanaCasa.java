package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaCasa extends JFrame{

	private JButton editar, mostrar, regresar;
	private JLabel imagenFondo;
	
	public VentanaCasa() {
		setSize(1150, 700);
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
		temp = new ImageIcon("src/Imagenes/GestionCasa.png").getImage();
		ImageIcon img;
		img = new ImageIcon(
				temp.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
		imagenFondo.setIcon(img);
		add(imagenFondo);
		
		editar = new JButton();
		editar.setOpaque(false); 
		editar.setBounds(600, 261, 470, 160);
		editar.setToolTipText("Editar datos");
		add(editar);
		
		mostrar = new JButton();
		mostrar.setOpaque(false); 
		mostrar.setBounds(65, 261, 470, 160);
		mostrar.setToolTipText("Mostrar datos");
		add(mostrar);
	}

	public JButton getEditar() {
		return editar;
	}

	public void setEditar(JButton editar) {
		this.editar = editar;
	}

	public JButton getMostrar() {
		return mostrar;
	}

	public void setMostrar(JButton mostrar) {
		this.mostrar = mostrar;
	}

	public JButton getRegresar() {
		return regresar;
	}

	public void setRegresar(JButton regresar) {
		this.regresar = regresar;
	}
}
