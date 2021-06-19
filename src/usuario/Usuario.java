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
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDomicilio(domicilio);
		this.seteMail(eMail);
		this.setTelefono(telefono);
		this.setReserva(new ArrayList<>());
		this.setPublicacion(new ArrayList<>());
		this.setFechaDeIngreso(Calendar.getInstance());
	}
			
	private void setReserva(ArrayList<Reserva> reserva) {
		this.reserva = reserva;
	}

	private void setFechaDeIngreso(Calendar fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}

	private void setPublicacion(ArrayList<Publicacion> publicacion) {
		this.publicacion = publicacion;
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
		return (ArrayList<Reserva>) this.reserva.stream().filter(reserva -> reserva.esFutura());
	}

	public ArrayList<Reserva> reservasEnCiudad(String ciudad){
		return (ArrayList<Reserva>) this.reserva.stream().filter(reserva -> reserva.esDeCiudad(ciudad));
	}
	
	public ArrayList<String> ciudadesDondeReservo(){
		return (ArrayList<String>) this.reserva.stream().map(reserva -> reserva.getPublicacion().getInmueble().getCiudad()).distinct();
	}
	
	// Agrega una Reserva a la lista
	public void addReserva(Reserva reserva) {
		this.reserva.add(reserva);
	}

	// Devuelve la antiguedad del usuario en DIAS desde 
	// su  ingreso al sitio hasta hoy
	public Integer antiguedadComoUsuario() {
		long milisegundos = Calendar.getInstance().getTimeInMillis() - this.getFechaDeIngreso().getTimeInMillis(); 
		return (int) (milisegundos / 1000 / 60 / 60 / 24);
	}
	

}
