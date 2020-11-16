package it.solvingteam.gestioneordini.test;

import it.solvingteam.gestioneordini.dao.EntityManagerUtil;
import it.solvingteam.gestioneordini.model.articolo.Articolo;
import it.solvingteam.gestioneordini.model.categoria.Categoria;
import it.solvingteam.gestioneordini.model.ordine.Ordine;
import it.solvingteam.gestioneordini.service.MyServiceFactory;
import it.solvingteam.gestioneordini.service.articolo.ArticoloService;
import it.solvingteam.gestioneordini.service.categoria.CategoriaService;
import it.solvingteam.gestioneordini.service.ordine.OrdineService;

/**
 * Hello world!
 *
 */
public class GestioneOrdiniTest {
    public static void main( String[] args ) {
    	OrdineService ordineServiceInstance = MyServiceFactory.getOrdineServiceInstance();
		ArticoloService articoloServiceInstance = MyServiceFactory.getArticoloServiceInstance();
		CategoriaService categoriaServiceInstance = MyServiceFactory.getCategoriaServiceInstance();
		
		// ora passo alle operazioni CRUD
		try {
			
           //inizializzo gli articoli
			
			Articolo articolo = new Articolo("tavolo",250.00);
			Articolo articolo1 = new Articolo("sedia", 150.00);
			Articolo articolo2 = new Articolo("mouse", 15.00);
			Articolo articolo3 = new Articolo("pantaloni", 3.00);
			Articolo articolo4 = new Articolo("quaderno", 1.00);
		
			/*articoloServiceInstance.inserisciNuovo(articolo);
			articoloServiceInstance.inserisciNuovo(articolo1);
			articoloServiceInstance.inserisciNuovo(articolo2);
			articoloServiceInstance.inserisciNuovo(articolo3);
			articoloServiceInstance.inserisciNuovo(articolo4);
			*/
			//inizializzo le categorie
			
			Categoria categoria = new Categoria("Casa");
			Categoria categoria1 = new Categoria("Elettronica");
			Categoria categoria2 = new Categoria("Abbigliamento");
			
			Categoria categoria3 = new Categoria("Cartoleria");
			
			//Categoria categoria4 = new Categoria("giardinaggio");
			
		    
			//articoloServiceInstance.aggiungiCategoria(articolo, categoria);
			//articoloServiceInstance.aggiungiCategoria(articolo1, categoria);
			//articoloServiceInstance.aggiungiCategoria(articolo2, categoria1);
			//articoloServiceInstance.aggiungiCategoria(articolo3, categoria2);
			//categoriaServiceInstance.inserisciNuovo(categoria);
			//categoriaServiceInstance.inserisciNuovo(categoria1);
			//categoriaServiceInstance.inserisciNuovo(categoria2);
			
			//categoriaServiceInstance.inserisciNuovo(categoria3);
			//categoriaServiceInstance.inserisciNuovo(categoria4);
			//inizializzo gli ordini
			/*
			Ordine ordine = new Ordine("Marco Rossi", "via dei boschi");
			Ordine ordine1= new Ordine("Franco Verdi", "via dei beati");
			Ordine ordine2= new Ordine("Tiziano Gialli", "via dei frati");
			Ordine ordine3= new Ordine("Giulio Cesare", "via dei ciclamini");
			
			//inserisco gli ordini
			ordineServiceInstance.inserisciNuovo(ordine);
			ordineServiceInstance.inserisciNuovo(ordine1);
			ordineServiceInstance.inserisciNuovo(ordine2);
			ordineServiceInstance.inserisciNuovo(ordine3);
			*/
			
			Ordine ordineDaDb1 = ordineServiceInstance.get(1L);
			//Ordine ordineDaDb2 = ordineServiceInstance.get(2L);
			//Ordine ordineDaDb = ordineServiceInstance.get(3L);
		    //Ordine ordineDaDb3 = ordineServiceInstance.get(4L);
			
			
			
			//assegno le categorie agli articoli
			
			//Categoria categoDb = categoriaServiceInstance.CercaPerDescrizione("giardinaggio");
			
			//Categoria categoDb1 = categoriaServiceInstance.CercaPerDescrizione("Cartoleria");
			 Categoria categoDb2 = categoriaServiceInstance.CercaPerDescrizione("Casa");
			//Categoria categoDb3 = categoriaServiceInstance.CercaPerDescrizione("Elettronica");
		    //Articolo artic = articoloServiceInstance.CercaPerDescrizione("tavolo");
			//Articolo artic1 = articoloServiceInstance.CercaPerDescrizione("sedia");
			Articolo artic2 = articoloServiceInstance.CercaPerDescrizione("mouse");
			//Articolo artic3 = articoloServiceInstance.CercaPerDescrizione("pantaloni");
			//Articolo artic4 = articoloServiceInstance.CercaPerDescrizione("quaderno");
			
			
			//if(artic1 != null) {
				//articoloServiceInstance.aggiungiCategoria(artic1, categoDb2);
				
			//}
			/*if(artic != null) {
				articoloServiceInstance.aggiungiCategoria(artic, categoDb2);
			}
			*/
			/*
			if (artic2 != null) {
				articoloServiceInstance.aggiungiCategoria(artic2, categoDb3);
			}
			*/
		    //rimuovo una categoria da un articolo
			//articoloServiceInstance.rimuoviCategoria(artic2, categoDb3);
			
			//proviamo ad eliminare una categoria che ha articoli 
			//categoriaServiceInstance.rimuovi(categoDb2);
			
			//provo ad assegnare all'articolo un ordine
			//artic2.setOrdine(ordineDaDb1);
			
			//assegno all'ordine articolo/i
			//ordineServiceInstance.aggiungiArticolo(ordineDaDb2, artic);
			//ordineServiceInstance.aggiungiArticolo(ordineDaDb1, artic1);
			//ordineServiceInstance.aggiungiArticolo(ordineDaDb1, artic2);
			//ordineServiceInstance.aggiungiArticolo(ordineDaDb, artic3);
			//ordineServiceInstance.aggiungiArticolo(ordineDaDb, artic4);
			
			//provo ad eliminare un articolo da un ordine 
			//ordineServiceInstance.rimuoviArticolo(ordineDaDb2, artic);
			
			
			//cerco gli ordini per una determinata categoria
			//ordineServiceInstance.searchByCategory("Casa");
			
			//cerco le categorie degli articoli per un determinato ordine
			//categoriaServiceInstance.searchCategoryByOrder(ordineDaDb1);
			
			//somma dei prezzi degli articoli per una determinata categoria
			articoloServiceInstance.sumPrezziByCategoria(categoDb2);
			
			//categoriaServiceInstance.rimuovi(categoDb);
			//categoriaServiceInstance.rimuovi(categoDb1);
			
		}catch(Exception e ) {
			e.printStackTrace();
		}finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
		    // main
		}
			EntityManagerUtil.shutdown();
		
		}
		
			

}