package pe.edu.upc.delivery.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.delivery.models.entities.Cliente;
import pe.edu.upc.delivery.services.ClienteService;

@Named("clienteView")		// Creando un Beans
@ViewScoped
public class ClienteView  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Cliente> clientes;
	
	@Inject
	private ClienteService clienteService;

	@PostConstruct
	public void init() {
		loadClientes();
	}
	
	public void loadClientes() {
		try {
			this.clientes = clienteService.findAll();
		} catch( Exception e ) {
			e.printStackTrace();
			System.err.println( e.getMessage() );
		}
	}	
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public ClienteService getClienteService() {
		return clienteService;
	}	
}
