package it.solvingteam.gestioneordini.dao.categoria;

import it.solvingteam.gestioneordini.dao.IBaseDAO;
import it.solvingteam.gestioneordini.model.categoria.Categoria;
import it.solvingteam.gestioneordini.model.ordine.Ordine;

public interface CategoriaDAO extends IBaseDAO<Categoria> {

	public Categoria findByDescrizione(String descrizione) throws Exception;

	void cercaCategorieOrdine(Ordine ordine) throws Exception;
}
