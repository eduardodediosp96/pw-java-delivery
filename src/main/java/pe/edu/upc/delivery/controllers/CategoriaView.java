package pe.edu.upc.delivery.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.delivery.models.entities.Categoria;
import pe.edu.upc.delivery.services.CategoriaService;

@Named("categoriaView")		// Creando un Beans
@ViewScoped
public class CategoriaView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Categoria> categorias;

	@Inject
	private CategoriaService categoriaService;

	@PostConstruct
	public void init() {
		loadCategorias();
	}
	
	public void loadCategorias() {
		try {
			this.categorias = categoriaService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println( e.getMessage() );
		}
	}
	
	
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public CategoriaService getCategoriaService() {
		return categoriaService;
	}
}
