package pe.edu.upc.delivery.models.repositories;

import java.util.Optional;

import pe.edu.upc.delivery.models.entities.Distrito;

public interface DistritoRepository extends JpaRepository<Distrito, Integer> {
	Optional<Distrito> findByNombre(String nombre) throws Exception;	
}
