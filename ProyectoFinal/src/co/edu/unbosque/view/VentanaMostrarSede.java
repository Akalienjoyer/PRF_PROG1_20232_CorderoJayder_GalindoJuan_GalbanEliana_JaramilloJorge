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

public class VentanaMostrarSede extends JFrame{

	private JButton regresar;
	private JLabel imagenFondo, ubicacion, empleados;
	
	public VentanaMostrarSede() {
	
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
		
		ubicacion = new JLabel();
		ubicacion.setText("Null");
		ubicacion.setBounds(135, 307, 500, 50);
		ubicacion.setForeground(Color.WHITE);
		ubicacion.setFont(new Font("Nue Gothic", 1, 45));
		add(ubicacion);

		empleados = new JLabel();
		empleados.setText("Null");
		empleados.setBounds(140, 484, 500, 50);
		empleados.setForeground(Color.WHITE);
		empleados.setFont(new Font("Nue Gothic", 1, 45));
		add(empleados);
		
		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, getWidth(), getHeight());
		Image temp;
		temp = new ImageIcon("src/Imagenes/ShowSede.png").getImage();
		ImageIcon img;
		img = new ImageIcon(
				temp.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
		imagenFondo.setIcon(img);
		add(imagenFondo);
		
	}

	public void uploadData(SedeDTO sede) {
		ubicacion.setText(sede.getUbicacion());
		empleados.setText(Integer.toString(sede.getEmpleados()));
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

	public JLabel getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(JLabel ubicacion) {
		this.ubicacion = ubicacion;
	}

	public JLabel getEmpleados() {
		return empleados;
	}

	public void setEmpleados(JLabel empleados) {
		this.empleados = empleados;
	}
	
}
