package sitio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;

import calificacion.Calificable;
import calificacion.Calificacion;
import categoria.Categoria;
import formasDePago.FormaDePago;
import publicacion.Publicacion;
import reserva.EstadoConsolidado;
import reserva.Reserva;
import usuario.Usuario;

public class Sitio {
	private static Sitio sitio;
	private static ObserverManager gestorDeNotificaciones;
	private static ArrayList<Usuario> usuario;
	private Set<Categoria> categorias; 
	private Set<FormaDePago> formasDePago;
	
	
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
		gestorDeNotificaciones.alertarCancelacion(reserva);
		asignarProximaReservaCondicional(reserva);
	}
	
	private static void asignarProximaReservaCondicional(Reserva reserva) {
		ArrayList<Reserva> reservaCondicional = new ArrayList<>();
		Reserva reservaSiguiente;
		usuario.forEach(usuario -> reservaCondicional.addAll( (ArrayList<Reserva>) usuario.todasLasReservas().stream().filter(res -> res.esCondicional()) )) ;
		if (reservaCondicional.size() > 0) {
			reservaSiguiente = reservaCondicional.stream().min((Comparator<? super Reserva>) reservaCondicional.stream().map(res -> res.getFecgaHoraReserva())).get();
			reservaSiguiente.aceptar();
		}
	}

	public static void procesarBajaDePrecio(Publicacion publicacion) {
		gestorDeNotificaciones.alertarBajaDePrecio(publicacion);
	} 
	
	public void addCategoria(Categoria categoria) {
		categorias.add(categoria);
	}
	public void  calificar (Calificable unaCategoria,Reserva unaReserva, Calificacion unaCalificacion ) {
		if(unaReserva.estaFinalizada()) {
			unaCategoria.setCalificacion(unaReserva.inquilino(), unaCalificacion);
		}
	}
	public void addFormaDePago(FormaDePago unaFormaDePago) {
		this.formasDePago.add(unaFormaDePago);
	}
	
	public double promedioGeneralCalificaciones(Categoria unaCategoria) {
		return unaCategoria.promedioDePuntaje();
	}
	
	public Map<Categoria, Double> promedioPorCategoriaPara(Categoria unaCategoria){
		
	}



}
