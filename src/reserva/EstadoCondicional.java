package reserva;

public class EstadoCondicional extends EstadoReserva{
	static EstadoCondicional estado;
	
	private EstadoCondicional(String descripcion) {
		super(descripcion);
	}

	public static EstadoCondicional getInstance() {
		if (estado == null) {
			estado = new EstadoCondicional("Condicional");
		}
		return estado;
	}
	@Override
	protected void aceptar(Reserva reserva) {
		super.aceptar(reserva);
		this.notificarCodicionalAceptada(reserva);
	}
	
	private void notificarCodicionalAceptada(Reserva reserva) {
		String mailDestino = reserva.getInquilino().geteMail();
		String asunto = "Reserva Condicional confirmada";
		String mensaje =   "Sue reserva condicional en " 
		                 + reserva.getPublicacion().getInmueble().getCiudad()
		                 + " ha sido confirmada.";
		
		/* se envia el mail de notificacion
		enviarMail(mailDestino, asunto, mensaje);
		*/
	}

	@Override
	protected Boolean esCondicional() {
		return true;
	}
	
	
}
