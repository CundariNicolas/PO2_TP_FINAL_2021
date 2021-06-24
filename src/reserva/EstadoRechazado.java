package reserva;

public class EstadoRechazado extends EstadoReserva{
    static EstadoRechazado estado;
	
	private EstadoRechazado(String descripcion) {
		super(descripcion);
	}

	/**
	 * Devuleve la instancia única de estado rechazado 
	 * 
	 * @return EstadoRechazado
	 */
	public static EstadoRechazado getInstance() {
		if (estado == null) {
			estado = new EstadoRechazado("Rechazado");
		}
		return estado;
	}

	/**
	 * Metodo sin efecto en este estado
	 */
	protected void aceptar(Reserva reserva) {
		// Nada para hacee
	};

	/**
	 * Metodo sin efecto en este estado
	 */
	protected void rechazar(Reserva reserva) {
		// Nada para hacee
	};
	
}
