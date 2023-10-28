package co.edu.unbosque.model;

import java.io.Serializable;

public class ApuestaBetPlayDTO extends ApuestaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8110449012860759144L;
	
	private String partido;
	private String resultado;
	
	public ApuestaBetPlayDTO() {
	
	}
	public ApuestaBetPlayDTO(String partido, String resultado) {
		super();
		this.partido = partido;
		this.resultado = resultado;
	}
	
	public ApuestaBetPlayDTO(String nombre, long cedula, String diaSemana, double valorApuesta) {
		super(nombre, cedula, diaSemana, valorApuesta);
		// TODO Auto-generated constructor stub
	}
	
	public ApuestaBetPlayDTO(String nombre, long cedula, String diaSemana, double valorApuesta,
			String partido, String resultado) {
		super(nombre, cedula, diaSemana, valorApuesta);
		this.partido = partido;
		this.resultado = resultado;
	}
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	@Override
	public String toString() {
		return super.toString()+"ApuestaBetPlayDTO [partido=" + partido + ", resultado=" + resultado + "]\n";
	}
	
}
