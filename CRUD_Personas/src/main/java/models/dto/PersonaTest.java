package models.dto;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class PersonaTest {

	@Test
	void testConstructor() {
		Persona p = new Persona("1111-1","Ines","Perado","ines.perado@correo.com",27,"Chile");
		assertEquals(p.getClass(), Persona.class);
	}
	
	@Test
	void testGetNombre() {
		Persona p = new Persona("1111-1","Ines","Perado","ines.perado@correo.com",27,"Chile");
		assertEquals("Ines", p.getNombre());
	}
	
	
	
	

}
