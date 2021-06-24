package publicacion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inmueble.Inmueble;
import politicaCancelacion.PoliticaDeCancelacion;
import reserva.Reserva;
import sitio.ObserverManager;
import sitio.PaginaWeb;
import sitio.Sitio;
import usuario.Usuario;

class PublicacionNotificarBajaEnPrecioTest {
	
	Sitio sitio;
	
	Reserva reserva = mock(Reserva.class);
	Publicacion publicacion = mock(Publicacion.class);
	ObserverManager manager = mock(ObserverManager.class);
	
	Publicacion publicacion1 = mock(Publicacion.class);
	Publicacion publicacion2 = mock(Publicacion.class);
	Publicacion publicacion3 = mock(Publicacion.class);
	Publicacion publicacion4 = mock(Publicacion.class);
	
	
	/* DOC */
	Usuario usuario;
	Inmueble inmueble;
	Calendar inicio;
	Calendar fin;
	ArrayList<Foto> fotos;
	ArrayList<PrecioDiaOcupacion> precioPorDia;
	
	Calendar fecha1;
	Calendar fecha2;
	Calendar fecha3;
	Calendar fecha4;
	Calendar fecha5;
	
	PrecioDiaOcupacion dia1;
	PrecioDiaOcupacion dia2;
	PrecioDiaOcupacion dia3;
	PrecioDiaOcupacion dia4;
	PrecioDiaOcupacion dia5;
	
	
	PoliticaDeCancelacion politica;


	@BeforeEach
	void setUp() throws Exception {
		// DOC
		usuario = mock(Usuario.class);
		inmueble = mock(Inmueble.class);
		inicio = Calendar.getInstance();
		fin = Calendar.getInstance();
		fotos = new ArrayList<Foto>();
		precioPorDia = new ArrayList<PrecioDiaOcupacion>();
		
		fecha1 = Calendar.getInstance();
		
		fecha1.set(2000, 6, 10, 10, 10, 10);
		
		fecha2 = Calendar.getInstance();
		
		fecha2.set(2000, 6, 11, 10, 10, 10);
		
		fecha3 = Calendar.getInstance();
		
		fecha3.set(2000, 6, 12, 10, 10, 10);
		
		fecha4 = Calendar.getInstance();
		
		fecha4.set(2000, 6, 13, 10, 10, 10);
		
		fecha5 = Calendar.getInstance();
		
		dia1 = new PrecioDiaOcupacion(fecha1, 200);
		dia2 = new PrecioDiaOcupacion(fecha2, 200);
		dia3 = new PrecioDiaOcupacion(fecha3, 200);
		dia4 = new PrecioDiaOcupacion(fecha4, 200);
		dia5 = new PrecioDiaOcupacion(fecha5, 400);
		
		precioPorDia.add(dia1);
		precioPorDia.add(dia2);
		precioPorDia.add(dia3);
		precioPorDia.add(dia4);
		precioPorDia.add(dia5);
		// SUT
			publicacion1 = new Publicacion(usuario, inmueble, inicio, fin, fotos, precioPorDia);
		
		
		sitio = Sitio.getInstance();
	}

	@Test
	void testNotificarBajaEnPrecio() {
		/**
		PaginaWeb pagina = mock(PaginaWeb.class);
		manager = ObserverManager.getInstance();
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(publicacion1);
		
		when(publicacion1.getInmueble()).thenReturn(inmueble);
		when(pagina.getPublicacion()).thenReturn(publicacion1);
		manager.suscribirABajaDePrecio(pagina);
		when(usuario.getPublicaciones()).thenReturn(publicaciones);
		
		sitio.addUsuario(usuario);
		
		dia1.setPrecio(100, publicacion1);
		
		verify(sitio, times(1)).;;
		
		;
		
		
		NO ME SALE 
		*/
	}

}
