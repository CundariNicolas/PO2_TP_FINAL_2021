package reserva;

public class EstadoRechazado extends EstadoReserva{
    static EstadoRechazado estado;
	
	private EstadoRechazado(String descripcion) {
		super(descripcion);
	}

	public static EstadoRechazado getInstance() {
		if (estado == null) {
			estado = new EstadoRechazado("Rechazado");
		}
		return estado;
	}

	protected void aceptar(Reserva reserva) {
		// Nada para hacee
	};

	protected void rechazar(Reserva reserva) {
		// Nada para hacee
	};
	
}
