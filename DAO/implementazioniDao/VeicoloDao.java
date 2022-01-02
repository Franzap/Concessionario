package Concessionario.DAO.implementazioniDao;

import java.util.ArrayList;
import java.util.Hashtable;

import Concessionario.DAO.interfacceDao.DaoCrudInterfaces;
import Concessionario.entita.Veicolo;

public class VeicoloDao implements DaoCrudInterfaces<Veicolo>{
	private static Hashtable <Long,Veicolo> table= new Hashtable<Long,Veicolo>();
	private static long idx=1l;
	
	@Override
	public Veicolo get(long id) {
		if(!VeicoloDao.table.containsKey(id)) {
			System.out.println("Il db non contiene veicoli con questo id!!");
			return null;
		}
		return VeicoloDao.table.get(id);
	}
	@Override
	public ArrayList<Veicolo> findAll() {
		ArrayList<Veicolo> veicoli= new ArrayList<Veicolo>();
		veicoli.addAll(VeicoloDao.table.values());
		/*for(Long l : VeicoloDao.table.keySet()) {
			veicoli.add(VeicoloDao.table.get(l));
		}*/
		return veicoli;
	}
	@Override
	public void save(Veicolo v) {
		if (v==null) { 
			System.out.println("Stai cercando di aggiungere il nulla");
			return;
		} 
		if (VeicoloDao.table.contains(v)){
			System.out.println("Stai cercando di aggiungere un veicolo già presente");
			return;
		}
		VeicoloDao.table.put(++idx,v);
		System.out.println("Aggiunta avvenuta!");
	}
	@Override
	public void update(long id, Veicolo v) {
		if (v==null) { 
			System.out.println("La modifica non può avvenire senza modifiche!!");
			return;
		}
		if (VeicoloDao.table.contains(v)){
			System.out.println("La modifica non può essere fatta");
			return;
		}
		System.out.println("Modifica avvenuta!");
		VeicoloDao.table.put(id, v);
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
