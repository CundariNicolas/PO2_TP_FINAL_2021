package reserva;

import java.util.Calendar;

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
		Sitio.procesarReservaCancelada(reserva);
		reserva.getPublicacion().registrarCancelacion(reserva.getFechaInicio(), reserva.getFechaFin());
		this.notificarCancelacion(reserva);
	}
	
	private void notificarCancelacion(Reserva reserva) {
		String mailDestino = reserva.getPublicacion().getPropietario().geteMail();
		String asunto = "Reserva CANCELADA";
		String mensaje =   "Fue cancelada ua reserva en " 
		                 + reserva.getPublicacion().getInmueble().getCiudad()
		                 + " .";
		
		/* se envia el mail de notificacion
		enviarMail(mailDestino, asunto, mensaje);
		*/
	}
	
	@Override
	protected Boolean estaFinalizada(Reserva reserva) {
		return     reserva.getFechaFin().before(Calendar.getInstance()) 
				&& reserva.getPublicacion().getInmueble().getCheckOUT() < Calendar.getInstance().HOUR_OF_DAY;
		
	}
}
