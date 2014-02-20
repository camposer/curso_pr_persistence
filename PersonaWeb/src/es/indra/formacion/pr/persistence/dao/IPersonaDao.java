package es.indra.formacion.pr.persistence.dao;

import java.util.List;

import es.indra.formacion.pr.persistence.model.Persona;

public interface IPersonaDao {
	public void agregar(Persona p);
	public List<Persona> obtenerTodos();
}
