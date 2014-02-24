package es.indra.formacion.pr.persistence.dao;

import es.indra.formacion.pr.persistence.model.Ordenador;

public class OrdenadorDao extends BaseDao<Ordenador, Integer> implements IOrdenadorDao {
	public OrdenadorDao() {
		super();
	}

	public OrdenadorDao(boolean autoCommit) {
		super(autoCommit);
	}
}
