package publicacion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inmueble.Inmueble;
import sitio.Observador;
import usuario.Usuario;

class PublicacionTestCase {
	
	/*SUT*/
	Publicacion publicacion1;
	/* DOC */
	Usuario usuario;
	Inmueble inmueble;
	Calendar inicio;
	Calendar fin;
	ArrayList<Foto> fotos;
	ArrayList<PrecioDiaOcupacion> precioPorDia;
	
	
	Calendar inicioPeriodoOcupado;
	Calendar finPeriodoOcupado;
	
	Calendar inicioPeriodoAOcupar;
	Calendar finPeriodoAOcupar;
	
	Observador observador1;
	Observador observador2;
	Observador observador3;

	
	
	@BeforeEach
	void setUp() throws Exception {
	// DOC
	usuario = mock(Usuario.class);
	inmueble = mock(Inmueble.class);
	inicio = Calendar.getInstance();
	fin = Calendar.getInstance();
	fotos = new ArrayList<Foto>();
	precioPorDia = new ArrayList<PrecioDiaOcupacion>();
	
	// SUT
		publicacion1 = new Publicacion(usuario, inmueble, inicio, fin, fotos, precioPorDia);

	}
	
	/* Test registrarOcupacion */
	@Test
	void registrarOcupacion() {
		
	}
	


}
