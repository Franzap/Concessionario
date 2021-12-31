package Concessionario.entita;

import Concessionario.interfacce.AutomobileI;
import Concessionario.interfacce.VeicoloI;

public class Automobile extends Veicolo implements VeicoloI, AutomobileI{
	
	private Persona proprietario;
	
	
	public Automobile(String marca, String modello, String targa, int cilindrata, double costo,Persona proprietario) {
		super(marca, modello, targa, cilindrata, costo);
		this.proprietario=proprietario;
	}
	
	/**
	 * @return the proprietario
	 */
	
	public Persona getProprietario() {
		return proprietario;
	}
	/**
	 * @param proprietario the proprietario to set
	 */

	public void setProprietario(Persona proprietario) {
		this.proprietario = proprietario;
	}
	
	@Override
	public void stampaDettagliVeicolo() {
		super.stampaDettagliVeicolo();
		this.stampaProprietario();
	}
	
	@Override
	public void stampaProprietario() {
		// TODO Auto-generated method stub
		this.proprietario.stampaIdentita();
	}
	
}
