package it.solvingteam.gestioneordini.service.articolo;

import java.util.Set;

import it.solvingteam.gestioneordini.dao.articolo.ArticoloDAO;
import it.solvingteam.gestioneordini.model.articolo.Articolo;
import it.solvingteam.gestioneordini.model.categoria.Categoria;


public interface ArticoloService {
	public Set<Articolo> setAll() throws Exception;

	public Articolo get(Long id) throws Exception;

	public void aggiorna(Articolo articoloInstance) throws Exception;

	public void inserisciNuovo(Articolo articoloInstance) throws Exception;

	public void rimuovi(Articolo articoloInstance) throws Exception;
    
	public void aggiungiCategoria(Articolo articoloEsistente,  Categoria categoriaInstance) throws Exception;
	
	public Articolo CercaPerDescrizione(String descrizione) throws Exception;
	
	public void rimuoviCategoria(Articolo articoloEsistente,  Categoria categoriaInstance) throws Exception;
	
	// per injection
	public void setArticoloDAO(ArticoloDAO articoloDAO);

	void sumPrezziByCategoria(Categoria categoriaInstance) throws Exception;
}
