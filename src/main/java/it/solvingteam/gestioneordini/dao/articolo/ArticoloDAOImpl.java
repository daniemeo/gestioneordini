package it.solvingteam.gestioneordini.dao.articolo;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.solvingteam.gestioneordini.model.articolo.Articolo;
import it.solvingteam.gestioneordini.model.categoria.Categoria;

public class ArticoloDAOImpl implements ArticoloDAO{
    
	private EntityManager entityManager;
	
	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		
	}

	@Override
	public Set<Articolo> list() throws Exception {
		return entityManager.createQuery("from Articolo",Articolo.class).getResultList().stream().collect(Collectors.toSet());

	}

	@Override
	public Articolo get(Long id) throws Exception {
		return entityManager.find(Articolo.class, id);
	}

	@Override
	public void update(Articolo articoloInstance) throws Exception {
		if (articoloInstance == null) {
			throw new Exception("Problema valore in input");
		}
		articoloInstance = entityManager.merge(articoloInstance);
		
	}
/*
	@Override
	public void insert(Articolo articoloInstance) throws Exception {
		if (articoloInstance == null) {
			throw new Exception("Problema valore in input");
		}if (this.list().size()>0) { 
			boolean articoloPresente=false;
			for (Articolo a :this.list()) {
				if (a.equals(articoloInstance)) {
					articoloPresente=true;
				}
			}
			if (articoloPresente) {
				System.err.println("Esiste già un articolo con questa descrixione="+ articoloInstance.getDescrizione());
				return;
			} else {
				entityManager.persist(articoloInstance);
			}
		} else {
			entityManager.persist(articoloInstance);
		}
		
		
		
	}
*/
	@Override
	public void insert(Articolo articoloInstance) throws Exception {
		if (articoloInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(articoloInstance);
		
		
	}
	
	@Override
	public void delete(Articolo articoloInstance) throws Exception {
		if (articoloInstance == null ) {
			throw new Exception("Problema valore in input");
		}
		TypedQuery<Articolo> query = entityManager.createQuery("select a FROM  Articolo a where a.ordine ?1",Articolo.class);
		 query.setParameter(1, articoloInstance.getOrdine());
		if( query.getResultList().isEmpty()) {
		entityManager.remove(entityManager.merge(articoloInstance));
		}else {
			System.out.println("non puoi eliminare questo articolo!! è presente in un ordine");
		}
	}
	

	@Override
	public Articolo findByDescrizione(String descrizione) throws Exception {
		TypedQuery<Articolo> query = entityManager
				.createQuery("select a from Articolo a where a.descrizione like ?1 ", Articolo.class)
				.setParameter(1, descrizione);
				
		
		return query.getResultStream().findFirst().orElse(null);
	}
    
	@Override
	public void addCategoria(Articolo articoloEsistente, Categoria categoriaEsistente) throws Exception {
		articoloEsistente.getCategorie().add(categoriaEsistente);
	}
	
	@Override
	public void removeCategoria(Articolo articoloEsistente, Categoria categoriaEsistente) throws Exception {
		articoloEsistente.getCategorie().remove(categoriaEsistente);
	}

	 @Override
	    public void sommaPrezziPerCategoria(Categoria categoria) throws Exception {
	    	TypedQuery<Double> query = entityManager.createQuery("select sum(a.prezzo) from Articolo a join a.categorie c where c.descrizione = ?1", Double.class);
			 query.setParameter(1, categoria.getDescrizione());
			 Set<Double> prezziTot = query.getResultList().stream().collect(Collectors.toSet());
			 System.out.println(" la somma dei prezzi per gli articoli per una categoria sono" + categoria.getDescrizione() + categoria + prezziTot);
	    }
	

	
}
