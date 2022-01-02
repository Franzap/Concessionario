package Concessionario.DAO.interfacceDao;

import java.util.ArrayList;


public interface DaoCrudInterfaces <T>{
	
	public T get(long id);
	public ArrayList<T> findAll();
	public void save(T t);
	public void update(long id, T t);
	public void delete(long id);

}
