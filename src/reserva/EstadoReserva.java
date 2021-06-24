package reserva;

public abstract class EstadoReserva  {
	private String descripcion;
	
	protected EstadoReserva(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * Devuleve la descripcion del estado
	 * 
	 * @return String descripcion del estado
	 */
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * Pasa una reseerva a estado cnsolidado
	 * 
	 * @param reserva Reserva
	 */
	protected void aceptar(Reserva reserva) {
		// Consolida --> Cambia estado
		reserva.getPublicacion().registrarOcupacion(reserva.getFechaInicio(), reserva.getFechaFin());
		reserva.setEstado(EstadoConsolidado.getInstance());
	};

	/**
	 * Sin efecto en esta clase
	 */
	protected void rechazar(Reserva reserva) {
		// No hace nada salvo en el estado Inicial
	};

	/**
	 * Pasa una reserva a estado candelad
	 * 
	 * @param reserva Reserva
	 */
	protected void cancelar(Reserva reserva) {
		reserva.setEstado(EstadoCancelado.getInstance());
	}

	/**
	 * Si una reserva es condicional.
	 * Por defecto FALSO
	 * 
	 * @return Boolean
	 */
	protected Boolean esCondicional() {
		return false;
	}

	/**
	 * Si uan reseerva esta finalizada.
	 * Por defecto es FALSO
	 * 
	 * @param reserva Reserva
	 * @return Boolean
	 */
	protected Boolean estaFinalizada(Reserva reserva) {
		return false;
	}

	/**
	 * Si una reserva se concreto.
	 * Por defecto es FALSO
	 * 
	 * @return Boolean 
	 */
	public Boolean seConcreto() {
		return false;
	}

}
