package Concessionario.entita;

import Concessionario.interfacce.MacchinaAgricolaI;
import Concessionario.interfacce.VeicoloI;

public class MacchinaAgricola extends Veicolo implements VeicoloI, MacchinaAgricolaI{
	
	private int tonnellate;
	
	public MacchinaAgricola(String marca, String modello, String targa, int cilindrata, double costo, int tonnellate) {
		super(marca, modello, targa, cilindrata, costo);
		this.tonnellate=tonnellate;
	}

	/**
	 * @return the tonnellate
	 */
	public int getTonnellate() {
		return tonnellate;
	}
	
	/**
	 * @param tonnellate the tonnellate to set
	 */
	
	public void setTonnellate(int tonnellate) {
		this.tonnellate = tonnellate;
	}
	
	@Override
	public void stampaDettagliVeicolo() {
		super.stampaDettagliVeicolo();
		this.stampaTonnellate();
	}
	
	@Override
	public void stampaTonnellate() {
		System.out.println("Tonnellate: "+ this.getTonnellate() + "t");
	}
}
