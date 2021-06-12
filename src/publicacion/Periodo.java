package publicacion;

import java.util.Calendar;

public class Periodo {
	
	private Calendar fechaInicio;
	private Calendar fechaFin;
	
	
	public Periodo(Calendar inicio, Calendar fin) {
		/**Crea un periodo a partir de dos fechas, si el primer parametro de las fechas es posterior al parametro fin,
		 * los revierte para crear el periodo de inicio a fin.
		 * 
		 */
		if(fin.before(inicio)) {
			this.fechaInicio = inicio;
			this.fechaFin = fin;
		}
		else {
			this.fechaInicio = inicio;
			this.fechaFin = fin;
		}
		
	}
	
	public Calendar getFechaInicio() {
		
		return fechaInicio;
		
	}
	public Calendar getFechaFin() {
		
		return fechaFin;
		
	}
}
