package Concessionario.app;

import java.util.List;
import java.util.Scanner;

import Concessionario.DAO.Dao;
import Concessionario.DAO.VeicoloHtDao;
import Concessionario.entita.Veicolo;

public class InterfacciaDao {
    Scanner scanner;
    Dao<Veicolo> dao;

    public InterfacciaDao() {
        this.scanner=new Scanner(System.in);
        this.dao= new VeicoloHtDao();
    }

    void mainMenu() {
        System.out.println("1. lista veicoli");
        System.out.println("2. aggiungi veicolo");
        System.out.println("3. modifica veicolo");
        System.out.println("4. cancella veicolo");
        System.out.println("5. esci");
        int choice = this.scanner.nextInt();
        this.scanner.nextLine();
       
        switch (choice) {
            case 1:
                lista();
                break;
            case 2:
                addVeicolo();
                break;
            case 3:
                updateVeicolo();
                break;
            case 4:
                deleteVeicolo();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("opzione: "+choice+" non valida");
                this.mainMenu();
                break;
        }
    }

    private void deleteVeicolo() {
        System.out.println("inserisci id del veicolo da eliminare;");
        this.dao.delete(scanner.nextLong());
        this.mainMenu();
    }

    private void updateVeicolo() {

    }

    private void addVeicolo() {
       
    	/**
    	
    	Veicolo v = new Veicolo();
        System.out.println("inserisci la marca:");
        scanner.nextLine();
        v.setMarca(scanner.nextLine());
        System.out.println("inserisci la cilindrata:");
        v.setCilindrata(scanner.nextInt());
        this.dao.save(v);
        this.mainMenu();
    	
    	*/
    }

    private void lista() {
        List<Veicolo> l = this.dao.findAll();
        for (Veicolo v: l) {
            System.out.println("id:"+Veicolo.getID()+" dettagli:"+v.toString());
        }
        this.mainMenu();
    }
}
