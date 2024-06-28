package models.dao;

import java.util.ArrayList;

public interface iRepositoryCrud <T> {
	
	public int create(T t);
	
	public T read(Object key);
	
	public boolean update(T t);
	
	public boolean delete(Object key);
	
	public ArrayList<T> readAll();

}
