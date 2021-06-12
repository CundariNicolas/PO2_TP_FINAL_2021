package publicacion;

import java.util.Calendar;

public class PrecioPeriodo {
	
	private Calendar fechaInicio;
	private Calendar fechaFin;
	private Integer precio;
	
	public PrecioPeriodo(Calendar inicio, Calendar fin,Integer precio) {
		this.fechaInicio= inicio;
		this.fechaFin = fin;
		this.precio = precio;
	}

	public Calendar getFechaInicio() {
		return fechaInicio;
	}

	public Calendar getFechaFin() {
		return fechaFin;
	}

	public Integer getPrecio() {
		return precio;
	}


	
	

}
