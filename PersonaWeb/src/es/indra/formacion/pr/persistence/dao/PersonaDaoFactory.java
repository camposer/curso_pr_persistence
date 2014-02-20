package es.indra.formacion.pr.persistence.dao;

public abstract class PersonaDaoFactory {
	public static IPersonaDao createPersonaDao() {
		return new PersonaDao();
	}
}
