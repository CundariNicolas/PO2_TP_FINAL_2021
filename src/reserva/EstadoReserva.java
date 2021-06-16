package reserva;

public abstract class EstadoReserva  {
	private String descripcion;
	
	protected EstadoReserva(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}

	protected void aceptar(Reserva reserva) {
		// Consolida --> Cambia estado
		reserva.consolidar();
		reserva.setEstado(EstadoConsolidado.getInstance());
	};

	protected void rechazar(Reserva reserva) {
		// No hace nada salvo en el estado Inicial
	};

	protected void cacelar(Reserva reserva) {
		reserva.setEstado(EstadoCancelado.getInstance());
	};

}
