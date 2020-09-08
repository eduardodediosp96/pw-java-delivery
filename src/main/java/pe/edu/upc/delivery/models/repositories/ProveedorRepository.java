package pe.edu.upc.delivery.models.repositories;

import java.util.List;

import pe.edu.upc.delivery.models.entities.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
	List<Proveedor> findByNombre(String nombre) throws Exception;
}
