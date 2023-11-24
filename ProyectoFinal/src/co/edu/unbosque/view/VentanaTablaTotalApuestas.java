package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.SedeDTO;

public class VentanaTablaTotalApuestas extends JFrame{
	
	private JLabel dato;
    private DefaultTableModel tabla;
    
    public VentanaTablaTotalApuestas(String data) {
		// TODO Auto-generated constructor stub
    	
    	setBounds(500,80,742,633);
		setLocationRelativeTo(null);
    	setResizable(false);
    	setDefaultCloseOperation(HIDE_ON_CLOSE);
	
    	dato = new JLabel("El total es: "+data);
    	dato.setBounds(100,100,100,100);
    	add(dato);
    	
    }
}
