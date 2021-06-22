package sitio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import publicacion.PrecioDiaOcupacion;
import publicacion.Publicacion;

class PaginaWebTest {
	PaginaWeb pag;
	Publicacion publicacion = mock(Publicacion.class);
	
	@BeforeEach
	void setUP() {
		pag = new PaginaWeb(publicacion);
	}
	
	@Test
	void testPaginaWeb() {
		assertEquals(pag.getClass(), PaginaWeb.class);
	}

	
	@Test
	void testGetPublicacion() {
		assertEquals(pag.getPublicacion().getClass(), Publicacion.class);
	}

	@Test
	void testNotificar() {
		PrecioDiaOcupacion precio = mock(PrecioDiaOcupacion.class);
		ArrayList<PrecioDiaOcupacion> precios = new ArrayList<PrecioDiaOcupacion>();
		precios.add(precio);
		when(publicacion.getPrecio()).thenReturn(precios);
		when(precio.getPrecio()).thenReturn(100.00);
		
		assertDoesNotThrow(() -> pag.notificar());
	}

}
