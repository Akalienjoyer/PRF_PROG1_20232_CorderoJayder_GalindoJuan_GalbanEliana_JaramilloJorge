package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.JuegoDTO;

public class VentanaTablaJuegos extends JFrame{

	private JTable table;
    private DefaultTableModel tabla;
    public VentanaTablaJuegos(ArrayList<JuegoDTO> list) {
    	
    	setBounds(500,80,742,633);
    	setResizable(false);
		setLocationRelativeTo(null);
    	setTitle("Registro de existencias - ");
    	setDefaultCloseOperation(HIDE_ON_CLOSE);
    	
    	  tabla = new DefaultTableModel();
          tabla.addColumn("Juego");
          tabla.addColumn("Presupuesto");
          

      	for (JuegoDTO o : list) {
        	  tabla.addRow(new Object[] {o.getTipo(),o.getPresupuesto()});
  		}
          
          table = new JTable(tabla);
          table.setEnabled(false);
          JScrollPane scrollPane = new JScrollPane(table);
          getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
}

