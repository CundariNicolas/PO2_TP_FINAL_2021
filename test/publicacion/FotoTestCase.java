package publicacion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FotoTestCase {
	//SUT
	Foto foto;
	// DOC
	String path;
	boolean marca360;
	Calendar fechaCaptura;
	Integer alto;
	Integer ancho;

	@BeforeEach
	void setUp() throws Exception {
		path = "Carpeta/casa.jpg";
		marca360 = false;
		fechaCaptura = new GregorianCalendar(2020, 11, 10);
		alto = 2000;
		ancho = 4000;
		foto = new Foto(path, marca360, fechaCaptura, ancho, alto);
	}

	@Test
	void testGetPath() {
		assertEquals("Carpeta/casa.jpg", foto.getPath());
	}
	
	@Test
	void testisMarca360() {
		assertFalse(foto.isMarca360());
	}
	
	@Test
	void testGetFechaCaptura() {
		assertEquals(new GregorianCalendar(2020, 11, 10), foto.getFechaCaptura());
	}
	
	@Test
	void testGetAlto() {
		assertEquals(2000, foto.getAlto());
	}
	@Test
	void testGetAncho() {
		assertEquals(4000, foto.getAncho());
	}
}
