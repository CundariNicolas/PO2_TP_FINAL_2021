package publicacion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrecioDiaOcupacionTestCase {
	
	//SUT
	PrecioDiaOcupacion preciosPorDia;
	//DOC
	Calendar fecha;
	boolean ocupado;
	double precio;
	

	@BeforeEach
	void setUp() throws Exception {
		precio = 20;
		fecha = mock(Calendar.class);
		preciosPorDia = new PrecioDiaOcupacion(fecha, precio);
		
	}

	@Test
	void testGetPrecio() {
		assertEquals(20, preciosPorDia.getPrecio());
	}
	
	@Test
	void testSetPrecio() {
		assertEquals(20, preciosPorDia.getPrecio());
		preciosPorDia.setPrecio(200);
		assertEquals(200, preciosPorDia.getPrecio());
	}
	@Test
	void testEstaOcupado() {
		assertFalse(preciosPorDia.estaOcupado());
		preciosPorDia.setOcupado();
		assertTrue(preciosPorDia.estaOcupado());
		
	}
	@Test
	void testSetOcupado() {
		precio = 20;
		fecha = mock(Calendar.class);
		preciosPorDia = new PrecioDiaOcupacion(fecha, precio);
		preciosPorDia.setOcupado();
		assertTrue(preciosPorDia.estaOcupado());
		
		
	}
	@Test
	void testSetLibre() {
		precio = 20;
		fecha = mock(Calendar.class);
		preciosPorDia = new PrecioDiaOcupacion(fecha, precio);
		preciosPorDia.setLibre();
		assertFalse(preciosPorDia.estaOcupado());
		
	}

}
