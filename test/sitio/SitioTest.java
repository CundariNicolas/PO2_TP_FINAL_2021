package sitio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import publicacion.Publicacion;
import reserva.Reserva;
import usuario.Usuario;

class SitioTest {
	Sitio sitio;
	
	Reserva reserva = mock(Reserva.class);
	Publicacion publicacion = mock(Publicacion.class);
	ObserverManager manager = mock(ObserverManager.class);

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
		
		System.out.println("size " + sitio.topTenInquilinos().size());
		System.out.println("0 cantidad=" + sitio.topTenInquilinos().get(0).cantidadDeAlquileres());
		System.out.println("1 cantidad=" + sitio.topTenInquilinos().get(1).cantidadDeAlquileres());
		System.out.println("2 cantidad=" + sitio.topTenInquilinos().get(2).cantidadDeAlquileres());
		System.out.println("3 cantidad=" + sitio.topTenInquilinos().get(3).cantidadDeAlquileres());
		
		assertEquals(sitio.topTenInquilinos().size(), 10);
		assertEquals(sitio.topTenInquilinos().get(0).cantidadDeAlquileres(), 2000);
		assertEquals(sitio.topTenInquilinos().get(1).cantidadDeAlquileres(), 404);
		assertEquals(sitio.topTenInquilinos().get(2).cantidadDeAlquileres(), 400);
		assertEquals(sitio.topTenInquilinos().get(3).cantidadDeAlquileres(), 202);
	}

}
