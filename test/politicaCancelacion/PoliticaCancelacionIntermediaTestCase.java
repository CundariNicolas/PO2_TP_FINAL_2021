package politicaCancelacion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import publicacion.PrecioDiaOcupacion;
import publicacion.Publicacion;
import reserva.Reserva;

class PoliticaCancelacionIntermediaTestCase {

	PoliticaDeCancelacion intermedia;
	Reserva reserva;
	Publicacion unaPublicacion;
	PrecioDiaOcupacion unPrecioDeReserva;

	
	
	@BeforeEach
	void setUp() throws Exception {
		this.intermedia= new Intermedia();
		this.reserva= mock(Reserva.class);
		this.unaPublicacion = mock(Publicacion.class);
		unPrecioDeReserva = mock (PrecioDiaOcupacion.class);
	}

	@Test
	void hasta20DiasAntesEsGratuita() {
		Calendar fechaDePrueba = new GregorianCalendar();
		int cantidaDeDiasAnterioresQueCancela = 21;
		double precioDeUnDia = 10.0;
		double precioEsperado = 0; 
		
		fechaDePrueba.add(Calendar.DAY_OF_YEAR, cantidaDeDiasAnterioresQueCancela);
	
		when(unPrecioDeReserva.getPrecio()).thenReturn(precioDeUnDia);
		
		ArrayList<PrecioDiaOcupacion> precios = new ArrayList<>();
		
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		when(reserva.valorEnCantidadDeDias(2)).thenReturn(precioEsperado);
		
		when(reserva.getFechaInicio()).thenReturn(fechaDePrueba);
		when(reserva.getPrecios()).thenReturn(precios);
	
		
		assertEquals(precioEsperado,intermedia.aplicar(reserva));
	}
	
	@Test
	void menosQue19DiasAntes50PorcientoDeLaReservaTotal() {
		Calendar fechaDePrueba = new GregorianCalendar();
		int cantidaDeDiasAnterioresQueCancela = 19;
		double precioDeUnDia = 10.0;
		double precioEsperado = reserva.precioTotalReserva() / 2; 
		
		fechaDePrueba.add(Calendar.DAY_OF_YEAR, cantidaDeDiasAnterioresQueCancela);
	
		when(unPrecioDeReserva.getPrecio()).thenReturn(precioDeUnDia);
		
		ArrayList<PrecioDiaOcupacion> precios = new ArrayList<>();
		
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		when(reserva.valorEnCantidadDeDias(2)).thenReturn(precioEsperado);
		
		when(reserva.getFechaInicio()).thenReturn(fechaDePrueba);
		when(reserva.getPrecios()).thenReturn(precios);
	
		assertEquals(precioEsperado,intermedia.aplicar(reserva));
	}
	
	@Test
	void menosQue10DiasAntes50PorcientoDeLaReservaTotal() {
		Calendar fechaDePrueba = new GregorianCalendar();
		int cantidaDeDiasAnterioresQueCancela = 10;
		double precioDeUnDia = 10.0;
		double precioEsperado = reserva.precioTotalReserva() / 2; 
		
		fechaDePrueba.add(Calendar.DAY_OF_YEAR, cantidaDeDiasAnterioresQueCancela);
	
		when(unPrecioDeReserva.getPrecio()).thenReturn(precioDeUnDia);
		
		ArrayList<PrecioDiaOcupacion> precios = new ArrayList<>();
		
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		when(reserva.valorEnCantidadDeDias(2)).thenReturn(precioEsperado);
		
		when(reserva.getFechaInicio()).thenReturn(fechaDePrueba);
		when(reserva.getPrecios()).thenReturn(precios);
	
		assertEquals(precioEsperado,intermedia.aplicar(reserva));
	}
	
	@Test
	void menosQueMenorA9DiasAntes100PorcientoDeLaReservaTotal() {
		Calendar fechaDePrueba = new GregorianCalendar();
		int cantidaDeDiasAnterioresQueCancela = 9;
		double precioDeUnDia = 10.0;
		double precioEsperado = reserva.precioTotalReserva(); 
		fechaDePrueba.add(Calendar.DAY_OF_YEAR, cantidaDeDiasAnterioresQueCancela);
		when(unPrecioDeReserva.getPrecio()).thenReturn(precioDeUnDia);
		ArrayList<PrecioDiaOcupacion> precios = new ArrayList<>();
		
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		precios.add(unPrecioDeReserva);
		when(reserva.valorEnCantidadDeDias(2)).thenReturn(precioEsperado);
		
		when(reserva.getFechaInicio()).thenReturn(fechaDePrueba);
		when(reserva.getPrecios()).thenReturn(precios);
	
		assertEquals(precioEsperado,intermedia.aplicar(reserva));
	}
	
	

}
