package reserva;

public class EstadoInicial extends EstadoReserva{
	static EstadoInicial estado;
	
	private EstadoInicial(String descripcion) {
		super(descripcion);
	}

	/**
	 * Devuleve la instancia �nica de estado inicial
	 * 
	 * @return EstadoInicial
	 */
	public static EstadoInicial getInstance() {
		if (estado == null) {
			estado = new EstadoInicial("Inicial");
		}
		return estado;
	}

	@Override
	/**
	 * Transicion a estado aceptado
	 * 
	 * @param reserva Reserva
	 */
	protected void aceptar(Reserva reserva) {
		super.aceptar(reserva);
		this.notificarAceptacion(reserva);
	}

	@Override
	/**
	 * Transiciona estado rechazado
	 * 
	 * @param reserva Reserva
	 */
	protected void rechazar(Reserva reserva) {
		reserva.setEstado(EstadoRechazado.getInstance());
	}
	
	private void notificarAceptacion(Reserva reserva) {
		String mailDestino = reserva.getInquilino().geteMail();
		String asunto = "Reserva confirmada";
		String mensaje =   "Su reserva en " 
		                 + reserva.getPublicacion().getCiudadInmueble()
		                 + " ha sido confirmada.";
		
		/* se envia el mail de notificacion
		enviarMail(mailDestino, asunto, mensaje);
		*/
	}
	

}
