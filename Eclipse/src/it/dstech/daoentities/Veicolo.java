package it.dstech.daoentities;

public abstract class Veicolo {
	private String marca;
	private String modello;
	private String targa;
	private int cilindrata;
	private double costo;
	
	public Veicolo(String marca, String modello, String targa, int cilindrata, double costo) {
		this.marca=marca;
		this.modello=modello;
		this.targa=targa;
		this.cilindrata=cilindrata;
		this.costo=costo;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}
	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	/**
	 * @return the modello
	 */
	public String getModello() {
		return modello;
	}
	/**
	 * @param modello the modello to set
	 */
	public void setModello(String modello) {
		this.modello = modello;
	}
	/**
	 * @return the targa
	 */
	public String getTarga() {
		return targa;
	}
	/**
	 * @param targa the targa to set
	 */
	public void setTarga(String targa) {
		this.targa = targa;
	}
	/**
	 * @return the cilindrata
	 */
	public int getCilindrata() {
		return cilindrata;
	}
	/**
	 * @param cilindrata the cilindrata to set
	 */
	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}
	/**
	 * @return the costo
	 */
	public double getCosto() {
		return costo;
	}
	/**
	 * @param costo the costo to set
	 */
	public void setCosto(double costo) {
		this.costo = costo;
	}

	public void stampaVeicoloSemplificato() {
		
		String nome=this.getClass().getName();
		System.out.println("Tipo Veicolo: "+ nome.split("\\.")[nome.split("\\.").length-1]);
		System.out.println(this.getMarca()+" "+ this.getModello());

	}
	
	public boolean equals(Veicolo v) {
		if(this.getTarga().toLowerCase().equals(v.getTarga())) {
			return true;
		}
		return false;
		
	}

	public void stampaDettagliVeicolo() {
		String nome=this.getClass().getName();
		System.out.println("Tipo Veicolo: "+ nome.split("\\.")[nome.split("\\.").length-1]);
		System.out.println("Marca: "+this.getMarca());
		System.out.println("Modello: "+this.getModello());
		System.out.println("Targa: "+this.getTarga());
		System.out.println("Cilindrata: "+this.getCilindrata());
		System.out.println("Costo: "+this.getCosto());
	}

	@Override
	public String toString() {
		return "Veicolo [marca=" + marca + ", modello=" + modello + ", targa=" + targa + ", cilindrata=" + cilindrata
				+ ", costo=" + costo + "]";
	}
	
}
