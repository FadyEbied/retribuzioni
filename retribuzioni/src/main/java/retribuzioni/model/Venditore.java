package retribuzioni.model;

public class Venditore extends Dependente{

	private double stipendioMensile;
	private double percentualeDiProfitti;
	private double valoreDelleVendite;
	
	public double calcoloStipendioMensile() {
		return stipendioMensile+(valoreDelleVendite*percentualeDiProfitti/100);
	}

	public double getStipendioMensile() {
		return stipendioMensile;
	}
	
	public void setStipendioMensile(double stipendioMensile) {
		this.stipendioMensile = stipendioMensile;
	}

	public double getPercentualeDiProfitti() {
		return percentualeDiProfitti;
	}

	public void setPercentualeDiProfitti(double percentualeDiProfitti) {
		this.percentualeDiProfitti = percentualeDiProfitti;
	}

	public double getValoreDelleVendite() {
		return valoreDelleVendite;
	}

	public void setValoreDelleVendite(double valoreDelleVendite) {
		this.valoreDelleVendite = valoreDelleVendite;
	}

}
