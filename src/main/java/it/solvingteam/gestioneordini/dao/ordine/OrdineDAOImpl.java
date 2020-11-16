package it.solvingteam.gestioneordini.dao.ordine;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.solvingteam.gestioneordini.model.articolo.Articolo;
import it.solvingteam.gestioneordini.model.ordine.Ordine;

public class OrdineDAOImpl implements OrdineDAO {

	private EntityManager entityManager;
		
	@Override
	public void setEntityManager(EntityManager entityManager) {
			this.entityManager = entityManager;
				
	}
	
	@Override
	public Set<Ordine> list() throws Exception {
		return entityManager.createQuery("from Ordine",Ordine.class).getResultList().stream().collect(Collectors.toSet());
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
    
    @Override
    
	public void addArticolo(Ordine ordineEsistente, Articolo articoloEsistente) throws Exception {
	articoloEsistente.setOrdine(ordineEsistente);
	}
    
    @Override
    
   	public void removeArticolo(Ordine ordineEsistente, Articolo articoloEsistente) throws Exception {
   	articoloEsistente.setOrdine(null);
   	}
    
    @Override
    public void cercaOrdiniPerCategoria(String descrizioneCategoria) throws Exception {
    	TypedQuery<Ordine> query = entityManager.createQuery("select a.ordine from Articolo a join a.categorie c where a.ordine is not null and c.descrizione like ?1", Ordine.class);
		 query.setParameter(1, descrizioneCategoria);
		 Set<Ordine> ordine= query.getResultList().stream().collect(Collectors.toSet());
		 System.out.println("gli ordini per questa categoria sono: " + descrizioneCategoria + ordine);
    }


	

}
