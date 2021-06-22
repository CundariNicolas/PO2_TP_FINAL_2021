package categoria;

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
import categoria.CategoriaUsuario;
import usuario.Usuario;

class CategoriaUsuarioTestCase {

	CategoriaUsuario puntualidad;//SUT
	CategoriaUsuario vestimenta;//DOC
	CategoriaUsuario prolijidad;

	Calificacion unaCalificacion;//DOC
	Calificacion otraCalificacion;//DOC
	Calificacion calificacionDamian;//DOC
	
	Usuario unUsuario;//DOC
	Usuario otroUsuario;//DOC
	Usuario damian;//DOC
	
	@BeforeEach
	void setUp() throws Exception {
		puntualidad = new CategoriaUsuario("puntualidad");
		unaCalificacion = mock (Calificacion.class);
		otraCalificacion = mock (Calificacion.class);
		calificacionDamian = mock (Calificacion.class);
		unUsuario = mock (Usuario.class);
		otroUsuario = mock (Usuario.class);
		damian = mock (Usuario.class);
		
		vestimenta = mock (CategoriaUsuario.class);
		prolijidad = mock(CategoriaUsuario.class);
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
	void veoCorrectamenteLaCalificacionDeUnUsuario() {
		puntualidad.addCalificacion(unUsuario, unaCalificacion);
		assertEquals(unaCalificacion,puntualidad.verCalificacionDeUn(unUsuario));
	}
	
	@Test
	void unaCategoriaEsIgualASiMisma() {
		assertTrue(puntualidad.esIgualA(puntualidad));
	}
	@Test
	void unaCategoriaEsDiferenteAOtra() {
		assertFalse(puntualidad.esIgualA(vestimenta));
	}
	
	@Test
	void enUnArrayDeCategoriasDevuelveALaCategoriaBuscada() {
		Set <Categoria> listaCategoria;
		listaCategoria = new HashSet<Categoria>();
		listaCategoria.add(vestimenta);
		listaCategoria.add(puntualidad);
		
		assertEquals(puntualidad,puntualidad.estasEn(listaCategoria));
		assertNotEquals(prolijidad, puntualidad.estasEn(listaCategoria));	
	}
	
	@Test
	void sePuedeTomarLasCalificacionesLasCalificaciones() {
		
		puntualidad.addCalificacion(unUsuario, unaCalificacion);
		puntualidad.addCalificacion(otroUsuario, otraCalificacion);
		
		Map<Usuario,Calificacion> resultado = puntualidad.getCalificaciones();
		
		assertTrue(resultado.containsKey(unUsuario));
		assertEquals(unaCalificacion,resultado.get(unUsuario));
		
		assertTrue(resultado.containsKey(otroUsuario));
		assertEquals(otraCalificacion,resultado.get(otroUsuario));

		assertFalse(resultado.containsKey(damian));
		
	}
}
