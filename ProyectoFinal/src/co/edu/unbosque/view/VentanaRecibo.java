package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.ApostadorDTO;
import co.edu.unbosque.model.ApuestaBalotoDTO;
import co.edu.unbosque.model.ApuestaBetPlayDTO;
import co.edu.unbosque.model.ApuestaChanceDTO;
import co.edu.unbosque.model.ApuestaDTO;
import co.edu.unbosque.model.ApuestaLoteriaDTO;
import co.edu.unbosque.model.ApuestaSuperastroDTO;
import co.edu.unbosque.model.ReciboDTO;

public class VentanaRecibo extends JFrame{

	private JTable table;
    private DefaultTableModel tabla;
    public VentanaRecibo(ReciboDTO recibo) {
    	
    	setBounds(500,80,742,633);
    	setResizable(false);
    	setTitle("Registro de existencias - ");
    	setDefaultCloseOperation(HIDE_ON_CLOSE);
    	
    	  tabla = new DefaultTableModel();
          tabla.addColumn("Tipo de juego");
          tabla.addColumn("Dia de la semana");
          tabla.addColumn("Valor de la apuesta");
          
          ArrayList<ApuestaDTO> bets = new ArrayList<>();
	        bets = recibo.getApuestas();
	        
	        for (ApuestaDTO o : bets) {
	        	if(o instanceof ApuestaSuperastroDTO) {
	        		tabla.addRow(new Object[] {"Superastro",o.getDiaSemana(),o.getValorApuesta()});
	        	}
	        	if(o instanceof ApuestaLoteriaDTO) {
	        		tabla.addRow(new Object[] {"Loteria",o.getDiaSemana(),o.getValorApuesta()});
	        	}
	        	if(o instanceof ApuestaBalotoDTO) {
	        		tabla.addRow(new Object[] {"Baloto",o.getDiaSemana(),o.getValorApuesta()});
	        	}
	        	if(o instanceof ApuestaChanceDTO) {
	        		tabla.addRow(new Object[] {"Chance",o.getDiaSemana(),o.getValorApuesta()});
	        	}
	        	if(o instanceof ApuestaBetPlayDTO) {
	        		tabla.addRow(new Object[] {"BetPlay",o.getDiaSemana(),o.getValorApuesta()});
	        	}
			}
          table = new JTable(tabla);
          table.setEnabled(false);
          JScrollPane scrollPane = new JScrollPane(table);
          getContentPane().add(scrollPane, BorderLayout.CENTER);
	}

}
