package es.indra.formacion.pr.persistence.dao;

import java.util.List;

public interface IDao<T, K> {
	public void agregar(T obj);
	public void modificar(T obj);
	public void eliminar(K clave);
	public T obtener(K clave);
	public List<T> obtenerTodos();
}
