package Concessionario.it.dstech;

import java.util.ArrayList;

import  Concessionario.it.dstech.daoentities.MacchinaAgricola;
import  Concessionario.it.dstech.daoentities.Persona;
import  Concessionario.it.dstech.daoentities.Veicolo;
import  Concessionario.it.dstech.exception.EccezioneVeicoloEsistente;

public interface ConcessionarioInterface {
	
	public double valore(); // restituisce il valore totale di tutti i veicoli presenti 
	public Veicolo menoPotente();// restituisce il veicolo con la cilindrata più piccola
	public Persona piuAnziana(); // restituisce il proprietario più anziano tra i proprietari delle auto
	public double mediaCilindrata(); // restituisce la media della cilindrata di tutti i veicoli
	public double mediaCapacitaTraino(); // restituisce la media della capacità di traino delle macchine agricole
	public MacchinaAgricola[] piuPotenti(int c);// restituisce l'array contenente tutte le macchine agricole con capacità di traino superiore a c. 
	public String marcaPiuFrequente(); // restituisce la marca piu frequente tra le marche dei vari veicoli
	public ArrayList<Veicolo> autoPerFascia(int etaMin, int etaMax); // restituisce l'array di tutte le auto possedute da proprietari con età compresa tra etaMin ed etaMax;
	public String marcaPreferita(int etaMin, int etaMax); //restituisce la marca piu acquistata dai proprietari di età compresa tra etaMin ed etaMax;
	public void stampaVeicoli();
	public void stampaDettaglio(int numeroVeicolo);
	public void stampaVeicoliNumerati();
	public void modificaVeicolo(int numeroVeicolo, Veicolo v); 	
	public void modificaVeicolo(int numeroVeicolo, String caratteristica, String stringa, double valore);
	public void aggiungiVeicolo(Veicolo v) throws EccezioneVeicoloEsistente;
	public void eliminaVeicolo(int numeroVeicolo1);
	public String classeVeicolo(int numeroVeicolo);
}
