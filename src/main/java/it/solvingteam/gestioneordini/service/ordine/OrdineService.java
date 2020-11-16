package it.solvingteam.gestioneordini.service.ordine;

import java.util.Set;

import it.solvingteam.gestioneordini.dao.ordine.OrdineDAO;
import it.solvingteam.gestioneordini.model.articolo.Articolo;
import it.solvingteam.gestioneordini.model.ordine.Ordine;



public interface OrdineService {
	public Set<Ordine> listAll() throws Exception;

	public Ordine get(Long id) throws Exception;

	public void aggiorna(Ordine ordineInstance) throws Exception;

	public void inserisciNuovo(Ordine ordineInstance) throws Exception;

	public void rimuovi(Ordine ordineInstance) throws Exception;

	// per injection
	public void setOrdineDAO(OrdineDAO ordineDAO);

	void aggiungiArticolo(Ordine ordineEsistente, Articolo articoloEsistente) throws Exception;

	void rimuoviArticolo(Ordine ordineEsistente, Articolo articoloEsistente) throws Exception;

	void searchByCategory(String descrizione) throws Exception;
}
