package reserva;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EstadoReservaTest {
	EstadoReserva estado;
	@Test
	void testGetDescripcion() {
		estado = EstadoInicial.getInstance();
		assertEquals(estado.getDescripcion(), "Inicial");
		
		estado = EstadoConsolidado.getInstance();
		assertEquals(estado.getDescripcion(), "Consolidado");
		
		estado = EstadoCondicional.getInstance();
		assertEquals(estado.getDescripcion(), "Condicional");
		
		estado = EstadoCancelado.getInstance();
		assertEquals(estado.getDescripcion(), "Cancelado");
		
		estado = EstadoRechazado.getInstance();
		assertEquals(estado.getDescripcion(), "Rechazado");
	}
	
	@Test
	void testEsCondicional() {
		estado = EstadoRechazado.getInstance();
		assertFalse(estado.esCondicional());
	}

	@Test
	void testRechazar() {
		estado = EstadoRechazado.getInstance();
		assertDoesNotThrow(() -> estado.esCondicional());
	}
	
	@Test
	void testSeConcreto() {
		estado = EstadoInicial.getInstance();
		assertFalse(estado.seConcreto());
		
		estado = EstadoConsolidado.getInstance();
		assertTrue(estado.seConcreto());
		
		estado = EstadoCondicional.getInstance();
		assertFalse(estado.seConcreto());
		
		estado = EstadoCancelado.getInstance();
		assertFalse(estado.seConcreto());
		
		estado = EstadoRechazado.getInstance();
		assertFalse(estado.seConcreto());
		
	}

}
