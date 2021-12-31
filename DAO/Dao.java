package Concessionario.DAO;

import java.util.List;

public interface Dao <T>{
	
		public T get(int id);
	    public List<T> findAll();
	    public void save(T t);
	    public void update(T t);
	    public void delete(int id);

}
