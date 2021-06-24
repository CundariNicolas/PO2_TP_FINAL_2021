package publicacion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inmueble.Inmueble;
import politicaCancelacion.PoliticaDeCancelacion;
import reserva.Reserva;
import sitio.Observador;
import sitio.Sitio;
import usuario.Usuario;

class PublicacionTestCase {
	
	/*SUT*/
	Publicacion publicacion1;
	/* DOC */
	Usuario usuario;
	Inmueble inmueble;
	Calendar inicio;
	Calendar fin;
	ArrayList<Foto> fotos;
	ArrayList<PrecioDiaOcupacion> precioPorDia;
	
	Calendar fecha1;
	Calendar fecha2;
	Calendar fecha3;
	Calendar fecha4;
	
	PrecioDiaOcupacion dia1;
	PrecioDiaOcupacion dia2;
	PrecioDiaOcupacion dia3;
	PrecioDiaOcupacion dia4;
	
	Reserva reserva;
	PoliticaDeCancelacion politica;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
	// DOC
	usuario = mock(Usuario.class);
	inmueble = mock(Inmueble.class);
	inicio = Calendar.getInstance();
	fin = Calendar.getInstance();
	fotos = new ArrayList<Foto>();
	precioPorDia = new ArrayList<PrecioDiaOcupacion>();
	
	fecha1 = Calendar.getInstance();
	
	fecha1.set(2000, 6, 10, 10, 10, 10);
	
	fecha2 = Calendar.getInstance();
	
	fecha2.set(2000, 6, 11, 10, 10, 10);
	
	fecha3 = Calendar.getInstance();
	
	fecha3.set(2000, 6, 12, 10, 10, 10);
	
	fecha4 = Calendar.getInstance();
	
	fecha4.set(2000, 6, 13, 10, 10, 10);
	
	dia1 = new PrecioDiaOcupacion(fecha1, 200);
	dia2 = new PrecioDiaOcupacion(fecha2, 200);
	dia3 = new PrecioDiaOcupacion(fecha3, 200);
	dia4 = new PrecioDiaOcupacion(fecha4, 200);
	
	precioPorDia.add(dia1);
	precioPorDia.add(dia2);
	precioPorDia.add(dia3);
	precioPorDia.add(dia4);
	// SUT
		publicacion1 = new Publicacion(usuario, inmueble, inicio, fin, fotos, precioPorDia);

	}
	
	/* Test registrarOcupacion */
	@Test
	void testRegistrarOcupacion() {
		publicacion1.registrarOcupacion(fecha2, fecha3);
		assertFalse(dia1.estaOcupado());
		assertTrue(dia2.estaOcupado());
		assertTrue(dia3.estaOcupado());
		assertFalse(dia4.estaOcupado());
		
	}
	
	@Test
	void testRegistrarCancelacion() {
		publicacion1.registrarOcupacion(fecha1, fecha4);
		publicacion1.registrarCancelacion(fecha2, fecha3);
		assertTrue(dia1.estaOcupado());
		assertFalse(dia2.estaOcupado());
		assertFalse(dia3.estaOcupado());
		assertTrue(dia4.estaOcupado());
	}
	
	@Test
	void testNoEstaLibreEntre() {
		publicacion1.registrarOcupacion(fecha1, fecha4);
		assertFalse(publicacion1.estaLibreEntre(fecha2, fecha3));
	}
	
	@Test
	void testEstaLibreEntre() {
		assertTrue(publicacion1.estaLibreEntre(fecha2, fecha4));
	}
	
	@Test
	void testMedioDePagoHabilitado() {
		publicacion1.medioDePagoHabilitado();
		verify(inmueble, atLeast(1)).getFormaDePago();
	}
	
	
	@Test
	void testDisponibleHoy() {
		assertTrue(publicacion1.disponibleHoy(fecha2));
	}
	@Test
	void testNoDisponibleHoy() {
		publicacion1.registrarOcupacion(fecha1, fecha3);
		assertFalse(publicacion1.disponibleHoy(fecha2));
	}
	
	@Test
	void testPrecioEnPeriodo() {
		assertEquals(800, publicacion1.precioEnPeriodo(fecha1, fecha4));
	}
	@Test
	void testAplicarPoliticaCancelacion() {
		Reserva reserva = mock(Reserva.class);
		PoliticaDeCancelacion politica = mock(PoliticaDeCancelacion.class);
		
		when(politica.aplicar(reserva)).thenReturn(0.0);
		when(inmueble.getPoliticaCancelacion()).thenReturn(politica);
		
		
		publicacion1.aplicarPoliticaCancelacion(reserva);
		verify(inmueble, atLeast(1)).getPoliticaCancelacion();
	}
	
	@Test
	void testGetInmueble() {
		assertEquals(inmueble, publicacion1.getInmueble());
	}
	
	@Test
	void testGetFechaInicioPublicacion() {
		assertEquals(inicio, publicacion1.getFechaInicioPublicacion());
	}

	@Test
	void testGetFechaFin() {
		assertEquals(fin, publicacion1.getFechaFin());
	}
	
	@Test
	void testGetFotos() {
		assertEquals(fotos, publicacion1.getFotos());
	}
	
	@Test
	void testGetPrecio() {
		assertEquals(precioPorDia, publicacion1.getPrecio());
	}
	@Test
	void testGetCiudadInmueble() {
		when(inmueble.getCiudad()).thenReturn("Quilmes");
		publicacion1.getCiudadInmueble();
		verify(inmueble,atLeast(1)).getCiudad();
		assertEquals("Quilmes", publicacion1.getCiudadInmueble());
	}
	
	@Test
	void testGetPropietario() {
		assertEquals(usuario, publicacion1.getPropietario());
	}
	
	@Test
	void testNotificarBajaEnPrecio() {
		
			
		
		
		
	}
}
