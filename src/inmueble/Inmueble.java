package inmueble;

import java.util.ArrayList;
import java.util.Calendar;

import formasDePago.FormaDePago;
import politicaCancelacion.PoliticaDeCancelacion;
import tipoInmueble.TipoDeInmueble;
import servicios.Servicio;

public class Inmueble {
	private ArrayList <Calificacion> calificaciones; 
	
	private ArrayList<FormaDePago> formaDePago;
	
	private TipoDeInmueble tipo; 

	private Integer superficie;

	private  String pais;

	private String ciudad;

	private String direccion ;

	private ArrayList <Servicio> servicios; //

	private Integer capacidad; 

	private Calendar checkIN;

	private Calendar checkOUT;
	
	private Integer cantidadDeVecesAlquilado;

	private PoliticaDeCancelacion politicaCancelacion;

	/**
	 * 
	 * @param tipoInmueble &#60;TipoDeInmueble &#62
	 * @param superficie Superficie total del inmueble en M2 tipo Floar
	 * @param pais Pais de Residencia del Inmueble
	 * @param ciudad  Ciudad de Residencia del Inmueble
	 * @param direccion Direccion del inmueble ej: "Ricardo Gutierrez 1320"
	 * @param servicios &#60;Servicio &#62 una lista del los servicios que contiene el inmuelbe 
	 * @param capacidad capacidad de personas que entrar en inmuble Int
	 */
	public Inmueble(TipoDeInmueble tipoInmueble,float superficie, 
			String pais, String ciudad,String direccion, 
			ArrayList<Servicio> servicios, int capacidad) {
		
	}
	
	/**
	 *  Almacena una forma de pago para el inmueble
	 * 
	 * @param formasDePago un ArrayList con object &#60;FormaDePago &#62;
	 */
	public void setModoDePago (ArrayList <FormaDePago> formasDePago) {
		if (formasDePago.isEmpty()) {
			throw new IllegalArgumentException("Tiene que haber Al menos una forma de Pago");
		}
		
		this.formaDePago = formasDePago;
	}
	
	/**
	* Aumenta mas uno la cantidad de alquiles que tuvo el inmueble en uno
	* 
	* @param  Ninguno
	* @return void
	* 
	*/
	public void aumentarCantidadVecesAlquilado() {
		this.cantidadDeVecesAlquilado = this.getCantidadDeVecesAlquilado() + 1;
	}

	/**
	 *  Getter de Cantidad de veces Alquilado
	 * @return un entero que representa la cantidad de veces que se alquilo el inmueble
	 */
	public Integer getCantidadVecesAlquilado() {
		return this.cantidadDeVecesAlquilado;
	}
	
	/**
	 *  formas de pago aceptadas por el inmuble
	 * @return &#60;Forma de Pago&#62 Array del tipo FormaPago con los pago que acepta el inmuble
	 */
	public ArrayList<FormaDePago> getFormaDePago() {
		return formaDePago;
	}
	
	/**
	 * 
	 * @param formaDePago &#60;FormaDePago &#62 Array no vacio;
	 */
	public void setFormaDePago(ArrayList<FormaDePago> formaDePago) {
		this.formaDePago = formaDePago;
	}

	public String getCiudad() {
		// TODO Auto-generated method stub
		return null;
	}
	
	 /**
	  * 
	  * @return Strig que representa el tipo de inmueble
	  */
	public TipoDeInmueble getTipo() {
		return tipo;
	}

	/**
	 *  configura el tipo de inmuble que es el tipo de inmuble tiene que ser uno solo
	 * @param tipo &#60;TipoDeInmueble &#62
	 */
	
	public void setTipo(TipoDeInmueble tipo) {
		this.tipo = tipo;
	}
	
	public boolean estaOcupadoEn(Calendar fecha) {
		return this.checkIN.after(fecha) && this.checkOUT.before(fecha);
	}

	/**
	 * 
	 * @return superfieces en M2 del inmueble
	 */
	public Integer getSuperficie() {
		return superficie;
	}

	public void setSuperficie(Integer superficie) {
		this.superficie = superficie;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(ArrayList<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public Integer getCantidadDeVecesAlquilado() {
		return cantidadDeVecesAlquilado;
	}

	public void setCantidadDeVecesAlquilado(Integer cantidadDeVecesAlquilado) {
		this.cantidadDeVecesAlquilado = cantidadDeVecesAlquilado;
	}

	public PoliticaDeCancelacion getPoliticaCancelacion() {
		return politicaCancelacion;
	}

	public void setPoliticaCancelacion(PoliticaDeCancelacion politicaCancelacion) {
		this.politicaCancelacion = politicaCancelacion;
	}
	
	
	/**
	 * 
	 * @param calificacion agregar una calificacion al inmueble
	 */
	
	public void agregarCalificacion (Calificacion calificacion) {
		calificaciones.add(calificacion);
	}
	
	
	
}