package servicios;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Servicios {

	Servicio servicio;
	Servicio otroServicio;
	
	@BeforeEach
	void setUp() throws Exception {
		servicio = new Servicio("unCodigo", "unaDescripcion");
		otroServicio = mock(Servicio.class);
	}

	@Test
	void seSeteaElCodigoCorrectamente() {
		assertEquals("unaDescripcion",servicio.getDescripcion());
	}
	
}
