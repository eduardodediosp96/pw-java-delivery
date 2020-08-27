package pe.edu.upc.delivery.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "distritos")
public class Distrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	
	@Column(name = "nombre", length = 30, nullable = false)
	private String nombre;
	
	@Column(name = "provincia", length = 30, nullable = false)
	private String provincia;
	
	@OneToMany(mappedBy = "distrito")		// 1(@OneToMany), 4(mappedBy)
	private List<Cliente> clientes;
	
	private List<Proveedor> proveedores;
	
}
