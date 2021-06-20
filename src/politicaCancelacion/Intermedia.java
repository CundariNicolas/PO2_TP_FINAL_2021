package politicaCancelacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import publicacion.PrecioPeriodo;
import reserva.Reserva;

public class Intermedia extends PoliticaDeCancelacion {
	/**
	 *
	 * Intermedia: Hasta 20 días antes es gratuita, entre el día 19 anterior y el
	*  día 10 anterior paga el 50 %, después del 10mo día paga la totalidad
	 */
	

	@Override
	protected void setMulta(Reserva reserva) {
		if (this.diferenciaEnDias >= 10) {
			this.multaAplicada = reserva.precioTotalReserva() / 2;
		}
		this.multaAplicada = reserva.precioTotalReserva();

	}

	@Override
	protected boolean condicion() {
		return (this.diferenciaEnDias < 20);
	}

	

}
