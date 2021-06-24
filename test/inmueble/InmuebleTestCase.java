package inmueble;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calificacion.Calificacion;
import formasDePago.FormaDePago;
import politicaCancelacion.PoliticaDeCancelacion;
import servicios.Servicio;
import tipoInmueble.TipoDeInmueble;
import usuario.Usuario;

class InmuebleTestCase {

	Inmueble unInmueble; //SUT
	
	Usuario unUsuario;
	Usuario otroUsuario;
	
	FormaDePago tarjetaDeCredito;
	FormaDePago debito;
	FormaDePago mercadoPago;
	
	TipoDeInmueble unaCasa;
	TipoDeInmueble unDepto;
	
	Servicio agua;
	Servicio gas;
	Servicio luz;
	
	PoliticaDeCancelacion politicaDeCancelacion;
	
	Calificacion unaCalificacion;
	Calificacion otraCalificacion;
	
	Set<Servicio> servicios;
	Set <Calificacion> calificacion;
	double superficie;
	int capacidad;
	int checkIN;
	int checkOUT;
	Set<FormaDePago> formasDePago;
	String pais;
	String ciudad;
	String direccion;
	
	
	@BeforeEach
	void setUp() throws Exception {
		agua = mock(Servicio.class);
		luz = mock(Servicio.class);
		gas = mock(Servicio.class);
		servicios = new HashSet<Servicio>();
		servicios.add(agua);
		servicios.add(gas);
		
		unUsuario = mock(Usuario.class);
		otroUsuario = mock(Usuario.class);
		
		mercadoPago = mock(FormaDePago.class);
		tarjetaDeCredito = mock(FormaDePago.class);
		debito = mock(FormaDePago.class);
		formasDePago = new HashSet<FormaDePago>();
		formasDePago.add(debito);
		formasDePago.add(tarjetaDeCredito);
		
		unaCalificacion = mock (Calificacion.class);
		otraCalificacion = mock (Calificacion.class);

		unDepto= mock (TipoDeInmueble.class);
		unaCasa= mock (TipoDeInmueble.class);
		politicaDeCancelacion = mock (PoliticaDeCancelacion.class);
		superficie  = 150;
		pais = "Argentina";
		ciudad ="Quilmes";
		direccion = "Husares 4598";
		capacidad = 4;
		checkIN = 14;
		checkOUT= 12;
		unInmueble = new Inmueble(unaCasa,superficie,pais, 
				           ciudad,direccion,capacidad,checkIN,
				           checkOUT,politicaDeCancelacion,formasDePago,servicios);
	}

	@Test
	void seInicializaDeFormaCorrecta() { 
		assertEquals(0, unInmueble.getCalificaciones().size());
		assertEquals(0, unInmueble.getCantidadDeVecesAlquilado());
		assertEquals(2,unInmueble.getFormaDePago().size());
	}
	
	@Test
	void sePuedeAgregarUnaCalificacion() {
		when(unaCalificacion.getOrigen()).thenReturn(unUsuario);
		unInmueble.setCalificacion(unaCalificacion);
		assertEquals(1,unInmueble.getCalificaciones().size());
	}
	
	@Test
	void unUsuarioElMismoUsuarioNoPuedeCalificar2veces() {
		when(unaCalificacion.getOrigen()).thenReturn(unUsuario);
		unInmueble.setCalificacion(unaCalificacion);
		unInmueble.setCalificacion(unaCalificacion);
		assertEquals(1,unInmueble.getCalificaciones().size());
	}
	
	@Test
	void diferentesUsuarioPuedeCalificar() {
		when(unaCalificacion.getOrigen()).thenReturn(unUsuario);
		when(otraCalificacion.getOrigen()).thenReturn(otroUsuario);
		
		unInmueble.setCalificacion(unaCalificacion);
		unInmueble.setCalificacion(otraCalificacion);
		
		assertEquals(2,unInmueble.getCalificaciones().size());
	}
	
	@Test
	void aumentaLaCantidadDeVecesAlquilado() {
		unInmueble.aumentarCantidadVecesAlquilado();
		assertEquals(1, unInmueble.getCantidadDeVecesAlquilado());
	}
	
