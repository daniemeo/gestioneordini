package it.solvingteam.gestioneordini.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import it.solvingteam.gestioneordini.model.articolo.Articolo;
import it.solvingteam.gestioneordini.model.ordine.Ordine;

public interface IBaseDAO<T> {

	public Set<T> list() throws Exception;

	public T get(Long id) throws Exception;

	public void update(T o) throws Exception;

	public void insert(T o) throws Exception;

	public void delete(T o) throws Exception;

	// questo mi serve per l'injection
	public void setEntityManager(EntityManager entityManager);

	

}
