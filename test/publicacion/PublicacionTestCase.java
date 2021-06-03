package publicacion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inmueble.Inmueble;

class PublicacionTestCase {
	/* DOC */
	Inmueble inmueble1 = mock(Inmueble.class);
	Calendar inicio = mock(Calendar.class);
	Calendar fin = mock(Calendar.class);
	ArrayList<Foto> fotos = new ArrayList<Foto>();
	ArrayList<PrecioPeriodo> precio = new ArrayList<PrecioPeriodo>();
	Integer checkIn = 1000;
	Integer checkOut= 1800;
	Calendar inicioOcupacion = mock(Calendar.class);
	Calendar finOcupacion = mock(Calendar.class);
	
	/*SUT*/
	Publicacion publicacion1 = new Publicacion(inmueble1, inicio, fin,checkIn, checkOut, fotos, precio);
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testRegistrarOcupacion() {
	//Excercise
		publicacion1.registrarOcupacion(inicioOcupacion, finOcupacion);
	//Verify
		assertEquals(1, publicacion1.getPeriodosOcupados().size());
	}

}
