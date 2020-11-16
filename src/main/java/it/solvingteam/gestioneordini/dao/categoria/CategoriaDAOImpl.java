package it.solvingteam.gestioneordini.dao.categoria;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.solvingteam.gestioneordini.model.articolo.Articolo;
import it.solvingteam.gestioneordini.model.categoria.Categoria;
import it.solvingteam.gestioneordini.model.ordine.Ordine;

public class CategoriaDAOImpl implements CategoriaDAO {
    
	  
    private EntityManager entityManager;
		
	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
			
		}
	@Override
	public Set<Categoria> list() throws Exception {
		return entityManager.createQuery("from Categoria",Categoria.class).getResultList().stream().collect(Collectors.toSet());
	}

	@Override
	public Categoria get(Long id) throws Exception {
		return entityManager.find(Categoria.class, id);
	}

	@Override
	public void update(Categoria categoriaInstance) throws Exception {
		if (categoriaInstance == null) {
			throw new Exception("Problema valore in input");
		}
		categoriaInstance = entityManager.merge(categoriaInstance);
		
		
	}

	@Override
	public void insert(Categoria categoriaInstance) throws Exception {
		if (categoriaInstance == null) {
			throw new Exception("Problema valore in input");
		}
		//controllo se esiste gia una categoria 
		if (this.list().size()>0) { 
			boolean categoriaPresente=false;
			for (Categoria c:this.list()) {
				if (c.equals(categoriaInstance)) {
					categoriaPresente=true;
				}
			}
			if (categoriaPresente) {
				System.err.println("Esiste già una categoria con descrizione="+categoriaInstance.getDescrizione());
				return;
			} else {
				entityManager.persist(categoriaInstance);
			}
		} else {
			entityManager.persist(categoriaInstance);
		}
		
	}

	@Override
	public void delete(Categoria categoriaInstance) throws Exception {
		if (categoriaInstance == null ) {
			throw new Exception("Problema valore in input");
		}
		Set<Articolo> listaArticoli = new HashSet<>();
		TypedQuery<Articolo> query = entityManager.createQuery("select a FROM Articolo a join a.categorie c where c = :categoria",Articolo.class);
		query.setParameter("categoria", categoriaInstance);
		listaArticoli = query.getResultList().stream().collect(Collectors.toSet());
		//se lista vuota, possiamo effettuare l'eliminazione
		if(listaArticoli.size()==0) {
		entityManager.remove(entityManager.merge(categoriaInstance));
		} else {
			System.out.println("Non si può eliminare la categoria!"); 
			
		}
		
	}
	
	@Override
	public Categoria findByDescrizione(String descrizione) throws Exception {
		TypedQuery<Categoria> query = entityManager
				.createQuery("select c from Categoria c where c.descrizione like ?1 ", Categoria.class)
				.setParameter(1, descrizione);
				
		
		return query.getResultStream().findFirst().orElse(null);
	}

	  @Override
	    public void cercaCategorieOrdine(Ordine ordine) throws Exception {
	    	TypedQuery<Categoria> query = entityManager.createQuery("select c from Categoria c join c.articoli categArt where categArt.ordine.id = ?1", Categoria.class);
			 query.setParameter(1, ordine.getId());
			 Set<Categoria> categoria= query.getResultList().stream().collect(Collectors.toSet());
			 System.out.println(" categorie degli Articoli di questo ordine :" + ordine.getId() + categoria);
	    }


}
