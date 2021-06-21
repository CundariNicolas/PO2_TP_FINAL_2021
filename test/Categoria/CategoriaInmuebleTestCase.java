package Categoria;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calificacion.Calificacion;
import categoria.Categoria;
import categoria.CategoriaInmueble;
import usuario.Usuario;

class CategoriaInmuebleTestCase {

	CategoriaInmueble limpieza;//SUT
	CategoriaInmueble instalaciones;//DOC
	CategoriaInmueble matenimiento;

	Calificacion unaCalificacion;//DOC
	Calificacion otraCalificacion;//DOC
	Calificacion calificacionDamian;//DOC
	
	Usuario unUsuario;//DOC
	Usuario otroUsuario;//DOC
	Usuario damian;//DOC
	
	@BeforeEach
	void setUp() throws Exception {
		limpieza = new CategoriaInmueble("limpieza");
		unaCalificacion = mock (Calificacion.class);
		otraCalificacion = mock (Calificacion.class);
		calificacionDamian = mock (Calificacion.class);
		unUsuario = mock (Usuario.class);
		otroUsuario = mock (Usuario.class);
		damian = mock (Usuario.class);
		
		instalaciones = mock (CategoriaInmueble.class);
		matenimiento = mock(CategoriaInmueble.class);
	}

	@Test
	void inicioSinCalificaciones() {
		assertEquals(0, limpieza.getCalificaciones().size());
	}
	
	@Test
	void sePuedeAgregarCalificaciones () {
		limpieza.addCalificacion(unUsuario, unaCalificacion);
		assertEquals(1, limpieza.getCalificaciones().size());
		limpieza.addCalificacion(otroUsuario, unaCalificacion);
		assertEquals(2, limpieza.getCalificaciones().size());
	}
	
	@Test
	void unMismoUsuarioNoPuedeAgregarMasDeUnaCalificacion() {
		assertEquals(0, limpieza.getCalificaciones().size());

		limpieza.addCalificacion(unUsuario, unaCalificacion);
		limpieza.addCalificacion(unUsuario, otraCalificacion);
		
		assertEquals(1, limpieza.getCalificaciones().size());		
	} 
	
	@Test
	 void seguardaCorrectamenteElNombreDeLaCategoria() {
		assertEquals("limpieza", limpieza.nombre());
	}
	
	@Test
	void calculaBienElPromedioDeCalificaciones() {
		int puntaje1 = 8;
		int puntaje2 = 5;
		double promedioBuscado = ((double)puntaje1 + (double)puntaje2) / 2;  
		when(otraCalificacion.getPuntaje()).thenReturn(puntaje2);
		when(unaCalificacion.getPuntaje()).thenReturn(puntaje1);
		limpieza.addCalificacion(otroUsuario, otraCalificacion);
		limpieza.addCalificacion(unUsuario, unaCalificacion);
		
		assertEquals(promedioBuscado,limpieza.promedioDePuntaje());
	}
	@Test
	void veoCorrectamenteLaCalificacionDeUnUsuario() {
		limpieza.addCalificacion(unUsuario, unaCalificacion);
		assertEquals(unaCalificacion,limpieza.verCalificacionDeUn(unUsuario));
	}
	
	@Test
	void unaCategoriaEsIgualASiMisma() {
		assertTrue(limpieza.esIgualA(limpieza));
	}
	@Test
	void unaCategoriaEsDiferenteAOtra() {
		assertFalse(limpieza.esIgualA(instalaciones));
	}
	
	@Test
	void enUnArrayDeCategoriasDevuelveALaCategoriaBuscada() {
		Set <Categoria> listaCategoria;
		listaCategoria = new HashSet<Categoria>();
		listaCategoria.add(instalaciones);
		listaCategoria.add(limpieza);
		
		assertEquals(limpieza,limpieza.estasEn(listaCategoria));
		assertNotEquals(matenimiento, limpieza.estasEn(listaCategoria));	
	}
	
	@Test
	void sePuedeTomarLasCalificacionesLasCalificaciones() {
		
		limpieza.addCalificacion(unUsuario, unaCalificacion);
		limpieza.addCalificacion(otroUsuario, otraCalificacion);
		
		Map<Usuario,Calificacion> resultado = limpieza.getCalificaciones();
		
		assertTrue(resultado.containsKey(unUsuario));
		assertEquals(unaCalificacion,resultado.get(unUsuario));
		
		assertTrue(resultado.containsKey(otroUsuario));
		assertEquals(otraCalificacion,resultado.get(otroUsuario));

		assertFalse(resultado.containsKey(damian));
		
	}
}
