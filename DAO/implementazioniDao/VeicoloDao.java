package Concessionario.DAO.implementazioniDao;

import java.util.ArrayList;
import java.util.Hashtable;

import Concessionario.DAO.interfacceDao.DaoCrudInterfaces;
import Concessionario.eccezioni.EccezioneVeicoloEsistente;
import Concessionario.entita.MacchinaAgricola;
import Concessionario.entita.Veicolo;

public class VeicoloDao implements DaoCrudInterfaces<Veicolo>{
	private static Hashtable <Long,Veicolo> table= new Hashtable<Long,Veicolo>();
	private static long idx=0;
	
	@Override
	public Veicolo get(long id) {
		if(!VeicoloDao.table.containsKey(id)) {
			System.out.println("Il db non contiene veicoli con questo id!!");
			return null;
		}
		return VeicoloDao.table.get(id);
	}
	@Override
	public void findAll() {
		
		for(Long id : VeicoloDao.table.keySet()) {
			System.out.print("ID: " + id + " ");
			table.get(id).stampaVeicoloSemplificato();
			System.out.println();
		}
	}
	@Override
	public void save(Veicolo v) throws EccezioneVeicoloEsistente {
		if (v==null) { 
			System.out.println("Stai cercando di aggiungere il nulla");
			return;
		} 
		if (VeicoloDao.table.contains(v)){
			System.out.println("Stai cercando di aggiungere un veicolo già presente");
			return;
		}
		for(long id : table.keySet()) {
			if(table.get(id).equals(v)) {
				throw new EccezioneVeicoloEsistente(v);
			}
		}
		VeicoloDao.table.put(++idx,v);
		System.out.println("Aggiunta avvenuta!");
	}
	@Override
	public void update(long id, String caratteristica, String stringa, double valore) {
		switch (caratteristica.toLowerCase()){
		case "marca": {
			table.get(id).setMarca(stringa);
			break;
		}
		case "modello": {
			table.get(id).setModello(stringa);
			break;
		}
		case "targa": {
			table.get(id).setTarga(stringa);
			break;
		}
		case "costo": {
			table.get(id).setCosto(valore);
			break;
		}
		case "cilindrata": {
			table.get(id).setCilindrata((int)valore);
			break;
		}
		case "tonnellate": {
			((MacchinaAgricola)table.get(id)).setTonnellate((int)valore);
			break;
		}
		case "proprietario":{
				
			break;
		}
		default:
			System.out.println("hai sbagliato a inserire la caratteristica");
			break;
		}
		
		System.out.println("Modifica avvenuta!");
	}
	@Override
	public void delete(long id) {
		if(!VeicoloDao.table.containsKey(id)) {
			System.out.println("Il veicolo con id che cerchi non esiste!");
			return;
		}
		System.out.println("Eliminazione avvenuta!");
		VeicoloDao.table.remove(id);
	}

	
}
