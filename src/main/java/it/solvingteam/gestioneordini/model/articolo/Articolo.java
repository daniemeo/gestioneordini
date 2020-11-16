package it.solvingteam.gestioneordini.model.articolo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import it.solvingteam.gestioneordini.model.categoria.Categoria;
import it.solvingteam.gestioneordini.model.ordine.Ordine;


@Entity
@Table(name = "articolo")
public class Articolo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "descrizione")
	private String descrizione;
	@Column(name = "prezzo")
	private Double prezzo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ordine_id")
	private Ordine ordine;
	@ManyToMany
	@JoinTable(name = "articolo_categoria", joinColumns = @JoinColumn(name = "articolo_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "categoria_id", referencedColumnName = "ID"))
	private Set<Categoria> categorie = new HashSet<>(0);
	
	public Articolo() {}
	
	public Articolo(String descrizione , Double prezzo) {
		this.descrizione = descrizione;
		this.prezzo = prezzo;
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
	public Double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	public Ordine getOrdine() {
		return ordine;
	}
	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}
	public Set<Categoria> getCategorie() {
		return categorie;
	}
	public void setRuoli(Set<Categoria> categorie) {
		this.categorie = categorie;
	}
	
	@Override
	public String toString() {
		return "Articolo [id=" + id + ", descrizione=" + descrizione+ ", prezzo=" + prezzo + ", categorie:" + categorie.size() + "]";
	}
	
	//non serve!! perchè possiamo creare piu articoli con lo stesso nome e quant'altro!!
	@Override 
	public boolean equals(Object object) {
		if(object instanceof Articolo ) {
		  Articolo articolo = (Articolo) object;
			return descrizione.equals(articolo.getDescrizione());
			
		}
		else {
			return this.equals(object);
		}
	}

	
	
}
