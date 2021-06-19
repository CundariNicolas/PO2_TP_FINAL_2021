package publicacion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inmueble.Inmueble;
import sitio.Observer;

class PublicacionTestCase {
	
	/*SUT*/
	Publicacion publicacion1;
	/* DOC */
	Inmueble inmueble;
	Calendar inicio;
	Calendar fin;
	Calendar checkIn;
	Calendar checkOut;
	ArrayList<Foto> fotos;
	ArrayList<PrecioPeriodo> precio;
	
	Periodo periodoOcupado;
	Periodo periodoAOcupar;
	
	
	Calendar inicioPeriodoOcupado;
	Calendar finPeriodoOcupado;
	
	Calendar inicioPeriodoAOcupar;
	Calendar finPeriodoAOcupar;
	
	Observer observador1;
	Observer observador2;
	Observer observador3;

	
	
	@BeforeEach
	void setUp() throws Exception {
	// DOC
	inmueble = mock(Inmueble.class);
	inicio = Calendar.getInstance();
	fin = Calendar.getInstance();
	checkIn = Calendar.getInstance();
	checkOut = Calendar.getInstance();
	fotos = new ArrayList<Foto>();
	precio = new ArrayList<PrecioPeriodo>();
	
	// SUT
		publicacion1 = new Publicacion(inmueble, inicio, fin, checkIn, checkOut, fotos, precio);

	}
	
	/* Test registrarOcupacion */
	@Test
	void registrarOcupacionQueEstaDisponible() {
		periodoAOcupar = mock(Periodo.class);
		publicacion1.registrarOcupacion(periodoAOcupar);
		assertEquals(1, publicacion1.getPeriodosOcupados().size());
	}
	
	@Test
	void registrarOcupacionQueNoEstaDisponible() {
		inicioPeriodoOcupado = Calendar.getInstance();
		inicioPeriodoOcupado.set(2000, Calendar.JANUARY, 10);
		
		finPeriodoOcupado = Calendar.getInstance();
		finPeriodoOcupado.set(2000, Calendar.JANUARY, 30);
		
		inicioPeriodoAOcupar = Calendar.getInstance();
		inicioPeriodoAOcupar.set(2000, Calendar.JANUARY, 10);

		finPeriodoAOcupar = Calendar.getInstance();
		finPeriodoAOcupar.set(2000, Calendar.JANUARY, 15);
		
		periodoOcupado = new Periodo(inicioPeriodoOcupado, finPeriodoOcupado);
		periodoAOcupar = new Periodo(inicioPeriodoAOcupar, finPeriodoAOcupar);
	
		
		
		
		publicacion1.registrarOcupacion(periodoOcupado);
		publicacion1.registrarOcupacion(periodoAOcupar);
		/*Solo deberia haber registrado la primera ocupacion*/
		assertNotEquals(2, publicacion1.getPeriodosOcupados().size());
		assertEquals(1, publicacion1.getPeriodosOcupados().size());
		assertEquals(periodoOcupado, publicacion1.getPeriodosOcupados().get(0));
	}
	
	
	
	
	
	
	
	
	
	
	/*Test estaLibreAntes*/
	@Test
	void testEstaLibreAntesVerdaderoDisintasFechas() {
		inicioPeriodoOcupado = Calendar.getInstance();
		inicioPeriodoOcupado.set(2000, Calendar.JANUARY, 20);
		
		finPeriodoOcupado = Calendar.getInstance();
		finPeriodoOcupado.set(2000, Calendar.JANUARY, 30);
		
		inicioPeriodoAOcupar = Calendar.getInstance();
		inicioPeriodoAOcupar.set(2000, Calendar.JANUARY, 10);

		finPeriodoAOcupar = Calendar.getInstance();
		finPeriodoAOcupar.set(2000, Calendar.JANUARY, 15);
		
		periodoOcupado = new Periodo(inicioPeriodoOcupado, finPeriodoOcupado);
		periodoAOcupar = new Periodo(inicioPeriodoAOcupar, finPeriodoAOcupar);
		
		assertTrue(publicacion1.estaLibreAntes(periodoOcupado, periodoAOcupar));
	}
	
	@Test
	void testEstaLibreAntesVerdaderoMismaFechaYHora() {
		inicioPeriodoOcupado = Calendar.getInstance();
		inicioPeriodoOcupado.set(2000, Calendar.JANUARY, 20);
		
		finPeriodoOcupado = Calendar.getInstance();
		finPeriodoOcupado.set(2000, Calendar.JANUARY, 30);
		
		inicioPeriodoAOcupar = Calendar.getInstance();
		inicioPeriodoAOcupar.set(2000, Calendar.JANUARY, 10);

		finPeriodoAOcupar = Calendar.getInstance();
		finPeriodoAOcupar.set(2000, Calendar.JANUARY, 20);
		
		periodoOcupado = new Periodo(inicioPeriodoOcupado, finPeriodoOcupado);
		periodoAOcupar = new Periodo(inicioPeriodoAOcupar, finPeriodoAOcupar);
		
		assertFalse(publicacion1.estaLibreAntes(periodoOcupado, periodoAOcupar));
	}
	
	
	
	
	/* Test estaLibreDespues*/

