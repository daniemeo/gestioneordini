package it.solvingteam.gestioneordini.service.categoria;

import java.util.Set;

import it.solvingteam.gestioneordini.dao.categoria.CategoriaDAO;
import it.solvingteam.gestioneordini.model.categoria.Categoria;
import it.solvingteam.gestioneordini.model.ordine.Ordine;



public interface CategoriaService {
	public Set<Categoria> setAll() throws Exception;

	public Categoria get(Long id) throws Exception;

	public void aggiorna(Categoria categoriaInstance) throws Exception;

	public void inserisciNuovo(Categoria categoriaInstance) throws Exception;

	public void rimuovi(Categoria categoriaInstance) throws Exception;
	
	public Categoria CercaPerDescrizione(String descrizione) throws Exception;

	// per injection
	public void setCategoriaDAO(CategoriaDAO categoriaDAO);

	void searchCategoryByOrder(Ordine ordineInstance) throws Exception;
}
