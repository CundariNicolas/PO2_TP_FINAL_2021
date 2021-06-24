package politicaCancelacion;

import java.util.Calendar;
import java.util.GregorianCalendar;

import reserva.Reserva;

public abstract class PoliticaDeCancelacion {
	
	
	
	//private String descripcion;
	
	protected int diferenciaEnDias;
	protected Double multaAplicada;
	
	PoliticaDeCancelacion () {
		super();
		this.multaAplicada = 0.0; 
	}
	
	abstract protected void setMulta(Reserva reserva);
	abstract protected boolean condicion ();	
	/**
	 * 
	 * Aplica la politica de cancelacion si corresponde
	 *@param reserva una reserva
	 *@return double
	 *
	 *
	 */
	public double aplicar (Reserva reserva) {
		
		this.setDiferenciaEnDias(reserva);
		if (this.condicion()) {
			this.setMulta(reserva);
		}
		return this.getMultaAplicada();
	}

	protected void setDiferenciaEnDias(Reserva reserva) {
		Calendar fechaActual = new GregorianCalendar();
		long diferencia = fechaActual.getTimeInMillis() - reserva.getFechaInicio().getTimeInMillis();
		this.diferenciaEnDias =(int) diferencia/1000/60/60/24;
	}
	
	protected int getDiferenciaEnDias() {
		return this.diferenciaEnDias;
	}
	
	protected Double getMultaAplicada() {
		return this.multaAplicada;
	}
	
	
}
