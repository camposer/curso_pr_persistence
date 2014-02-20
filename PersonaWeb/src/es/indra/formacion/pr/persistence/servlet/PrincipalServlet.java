package es.indra.formacion.pr.persistence.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.indra.formacion.pr.persistence.model.Ordenador;
import es.indra.formacion.pr.persistence.model.Persona;


/**
 * Servlet implementation class PrincipalServlet
 */
@WebServlet("/Principal")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrincipalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = null;
		EntityManager em = null; // Equivalente a la Sesión de Hibernate (que envuelve una conexión)
		EntityTransaction et = null;

		try {
			emf = Persistence.createEntityManagerFactory("PersonaJpa");
			em = emf.createEntityManager(); // Equivalente a la Sesión de Hibernate (que envuelve una conexión)
			et = em.getTransaction();
			
			et.begin();
			
			/************** PERSIST **************/
			// INSERT
			Persona p = new Persona();
			p.setNombre("Juan");
			p.setApellido("Pérez");
			p.setFechaNacimiento(new Date());
			p.setAltura(180.0);
			em.persist(p); // Ahora p es un objeto Persistente!!
			
			// UPDATE
			p.setNombre("Juanito");
			em.persist(p); // Cambiará el nombre de Juan a Juanito!
			
			/*
			p = new Persona();
			p.setId(1);
			p.setNombre("Juan");
			p.setApellido("Pérez");
			p.setFechaNacimiento(new Date());
			p.setAltura(180.0);
			em.persist(p); // FALLA!
			*/

			p = em.find(Persona.class, 1); // Búsqueda la Persona con id = 1 
								// y devuelve un objeto persistente!!!
			p.setAltura(300.0);
			em.persist(p); // Actualiza!
			
			
			// DELETE
			/*
			p = new Persona();
			p.setId(1);
			em.remove(p); // FALLA! o no es persistente!!
			*/
			
			p = em.find(Persona.class, 5);
			if (p != null)
				em.remove(p); // Elimina el objeto
			

			/************** MERGE **************/
			// INSERT
			p = new Persona();
			p.setNombre("Juan");
			p.setApellido("Pérez");
			p.setFechaNacimiento(new Date());
			p.setAltura(180.0);
			Persona p2 = em.merge(p); // INSERTA! Luego, p seguirá siendo 
								// Transiente y p2 Persistente
			
			// UPDATE
			p2.setNombre("Fulanito");
			em.merge(p2); // Cambiará el nombre de Juan a Juanito!
			
			p = new Persona();
			p.setId(1);
			p.setNombre("Cambiado");
			p.setApellido("Otro");
			p.setFechaNacimiento(new Date());
			p.setAltura(180.0);
			p2 = em.merge(p); // Actualizaría este registro! p2 es persistente 
							// y p sigue siendo transiente 

			// SELECT *
			//Query q = em.createNamedQuery("Persona.findAll");
			Query q = em.createQuery("SELECT p FROM Persona p");
			q.setFirstResult(0); // Desde el primer registro
			q.setMaxResults(19); // 20 registros máximo
			
			// Todos los objetos que son devueltos aquí, son persistententes!!
			List<Persona> personas = (List<Persona>)q.getResultList(); 
			
			if (personas != null) for (Persona p1 : personas) {
				System.out.println();
				System.out.println("Persona");
				System.out.println("nombre = " + p1.getNombre());
				System.out.println("apellido = " + p1.getApellido());
				
				System.out.println("Estos son mis ordenadores: ");
				List<Ordenador> ordenadores = p1.getOrdenadores();
				if (ordenadores != null) for (Ordenador o : ordenadores) {
					System.out.println("nombre = " + o.getNombre());
					System.out.println("serial = " + o.getSerial());
				}
			}
			

			et.commit();
		} catch(PersistenceException pe) { // Excepción unchecked!!!
			if (et != null)
				et.rollback();
		} finally {
			if (em != null)
				em.close();
		}
	}

}
