package pe.edu.upc.delivery.models.entities;

import java.util.Date;
import java.util.List;

public class Cliente {
	private Integer id;
	private String apellidos;
	private String nombres;
	private String direccion;
	private Distrito distrito;
	private String numeroDocumento;
	private String celular;
	private String correo;
	private Date fechaNacimiento;
	
	private List<Pedido> pedidos;
}
