package reserva;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import formasDePago.FormaDePago;
import publicacion.PrecioDiaOcupacion;
import publicacion.Publicacion;
import sitio.Sitio;
import usuario.Usuario;

class EstadoCondicionalTest {
	Reserva reserva;
	Publicacion publicacion = mock(Publicacion.class);
	Calendar fechaIN = mock(Calendar.class);
	Calendar fechaOUT = mock(Calendar.class);
	ArrayList<PrecioDiaOcupacion> precio = new ArrayList<>();
	FormaDePago formaDePago = mock(FormaDePago.class);
	Usuario usuario = mock(Usuario.class);
	Sitio sitio = mock(Sitio.class);
	EstadoReserva  estado;

	@BeforeEach
	void setUP() {
		estado = EstadoCondicional.getInstance();
		reserva = new Reserva(publicacion, fechaIN, fechaOUT, precio,formaDePago, usuario);
		reserva.setEstado(estado);
	}
	@Test
	void testAceptar() {
		estado.aceptar(reserva);
		assertEquals(reserva.getEstado().getClass(), EstadoConsolidado.class);
	}

	@Test
	void testEsCondicional() {
		assertTrue(estado.esCondicional());
	}

	@Test
	void testGetInstance() {
		assertEquals(EstadoCondicional.getInstance().getClass(), estado.getClass());
	}

}
