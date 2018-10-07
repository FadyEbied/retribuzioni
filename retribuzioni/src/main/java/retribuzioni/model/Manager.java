package retribuzioni.model;

import java.util.List;

public class Manager extends Dependente {
	
	private double stipendioMensile;
	private List<Dependente> lstDependente;
	private double percentualeRetribuzione;

	public double calcoloStipendioMensile() {
		double totaleStipendioSottoPosti=0;
		
		for (Dependente tmpDependente : lstDependente) {
			totaleStipendioSottoPosti+=tmpDependente.calcoloStipendioMensile();
		}
		
		return stipendioMensile+(percentualeRetribuzione*totaleStipendioSottoPosti/100);
	}

	public double getStipendioMensile() {
		return stipendioMensile;
	}

	public void setStipendioMensile(double stipendioMensile) {
		this.stipendioMensile = stipendioMensile;
	}

	public List<Dependente> getLstDependente() {
		return lstDependente;
	}

	public void setLstDependente(List<Dependente> lstDependente) {
		this.lstDependente = lstDependente;
	}
	
	public double getPercentualeRetribuzione() {
		return percentualeRetribuzione;
	}
	
	public void setPercentualeRetribuzione(double percentualeRetribuzione) {
		this.percentualeRetribuzione = percentualeRetribuzione;
	}

}
