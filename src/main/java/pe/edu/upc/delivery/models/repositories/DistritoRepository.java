package pe.edu.upc.delivery.models.repositories;

import java.util.List;

import pe.edu.upc.delivery.models.entities.Distrito;

public interface DistritoRepository extends JpaRepository<Distrito, Integer> {
	List<Distrito> findByNombre(String nombre) throws Exception;	
}
