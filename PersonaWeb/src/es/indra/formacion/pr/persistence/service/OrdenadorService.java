package es.indra.formacion.pr.persistence.service;

import java.util.List;

import es.indra.formacion.pr.persistence.dao.IOrdenadorDao;
import es.indra.formacion.pr.persistence.dao.IPersonaDao;
import es.indra.formacion.pr.persistence.dao.OrdenadorDaoFactory;
import es.indra.formacion.pr.persistence.dao.PersonaDaoFactory;
import es.indra.formacion.pr.persistence.model.Ordenador;
import es.indra.formacion.pr.persistence.model.Persona;

public class OrdenadorService implements IOrdenadorService {
	private IPersonaDao personaDao;
	private IOrdenadorDao ordenadorDao;

	public OrdenadorService() {
		ordenadorDao = OrdenadorDaoFactory.createOrdenadorDao();
		personaDao = PersonaDaoFactory.createPersonaDao();
	}
	
	@Override
	public void agregarOrdenador(Ordenador o) {
		Persona p = personaDao.obtener(o.getPersona().getId());
		o.setPersona(p);
		
		ordenadorDao.agregar(o); // Ahora sí funciona!!
	}

	@Override
	public List<Ordenador> obtenerOrdenadores() {
		return ordenadorDao.obtenerTodos();
	}

}
