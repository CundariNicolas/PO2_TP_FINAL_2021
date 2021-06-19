package reserva;

import sitio.Sitio;

public class EstadoConsolidado extends EstadoReserva{
    static EstadoConsolidado estado;
	
	private EstadoConsolidado(String descripcion) {
		super(descripcion);
	}

	public static EstadoConsolidado getInstance() {
		if (estado == null) {
			estado = new EstadoConsolidado("Consolidado");
		}
		return estado;
	}
	
	@Override
	protected void aceptar(Reserva reserva) {
		// Nada para hacer
	}

	@Override
	protected void cacelar(Reserva reserva) {
		super.cacelar(reserva);
		this.notificarCancelacion(reserva);
	}
	
	private void notificarCancelacion(Reserva reserva) {
		Sitio.procesarReservaCancelada(reserva);
	}

}