	@Test
	void testEstaLibreDespuesVerdaderoDistintasFechas() {
		inicioPeriodoOcupado = Calendar.getInstance();
		inicioPeriodoOcupado.set(2000, Calendar.JANUARY, 3);
		
		finPeriodoOcupado = Calendar.getInstance();
		finPeriodoOcupado.set(2000, Calendar.JANUARY, 7);
		
		inicioPeriodoAOcupar = Calendar.getInstance();
		inicioPeriodoAOcupar.set(2000, Calendar.JANUARY, 8);

		finPeriodoAOcupar = Calendar.getInstance();
		finPeriodoAOcupar.set(2000, Calendar.JANUARY, 10);
		
		periodoOcupado = new Periodo(inicioPeriodoOcupado, finPeriodoOcupado);
		periodoAOcupar = new Periodo(inicioPeriodoAOcupar, finPeriodoAOcupar);
		
		assertTrue(publicacion1.estaLibreDespues(periodoOcupado, periodoAOcupar));
	
		
	}
	
	@Test
	void testEstaLibreDespuesVerdaderoMismaFecha() {
		inicioPeriodoOcupado = Calendar.getInstance();
		inicioPeriodoOcupado.set(2000, Calendar.JANUARY, 3);
		
		finPeriodoOcupado = Calendar.getInstance();
		finPeriodoOcupado.set(2000, Calendar.JANUARY, 7, 22, 20);
		
		inicioPeriodoAOcupar = Calendar.getInstance();
		inicioPeriodoAOcupar.set(2000, Calendar.JANUARY, 7, 24, 00);

		finPeriodoAOcupar = Calendar.getInstance();
		finPeriodoAOcupar.set(2000, Calendar.JANUARY, 10);
		
		periodoOcupado = new Periodo(inicioPeriodoOcupado, finPeriodoOcupado);
		periodoAOcupar = new Periodo(inicioPeriodoAOcupar, finPeriodoAOcupar);
		
		assertTrue(publicacion1.estaLibreDespues(periodoOcupado, periodoAOcupar));
	
		
	}
	@Test
	void testEstaLibreDespuesReservaMismaHoraNoSePuede() {
		inicioPeriodoOcupado = Calendar.getInstance();
		inicioPeriodoOcupado.set(2000, Calendar.JANUARY, 3);
		
		finPeriodoOcupado = Calendar.getInstance();
		finPeriodoOcupado.set(2000, Calendar.JANUARY, 7, 6, 20);
		
		inicioPeriodoAOcupar = Calendar.getInstance();
		inicioPeriodoAOcupar.set(2000, Calendar.JANUARY, 7, 6, 20);

		finPeriodoAOcupar = Calendar.getInstance();
		finPeriodoAOcupar.set(2000, Calendar.JANUARY, 7, 22, 00);
		
		periodoOcupado = new Periodo(inicioPeriodoOcupado, finPeriodoOcupado);
		periodoAOcupar = new Periodo(inicioPeriodoAOcupar, finPeriodoAOcupar);
		
		assertFalse(publicacion1.estaLibreDespues(periodoOcupado, periodoAOcupar));
	
		
	}
	@Test
	void testEstaLibreDespuesFalsoEstaOcupado() {
		inicioPeriodoOcupado = Calendar.getInstance();
		inicioPeriodoOcupado.set(2000, Calendar.JANUARY, 3);
		
		finPeriodoOcupado = Calendar.getInstance();
		finPeriodoOcupado.set(2000, Calendar.JANUARY, 7, 6, 20);
		
		inicioPeriodoAOcupar = Calendar.getInstance();
		inicioPeriodoAOcupar.set(2000, Calendar.JANUARY, 7, 6, 10);

		finPeriodoAOcupar = Calendar.getInstance();
		finPeriodoAOcupar.set(2000, Calendar.JANUARY, 7, 22, 00);
		
		periodoOcupado = new Periodo(inicioPeriodoOcupado, finPeriodoOcupado);
		periodoAOcupar = new Periodo(inicioPeriodoAOcupar, finPeriodoAOcupar);
		
		assertFalse(publicacion1.estaLibreDespues(periodoOcupado, periodoAOcupar));
	
	}
	
	@Test
	void testSucribirObservador() {
		observador1 = spy(Observer.class);
		observador2 = spy(Observer.class);
		observador3 = spy(Observer.class);
		
		publicacion1.suscribirBajaDePrecio(observador1);
		publicacion1.suscribirBajaDePrecio(observador2);
		publicacion1.suscribirBajaDePrecio(observador3);
		
		publicacion1.notificarBajaDePrecio();
		verify(observador1).publish("Bajo el precio");
		verify(observador2).publish("Bajo el precio");
		verify(observador3).publish("Bajo el precio");
			
	}
	

}
