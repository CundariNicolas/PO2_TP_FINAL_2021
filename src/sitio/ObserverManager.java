package sitio;

import java.util.ArrayList;

import publicacion.Publicacion;
import reserva.Reserva;

public class ObserverManager {
	private static ObserverManager manager;
	private static ArrayList<Observador> observadoresCancelacion;
	private static ArrayList<Observador> observadoresPrecio;
	private static ArrayList<Observador> observadoresReserva;
	
	private ObserverManager() {
		this.setObservadoresCancelacion( new ArrayList<>() );
		this.setObservadoresPrecio( new ArrayList<>() );
		this.setObservadoresReserva( new ArrayList<>() );
	}
	
	public static ObserverManager getInstance() {
		if (manager == null) {
			manager = new ObserverManager();
		}
		return manager;
	}
	
	private static ArrayList<Observador> getObservadoresCancelacion() {
		return observadoresCancelacion;
	}

	private static void setObservadoresCancelacion(ArrayList<Observador> observadoresCancelacion) {
		ObserverManager.observadoresCancelacion = observadoresCancelacion;
	}

	private static ArrayList<Observador> getObservadoresPrecio() {
		return observadoresPrecio;
	}

	private static void setObservadoresPrecio(ArrayList<Observador> observadoresPrecio) {
		ObserverManager.observadoresPrecio = observadoresPrecio;
	}

	private static ArrayList<Observador> getObservadoresReserva() {
		return observadoresReserva;
	}

	private static void setObservadoresReserva(ArrayList<Observador> observadoresReservan) {
		ObserverManager.observadoresReserva = observadoresReserva;
	}
	
	public void suscribirACancelacion(Observador observador) {
		this.observadoresCancelacion.add(observador);
	}
	
	public void suscribirABajaDePrecio(Observador observador) {
		this.observadoresPrecio.add(observador);
	}
	
	public void suscribirReserva(Observador observador) {
		this.observadoresReserva.add(observador);
	}
	
	public void alertarCancelacion(Reserva reserva) {
		ArrayList<Observador> subList; 
		subList = (ArrayList<Observador>) this.getObservadoresCancelacion().stream().filter(observador -> observador.getPublicacion().getInmueble() == reserva.getPublicacion().getInmueble());
		this.notificarCambio(subList);
	}
	
	public void alertarBajaDePrecio(Publicacion publicacion) {
		ArrayList<Observador> subList; 
		subList = (ArrayList<Observador>) this.getObservadoresPrecio().stream().filter(observador -> observador.getPublicacion().getInmueble() == publicacion.getInmueble());
		this.notificarCambio(subList);
	}
	
	public void alertarReserva(Publicacion publicacion) {
		this.notificarCambio(this.getObservadoresReserva());
	}
	
	private void notificarCambio(ArrayList<Observador> observador) {
		observador.forEach(obs -> obs.notificar());
	}


}
