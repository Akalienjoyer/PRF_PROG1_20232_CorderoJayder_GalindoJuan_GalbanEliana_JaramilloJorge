package co.edu.unbosque.model;

import java.io.Serializable;

public class ApuestaLoteriaDTO extends ApuestaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4910096821176764081L;
	
	private String nombreLoto;
	private int num1;
	private int num2;
	private int num3;
	private int num4;
	private int ser1;
	private int ser2;
	private int ser3;
	
	public ApuestaLoteriaDTO() {
	
	}
	public ApuestaLoteriaDTO(String nombreLoto, int num1, int num2, int num3, int num4, int ser1, int ser2, int ser3) {
		super();
		this.nombreLoto = nombreLoto;
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
		this.ser1 = ser1;
		this.ser2 = ser2;
		this.ser3 = ser3;
	}
	
	public ApuestaLoteriaDTO(String nombreLoto, long cedula, String diaSemana, double valorApuesta) {
		super(nombreLoto, cedula, diaSemana, valorApuesta);
		// TODO Auto-generated constructor stub
	}
	

	public ApuestaLoteriaDTO(String nombreLoto, long cedula, String diaSemana, double valorApuesta,
			String nombreLoto2, int num1, int num2, int num3, int num4, int ser1, int ser2, int ser3) {
		super(nombreLoto, cedula, diaSemana, valorApuesta);
		nombreLoto = nombreLoto2;
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
		this.ser1 = ser1;
		this.ser2 = ser2;
		this.ser3 = ser3;
	}
	public String getNombreLoto() {
		return nombreLoto;
	}

	public void setNombreLoto(String nombreLoto) {
		this.nombreLoto = nombreLoto;
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

	public int getSer1() {
		return ser1;
	}

	public void setSer1(int ser1) {
		this.ser1 = ser1;
	}

	public int getSer2() {
		return ser2;
	}

	public void setSer2(int ser2) {
		this.ser2 = ser2;
	}

	public int getSer3() {
		return ser3;
	}

	public void setSer3(int ser3) {
		this.ser3 = ser3;
	}

	@Override
	public String toString() {
		return super.toString()+"ApuestaLoteria [nombreLoto=" + nombreLoto + ", num1=" + num1 + ", num2=" + num2 + ", num3=" + num3 + ", num4="
				+ num4 + ", ser1=" + ser1 + ", ser2=" + ser2 + ", ser3=" + ser3 + "] \n";
	}
	
	
}
