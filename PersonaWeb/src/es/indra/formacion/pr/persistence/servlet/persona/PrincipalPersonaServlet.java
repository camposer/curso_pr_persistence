package es.indra.formacion.pr.persistence.servlet.persona;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.indra.formacion.pr.persistence.service.IPersonaService;
import es.indra.formacion.pr.persistence.service.PersonaServiceFactory;


/**
 * Servlet implementation class PrincipalServlet
 */
@WebServlet("/persona/Principal")
public class PrincipalPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrincipalPersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IPersonaService personaService = PersonaServiceFactory.createPersonaService();
		
		request.setAttribute("personas", personaService.obtenerPersonas());
		getServletContext()
			.getRequestDispatcher("/jsp/persona/principal.jsp")
			.forward(request, response);
	}

}
