package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.dao.PersonaDao;
import models.dto.Persona;

import java.io.IOException;

public class ModificarPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PersonaDao dao = new PersonaDao();
       
    public ModificarPersonaServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String rut = request.getParameter("txtRutBuscado");
			String nombre = request.getParameter("txtNombre");
			String apellido = request.getParameter("txtApellido");
			String email = request.getParameter("txtEmail");
			int edad = Integer.parseInt(request.getParameter("txtEdad"));
			String pais = request.getParameter("txtPais");
			
			Persona p_update = new Persona(rut, nombre, apellido, email, edad, pais);
			System.out.println(p_update);
			
			if (dao.update(p_update)) {
				request.getSession().setAttribute("mensaje", "Datos de la persona actualizados correctamente");
				response.sendRedirect("listado.jsp");
			}
			else {
				request.getSession().setAttribute("error", "No se logró completar el proceso de actualización");
				response.sendRedirect("index.jsp");
			}
		} catch (Exception e) {
			request.getSession().setAttribute("error", "Se ha producido un error catastrófico");
			response.sendRedirect("listado.jsp");
		}
	}

}
