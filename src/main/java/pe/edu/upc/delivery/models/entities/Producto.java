package pe.edu.upc.delivery.models.entities;

import java.util.List;

public class Producto {
	private Integer id;
	private String descripcion;
	private Integer stock;
	private Float precioCompra;
	private Float precioVenta;
	private String marca;
	private Categoria categoria;
	
	private List<Proveedor> proveedores;
	private List<DetallePedido> detallePedidos;
}
