package it.solvingteam.gestioneordini.service.categoria;

import java.util.List;

import it.solvingteam.gestioneordini.dao.categoria.CategoriaDAO;
import it.solvingteam.gestioneordini.model.categoria.Categoria;



public interface CategoriaService {
	public List<Categoria> listAll() throws Exception;

	public Categoria get(Long id) throws Exception;

	public void aggiorna(Categoria categoriaInstance) throws Exception;

	public void inserisciNuovo(Categoria categoriaInstance) throws Exception;

	public void rimuovi(Categoria categoriaInstance) throws Exception;

	// per injection
	public void setCategoriaDAO(CategoriaDAO categoriaDAO);
}
