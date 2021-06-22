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

}
