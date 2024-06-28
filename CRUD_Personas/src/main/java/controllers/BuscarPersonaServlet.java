package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.dao.PersonaDao;
import models.dto.Persona;

import java.io.IOException;

public class BuscarPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PersonaDao dao = new PersonaDao();
       
    public BuscarPersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String rut = request.getParameter("rut");
			Persona persona = null;
			
			if (rut != null) {
				persona = dao.read(rut);
				if (persona != null) {
					request.setAttribute("personaBuscada", persona);
				}
				else {
					request.setAttribute("error", "No existe una persona con el rut indicado en nuestros registros");
					response.sendRedirect("listado.jsp");
				}
			}
			else {
				request.setAttribute("error", "Debes ingresar un rut para buscar");
				response.sendRedirect("listado.jsp");
			}
			
		} catch (Exception e) {
			request.setAttribute("error", "Se ha producido un error catastrófico");
			response.sendRedirect("listado.jsp");
		}
	}

}
