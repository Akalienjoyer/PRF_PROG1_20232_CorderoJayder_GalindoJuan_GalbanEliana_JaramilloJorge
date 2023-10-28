package co.edu.unbosque.model;

import java.io.Serializable;
/*
 * Data Transfer Object de Apostador.
 * @author JorgeJ
 * 
 */
public class ApostadorDTO implements Serializable{
	/**
	 * Se implementa la serializacion de los datos para su
	 * registro en archivos .dat
	 */
	private static final long serialVersionUID = -8015862659839688353L;
	private String nombre;
	private long cedula;
	private String sede;
	private String direccion;
	private long celular;
	private String contraseña;
	private String user;
	
	/**
	 * Constructor sin parametros
	 */
	public ApostadorDTO() {
	
	}
	/**
	 * 
	 * Constructor con parametros propios
	 */
	public ApostadorDTO(String nombre, long cedula, String sede, String direccion, long celular, String contraseña, String user) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.sede = sede;
		this.direccion = direccion;
		this.celular = celular;
		this.contraseña = contraseña;
		this.user = user;
	}
	/**
	 * Getters y Setters
	 */
	
	public String getNombre() {
		return nombre;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
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
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public long getCelular() {
		return celular;
	}
	public void setCelular(long celular) {
		this.celular = celular;
	}
	/**
	 * Retorno de todos los atributos de la clase en un String
	 */
	@Override
	public String toString() {
		return "ApostadorDTO [nombre=" + nombre + ", cedula=" + cedula + ", sede=" + sede + ", direccion=" + direccion
				+ ", celular=" + celular + "]\n ";
	}
	
}
