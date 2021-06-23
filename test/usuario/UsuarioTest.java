
package usuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calificacion.Calificacion;
import inmueble.Inmueble;
import publicacion.Publicacion;
import reserva.Reserva;


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
		pedroRuiz.addPublicacion(publicacion3);
		assertEquals(pedroRuiz.getPublicaciones().size(), 1);
	}

	@Test
	void testGetCalificaciones() {
		pedroRuiz.setCalificacion(calificacion1);
		assertEquals(pedroRuiz.getCalificaciones().size(), 1);
	}

	@Test
	void testAddCalificacion() {
		pedroRuiz.setCalificacion(calificacion1);
		pedroRuiz.setCalificacion(calificacion2);
		assertEquals(pedroRuiz.getCalificaciones().size(), 2);
	}

	@Test
	void testAddPublicacion() {
		pedroRuiz.addPublicacion(publicacion1);
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
		reserva1 = mock(Reserva.class);
		reserva2 = mock(Reserva.class);
		reserva3 = mock(Reserva.class);
		
		when(publicacion1.getCiudadInmueble()).thenReturn("Cordoba");
		when(publicacion2.getCiudadInmueble()).thenReturn("Rosario");
		when(publicacion3.getCiudadInmueble()).thenReturn("Rio");
				
		when(reserva1.getPublicacion()).thenReturn(publicacion1);
		when(reserva2.getPublicacion()).thenReturn(publicacion2);
		when(reserva3.getPublicacion()).thenReturn(publicacion3);
		
		pedroRuiz.addReserva(reserva1);
		pedroRuiz.addReserva(reserva2);
		pedroRuiz.addReserva(reserva3);
		assertEquals(pedroRuiz.ciudadesDondeReservo().size(), 3);
	}

	@Test
	void testCiudadesDondeReservo() {
		publicacion1 = mock(Publicacion.class);
		publicacion2 = mock(Publicacion.class);
		publicacion3 = mock(Publicacion.class);
		reserva1 = mock(Reserva.class);
		reserva2 = mock(Reserva.class);
		reserva3 = mock(Reserva.class);
		
		when(publicacion1.getCiudadInmueble()).thenReturn("Cordoba");
		when(publicacion2.getCiudadInmueble()).thenReturn("Rio");
		when(publicacion3.getCiudadInmueble()).thenReturn("Cordoba");
				
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
		publicacion1 = mock(Publicacion.class);
		inmueble1 = mock(Inmueble.class);
		when(inmueble1.getCantidadDeVecesAlquilado()).thenReturn(15);
		when(publicacion1.getInmueble()).thenReturn(inmueble1);
		
		pedroRuiz.addPublicacion(publicacion1);

		assertEquals(pedroRuiz.cantidadDeVecesAlquilado(inmueble1), 15);
	}

	@Test
	void testCantidadTotalDeAlquileres() {
		publicacion1 = mock(Publicacion.class);
		publicacion2 = mock(Publicacion.class);
		inmueble1 = mock(Inmueble.class);
		inmueble2 = mock(Inmueble.class);
		when(inmueble1.getCantidadDeVecesAlquilado()).thenReturn(15);
		when(inmueble2.getCantidadDeVecesAlquilado()).thenReturn(18);
		when(publicacion1.getInmueble()).thenReturn(inmueble1);
		when(publicacion2.getInmueble()).thenReturn(inmueble2);
		
		pedroRuiz.addPublicacion(publicacion1);
		pedroRuiz.addPublicacion(publicacion2);
		assertEquals(pedroRuiz.cantidadTotalDeAlquileres(), 33);
	}

}
