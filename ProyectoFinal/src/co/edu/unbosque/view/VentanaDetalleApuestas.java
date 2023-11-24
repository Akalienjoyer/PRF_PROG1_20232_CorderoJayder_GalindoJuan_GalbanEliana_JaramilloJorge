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
import co.edu.unbosque.model.persistence.ApuestaChanceDAO;

public class VentanaDetalleApuestas extends JFrame{
	private JTable table;
    private DefaultTableModel tabla;
    
    public VentanaDetalleApuestas(ArrayList<ApuestaDTO> apuestas) {
		// TODO Auto-generated constructor stub
    	
    	setBounds(200,80,1242,633);
    	setResizable(false);
    	setDefaultCloseOperation(HIDE_ON_CLOSE);
    	
    	  tabla = new DefaultTableModel();
          tabla.addColumn("Juego");
          tabla.addColumn("Cedula");
          tabla.addColumn("Sede");
          tabla.addColumn("Dia de semana");
          tabla.addColumn("num1");
          tabla.addColumn("num2");
          tabla.addColumn("num3");
          tabla.addColumn("num4");
          tabla.addColumn("num5");
          tabla.addColumn("num6");
          tabla.addColumn("nombre loteria");
          tabla.addColumn("serie");
          tabla.addColumn("Signo");
          tabla.addColumn("Partido");
          tabla.addColumn("Resultado");
          tabla.addColumn("Valor");
          
          for (ApuestaDTO o : apuestas) {
        	  if(o instanceof ApuestaLoteriaDTO) {
        		  tabla.addRow(new Object[] {"Loteria",o.getCedula(),o.getNombre(),o.getDiaSemana(),((ApuestaLoteriaDTO)o).getNum1(),((ApuestaLoteriaDTO)o).getNum2()
        		  ,((ApuestaLoteriaDTO)o).getNum3(),((ApuestaLoteriaDTO)o).getNum4(),"N/A","N/A",((ApuestaLoteriaDTO)o).getNombreLoto()
        		  ,((ApuestaLoteriaDTO)o).getSer(),"N/A","N/A","N/A",o.getValorApuesta()});
        	  }
        	  if(o instanceof ApuestaBalotoDTO) {
        		  tabla.addRow(new Object[] {"Baloto",o.getCedula(),o.getNombre(),o.getDiaSemana(),((ApuestaBalotoDTO)o).getNum1(),((ApuestaBalotoDTO)o).getNum2()
        		  ,((ApuestaBalotoDTO)o).getNum3(),((ApuestaBalotoDTO)o).getNum4(),((ApuestaBalotoDTO)o).getNum5(),((ApuestaBalotoDTO)o).getNum6(),
        		  "N/A","N/A","N/A","N/A","N/A",o.getValorApuesta()});
        	  }
        	  if(o instanceof ApuestaChanceDTO) {
        		  tabla.addRow(new Object[] {"Chance",o.getCedula(),o.getNombre(),o.getDiaSemana(),((ApuestaChanceDTO)o).getNum1(),((ApuestaChanceDTO)o).getNum2()
        		  ,((ApuestaChanceDTO)o).getNum3(),((ApuestaChanceDTO)o).getNum4(),"N/A","N/A",((ApuestaChanceDTO)o).getNombreLoto()
        		  ,"N/A","N/A","N/A","N/A",o.getValorApuesta()});
        	  }
        	  if(o instanceof ApuestaSuperastroDTO) {
        		  tabla.addRow(new Object[] {"Superastro",o.getCedula(),o.getNombre(),o.getDiaSemana(),((ApuestaSuperastroDTO)o).getNum1(),((ApuestaSuperastroDTO)o).getNum2()
        		  ,((ApuestaSuperastroDTO)o).getNum3(),((ApuestaSuperastroDTO)o).getNum4(),"N/A","N/A","N/A","N/A",((ApuestaSuperastroDTO)o).getSigno()
        		  ,"N/A","N/A",o.getValorApuesta()});
        	  }
        	  if(o instanceof ApuestaBetPlayDTO) {
        		  tabla.addRow(new Object[] {"BetPlay",o.getCedula(),o.getNombre(),o.getDiaSemana(),"N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A"
        		  ,((ApuestaBetPlayDTO)o).getPartido(),((ApuestaBetPlayDTO)o).getResultado(),o.getValorApuesta()});
        	  }
          }
          table = new JTable(tabla);
          table.setEnabled(false);
          JScrollPane scrollPane = new JScrollPane(table);
          getContentPane().add(scrollPane, BorderLayout.CENTER);
	
}
}
