package reserva;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import formasDePago.FormaDePago;
import inmueble.Inmueble;
import publicacion.PrecioDiaOcupacion;
import publicacion.Publicacion;
import usuario.Usuario;

class ReservaTest {
	private Reserva reserva1;
	private Reserva reservaCondicional;
	private Publicacion publicacion1 = mock(Publicacion.class);
	private Calendar fechaIN;
	private Calendar fechaOUT;
	private ArrayList<PrecioDiaOcupacion> precio = new ArrayList<PrecioDiaOcupacion>();
	private FormaDePago formaDePago = mock(FormaDePago.class);
	private Usuario inquilino = mock(Usuario.class);
	

	@BeforeEach
	void setUp() {
		fechaIN = Calendar.getInstance();
		fechaIN.set(2021, 10, 5);
		fechaOUT = Calendar.getInstance();
		fechaOUT.set(2021, 11, 12);
		
		reserva1 = new Reserva(publicacion1, fechaIN, fechaOUT, precio, formaDePago, inquilino);
		reservaCondicional =  Reserva.reservaCondicional(publicacion1, fechaIN, fechaOUT, precio, formaDePago, inquilino);
	}
	
	@Test
	void testReserva() {
		assertEquals(reserva1.getClass(), Reserva.class);
	}

	@Test
	void testReservaCondicional() {
		assertEquals(reservaCondicional.getClass(), Reserva.class);
		assertEquals(reservaCondicional.getEstado().getClass(), EstadoCondicional.class);
		assertTrue(reservaCondicional.esCondicional());
	}

	@Test
	void testSetEstado() {
		reserva1.setEstado(EstadoCancelado.getInstance());
		assertEquals(reserva1.getEstado().getClass(), EstadoCancelado.class);
	}

	@Test
	void testGetFecgaHoraReserva() {
		assertEquals(reserva1.getFecgaHoraReserva().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.YEAR));
		assertEquals(reserva1.getFecgaHoraReserva().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.MONTH));
		assertEquals(reserva1.getFecgaHoraReserva().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		assertEquals(reserva1.getFecgaHoraReserva().get(Calendar.HOUR), Calendar.getInstance().get(Calendar.HOUR));
		assertEquals(reserva1.getFecgaHoraReserva().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.MINUTE));
	}

	@Test
	void testGetPublicacion() {
		assertEquals(reserva1.getPublicacion().getClass(), Publicacion.class);
	}

	@Test
	void testGetFechaInicio() {
		assertEquals(reserva1.getFechaInicio().get(Calendar.YEAR), fechaIN.get(Calendar.YEAR));
		assertEquals(reserva1.getFechaInicio().get(Calendar.MONTH), fechaIN.get(Calendar.MONTH));
		assertEquals(reserva1.getFechaInicio().get(Calendar.DAY_OF_MONTH), fechaIN.get(Calendar.DAY_OF_MONTH));
	}

	@Test
	void testGetFechaFin() {
		assertEquals(reserva1.getFechaFin().get(Calendar.YEAR), fechaOUT.get(Calendar.YEAR));
		assertEquals(reserva1.getFechaFin().get(Calendar.MONTH), fechaOUT.get(Calendar.MONTH));
		assertEquals(reserva1.getFechaFin().get(Calendar.DAY_OF_MONTH), fechaOUT.get(Calendar.DAY_OF_MONTH));
	}

	@Test
	void testGetPrecios() {
		PrecioDiaOcupacion precioDia = mock(PrecioDiaOcupacion.class);
		precio.add(precioDia);
		assertEquals(reserva1.getPrecios().get(0).getClass(), PrecioDiaOcupacion.class);
	}

	@Test
	void testGetFormaDePago() {
		formaDePago = mock(FormaDePago.class);
		assertEquals(reserva1.getFormaDePago().getClass(), FormaDePago.class);
	}

	@Test
	void testGetInquilino() {
		assertEquals(reserva1.getInquilino().getClass(), Usuario.class);
	}

	@Test
	void testEnviarA() {
		Reserva reservaMock = mock(Reserva.class);
		reservaMock .enviarA("pepe@gmail.com");
		verify(reservaMock).enviarA("pepe@gmail.com");		
	}

	@Test
	void testAceptar() {
		Inmueble inmueble = mock(Inmueble.class);
		when(publicacion1.getInmueble()).thenReturn(inmueble);
		reserva1.aceptar();
		assertEquals(reserva1.getEstado().getClass(), EstadoConsolidado.class);
	}

	@Test
	void testRechazar() {
		reserva1.rechazar();
		assertEquals(reserva1.getEstado().getClass(), EstadoRechazado.class);		
	}

	@Test
	void testCancelar() {
		reserva1.cancelar();
		assertEquals(reserva1.getEstado().getClass(), EstadoCancelado.class);	
	}

	@Test
	void testEsFutura() {
		assertTrue(reserva1.esFutura());
	}

	@Test
	void testEsDeCiudad() {
		when(publicacion1.getCiudadInmueble()).thenReturn("Cordoba");
				
		assertTrue(reserva1.esDeCiudad("Cordoba"));
		assertFalse(reserva1.esDeCiudad("Rio"));
	}

	@Test
	void testEsCondicional() {
		assertTrue(reservaCondicional.esCondicional());
	}

	@Test
	void testEstaFinalizada() {
		assertFalse(reserva1.estaFinalizada());
	}

	@Test
	void testPrecioTotalReserva() {
		PrecioDiaOcupacion precioDia = mock(PrecioDiaOcupacion.class);
		when(precioDia.getPrecio()).thenReturn(100.00);
		precio.add(precioDia);
		precio.add(precioDia);
		
		assertEquals(reserva1.precioTotalReserva(), 200.00);
	}

	@Test
	void testValorEnCantidadDeDias() {
		PrecioDiaOcupacion precioDia = mock(PrecioDiaOcupacion.class);
		when(precioDia.getPrecio()).thenReturn(333.33);
		precio.add(precioDia);
		precio.add(precioDia);
		
		assertEquals(reserva1.valorEnCantidadDeDias(1), 333.33);
		assertEquals(reserva1.valorEnCantidadDeDias(2), 666.66);
	}

}
