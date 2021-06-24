package publicacion;

import java.util.Calendar;

public class PrecioDiaOcupacion {
	private Calendar fecha;
	private boolean ocupado;
	private double precio;
	
	
	/**
	 * Retorna una instancia de PrecioDiaOcupacion
	 * @param fecha Calendar
	 * @param precio double
	 * @return PrecioDiaOcupacion
	 */
	public PrecioDiaOcupacion(Calendar fecha, double precio) {
		
		this.fecha = fecha;
		this.precio = precio;
		this.ocupado = false;
	}
	
	/**
	 * Indica si esta ocupado el inmueble al que esta asociado
	 * @return boolean
	 */
	public boolean estaOcupado() {
		
		return ocupado;
	}
	
	/**
	 * Retorna la fecha del dia que representa
	 * @return Calendar
	 */
	public Calendar getFecha() {
		
		return fecha;
	}
	
	/**
	 * Retorna el precio del dia representado
	 * @return double
	 */
	public double getPrecio() {
		
		return precio;
	}
	
	/**
	 * Setea el precio
	 * @param precio double
	 * @return void
	 */
	public void setPrecio(double precio) {
		
		this.precio = precio;
	}
	
	/**
	 * Cambia el precio de un dia dado y si es menor al anterior, la publicacion notifica la baja de precio
	 * @param precio double
	 * @param publicacion Publicacion
	 * @return void
	 */
	public void setPrecio(double precio, Publicacion publicacion) {
		if(precio <= this.getPrecio()) {
			publicacion.notificarBajaEnPrecio();
		}
		this.setPrecio(precio);
	}
	
	
	/**Cambia el estado a ocupado
	 * @return void
	 */
	public void setOcupado() {
		this.ocupado = true;
	}
	
	/**Cambia el estado a libre
	 * @return void
	 */
	public void setLibre() {
		
		this.ocupado = false;
	}
}
