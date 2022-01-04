package Concessionario.DAO.implementazioniDao;

import java.util.ArrayList;


import java.util.Hashtable;

import Concessionario.DAO.interfacceDao.DaoCrudInterfaces;
import Concessionario.eccezioni.EccezioneEsistente;
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
	public void save(Veicolo v) throws EccezioneEsistente {
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
				throw new EccezioneEsistente(v);
			}
		}
		v.setID(idx);
		VeicoloDao.table.put(++idx,v);
		System.out.println("Aggiunta avvenuta!");
	}
	@Override
	public void update(Veicolo v) {
		if (v==null) { 
			System.out.println("Stai cercando di aggiungere il nulla");
			return;
		} 
		if (VeicoloDao.table.contains(v)){
			System.out.println("Stai cercando di aggiungere un veicolo già presente");
			return;
		}
		VeicoloDao.table.put(v.getID(),v);
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
