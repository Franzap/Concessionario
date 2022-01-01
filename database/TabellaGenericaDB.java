package Concessionario.database;

public interface TabellaGenericaDB <T>{
	
	public void create(T t);
	public T read(long id);
	public void update(long id, T o);
	public void delete(long id);	
	
}
