package Concessionario.app;

import java.util.ArrayList;


import java.util.InputMismatchException;
import java.util.Scanner;


import Concessionario.entita.Automobile;
import Concessionario.entita.Concessionario;
import Concessionario.entita.MacchinaAgricola;
import Concessionario.entita.Persona;
import Concessionario.entita.Veicolo;
import Concessionario.DAO.interfacceDao.*;
import Concessionario.eccezioni.EccezioneEsistente;

@SuppressWarnings("unused")
public class Esercitazione2 <T> {
	private Scanner scan;
	private DaoCrudInterfaces<T> daoVeicolo;
	private DaoCrudInterfaces<T> daoPersona;
	
	
	public Esercitazione2(DaoCrudInterfaces<T> daoVeicolo, DaoCrudInterfaces<T> daoPersona) {
		this.scan = new Scanner(System.in);
		this.daoVeicolo = daoVeicolo;
		this.daoPersona = daoPersona;
	}

	public void menu(){
			Scanner scan= new Scanner(System.in);
			System.out.println("Questa è la lista delle azioni che puoi richiedere:");
			System.out.println("1) Lista Veicoli");
			System.out.println("2) Dettagli Veicolo");
			System.out.println("3) Cancella Veicolo");
			System.out.println("4) Modifica Veicolo");
			System.out.println("5) Aggiungi Veicolo");
			System.out.println("6) Uscita");
			System.out.print("inserisci il numero corrispondente all'azione da compiere: ");	
			
			try {
				int choice=scan.nextInt();
				scan.nextLine();
				switch(choice) {
				case 1:
					comandoListaVeicoli();
					break;
			
				case 2:
					this.daoVeicolo.findAll();
					comandoDettagliVeicolo(scan);
					break;
			
				case 3:
					comandoCancellaVeicolo(scan);
					break;
			
				case 4:
					comandoModificaVeicolo(scan);
					break;
				
				case 5:
					comandoAggiungiVeicolo(scan);
					break;
				
				case 6:
					scan.close();
					System.out.println("ADDIO, SPERIAMO DI NON VEDERTI PIU'");
					System.exit(0);
					break;
				
				default:
					System.out.println("Numero non valido!");

				}
				
			} catch (InputMismatchException e) {
				
				System.out.println();
				System.out.println(("L'INPUT CHE HAI IMMESSO NON è VALIDO").toUpperCase());
				System.out.println("RIPROVA");
				System.out.println();		
			
			}
			
			menu();	
	}

	// CAMBIARE I COMANDI IN MODO CHE CHIAMINO I METODI DEL DAO AL POSTO DEI METODI DELLE CLASSI

	private void comandoListaVeicoli() {
		System.out.println();
		System.out.println("Lista veicoli del concessionario:");	
		System.out.println();
		//System.out.println(this.dao.findAll());
		int count=0;
		this.daoVeicolo.findAll();
	}
	
	private void comandoDettagliVeicolo(Scanner scan) {
			int Indice_Veicolo;
			try {
				comandoListaVeicoli();
				System.out.print("\n\nInserisci l' indice del veicolo da cercare   ");
				Indice_Veicolo=scan.nextInt();
				scan.nextLine();
				((Veicolo)this.daoVeicolo.get(Indice_Veicolo)).stampaDettagliVeicolo();
				
			}catch(InputMismatchException |IndexOutOfBoundsException e) {
				System.out.println("\n Veicolo non trovato! \n\n");
			}
				Tasto_Continua(scan);	
	}
	
	private void comandoCancellaVeicolo(Scanner scan) {
		
		comandoListaVeicoli();
		System.out.println();
		System.out.println("Inserisci il numero del veicolo che vuoi eliminare:");
		System.out.println();
		int numeroVeicolo=1;
		
		try {
			numeroVeicolo=scan.nextInt();
			scan.nextLine();
			System.out.println("HAI SCELTO IL VEICOLO:");
			this.daoVeicolo.get(numeroVeicolo);
		
		} catch(InputMismatchException e ) {
			
			System.out.println();
			System.out.println(("IL VALORE CHE HAI IMMESSO NON è VALIDO").toUpperCase());
			System.out.println("RIPROVA:");
			System.out.println();
			scan.nextLine();
			comandoCancellaVeicolo(scan);
		
		}catch(IndexOutOfBoundsException e) {
			System.out.println();
			System.out.println(("IL NUMERO DI VEICOLO NON è GIUSTO!!").toUpperCase());
			System.out.println("RIPROVA:");
			System.out.println();
			comandoCancellaVeicolo(scan);
		}
		
		System.out.println( );
		
		if(Esercitazione2.ripetereComando(scan,"Sicuro di voler eliminare il veicolo "+ numeroVeicolo +"? Scrivi 1 per \"SI\" E 2 per \" no\" " )) {
				
			System.out.println("Ho eliminato correttamente il veicolo!!");
			this.daoVeicolo.delete(numeroVeicolo);				
		}
		scan.nextLine();
	}
	
