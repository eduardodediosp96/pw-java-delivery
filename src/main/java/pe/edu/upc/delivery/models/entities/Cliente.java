package pe.edu.upc.delivery.models.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "clientes")
public class Cliente {	// UpperCammel Case
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "apellidos", length = 40, nullable = false)
	private String apellidos;
	
	@Column(name = "nombres", length = 40, nullable = false)
	private String nombres;
	
	@Column(name = "direccion", length = 50, nullable = false)
	private String direccion;
	
	@ManyToOne		// 2	
	@JoinColumn(name = "distrito_id")	// 3
	private Distrito distrito;
	
	@Column(name = "numero_documento", length = 12, nullable = false)	// Snake
	private String numeroDocumento;	// lowerCammel Case
	
	@Column(name = "celular", length = 9, nullable = false)
	private String celular;
	
	@Column(name = "correo", length = 40, nullable = false)
	private String correo;
	
	@Column(name = "fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	private List<Pedido> pedidos;
}
