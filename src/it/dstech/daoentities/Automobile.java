package it.dstech.daoentities;

public class Automobile extends Veicolo{
	
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
		
		this.getProprietario().stampaProprietario();
	}
	
}
