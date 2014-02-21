package es.indra.formacion.pr.persistence.service;

public abstract class OrdenadorServiceFactory {
	public static IOrdenadorService createOrdenadorService() {
		return new OrdenadorService();
	}
}
