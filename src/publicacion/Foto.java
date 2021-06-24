package publicacion;

import java.util.Calendar;

public class Foto {
	
	private String path;
	private boolean marca360;
	private Calendar fechaCaptura;
	private Integer ancho;
	private Integer alto;
	
	
	/**
	 * Retorna una instancia de la clase Foto
	 * @param path String
	 * @param marca360 boolean
	 * @param fecha Calendar
	 * @param ancho Integer
	 * @param alto Integer
	 * @return Foto
	 */
	public Foto(String path, boolean marca360, Calendar fecha, Integer ancho, Integer alto) {
		
		this.path = path;
		this.marca360 = marca360;
		this.fechaCaptura = fecha;
		this.ancho = ancho;
		this.alto = alto;
		 
		
	}


	
	/**
	 * Retorna la ruta donde esta alojada la foto
	 * @return String
	 */
	public String getPath() {
		return path;
	}


	/**
	 * Indica si la foto es 360
	 * @return boolean
	 */
	public boolean isMarca360() {
		return marca360;
	}


	
	/**
	 * Retorna la fecha de captura de la foto
	 * @return Calendar
	 */
	public Calendar getFechaCaptura() {
		return fechaCaptura;
	}


	/**
	 * Retorna el ancho de la foto
	 * @return Integer
	 */
	public Integer getAncho() {
		return ancho;
	}


	/**
	 * Retorna el alto de la foto
	 * @return Integer
	 */
	public Integer getAlto() {
		return alto;
	}

}
