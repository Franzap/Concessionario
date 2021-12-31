package Concessionario.eccezioni;

import Concessionario.entita.Veicolo;

@SuppressWarnings("serial")
public class EccezioneVeicoloEsistente extends Exception{
	public EccezioneVeicoloEsistente( Veicolo v) {
		super(v.toString()+" Già Presente");
	}
	
}
