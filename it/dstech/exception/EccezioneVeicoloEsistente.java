package Concessionario.it.dstech.exception;

import Concessionario.it.dstech.daoentities.Veicolo;

@SuppressWarnings("serial")
public class EccezioneVeicoloEsistente extends Exception{
	public EccezioneVeicoloEsistente( Veicolo v) {
		super(v.toString()+" Già Presente");
	}
	
}
