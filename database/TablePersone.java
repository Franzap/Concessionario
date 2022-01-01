package Concessionario.database;

import java.util.Hashtable;

import Concessionario.entita.Persona;

public class TablePersone implements TabellaGenericaDB<Persona> {
	private Hashtable <Long,Persona> table;
	private static long idx;

	@Override
	public Persona read(long id) {
		if(!this.table.containsKey(id)) {
			System.out.println("Il db non contiene persone con questo id!!");
			return null;
		}
		return this.table.get(id);
	}

	@Override
	public void update(long id, Persona p) {
		if(!this.table.containsKey(id)) {
			System.out.println("Il db non contiene persone con questo id!!");
			return;
		} 
		this.table.put(id, p);
	}

	@Override
	public void delete(long id) {
		if(!this.table.containsKey(id)) {
			System.out.println("Il db non contiene persone con questo id!!");
			return;
		}
		this.table.remove(id);
	}


	@Override
	public void create(Persona p) {
		if(this.table.contains(p)) {
			System.out.println("Stai aggiungendo una persona che già esiste nel db");
			return;
		}
		this.table.put(++idx,p);
	}
	
}
