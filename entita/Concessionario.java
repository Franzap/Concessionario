package Concessionario.entita;

import java.util.ArrayList;
import Concessionario.eccezioni.EccezioneVeicoloEsistente;
import Concessionario.interfacce.ConcessionarioI;

public class Concessionario implements ConcessionarioI {
	private ArrayList<Veicolo> veicoli;
	
	public Concessionario(ArrayList<Veicolo> veicoli) {
		this.veicoli=veicoli;
	}

	@Override
	public double valore() {
		double totale=0;
		for (Veicolo v : this.veicoli) {
			totale+=v.getCosto();
		}
		return totale;
	}

	@Override
	public Veicolo menoPotente() {
		int min=this.veicoli.get(0).getCilindrata();
		Veicolo veicolo= this.veicoli.get(0);
		
		for(Veicolo v : this.veicoli) {
			min= (min>v.getCilindrata()) ? v.getCilindrata() : min;
			veicolo= v;
		}
		return veicolo;
	}

	
	@Override
	public Persona piuAnziana() {
		int eta_corrente=0;
		Persona anziano= new Persona();
		for(Veicolo v: this.veicoli) {
			if( v instanceof Automobile ) {
				Automobile automobile_corrente=((Automobile)v);
				if (eta_corrente<automobile_corrente.getProprietario().getEta()) {
					eta_corrente=automobile_corrente.getProprietario().getEta();
					anziano=automobile_corrente.getProprietario();
				}
				
			}
		}
		return anziano;
	}

	@Override
	public double mediaCilindrata() {
		double media=0;
		for(Veicolo v : this.veicoli) {
			media+=v.getCilindrata();
		}
		media= media/(this.veicoli.size());
		return media;
	}

	@Override
	public double mediaCapacitaTraino() {
		double media=0;
		int totale_macchine_agricole=0;
		for(Veicolo v: this.veicoli) {
			if((v) instanceof MacchinaAgricola) {
				media+=((MacchinaAgricola)v).getTonnellate();
				totale_macchine_agricole++;
			}
		}
		media= media/totale_macchine_agricole;
		return media;
	
	}

	@Override
	public MacchinaAgricola[] piuPotenti(int c) {
		int count=0;
		for(Veicolo v : this.veicoli) {
			if(v instanceof MacchinaAgricola) {
				count++;
			}
		}
		MacchinaAgricola [] arrayMacchine=new MacchinaAgricola[count];
		count=0;
		for(Veicolo v : this.veicoli) {
			if(v instanceof MacchinaAgricola) {
				if(v.getCilindrata()>c) {
					arrayMacchine[count]=(MacchinaAgricola)v;
					count++;
				}
			}
		}
		
		return arrayMacchine;
	}


	@Override
	public String marcaPiuFrequente() {
		boolean[] flags=new boolean[this.veicoli.size()];
		String marca=this.veicoli.get(0).getMarca();
		int count=0,max=0, i=0;
		for(Veicolo v : this.veicoli) {
			i=0;
			count=0;
			for (Veicolo v2 : this.veicoli) {
				if(v.getMarca().equals(v2.getMarca())&&!flags[i]) {
					count++;
					flags[i]=true;
				}
				i++;
			}
			if (count > max) {
				marca = v.getMarca();
				max = count;
			}
			
		}
			
		return marca;
	}
	

	@Override
	public ArrayList<Veicolo> autoPerFascia(int etaMin, int etaMax) {	
		ArrayList<Veicolo> auto=new ArrayList<Veicolo>();
		for (Veicolo v : this.veicoli) {
			if(v instanceof Automobile) {
				if (((Automobile) v).getProprietario().getEta()>=etaMin&&((Automobile) v).getProprietario().getEta()<=etaMax) {
					auto.add(v);
				}
			}
		}
		
		return auto;
	}

	@Override
	public String marcaPreferita(int etaMin, int etaMax) {
		ArrayList<Veicolo> auto = autoPerFascia(etaMin, etaMax) ;
		
		Concessionario c= new Concessionario(auto);
		
		return c.marcaPiuFrequente();
	}
	@Override
	public void stampaVeicoli() {
		for(Veicolo v : this.veicoli) {
			v.stampaVeicoloSemplificato();
			System.out.println();
		}
	}
	@Override
	public void stampaDettaglio(int numeroVeicolo) {
		this.veicoli.get(numeroVeicolo-1).stampaDettagliVeicolo();
	}
	@Override
	public void stampaVeicoliNumerati() {
		int count=0;
		for(Veicolo v : this.veicoli) {
			System.out.println("Veicolo n. "+ ++count);
			v.stampaVeicoloSemplificato();
			System.out.println();
		}
		
	}
	@Override
	public void eliminaVeicolo(int numeroVeicolo1) {
		this.veicoli.remove(numeroVeicolo1-1);
		
	}
	@Override
	public void aggiungiVeicolo(Veicolo v) throws EccezioneVeicoloEsistente {
		for(Veicolo v1 : this.veicoli) {
			if(v1.equals(v)) {
				throw new EccezioneVeicoloEsistente(v);
			}
		}
		this.veicoli.add(v);
	}

	@Override
	public String classeVeicolo(int numeroVeicolo) {
		if(this.veicoli.get(numeroVeicolo-1) instanceof Automobile) {
			return "Automobile";
		} else {
			return "MacchinaAgricola";
		}
	}
	@Override
	public void modificaVeicolo(int numeroVeicolo, Veicolo v) {
		if(v instanceof Automobile) {
			((Automobile) v).setProprietario(((Automobile) this.veicoli.get(numeroVeicolo-1)).getProprietario());
		}
			this.veicoli.remove(numeroVeicolo-1);
			this.veicoli.add(v);
		
	}
	@Override
	public void modificaVeicolo(int numeroVeicolo, String caratteristica, String stringa, double valore) {
		switch (caratteristica.toLowerCase()){
		case "marca": {
			this.veicoli.get(numeroVeicolo-1).setMarca(stringa);
			break;
		}
		case "modello": {
			this.veicoli.get(numeroVeicolo-1).setModello(stringa);
			break;
		}
		case "targa": {
			this.veicoli.get(numeroVeicolo-1).setTarga(stringa);
			break;
		}
		case "costo": {
			this.veicoli.get(numeroVeicolo-1).setCosto(valore);
			break;
		}
		case "cilindrata": {
			this.veicoli.get(numeroVeicolo-1).setCilindrata((int)valore);
			break;
		}
		case "tonnellate": {
			((MacchinaAgricola)this.veicoli.get(numeroVeicolo-1)).setTonnellate((int)valore);
			break;
		}
		case "proprietario":{
				
			break;
		}
		default:
			System.out.println("hai sbagliato a inserire la caratteristica");
			break;
		}
		
	}	

}
