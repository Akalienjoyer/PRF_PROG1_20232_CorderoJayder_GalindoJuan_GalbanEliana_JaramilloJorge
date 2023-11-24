package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaConsultas extends JFrame{
	
	private JButton clientesSede, apuestasTotales, detalleApuestas, totalApuestas, regresar;
	private JLabel imagenFondo;

	public VentanaConsultas() {
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
		temp = new ImageIcon("src/Imagenes/Consultas.png").getImage();
		ImageIcon img;
		img = new ImageIcon(
				temp.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
		imagenFondo.setIcon(img);
		add(imagenFondo);
		
		clientesSede = new JButton();
		clientesSede.setOpaque(false);
		clientesSede.setBounds(177, 263, 345, 52);
		clientesSede.setToolTipText("Ingresar a ver Listado de Clientes por Sede");
		add(clientesSede);
		
		apuestasTotales = new JButton();
		apuestasTotales.setOpaque(false);
		apuestasTotales.setBounds(177, 340, 345, 52);
		apuestasTotales.setToolTipText("Ingresar a ver Valor de Apuestas por Cliente");
		add(apuestasTotales);
		
		detalleApuestas = new JButton();
		detalleApuestas.setOpaque(false);
		detalleApuestas.setBounds(177, 417, 345, 52);
		detalleApuestas.setToolTipText("Ingresar a ver Detalle de Apuestas realizada por Cliente y Sede");
		add(detalleApuestas);
		
		totalApuestas = new JButton();
		totalApuestas.setOpaque(false);
		totalApuestas.setBounds(177, 495, 345, 52);
		totalApuestas.setToolTipText("Ingresar a ver Total de Apuestas por Sede y Juego");
		add(totalApuestas);
		
		
	}

	public JButton getClientesSede() {
		return clientesSede;
	}

	public void setClientesSede(JButton clientesSede) {
		this.clientesSede = clientesSede;
	}

	public JButton getApuestasTotales() {
		return apuestasTotales;
	}

	public void setApuestasTotales(JButton apuestasTotales) {
		this.apuestasTotales = apuestasTotales;
	}

	public JButton getDetalleApuestas() {
		return detalleApuestas;
	}

	public void setDetalleApuestas(JButton detalleApuestas) {
		this.detalleApuestas = detalleApuestas;
	}

	public JButton getTotalApuestas() {
		return totalApuestas;
	}

	public void setTotalApuestas(JButton totalApuestas) {
		this.totalApuestas = totalApuestas;
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
