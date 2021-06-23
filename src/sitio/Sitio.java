
package sitio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


import calificacion.Calificable;
import calificacion.Calificacion;
import categoria.Categoria;
import formasDePago.FormaDePago;
import publicacion.Publicacion;
import reserva.Reserva;
import usuario.Usuario;
import servicios.Servicio;
import tipoInmueble.TipoDeInmueble;

public class Sitio {
	private static Sitio sitio;
	private static ObserverManager gestorDeNotificaciones;
	private static List<Usuario> usuario;
	private Set<Categoria> categorias; 
	private Set<FormaDePago> formasDePago;
	private Set<Servicio> servicios;
	private Set<TipoDeInmueble> tiposDeInmuebles;
	
	private Sitio() {
		this.setGestorDeNotificaciones( ObserverManager.getInstance() );
		this.setUsuario( new ArrayList<>());
		servicios = new HashSet<Servicio>();
		categorias =new HashSet<Categoria>();
		formasDePago = new HashSet<FormaDePago>();	
		tiposDeInmuebles= new HashSet<TipoDeInmueble>();
	}
	
	public static Sitio getInstance() {
		if (sitio == null) {
			sitio = new Sitio( );
		}
		return sitio;
	}

	private static ObserverManager getGestorDeNotificaciones() {
		return gestorDeNotificaciones;
	}

	private void setGestorDeNotificaciones(ObserverManager gestorDeNotificaciones) {
		Sitio.gestorDeNotificaciones = gestorDeNotificaciones;
	}

	private List<Usuario> getUsuario() {
		return usuario;
	}

	private void setUsuario(List<Usuario> usuario) {
		Sitio.usuario = usuario;
	}
	
	public void addUsuario(Usuario usuario) {
		this.getUsuario().add(usuario);
	}

	public static void procesarReservaCancelada(Reserva reserva) {
		reserva.getPublicacion().aplicarPoliticaCancelacion(reserva);
		getGestorDeNotificaciones().alertarCancelacion(reserva);
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
		getGestorDeNotificaciones().alertarBajaDePrecio(publicacion);
	} 
	
	public void addCategoria(Categoria categoria) {
		categorias.add(categoria);
	}
	
	public void  calificar (Calificable calificable ,Reserva unaReserva, Calificacion unaCalificacion ) {
		if(unaReserva.estaFinalizada()) {
			calificable.setCalificacion(unaCalificacion);
		}
	}
	
	public void addFormaDePago(FormaDePago unaFormaDePago) {
		this.formasDePago.add(unaFormaDePago);
	}
	
	public double promedioGeneralCalificaciones(Calificable unCalificable) {
		double suma = 0.0;
		List<Calificacion> calificaciones = new ArrayList<Calificacion>();
		calificaciones  = unCalificable.getCalificaciones();
		for (Calificacion calificacion:calificaciones) {
			suma += calificacion.getPuntaje();
		}
		return suma/calificaciones.size();
	}	
	
	
	public Map<Categoria,Double> promedioPorCategoria (Calificable calificable) {
		Map<Categoria,Double> categorias = new HashMap<Categoria,Double>();
		List<Calificacion> calificaciones = new ArrayList<Calificacion>();
		
		calificaciones = calificable.getCalificaciones();
		
		for (Calificacion calificacion:calificaciones) {
			categorias.put(calificacion.getCategoria(),this.promedioDe(calificable, calificacion.getCategoria())); 
		}
		return categorias;
	
	}
	
	private double promedioDe(Calificable calificable, Categoria unaCategoria) {
		List<Calificacion> calificaciones = new ArrayList<Calificacion>();
		double acumuladorDePuntaje = 0.0;
		calificaciones = calificable.getCalificaciones().stream().
				filter(filtroCategoria-> filtroCategoria.getCategoria() == unaCategoria)
				.collect(Collectors.toList());
		for (Calificacion unaCalificacion : calificaciones) {
			acumuladorDePuntaje += unaCalificacion.getPuntaje();
		}
		return acumuladorDePuntaje / calificaciones.size();
			
	}
	
	
	
	public void addTipoInmueble (TipoDeInmueble unTipoDeInmueble) {
		tiposDeInmuebles.add(unTipoDeInmueble);
	}
	
	public Collection<TipoDeInmueble> getTiposDeInmuebles() {
		return this.tiposDeInmuebles;
	}
	
	public void addServicio(Servicio unServicio) {
		servicios.add(unServicio);
	}
	
	public Collection<Servicio> getServicios(){
		return this.servicios;
	}

	public ArrayList<Publicacion> buscarPublicacion(CriterioBasico criterio){
		return criterio.lasQueCumplen(usuario.stream().flatMap(u -> u.getPublicaciones().stream()).collect(Collectors.toCollection(ArrayList::new)));
	}
	
}

