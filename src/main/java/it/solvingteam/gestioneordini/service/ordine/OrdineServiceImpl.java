package it.solvingteam.gestioneordini.service.ordine;

import java.util.Set;

import javax.persistence.EntityManager;

import it.solvingteam.gestioneordini.dao.EntityManagerUtil;
import it.solvingteam.gestioneordini.dao.ordine.OrdineDAO;
import it.solvingteam.gestioneordini.model.articolo.Articolo;
import it.solvingteam.gestioneordini.model.ordine.Ordine;

public class OrdineServiceImpl implements OrdineService{
    
	private OrdineDAO ordineDAO;
	

	@Override
	public Set<Ordine> listAll() throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			ordineDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return ordineDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}

	}

	@Override
	public Ordine get(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			ordineDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return ordineDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}

	}

	@Override
	public void aggiorna(Ordine ordineInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			ordineDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			ordineDAO.update(ordineInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}	
		
	}

	@Override
	public void inserisciNuovo(Ordine ordineInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			ordineDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			ordineDAO.insert(ordineInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void rimuovi(Ordine ordineInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			ordineDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			ordineDAO.insert(ordineInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public void aggiungiArticolo(Ordine ordineEsistente, Articolo articoloEsistente) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			ordineDAO.setEntityManager(entityManager);

			// 'attacco' alla sessione di hibernate i due oggetti
			// così jpa capisce che se è già presente quella categori non deve essere inserito
			ordineEsistente = entityManager.merge(ordineEsistente);
			articoloEsistente = entityManager.merge(articoloEsistente);
			
			ordineDAO.addArticolo(ordineEsistente, articoloEsistente);
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
	public void setOrdineDAO(OrdineDAO ordineDAO) {
		this.ordineDAO = ordineDAO;
		
	}
	
	@Override
	public void rimuoviArticolo(Ordine ordineEsistente, Articolo articoloEsistente) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			ordineDAO.setEntityManager(entityManager);

			ordineEsistente = entityManager.merge(ordineEsistente);
			articoloEsistente = entityManager.merge(articoloEsistente);
			
			ordineDAO.removeArticolo(ordineEsistente, articoloEsistente);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}
	

	@Override
	public void searchByCategory(String descrizione) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			ordineDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			 ordineDAO.cercaOrdiniPerCategoria(descrizione);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}

	}
	

}
