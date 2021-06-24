package sitio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inmueble.Inmueble;
import publicacion.PrecioDiaOcupacion;
import publicacion.Publicacion;

class CriterioTestCase {
	
	CriterioBasico criterio;
	ArrayList<Publicacion> publicaciones;
	Publicacion publicacion1;
	Publicacion publicacion2;
	Publicacion publicacion3;
	Publicacion publicacion4;
	Publicacion publicacion5;
	Publicacion publicacion6;
	Calendar fecha1;
	Calendar fecha2;
	
	Inmueble inmueble1;
	Inmueble inmueble2;
	
	CriterioHuesped criterioHuesped;
	CriterioPrecio criterioPrecio;

	@BeforeEach
	void setUp() throws Exception {
		
		
		
		//DOC
		
		fecha1 = mock(Calendar.class);
		fecha2 = mock(Calendar.class);
		
		inmueble1 = mock(Inmueble.class);
		inmueble2 = mock(Inmueble.class);
		
		publicacion1 = mock(Publicacion.class);
		publicacion2 = mock(Publicacion.class);
		publicacion3 = mock(Publicacion.class);
		publicacion4 = mock(Publicacion.class);
		publicacion5 = mock(Publicacion.class);
		publicacion6 = mock(Publicacion.class);
		
		publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(publicacion1);
		publicaciones.add(publicacion2);
		publicaciones.add(publicacion3);
		publicaciones.add(publicacion4);
		publicaciones.add(publicacion5);
		publicaciones.add(publicacion6);
		
		//SUT
		criterio = new CriterioBasico("Quilmes", fecha1, fecha2);
		criterioHuesped = new CriterioHuesped(4);
		criterioPrecio = new CriterioPrecio(10.0, 100.0);
		
	}

	@Test
	void testLasQueCumplen() {
		when(publicacion1.getCiudadInmueble()).thenReturn("Quilmes");
		when(publicacion2.getCiudadInmueble()).thenReturn("Quilmes");
		when(publicacion3.getCiudadInmueble()).thenReturn("Quilmes");
		when(publicacion1.estaLibreEntre(fecha1, fecha2)).thenReturn(true);
		when(publicacion2.estaLibreEntre(fecha1, fecha2)).thenReturn(true);
		when(publicacion3.estaLibreEntre(fecha1, fecha2)).thenReturn(true);
		
		assertEquals(3, criterio.lasQueCumplen(publicaciones).size());
	}
	
	@Test
	void testCriteriosHuesped() {
		
		
		when(inmueble1.getCapacidad()).thenReturn(5);
		when(inmueble2.getCapacidad()).thenReturn(1);
		
		when(publicacion1.getInmueble()).thenReturn(inmueble1);
		when(publicacion2.getInmueble()).thenReturn(inmueble2);
		when(publicacion3.getInmueble()).thenReturn(inmueble2);
		when(publicacion4.getInmueble()).thenReturn(inmueble2);
		when(publicacion5.getInmueble()).thenReturn(inmueble2);
		when(publicacion6.getInmueble()).thenReturn(inmueble2);
		
		when(publicacion1.getCiudadInmueble()).thenReturn("Quilmes");
		when(publicacion2.getCiudadInmueble()).thenReturn("Quilmes");
		when(publicacion3.getCiudadInmueble()).thenReturn("Quilmes");
		when(publicacion4.getCiudadInmueble()).thenReturn("Quilmes");
		when(publicacion5.getCiudadInmueble()).thenReturn("Quilmes");
		when(publicacion6.getCiudadInmueble()).thenReturn("Quilmes");
		
		when(publicacion1.estaLibreEntre(fecha1, fecha2)).thenReturn(true);
		when(publicacion2.estaLibreEntre(fecha1, fecha2)).thenReturn(true);
		when(publicacion3.estaLibreEntre(fecha1, fecha2)).thenReturn(true);
		when(publicacion4.estaLibreEntre(fecha1, fecha2)).thenReturn(false);
		when(publicacion5.estaLibreEntre(fecha1, fecha2)).thenReturn(false);
		when(publicacion6.estaLibreEntre(fecha1, fecha2)).thenReturn(false);
		
		assertEquals(1, criterioHuesped.lasQueCumplen(publicaciones).size());
		
	}
	
	@Test
	void testLasQueCumplenPeroNoConExtras() {
		
		criterio.addCriterio(criterioHuesped);
		
		when(inmueble1.getCapacidad()).thenReturn(5);
		when(inmueble2.getCapacidad()).thenReturn(1);
		
		when(publicacion1.getInmueble()).thenReturn(inmueble1);
		when(publicacion2.getInmueble()).thenReturn(inmueble2);
		when(publicacion3.getInmueble()).thenReturn(inmueble2);
		when(publicacion4.getInmueble()).thenReturn(inmueble2);
		when(publicacion5.getInmueble()).thenReturn(inmueble2);
		when(publicacion6.getInmueble()).thenReturn(inmueble2);
		
		when(publicacion1.getCiudadInmueble()).thenReturn("Quilmes");
		when(publicacion2.getCiudadInmueble()).thenReturn("Quilmes");
		when(publicacion3.getCiudadInmueble()).thenReturn("Quilmes");
		when(publicacion4.getCiudadInmueble()).thenReturn("Quilmes");
		when(publicacion5.getCiudadInmueble()).thenReturn("Quilmes");
		when(publicacion6.getCiudadInmueble()).thenReturn("Quilmes");
		
		when(publicacion1.estaLibreEntre(fecha1, fecha2)).thenReturn(true);
		when(publicacion2.estaLibreEntre(fecha1, fecha2)).thenReturn(true);
		when(publicacion3.estaLibreEntre(fecha1, fecha2)).thenReturn(true);
		when(publicacion4.estaLibreEntre(fecha1, fecha2)).thenReturn(false);
		when(publicacion5.estaLibreEntre(fecha1, fecha2)).thenReturn(false);
		when(publicacion6.estaLibreEntre(fecha1, fecha2)).thenReturn(false);
		
		
		
		assertEquals(1, criterio.lasQueCumplen(publicaciones).size());
	}
	
