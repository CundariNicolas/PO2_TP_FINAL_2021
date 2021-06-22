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
	
	private static List<Observador> getObservadoresCancelacion() {
		return observadoresCancelacion;
	}

	private static void setObservadoresCancelacion(List<Observador> observadoresCancelacion) {
		ObserverManager.observadoresCancelacion = observadoresCancelacion;
	}

	private static List<Observador> getObservadoresPrecio() {
		return observadoresPrecio;
	}

	private static void setObservadoresPrecio(List<Observador> observadoresPrecio) {
		ObserverManager.observadoresPrecio = observadoresPrecio;
	}

	private static List<Observador> getObservadoresReserva() {
		return observadoresReserva;
	}

	private static void setObservadoresReserva(List<Observador> observadoresReservan) {
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
		List<Observador> subList; 
		subList = this.getObservadoresCancelacion().stream().filter(observador -> observador.getPublicacion().getInmueble() == reserva.getPublicacion().getInmueble()).collect(Collectors.toList());
		this.notificarCambio(subList);
	}
	
	public void alertarBajaDePrecio(Publicacion publicacion) {
		List<Observador> subList; 
		subList = this.getObservadoresPrecio().stream().filter(observador -> observador.getPublicacion().getInmueble() == publicacion.getInmueble()).collect(Collectors.toList());
		this.notificarCambio(subList);
	}
	
	public void alertarReserva(Publicacion publicacion) {
		this.notificarCambio(this.getObservadoresReserva());
	}
	
	private void notificarCambio(List<Observador> observador) {
		observador.forEach(obs -> obs.notificar());
	}


}
