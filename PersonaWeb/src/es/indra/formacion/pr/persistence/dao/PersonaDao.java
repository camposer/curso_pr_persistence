package es.indra.formacion.pr.persistence.dao;

import es.indra.formacion.pr.persistence.model.Persona;

class PersonaDao extends BaseDao<Persona, Integer> implements IPersonaDao {
	public PersonaDao() {
		super();
	}
	
	public PersonaDao(boolean autoCommit) {
		super(autoCommit);
	}
	
}
