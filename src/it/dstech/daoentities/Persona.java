package concessionario_GRUPPO3;

public class Persona {
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
	public void stampaProprietario() {
		System.out.println(this.getNome());
		System.out.println(this.getCognome());
		System.out.println(this.eta);
		
	}
	
}
