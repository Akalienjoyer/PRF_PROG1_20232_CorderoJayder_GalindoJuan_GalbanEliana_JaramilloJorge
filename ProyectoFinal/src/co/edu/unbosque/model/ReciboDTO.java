package co.edu.unbosque.model;

import java.util.ArrayList;

public class ReciboDTO {

	private long Cedula;
	private ArrayList<ApuestaDTO> apuestas;
	
	public ReciboDTO() {
	
	}

	public ReciboDTO(long cedula, ArrayList<ApuestaDTO> apuestas) {
		super();
		Cedula = cedula;
		this.apuestas = apuestas;
	}

	public long getCedula() {
		return Cedula;
	}

	public void setCedula(long cedula) {
		Cedula = cedula;
	}

	public ArrayList<ApuestaDTO> getApuestas() {
		return apuestas;
	}

	public void setApuestas(ArrayList<ApuestaDTO> apuestas) {
		this.apuestas = apuestas;
	}

	@Override
	public String toString() {
		return "ReciboDTO [Cedula=" + Cedula + ", apuestas=" + apuestas + "]";
	}
	
}
