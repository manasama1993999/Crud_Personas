package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.dao.PersonaDao;
import models.dto.Persona;
import models.utils.Validaciones;

import java.io.IOException;
import java.util.ArrayList;


public class RegistrarPersonaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private PersonaDao dao = new PersonaDao();
	ArrayList<String> errores = new ArrayList<String>();   

    public RegistrarPersonaServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getSession().setAttribute("errores", null);
		response.sendRedirect("registro.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String mensaje = null;
			String error = null;
			
			String rut = request.getParameter("txtRut");
			String nombre = request.getParameter("txtNombre");
			String apellido = request.getParameter("txtApellido");
			String email = request.getParameter("txtEmail");
			int edad = Integer.parseInt(request.getParameter("txtEdad"));
			String pais = request.getParameter("txtPais");
			
			Validaciones validar = new Validaciones();
			
			if (validar.validarRut(rut) == false) {
				errores.add("Rut no válido.");
			}
			if (validar.validarEmail(email) == false) {
				errores.add("Email no válido.");
			}
			if (nombre.trim().length() == 0 || nombre.trim().length() > 30) {
				errores.add("El nombre debe contener entre 1 y 30 caracteres");
			}
			if (apellido.trim().length() == 0 || apellido.trim().length() > 30) {
				errores.add("El apellido debe contener entre 1 y 30 caracteres");
			}
			
			if (errores.size() == 0) {
				Persona p = new Persona(rut, nombre, apellido, email, edad, pais);
				
				Persona p_rut = dao.read(p.getRut());
				Persona p_email = dao.findByEmail(p.getEmail());
				
				if(p_rut != null || p_email != null) {
					request.getSession().setAttribute("error", "Usuario ya registrado");
					request.getSession().setAttribute("errores", null);
					response.sendRedirect("registro.jsp");
				}
				else {
					if (dao.create(p) == 1) {
						request.getSession().setAttribute("mensaje", "Persona registrada satisfactoriamente");
						response.sendRedirect("listado.jsp");
					}
					else {
						request.getSession().setAttribute("error", "Persona no registrada. Inténtelo más rato.");
						response.sendRedirect("registro.jsp");
					}
				}
			}
			else {
				request.getSession().setAttribute("errores", errores);
				response.sendRedirect("registro.jsp");
			}
		} catch (Exception e) {
			response.sendRedirect("registro.jsp");
		}
		
	}

}
