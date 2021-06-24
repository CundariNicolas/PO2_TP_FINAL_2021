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
		multaAplicada = 0.0;
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
		return this.multaAplicada;
	}

	protected void setDiferenciaEnDias(Reserva reserva) {
		Calendar fechaActual = new GregorianCalendar();
		fechaActual.get (Calendar.DAY_OF_YEAR);
		int diferencia = reserva.getFechaInicio().get(Calendar.DAY_OF_YEAR) -  fechaActual.get (Calendar.DAY_OF_YEAR);
		this.diferenciaEnDias= diferencia; 
	}
	
	
	
	protected void setMultaAplicada(double unValor) {
		this.multaAplicada = unValor;
	}
	
	
}
