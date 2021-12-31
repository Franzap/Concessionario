package Concessionario.DAO.implementazioniDao;

import java.util.ArrayList;
import java.util.Hashtable;

import Concessionario.DAO.interfacceDao.Dao;
import Concessionario.entita.Veicolo;
@SuppressWarnings("unused")
public class VeicoloHtDao implements  Dao<Veicolo>{
   
	private static Hashtable<Long,Veicolo> db= new Hashtable<>();
	private static Long ID=1L;
	
	@Override
	public Veicolo get(long l) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Veicolo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void save(Veicolo t) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(Veicolo t) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(long l) {
		// TODO Auto-generated method stub
		
	}

	
}
