package sitio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import publicacion.Publicacion;
import reserva.Reserva;
import usuario.Usuario;

public class Sitio {
	private static Sitio sitio;
	private static ObserverManager gestorDeNotificaciones;
	private static List<Usuario> usuario;
	
	
	private Sitio() {
		this.setGestorDeNotificaciones( ObserverManager.getInstance() );
		this.setUsuario( new ArrayList<>());
	}
	
	public static Sitio getInstance() {
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

	private List<Usuario> getUsuario() {
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
		List<Reserva> reservaCoincide = new ArrayList<>();
		Reserva reservaSiguiente;
		reservaCoincide = getReservasCondicionalesQueCoincidenCon(reserva);
		if (reservaCoincide.size() > 0) {
			reservaSiguiente = reservaCoincide.stream().min((Comparator<? super Reserva>) reservaCoincide.stream().map(res -> res.getFecgaHoraReserva())).get();
			reservaSiguiente.aceptar();
		}
	}

	private static List<Reserva> getReservasCondicionales(){
		List<Reserva> reservaCondicional = new ArrayList<>();
		usuario.forEach(usuario -> reservaCondicional.addAll( usuario.todasLasReservas().stream().filter(res -> res.esCondicional()).collect(Collectors.toList()) )) ;
		return reservaCondicional;
	}
	
	private static List<Reserva> getReservasCondicionalesQueCoincidenCon(Reserva reserva){
		List<Reserva> reservaCondicional = new ArrayList<>();
		reservaCondicional = getReservasCondicionales();
		return  reservaCondicional.stream().filter(res -> res.getPublicacion().getInmueble().equals(reserva.getPublicacion().getInmueble())  && res.getFechaInicio().equals(reserva.getFechaInicio())  && res.getFechaFin().equals(reserva.getFechaFin()) ).collect(Collectors.toList());
		
	}
	
	public static void procesarBajaDePrecio(Publicacion publicacion) {
		gestorDeNotificaciones.alertarBajaDePrecio(publicacion);
	}
	
	public ArrayList<Publicacion> buscarPublicacion(CriterioBasico criterio){
		return criterio.lasQueCumplen(usuario.stream().flatMap(u -> u.getPublicaciones().stream()).collect(Collectors.toCollection(ArrayList::new)));
	}
	

}
