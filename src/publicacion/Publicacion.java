package publicacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.stream.Collectors;
import java.util.Set;

import java.util.stream.Stream;

import formasDePago.FormaDePago;
import inmueble.Inmueble;
import reserva.Reserva;
import sitio.Observador;
import sitio.Sitio;
import usuario.Usuario;

public class Publicacion {
	private Inmueble inmueble;
	private Calendar fechaInicio;
	private Calendar fechaFin;
	private ArrayList<Foto> fotos;
	private ArrayList<PrecioDiaOcupacion> preciopordiaocupado;
	private Usuario propietario;
	
	
	/**Crea una instancia de Publicacion
	 * 
	 * @param propietario Usuario
	 * @param inmueble Inmueble
	 * @param inicio Calendar
	 * @param fin Calendar
	 * @param fotos ArrayList<Foto>
	 * @param precios ArrayList<PrecioDiaOcupacion>
	 * 
	 * @return Publicacion
	 * 
	 */
	public Publicacion(Usuario propietario, Inmueble inmueble, Calendar inicio, Calendar fin, ArrayList<Foto> fotos, ArrayList<PrecioDiaOcupacion> precio) {
		
		this.propietario = propietario;
		this.inmueble = inmueble;
		this.fechaInicio = inicio;
		this.fechaFin = fin;
		this.setFotos(fotos);
		this.preciopordiaocupado = precio;
		
	}
	
	
	/**Registra la ocupacion en cada dia entre las fechas dadas por parametros
	 * @param fechainicio Calendar
	 * @param fechaFin Calendar
	 * @return void
	 *
	 */
	
	public void registrarOcupacion(Calendar fechainicio, Calendar fechaFin) {
		
		
		this.preciopordiaocupado.forEach(dia -> {
			if((dia.getFecha().after(fechainicio) || dia.getFecha().equals(fechainicio)) && (dia.getFecha().before(fechaFin) || dia.getFecha().equals(fechaFin))) {
				dia.setOcupado();
			}
		});
		
	}
	
	/**Desocupa los dias entre las fechas dadas por parametros
	 * @param fechaInicio2 Calendar
	 * @param fechaFin2 Calendar
	 * @return void
	 */
	
	public void registrarCancelacion(Calendar fechaInicio2, Calendar fechaFin2) {
		preciopordiaocupado.forEach(dia -> {
			if((dia.getFecha().after(fechaInicio2) || dia.getFecha().equals(fechaInicio2)) && (dia.getFecha().before(fechaFin2) || dia.getFecha().equals(fechaFin2))) {
				dia.setLibre();
			}
		});
		
	}
	
	/**
	 * Indica si entre las fechas dadas esta desocupado el inmueble de la publicacion
	 * @param fechaDesde Calendar
	 * @param fechaHasta Calendar
	 * @return boolean
	 */
	
	public boolean estaLibreEntre(Calendar fechaDesde, Calendar fechaHasta) {
		
		return getPeriodoEspecificado(fechaDesde, fechaHasta).allMatch( p -> !p.estaOcupado());
	}
	
	/**
	 * Retorna los medios de pago habilitados para el inmueble de la publicacion
	 * @return ArrayList<FormaDePago>
	 */
	public Set<FormaDePago> medioDePagoHabilitado(){

		return inmueble.getFormaDePago();
	}
	
	
	/**Notifica al sitio la baja de precio en esta publicacion
	 * @return void
	 */
	public void notificarBajaEnPrecio() {
		Sitio.procesarBajaDePrecio(this);
		
	}
	
	/**
	 * Establece el precio en un periodo de dias dado
	 * @param precio2 ArrayList<PrecioDiaOcupacion>
	 * @return void
	 */
	public void setPrecioPeriodo(ArrayList<PrecioDiaOcupacion> precio2) {
		
		this.preciopordiaocupado = precio2;
	}
	
	
	/**
	 * Modifica el precio dia un dia en especificado a traves del parametro
	 * @param dia PrecioDiaOcupacion
	 */
	public void modificarPrecio(PrecioDiaOcupacion dia ) {
		this.preciopordiaocupado.stream().filter(d -> d.getFecha().equals(dia.getFecha())).findFirst().get().setPrecio(dia.getPrecio(), this);;
	}
	
