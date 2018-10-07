package retribuzioni.model;

public class Tecnico extends Dependente{

	private double stipendioMensile;
	
	public double calcoloStipendioMensile() {
		return stipendioMensile;
	}

	public double getStipendioMensile() {
		return stipendioMensile;
	}
	
	public void setStipendioMensile(double stipendioMensile) {
		this.stipendioMensile = stipendioMensile;
	}
	
}
