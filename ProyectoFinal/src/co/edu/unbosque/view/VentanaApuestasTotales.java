package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaApuestasTotales extends JFrame{
	
	private JTable table;
    private DefaultTableModel tabla;
    
    public VentanaApuestasTotales() {
		// TODO Auto-generated constructor stub

    	setBounds(500,80,742,633);
    	setResizable(false);
    	setLocationRelativeTo(null);
		setLayout(null);
    	setDefaultCloseOperation(HIDE_ON_CLOSE);
    	
    	  tabla = new DefaultTableModel();
          tabla.addColumn("Ubicacion");
          tabla.addColumn("cantidad de empleados");
          
          table = new JTable(tabla);
          table.setEnabled(false);
          JScrollPane scrollPane = new JScrollPane(table);
          getContentPane().add(scrollPane, BorderLayout.CENTER);
	
    }
	
	

}
