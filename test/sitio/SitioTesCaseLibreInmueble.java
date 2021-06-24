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
			// 3 unInmuebles libres
			Inmueble unInmueble1 = mock (Inmueble.class);
			Inmueble unInmueble2 = mock (Inmueble.class);
			Inmueble unInmueble3 = mock (Inmueble.class);
			
			Usuario unUsuario1 = mock(Usuario.class);
			Usuario unUsuario2 = mock(Usuario.class);
			Usuario unUsuario3 = mock(Usuario.class);
			Usuario unUsuario4 = mock(Usuario.class);
			Usuario unUsuario5 = mock(Usuario.class);
			
			sitio.addUsuario(unUsuario1);
			sitio.addUsuario(unUsuario2);
			sitio.addUsuario(unUsuario3);
			sitio.addUsuario(unUsuario4);
			sitio.addUsuario(unUsuario5);
			
			
			List<Publicacion> unaLista1 = new ArrayList<>();
			Publicacion unaPublicacion1 = mock(Publicacion.class);
			unaLista1.add(unaPublicacion1);
			
			List<Publicacion> unaLista2 = new ArrayList<>();
			Publicacion unaPublicacion2 = mock(Publicacion.class);
			Publicacion unaPublicacion3 = mock(Publicacion.class);
			when(unaPublicacion2.disponibleHoy()).thenReturn(true);
			when(unaPublicacion1.getInmueble()).thenReturn(unInmueble1);
			unaLista2.add(unaPublicacion2);
			unaLista2.add(unaPublicacion3);
			
			List<Publicacion> unaLista3 = new ArrayList<>();
			Publicacion unaPublicacion4= mock(Publicacion.class);
			Publicacion unaPublicacion5 = mock(Publicacion.class);
			Publicacion unaPublicacion6= mock(Publicacion.class);
			Publicacion unaPublicacion7= mock(Publicacion.class);
			unaLista3.add(unaPublicacion7);
			unaLista3.add(unaPublicacion6);
			unaLista3.add(unaPublicacion5);
			unaLista3.add(unaPublicacion4);
			
			List<Publicacion> unaLista4 = new ArrayList<>();
			Publicacion unaPublicacion8 = mock(Publicacion.class);
			Publicacion unaPublicacion9 = mock(Publicacion.class);
			unaLista4.add(unaPublicacion8);
			unaLista4.add(unaPublicacion9);
			
			when(unUsuario1.getPublicaciones()).thenReturn(unaLista1);
			when(unUsuario2.getPublicaciones()).thenReturn(unaLista2);
			when(unUsuario3.getPublicaciones()).thenReturn(unaLista3);
			when(unUsuario4.getPublicaciones()).thenReturn(unaLista4);
			
			
			when(unaPublicacion6.disponibleHoy()).thenReturn(true);
			when(unaPublicacion1.disponibleHoy()).thenReturn(true);
			when(unaPublicacion3.disponibleHoy()).thenReturn(true);
			
			
			when(unaPublicacion6.getInmueble()).thenReturn(unInmueble3);		
			when(unaPublicacion1.getInmueble()).thenReturn(unInmueble1);
			when(unaPublicacion3.getInmueble()).thenReturn(unInmueble2);
			
			
			when(unaPublicacion2.disponibleHoy()).thenReturn(false);
			when(unaPublicacion4.disponibleHoy()).thenReturn(false);
			when(unaPublicacion5.disponibleHoy()).thenReturn(false);
			when(unaPublicacion7.disponibleHoy()).thenReturn(false);
			when(unaPublicacion8.disponibleHoy()).thenReturn(false);
			when(unaPublicacion9.disponibleHoy()).thenReturn(false);
			
			
			assertEquals(3, sitio.inmueblesLibresHoy().size());
	}

}
