package Concessionario.interfacce;

import java.util.ArrayList;

import Concessionario.eccezioni.EccezioneVeicoloEsistente;
import Concessionario.entita.MacchinaAgricola;
import Concessionario.entita.Persona;
import Concessionario.entita.Veicolo;

public interface ConcessionarioI {
	
	public double valore(); 
	public Veicolo menoPotente();
	public Persona piuAnziana(); 
	public double mediaCilindrata(); 
	public double mediaCapacitaTraino(); 
	public MacchinaAgricola[] piuPotenti(int c);
	public String marcaPiuFrequente(); 
	public ArrayList<Veicolo> autoPerFascia(int etaMin, int etaMax); 
	public String marcaPreferita(int etaMin, int etaMax);
	public void stampaVeicoli();
	public void stampaDettaglio(int numeroVeicolo);
	public void stampaVeicoliNumerati();
	public void modificaVeicolo(int numeroVeicolo, Veicolo v); 	
	public void modificaVeicolo(int numeroVeicolo, String caratteristica, String stringa, double valore);
	public void aggiungiVeicolo(Veicolo v) throws EccezioneVeicoloEsistente;
	public void eliminaVeicolo(int numeroVeicolo1);
	public String classeVeicolo(int numeroVeicolo);
}
