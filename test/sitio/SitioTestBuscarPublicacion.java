package sitio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inmueble.Inmueble;
import publicacion.Publicacion;
import reserva.Reserva;
import usuario.Usuario;

class SitioTestBuscarPublicacion {
	Sitio sitio;
	
	Reserva reserva = mock(Reserva.class);
	Publicacion publicacion = mock(Publicacion.class);
	ObserverManager manager = mock(ObserverManager.class);
	
	Publicacion publicacion1 = mock(Publicacion.class);
	Publicacion publicacion2 = mock(Publicacion.class);
	Publicacion publicacion3 = mock(Publicacion.class);
	Publicacion publicacion4 = mock(Publicacion.class);


	@BeforeEach
	void setUp() throws Exception {
		sitio = Sitio.getInstance();
	}

	@Test
	void testBuscarPublicacion() {
		CriterioBasico criterio;
		ArrayList<Publicacion> publicaciones;

		Calendar fecha1;
		Calendar fecha2;
		Usuario usuario;
		
	
		
		fecha1 = mock(Calendar.class);
		fecha2 = mock(Calendar.class);
		
		
		usuario = mock(Usuario.class);

		
		publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(publicacion1);
		publicaciones.add(publicacion2);
		publicaciones.add(publicacion3);
		publicaciones.add(publicacion4);

		
		
		criterio = new CriterioBasico("Quilmes", fecha1, fecha2);

		
		when(publicacion1.getCiudadInmueble()).thenReturn("Quilmes");
		when(publicacion2.getCiudadInmueble()).thenReturn("Quilmes");
		when(publicacion3.getCiudadInmueble()).thenReturn("Quilmes");
		when(publicacion1.estaLibreEntre(fecha1, fecha2)).thenReturn(true);
		when(publicacion2.estaLibreEntre(fecha1, fecha2)).thenReturn(true);
		when(publicacion3.estaLibreEntre(fecha1, fecha2)).thenReturn(false);
		when(usuario.getPublicaciones()).thenReturn(publicaciones);		
		
		
		sitio.addUsuario(usuario);
		
		
		
		assertEquals(2, sitio.buscarPublicacion(criterio).size());
		
		
		
	}
}
