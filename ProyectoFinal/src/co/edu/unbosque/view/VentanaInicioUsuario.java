package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaInicioUsuario extends JFrame{

	private JButton login, register, info, regresar;
	private JLabel imagenFondo;
	private JTextField txfNumDoc;
	
	public VentanaInicioUsuario() {
		// TODO Auto-generated constructor stub
		setSize(1150, 700);
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
		
		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, getWidth(), getHeight());
		Image temp;
		temp = new ImageIcon("src/Imagenes/InicioUsuario.png").getImage();
		ImageIcon img;
		img = new ImageIcon(
				temp.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
		imagenFondo.setIcon(img);
		add(imagenFondo);
		
		info = new JButton();
		info.setFont(new Font("Nue Gothic", 1, 40));
		info.setOpaque(false); 
		info.setBounds(100, 452, 274, 59);
		info.setToolTipText("Informacion Empresarial");
		add(info);
		
		login = new JButton();
		login.setFont(new Font("Nue Gothic", 1, 40));
        login.setOpaque(false); 
		login.setBounds(560, 42, 210, 56);
		login.setToolTipText("Ingresar Jugador");
		add(login);
		
		register = new JButton();
		register.setFont(new Font("Nue Gothic", 1, 40));
		register.setOpaque(false); 
		register.setBounds(795, 41, 210, 59);
		register.setToolTipText("Registrar Jugador");
		add(register);
		
		
	}

	public JButton getLogin() {
		return login;
	}

	public void setLogin(JButton login) {
		this.login = login;
	}

	public JButton getRegister() {
		return register;
	}

	public void setRegister(JButton register) {
		this.register = register;
	}

	public JButton getInfo() {
		return info;
	}

	public void setInfo(JButton info) {
		this.info = info;
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

	public JTextField getTxfNumDoc() {
		return txfNumDoc;
	}

	public void setTxfNumDoc(JTextField txfNumDoc) {
		this.txfNumDoc = txfNumDoc;
	}

}
