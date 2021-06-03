package publicacion;

import java.util.Calendar;

public class Periodo {
	
	private Calendar fechaInicio;
	private Calendar fechaFin;
	
	
	public Periodo(Calendar inicio, Calendar fin) {
		
		this.fechaInicio = inicio;
		this.fechaFin = fin;
		
	}
	
	public Calendar fechaInicio() {
		
		return fechaInicio;
		
	}
	public Calendar fechaFin() {
		
		return fechaFin;
		
	}
}
