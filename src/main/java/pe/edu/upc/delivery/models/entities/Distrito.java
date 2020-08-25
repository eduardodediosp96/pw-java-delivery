package pe.edu.upc.delivery.models.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "distritos")
public class Distrito {
	@Id
	private Integer id;
	private String nombre;
	private String provincia;
	
	private List<Proveedor> proveedores;
	private List<Cliente> clientes;
}
