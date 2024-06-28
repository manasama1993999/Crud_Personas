package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.dao.PersonaDao;

import java.io.IOException;

public class EliminarPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PersonaDao dao = new PersonaDao();
       
    public EliminarPersonaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String rut = request.getParameter("rut");
			
			if (dao.delete(rut)) {
				request.getSession().setAttribute("mensaje", "Persona eliminada de las faz de la tierra correctamente.");
				response.sendRedirect("listado.jsp");
			}
			else {
				request.getSession().setAttribute("error", "Ups algo extraño pasó o la persona que intentas eliminar no existe en nuestros registros registrosos.");
				response.sendRedirect("listado.jsp");
			}
			
		} catch (Exception e) {
			request.getSession().setAttribute("error", "Se ha producido un error catastrófico");
			response.sendRedirect("listado.jsp");
		}
	}

}
