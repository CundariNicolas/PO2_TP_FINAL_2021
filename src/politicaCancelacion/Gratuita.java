package politicaCancelacion;

import reserva.Reserva;

public class Gratuita extends PoliticaDeCancelacion {
	
	private int diasDeMulta;
	
	Gratuita(){
		super();
		this.setCantidadDiasDeMultas(2);
	}

	@Override
	protected void setMulta(Reserva reserva) {
		this.setMultaAplicada(reserva.valorEnCantidadDeDias(this.getCantiadaDeDias()));
	}

	public void setCantidadDiasDeMultas(int dias) {
		this.diasDeMulta = dias;
	}
	
	public int getCantiadaDeDias() {
		return this.diasDeMulta;
	}

	@Override
	protected boolean condicion() {
		return  (this.diferenciaEnDias <= 10);
	}

}
