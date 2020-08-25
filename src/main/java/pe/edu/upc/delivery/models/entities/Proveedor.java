package pe.edu.upc.delivery.models.entities;

import java.util.List;

public class Proveedor {
	private Integer id;
	private String nombre;
	private String direccion;
	private Distrito distrito;
	private String contacto;
	private String celular;
	
	private List<Producto> productos;
	private List<DetallePedido> detallePedidos;
}
