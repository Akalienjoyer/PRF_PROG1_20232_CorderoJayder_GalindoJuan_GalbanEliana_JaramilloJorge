package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaSeleccionJuegosAdmin extends JFrame{
	
	private JButton baloto, superAstro, chance, loteria, betplay, regresar;
	private JLabel imagenFondo;
	
	public VentanaSeleccionJuegosAdmin() {
		// TODO Auto-generated constructor stub
		setSize(1150, 700);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
        setUndecorated(true);
        
        regresar = new JButton("REGRESAR");
		regresar.setFont(new Font("Nue Gothic", 1, 20));
		regresar.setForeground(Color.WHITE);
		regresar.setBackground(new Color(200, 200, 200));
		regresar.setOpaque(false);
		regresar.setContentAreaFilled(false);
		regresar.setBorderPainted(false);
		regresar.setBounds(-6, 660, 120, 30);
		regresar.setToolTipText("Regresa al Menu Anterior");
		add(regresar);
		
		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, getWidth(), getHeight());
		Image temp;
		temp = new ImageIcon("src/Imagenes/GestorJuegos.png").getImage();
		ImageIcon img;
		img = new ImageIcon(
				temp.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
		imagenFondo.setIcon(img);
		add(imagenFondo);
		
		baloto = new JButton();
		baloto.setOpaque(false); 
		baloto.setBounds(95, 249, 135, 145);
		baloto.setToolTipText("Ingresar al juego 'BALOTO'");
		add(baloto);
		
		superAstro = new JButton();
		superAstro.setOpaque(false); 
		superAstro.setBounds(369, 249, 135, 145);
		superAstro.setToolTipText("Ingresar al juego 'SUPER ASTRO'");
		add(superAstro);
		
		chance = new JButton();
		chance.setOpaque(false); 
		chance.setBounds(639, 249, 135, 145);
		chance.setToolTipText("Ingresar al juego 'CHANCE'");
		add(chance);
		
		loteria = new JButton();
		loteria.setOpaque(false); 
		loteria.setBounds(912, 249, 135, 145);
		loteria.setToolTipText("Ingresar al juego 'LOTERIA'");
		add(loteria);
		
		betplay = new JButton();
		betplay.setOpaque(false); 
		betplay.setBounds(500, 410, 135, 145);
		betplay.setToolTipText("Ingresar al juego 'BETPLAY'");
		add(betplay);
		
	}

	public JButton getBaloto() {
		return baloto;
	}

	public void setBaloto(JButton baloto) {
		this.baloto = baloto;
	}

	public JButton getSuperAstro() {
		return superAstro;
	}

	public void setSuperAstro(JButton superAstro) {
		this.superAstro = superAstro;
	}

	public JButton getChance() {
		return chance;
	}

	public void setChance(JButton chance) {
		this.chance = chance;
	}

	public JButton getLoteria() {
		return loteria;
	}

	public void setLoteria(JButton loteria) {
		this.loteria = loteria;
	}

	public JButton getBetplay() {
		return betplay;
	}

	public void setBetplay(JButton betplay) {
		this.betplay = betplay;
	}

	public JButton getVolverInicio() {
		return regresar;
	}

	public void setVolverInicio(JButton volverInicio) {
		this.regresar = volverInicio;
	}

	public JLabel getImagenFondo() {
		return imagenFondo;
	}

	public void setImagenFondo(JLabel imagenFondo) {
		this.imagenFondo = imagenFondo;
	}

	public JButton getRegresar() {
		return regresar;
	}

	public void setRegresar(JButton regresar) {
		this.regresar = regresar;
	}
	
	
	
}
