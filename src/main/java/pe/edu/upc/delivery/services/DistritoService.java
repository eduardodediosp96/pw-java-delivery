package pe.edu.upc.delivery.services;

import java.util.Optional;

import pe.edu.upc.delivery.models.entities.Distrito;

public interface DistritoService extends CrudService<Distrito, Integer>{
	Optional<Distrito> findByNombre(String nombre) throws Exception;
}
