package es.indra.formacion.pr.persistence.servlet.ordenador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.indra.formacion.pr.persistence.model.Ordenador;
import es.indra.formacion.pr.persistence.model.Persona;
import es.indra.formacion.pr.persistence.service.IOrdenadorService;
import es.indra.formacion.pr.persistence.service.OrdenadorServiceFactory;

/**
 * Servlet implementation class AgregarOrdenadorServlet
 */
@WebServlet("/ordenador/Agregar")
public class AgregarOrdenadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarOrdenadorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IOrdenadorService ordenadorService = OrdenadorServiceFactory.createOrdenadorService();

		String nombre = request.getParameter("nombre");
		String serial = request.getParameter("serial");
		String spersonaId = request.getParameter("personaId");
		
		// TODO: Incluir validaciones!
		
		Persona p = new Persona();
		p.setId(Integer.parseInt(spersonaId));
		
		Ordenador o = new Ordenador();
		o.setNombre(nombre);
		o.setSerial(serial);
		o.setPersona(p);
		
		ordenadorService.agregarOrdenador(o);
		
		response.sendRedirect("Principal");
	}

}
