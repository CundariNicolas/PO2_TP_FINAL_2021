package sitio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.platform.engine.support.hierarchical.Node.ExecutionMode;

import inmueble.Inmueble;
import publicacion.Foto;
import publicacion.PrecioDiaOcupacion;
import publicacion.Publicacion;
import reserva.Reserva;
import usuario.Usuario;

class ObserverManagerTest {
	ObserverManager manager;
	
	AppMobile app = mock(AppMobile.class);
	PaginaWeb pag = mock(PaginaWeb.class);
	Reserva reserva = mock(Reserva.class);
	Publicacion publicacion = mock(Publicacion.class);
	Inmueble inmueble = mock(Inmueble.class);
	
	
	@BeforeEach
	void setUP() {
		manager = ObserverManager.getInstance();
	}

	@Test
	void testGetInstance() {
		assertEquals(manager.getClass(), ObserverManager.class);
	}

	@Test
	void testAlertarCancelacion() {
		when(app.getPublicacion()).thenReturn(publicacion);
		when(reserva.getPublicacion()).thenReturn(publicacion);
		when(publicacion.getInmueble()).thenReturn(inmueble);
		
		manager.suscribirACancelacion(app);
		manager.alertarCancelacion(reserva);
		verify(app, times(1)).getPublicacion();
		verify(app, times(1)).notificar();
	}
	
	@Test
	void testSuscribirABajaDePrecio() {
		assertDoesNotThrow(() -> manager.suscribirABajaDePrecio(pag));
	}

	@Test
	void testSuscribirReserva() {
		assertDoesNotThrow(() -> manager.suscribirReserva(app));
	}

	@Test
	void testAlertarBajaDePrecio() {
		when(pag.getPublicacion()).thenReturn(publicacion);
		when(publicacion.getInmueble()).thenReturn(inmueble);
		
		manager.suscribirABajaDePrecio(pag);
		manager.alertarBajaDePrecio(publicacion);
		verify(pag, times(1)).getPublicacion();
		verify(pag, times(1)).notificar();
	}

	@Test
	void testAlertarReserva() {
		manager.suscribirReserva(pag);
		manager.alertarReserva(publicacion);
		
		verify(pag, times(1)).notificar();
		assertDoesNotThrow(() -> manager.alertarReserva(publicacion));
	}
	
	@Test
	void testSuscribirACancelacion() {
		try {
            Thread.sleep(20);
         } catch (Exception e) {
        	 assertDoesNotThrow(() -> manager.suscribirACancelacion(app));
         }
		
	}


}
