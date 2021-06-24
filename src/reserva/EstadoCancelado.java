package reserva;

public class EstadoCancelado extends EstadoReserva{
    static EstadoCancelado estado;
	
	private EstadoCancelado(String descripcion) {
		super(descripcion);
	}

	/**
	 * Devuleve la instancia única de estado cancelado
	 * 
	 * @return EstadoCancelado
	 */
	public static EstadoCancelado getInstance() {
		if (estado == null) {
			estado = new EstadoCancelado("Cancelado");
		}
		return estado;
	}

	@Override
	/**
	 * Metodo sin efecto en este estado
	 */
	protected void aceptar(Reserva reserva) {
		// nada para hacer ya esta cancelada			
	}

	@Override
	/**
	 * Metodo sin efecto en este estado
	 */
	protected void cancelar(Reserva reserva) {
		// nada para hacer ya esta cancelada	
	}

}
