package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaEdicionApostador extends JFrame{

	private JButton ingresar, regresar;
	private JTextField nombreCompleto, cedula, direccion, celular;
	private JLabel imagenFondo, tipo;
	private JComboBox<String> sedeJuego;
    private String[] localidadesBogota = {"Chapinero", "Usaquén", "Kennedy", "Suba", "Fontibón", "Engativá", "Teusaquillo", "Santa Fe"};


	public VentanaEdicionApostador (String accion) {
		
		setSize(700, 700);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setUndecorated(true);

		regresar = new JButton("REGRESAR");
		regresar.setFont(new Font("Nue Gothic", 1, 22));
		regresar.setForeground(Color.WHITE);
		regresar.setBackground(new Color(200, 200, 200));
		regresar.setOpaque(false);
		regresar.setContentAreaFilled(false);
		regresar.setBorderPainted(false);
		regresar.setBounds(-4, 660, 120, 30);
		regresar.setToolTipText("Regresa al Menu Anterior");
		add(regresar);

		tipo = new JLabel();
		tipo.setText(accion);
//		add(tipo);
		
		nombreCompleto = new JTextField();
		nombreCompleto.setBorder(null); 
        nombreCompleto.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
        nombreCompleto.setBackground(new java.awt.Color(0, 0, 0, 1));
		nombreCompleto.setBounds(196, 160, 328, 50); 
		nombreCompleto.setToolTipText("Ingresa el Nombre Completo"); 
		add(nombreCompleto);

		cedula = new JTextField();
		cedula.setBorder(null); 
		cedula.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		cedula.setBackground(new java.awt.Color(0, 0, 0, 1));
		cedula.setBounds(196, 244, 328, 50);
		cedula.setToolTipText("Ingresa la Cedula"); 
		add(cedula);
		
		sedeJuego = new JComboBox<>(localidadesBogota); 
        sedeJuego.setFont(new Font("Nue Gothic", Font.PLAIN, 18));
        sedeJuego.setBounds(174, 332, 350, 50);
        sedeJuego.setToolTipText("Selecciona la Sede del Juego");
        add(sedeJuego);
		
		direccion = new JTextField();
		direccion.setBorder(null); 
		direccion.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		direccion.setBackground(new java.awt.Color(0, 0, 0, 1));
		direccion.setBounds(196, 416, 328, 50);
		direccion.setToolTipText("Ingresa la Direccion"); 
		add(direccion);
		
		celular = new JTextField();
		celular.setBorder(null); 
		celular.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		celular.setBackground(new java.awt.Color(0, 0, 0, 1));
		celular.setBounds(196, 500, 328, 50);
		celular.setToolTipText("Ingresa el Numero de Celular"); 
		add(celular);
		
		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, getWidth(), getHeight());
		Image temp;
		temp = new ImageIcon("src/Imagenes/ActualizarApostador.png").getImage();
		ImageIcon img;
		img = new ImageIcon(
				temp.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
		imagenFondo.setIcon(img);
		add(imagenFondo);
		
		ingresar = new JButton();
		ingresar.setOpaque(false);
		ingresar.setBounds(175, 573, 352, 45);
		ingresar.setToolTipText("Ingresar datos");
		add(ingresar);
		
	}


	public JButton getIngresar() {
		return ingresar;
	}


	public void setIngresar(JButton ingresar) {
		this.ingresar = ingresar;
	}


	public JButton getRegresar() {
		return regresar;
	}


	public void setRegresar(JButton regresar) {
		this.regresar = regresar;
	}


	public JTextField getNombreCompleto() {
		return nombreCompleto;
	}


	public void setNombreCompleto(JTextField nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}


	public JTextField getCedula() {
		return cedula;
	}


	public void setCedula(JTextField cedula) {
		this.cedula = cedula;
	}


	public JTextField getDireccion() {
		return direccion;
	}


	public void setDireccion(JTextField direccion) {
		this.direccion = direccion;
	}


	public JTextField getCelular() {
		return celular;
	}


	public void setCelular(JTextField celular) {
		this.celular = celular;
	}


	public JLabel getImagenFondo() {
		return imagenFondo;
	}


	public void setImagenFondo(JLabel imagenFondo) {
		this.imagenFondo = imagenFondo;
	}


	public JLabel getTipo() {
		return tipo;
	}


	public void setTipo(JLabel tipo) {
		this.tipo = tipo;
	}


	public JComboBox<String> getSedeJuego() {
		return sedeJuego;
	}


	public void setSedeJuego(JComboBox<String> sedeJuego) {
		this.sedeJuego = sedeJuego;
	}


	public String[] getLocalidadesBogota() {
		return localidadesBogota;
	}


	public void setLocalidadesBogota(String[] localidadesBogota) {
		this.localidadesBogota = localidadesBogota;
	}

	
	
}
