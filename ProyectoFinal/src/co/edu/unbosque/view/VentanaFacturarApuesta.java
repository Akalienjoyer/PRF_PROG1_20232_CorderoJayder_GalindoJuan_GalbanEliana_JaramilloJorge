package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaFacturarApuesta extends JFrame{
	
	private JButton baloto, superAstro, chance, loteria, betplay, volverInicio;
	private JLabel imagenFondo;
	
	public VentanaFacturarApuesta() {
		// TODO Auto-generated constructor stub
		setSize(1150, 700);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
        setUndecorated(true);
        
        volverInicio = new JButton("REGRESAR");
		volverInicio.setFont(new Font("Nue Gothic", 1, 20));
		volverInicio.setForeground(Color.WHITE);
		volverInicio.setBackground(new Color(200, 200, 200));
		volverInicio.setOpaque(false);
		volverInicio.setContentAreaFilled(false);
		volverInicio.setBorderPainted(false);
		volverInicio.setBounds(-6, 660, 120, 30);
		volverInicio.setToolTipText("Regresa al Menu Anterior");
		add(volverInicio);
		
		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, getWidth(), getHeight());
		Image temp;
		temp = new ImageIcon("src/Imagenes/SelectorFacturar.png").getImage();
		ImageIcon img;
		img = new ImageIcon(
				temp.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
		imagenFondo.setIcon(img);
		add(imagenFondo);
		
		baloto = new JButton();
		baloto.setOpaque(false); 
		baloto.setBounds(51, 245, 195, 359);
		baloto.setToolTipText("Ingresar al juego 'BALOTO'");
		add(baloto);
		
		superAstro = new JButton();
		superAstro.setOpaque(false); 
		superAstro.setBounds(264, 245, 195, 359);
		superAstro.setToolTipText("Ingresar al juego 'SUPER ASTRO'");
		add(superAstro);
		
		betplay = new JButton();
		betplay.setOpaque(false); 
		betplay.setBounds(477, 245, 195, 359);
		betplay.setToolTipText("Ingresar al juego 'BETPLAY'");
		add(betplay);
		
		chance = new JButton();
		chance.setOpaque(false); 
		chance.setBounds(690, 245, 195, 359);
		chance.setToolTipText("Ingresar al juego 'CHANCE'");
		add(chance);
		
		loteria = new JButton();
		loteria.setOpaque(false); 
		loteria.setBounds(903, 245, 195, 359);
		loteria.setToolTipText("Ingresar al juego 'LOTERIA'");
		add(loteria);
		
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
		return volverInicio;
	}

	public void setVolverInicio(JButton volverInicio) {
		this.volverInicio = volverInicio;
	}

	public JLabel getImagenFondo() {
		return imagenFondo;
	}

	public void setImagenFondo(JLabel imagenFondo) {
		this.imagenFondo = imagenFondo;
	}
}
