package it.solvingteam.gestioneordini.dao.ordine;

import it.solvingteam.gestioneordini.dao.IBaseDAO;
import it.solvingteam.gestioneordini.model.articolo.Articolo;
import it.solvingteam.gestioneordini.model.ordine.Ordine;

public interface OrdineDAO extends IBaseDAO<Ordine> {
	
	public void addArticolo(Ordine ordineEsistente, Articolo articoloEsistente) throws Exception;

	void removeArticolo(Ordine ordineEsistente, Articolo articoloEsistente) throws Exception;

	void cercaOrdiniPerCategoria(String descrizioneCategoria) throws Exception;
}