	@Test
	void testCriterioPrecio() {
		
		PrecioDiaOcupacion dia1 = mock(PrecioDiaOcupacion.class);
		PrecioDiaOcupacion dia2 = mock(PrecioDiaOcupacion.class);
		PrecioDiaOcupacion dia3 = mock(PrecioDiaOcupacion.class);
		
		ArrayList<PrecioDiaOcupacion> precios1 = new ArrayList<PrecioDiaOcupacion>();
		ArrayList<PrecioDiaOcupacion> precios2 = new ArrayList<PrecioDiaOcupacion>();
		ArrayList<PrecioDiaOcupacion> precios3 = new ArrayList<PrecioDiaOcupacion>();
		precios1.add(dia1);
		precios2.add(dia2);
		precios3.add(dia3);	
		
		when(dia1.getPrecio()).thenReturn(50.0);
		when(dia2.getPrecio()).thenReturn(1.0);
		when(dia3.getPrecio()).thenReturn(200.0);
		
		when(publicacion1.getPrecio()).thenReturn(precios1);
		when(publicacion2.getPrecio()).thenReturn(precios1);
		when(publicacion3.getPrecio()).thenReturn(precios1);
		when(publicacion4.getPrecio()).thenReturn(precios1);
		when(publicacion5.getPrecio()).thenReturn(precios3);
		when(publicacion6.getPrecio()).thenReturn(precios3);
		
		assertEquals(4, criterioPrecio.lasQueCumplen(publicaciones).size());
	}
	
	@Test
	void testAmbosCriterios() {
		
		PrecioDiaOcupacion dia1 = mock(PrecioDiaOcupacion.class);
		PrecioDiaOcupacion dia2 = mock(PrecioDiaOcupacion.class);
		PrecioDiaOcupacion dia3 = mock(PrecioDiaOcupacion.class);
		
		ArrayList<PrecioDiaOcupacion> precios1 = new ArrayList<PrecioDiaOcupacion>();
		ArrayList<PrecioDiaOcupacion> precios2 = new ArrayList<PrecioDiaOcupacion>();
		ArrayList<PrecioDiaOcupacion> precios3 = new ArrayList<PrecioDiaOcupacion>();
		precios1.add(dia1);
		precios2.add(dia2);
		precios3.add(dia3);		
		
		criterio.addCriterio(criterioHuesped);
		criterio.addCriterio(criterioPrecio);
		
		when(inmueble1.getCapacidad()).thenReturn(5); 
		when(inmueble2.getCapacidad()).thenReturn(1);
		
		when(publicacion1.getInmueble()).thenReturn(inmueble1);
		when(publicacion2.getInmueble()).thenReturn(inmueble1);
		when(publicacion3.getInmueble()).thenReturn(inmueble2);
		when(publicacion4.getInmueble()).thenReturn(inmueble2);
		when(publicacion5.getInmueble()).thenReturn(inmueble2);
		when(publicacion6.getInmueble()).thenReturn(inmueble2);
		
		when(publicacion1.getCiudadInmueble()).thenReturn("Quilmes");
		when(publicacion2.getCiudadInmueble()).thenReturn("Quilmes");
		when(publicacion3.getCiudadInmueble()).thenReturn("Quilmes");
		when(publicacion4.getCiudadInmueble()).thenReturn("Quilmes");
		when(publicacion5.getCiudadInmueble()).thenReturn("Quilmes");
		when(publicacion6.getCiudadInmueble()).thenReturn("Quilmes");
		
		when(publicacion1.estaLibreEntre(fecha1, fecha2)).thenReturn(true);
		when(publicacion2.estaLibreEntre(fecha1, fecha2)).thenReturn(true);
		when(publicacion3.estaLibreEntre(fecha1, fecha2)).thenReturn(true);
		when(publicacion4.estaLibreEntre(fecha1, fecha2)).thenReturn(false);
		when(publicacion5.estaLibreEntre(fecha1, fecha2)).thenReturn(false);
		when(publicacion6.estaLibreEntre(fecha1, fecha2)).thenReturn(false);
		
		when(publicacion1.getPrecio()).thenReturn(precios1);
		when(publicacion2.getPrecio()).thenReturn(precios1);
		when(publicacion3.getPrecio()).thenReturn(precios2);
		when(publicacion4.getPrecio()).thenReturn(precios2);
		when(publicacion5.getPrecio()).thenReturn(precios3);
		when(publicacion6.getPrecio()).thenReturn(precios3);
		
		when(dia1.getPrecio()).thenReturn(50.0);
		when(dia2.getPrecio()).thenReturn(5.0);
		when(dia3.getPrecio()).thenReturn(200.0);
		
		
		
		assertEquals(2, criterio.lasQueCumplen(publicaciones).size());
		
	}

}
