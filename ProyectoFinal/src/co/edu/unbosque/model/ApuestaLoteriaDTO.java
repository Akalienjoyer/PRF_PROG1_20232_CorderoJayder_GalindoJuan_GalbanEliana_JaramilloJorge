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
	private int ser;
	
	public ApuestaLoteriaDTO() {
	
	}
	public ApuestaLoteriaDTO(String nombreLoto, int num1, int num2, int num3, int num4, int ser) {
		super();
		this.nombreLoto = nombreLoto;
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
		this.ser = ser;
	}
	
	public ApuestaLoteriaDTO(String nombreLoto, long cedula, String diaSemana, double valorApuesta) {
		super(nombreLoto, cedula, diaSemana, valorApuesta);
		// TODO Auto-generated constructor stub
	}
	

	public ApuestaLoteriaDTO(String nombreLoto, long cedula, String diaSemana, double valorApuesta,
			String nombreLoto2, int num1, int num2, int num3, int num4, int ser) {
		super(nombreLoto, cedula, diaSemana, valorApuesta);
		nombreLoto = nombreLoto2;
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
		this.ser = ser;
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

	public int getSer() {
		return ser;
	}
	public void setSer(int ser) {
		this.ser = ser;
	}
	@Override
	public String toString() {
		return super.toString()+"ApuestaLoteria [nombreLoto=" + nombreLoto + ", num1=" + num1 + ", num2=" + num2 + ", num3=" + num3 + ", num4="
				+ num4 + ", Serie=" + ser +"] \n";
	}
	
	
}
