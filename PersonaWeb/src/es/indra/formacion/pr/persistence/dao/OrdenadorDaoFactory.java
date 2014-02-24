package es.indra.formacion.pr.persistence.dao;

public abstract class OrdenadorDaoFactory {
	public static IOrdenadorDao createOrdenadorDao() {
		return createOrdenadorDao(true);
	}

	public static IOrdenadorDao createOrdenadorDao(boolean autoCommit) {
		return new OrdenadorDao(autoCommit);
	}
}
