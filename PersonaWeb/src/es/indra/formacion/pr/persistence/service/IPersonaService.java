package es.indra.formacion.pr.persistence.service;

import java.util.List;

import es.indra.formacion.pr.persistence.model.Persona;

public interface IPersonaService {
	public void agregarPersona(Persona p);
	public List<Persona> obtenerPersonas();
}
