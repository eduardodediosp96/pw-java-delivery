package pe.edu.upc.delivery.services;

import java.util.List;

import pe.edu.upc.delivery.models.entities.Categoria;

public interface CategoriaService extends CrudService<Categoria, Integer> {
	List<Categoria> findByDenominacion(String denominacion) throws Exception;
}
