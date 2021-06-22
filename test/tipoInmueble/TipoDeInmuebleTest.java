package tipoInmueble;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TipoDeInmuebleTest {

	TipoDeInmueble casa;
	
	@BeforeEach
	void setUp() throws Exception {
		casa = new TipoDeInmueble("Casa");
	}

	@Test
	void seCreaCorrectamenteElInmueble() {
		assertEquals("Casa", casa.codigoDescripcion());
		assertNotEquals("", casa.codigoDescripcion());
	}
}
