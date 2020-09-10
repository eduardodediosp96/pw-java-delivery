package pe.edu.upc.delivery.services;

import java.util.List;

import pe.edu.upc.delivery.models.entities.Proveedor;

public interface ProveedorService extends CrudService<Proveedor, Integer> {
	List<Proveedor> findByNombre(String nombre) throws Exception;
}
