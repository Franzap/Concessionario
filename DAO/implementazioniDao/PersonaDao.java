package Concessionario.DAO.implementazioniDao;

import Concessionario.entita.Persona;
import Concessionario.DAO.interfacceDao.DaoCrudInterfaces;
import Concessionario.eccezioni.EccezioneVeicoloEsistente;

import java.util.ArrayList;
import java.util.Hashtable;

public class PersonaDao implements DaoCrudInterfaces<Persona>{
	private static Hashtable<Long,Persona> table=new Hashtable<Long,Persona>();
	private static long idx=1l;
	
	
	@Override
	public Persona get(long id) {
		if(!PersonaDao.table.containsKey(id)) {
			System.out.println("Non esiste persona registrata con quell'id");
			return null;
		}
		return PersonaDao.table.get(id);
	}

	@Override
	public void findAll() {
		ArrayList<Persona> contatti= new ArrayList<Persona>();
		contatti.addAll(PersonaDao.table.values());
		/*for(Long id : PersonaDao.table.keySet()) {
			contatti.add(PersonaDao.table.get(id));
		}*/
	}

	@Override
	public void save(Persona p) throws EccezioneVeicoloEsistente {
		if (p==null) { 
			System.out.println("Stai cercando di aggiungere il nulla");
			return;
		} 
		if (PersonaDao.table.contains(p)){
			System.out.println("Stai cercando di aggiungere una persona già presente");
			return;
		}
		PersonaDao.table.put(++idx,p);
		System.out.println("Aggiunta avvenuta!");
	}

	@Override
	public void update(long id, String caratteristica, String stringa, double valore) {
		
		
		
	}

	@Override
	public void delete(long id) {
		if(!PersonaDao.table.containsKey(id)) {
			System.out.println("La persona con id che cerchi non esiste!");
			return;
		}
		System.out.println("Eliminazione avvenuta!");
		PersonaDao.table.remove(id);
	}

}
