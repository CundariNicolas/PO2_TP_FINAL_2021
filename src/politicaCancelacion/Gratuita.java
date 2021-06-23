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
		this.multaAplicada = reserva.valorEnCantidadDeDias(this.diasDeMulta);
	}

	public void setCantidadDiasDeMultas(int dias) {
		this.diasDeMulta = dias;
	}

	@Override
	protected boolean condicion() {
		return  (this.diferenciaEnDias >= 10 && this.diferenciaEnDias < 2) || (this.diferenciaEnDias >= 2 );
	}

}
