package sitio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import publicacion.Publicacion;

class CriterioTestCase {
	
	ArrayList<Publicacion> publicaciones;
	Publicacion publicacion1;
	Publicacion publicacion2;
	Publicacion publicacion3;
	Publicacion publicacion4;
	Publicacion publicacion5;
	Publicacion publicacion6;

	@BeforeEach
	void setUp() throws Exception {
		publicacion1 = mock(Publicacion.class);
		publicacion2 = mock(Publicacion.class);
		publicacion3 = mock(Publicacion.class);
		publicacion4 = mock(Publicacion.class);
		publicacion5 = mock(Publicacion.class);
		publicacion6 = mock(Publicacion.class);
		
		publicaciones.add(publicacion1);
		publicaciones.add(publicacion2);
		publicaciones.add(publicacion3);
		publicaciones.add(publicacion4);
		publicaciones.add(publicacion5);
		publicaciones.add(publicacion6);
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
