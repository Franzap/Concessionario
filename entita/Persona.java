package Concessionario.entita;

import Concessionario.interfacce.PersonaI;

public class Persona implements PersonaI{
	private String nome;
	private String cognome;
	private int eta;
	
	public Persona(String nome, String cognome, int eta) {
		this.nome=nome;
		this.cognome=cognome;
		this.eta=eta;
	}
	public Persona() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the nome 
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}
	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	/**
	 * @return the eta
	 */
	public int getEta() {
		return eta;
	}
	/**
	 * @param eta the eta to set
	 */
	public void setEta(int eta) {
		this.eta = eta;
	}
	@Override
	public void stampaIdentita() {
		System.out.println("Nome: "+this.getNome());
		System.out.println("Cognome: "+this.getCognome());
		System.out.println("Età: "+this.eta);
	}
	
}
