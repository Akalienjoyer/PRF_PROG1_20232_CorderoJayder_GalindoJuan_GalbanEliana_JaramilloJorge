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

public class VentanaShowApostador extends JFrame{

	private JButton regresar;
	private JLabel nombre, cedula, sede, direccion, celular, imagenFondo;
	
	public VentanaShowApostador() {
		
		setSize(700, 700);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setUndecorated(true);
		
		nombre = new JLabel();
		nombre.setText("Null");
		nombre.setBounds(200, 138, 500, 50);
		nombre.setForeground(Color.GRAY);
		nombre.setFont(new Font("Nue Gothic", 1, 35));
		add(nombre);

		cedula = new JLabel();
		cedula.setText("Null");
		cedula.setBounds(200, 214, 500, 50);
		cedula.setForeground(Color.GRAY);
		cedula.setFont(new Font("Nue Gothic", 1, 35));
		add(cedula);
		
		sede = new JLabel();
		sede.setText("Null");
		sede.setBounds(250, 290, 500, 50);
		sede.setForeground(Color.GRAY);
		sede.setFont(new Font("Nue Gothic", 1, 35));
		add(sede);
		
		direccion = new JLabel();
		direccion.setText("Null");
		direccion.setBounds(208, 366, 500, 50);
		direccion.setForeground(Color.GRAY);
		direccion.setFont(new Font("Nue Gothic", 1, 35));
		add(direccion);
		
		celular = new JLabel();
		celular.setText("Null");
		celular.setBounds(200, 460, 500, 50);
		celular.setForeground(Color.GRAY);
		celular.setFont(new Font("Nue Gothic", 1, 35));
		add(celular);
		
		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, getWidth(), getHeight());
		Image temp;
		temp = new ImageIcon("src/Imagenes/ShowApostador.png").getImage();
		ImageIcon img;
		img = new ImageIcon(
				temp.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
		imagenFondo.setIcon(img);
		add(imagenFondo);
		
		regresar = new JButton();
		regresar.setOpaque(false);
		regresar.setBounds(175, 573, 352, 45);
		regresar.setToolTipText("Volver al menu anterior");
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
