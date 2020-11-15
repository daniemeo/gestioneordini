package it.solvingteam.gestioneordini.test;

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
}
}