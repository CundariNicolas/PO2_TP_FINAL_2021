package inmueble;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tipoInmueble.TipoDeInmueble;

class InmuebleTestCase {

	Inmueble casa; //SUT
	TipoInmueble tipoInmueble;
	
	
	@BeforeEach
	void setUp() throws Exception {
		this.casa = new Inmueble ();
		this.tipoInmueble = mock(TipoDeInmueble.class);
		
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
