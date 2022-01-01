package Concessionario.DAO.interfacceDao;

import java.util.ArrayList;

public interface DaoCrudInterfaces <T>{
	
	public T get(long l);
	public ArrayList<T> findAll();
	public void save(T t);
	public void update(T t);
	public void delete(long l);

}
