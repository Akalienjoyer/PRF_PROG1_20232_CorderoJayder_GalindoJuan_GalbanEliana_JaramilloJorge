package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import co.edu.unbosque.model.ApostadorDTO;
import co.edu.unbosque.model.SedeDTO;

public class VentanaMostrarApostador extends JFrame{

	private JButton regresar;
	private JLabel nombre, cedula, sede, direccion, celular, imagenFondo;
	
	public VentanaMostrarApostador() {
		
		setSize(700, 700);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setUndecorated(true);
		
		nombre = new JLabel();
		nombre.setText("Null");
		nombre.setBounds(340, 188, 500, 50);
		nombre.setForeground(Color.DARK_GRAY);
		nombre.setFont(new Font("Nue Gothic", 1, 35));
		add(nombre);

		cedula = new JLabel();
		cedula.setText("Null");
		cedula.setBounds(340, 256, 500, 50);
		cedula.setForeground(Color.DARK_GRAY);
		cedula.setFont(new Font("Nue Gothic", 1, 35));
		add(cedula);
		
		sede = new JLabel();
		sede.setText("Null");
		sede.setBounds(300, 322, 500, 50);
		sede.setForeground(Color.DARK_GRAY);
		sede.setFont(new Font("Nue Gothic", 1, 35));
		add(sede);
		
		direccion = new JLabel();
		direccion.setText("Null");
		direccion.setBounds(348, 385, 500, 50);
		direccion.setForeground(Color.DARK_GRAY);
		direccion.setFont(new Font("Nue Gothic", 1, 35));
		add(direccion);
		
		celular = new JLabel();
		celular.setText("Null");
		celular.setBounds(340, 452, 500, 50);
		celular.setForeground(Color.DARK_GRAY);
		celular.setFont(new Font("Nue Gothic", 1, 35));
		add(celular);
		
		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, getWidth(), getHeight());
		Image temp;
		temp = new ImageIcon("src/Imagenes/DatosApostador.png").getImage();
		ImageIcon img;
		img = new ImageIcon(
				temp.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
		imagenFondo.setIcon(img);
		
		add(imagenFondo);
		regresar = new JButton();
		regresar.setOpaque(false);
		regresar.setBounds(175, 527, 352, 45);
		regresar.setToolTipText("Volver al Menu Anterior");
		add(regresar);
		
	}
	
	public void uploadData(ApostadorDTO apostador) {
		nombre.setText(apostador.getNombre());
		cedula.setText(Long.toString(apostador.getCedula()));
		sede.setText(apostador.getSede());
		direccion.setText(apostador.getDireccion());
		celular.setText(Long.toString(apostador.getCelular()));
	}
	
	public JButton getRegresar() {
		return regresar;
	}

	public void setRegresar(JButton regresar) {
		this.regresar = regresar;
	}
	
}