	/**
	 * Indica si en la fecha dada, esta disponible el inmueble
	 * @param fechaActual Calendar
	 * @return boolean
	 */
	public boolean disponibleHoy(Calendar fechaActual) {
		return !this.preciopordiaocupado.stream().filter(d -> d.getFecha().equals(fechaActual)).findFirst().get().estaOcupado();		
	}
	
	/**
	 * Inidica si en el si de hoy, hay inmueble libre, tomando el dia como un dia del año calendario Gregoriano;
	 * 
	 * @return boolena
	 */
	public boolean disponibleHoy() {
		System.out.println("Entro a Disponible");
		Calendar hoy = new GregorianCalendar();
		//return !this.preciopordiaocupado.stream().filter(d -> d.getFecha(Calendar.DAY_OF_YEAR).equals(fechaActual)).findFirst().get().estaOcupado();
		return !this.preciopordiaocupado.stream().filter(d -> d.getFecha().get(Calendar.DAY_OF_YEAR) == (hoy.get(Calendar.DAY_OF_YEAR))).findFirst().get().estaOcupado();
		
	}
	
	/**
	 * Retorna el precio total en un periodo dado
	 * @param inicio Calendar
	 * @param fin Calendar
	 * @return double
	 */
	public double precioEnPeriodo(Calendar inicio, Calendar fin) {
		return getPeriodoEspecificado(inicio, fin).map(p -> p.getPrecio()).reduce((double) 0, (a,b) -> a+b);
	}
	
	/**
	 * Aplica la politica de cancelacion a la reserva pasada por parametro
	 * @param reserva Reserva
	 * @return void
	 */
	public void aplicarPoliticaCancelacion(Reserva reserva) {
		this.inmueble.getPoliticaCancelacion().aplicar(reserva);		
	}
	
	/**
	 * Retorna un periodo especificado de dias con su precio y su disponibilidad
	 * @param inicio
	 * @param fin
	 * @return Stream<PrecioDiaOcupacion>
	 */
	private Stream<PrecioDiaOcupacion> getPeriodoEspecificado(Calendar inicio, Calendar fin){
		return this.preciopordiaocupado.stream().filter(p -> p.getFecha().after(inicio) || p.getFecha().equals(inicio) && p.getFecha().before(fin) || p.getFecha().equals(fin));
	}
	

	

	


	
	
	// GETTERS AND SETTERS
	
	/**
	 * Retorna el inmueble de la publicacion
	 * @return Inmueble
	 */
	public Inmueble getInmueble() {
		return inmueble;
	}
	/**
	 * Retorna la fecha de inicio de la publicacion
	 * @return Calendar
	 */
	public Calendar getFechaInicioPublicacion() {
		return fechaInicio;
	}
	
	/**
	 * Retorna la fecha en la que caduca la publicacion
	 * @return Calendar
	 */
	public Calendar getFechaFin() {
		return fechaFin;
	}
	
	/**
	 * Retorna las fotos pertenecientes al inmueble
	 * @return ArrayList<Foto>
	 */
	public ArrayList<Foto> getFotos() {
		return fotos;
	}
	
	/**
	 * Setea las fotos de la publicacion
	 * @param fotos ArrayList<Foto>
	 * @return void
	 */
	public void setFotos(ArrayList<Foto> fotos) {
		this.fotos = fotos;
	}

	/**
	 * Retorna todos los dias con su precio y ocupacion
	 * @return ArrayList<PrecioDiaOcupacion>
	 */
	public ArrayList<PrecioDiaOcupacion> getPrecio() {
		return preciopordiaocupado;
	}

	/**
	 * Retorna la ciudad en la que esta situada el inmueble
	 * @return String
	 */
	public String getCiudadInmueble() {
		return this.inmueble.getCiudad();
	}

	

	/**
	 * Retorna el usuario propietario de la publicacion
	 * @return Usuario
	 */
	public Usuario getPropietario() {
		
		return propietario;
	}
	
	



	

}
