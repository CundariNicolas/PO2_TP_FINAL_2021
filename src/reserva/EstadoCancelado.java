package reserva;

public class EstadoCancelado extends EstadoReserva{
    static EstadoCancelado estado;
	
	private EstadoCancelado(String descripcion) {
		super(descripcion);
	}

	public static EstadoCancelado getInstance() {
		if (estado == null) {
			estado = new EstadoCancelado("Cancelado");
		}
		return estado;
	}

	@Override
	protected void aceptar(Reserva reserva) {
		// nada para hacer ya esta cancelada			
	}

	@Override
	protected void cacelar(Reserva reserva) {
		// nada para hacer ya esta cancelada	
	}

}
