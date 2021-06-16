package usuario;

import java.util.ArrayList;
import java.util.Calendar;

import publicacion.Publicacion;
import reserva.Reserva;

public class Usuario {
	private String nombre;
	private String apellido;
	private String domicilio;
	private String eMail;
	private Integer telefono;
	private Calendar fechaDeIngreso;
	private ArrayList<Publicacion> publicacion;
	private ArrayList<Reserva> reserva;
	
	public Usuario (String nombre, String apellido, String domicilio, String eMail, Integer telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.eMail = eMail;
		this.telefono = telefono;	
		this.fechaDeIngreso = Calendar.getInstance();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getNombreYApellido() {
		return this.nombre + " " + this.apellido;
	}

	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Calendar getFechaDeIngreso() {
		return fechaDeIngreso;
	}

	public ArrayList<Publicacion> getPublicacion() {
		return publicacion;
	}

	// Agrega una Publicación a la lista
	public void addPublicacion(Publicacion publicacion) {
		this.publicacion.add(publicacion);
	}

	// devuelve todas las reservas
	public ArrayList<Reserva> todasLasReservas() {
		return reserva;
	}
	
	public ArrayList<Reserva> reservasFuturas(){
		// FALTA HACER QUE SE FILTRN LAS
		// RESEVAS FUTURAS
		return reserva;
	}

	public ArrayList<Reserva> reservasEnCiudad(String ciudad){
		// FALTA HACER QUE SE FILTRN LAS
		// RESEVAS PARA LA CIUDAD
		return reserva;
	}
	
	public ArrayList<String> ciudadesDondeReservo(){
		// FALTA HACER RECUPERAR LA 
		// LISTA DE CIUDADES
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Cordoba");
		lista.add("Rosario");
		return lista; /* reserva; */
	}
	
	// Agrega una Reserva a la lista
	public void addReserva(Reserva reserva) {
		this.reserva.add(reserva);
	}

	// Devuelve la antiguedad del usuario en días desde 
	// su  ingreso al sitio hasta hoy
	public Integer antiguedadComoUsuario() {
		long milisegundos = Calendar.getInstance().getTimeInMillis() - this.getFechaDeIngreso().getTimeInMillis(); 
		return (int) (milisegundos / 1000 / 60 / 60 / 24);
	}
	

}
