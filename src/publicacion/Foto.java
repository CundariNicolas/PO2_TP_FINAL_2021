package publicacion;

import java.util.Calendar;

public class Foto {
	
	String path;
	boolean marca360;
	Calendar fechaCaptura;
	Integer ancho;
	Integer alto;
	
	
	public Foto(String path, boolean marca360, Calendar fecha, Integer ancho, Integer alto) {
		
		this.path = path;
		this.marca360 = marca360;
		this.fechaCaptura = fecha;
		this.ancho = ancho;
		this.alto = alto;
		
	}

}
