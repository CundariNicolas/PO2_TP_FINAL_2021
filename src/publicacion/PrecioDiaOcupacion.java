package publicacion;

<<<<<<< HEAD
import java.util.Calendar;
=======
public class PrecioDiaOcupacion {
	
	public Double getPrecio() {
		return 1.5;
	}
>>>>>>> branch 'main' of https://github.com/gmauge/PO2_TP_FINAL_2021.git

public class PrecioDiaOcupacion {
	private Calendar fecha;
	private boolean ocupado;
	private double precio;
	
	public PrecioDiaOcupacion(Calendar fecha, double precio) {
		/** constructor de un dia con su precio */
		this.fecha = fecha;
		this.precio = precio;
		this.ocupado = false;
	}
	public boolean estaOcupado() {
		/** retorna  si el dia esta ocupado */
		return ocupado;
	}
	public Calendar getFecha() {
		/** la fecha de el dia representado */
		return fecha;
	}
	
	public double getPrecio() {
		/** el precio del dia representado */
		return precio;
	}
	
	public void setPrecio(double precio) {
		/** cambia el precio por dia */
		this.precio = precio;
	}
	
	public void setOcupado() {
		/** cambia el estado a ocupado */
		this.ocupado = true;
	}
	public void setLibre() {
		/** cambia el estado a desocupado */
		this.ocupado = false;
	}
}
