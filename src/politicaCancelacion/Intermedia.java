package politicaCancelacion;

import reserva.Reserva;

public class Intermedia extends PoliticaDeCancelacion {
	/**
	 *
	 * Intermedia: Hasta 20 días antes es gratuita, entre el día 19 anterior y el
	*  día 10 anterior paga el 50 %, después del 10mo día paga la totalidad
	 */
	Intermedia (){
		super();
	}

	 /**
	  * Hasta 20 dias antes es gratuita, entre el dia 19 anterior y el
	  *	dia 10 anterior paga el 50 %, después del 10mo dia paga la totalidad
	  * {@link PoliticaDeCancelacion}
	  */
	@Override
	protected void setMulta(Reserva reserva) {
		if (this.diferenciaEnDias >= 10) {
			this.multaAplicada = reserva.precioTotalReserva() / 2;
		}
		this.multaAplicada = reserva.precioTotalReserva();

	}

	/**
	 * {@link PoliticaDeCancelacion}
	 */
	@Override
	protected boolean condicion() {
		return (this.diferenciaEnDias < 20);
	}

	

}
