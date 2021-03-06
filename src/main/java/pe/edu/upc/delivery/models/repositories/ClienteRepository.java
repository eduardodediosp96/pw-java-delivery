package pe.edu.upc.delivery.models.repositories;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.delivery.models.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	List<Cliente> findByApellidos(String apellidos) throws Exception;
	List<Cliente> findByDireccion(String direccion) throws Exception;
	Optional<Cliente> findByNumeroDocumento(String numeroDocumento) throws Exception;
}
