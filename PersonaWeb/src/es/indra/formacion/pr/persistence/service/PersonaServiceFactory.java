package es.indra.formacion.pr.persistence.service;

public abstract class PersonaServiceFactory {
	public static IPersonaService createPersonaService() {
		return new PersonaService();
	}
}