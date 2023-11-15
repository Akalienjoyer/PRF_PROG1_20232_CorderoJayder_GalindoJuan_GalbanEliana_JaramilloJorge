package co.edu.unbosque.model;

public abstract class CasaApuestaDTO {

	private String nombreCasa;
	private int numSedes;
	private double budget;
	
	public CasaApuestaDTO() {

	}

	public CasaApuestaDTO(String nombreCasa, int numSedes, double budget) {
		super();
		this.nombreCasa = nombreCasa;
		this.numSedes = numSedes;
		this.budget = budget;
	}

	public String getNombreCasa() {
		return nombreCasa;
	}

	public void setNombreCasa(String nombreCasa) {
		this.nombreCasa = nombreCasa;
	}

	public int getNumSedes() {
		return numSedes;
	}

	public void setNumSedes(int numSedes) {
		this.numSedes = numSedes;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	@Override
	public String toString() {
		return "CasaApuestaDTO [nombreCasa=" + nombreCasa + ", numSedes=" + numSedes + ", budget=" + budget + "]";
	}
	
	public boolean checkBudget(double b1,double b2,double b3,double b4,double b5) {
		if((b1+b2+b3+b4+b5)==getBudget()) {
			return true;
		}else {
			return false;
		}
	}
}
