package politicaCancelacion;

import reserva.Reserva;

public class Gratuita extends PoliticaDeCancelacion {
	
	private int diasDeMulta;
	/**
	 * Contrusctor de la clase Gratuita hereda de {@link PoliticaDeCancelacion} y configura en 2 la cantidad de dias de multa
	 */
	Gratuita(){
		super();
		this.setCantidadDiasDeMultas(2);
	}
	/**
	 * Aplica la multa correspondiente a 2 dias de valor de la reserva realizada
	 * Heredado y sobre escrito de {@link PoliticaDeCancelacion} 
	 */
	@Override
	protected void setMulta(Reserva reserva) {
		this.setMultaAplicada(reserva.valorEnCantidadDeDias(this.getCantiadaDeDias()));
	}
	/**
	 * Configura la cantidad de dias de multa, tiene que ser mayor a 0 sino por defecto es 2
	 * @param dias integer
	 */
	public void setCantidadDiasDeMultas(int dias) {
		if (dias > 0 )
		{		this.diasDeMulta = dias;

		}
	}
	 /**
	  * Muestra la cantidad de dias de multa que tiene asignado actualmente
	  * @return
	  */
	public int getCantiadaDeDias() {
		return this.diasDeMulta;
	}

	/**
	 * es la conducion para la cual aplica la multa
	 * 	
	 * Heredado {@link PoliticaDeCancelacion}
	 */
	@Override
	protected boolean condicion() {
		return  (this.diferenciaEnDias <= 10);
	}

}
