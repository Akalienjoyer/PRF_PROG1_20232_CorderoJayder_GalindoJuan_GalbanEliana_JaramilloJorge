package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaSedes extends JFrame{
	
	private JButton crear, buscar, mostrar, actualizar, borrar, regresar;
	private JLabel imagenFondo;

	public VentanaSedes() {
		// TODO Auto-generated constructor stub
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
		temp = new ImageIcon("src/Imagenes/Sedes.png").getImage();
		ImageIcon img;
		img = new ImageIcon(
				temp.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
		imagenFondo.setIcon(img);
		add(imagenFondo);

		crear = new JButton();
		crear.setOpaque(false);
		crear.setBounds(60, 232, 315, 83);
		crear.setToolTipText("Ingresar a creacion de sedes");
		add(crear);
		
		buscar = new JButton();
		buscar.setOpaque(false);
		buscar.setBounds(420, 232, 315, 83);
		buscar.setToolTipText("Ingresar a buscar de sedes");
		add(buscar);
		
		mostrar = new JButton();
		mostrar.setOpaque(false);
		mostrar.setBounds(775, 232, 315, 83);
		mostrar.setToolTipText("Ingresar a mostrar de sedes");
		add(mostrar);
		
		actualizar = new JButton();
		actualizar.setOpaque(false);
		actualizar.setBounds(243, 392, 315, 83);
		actualizar.setToolTipText("Ingresar a actualizar de sedes");
		add(actualizar);
		
		borrar = new JButton();
		borrar.setOpaque(false);
		borrar.setBounds(599, 392, 315, 83);
		borrar.setToolTipText("Ingresar a borrar de sedes");
		add(borrar);
		
	}

	public JButton getCrear() {
		return crear;
	}



	public void setCrear(JButton crear) {
		this.crear = crear;
	}



	public JButton getBuscar() {
		return buscar;
	}



	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}



	public JButton getMostrar() {
		return mostrar;
	}



	public void setMostrar(JButton mostrar) {
		this.mostrar = mostrar;
	}



	public JButton getActualizar() {
		return actualizar;
	}



	public void setActualizar(JButton actualizar) {
		this.actualizar = actualizar;
	}



	public JButton getBorrar() {
		return borrar;
	}



	public void setBorrar(JButton borrar) {
		this.borrar = borrar;
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
