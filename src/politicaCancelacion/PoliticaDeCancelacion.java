package politicaCancelacion;

import java.util.Calendar;
import java.util.GregorianCalendar;

import reserva.Reserva;

public abstract class PoliticaDeCancelacion {
	
	
	
	//private String descripcion;
	
	protected int diferenciaEnDias;
	protected Double multaAplicada;
	
	/**
	 * Contructor de la Clase por defecto la multa Aplicada internamente es 0
	 */
	PoliticaDeCancelacion () {
		super();
		multaAplicada = 0.0;
	}
	
	/**
	 * es a partir de la cual se aplicaran las multas correspondientes
	 * @param reserva {@link Reserva}
	 */
	abstract protected void setMulta(Reserva reserva);
	
	/**
	 * 
	 * @return boolean es la condicion por la cual se va a aplicar la multa.
	 */
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
	/**
	 * a Partir de {@link Reserva} obtiene la diferencia con la hora actual a partir de la reserva, contandolo en dias desde comienzo de año
	 * @param reserva {@link Reserva}
	 */
	protected void setDiferenciaEnDias(Reserva reserva) {
		Calendar fechaActual = new GregorianCalendar();
		fechaActual.get (Calendar.DAY_OF_YEAR);
		int diferencia = reserva.getFechaInicio().get(Calendar.DAY_OF_YEAR) -  fechaActual.get (Calendar.DAY_OF_YEAR);
		this.diferenciaEnDias= diferencia; 
	}
	
	
	/**
	 * Aplica el valor de la multa
	 * @param unValor
	 */
	protected void setMultaAplicada(double unValor) {
		this.multaAplicada = unValor;
	}
	
	
}
