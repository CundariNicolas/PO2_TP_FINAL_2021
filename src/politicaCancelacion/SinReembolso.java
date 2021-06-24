package politicaCancelacion;

import reserva.Reserva;

public class SinReembolso extends PoliticaDeCancelacion {

	/**
	 * es la reserva  parti de la cual se aplica la multa
	 *  {@link Reserva}
	 */
	@Override
	protected void setMulta(Reserva reserva) {
		this.multaAplicada = reserva.precioTotalReserva();
	}

	/**
	 * {@link}
	 * condicion Siempre aplica la multa al cancelar
	 */
	@Override
	protected boolean condicion() {
		return true;
	}

}
