package inmueble;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import servicios.Servicio;
import tipoInmueble.TipoDeInmueble;

class InmuebleTestCase {

	Inmueble casa; //SUT
	TipoDeInmueble tipoInmueble;
	Servicio agua;
	Servicio gas;
	Servicio luz;
	ArrayList <Servicio> servicios;
	
	@BeforeEach
	void setUp() throws Exception {
		agua = mock(Servicio.class);
		luz = mock(Servicio.class);
		gas = mock(Servicio.class);
		servicios = new ArrayList<>();
		servicios.add(agua);
		servicios.add(gas);
		servicios.add(luz);
		
		tipoInmueble = mock(TipoDeInmueble.class);
		
		casa = new Inmueble (tipoInmueble,
				150.0,
				"Argentina",
				"Buenos Aires", 
				"Gutierrez 1320",
				servicios, 
				150);
		}

	@Test
	void test() {
	}

}
