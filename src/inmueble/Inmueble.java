package inmueble;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import calificacion.Calificable;
import calificacion.Calificacion;
import formasDePago.FormaDePago;
import politicaCancelacion.PoliticaDeCancelacion;
import tipoInmueble.TipoDeInmueble;
import usuario.Usuario;
import servicios.Servicio;


public class Inmueble implements Calificable{
	
	private ArrayList<Calificacion> calificaciones; 
	private Set<FormaDePago> formaDePago;
	private TipoDeInmueble tipoInmueble; 
	private Double superficie;
	private String pais;
	private String ciudad;
	private String direccion ;
	private Set<Servicio> servicios;
	private Integer capacidad; 
	private int checkIN;
	private int checkOUT;
	private Integer cantidadDeVecesAlquilado;
	private PoliticaDeCancelacion politicaCancelacion;

	
	/**
	 * Constructor de la clase Inmueble representacion de un Inmuble que contiene los siguites parametros
	 * @param tipoInmueble {@link TipoDeInmueble}
	 * @param superficie Double que representa la superfice en Metros Cuadrados
	 * @param pais String represtando en forma completa ej: "Argentina"
	 * @param ciudad String represtando en forma completa ej: "Caballito"
	 * @param direccion String con altura de calle incluida represtando en forma completa ej: "Maipu 1210"
	 * @param capacidad Integer representando la capidad del inmueble
	 * @param checkIN Integer numero de 0 a 24 que respresenta la hora de ingreso
	 * @param checkOUT numero de 0 a 24 que respresenta la hora de salida
	 * @param politicaCancelacion {@link PoliticaDeCancelacion} Representa la politica de cancelacion asociado al alquiler del inmueble
	 * @param formasDePago {@link FormaDePago} Set<FormaDePago> Es un Set Representa la forma de pago que acepta el alquiler del inmuble
	 * @param serviciosDisponibles {@link Servicio} Set<Servicio> Es un Set que representa los servicios disponibles para el inmueble
	 */
	public Inmueble(TipoDeInmueble tipoInmueble, Double superficie, String pais, String ciudad, String direccion,
			Integer capacidad, int checkIN, int checkOUT,PoliticaDeCancelacion politicaCancelacion,
			Set<FormaDePago> formasDePago,Set<Servicio> serviciosDisponibles) {
		super();
		calificaciones = new ArrayList<Calificacion>();
		this.setFormaDePago(formasDePago);
		this.setTipo(tipoInmueble);
		this.setSuperficie (superficie);
		this.setPais (pais);
		this.setCiudad (ciudad);
		this.setDireccion (direccion);
		this.setServicios (serviciosDisponibles);
		this.setCapacidad (capacidad);
		this.setCheckIN (checkIN);
		this.setCheckOUT (checkOUT);
		this.setCantidadDeVecesAlquilado (0);
		this.setPoliticaCancelacion (politicaCancelacion);
	}
	
	
	private boolean existeLaCalificacionDelUsuario(Usuario unUsuario) {
		return this.calificaciones
				.stream()
				.anyMatch(usuario-> usuario.getOrigen().equals(unUsuario));
	}
	
	/**
	 *  Metodo heradable de {@link Calificable} si otro {@link Usuario} ya califico al inmueble se reemplaza la calificacion
	 *  @param unaCalificacion que representa los puntajes del inmuble
	 */
	@Override
	public void setCalificacion(Calificacion unaCalificacion) {
		if (!this.existeLaCalificacionDelUsuario(unaCalificacion.getOrigen()))
			{
				this.getCalificaciones().add(unaCalificacion);
			}	
	}
	
	/**
	 *  Metodo heradable de {@link Calificable} si el  {@link Usuario} dentro de la clase ya ha calificado
	 *  al inmueble se reemplaza la calificacion.
	 *  
	 *  @param unaCalificacion que representa los puntajes del inmuebles
	 */
	@Override
	public List <Calificacion> getCalificaciones() {
		return this.calificaciones;
		
	}
	
	/**
	 * Suma 1 a la cantiad de veces Alquilados, por defecto empieza en 0
	 */
	public void aumentarCantidadVecesAlquilado() {
		this.cantidadDeVecesAlquilado = this.getCantidadDeVecesAlquilado() + 1;
	}	

	/**
	 * 
	 * @param pais String represtando en forma completa ej: "Argentina"
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
	/**
	 * 
	 * @param ciudad String represtando en forma completa ej: "Caballito"
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	/**
	 * Devuelve las formas de pago disponibles para el inmueble 
	 * @return Set<FormaDePago> representado las formas de Pago disponibles
	 */
	public Set<FormaDePago> getFormaDePago() {
		return this.formaDePago;
	}
	
	/**
	 * Devuelve el tipo de inmuble que representa {@link TipoDeInmueble}l
	 * @return TipoDeInmuble 
	 */
	public TipoDeInmueble getTipo() {
		return this.tipoInmueble;
	}		
	
