package publicacion;

import java.util.Calendar;

public class Foto {
	
	private String path;
	private boolean marca360;
	private Calendar fechaCaptura;
	private Integer ancho;
	private Integer alto;
	
	
	
	public Foto(String path, boolean marca360, Calendar fecha, Integer ancho, Integer alto) {
		
		this.path = path;
		this.marca360 = marca360;
		this.fechaCaptura = fecha;
		this.ancho = ancho;
		this.alto = alto;
		 
		
	}



	public String getPath() {
		return path;
	}



	public boolean isMarca360() {
		return marca360;
	}



	public Calendar getFechaCaptura() {
		return fechaCaptura;
	}



	public Integer getAncho() {
		return ancho;
	}



	public Integer getAlto() {
		return alto;
	}

}
