package it.solvingteam.gestioneordini.service.articolo;

import java.util.List;

import it.solvingteam.gestioneordini.dao.articolo.ArticoloDAO;
import it.solvingteam.gestioneordini.model.articolo.Articolo;


public interface ArticoloService {
	public List<Articolo> listAll() throws Exception;

	public Articolo get(Long id) throws Exception;

	public void aggiorna(Articolo articoloInstance) throws Exception;

	public void inserisciNuovo(Articolo articoloInstance) throws Exception;

	public void rimuovi(Articolo articoloInstance) throws Exception;

	// per injection
	public void setArticoloDAO(ArticoloDAO articoloDAO);
}
