package sitio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import publicacion.Publicacion;
import reserva.Reserva;

public class ObserverManager {
	private static ObserverManager manager;
	private static List<Observador> observadoresCancelacion;
	private static List<Observador> observadoresPrecio;
	private static List<Observador> observadoresReserva;
	
	private ObserverManager() {
		ObserverManager.setObservadoresCancelacion( new ArrayList<>() );
		ObserverManager.setObservadoresPrecio( new ArrayList<>() );
		ObserverManager.setObservadoresReserva( new ArrayList<>() );
	}
	
	public static ObserverManager getInstance() {
		if (manager == null) {
			manager = new ObserverManager();
		}
		return manager;
	}
	
	private static List<Observador> getObservadoresCancelacion() {
		return observadoresCancelacion;
	}

	private static void setObservadoresCancelacion(List<Observador> observadores) {
		observadoresCancelacion = observadores;
	}

	private static List<Observador> getObservadoresPrecio() {
		return observadoresPrecio;
	}

	private static void setObservadoresPrecio(List<Observador> observadores) {
		observadoresPrecio = observadores;
	}

	private static List<Observador> getObservadoresReserva() {
		return observadoresReserva;
	}

	private static void setObservadoresReserva(List<Observador> observadores) {
		observadoresReserva = observadores;
	}
	
	public void suscribirACancelacion(Observador observador) {
		ObserverManager.observadoresCancelacion.add(observador);
	}
	
	public void suscribirABajaDePrecio(Observador observador) {
		ObserverManager.observadoresPrecio.add(observador);
	}
	
	public void suscribirReserva(Observador observador) {
		ObserverManager.observadoresReserva.add(observador);
	}
	
	public void alertarCancelacion(Reserva reserva) {
		List<Observador> subList = new ArrayList<>(); 
		subList = ObserverManager.getObservadoresCancelacion().stream().filter(observador -> observador.getPublicacion().getInmueble().equals(reserva.getPublicacion().getInmueble()) ).collect(Collectors.toList());
		this.notificarCambio(subList);
	}
	
	public void alertarBajaDePrecio(Publicacion publicacion) {
		List<Observador> subList = new ArrayList<>(); 
		subList = ObserverManager.getObservadoresPrecio().stream().filter(observador -> observador.getPublicacion().getInmueble().equals( publicacion.getInmueble()) ).collect(Collectors.toList());
		this.notificarCambio(subList);
	}
	
	public void alertarReserva(Publicacion publicacion) {
		this.notificarCambio(ObserverManager.getObservadoresReserva());
	}
	
	private void notificarCambio(List<Observador> observador) {
		observador.forEach(obs -> obs.notificar());
	}


}
