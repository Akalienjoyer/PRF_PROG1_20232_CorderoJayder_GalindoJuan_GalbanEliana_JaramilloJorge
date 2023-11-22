package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.ApostadorDTO;

public class VentanaTablaApostadores extends JFrame{

	private JTable table;
    private DefaultTableModel tabla;
    public VentanaTablaApostadores(ArrayList<ApostadorDTO> list) {
    	
    	setBounds(500,80,742,633);
    	setResizable(false);
    	setTitle("Registro de existencias - ");
    	setDefaultCloseOperation(HIDE_ON_CLOSE);
    	
    	  tabla = new DefaultTableModel();
          tabla.addColumn("Nombre");
          tabla.addColumn("Cedula");
          tabla.addColumn("Sede");
          tabla.addColumn("Direccion");
          tabla.addColumn("Celular");
          tabla.addColumn("Saldo");

      	for (ApostadorDTO o : list) {
        	  tabla.addRow(new Object[] {o.getNombre(),o.getCedula(),o.getSede(),o.getDireccion(),o.getCelular(),o.getSaldo()});
  		}
          
          table = new JTable(tabla);
          table.setEnabled(false);
          JScrollPane scrollPane = new JScrollPane(table);
          getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
}

