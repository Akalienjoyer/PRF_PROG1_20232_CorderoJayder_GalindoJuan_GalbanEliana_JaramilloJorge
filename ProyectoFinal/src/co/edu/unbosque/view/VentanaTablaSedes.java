package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.SedeDTO;

public class VentanaTablaSedes extends JFrame{

	private JTable table;
    private DefaultTableModel tabla;
    public VentanaTablaSedes(ArrayList<SedeDTO> list) {
    	
    	setBounds(500,80,742,633);
    	setResizable(false);
    	setTitle("Registro de existencias - ");
    	setDefaultCloseOperation(HIDE_ON_CLOSE);
    	
    	  tabla = new DefaultTableModel();
          tabla.addColumn("Ubicacion");
          tabla.addColumn("cantidad de empleados");
          

      	for (SedeDTO o : list) {
        	  tabla.addRow(new Object[] {o.getUbicacion(),o.getEmpleados()});
  		}
          
          table = new JTable(tabla);
          table.setEnabled(false);
          JScrollPane scrollPane = new JScrollPane(table);
          getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
}

