package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.dao.PersonaDao;
import models.dto.Persona;

import java.io.IOException;
import java.util.ArrayList;


public class ListarPersonaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private PersonaDao dao = new PersonaDao();
	
    public ListarPersonaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<Persona> personas = new ArrayList<Persona>();
			personas = dao.readAll();
			request.setAttribute("personas", personas);			
		} catch (Exception e) {
			request.getSession().setAttribute("error", "Se ha producido un problema de conexión con la base de datos.");
		}
	}

	

}
