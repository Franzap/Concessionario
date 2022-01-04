package Concessionario.DAO.interfacceDao;

import java.util.ArrayList;

import Concessionario.eccezioni.EccezioneEsistente;

public interface DaoCrudInterfaces <T>{
	
	public T get(long id);
	public void findAll();
	public void save(T t) throws EccezioneEsistente;
	public void update(long id, String caratteristica, String stringa, double valore);
	public void delete(long id);

}
