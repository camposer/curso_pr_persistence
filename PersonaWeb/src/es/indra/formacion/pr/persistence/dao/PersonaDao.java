package es.indra.formacion.pr.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import es.indra.formacion.pr.persistence.model.Persona;

class PersonaDao implements IPersonaDao {
	private EntityManager em;
	
	public PersonaDao() {
		em = Persistence
				.createEntityManagerFactory("PersonaJpa")
				.createEntityManager();
	}

	@Override
	protected void finalize() throws Throwable {
		if (em != null)
			em.close();
	}
	
	@Override
	public void agregar(Persona p) {
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();

			em.persist(p);
			
			et.commit();
		} catch (Exception e) {
			if (et != null)
				et.rollback();
		} 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> obtenerTodos() {
		Query q = em.createNamedQuery("Persona.findAll");
		List<Persona> personas = (List<Persona>)q.getResultList();	
		return personas;
	}

}
