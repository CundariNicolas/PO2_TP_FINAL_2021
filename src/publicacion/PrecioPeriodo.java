package publicacion;

import java.util.Calendar;

public class PrecioPeriodo {
	
	Calendar fechaInicio;
	Calendar fechaFin;
	Integer precio;
	
	public PrecioPeriodo(Calendar inicio, Calendar fin,Integer precio) {
		this.fechaInicio = inicio;
		this.fechaFin = fin;
		this.precio = precio;
	}
	
	
	

}
