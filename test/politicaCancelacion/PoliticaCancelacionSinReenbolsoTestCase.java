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

class PoliticaCancelacionSinReenbolsoTestCase {
	
	PoliticaDeCancelacion sinReembolso;
	Reserva reserva;
	Publicacion unaPublicacion;
	PrecioDiaOcupacion unPrecioDeReserva;

	
	
	@BeforeEach
	void setUp() throws Exception {
		this.sinReembolso = new SinReembolso();
		this.reserva= mock(Reserva.class);
		this.unaPublicacion = mock(Publicacion.class);
		unPrecioDeReserva = mock (PrecioDiaOcupacion.class);
	}

	@Test
	void con9DiasDeCancelacionSeCobraEltotalDeLaCancelacion() {
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
	
		
		assertEquals(precioEsperado,sinReembolso.aplicar(reserva));
	}
	
	@Test
	void con1DiaDeCancelacionSeCobraEltotalDeLaCancelacion() {
		Calendar fechaDePrueba = new GregorianCalendar();
		int cantidaDeDiasAnterioresQueCancela = 1;
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
	
		assertEquals(precioEsperado,sinReembolso.aplicar(reserva));
	}
	
	@Test
	void con20DiaDeCancelacionSeCobraEltotalDeLaCancelacion() {
		Calendar fechaDePrueba = new GregorianCalendar();
		int cantidaDeDiasAnterioresQueCancela = 1;
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
	
		assertEquals(precioEsperado,sinReembolso.aplicar(reserva));
	} 
	

}
