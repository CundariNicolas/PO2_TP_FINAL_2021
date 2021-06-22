package categoria;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class CategoriaInmuebleTestCase {

	CategoriaInmueble categoria;
	
	@BeforeEach
	void setUp() throws Exception {
		categoria = new CategoriaInmueble("Limpieza");
	}
	
	@Test
	void seCreaUnaCategoriaCorrectamente() {
		assertEquals("Limpieza",categoria.getDescripcion());
	}

}
