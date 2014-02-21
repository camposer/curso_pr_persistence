package es.indra.formacion.pr.persistence.service;

import java.util.List;

import es.indra.formacion.pr.persistence.model.Ordenador;

public interface IOrdenadorService {
	public void agregarOrdenador(Ordenador o);
	public List<Ordenador> obtenerOrdenadores();
}
