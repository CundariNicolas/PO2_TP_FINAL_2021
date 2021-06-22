package categoria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class CategoriaUsuarioTestCase {

	CategoriaUsuario categoria;
	
	@BeforeEach
	void setUp() throws Exception {
		categoria = new CategoriaUsuario("Puntualidad");
	}
	
	@Test
	void seCreaUnaCategoriaCorrectamente() {
		assertEquals("Puntualidad",categoria.getDescripcion());
	}
}


