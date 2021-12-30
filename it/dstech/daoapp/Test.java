package Concessionario.src.it.dstech.daoapp;

import java.util.InputMismatchException;
import java.util.Scanner;

import  Concessionario.src.it.dstech.daoentities.Automobile;
import  Concessionario.src.it.dstech.daoentities.Concessionario;
import  Concessionario.src.it.dstech.daoentities.MacchinaAgricola;
import  Concessionario.src.it.dstech.daoentities.Persona;
import  Concessionario.src.it.dstech.exception.EccezioneVeicoloEsistente;

public class Test {
	
	public static void menu(Concessionario c){
		
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
					comandoListaVeicoli(c);
					break;
			
				case 2:
					c.stampaVeicoliNumerati();
					comandoDettagliVeicolo(c,scan);
					break;
			
				case 3:
					comandoCancellaVeicolo(c,scan);
					break;
			
				case 4:
					comandoModificaVeicolo(c,scan);
					break;
				
				case 5:
					comandoAggiungiVeicolo(c,scan);
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
			
			Test.menu(c);	
	}

	

	private static void comandoListaVeicoli(Concessionario c) {
		System.out.println();
		System.out.println("Lista veicoli del concessionario:");	
		System.out.println();
		c.stampaVeicoli();
	
	}
	
	private static void comandoDettagliVeicolo(Concessionario c, Scanner scan) {	
			int Indice_Veicolo;
			try {
				System.out.print("\n\nInserisci l' indice del veicolo da cercare   ");
				Indice_Veicolo=scan.nextInt();
				scan.nextLine();
				c.stampaDettaglio(Indice_Veicolo);
				
			}catch(InputMismatchException |IndexOutOfBoundsException e) {
				System.out.println("\n Veicolo non trovato! \n\n");
			}
				Tasto_Continua(scan);	
	}
	
	private static void comandoCancellaVeicolo(Concessionario c, Scanner scan) {
		
		c.stampaVeicoliNumerati();
		System.out.println();
		System.out.println("Inserisci il numero del veicolo che vuoi eliminare:");
		System.out.println();
		int numeroVeicolo=1;
		
		try {
			numeroVeicolo=scan.nextInt();
			scan.nextLine();
			System.out.println("HAI SCELTO IL VEICOLO:");
			c.stampaDettaglio(numeroVeicolo);
		
		} catch(InputMismatchException e ) {
			
			System.out.println();
			System.out.println(("IL VALORE CHE HAI IMMESSO NON è VALIDO").toUpperCase());
			System.out.println("RIPROVA:");
			System.out.println();
			scan.nextLine();
			Test.comandoCancellaVeicolo(c, scan);
		
		}catch(IndexOutOfBoundsException e) {
			System.out.println();
			System.out.println(("IL NUMERO DI VEICOLO NON è GIUSTO!!").toUpperCase());
			System.out.println("RIPROVA:");
			System.out.println();
			Test.comandoCancellaVeicolo(c, scan);
		}
		
		System.out.println( );
		
		if(Test.ripetereComando(scan,"Sicuro di voler eliminare il veicolo "+ numeroVeicolo +"? Scrivi 1 per \"SI\" E 2 per \" no\" " )) {
				
			System.out.println("Ho eliminato correttamente il veicolo!!");
			c.eliminaVeicolo(numeroVeicolo);				
		}
		scan.nextLine();
	}
	
	private static void comandoModificaVeicolo(Concessionario c, Scanner scan) {
		
		c.stampaVeicoliNumerati();
		System.out.println();
		System.out.print("Inserisci il numero del veicolo che vuoi modificare: ");
		int numeroVeicolo=0;
		try {
			
			numeroVeicolo=scan.nextInt();	
			scan.nextLine();
			c.stampaDettaglio(numeroVeicolo);
			
		} catch(InputMismatchException e ) {
		
			System.out.println();
			System.out.println(("IL VALORE CHE HAI IMMESSO NON è VALIDO").toUpperCase());
			System.out.println("RIPROVA:");
			System.out.println();
			scan.nextLine();
			Test.comandoModificaVeicolo(c, scan);
		
		}catch(IndexOutOfBoundsException e) {
			System.out.println();
			System.out.println(("IL NUMERO DI VEICOLO NON è GIUSTO!!").toUpperCase());
			System.out.println("RIPROVA:");
			System.out.println();
			Test.comandoModificaVeicolo(c, scan);
		}
		
			System.out.print("Inserire il nome della caratteristica da modificare:");
			String caratteristica=scan.next().toLowerCase();
			scan.nextLine();
			System.out.print("Inserire il nuovo valore: ");
			
			int valoreIntero=0;
			
			String valore="";
			
			if(caratteristica.equals("cilindrata")||caratteristica.equals("costo")||caratteristica.equals("tonnellate")||caratteristica.equals("proprietario")) {
					valoreIntero=scan.nextInt();
					scan.nextLine();
			}else {
				valore=scan.next();
				valore+=scan.nextLine();
			}
			
			c.modificaVeicolo(numeroVeicolo,caratteristica, valore, valoreIntero);
			
			
			if(Test.ripetereComando(scan,"Vuoi ripetere l'operazione? 1: Ripetere 0: Uscire")) {
				Test.comandoModificaVeicolo(c, scan);
			}
	
		
		c.stampaDettaglio(numeroVeicolo);
		
	}
	private static void comandoAggiungiVeicolo(Concessionario c, Scanner scan) {
		boolean scelta=false;
		int cilindrata=0;
		double costo=0;
		String marca="", modello="", targa="";
		try {
			scelta=Test.ripetereComando(scan, "Inserisci 0 per aggiungere un Automobile o inserisci 1 per aggiungere una Macchina Agricola");
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
			Test.comandoAggiungiVeicolo(c,scan);
		}	
		
		
			try {
				
				 if(scelta) {
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
					 Automobile a = new Automobile(marca, modello, targa, cilindrata, costo, p);
					 c.aggiungiVeicolo(a);
				 
			 	 }else if(!scelta) {
			 		 System.out.println("Inserisci la Capacita di Traino");
			 		 int capacitaTraino = scan.nextInt();
			 		 MacchinaAgricola m = new MacchinaAgricola(marca, modello, targa, cilindrata, costo, capacitaTraino);
					 c.aggiungiVeicolo(m);
			 }
				 
			} catch (EccezioneVeicoloEsistente e) {
				System.out.println(e.getMessage());
				System.out.println("Aggiungi di nuovo il veicolo");
				Test.comandoAggiungiVeicolo(c, scan);
			} 
			if(Test.ripetereComando(scan,"Vuoi ripetere l'operazione? 1: Ripetere 0: Uscire")){
				
				Test.comandoAggiungiVeicolo(c, scan);
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
				Test.ripetereComando(scan,msg);
			}
		} catch (InputMismatchException e) {
			System.out.println("Hai sbagliato input, RIPROVA!!");
			scan.nextLine();
			Test.ripetereComando(scan,msg);
		}

		return flag;
	}
}

