package Concessionario.DAO;

import java.util.ArrayList;

public interface Dao <T>{
	
	public T get(int id);
	public ArrayList<T> findAll();
	public void save(T t);
	public void update(T t);
	public void delete(int id);

}
