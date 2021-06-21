package Categoria;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calificacion.Calificacion;
import categoria.CategoriaUsuario;
import usuario.Usuario;

class CategoriaInmuebleTestCase {

	CategoriaUsuario puntualidad;//SUT
	Calificacion unaCalificacion;//DOC
	Calificacion otraCalificacion;//DOC
	Usuario unUsuario;
	Usuario otroUsuario;
	
	@BeforeEach
	void setUp() throws Exception {
		puntualidad = new CategoriaUsuario("puntualidad");
		unaCalificacion = mock (Calificacion.class);
		otraCalificacion = mock (Calificacion.class);
		unUsuario = mock (Usuario.class);
		otroUsuario = mock (Usuario.class);
	}

	@Test
	void inicioSinCalificaciones() {
		assertEquals(0, puntualidad.getCalificaciones().size());
	}
	
	@Test
	void sePuedeAgregarCalificaciones () {
		puntualidad.addCalificacion(unUsuario, unaCalificacion);
		assertEquals(1, puntualidad.getCalificaciones().size());
		puntualidad.addCalificacion(otroUsuario, unaCalificacion);
		assertEquals(2, puntualidad.getCalificaciones().size());
	}
	
	@Test
	void unMismoUsuarioNoPuedeAgregarMasDeUnaCalificacion() {
		assertEquals(0, puntualidad.getCalificaciones().size());

		puntualidad.addCalificacion(unUsuario, unaCalificacion);
		puntualidad.addCalificacion(unUsuario, otraCalificacion);
		
		assertEquals(1, puntualidad.getCalificaciones().size());		
	} 
	
	@Test
	 void seguardaCorrectamenteElNombreDeLaCategoria() {
		assertEquals("puntualidad", puntualidad.nombre());
	}
	
	@Test
	void calculaBienElPromedioDeCalificaciones() {
		int puntaje1 = 8;
		int puntaje2 = 5;
		double promedioBuscado = ((double)puntaje1 + (double)puntaje2) / 2;  
		when(otraCalificacion.getPuntaje()).thenReturn(puntaje2);
		when(unaCalificacion.getPuntaje()).thenReturn(puntaje1);
		puntualidad.addCalificacion(otroUsuario, otraCalificacion);
		puntualidad.addCalificacion(unUsuario, unaCalificacion);
		
		assertEquals(promedioBuscado,puntualidad.promedioDePuntaje());
	}
	@Test
	void
	
	

}
