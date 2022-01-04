package Concessionario.eccezioni;


public class EccezioneEsistente extends Exception{
	public EccezioneEsistente( Object t) {
		super(t.toString()+" Già Presente");
	}
	
}
