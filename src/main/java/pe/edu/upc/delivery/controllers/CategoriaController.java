package pe.edu.upc.delivery.controllers;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.delivery.services.CategoriaService;

@Named
public class CategoriaController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CategoriaService categoriaService;
	
}
