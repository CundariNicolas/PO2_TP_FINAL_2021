package calificacion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import categoria.Categoria;
import usuario.Usuario;

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
		int puntaje = 10;
		calificacion.setPuntaje(puntaje);
		assertEquals(puntaje, calificacion.getPuntaje());
	}
	
	@Test
	void sePuedeSetearUnUsuario() {
		calificacion.setOrigen(unUsuario);
		assertEquals(unUsuario, calificacion.getOrigen());
	}

}
