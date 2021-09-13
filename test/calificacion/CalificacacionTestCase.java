package calificacion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import categoria.Categoria;
import usuario.Usuario;
//Test Prueba
class CalificacacionTestCase {

	Calificacion calificacion;//SUT
	Categoria unaCategoria;//DOC
	Usuario unUsuario; //DOC
	@BeforeEach
	void setUp() throws Exception { 
		unaCategoria = mock(Categoria.class);
		unUsuario = mock (Usuario.class);
		calificacion = new Calificacion(unaCategoria);
		
	}

	@Test
	void sePuedeSetearUnaComentario() {
		calificacion.setComentario("Es muy buena");
		assertEquals("Es muy buena", calificacion.getComentario());
	}
	
	@Test
	void sePuedeSetearUnPuntaje() {
		int puntaje = 5;
		calificacion.setPuntaje(puntaje);
		assertEquals(puntaje, calificacion.getPuntaje());
	}
	
	@Test
	void sePuedeSetearUnUsuario() {
		calificacion.setOrigen(unUsuario);
		assertEquals(unUsuario, calificacion.getOrigen());
	}
	
	@Test
	void noSePuedeCalificarFueraDelRango() {
		int puntajeCorrecto = 4;
		int valorErroneo1 = 0;
		int valorErroneo2 = 6;
		int valorErroneo3 = -1;
		calificacion.setPuntaje(puntajeCorrecto);
		
		calificacion.setPuntaje(valorErroneo1);
		assertEquals(puntajeCorrecto, calificacion.getPuntaje());
		
		calificacion.setPuntaje(valorErroneo2);
		assertEquals(puntajeCorrecto, calificacion.getPuntaje());
		
		calificacion.setPuntaje(valorErroneo3);
		assertEquals(puntajeCorrecto, calificacion.getPuntaje());
		
	}
	
	@Test
	void seObtieneLaCategoriaCreada() {
		assertEquals(unaCategoria, calificacion.getCategoria());
	}

}