	private void comandoModificaVeicolo(Scanner scan) {
		
		comandoListaVeicoli();
		System.out.println();
		System.out.print("Inserisci il numero del veicolo che vuoi modificare: ");
		int numeroVeicolo=0;
		try {
			
			numeroVeicolo=scan.nextInt();	
			scan.nextLine();
			((Veicolo)this.daoVeicolo.get(numeroVeicolo)).stampaDettagliVeicolo();
			
		} catch(InputMismatchException e ) {
		
			System.out.println();
			System.out.println(("IL VALORE CHE HAI IMMESSO NON è VALIDO").toUpperCase());
			System.out.println("RIPROVA:");
			System.out.println();
			scan.nextLine();
			comandoModificaVeicolo(scan);
		
		}catch(IndexOutOfBoundsException e) {
			System.out.println();
			System.out.println(("IL NUMERO DI VEICOLO NON è GIUSTO!!").toUpperCase());
			System.out.println("RIPROVA:");
			System.out.println();
			comandoModificaVeicolo(scan);
		}
		
			System.out.print("Inserire il nome della caratteristica da modificare:");
			String caratteristica=scan.next().toLowerCase();
			scan.nextLine();
			System.out.print("Inserire il nuovo valore: ");
			
			switch (caratteristica.toLowerCase()){
			case "marca": {
				String valore=scan.next();
				valore+=scan.nextLine();
				((Veicolo)this.daoVeicolo.get(numeroVeicolo)).setMarca(valore);
				break;
			}
			case "modello": {
				String valore=scan.next();
				valore+=scan.nextLine();
				((Veicolo)this.daoVeicolo.get(numeroVeicolo)).setModello(valore);
				break;
			}
			case "targa": {
				String valore=scan.next();
				valore+=scan.nextLine();
				((Veicolo)this.daoVeicolo.get(numeroVeicolo)).setTarga(valore);
				break;
			}
			case "costo": {
				int valore=scan.nextInt();
				scan.nextLine();
				((Veicolo)this.daoVeicolo.get(numeroVeicolo)).setCosto(valore);
				break;
			}
			case "cilindrata": {
				int valore=scan.nextInt();
				scan.nextLine();
				((Veicolo)this.daoVeicolo.get(numeroVeicolo)).setCilindrata(valore);
				break;
			}
			case "tonnellate": {
				int valore=scan.nextInt();
				scan.nextLine();
				((MacchinaAgricola)this.daoVeicolo.get(numeroVeicolo)).setTonnellate(valore);
				break;
			}
			case "proprietario":{
					
				break;
			}
			default:
				System.out.println("hai sbagliato a inserire la caratteristica");
				break;
			}
			
			this.daoVeicolo.update(this.daoVeicolo.get(numeroVeicolo));
			
			
			if(Esercitazione2.ripetereComando(scan,"Vuoi ripetere l'operazione? 1: Ripetere 0: Uscire")) {
				comandoModificaVeicolo(scan);
			}
		
	}
	
	private void comandoAggiungiVeicolo(Scanner scan) {
		boolean scelta=false;
		int cilindrata=0;
		double costo=0;
		String marca="", modello="", targa="";
		try {
			scelta=Esercitazione2.ripetereComando(scan, "Inserisci 0 per aggiungere un Automobile o inserisci 1 per aggiungere una Macchina Agricola");
			scan.nextLine();
			System.out.println("Inserisci la marca dil Veicolo");
			marca = scan.next();
			marca+=scan.nextLine();
			System.out.println("Inserisci il modello dil Veicolo");
			modello = scan.next();
			modello+=scan.nextLine();
			System.out.println("Inserisci la targa dil Veicolo");
			targa = scan.next();
			scan.nextLine();
			System.out.println("Inserisci la cilindrata dil Veicolo");
			cilindrata = scan.nextInt();
			scan.nextLine();
			System.out.println("Inserisci il costo dil Veicolo");
			costo = scan.nextDouble();
			scan.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("Hai sbagliato ad inserire il valore");
			scan.nextLine();
			comandoAggiungiVeicolo(scan);
		}	
			
			try {
				
				 if(!scelta) {
					 System.out.println("Inserisci il cliente");
					 System.out.println("Inserisci il nome dil cliente");
					 String nome = scan.next();
					 scan.nextLine();
					 System.out.println("Inserisci il cognome dil cliente");
					 String cognome = scan.next();
					 scan.nextLine();
					 System.out.println("Inserisci l' eta dil cliente");
					 int eta = scan.nextInt();
					 scan.nextLine();
					 Persona p = new Persona(nome, cognome, eta);
					 this.daoPersona.save((T)p);
					 Automobile a = new Automobile(marca, modello, targa, cilindrata, costo, p);
					 this.daoVeicolo.save((T)a);
				 
			 	 }else if(scelta) {
			 		 System.out.println("Inserisci la Capacita di Traino");
			 		 int capacitaTraino = scan.nextInt();
			 		 MacchinaAgricola m = new MacchinaAgricola(marca, modello, targa, cilindrata, costo, capacitaTraino);
					 this.daoVeicolo.save((T)m);
			 }
				 
			} catch (EccezioneEsistente e) {
				System.out.println(e.getMessage());
				System.out.println("Aggiungi di nuovo il veicolo");
				comandoAggiungiVeicolo(scan);
			} 
			if(Esercitazione2.ripetereComando(scan,"Vuoi ripetere l'operazione? 1: Ripetere 0: Uscire")){
				
				comandoAggiungiVeicolo(scan);
			}
	}
	private static void Tasto_Continua(Scanner scan) {
		System.out.println("\nPremere un tasto per continuare...\n\n");
		scan.nextLine();
	}
	
	private static boolean ripetereComando(Scanner scan,String msg) {
		System.out.println(msg);
		boolean flag=false;
		try {
			int valore=scan.nextInt();
			
			if(valore==1) {
		 		flag=true;
			}else if(valore==0){
				flag= false;
			}else {
			//questa dovrebbe essere un'eccezione ma la gestiamo con un if
				System.out.println("Hai sbagliato input, RIPROVA!!");
				scan.nextLine();
				Esercitazione2.ripetereComando(scan,msg);
			}
		} catch (InputMismatchException e) {
			System.out.println("Hai sbagliato input, RIPROVA!!");
			scan.nextLine();
			Esercitazione2.ripetereComando(scan,msg);
		}

		return flag;
	}
}

