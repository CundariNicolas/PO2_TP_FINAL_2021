package reserva;

public class EstadoCondicional extends EstadoReserva{
	static EstadoCondicional estado;
	
	private EstadoCondicional(String descripcion) {
		super(descripcion);
	}

	/**
	 * Devuleve la instancia única de estado condicional
	 * 
	 * @return EstadoCondicional
	 */
	public static EstadoCondicional getInstance() {
		if (estado == null) {
			estado = new EstadoCondicional("Condicional");
		}
		return estado;
	}
	@Override
	/**
	 * Transiciona a consolidada la reserva
	 * 
	 * @param reserva Reserva
	 */
	protected void aceptar(Reserva reserva) {
		super.aceptar(reserva);
		this.notificarCodicionalAceptada(reserva);
	}
	
	private void notificarCodicionalAceptada(Reserva reserva) {
		String mailDestino = reserva.getInquilino().geteMail();
		String asunto = "Reserva Condicional confirmada";
		String mensaje =   "Su reserva condicional en " 
		                 + reserva.getPublicacion().getCiudadInmueble()
		                 + " ha sido confirmada.";
		
		/* se envia el mail de notificacion
		enviarMail(mailDestino, asunto, mensaje);
		*/
	}

	@Override
	/**
	 * Evalua si la reserva es condiciona
	 */
	protected Boolean esCondicional() {
		return true;
	}
	
	
}
