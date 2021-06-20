package politicaCancelacion;

import java.util.ArrayList;

import publicacion.PrecioPeriodo;
import reserva.Reserva;

public class Gratuita extends PoliticaDeCancelacion {
	Gratuita(){
		super();
	}

	/**
	 * Cancelación gratuita hasta 10 días antes de la fecha de inicio de la
	 *	ocupación y luego abona el equivalente a dos días de reserva.
	 */
	
		
	@Override
	protected void setMulta(Reserva reserva) {
	
		int cantidadDeDiasDeMulta=2;
		Double precioAcumulado = 0.0;
		
		ArrayList<PrecioPeriodo> diasDeReserva = reserva.getPublicacion().getPrecio();
		for (int pocicion = 0; pocicion < cantidadDeDiasDeMulta ; pocicion ++ ) {
			precioAcumulado += diasDeReserva.get(pocicion).getPrecio();
		}
		
		/*
		 * this.multpaAplicada =  reserva.ValorDeCantidaDeDias(cantidadDeDiasDeMulta);
		 */
		
		this.multaAplicada = precioAcumulado;
	}

	@Override
	protected boolean condicion() {
	
		return  (this.diferenciaEnDias >= 10 && this.diferenciaEnDias < 2) || (this.diferenciaEnDias >= 2 );
	}

}
