package co.edu.unbosque.model;

import java.io.Serializable;

public class ApuestaChanceDTO extends ApuestaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5709237510620916838L;
	
	private String nombre;
	private int num1;
	private int num2;
	private int num3;
	private int num4;
	
	public ApuestaChanceDTO() {
	
	}

	public ApuestaChanceDTO(String nombre, int num1, int num2, int num3, int num4) {
		super();
		this.nombre = nombre;
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
	}

	public ApuestaChanceDTO(String nombre, long cedula, String diaSemana, double valorApuesta) {
		super(nombre, cedula, diaSemana, valorApuesta);
		// TODO Auto-generated constructor stub
	}

	public ApuestaChanceDTO(String nombre, long cedula, String diaSemana, double valorApuesta, String nombre2, int num1,
			int num2, int num3, int num4) {
		super(nombre, cedula, diaSemana, valorApuesta);
		nombre = nombre2;
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public int getNum3() {
		return num3;
	}

	public void setNum3(int num3) {
		this.num3 = num3;
	}

	public int getNum4() {
		return num4;
	}

	public void setNum4(int num4) {
		this.num4 = num4;
	}

	@Override
	public String toString() {
		return super.toString()+"ApuestaChanceDTO [nombre=" + nombre + ", num1=" + num1 + ", num2=" + num2 + ", num3=" + num3 + ", num4="
				+ num4 + "]\n";
	}
	
}
