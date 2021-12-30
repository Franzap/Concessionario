package Concessionario.src.it.dstech.daoentities;

public class MacchinaAgricola extends Veicolo{
	
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
		System.out.println("Tonnellate: "+ this.getTonnellate() + "t");
	}
}
