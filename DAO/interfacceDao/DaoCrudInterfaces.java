package Concessionario.DAO.interfacceDao;

import java.util.ArrayList;

import Concessionario.eccezioni.EccezioneVeicoloEsistente;


public interface DaoCrudInterfaces <T>{
	
	public T get(long id);
	public void findAll();
	public void save(T t) throws EccezioneVeicoloEsistente;
	public void update(long id, String caratteristica, String stringa, double valore);
	public void delete(long id);

}
