package es.indra.formacion.pr.persistence.transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import es.indra.formacion.pr.persistence.dao.BaseDao;
import es.indra.formacion.pr.persistence.dao.IDao;

public class TransactionManager {
	private EntityManager em;
	private EntityTransaction et;
	
	public TransactionManager() {
		em = BaseDao.createEntityManager();
		et = em.getTransaction();
	}

	public void begin() {
		et.begin();
	}
	
	public void commit() {
		et.commit();
	}
	
	public void rollback() {
		et.rollback();
	}
	
	public void close() {
		em.close();
	}
	
	@SuppressWarnings("rawtypes")
	public void join(IDao dao) {
		dao.setEntityManager(em);
	}
}
