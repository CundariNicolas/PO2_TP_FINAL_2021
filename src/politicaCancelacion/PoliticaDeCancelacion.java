package politicaCancelacion;

import java.util.Calendar;
import java.util.GregorianCalendar;

import reserva.Reserva;

public abstract class PoliticaDeCancelacion {
	
	/**
	 * El sistema permite indicar diferentes formas de resarcimiento que un
		propietario puede percibir en caso que un inquilino cancele una reserva. Esto se
		llama política de cancelación. Cada propietario puede indicar cual será la política de
		cancelación que aplica sobre la propiedad que publica. En principio hay tres tipos de
		políticas de cancelación, aunque podrían sumarse otras:
			
			● Cancelación gratuita hasta 10 días antes de la fecha de inicio de la
		ocupación y luego abona el equivalente a dos días de reserva.
			
			● Sin cancelación: en caso de cancelar el usuario de todas formas paga
		los días que había reservado.
			
			● Intermedia: Hasta 20 días antes es gratuita, entre el día 19 anterior y el
		día 10 anterior paga el 50 %, después del 10mo día paga la totalidad.
	 */
	
	//private String descripcion;
	
	protected int diferenciaEnDias;
	protected Double multaAplicada;
	
	PoliticaDeCancelacion () {
		super();
		this.multaAplicada = 0.0;
	}
	
	abstract protected void setMulta(Reserva reserva);
	abstract protected boolean condicion ();	
	
	public double aplicar (Reserva reserva) {
		this.setDiferenciaEnDias(reserva);
		if (this.condicion()) {
			//this.setMulta(this.multa(reserva)); 
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
