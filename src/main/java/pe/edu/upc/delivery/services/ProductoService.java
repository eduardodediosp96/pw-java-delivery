package pe.edu.upc.delivery.services;

import java.util.List;

import pe.edu.upc.delivery.models.entities.Producto;

public interface ProductoService extends CrudService<Producto, Integer> {
	List<Producto> findByDescripcion(String Descripcion) throws Exception;
}
