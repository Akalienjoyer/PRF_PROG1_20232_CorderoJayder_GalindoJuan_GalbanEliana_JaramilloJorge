package co.edu.unbosque.model;

import java.io.Serializable;

public class ApuestaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3817671324002359345L;
	private String nombre;
	private long cedula;
	private String diaSemana;
	private double valorApuesta;
	
	public ApuestaDTO() {
	
	}

	public ApuestaDTO(String nombre, long cedula, String diaSemana, double valorApuesta) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.diaSemana = diaSemana;
		this.valorApuesta = valorApuesta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public double getValorApuesta() {
		return valorApuesta;
	}

	public void setValorApuesta(double valorApuesta) {
		this.valorApuesta = valorApuesta;
	}

	@Override
	public String toString() {
		return "ApuestaDTO [nombre=" + nombre + ", cedula=" + cedula + ", diaSemana=" + diaSemana + ", valorApuesta="
				+ valorApuesta + "]\n";
	}
	
}
