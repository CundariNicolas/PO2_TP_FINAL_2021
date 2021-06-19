package sitio;

import java.util.ArrayList;

import publicacion.Publicacion;
import reserva.Reserva;

public class ObserverManager {
	private static ObserverManager manager;
	private static ArrayList<Observador> observadorCancelacion;
	private static ArrayList<Observador> observadorPrecio;
	
	private ObserverManager() {
		this.setObservadorCancelacion( new ArrayList<>() );
		this.setObservadorPrecio( new ArrayList<>() );
	}
	
	public static ObserverManager getInstance() {
		if (manager == null) {
			manager = new ObserverManager();
		}
		return manager;
	}
	
	private static ArrayList<Observador> getObservadorCancelacion() {
		return observadorCancelacion;
	}

	private static void setObservadorCancelacion(ArrayList<Observador> observadorCancelacion) {
		ObserverManager.observadorCancelacion = observadorCancelacion;
	}

	private static ArrayList<Observador> getObservadorPrecio() {
		return observadorPrecio;
	}

	private static void setObservadorPrecio(ArrayList<Observador> observadorPrecio) {
		ObserverManager.observadorPrecio = observadorPrecio;
	}

	public void suscribirACancelacion(Observador observador) {
		this.observadorCancelacion.add(observador);
	}
	
	public void suscribirABajaDePrecio(Observador observador) {
		this.observadorPrecio.add(observador);
	}
	
	public void alertarCancelacion(Reserva reserva) {
		ArrayList<Observador> subList; 
		subList = (ArrayList<Observador>) this.getObservadorCancelacion().stream().filter(observador -> observador.getPublicacion().getInmueble() == reserva.getPublicacion().getInmueble());
		this.notificarCambio(subList);
	}
	
	public void alertarBajaDePrecio(Publicacion publicacion) {
		ArrayList<Observador> subList; 
		subList = (ArrayList<Observador>) this.getObservadorPrecio().stream().filter(observador -> observador.getPublicacion().getInmueble() == publicacion.getInmueble());
		this.notificarCambio(subList);
	}
	
	private void notificarCambio(ArrayList<Observador> observador) {
		observador.forEach(obs -> obs.notificar());
	}


}
