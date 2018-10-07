package retribuzioni;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import retribuzioni.model.Dependente;
import retribuzioni.model.Manager;
import retribuzioni.model.Tecnico;
import retribuzioni.model.Venditore;

public class TestUnit {
	
	private Dependente vittorio = null;
	private Dependente teresa = null;
	private Dependente mario = null;
	private Dependente virna = null;
	private Dependente maria = null;


	@Before
	public void initailizzation() {
		vittorio = new Venditore();
		vittorio.setNome("Vittorio");
		((Venditore) vittorio).setStipendioMensile(500);
		((Venditore) vittorio).setPercentualeDiProfitti(10);
		((Venditore) vittorio).setValoreDelleVendite(15000);

		teresa = new Tecnico();
		teresa.setNome("Teresa");
		((Tecnico) teresa).setStipendioMensile(1400);

		mario = new Manager();
		((Manager) mario).setNome("Mario");
		((Manager) mario).setStipendioMensile(1500);
		((Manager) mario).setPercentualeRetribuzione(.5);		
		
		List<Dependente> tmpLstMario = new ArrayList<Dependente>();
		tmpLstMario.add(vittorio);
		tmpLstMario.add(teresa);
		((Manager) mario).setLstDependente(tmpLstMario);
		
		
		virna = new Venditore();
		virna.setNome("Virna");
		((Venditore) virna).setStipendioMensile(500);
		((Venditore) virna).setPercentualeDiProfitti(10);
		((Venditore) virna).setValoreDelleVendite(17000);

		
		maria = new Manager();
		((Manager) maria).setNome("Maria");
		((Manager) maria).setStipendioMensile(1500);
		((Manager) maria).setPercentualeRetribuzione(.5);		
		
		List<Dependente> tmpLstMaria = new ArrayList<Dependente>();
		tmpLstMaria.add(mario);
		tmpLstMaria.add(virna);
		((Manager) maria).setLstDependente(tmpLstMaria);

		
	}
	
	@Test
	public void testVittorio() {
		assertEquals(500+(10*15000/100), ((Venditore) vittorio).calcoloStipendioMensile(),0);
	}
	
	@Test
	public void testTeresa() {		
		assertEquals(1400, ((Tecnico) teresa).calcoloStipendioMensile(),0);
	}
	
	@Test
	public void testMario() {
		double percentualeStipendioSottoposto = (vittorio.calcoloStipendioMensile()+teresa.calcoloStipendioMensile())*.5/100;
		assertEquals(percentualeStipendioSottoposto+1500, mario.calcoloStipendioMensile(),0);
	}
	
	@Test
	public void testVirna() {
		assertEquals(500+(10*17000/100), ((Venditore) virna).calcoloStipendioMensile(),0);

	}
	
	@Test
	public void testMaria() {
		double percentualeStipendioSottoposto = (mario.calcoloStipendioMensile()+virna.calcoloStipendioMensile())*.5/100;
		assertEquals(percentualeStipendioSottoposto+1500, maria.calcoloStipendioMensile(),0);

	}
	
	@Test
	public void testTotale() {
		double totalePrevisto = vittorio.calcoloStipendioMensile()+ teresa.calcoloStipendioMensile()+mario.calcoloStipendioMensile()+virna.calcoloStipendioMensile()+maria.calcoloStipendioMensile();
		
		double stipendioVittorio = 500+1500;
		System.out.println("Lo stipendio di Vittorio è "+stipendioVittorio);

		double stipendioTeresa= 1400;
		System.out.println("Lo stipendio di Teresa è "+stipendioTeresa);
		
		double stipendioMario= ((stipendioVittorio+stipendioTeresa)*.5/100)+1500;
		System.out.println("Lo stipendio di Mario è "+stipendioMario);
		
		double stipendioVirna=1700+500;
		System.out.println("Lo stipendio di Virna è "+stipendioVirna);
		
		double stipendioMaria= ((stipendioMario+stipendioVirna)*.5/100)+1500;
		System.out.println("Lo stipendio di Maria è "+stipendioMaria);
		
		double totaleReale = stipendioMaria+stipendioMario+stipendioTeresa+stipendioVirna+stipendioVittorio;
		
		//assertEquals(totalePrevisto, totaleReale,0);
		assertTrue("Totale: "+totaleReale, totaleReale==totalePrevisto);
		System.out.println("Il totale  delle retribuzioni dell'intera azienda è "+totaleReale);
	}
	

}
