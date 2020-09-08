package pe.edu.upc.delivery.models.repositories;

import java.util.List;

import pe.edu.upc.delivery.models.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	List<Producto> findByDescripcion(String Descripcion) throws Exception;
}
