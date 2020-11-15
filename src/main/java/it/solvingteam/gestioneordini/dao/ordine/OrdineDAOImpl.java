package it.solvingteam.gestioneordini.dao.ordine;

import java.util.List;

import javax.persistence.EntityManager;

import it.solvingteam.gestioneordini.model.ordine.Ordine;

public class OrdineDAOImpl implements OrdineDAO {

	private EntityManager entityManager;
		
	@Override
	public void setEntityManager(EntityManager entityManager) {
			this.entityManager = entityManager;
				
	}
	
	@Override
	public List<Ordine> list() throws Exception {
		return entityManager.createQuery("from Ordine",Ordine.class).getResultList();
	}

	@Override
	public Ordine get(Long id) throws Exception {
		return entityManager.find(Ordine.class, id);
	}

	@Override
	public void update(Ordine ordineInstance) throws Exception {
		if (ordineInstance == null) {
			throw new Exception("Problema valore in input");
		}
		ordineInstance = entityManager.merge(ordineInstance);
		
	}

	@Override
	public void insert(Ordine ordineInstance) throws Exception {
		if (ordineInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(ordineInstance);
		
		
	}

	@Override
	public void delete(Ordine ordineInstace) throws Exception {
		if (ordineInstace == null ) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(ordineInstace));
		
	}

	

}