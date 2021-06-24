package politicaCancelacion;

import reserva.Reserva;

public class SinReembolso extends PoliticaDeCancelacion {

	@Override
	protected void setMulta(Reserva reserva) {
		this.multaAplicada = reserva.precioTotalReserva();
	}

	@Override
	protected boolean condicion() {
		return true;
	}

}
