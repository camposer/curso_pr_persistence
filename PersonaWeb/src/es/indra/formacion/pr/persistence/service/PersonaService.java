package es.indra.formacion.pr.persistence.service;

import java.util.List;

import es.indra.formacion.pr.persistence.dao.IPersonaDao;
import es.indra.formacion.pr.persistence.dao.PersonaDaoFactory;
import es.indra.formacion.pr.persistence.model.Persona;

class PersonaService implements IPersonaService {
	private IPersonaDao personaDao;
	
	public PersonaService() {
		personaDao = PersonaDaoFactory.createPersonaDao();
	}

	@Override
	public void agregarPersona(Persona p) {
		personaDao.agregar(p);
	}

	@Override
	public List<Persona> obtenerPersonas() {
		return personaDao.obtenerTodos();
	}

}
