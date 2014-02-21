package es.indra.formacion.pr.persistence.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public abstract class BaseDao<T, K> implements IDao<T, K> {
	private EntityManager em;
	private Class<T> clase;
	
	@SuppressWarnings("unchecked")
	public BaseDao() {
		em = Persistence
				.createEntityManagerFactory("PersonaJpa")
				.createEntityManager();
		
		Type type = this.getClass().getGenericSuperclass();

	    if (type instanceof ParameterizedType) {
	        ParameterizedType pt = (ParameterizedType) type;
	        Type[] fieldArgTypes = pt.getActualTypeArguments();
	        clase = (Class<T>) fieldArgTypes[0];
	    }
	}

	@Override
	protected void finalize() throws Throwable {
		if (em != null)
			em.close();
	}
	
	@Override
	public void agregar(T obj) {
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();

			em.persist(obj);
			
			et.commit();
		} catch (Exception e) {
			if (et != null)
				et.rollback();
		} 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> obtenerTodos() {
		Query q = em.createNamedQuery(clase.getSimpleName() + ".findAll");
		return (List<T>)q.getResultList();
	}

	@Override
	public void modificar(T obj) {
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();

			em.merge(obj);
			
			et.commit();
		} catch (Exception e) {
			if (et != null)
				et.rollback();
		} 
	}

	@Override
	public void eliminar(K clave) {
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			
			T obj = em.find(clase, clave);
			em.remove(obj);
			
			et.commit();
		} catch (Exception e) {
			if (et != null)
				et.rollback();
		} 

	}

	@Override
	public T obtener(K clave) {
		return em.find(clase, clave);
	}

}
