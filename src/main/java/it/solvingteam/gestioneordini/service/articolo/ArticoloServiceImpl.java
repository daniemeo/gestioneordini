package it.solvingteam.gestioneordini.service.articolo;

import java.util.Set;

import javax.persistence.EntityManager;

import it.solvingteam.gestioneordini.dao.EntityManagerUtil;
import it.solvingteam.gestioneordini.dao.articolo.ArticoloDAO;
import it.solvingteam.gestioneordini.model.articolo.Articolo;
import it.solvingteam.gestioneordini.model.categoria.Categoria;


public class ArticoloServiceImpl implements ArticoloService {

	private ArticoloDAO articoloDAO;

	@Override
	public Set<Articolo> setAll() throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			articoloDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return articoloDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}

	}

	@Override
	public Articolo get(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			articoloDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return articoloDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void aggiorna(Articolo articoloInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			articoloDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			articoloDAO.update(articoloInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void inserisciNuovo(Articolo articoloInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			articoloDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			articoloDAO.insert(articoloInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void rimuovi(Articolo articoloInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			articoloDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			articoloDAO.insert(articoloInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void setArticoloDAO(ArticoloDAO articoloDAO) {
		this.articoloDAO = articoloDAO;

	}
	
	@Override
	public void aggiungiCategoria(Articolo articoloEsistente,  Categoria categoriaInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			articoloDAO.setEntityManager(entityManager);

			// 'attacco' alla sessione di hibernate i due oggetti
			// così jpa capisce che se è già presente quella categori non deve essere inserito
			articoloEsistente = entityManager.merge(articoloEsistente);
			categoriaInstance = entityManager.merge(categoriaInstance);
			
			articoloDAO.addCategoria(articoloEsistente, categoriaInstance);
			//l'update non viene richiamato a mano in quanto 
			//risulta automatico, infatti il contesto di persistenza
			//rileva che articoloEsistente ora è dirty vale a dire che una sua
			//proprieta ha subito una modifica (vale anche per i Set ovviamente)

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}
	
	@Override
	public Articolo CercaPerDescrizione(String descrizione) throws Exception{
	// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			articoloDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return articoloDAO.findByDescrizione(descrizione);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
		
	}
	
	
	@Override
	public void rimuoviCategoria(Articolo articoloEsistente,  Categoria categoriaInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			articoloDAO.setEntityManager(entityManager);

			// 'attacco' alla sessione di hibernate i due oggetti
			// così jpa capisce che se è già presente quella categori non deve essere inserito
			articoloEsistente = entityManager.merge(articoloEsistente);
			categoriaInstance = entityManager.merge(categoriaInstance);
			
			articoloDAO.removeCategoria(articoloEsistente, categoriaInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}
	
	@Override
	public void sumPrezziByCategoria(Categoria categoriaInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			articoloDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			articoloDAO.sommaPrezziPerCategoria(categoriaInstance);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}

	}
	

	

}
