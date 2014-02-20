package es.indra.formacion.pr.persistence.dao;

import java.util.Date;

import es.indra.formacion.pr.persistence.model.Persona;

public class PersonaDaoTest {
	public static void main(String[] args) {
		IPersonaDao personaDao = PersonaDaoFactory.createPersonaDao();
		
		Persona p = new Persona(
				"María",
				"García",
				new Date(),
				160.0
				);
		
		// Probando el obtenerTodos
		System.out.println(personaDao.obtenerTodos());

		// Probando agregar
		personaDao.agregar(p);
		
		// Probando el obtenerTodos
		System.out.println(personaDao.obtenerTodos());
	}
}
