package publicacion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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
	
	Publicacion publicacion;
	
	

	@BeforeEach
	void setUp() throws Exception {
		precio = 20;
		fecha = mock(Calendar.class);
		preciosPorDia = new PrecioDiaOcupacion(fecha, precio);
		publicacion = mock(Publicacion.class);
		
		
		
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
	
	@Test
	void testSetPrecioMenor() {
		preciosPorDia.setPrecio(10, publicacion);
		verify(publicacion, times(1)).notificarBajaEnPrecio();;
		
		
	}
	@Test
	void testSetPrecioNoMenor() {
		preciosPorDia.setPrecio(30, publicacion);
		verify(publicacion, times(0)).notificarBajaEnPrecio();;
		
	}


}