	/**
	 * 
	 * @return Double que representa la superfice en Metros Cuadrados
	 */
	public Double getSuperficie() {
		return this.superficie;
	}
	
	/**
	 * 
	 * @return String represtando en forma completa ej: "Caballito"
	 */
	public String getCiudad() {
		return this.ciudad;
	}

	/**
	 * 
	 * @return String represtando en forma completa ej: "Argentina"
	 */
	public String getPais() {
		return this.pais;
	}
	
	/**
	 * 
	 * @return String con altura de calle incluida represtando en forma completa ej: "Maipu 1210"
	 */
	public String getDireccion() {
		return this.direccion;
	}

	/**
	 * 
	 *@return {@link Servicio} Set<Servicio> Es un Set que representa los servicios disponibles para el inmueble
 	 */
	public Set<Servicio> getServicios() {
		return this.servicios;
	}
	
	
	/**
	 * 
	 * @return integer que devuelva la cantiada de veces Alquilado
	 */
	public Integer getCantidadDeVecesAlquilado() {
		return this.cantidadDeVecesAlquilado;
	}
	/**
	 * 
	 * @return {@link PoliticaDeCancelacion} Representando la politica de cancelacion asociado al alquiler del inmueble
	 */
	public PoliticaDeCancelacion getPoliticaCancelacion() {
		return this.politicaCancelacion;
	}
	
	/**
	 * 
	 * @return Integer representando la capidad del inmueble
	 */
	public Integer getCapacidad() {
		return this.capacidad;
	}
	/**
	 * 
	 * @return integer de 0 a 24 que respresenta la hora de salida
	 */
	public int getCheckOUT() {
		return this.checkOUT;
	}
	
	/**
	 * 
	 * @return integer de 0 a 24 que respresenta la hora de Entrada
	 */
	public int getCheckIn() {
		return this.checkIN;
	}
	
	/**
	 * 
	 * @param unCheckIn Integer numero de 0 a 24 que respresenta la hora de ingreso si esta fuera del rango no se asigna.
	 */
	public void setCheckIN(int unCheckIn) {
		if (this.esHorarioValido(unCheckIn)) {
			this.checkIN = unCheckIn;	
		}
		
	}

	/**
	 * 
	 * @param unCheckout Integer numero de 0 a 24 que respresenta la hora de ingreso si esta fuera del rango no se asigna.
	 */
	public void setCheckOUT (int unCheckout) {
		if (this.esHorarioValido(unCheckout)) {			
			this.checkOUT = unCheckout;
		}
	}
	
	
	/**
	 * 
	 * @param politicaCancelacion  {@link PoliticaDeCancelacion} Representa la politica de cancelacion asociado al alquiler del inmueble
	 */
	public void setPoliticaCancelacion(PoliticaDeCancelacion politicaCancelacion) {
		this.politicaCancelacion = politicaCancelacion;
	} 
	
	/**
	 * 
	 * @param formaDePago  {@link FormaDePago} Set<FormaDePago> Es un Set Representa la forma de pago que acepta el alquiler del inmuble
	 */
	public void setFormaDePago(Set<FormaDePago> formaDePago) {
		this.formaDePago = formaDePago;
	}
	/**
	 * 
	 * @param tipo {@link TipoDeInmueble} Representa el tipo de inmuble
	 */
	public void setTipo(TipoDeInmueble tipo) {
		this.tipoInmueble = tipo;
	} 
	/**
	 * 
	 * @param superficie Double mayor a 0 que representa los metros cuadrados si es NO mayor a 0 no se configura;
	 */
	public void setSuperficie(Double superficie) {
		if (superficie > 0) {
			this.superficie = superficie;	
		}
		
	}
	 /**
	  * 
	  * @param direccion String con altura de calle incluida represtando en forma completa ej: "Maipu 1210"
	  */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * 
	 * @param servicios {@link Servicio} Set<Servicio> Es un Set que representa los servicios disponibles para el inmueble
	 */
	public void setServicios(Set<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	/**
	 * 
	 * @param capacidad Integer > 0 representando la capidad del inmueble si es menor a 0 no se configura 
	 */
	public void setCapacidad(Integer capacidad) {
		if (capacidad > 0) {
			this.capacidad = capacidad;	
		}
		
	}
	
	/**
	 * 
	 * @param cantidadDeVecesAlquilado
	 */
	private void setCantidadDeVecesAlquilado(Integer cantidadDeVecesAlquilado) {
		if (cantidadDeVecesAlquilado >= 0) {
			this.cantidadDeVecesAlquilado = cantidadDeVecesAlquilado;
		}
	}
	
	/**
	 * Valida el Integer que sea de 0 a 24 si esta en el rango devuelve TRUE
	 * fuera del rango de 0 a 24 es FALSE
	 * @param horario Integer de 0 a 24 que representa un horario valido
	 * @return booelean
	 */
	private boolean esHorarioValido(int horario) {
		return horario >= 0 && horario < 24;
	}
	
}