package co.edu.unbosque.model;

import java.io.Serializable;

public class ApuestaSuperastroDTO extends ApuestaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6741252732865113967L;
	
	private int num1;
	private int num2;
	private int num3;
	private int num4;
	private String signo;
	
	public ApuestaSuperastroDTO() {
	
	}

	public ApuestaSuperastroDTO(int num1, int num2, int num3, int num4, String signo) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
		this.signo = signo;
	}
	public ApuestaSuperastroDTO(String nombre, long cedula, String diaSemana, double valorApuesta) {
		super(nombre, cedula, diaSemana, valorApuesta);
	}
	
	public ApuestaSuperastroDTO(String nombre, long cedula, String diaSemana, double valorApuesta, int num1, int num2,
			int num3, int num4, String signo) {
		super(nombre, cedula, diaSemana, valorApuesta);
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
		this.signo = signo;
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

	public String getSigno() {
		return signo;
	}

	public void setSigno(String signo) {
		this.signo = signo;
	}

	@Override
	public String toString() {
		return super.toString()+"ApuestaSuperastroDTO [num1=" + num1 + ", num2=" + num2 + ", num3=" + num3 + ", num4=" + num4
				+ ", signo=" + signo + "]\n";
	}
	
}
