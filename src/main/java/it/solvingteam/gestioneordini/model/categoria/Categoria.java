package it.solvingteam.gestioneordini.model.categoria;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import it.solvingteam.gestioneordini.model.articolo.Articolo;

@Entity
@Table(name = "categoria")

public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "descrizione")
	private String descrizione;
	@ManyToMany(mappedBy = "categorie")
	private Set<Articolo> articoli = new HashSet<>(0);
	
	public Categoria() {}
	
	public Categoria(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Set<Articolo> getArticoli() {
		return articoli;
	}
	public void setArticoli(Set<Articolo> articoli) {
		this.articoli = articoli;
	}
	
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", descrizione=" + descrizione + "]";
	}
	@Override 
	public boolean equals(Object object) {
		if(object instanceof Categoria ) {
			Categoria categoria = (Categoria) object;
			return descrizione.equals(categoria.getDescrizione());
			
		}
		else {
			return this.equals(object);
		}
	}
}
