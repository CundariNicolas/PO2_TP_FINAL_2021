package sitio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inmueble.Inmueble;
import publicacion.Publicacion;
import reserva.Reserva;
import usuario.Usuario;

class SitioTest {
	Sitio sitio;
	
	Reserva reserva = mock(Reserva.class);
	Publicacion publicacion = mock(Publicacion.class);
	ObserverManager manager = mock(ObserverManager.class);
	
	Publicacion publicacion1 = mock(Publicacion.class);
	Publicacion publicacion2 = mock(Publicacion.class);
	Publicacion publicacion3 = mock(Publicacion.class);
	Publicacion publicacion4 = mock(Publicacion.class);

	@BeforeEach
	void setUP() {
		sitio = Sitio.getInstance();
	}
	
	@Test
	void testGetInstance() {
		assertEquals(sitio.getClass(), Sitio.class);
	}

	@Test
	void testAddUsuario() {
		Usuario usuario1 = mock(Usuario.class);
		
		assertDoesNotThrow(() -> sitio.addUsuario(usuario1));
	}

	@Test
	void testProcesarReservaCancelada() {
		when(reserva.getPublicacion()).thenReturn(publicacion);
		
		sitio.procesarReservaCancelada(reserva);
		verify(publicacion, times(1)).aplicarPoliticaCancelacion(reserva);
	}

	@Test
	void testTopTenInquilinos() {
		Usuario usuario1 = mock(Usuario.class);
		Usuario usuario2 = mock(Usuario.class);
		Usuario usuario3 = mock(Usuario.class);
		Usuario usuario4 = mock(Usuario.class);
		Usuario usuario5 = mock(Usuario.class);
		Usuario usuario6 = mock(Usuario.class);
		Usuario usuario7 = mock(Usuario.class);
		Usuario usuario8 = mock(Usuario.class);
		Usuario usuario9 = mock(Usuario.class);
		Usuario usuario10 = mock(Usuario.class);
		Usuario usuario11 = mock(Usuario.class);
		Usuario usuario12 = mock(Usuario.class);
		
		when(usuario1.cantidadDeAlquileres()).thenReturn(2);
		when(usuario2.cantidadDeAlquileres()).thenReturn(5);
		when(usuario3.cantidadDeAlquileres()).thenReturn(200);
		when(usuario4.cantidadDeAlquileres()).thenReturn(40);
		when(usuario5.cantidadDeAlquileres()).thenReturn(20);
		when(usuario6.cantidadDeAlquileres()).thenReturn(50);
		when(usuario7.cantidadDeAlquileres()).thenReturn(2000);
		when(usuario8.cantidadDeAlquileres()).thenReturn(400);
		when(usuario9.cantidadDeAlquileres()).thenReturn(22);
		when(usuario10.cantidadDeAlquileres()).thenReturn(55);
		when(usuario11.cantidadDeAlquileres()).thenReturn(202);
		when(usuario12.cantidadDeAlquileres()).thenReturn(404);
		
		sitio.addUsuario(usuario1);
		sitio.addUsuario(usuario2);
		sitio.addUsuario(usuario3);
		sitio.addUsuario(usuario4);
		sitio.addUsuario(usuario5);
		sitio.addUsuario(usuario6);
		sitio.addUsuario(usuario7);
		sitio.addUsuario(usuario8);
		sitio.addUsuario(usuario9);
		sitio.addUsuario(usuario10);
		sitio.addUsuario(usuario11);
		sitio.addUsuario(usuario12);
	
		
		assertEquals(sitio.topTenInquilinos().size(), 10);
		assertEquals(sitio.topTenInquilinos().get(0).cantidadDeAlquileres(), 2000);
		assertEquals(sitio.topTenInquilinos().get(1).cantidadDeAlquileres(), 404);
		assertEquals(sitio.topTenInquilinos().get(2).cantidadDeAlquileres(), 400);
		assertEquals(sitio.topTenInquilinos().get(3).cantidadDeAlquileres(), 202);
	}
	
	
	
	
	
	@Test
	void testTasaDeOcupacion() {
		
		
		
		Sitio sitio1 = Sitio.getInstance();
		
		Calendar fecha1 = mock(Calendar.class);
		
		Usuario usuario1 = mock(Usuario.class);
		Usuario usuario2 = mock(Usuario.class);
		Usuario usuario3 = mock(Usuario.class);
		Usuario usuario4 = mock(Usuario.class);
		
		ArrayList<Publicacion> publicaciones1= new ArrayList<Publicacion>();
		ArrayList<Publicacion> publicaciones2= new ArrayList<Publicacion>();
		ArrayList<Publicacion> publicaciones3= new ArrayList<Publicacion>();
		ArrayList<Publicacion> publicaciones4= new ArrayList<Publicacion>();
		
		publicaciones1.add(publicacion1);
		publicaciones2.add(publicacion2);
		publicaciones3.add(publicacion3);
		publicaciones4.add(publicacion4);
		
		when(usuario1.getPublicaciones()).thenReturn(publicaciones1);
		when(usuario2.getPublicaciones()).thenReturn(publicaciones2);
		when(usuario3.getPublicaciones()).thenReturn(publicaciones3);
		when(usuario4.getPublicaciones()).thenReturn(publicaciones4);
		
		when(publicacion1.disponibleHoy(fecha1)).thenReturn(false);
		when(publicacion2.disponibleHoy(fecha1)).thenReturn(true);
		when(publicacion3.disponibleHoy(fecha1)).thenReturn(true);
		when(publicacion4.disponibleHoy(fecha1)).thenReturn(true);
	
		
		
		
		sitio1.addUsuario(usuario1);
		sitio1.addUsuario(usuario2);
		sitio1.addUsuario(usuario3);
		sitio1.addUsuario(usuario4);
		
		assertEquals(3, sitio1.cantidadDeDisponiblesHoy(fecha1));
		assertEquals(4, sitio1.todasLasPublicaciones());
		assertEquals(0.25, sitio1.tasaDeOcupacion(fecha1));

	}
}
