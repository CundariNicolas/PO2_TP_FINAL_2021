package sitio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import publicacion.Publicacion;

class AppMobileTest {
	AppMobile app;
	Publicacion publicacion = mock(Publicacion.class);
	
	@BeforeEach
	void setUP() {
		app = new AppMobile(publicacion);
	}

	@Test
	void testGetPublicacion() {
		assertEquals(app.getPublicacion().getClass(), Publicacion.class);
	}

	@Test
	void testNotificar() {
		assertDoesNotThrow(() -> app.notificar());
	}
	@Test
	void testAppMobile() {
		assertEquals(app.getClass(), AppMobile.class);
	}	

}
