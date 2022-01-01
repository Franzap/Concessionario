package Concessionario.database;

import java.util.Hashtable;

import Concessionario.entita.Veicolo;

public class TableVeicolo implements TabellaGenericaDB<Veicolo>{
	private Hashtable <Long,Veicolo> table;
	private static long idx;

	@Override
	public Veicolo read(long id) {
		if(!this.table.containsKey(id)) {
			System.out.println("Il db non contiene veicoli con questo id!!");
			return null;
		}
		return this.table.get(id);
	}

	@Override
	public void update(long id, Veicolo v) {
		if(!this.table.containsKey(id)) {
			System.out.println("Il db non contiene veicoli con questo id!!");
			return;
		} 
		this.table.put(id, v);
	}

	@Override
	public void delete(long id) {
		if(!this.table.containsKey(id)) {
			System.out.println("Il db non contiene veicoli con questo id!!");
			return;
		}
		this.table.remove(id);
	}


	@Override
	public void create(Veicolo v) {
		if(this.table.contains(v)) {
			System.out.println("Stai aggiungendo una veicoli che già esiste nel db");
			return;
		}
		this.table.put(++idx,v);
	}
}
