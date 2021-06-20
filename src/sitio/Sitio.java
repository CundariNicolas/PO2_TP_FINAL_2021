package sitio;

import java.util.ArrayList;
import java.util.Comparator;

import publicacion.Publicacion;
import reserva.EstadoConsolidado;
import reserva.Reserva;
import usuario.Usuario;

public class Sitio {
	private static Sitio sitio;
	private static ObserverManager gestorDeNotificaciones;
	private static ArrayList<Usuario> usuario;
	
	
	public Sitio() {
		this.setGestorDeNotificaciones( ObserverManager.getInstance() );
		this.setUsuario( new ArrayList<>());
	}
	
	private static Sitio getInstance() {
		if (sitio == null) {
			sitio = new Sitio();
		}
		return sitio;
	}

	private ObserverManager getGestorDeNotificaciones() {
		return gestorDeNotificaciones;
	}

	private void setGestorDeNotificaciones(ObserverManager gestorDeNotificaciones) {
		this.gestorDeNotificaciones = gestorDeNotificaciones;
	}

	private ArrayList<Usuario> getUsuario() {
		return usuario;
	}

	private void setUsuario(ArrayList<Usuario> usuario) {
		this.usuario = usuario;
	}
	
	public void addUsuario(Usuario usuario) {
		this.getUsuario().add(usuario);
	}

	public static void procesarReservaCancelada(Reserva reserva) {
		reserva.getPublicacion().aplicarPoliticaCancelacion(reserva);
		gestorDeNotificaciones.alertarCancelacion(reserva);
		asignarProximaReservaCondicional(reserva);
	}
	
	private static void asignarProximaReservaCondicional(Reserva reserva) {
		ArrayList<Reserva> reservaCoincide = new ArrayList<>();
		Reserva reservaSiguiente;
		reservaCoincide = getReservasCondicionalesQueCoincidenCon(reserva);
		if (reservaCoincide.size() > 0) {
			reservaSiguiente = reservaCoincide.stream().min((Comparator<? super Reserva>) reservaCoincide.stream().map(res -> res.getFecgaHoraReserva())).get();
			reservaSiguiente.aceptar();
		}
	}

	private static ArrayList<Reserva> getReservasCondicionales(){
		ArrayList<Reserva> reservaCondicional = new ArrayList<>();
		usuario.forEach(usuario -> reservaCondicional.addAll( (ArrayList<Reserva>) usuario.todasLasReservas().stream().filter(res -> res.esCondicional()) )) ;
		return reservaCondicional;
	}
	
	private static ArrayList<Reserva> getReservasCondicionalesQueCoincidenCon(Reserva reserva){
		ArrayList<Reserva> reservaCondicional = new ArrayList<>();
		reservaCondicional = getReservasCondicionales();
		return  (ArrayList<Reserva>) reservaCondicional.stream().filter(res -> res.getPublicacion().getInmueble().equals(reserva.getPublicacion().getInmueble())  && res.getFechaInicio().equals(reserva.getFechaInicio())  && res.getFechaFin().equals(reserva.getFechaFin()) );
		
	}
	
	public static void procesarBajaDePrecio(Publicacion publicacion) {
		gestorDeNotificaciones.alertarBajaDePrecio(publicacion);
	}
	

}
