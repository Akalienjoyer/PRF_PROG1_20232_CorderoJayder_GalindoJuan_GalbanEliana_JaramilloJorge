package co.edu.unbosque.model;

import java.io.Serializable;

public class JuegoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4663134442682867443L;

	private String nombre;
	private String tipo;
	private double presupuesto;
	
	public JuegoDTO() {
	
	}

	public JuegoDTO(String nombre, String tipo, double presupuesto) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.presupuesto = presupuesto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	@Override
	public String toString() {
		return "JuegoDTO [nombre=" + nombre + ", tipo=" + tipo + ", presupuesto=" + presupuesto + "]\n";
	}
	
}
