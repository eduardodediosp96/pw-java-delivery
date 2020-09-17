package pe.edu.upc.delivery.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.edu.upc.delivery.models.entities.Categoria;
import pe.edu.upc.delivery.services.CategoriaService;
import pe.edu.upc.delivery.utils.Action;

@Named("categoriaView")		// Creando un Beans
@ViewScoped
public class CategoriaView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Categoria> categorias;
	private Categoria categoria;
	private Categoria categoriaSelected;
	private Action action;

	@Inject
	private CategoriaService categoriaService;

	@PostConstruct
	public void init() {
		cleanForm();
		loadCategorias();	
		action = Action.NONE;
	}
	
	public void loadCategorias() {
		try {
			this.categorias = categoriaService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println( e.getMessage() );
		}
	}
	// Método que se ejecuta cuando hago click en 'Nuevo'
	public void newCategoria() {
		action = Action.NEW;
		cleanForm();
	}
	public void cleanForm( ) {
		this.categoria = new Categoria();
		this.categoriaSelected = null;		
	}
	// Metodo para grabar el elemento ingresado en el formulario
	public void saveCategoria() {
		try {
			if (action == Action.NEW) {
				categoriaService.save(this.categoria);
			} 
			else if (action == Action.EDIT) {
				categoriaService.update(this.categoria);
			}	
			action = Action.NONE;
			cleanForm();
			loadCategorias();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println( e.getMessage() );
		}
	}
	// Metodo que se ejecuta cada vez que el usuario selecciona una fila del datatable
	public void selectCategoria(SelectEvent<Categoria> e) {
		this.categoriaSelected = e.getObject();
	}
	
	// Método que se ejecuta cuando hago click en el boton Editar
	public void editCategoria() {
		if(categoriaSelected != null) {
			action = Action.EDIT;
			categoria = categoriaSelected;
			categoriaSelected = null;
		}
	}
	
	// Método que se ejecuta cuando hace click en el boton 'Eliminar'
	public void deleteCategoria() {
		if(categoriaSelected != null) {
			try {
				categoriaService.deleteById(categoriaSelected.getId());
				action = Action.NONE;
				cleanForm();
				loadCategorias();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println( e.getMessage() );
			}
		}
	}
	
	
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public CategoriaService getCategoriaService() {
		return categoriaService;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
	
	
}
