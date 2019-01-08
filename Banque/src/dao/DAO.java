package dao;

import java.util.ArrayList;

public interface DAO<T> {
	public abstract T getById(int id);

	public abstract int create(T objet);
	//return generated key, return -1 en cas d'erreur
	
	public abstract void update(T objet);

	public abstract void delete(T objet);

	public abstract ArrayList<T> findAll();
}