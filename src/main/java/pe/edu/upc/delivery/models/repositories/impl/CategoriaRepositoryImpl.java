package pe.edu.upc.delivery.models.repositories.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.delivery.models.entities.Categoria;
import pe.edu.upc.delivery.models.repositories.CategoriaRepository;

@Named
@ApplicationScoped
public class CategoriaRepositoryImpl implements CategoriaRepository, Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "DeliveryPU")
	private EntityManager em;

	@Override
	public Categoria save(Categoria entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Categoria update(Categoria entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// Buscar el objeto a eliminar
		Optional<Categoria> optional = findById(id);
		// Verificar que optional contenga un objeto categoria
		if( optional.isPresent() )
			// Remover el objeto contenido en el optional
			em.remove( optional.get() );
	}

	@Override
	public List<Categoria> findAll() throws Exception {
		List<Categoria> categorias = new ArrayList<Categoria>();
		String qlString = "SELECT c FROM Categoria c";	// JPQL
		TypedQuery<Categoria> query = em.createQuery(qlString, Categoria.class);
		categorias = query.getResultList();
		return categorias;
	}

	@Override
	public Optional<Categoria> findById(Integer id) throws Exception {
		// Crear la variable a retornar
		Optional<Categoria> categoria = Optional.empty();
		// Crear la sentencia JPQL
		String qlString = "SELECT c FROM Categoria c WHERE c.id = ?1";	// JPQL
		// Crear la varible query basado en el JPQL y la clase
		TypedQuery<Categoria> query = em.createQuery(qlString, Categoria.class);
		// Establecer los parametros
		query.setParameter(1, id);
		// Obtener la lista resultante de la consulta
		List<Categoria> categorias = query.getResultList();
		
		// Si categorias tiene un elemento
		if(categorias != null && !categorias.isEmpty())
			categoria = Optional.of( categorias.get(0) );
		
		return categoria;
	}

	@Override
	public List<Categoria> findByDenominacion(String denominacion) throws Exception {
		List<Categoria> categorias = new ArrayList<Categoria>();
		String qlString = "SELECT c FROM Categoria c WHERE c.denominacion LIKE ?1";	// JPQL
		TypedQuery<Categoria> query = em.createQuery(qlString, Categoria.class);
		query.setParameter(1, "%" + denominacion + "%");
		categorias = query.getResultList();
		return categorias;
	}

}
