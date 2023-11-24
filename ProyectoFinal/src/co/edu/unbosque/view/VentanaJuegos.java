package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaJuegos extends JFrame{

	private JTextField baloto, superastro, betPlay, chance, loteria;
	private JLabel imagenFondo, presupuesto;
	private JButton ingresar, regresar, consultar;
	
	public VentanaJuegos() {
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
		
		consultar = new JButton();
		consultar.setFont(new Font("Nue Gothic", 1, 22));
		consultar.setForeground(Color.WHITE);
		consultar.setBackground(new Color(200, 200, 200));
		consultar.setOpaque(false);
		consultar.setContentAreaFilled(false);
		consultar.setBorderPainted(false);
		consultar.setBounds(800, 100, 300, 30);
		consultar.setToolTipText("Consultar");
		add(consultar);
        
        ingresar = new JButton();
		ingresar.setFont(new Font("Nue Gothic", 1, 22));
		ingresar.setForeground(Color.WHITE);
		ingresar.setBackground(new Color(200, 200, 200));
		ingresar.setOpaque(false);
		ingresar.setContentAreaFilled(false);
		ingresar.setBorderPainted(false);
		ingresar.setBounds(820, 510, 125, 53);
		ingresar.setToolTipText("Ingresar datos");
		add(ingresar);
        
        baloto = new JTextField();
    	baloto.setBorder(null); 
    	baloto.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
        baloto.setBackground(new java.awt.Color(0, 0, 0, 1));
        baloto.setBounds(90, 422, 125, 53); 
        baloto.setToolTipText("Ingresa el presupuesto"); 
		add(baloto);
		
		superastro = new JTextField();
		superastro.setBorder(null); 
		superastro.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		superastro.setBackground(new java.awt.Color(0, 0, 0, 1));
		superastro.setBounds(310, 422, 125, 53); 
		superastro.setToolTipText("Ingresa el presupuesto"); 
	    add(superastro);
	    
	    betPlay = new JTextField();
	    betPlay.setBorder(null); 
	    betPlay.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
	    betPlay.setBackground(new java.awt.Color(0, 0, 0, 1));
	    betPlay.setBounds(515, 422, 125, 53); 
	    betPlay.setToolTipText("Ingresa el presupuesto"); 
		add(betPlay);
		
		chance = new JTextField();
		chance.setBorder(null); 
		chance.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		chance.setBackground(new java.awt.Color(0, 0, 0, 1));
		chance.setBounds(738, 422, 125, 53); 
		chance.setToolTipText("Ingresa el presupuesto"); 
		add(chance);
		
		loteria = new JTextField();
		loteria.setBorder(null); 
		loteria.setFont(new Font("Nue Gothic", Font.PLAIN, 18)); 
		loteria.setBackground(new java.awt.Color(0, 0, 0, 1));
		loteria.setBounds(945, 422, 125, 53); 
		loteria.setToolTipText("Ingresa el presupuesto"); 
		add(loteria);
        
		presupuesto = new JLabel();
		presupuesto.setText("Null");
		presupuesto.setBounds(545, 510, 325, 53); 
		presupuesto.setForeground(Color.BLACK);
		presupuesto.setFont(new Font("Nue Gothic", 1, 30));
		add(presupuesto);
		
        imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, getWidth(), getHeight());
		Image temp;
		temp = new ImageIcon("src/Imagenes/GestorJuegos.png").getImage();
		ImageIcon img;
		img = new ImageIcon(
				temp.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
		imagenFondo.setIcon(img);
		add(imagenFondo);
		
		
	}

	public void updateData(String data) {
		presupuesto.setText(data);
	}
	
	public JTextField getBaloto() {
		return baloto;
	}

	public void setBaloto(JTextField baloto) {
		this.baloto = baloto;
	}

	public JButton getConsultar() {
		return consultar;
	}

	public void setConsultar(JButton consultar) {
		this.consultar = consultar;
	}

	public JTextField getSuperastro() {
		return superastro;
	}

	public void setSuperastro(JTextField superastro) {
		this.superastro = superastro;
	}

	public JTextField getBetPlay() {
		return betPlay;
	}

	public void setBetPlay(JTextField betPlay) {
		this.betPlay = betPlay;
	}

	public JTextField getChance() {
		return chance;
	}

	public void setChance(JTextField chance) {
		this.chance = chance;
	}

	public JTextField getLoteria() {
		return loteria;
	}

	public void setLoteria(JTextField loteria) {
		this.loteria = loteria;
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
	
}
