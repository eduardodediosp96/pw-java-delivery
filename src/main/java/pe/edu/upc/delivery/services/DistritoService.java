package pe.edu.upc.delivery.services;

import java.util.List;

import pe.edu.upc.delivery.models.entities.Distrito;

public interface DistritoService extends CrudService<Distrito, Integer>{
	List<Distrito> findByNombre(String nombre) throws Exception;
}
