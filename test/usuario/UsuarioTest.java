package usuario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {

	private Usuario pedroRuiz;
	
	@BeforeEach
    public void setUp() throws Exception {
        //Se crea el usuario
        pedroRuiz = new Usuario("Pedro", "Ruiz","Av. Rivadavia 100", "pedroRuiz@gmail.com", 42229000);
    }
 
// Verifica nombre
    @Test
    public void testNombre() {
    	   	
        // Getting the even occurrences
        String nombre = pedroRuiz.getNombre();
                
        // I check the amount is the expected one
        assertEquals(nombre, "Pedro");
    }

// Verifica apellido
    @Test
    public void testApellido() {
    	   	
        // Getting the even occurrences
        String apellido = pedroRuiz.getApellido();
                
        // I check the amount is the expected one
        assertEquals(apellido, "Ruiz");
    }
    
// Verifica domicilio
    @Test
    public void testDomicilio() {
    	   	
        // Getting the even occurrences
        String domicilio = pedroRuiz.getDomicilio();
                
        // I check the amount is the expected one
        assertEquals(domicilio, "Av. Rivadavia 100");
    }
    
 // Verifica nombre y apellido
    @Test
    public void testNombreYApellido() {
    	   	
        // Getting the even occurrences
        String nomApe = pedroRuiz.getNombreYApellido();
                
        // I check the amount is the expected one
        assertEquals(nomApe, "Pedro Ruiz");
    }
    
 // Verifica email
    @Test
    public void testMail() {
    	   	
        // Getting the even occurrences
        String mail = pedroRuiz.geteMail();
                
        // I check the amount is the expected one
        assertEquals(mail, "pedroRuiz@gmail.com");
    }
    
 // Verifica telefono
    @Test
    public void testTelefono() {
    	   	
        // Getting the even occurrences
        Integer telefono = pedroRuiz.getTelefono();
                
        // I check the amount is the expected one
        assertEquals(telefono, 42229000);
    }
    
 // Verifica antiguedad
    @Test
    public void testAntiguedadComoUsuario() {
    	   	
        // Getting the even occurrences
        Integer dias = pedroRuiz.antiguedadComoUsuario();
                
        // I check the amount is the expected one
        assertEquals(dias, 0);
    }
}
