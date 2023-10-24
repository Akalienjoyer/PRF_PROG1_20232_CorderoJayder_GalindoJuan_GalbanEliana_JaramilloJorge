package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Data Transfer Object de Sede.
 * 
 * @author JorgeJ
 *
 */
public class SedeDTO implements Serializable{

	/**
	 * Se implementa la serializacion de los datos para su
	 * registro en archivos .dat
	 */
	private static final long serialVersionUID = -9068228043115375394L;
	private String ubicacion;
	private int empleados;
	
	/**
	 * Constructor sin parametros
	 */
	public SedeDTO() {
	
	}
	/**
	 * 
	 * Constructor con parametros propios
	 */
	public SedeDTO(String ubicacion, int empleados) {
		super();
		this.ubicacion = ubicacion;
		this.empleados = empleados;
	}
	/**
	 * Getters y setters
	 */
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public int getEmpleados() {
		return empleados;
	}
	public void setEmpleados(int empleados) {
		this.empleados = empleados;
	}
	/**
	 * Retorno de todos los atributos de la clase en un String
	 */
	@Override
	public String toString() {
		return "SedeDTO [ubicacion=" + ubicacion + ", empleados=" + empleados + "]\n";
	}
	
}
