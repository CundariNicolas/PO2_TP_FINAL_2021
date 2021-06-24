package reserva;

import java.util.ArrayList;
import java.util.Calendar;

import formasDePago.FormaDePago;
import publicacion.PrecioDiaOcupacion;
import publicacion.Publicacion;
import usuario.Usuario;

public class Reserva {
	private Calendar fecgaHoraReserva;
	private Publicacion publicacion;
	private Calendar fechaInicio;
	private Calendar fechaFin;
	private ArrayList<PrecioDiaOcupacion> precios;
	private FormaDePago formaDePago;
	private Usuario inquilino;
	private EstadoReserva estado;
	
	/**
	 * Crea una nueva reserva en estado INICIAL con los valores dados
	 * 
	 * @param publicacion Publicacion
	 * @param fechaInicio Calendar
	 * @param fechaFin Calendar
	 * @param precios List<PrecioDiaOcupacion>
	 * @param formaDePago FormaDePago
	 * @param inquilino Usuario
	 * @return Reserva
	 */
	public Reserva(Publicacion publicacion, Calendar fechaInicio, Calendar fechaFin, ArrayList<PrecioDiaOcupacion> precios,
			FormaDePago formaDePago, Usuario inquilino) {
		super();
		this.fecgaHoraReserva = Calendar.getInstance();
		this.publicacion = publicacion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.precios = precios;
		this.formaDePago = formaDePago;
		this.inquilino = inquilino;
		this.estado = EstadoInicial.getInstance();
	}
	
	/**
	 * Crea una nueva reserva en estado CONDICIONAL con los valores dados
	 * 
	 * @param publicacion Publicacion
	 * @param fechaInicio Calendar
	 * @param fechaFin Calendar
	 * @param precios List<PrecioDiaOcupacion>
	 * @param formaDePago FormaDePago
	 * @param inquilino Usuario
	 * @return Reserva
	 */
	public static Reserva reservaCondicional(Publicacion publicacion, Calendar fechaInicio, Calendar FechaFin, ArrayList<PrecioDiaOcupacion> precios,
			FormaDePago formaDePago, Usuario inquilino) {
		Reserva reserva = new Reserva(publicacion, fechaInicio, FechaFin, precios, formaDePago, inquilino);
		reserva.setEstado(EstadoCondicional.getInstance());
		return reserva;
	}
	
	protected void setEstado(EstadoReserva estado) {
		this.estado = estado;
	}

	/**
	 * Devuelve el momento en que se ingreso la reserva
	 * 
	 * @return Calendar timestamp de cuando s ehizo la reserva
	 */
	public Calendar getFecgaHoraReserva() {
		return fecgaHoraReserva;
	}

	/**
	 * Devuelve la publicacion asociada a la resreva
	 * 
	 * @return Publicacion
	 */
	public Publicacion getPublicacion() {
		return publicacion;
	}

	/**
	 * devuelve la fecha de inicio de la reserva
	 * 
	 * @return Calendar
	 */
	public Calendar getFechaInicio() {
		return this.fechaInicio;
	}
	
	/**
	 * Devuleve la fecha de fin de la reserva
	 * 
	 * @return Calendar
	 */
	public Calendar getFechaFin() {
		return this.fechaFin;
	}

	/**
	 * Devuleve el precio de la reserva por cada dia de la misma
	 *  
	 * @return ArrayList<PrecioDiaOcupacion>
	 */
	public ArrayList<PrecioDiaOcupacion> getPrecios() {
		return this.precios;
	}

	/**
	 * Devuelve la forma de pago de la reserva
	 * 
	 * @return FormaDePago
	 */
	public FormaDePago getFormaDePago() {
		return formaDePago;
	}

	/**
	 * Devuleve el usuario que realizo la reserva
	 * 
	 * @return Usuario
	 */
	public Usuario getInquilino() {
		return inquilino;
	}
	
	/**
	 * Envia la reserva la cuenta de correo indicada 
	 * 
	 * @param email String correo electronico
	 */
	public void enviarA(String email) {
		/*
		 Se envia la reserva por mail al email 
		*/
	}

	/**
	 * El propietario acepta la reserva con este metodo
	 */
	public void aceptar() {
		this.estado.aceptar(this);
	}
	
	/**
	 * El propietario rechaza la reserva con este metodo
	 */
	public void rechazar() {
		this.estado.rechazar(this);
	}
	/**
	 * El usuario cancela la reserva con est emetodo
	 */
	public void cancelar() {
		this.estado.cancelar(this);
	}
	
	/**
	 * Indica si la reserva es futura
	 * 
	 * @return Boolean
	 */
	public Boolean esFutura() {
		return this.getFechaInicio().after(Calendar.getInstance());
	}

	/**
	 * Indica si la reserva es de un inmueble en la ciudad indicada
	 * 
	 * @param ciudad String nombre de una ciudad
	 * @return Boolean
	 */
	public Boolean esDeCiudad(String ciudad) {
		return this.getPublicacion().getCiudadInmueble() == ciudad;
	}

	/**
	 * Indica si l areserva es condicional
	 * 
	 * @return Boolean
	 */
	public Boolean esCondicional() {
		return this.estado.esCondicional();
	}
	
	/**
	 * Indica si la reserva esta finalizada
	 * 
	 * @return Boolean
	 */
	public Boolean estaFinalizada() {
		return this.estado.estaFinalizada(this);
	}

	/**
	 * Calcula y devuelve el importe total de la reserva
	 * 
	 * @return double
	 */
	public Double precioTotalReserva() {
		Double precioAcumulado = 0.0;
		for (PrecioDiaOcupacion precio : this.getPrecios()) {
			precioAcumulado += precio.getPrecio();
		}
		return precioAcumulado;
			
	}

	/**
	 * Calcula y devuelve el importe d ela reserva para la cantidad de dias indicada
	 * 
	 * @param cantidadDeDias int
	 * @return double
	 */
	public double valorEnCantidadDeDias(int cantidadDeDias) {
		double precioAcumulado = 0.0;
		for(int inicio=0; inicio < cantidadDeDias ; inicio++) {
			precioAcumulado += this.getPrecios().get(inicio).getPrecio();	
		}
		return precioAcumulado;
	}

	/**
	 * Devuelve el estado de la reserva
	 * 
	 * @return EstadoReserva
	 */
	public EstadoReserva getEstado() {
		return this.estado;
	}

	/**
	 * Indica si la reserva se concreto
	 * 
	 * @return Boolean
	 */
	public Boolean seConcreto() {
		return this.getEstado().seConcreto();
	}
	
}
