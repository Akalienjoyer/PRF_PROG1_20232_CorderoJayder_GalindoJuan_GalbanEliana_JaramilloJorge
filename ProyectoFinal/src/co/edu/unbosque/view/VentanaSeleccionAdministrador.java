package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaSeleccionAdministrador extends JFrame{

	private JButton gestionesAdmin, facturarApuesta, generarRecibo, consultas, regresar;
	private JLabel imagenFondo;
	
	public VentanaSeleccionAdministrador() {
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
		temp = new ImageIcon("src/Imagenes/SeleccionAdministrador.png").getImage();
		ImageIcon img;
		img = new ImageIcon(
				temp.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
		imagenFondo.setIcon(img);
		add(imagenFondo);
		
		facturarApuesta = new JButton();
		facturarApuesta.setOpaque(false); 
		facturarApuesta.setBounds(700, 217, 262, 69);
		facturarApuesta.setToolTipText("Facturar Apuesta");
		add(facturarApuesta);
		
		gestionesAdmin = new JButton();
		gestionesAdmin.setOpaque(false); 
		gestionesAdmin.setBounds(700, 306, 262, 69);
		gestionesAdmin.setToolTipText("Mas Gestiones de Administrador");
		add(gestionesAdmin);
		
		generarRecibo = new JButton();
		generarRecibo.setOpaque(false); 
		generarRecibo.setBounds(700, 390, 262, 69);
		generarRecibo.setToolTipText("Generar Recibo General");
		add(generarRecibo);
		
		consultas = new JButton();
		consultas.setOpaque(false); 
		consultas.setBounds(700, 478, 262, 69);
		consultas.setToolTipText("Mostrar Consultas Independientes");
		add(consultas);
		
	}

	public JButton getGestionesAdmin() {
		return gestionesAdmin;
	}

	public void setGestionesAdmin(JButton gestionesAdmin) {
		this.gestionesAdmin = gestionesAdmin;
	}

	public JButton getFacturarApuesta() {
		return facturarApuesta;
	}

	public void setFacturarApuesta(JButton facturarApuesta) {
		this.facturarApuesta = facturarApuesta;
	}

	public JButton getGenerarRecibo() {
		return generarRecibo;
	}

	public void setGenerarRecibo(JButton generarRecibo) {
		this.generarRecibo = generarRecibo;
	}

	public JButton getConsultas() {
		return consultas;
	}

	public void setConsultas(JButton consultas) {
		this.consultas = consultas;
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
