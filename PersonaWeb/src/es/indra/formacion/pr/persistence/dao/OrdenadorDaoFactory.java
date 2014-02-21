package es.indra.formacion.pr.persistence.dao;

public abstract class OrdenadorDaoFactory {
	public static IOrdenadorDao createOrdenadorDao() {
		return new OrdenadorDao();
	}
}