	@Test
	void seObtieneElPaisCorrecto() {
		assertEquals("Argentina", unInmueble.getPais());
	}
	
	@Test
	void seObtieneLaCiudadCorrecta() {
		assertEquals("Quilmes", unInmueble.getCiudad());
	}
	
	@Test
	void SeObtieneCorrectamenteLasFormasDePago() {
		assertTrue(unInmueble.getFormaDePago().contains(debito));
		assertTrue(unInmueble.getFormaDePago().contains(tarjetaDeCredito));
		assertFalse(unInmueble.getFormaDePago().contains(mercadoPago));
		
	}
	
	@Test
	void seObtieneElTipoDeInmueble() {
		assertEquals(unaCasa,unInmueble.getTipo());
		assertNotEquals(unDepto,unInmueble.getTipo());
	}
	@Test
	void serObtieneLaSuperficie() {
		double superficieIncorrecta = 200.0;
		assertEquals(superficie,unInmueble.getSuperficie());
		assertFalse(unInmueble.getSuperficie() == superficieIncorrecta);
	} 
	@Test
	void seObtieneLaDireccion() {
		String direccionIncorrecta = "Malabia 790";
		assertEquals(direccion,unInmueble.getDireccion());
		assertFalse(unInmueble.getDireccion() == direccionIncorrecta);
	}
	@Test
	void tieneBienLaCantidadDeServicios() {
		assertEquals(2,unInmueble.getServicios().size());
		
	}
	@Test
	void seObtieneCorrectamentLaPoliticaDeCancelacion() {
		PoliticaDeCancelacion politicaErronea = mock (PoliticaDeCancelacion.class);
		assertEquals(politicaDeCancelacion,unInmueble.getPoliticaCancelacion());
		assertFalse(politicaErronea == unInmueble.getPoliticaCancelacion());
	}
	
	@Test
	void seObtieneElHorarioDeCheckIn() {
		int checkINErroneo= 7;
		assertEquals(checkIN,unInmueble.getCheckIn());
		assertFalse(checkINErroneo==unInmueble.getCheckIn());
	}
	
	@Test
	void seObtieneElHorarioDeCheckOUT() {
		int checkOUTErroneo= 7;
		assertEquals(checkIN,unInmueble.getCheckIn());
		assertFalse(checkOUTErroneo==unInmueble.getCheckIn());
	}
	
	@Test
	void checkInYCheckOutNoPuedeSerNegativos() {
		int horarioErroneo = -5;
		unInmueble.setCheckIN(horarioErroneo);
		assertFalse(horarioErroneo==unInmueble.getCheckIn());
		
		unInmueble.setCheckOUT(horarioErroneo);
		assertFalse(horarioErroneo==unInmueble.getCheckOUT());
	}
	
	@Test
	void laSuperficieNoPuedeSerNegativa() {
		double superficieErronea = -200;
		unInmueble.setSuperficie(superficieErronea);
		assertFalse(superficieErronea==unInmueble.getSuperficie());
	}
	
	@Test
	void capacidadCorrecta() {
		assertEquals(unInmueble.getCapacidad(), capacidad);
	}
	
	@Test
	void noSePuedeConfigurarUnaCapacidadNegativa() {
		int valorErroneo = -5;
		unInmueble.setCapacidad(valorErroneo);
		
		assertFalse(unInmueble.getCapacidad() == valorErroneo);
	}
	
	@Test
	void soloSePuedenAgregarMetodosDePagoEnConjunto() {
		FormaDePago forma1 = mock (FormaDePago.class);
		FormaDePago forma2 = mock (FormaDePago.class);
		FormaDePago forma3 = mock (FormaDePago.class);
		FormaDePago forma4 = mock (FormaDePago.class);
		Set <FormaDePago> formas = new HashSet<>();
		formas.add(forma1);
		unInmueble.setFormaDePago(formas);
		assertEquals(1, unInmueble.getFormaDePago().size());
		
		unInmueble.setFormaDePago(formas);
		unInmueble.setFormaDePago(formas);
		assertEquals(1, unInmueble.getFormaDePago().size());
		
		formas.add(forma2); 
		formas.add(forma3);
		formas.add(forma4);
		assertEquals(4, unInmueble.getFormaDePago().size());
		
	}
	
}

