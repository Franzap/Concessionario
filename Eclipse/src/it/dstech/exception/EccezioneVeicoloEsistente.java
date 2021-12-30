package concessionario_GRUPPO3;

@SuppressWarnings("serial")
public class EccezioneVeicoloEsistente extends Exception{
	public EccezioneVeicoloEsistente( Veicolo v) {
		super(v.toString()+" Già Presente");
	}
	
}
