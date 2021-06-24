
package usuario;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import calificacion.Calificable;
import calificacion.Calificacion;
import inmueble.Inmueble;
import publicacion.Publicacion;
import reserva.Reserva;


public class Usuario implements Calificable, Comparable<Usuario>{
	private String nombre;
	private String apellido;
	private String domicilio;
	private String eMail;
	private Integer telefono;
	private Calendar fechaDeIngreso;
	private List<Publicacion> publicaciones;
	private List<Reserva> reservas;
	private List<Calificacion> calificaciones;
	
	/**
	 * Constructor de Usuario
	 * 
	 * @param nombre String Nombre del usuario
	 * @param apellido String Apellido del usuario
	 * @param domicilio String Domicilio del usuario
	 * @param eMail String Correo electronico del usuario
	 * @param telefono Integer Telefono del usuario
	 * @return Usuario un usuario
	 */
	public Usuario (String nombre, String apellido, String domicilio, String eMail, Integer telefono) {
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDomicilio(domicilio);
		this.seteMail(eMail);
		this.setTelefono(telefono);
		this.setReservas(new ArrayList<>());
		this.setPublicaciones(new ArrayList<>());
		this.setCalificaciones(new ArrayList<>());
		this.setFechaDeIngreso(Calendar.getInstance());
	}
			
	private void setReservas(ArrayList<Reserva> reserva) {
		this.reservas = reserva;
	}

	private void setFechaDeIngreso(Calendar fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}

	private void setPublicaciones(ArrayList<Publicacion> publicacion) {
		this.publicaciones = publicacion;
	}
	
	/**
	 * Devuelve el nombre del usuario
	 * 
	 * @return String nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el apelliso del usuario
	 * 
	 * @return String apellido
	 */
	public String getApellido() {
		return apellido;
	}
	
	private void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/**
	 * Devuelve el nombre concatenado con el apellido del usuario
	 * 
	 * @return String nombre y apellido
	 */
	public String getNombreYApellido() {
		return this.nombre + " " + this.apellido;
	}
	
	/**
	 * Devuleve el domicilio del usuario
	 * 
	 * @return String domicilio 
	 */
	public String getDomicilio() {
		return domicilio;
	}
	
	private void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	/**
	 * Devuleve el correo electronico del usuario
	 * 
	 * @return String correo electronico 
	 */
	public String geteMail() {
		return eMail;
	}
	
	private void seteMail(String eMail) {
		this.eMail = eMail;
	}

	/**
	 * Devuelve el numero de telefono del usuario
	 * 
	 * @return Integer numero de telefono
	 */
	public Integer getTelefono() {
		return telefono;
	}
	
	private void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	/**
	 * Devuelve la fecha de registro del usuario en el sitio
	 * 
	 * @return Calendar fecha de registro 
	 */
	public Calendar getFechaDeIngreso() {
		return fechaDeIngreso;
	}

	
	/**
	 * Devuleve la lista de publicaciones del usuario
	 * 
	 * @return List<Publicacion> publicaciones
	 */
	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}
	
	/**
	 * Devuleve la lista de calificaciones del usuario
	 * 
	 * @return List<Calificacion> calificacioness
	 */
	public List<Calificacion> getCalificaciones(){
		return calificaciones;
	}
	
	
	private void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	/**
	 * Agrega una publicacion al usuario
	 * 
	 * @param publicacion Publicacion
	 */
	public void addPublicacion(Publicacion publicacion) {
		this.publicaciones.add(publicacion);
	}

	/**
	 * Devuelve todas las reservas que hizo el usuario
	 * 
	 * @return List<Reserva> reseevas
	 */
	public List<Reserva> todasLasReservas() {
		return reservas;
	}
	
	/**
	 * Devuelve una lista con las reservas futuras
	 * 
	 * @return List<Reserva> reservas
	 */
	public List<Reserva> reservasFuturas(){
		return this.reservas.stream().filter(reserva -> reserva.esFutura()).collect(Collectors.toList());
	}

	/**
	 * Devuelve una lista de reservas para una ciudad indicada
	 * 
	 * @param ciudad String nombre de una ciudad
	 * @return Lista<Reserva> reservas
	 */
	public List<Reserva> reservasEnCiudad(String ciudad){
		return this.reservas.stream().filter(reserva -> reserva.esDeCiudad(ciudad)).collect(Collectors.toList());
	}
	
	/**
	 * Devuleve la lista de ciudades donde el usuario reservo alguna vez
	 * 
	 * @return Lista<String> lista de nombre de ciudades
	 */
	public List<String> ciudadesDondeReservo(){
		return this.reservas.stream().map(reserva -> reserva.getPublicacion().getCiudadInmueble()).distinct().collect(Collectors.toList());
	}
	
	/**
	 * Agrega una reserva al usuario
	 * 
	 * @param reserva Reserva
	 */
	public void addReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}

	 
	/**
	 * Devuelve la antiguedad del usuario en DIAS desde  su ingreso al sitio hasta hoy
	 *  
	 * @return Integer dias
	 */
	public Integer antiguedadComoUsuario() {
		long milisegundos = Calendar.getInstance().getTimeInMillis() - this.getFechaDeIngreso().getTimeInMillis(); 
		return (int) (milisegundos / 1000 / 60 / 60 / 24);
	}
	
	/**
	 * Devuleve la cantidad de veces que el usuario alquilo un inmueble en particular
	 * 
	 * @param inmueble Inmueble
	 * @return Integer cantidad de veces
	 */
	public Integer cantidadDeVecesAlquilado(Inmueble inmueble) {
		return 	this.getPublicaciones().stream().filter(publicacion -> publicacion.getInmueble().equals(inmueble)).findFirst().get().getInmueble().getCantidadDeVecesAlquilado();
	}
	
	/**
	 * Devuelve la cantidad total de días que alquilo todos los inmuebles  
	 * 
	 * @return Integer cantidad de dias
	 */
	public Integer cantidadTotalDeAlquileres() {
		Integer cuenta = 0;
		List<Inmueble> inmuebles = new ArrayList<Inmueble>();
		inmuebles.addAll( this.getPublicaciones().stream().map(publicacion -> publicacion.getInmueble() ).distinct().collect(Collectors.toList()));
		for(Inmueble inmueble : inmuebles) {
			cuenta += inmueble.getCantidadDeVecesAlquilado();
		}
		return cuenta;
	}

	@Override
	/**
	 * Agrega una calificacion a las calificaciones del usuario
	 * 
	 * @param unaCalificacion Calificacion
	 */
	public void setCalificacion(Calificacion unaCalificacion) {
		this.getCalificaciones().add(unaCalificacion);
	}
	
	/**
	 * Devuelve la cantidad de veces que alquilo propiedades efectivamente (con reservas consolidadas)
	 * 
	 * @return Integer cantidad de alquileres
	 */
	public Integer cantidadDeAlquileres() {
		return (int) this.todasLasReservas().stream().filter(reserva -> reserva.seConcreto()).count();
	}

	@Override
	/**
	 * Se usa para poder ordenar
	 * 
	 * @param o Object
	 */
	public int compareTo(Usuario o) {
		if(this.cantidadDeAlquileres() < o.cantidadDeAlquileres()) {
			return 1;
		}
		else if(this.cantidadDeAlquileres() > o.cantidadDeAlquileres()) {
			return -1;
		}
		else {
			return 0;
		}
	}
	

}

