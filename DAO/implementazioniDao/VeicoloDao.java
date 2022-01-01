package Concessionario.DAO.implementazioniDao;

import java.util.ArrayList;
import java.util.Hashtable;

import Concessionario.DAO.interfacceDao.DaoCrudInterfaces;
import Concessionario.entita.Veicolo;
@SuppressWarnings("unused")
public class VeicoloDao implements  DaoCrudInterfaces<Veicolo>{
	@Override
	public Veicolo get(long l) {
		return null;
	}
	@Override
	public ArrayList<Veicolo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void save(Veicolo v) {
		if (v==null) 
			System.out.println("Stai cercando di aggiungere il nulla");
		else {
			System.out.println("Aggiunta avvenuta!");
		}
	}
	@Override
	public void update(Veicolo v) {
		if (v==null) 
			System.out.println("La modifica non può avvenire senza modifiche!!");
		else {
			System.out.println("Modifica avvenuta!");
		}
	}
	@Override
	public void delete(long l) {
		// TODO Auto-generated method stub
		
	}

	
}
