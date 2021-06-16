package reserva;

public class EstadoInicial extends EstadoReserva{
	static EstadoInicial estado;
	
	private EstadoInicial(String descripcion) {
		super(descripcion);
	}

	public static EstadoReserva getInstance() {
		if (estado == null) {
			estado = new EstadoInicial("Inicial");
		}
		return estado;
	}

	@Override
	protected void aceptar(Reserva reserva) {
		super.aceptar(reserva);
		this.notificarAceptacion(reserva);
	}

	@Override
	protected void rechazar(Reserva reserva) {
		reserva.setEstado(EstadoRechazado.getInstance());
	}
	
	private void notificarAceptacion(Reserva reserva) {
		String mailDestino = reserva.getInquilino().geteMail();
		String asunto = "Reserva confirmada";
		String mensaje =   "Sue reserva en " 
		                 + reserva.getPublicacion().getInmueble().getCiudad()
		                 + " ha sido confirmada.";
		
		/* se envia el mail de notificacion
		enviarMail(mailDestino, asunto, mensaje);
		*/
	}
	

}
