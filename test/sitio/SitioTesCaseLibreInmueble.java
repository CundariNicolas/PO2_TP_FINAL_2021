package sitio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inmueble.Inmueble;
import publicacion.Publicacion;
import usuario.Usuario;

class SitioTesCaseLibreInmueble {

	Sitio sitio;
	
	@BeforeEach
	void setUp() throws Exception {
		sitio= Sitio.getInstance();
	}

	@Test
	void testInmueblesLibreshoy() {
		// 3 inmuebles libres
		Inmueble inmueble1 = mock (Inmueble.class);
		Inmueble inmueble2 = mock (Inmueble.class);
		Inmueble inmueble3 = mock (Inmueble.class);
		
		Usuario usuario1 = mock(Usuario.class);
		Usuario usuario2 = mock(Usuario.class);
		Usuario usuario3 = mock(Usuario.class);
		Usuario usuario4 = mock(Usuario.class);
		Usuario usuario5 = mock(Usuario.class);
		
		sitio.addUsuario(usuario1);
		sitio.addUsuario(usuario2);
		sitio.addUsuario(usuario3);
		sitio.addUsuario(usuario4);
		sitio.addUsuario(usuario5);
		
		
		List<Publicacion> lista1 = new ArrayList<>();
		Publicacion publicacion1 = mock(Publicacion.class);
		lista1.add(publicacion1);
		
		List<Publicacion> lista2 = new ArrayList<>();
		Publicacion publicacion2 = mock(Publicacion.class);
		Publicacion publicacion3 = mock(Publicacion.class);
		when(publicacion2.disponibleHoy()).thenReturn(true);
		when(publicacion1.getInmueble()).thenReturn(inmueble1);
		lista2.add(publicacion2);
		lista2.add(publicacion3);
		
		List<Publicacion> lista3 = new ArrayList<>();
		Publicacion publicacion4= mock(Publicacion.class);
		Publicacion publicacion5 = mock(Publicacion.class);
		Publicacion publicacion6= mock(Publicacion.class);
		Publicacion publicacion7= mock(Publicacion.class);
		lista3.add(publicacion7);
		lista3.add(publicacion6);
		lista3.add(publicacion5);
		lista3.add(publicacion4);
		
		List<Publicacion> lista4 = new ArrayList<>();
		Publicacion publicacion8 = mock(Publicacion.class);
		Publicacion publicacion9 = mock(Publicacion.class);
		lista4.add(publicacion8);
		lista4.add(publicacion9);
		
		when(usuario1.getPublicaciones()).thenReturn(lista1);
		when(usuario2.getPublicaciones()).thenReturn(lista2);
		when(usuario3.getPublicaciones()).thenReturn(lista3);
		when(usuario4.getPublicaciones()).thenReturn(lista4);
		
		
		when(publicacion6.disponibleHoy()).thenReturn(true);
		when(publicacion1.disponibleHoy()).thenReturn(true);
		when(publicacion3.disponibleHoy()).thenReturn(true);
		
		
		when(publicacion6.getInmueble()).thenReturn(inmueble3);		
		when(publicacion1.getInmueble()).thenReturn(inmueble1);
		when(publicacion3.getInmueble()).thenReturn(inmueble2);
		
		
		when(publicacion2.disponibleHoy()).thenReturn(false);
		when(publicacion4.disponibleHoy()).thenReturn(false);
		when(publicacion5.disponibleHoy()).thenReturn(false);
		when(publicacion7.disponibleHoy()).thenReturn(false);
		when(publicacion8.disponibleHoy()).thenReturn(false);
		when(publicacion9.disponibleHoy()).thenReturn(false);
		
		
		assertEquals(3, sitio.inmueblesLibresHoy().size());
	}

}
