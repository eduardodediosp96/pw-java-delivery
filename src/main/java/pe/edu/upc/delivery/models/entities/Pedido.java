package pe.edu.upc.delivery.models.entities;

import java.util.Date;
import java.util.List;

public class Pedido {
	private Integer id;
	private Cliente cliente;
	private Date fechaPedido;
	private Float precioTotal;	
	
	private List<DetallePedido> detallePedidos;
	
}
