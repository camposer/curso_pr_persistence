package es.indra.formacion.pr.persistence.service;

import java.util.List;

import es.indra.formacion.pr.persistence.dao.IOrdenadorDao;
import es.indra.formacion.pr.persistence.dao.IPersonaDao;
import es.indra.formacion.pr.persistence.dao.OrdenadorDaoFactory;
import es.indra.formacion.pr.persistence.dao.PersonaDaoFactory;
import es.indra.formacion.pr.persistence.model.Ordenador;
import es.indra.formacion.pr.persistence.model.Persona;
import es.indra.formacion.pr.persistence.transaction.TransactionManager;

class PersonaService implements IPersonaService {
	private IPersonaDao personaDao;
	private IOrdenadorDao ordenadorDao;
	private TransactionManager tm =  null;
	
	public PersonaService() {
		tm = new TransactionManager();
		personaDao = PersonaDaoFactory.createPersonaDao(false);
		tm.join(personaDao);
		ordenadorDao = OrdenadorDaoFactory.createOrdenadorDao(false);
		tm.join(ordenadorDao);
	}

	@Override
	public void agregarPersona(Persona p) {
		try {
			tm.begin();

			// Operaciones con persona
			personaDao.agregar(p);
			
			// Operaciones con ordenadores
			if (p.getOrdenadores() != null) for (Ordenador o : p.getOrdenadores()) {
				o.setPersona(p); // Ya fue persistido!!!
				ordenadorDao.agregar(o);
			}
			
			tm.commit();
		} catch (Exception e) {
			if (tm != null)
				tm.rollback();
		}
	}

	@Override
	public List<Persona> obtenerPersonas() {
		return personaDao.obtenerTodos();
	}

	@Override
	protected void finalize() throws Throwable {
		if (tm != null)
			tm.close(); // Cierra la sesión (EntityManager)
	}
}
