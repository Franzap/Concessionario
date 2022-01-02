package  Concessionario.app;

import java.util.ArrayList;

import Concessionario.DAO.implementazioniDao.VeicoloDao;
import Concessionario.DAO.interfacceDao.DaoCrudInterfaces;
import Concessionario.entita.Automobile;
import Concessionario.entita.Concessionario;
import Concessionario.entita.MacchinaAgricola;
import Concessionario.entita.Persona;
import Concessionario.entita.Veicolo;



public class Main {
	
	
	public static void main(String[] args)  {
		/*Persona p1 = new Persona("Mario", "Rossi", 35);
		Automobile a1 = new Automobile("Audi", "A3", "sdhjhgsd", 2000,25000, p1);
		Persona p2 = new Persona("Maria", "Bianchi", 45);
		Automobile a2 = new Automobile("BMW", "M3", "3456dfgsd", 4000,50000, p2);
		MacchinaAgricola m1 = new MacchinaAgricola("Iveco", "XT3", "73stetd", 8000,105000, 30);
		MacchinaAgricola m2 = new MacchinaAgricola("NewHollander", "HF56", "7jsytjsd", 10000,175000, 50);
		MacchinaAgricola m3 = new MacchinaAgricola("Landini", "h1", "64hgdlj", 7000, 50000, 15);
		Persona p3 = new Persona("Luigi", "Neri", 28);
		Automobile a3 = new Automobile("Fiat", "Punto", "245hjd", 1300,10000, p3);
		
		ArrayList<Veicolo> veicoli =new ArrayList<Veicolo>();
		veicoli.add(a1);
		veicoli.add(a2);
		veicoli.add(a3);
		veicoli.add(m1);
		veicoli.add(m2);
		veicoli.add(m3);
		Concessionario c = new Concessionario(veicoli);
		
		Esercitazione2.menu(c);
	*/	
		DaoCrudInterfaces<Veicolo> dao= new VeicoloDao(); 
		Esercitazione2 es= new Esercitazione2(dao);
		es.menu();
	}

}
