
package usuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inmueble.Inmueble;
import publicacion.Publicacion;
import reserva.Reserva;
import sitio.Calificacion;

class UsuarioTest {
	private Usuario pedroRuiz;
	
	private Reserva reserva1;
	private Reserva reserva2;
	private Reserva reserva3;
	private Publicacion publicacion1;
	private Publicacion publicacion2;
	private Publicacion publicacion3;
	private Inmueble inmueble1;
	private Inmueble inmueble2;
	private Inmueble inmueble3;
	private Calificacion calificacion1;
	private Calificacion calificacion2;

	
	@BeforeEach
    public void setUp() throws Exception {
		//Se crea el usuario
        pedroRuiz = new Usuario("Pedro", "Ruiz","Av. Rivadavia 100", "pedroRuiz@gmail.com", 42229000);
        //pedroRuiz.addReserva(reserva1);
        pedroRuiz.addPublicacion(publicacion1);
        pedroRuiz.addCAlificacion(calificacion1);
    }
	
	@Test
	void testUsuario() {
		assertEquals(pedroRuiz.getClass(), Usuario.class);
	}

	@Test
	void testGetNombre() {
		String nombre = pedroRuiz.getNombre();
        assertEquals(nombre, "Pedro");
	}

	@Test
	void testGetApellido() {
		String apellido = pedroRuiz.getApellido();
        assertEquals(apellido, "Ruiz");
	}

	@Test
	void testGetNombreYApellido() {
		String nomApe = pedroRuiz.getNombreYApellido();
        assertEquals(nomApe, "Pedro Ruiz");
	}

	@Test
	void testGetDomicilio() {
        String domicilio = pedroRuiz.getDomicilio();
        assertEquals(domicilio, "Av. Rivadavia 100");
	}

	@Test
	void testGeteMail() {
		String mail = pedroRuiz.geteMail();
        assertEquals(mail, "pedroRuiz@gmail.com");
	}

	@Test
	void testGetTelefono() {
		Integer telefono = pedroRuiz.getTelefono();
        assertEquals(telefono, 42229000);
	}

	@Test
	void testGetFechaDeIngreso() {
		assertEquals(pedroRuiz.getFechaDeIngreso().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.YEAR));
		assertEquals(pedroRuiz.getFechaDeIngreso().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.MONTH));
		assertEquals(pedroRuiz.getFechaDeIngreso().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
	}

	@Test
	void testGetPublicaciones() {
		assertEquals(pedroRuiz.getPublicaciones().size(), 1);
	}

	@Test
	void testGetCalificaciones() {
		assertEquals(pedroRuiz.getCalificaciones().size(), 1);
	}

	@Test
	void testAddCAlificacion() {
		pedroRuiz.addCAlificacion(calificacion2);
		assertEquals(pedroRuiz.getCalificaciones().size(), 2);
	}

	@Test
	void testAddPublicacion() {
		pedroRuiz.addPublicacion(publicacion2);
		assertEquals(pedroRuiz.getPublicaciones().size(), 2);
	}

	@Test
	void testTodasLasReservas() {
		pedroRuiz.addReserva(reserva1);
		pedroRuiz.addReserva(reserva2);
		pedroRuiz.addReserva(reserva3);
		assertEquals(pedroRuiz.todasLasReservas().size(), 3);
	}

	@Test
	void testReservasFuturas() {
		reserva1 = mock(Reserva.class);
		reserva2 = mock(Reserva.class);
		reserva3 = mock(Reserva.class);
		when(reserva1.esFutura()).thenReturn(true);
		when(reserva2.esFutura()).thenReturn(true);
		when(reserva3.esFutura()).thenReturn(false);
		pedroRuiz.addReserva(reserva1);
		pedroRuiz.addReserva(reserva2);
		pedroRuiz.addReserva(reserva3);
		assertEquals(pedroRuiz.reservasFuturas().size(), 2);
	}

	@Test
	void testReservasEnCiudad() {
		publicacion1 = mock(Publicacion.class);
		publicacion2 = mock(Publicacion.class);
		publicacion3 = mock(Publicacion.class);
		inmueble1 = mock(Inmueble.class);
		inmueble2 = mock(Inmueble.class);
		inmueble3 = mock(Inmueble.class);
		reserva1 = mock(Reserva.class);
		reserva2 = mock(Reserva.class);
		reserva3 = mock(Reserva.class);
		
		when(inmueble1.getCiudad()).thenReturn("Cordoba");
		when(inmueble2.getCiudad()).thenReturn("Rosario");
		when(inmueble3.getCiudad()).thenReturn("Cordoba");
		
		when(publicacion1.getInmueble()).thenReturn(inmueble1);
		when(publicacion2.getInmueble()).thenReturn(inmueble2);
		when(publicacion3.getInmueble()).thenReturn(inmueble3);
				
		when(reserva1.getPublicacion()).thenReturn(publicacion1);
		when(reserva2.getPublicacion()).thenReturn(publicacion2);
		when(reserva3.getPublicacion()).thenReturn(publicacion3);
		
		pedroRuiz.addReserva(reserva1);
		pedroRuiz.addReserva(reserva2);
		pedroRuiz.addReserva(reserva3);
		assertEquals(pedroRuiz.ciudadesDondeReservo().size(), 2);
	}

	@Test
	void testCiudadesDondeReservo() {
		publicacion1 = mock(Publicacion.class);
		publicacion2 = mock(Publicacion.class);
		publicacion3 = mock(Publicacion.class);
		inmueble1 = mock(Inmueble.class);
		inmueble2 = mock(Inmueble.class);
		inmueble3 = mock(Inmueble.class);
		reserva1 = mock(Reserva.class);
		reserva2 = mock(Reserva.class);
		reserva3 = mock(Reserva.class);
		
		when(inmueble1.getCiudad()).thenReturn("Cordoba");
		when(inmueble2.getCiudad()).thenReturn("Rosario");
		when(inmueble3.getCiudad()).thenReturn("Cordoba");
		
		when(publicacion1.getInmueble()).thenReturn(inmueble1);
		when(publicacion2.getInmueble()).thenReturn(inmueble2);
		when(publicacion3.getInmueble()).thenReturn(inmueble3);
				
		when(reserva1.getPublicacion()).thenReturn(publicacion1);
		when(reserva2.getPublicacion()).thenReturn(publicacion2);
		when(reserva3.getPublicacion()).thenReturn(publicacion3);
		
		pedroRuiz.addReserva(reserva1);
		pedroRuiz.addReserva(reserva2);
		pedroRuiz.addReserva(reserva3);
		assertEquals(pedroRuiz.ciudadesDondeReservo().size(), 2);
	}

	@Test
	void testAddReserva() {
		pedroRuiz.addReserva(reserva1);
		pedroRuiz.addReserva(reserva2);
		assertEquals(pedroRuiz.todasLasReservas().size(), 2);
	}

	@Test
	void testAntiguedadComoUsuario() {
		Integer dias = pedroRuiz.antiguedadComoUsuario();
        assertEquals(dias, 0);
	}

	@Test
	void testCantidadDeVecesAlquilado() {
		fail("Not yet implemented");
	}

	@Test
	void testCantidadTotalDeAlquileres() {
		fail("Not yet implemented");
	}

}
