package es.indra.formacion.pr.persistence.servlet.ordenador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.indra.formacion.pr.persistence.service.IOrdenadorService;
import es.indra.formacion.pr.persistence.service.IPersonaService;
import es.indra.formacion.pr.persistence.service.OrdenadorServiceFactory;
import es.indra.formacion.pr.persistence.service.PersonaServiceFactory;

/**
 * Servlet implementation class PrincipalOrdenadorServlet
 */
@WebServlet("/ordenador/Principal")
public class PrincipalOrdenadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrincipalOrdenadorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IPersonaService personaService = PersonaServiceFactory.createPersonaService();
		IOrdenadorService ordenadorService = OrdenadorServiceFactory.createOrdenadorService();
		
		request.setAttribute("personas", personaService.obtenerPersonas());
		request.setAttribute("ordenadores", ordenadorService.obtenerOrdenadores());
		
		getServletContext()
			.getRequestDispatcher("/jsp/ordenador/principal.jsp")
			.forward(request, response);
	}

}
