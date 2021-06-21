package usuario;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import inmueble.Inmueble;
import publicacion.Publicacion;
import reserva.Reserva;
import sitio.Calificable;
import sitio.Calificacion;

public class Usuario implements Calificable{
	private String nombre;
	private String apellido;
	private String domicilio;
	private String eMail;
	private Integer telefono;
	private Calendar fechaDeIngreso;
	private ArrayList<Publicacion> publicaciones;
	private ArrayList<Reserva> reservas;
	private ArrayList<Calificacion> calificaciones;
	
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

	public String getNombre() {
		return nombre;
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}
	private void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getNombreYApellido() {
		return this.nombre + " " + this.apellido;
	}

	public String getDomicilio() {
		return domicilio;
	}
	private void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String geteMail() {
		return eMail;
	}
	private void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Integer getTelefono() {
		return telefono;
	}
	private void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Calendar getFechaDeIngreso() {
		return fechaDeIngreso;
	}

	public ArrayList<Publicacion> getPublicaciones() {
		return publicaciones;
	}
	
	public ArrayList<Calificacion> getCalificaciones(){
		return calificaciones;
	}
	
	public void addCAlificacion(Calificacion calificacion) {
		this.getCalificaciones().add(calificacion);
	}
	
	private void setCalificaciones(ArrayList<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	// Agrega una Publicaci�n a la lista
	public void addPublicacion(Publicacion publicacion) {
		this.publicaciones.add(publicacion);
	}

	// devuelve todas las reservas
	public ArrayList<Reserva> todasLasReservas() {
		return reservas;
	}
	
	public List<Reserva> reservasFuturas(){
		return this.reservas.stream().filter(reserva -> reserva.esFutura()).collect(Collectors.toList());
	}

	public ArrayList<Reserva> reservasEnCiudad(String ciudad){
		return (ArrayList<Reserva>) this.reservas.stream().filter(reserva -> reserva.esDeCiudad(ciudad));
	}
	
	public List<String> ciudadesDondeReservo(){
		return this.reservas.stream().map(reserva -> reserva.getPublicacion().getInmueble().getCiudad()).distinct().collect(Collectors.toList());
	}
	
	// Agrega una Reserva a la lista
	public void addReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}

	// Devuelve la antiguedad del usuario en DIAS desde 
	// su  ingreso al sitio hasta hoy
	public Integer antiguedadComoUsuario() {
		long milisegundos = Calendar.getInstance().getTimeInMillis() - this.getFechaDeIngreso().getTimeInMillis(); 
		return (int) (milisegundos / 1000 / 60 / 60 / 24);
	}
	
	public Integer cantidadDeVecesAlquilado(Inmueble inmueble) {
		return 	this.getPublicaciones().stream().filter(publicacion -> publicacion.getInmueble().equals(inmueble)).findFirst().get().getInmueble().getCantidadDeVecesAlquilado();
	}
	
	public Integer cantidadTotalDeAlquileres() {
		Integer cuenta = 0;
		ArrayList<Inmueble> inmuebles = new ArrayList<>();
		inmuebles.addAll( (ArrayList<Inmueble>) this.getPublicaciones().stream().map(publicacion -> publicacion.getInmueble() ).distinct());
		for(Inmueble inmueble : inmuebles) {
			cuenta += inmueble.getCantidadDeVecesAlquilado();
		}
		return cuenta;
	}

}
