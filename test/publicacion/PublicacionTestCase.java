package publicacion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inmueble.Inmueble;

class PublicacionTestCase {
	
	/*SUT*/
	Publicacion publicacion1;
	
	/*DOC */
	Inmueble inmueble1;
	Calendar inicio;
	Calendar fin;
	ArrayList<Foto> fotos;
	ArrayList<PrecioPeriodo> precio;
	Calendar checkIn;
	Calendar checkOut;
	Calendar inicioOcupacion;
	Calendar finOcupacion;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testRegistrarOcupacion() {
		 // SUT
		inmueble1 = mock(Inmueble.class);
		inicio = mock(Calendar.class);
		fin = mock(Calendar.class);
		fotos = new ArrayList<Foto>();
		precio = new ArrayList<PrecioPeriodo>();
		checkIn = mock(Calendar.class);
		checkOut= mock(Calendar.class);
		inicioOcupacion = mock(Calendar.class);
		finOcupacion = mock(Calendar.class);
		
		publicacion1 = new Publicacion(inmueble1, inicio, fin,checkIn, checkOut, fotos, precio);
		
		
	//Excercise
		publicacion1.registrarOcupacion(inicioOcupacion, finOcupacion);
	//Verify
		assertEquals(1, publicacion1.getPeriodosOcupados().size());
	}

}
