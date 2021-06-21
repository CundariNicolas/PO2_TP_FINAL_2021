package politicaCancelacion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;

import publicacion.PrecioDiaOcupacion;
import publicacion.Publicacion;
import reserva.Reserva;

class politicaCancelacionGratuitaTestCase {

	PoliticaDeCancelacion gratiuta;
	Reserva reserva;
	Publicacion unaPublicacion;
	PrecioDiaOcupacion unPrecioDeReserva;
	
	@BeforeEach
	void setUp() throws Exception {
		this.gratiuta = new Gratuita();
		this.reserva= mock(Reserva.class);
		this.unaPublicacion = mock(Publicacion.class);
		unPrecioDeReserva = mock (PrecioDiaOcupacion.class);
	}

	@Test
	void unaCancelacionDeReservaConMasDe10DiasNoCobraMulta() {
		Calendar fechaDePrueba = new GregorianCalendar();
		fechaDePrueba.add(Calendar.DAY_OF_YEAR, 10);
		
		when(reserva.getFechaInicio()).thenReturn(fechaDePrueba);
		when(unaPublicacion.getPrecio()).thenReturn();
		assertEquals(0,gratiuta.aplicar(reserva));
	}
	
	@Test
	void unaCancelacionDeReservaCon9DiasCobraMulta() {
		Calendar fechaDePrueba = new GregorianCalendar();
		int cantidaDeDiasAnterioresQueCancela = 9;
		double precioDeUnDia = 10.0;
		double precioEsperado = precioDeUnDia * 2; 
		
		fechaDePrueba.add(Calendar.DAY_OF_YEAR, cantidaDeDiasAnterioresQueCancela);
		when(reserva.getFechaInicio()).thenReturn(fechaDePrueba);
		when(reserva.getPrecio().getPrecio()).thenReturn(precioDeUnDia);
		
		assertEquals(precioEsperado,gratiuta.aplicar(reserva));
	}

}
