package models.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.dto.Persona;

class PersonaDaoTest {
	
	static PersonaDao dao = new PersonaDao();
	static ArrayList<Persona> personas = dao.readAll();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Hola");
		
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("nueva prueba");
	}

	@Test
	void testReadAll() {
		int cantidad = personas.size();
		assertEquals(2, cantidad);
	}
	
	@Test
	void testDelete() {
		boolean respuesta = dao.delete("2222-2");
		assertFalse(respuesta);
	}
	
	@Test
	void testBuscadaByEmail() {
		Persona p = new Persona("1111-1","Ines","Perado","ines.perado@correo.com",27,"Chile");
		dao.create(p);
		Persona buscada = dao.findByEmail("ines.perado@correo.com");
		assertEquals("ines.perado@correo.com", buscada.getEmail());
	}
	

}
