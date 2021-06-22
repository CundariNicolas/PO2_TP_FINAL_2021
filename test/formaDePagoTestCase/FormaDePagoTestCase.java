package formaDePagoTestCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import formasDePago.FormaDePago;

class FormaDePagoTestCase {

	FormaDePago formaDePago;
	@BeforeEach
	void setUp() throws Exception {
	
		formaDePago = new FormaDePago("unCodigo","Tarjeta de Debito");
	}

	@Test
	void seGeneraUnaFormaDeCorrectamente() {
		assertEquals("unCodigo", formaDePago.getCodigo());
		assertEquals("Tarjeta de Debito" , formaDePago.getDescripcion());
	}

}
