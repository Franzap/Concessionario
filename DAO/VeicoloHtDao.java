package Concessionario.DAO;

import java.util.ArrayList;
import java.util.Hashtable;
import Concessionario.entita.Veicolo;

public class VeicoloHtDao implements  Dao<Veicolo>{
   
	private static Hashtable<Long,Veicolo> db= new Hashtable<>();
	private static Long ID=1L;


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
	public Veicolo get(long l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long l) {
		// TODO Auto-generated method stub
		
	}

	public static Long getID() {
		return ID;
	}

	public static Hashtable<Long,Veicolo> getDb() {
		return db;
	}

	public static void setDb(Hashtable<Long,Veicolo> db) {
		VeicoloHtDao.db = db;
	}

	
}