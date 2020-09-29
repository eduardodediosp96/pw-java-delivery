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

import pe.edu.upc.delivery.models.entities.Distrito;
import pe.edu.upc.delivery.models.repositories.DistritoRepository;

@Named
@ApplicationScoped
public class DistritoRepositoryImpl implements DistritoRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "DeliveryPU")
	private EntityManager em;

	@Override
	public Distrito save(Distrito entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Distrito update(Distrito entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<Distrito> optional = findById(id);
		if( optional.isPresent() )
			em.remove( optional.get() );
	}

	@Override
	public List<Distrito> findAll() throws Exception {
		List<Distrito> distritos = new ArrayList<Distrito>();
		String qlString = "SELECT d FROM Distrito d";	// JPQL
		TypedQuery<Distrito> query = em.createQuery(qlString, Distrito.class);
		distritos = query.getResultList();
		return distritos;
	}

	@Override
	public Optional<Distrito> findById(Integer id) throws Exception {

		Optional<Distrito> distrito = Optional.empty();
		String qlString = "SELECT d FROM Distrito d WHERE d.id = ?1";	// JPQL
		TypedQuery<Distrito> query = em.createQuery(qlString, Distrito.class);
		query.setParameter(1, id);
		List<Distrito> distritos = query.getResultList();
		
		if(distritos != null && !distritos.isEmpty())
			distrito = Optional.of( distritos.get(0) );
		
		return distrito;
	}

	@Override
	public List<Distrito> findByNombre(String nombre) throws Exception {
		List<Distrito> distritos = new ArrayList<Distrito>();
		String qlString = "SELECT d FROM Distrito d WHERE d.nombre LIKE ?1";	// JPQL
		TypedQuery<Distrito> query = em.createQuery(qlString, Distrito.class);
		query.setParameter(1, "%" + nombre + "%");
		distritos = query.getResultList();
		return distritos;
	}


}
