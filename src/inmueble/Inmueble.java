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
	
	@Override
	public void setCalificacion(Calificacion unaCalificacion) {
		if (!this.existeLaCalificacionDelUsuario(unaCalificacion.getOrigen()))
			{
				this.getCalificaciones().add(unaCalificacion);
			}	
	}
	
	@Override
	public List <Calificacion> getCalificaciones() {
		return this.calificaciones;
		
	}

	public void aumentarCantidadVecesAlquilado() {
		this.cantidadDeVecesAlquilado = this.getCantidadDeVecesAlquilado() + 1;
	}	

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
	public Set<FormaDePago> getFormaDePago() {
		return this.formaDePago;
	}
	
	public TipoDeInmueble getTipo() {
		return this.tipoInmueble;
	}		
	public Double getSuperficie() {
		return this.superficie;
	}
	
	public String getCiudad() {
		return this.ciudad;
	}

	public String getPais() {
		return this.pais;
	}

	public String getDireccion() {
		return this.direccion;
	}


	public Set<Servicio> getServicios() {
		return this.servicios;
	}
	
	public Integer getCantidadDeVecesAlquilado() {
		return this.cantidadDeVecesAlquilado;
	}

	public PoliticaDeCancelacion getPoliticaCancelacion() {
		return this.politicaCancelacion;
	}
	
	public Integer getCapacidad() {
		return this.capacidad;
	}
	
	public int getCheckOUT() {
		return this.checkOUT;
	}
	public int getCheckIn() {
		return this.checkIN;
	}
	
	public void setCheckIN(int unCheckIn) {
		if (this.esHorarioValido(unCheckIn)) {
			this.checkIN = unCheckIn;	
		}
		
	}
	
	public void setCheckOUT (int unCheckout) {
		if (this.esHorarioValido(unCheckout)) {			
			this.checkOUT = unCheckout;
		}
	}
	
	public void setPoliticaCancelacion(PoliticaDeCancelacion politicaCancelacion) {
		this.politicaCancelacion = politicaCancelacion;
	} 
	
	public void setFormaDePago(Set<FormaDePago> formaDePago) {
		this.formaDePago = formaDePago;
	}
	
	public void setTipo(TipoDeInmueble tipo) {
		this.tipoInmueble = tipo;
	} 
	
	public void setSuperficie(Double superficie) {
		if (superficie > 0) {
			this.superficie = superficie;	
		}
		
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public void setServicios(Set<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	
	public void setCapacidad(Integer capacidad) {
		if (capacidad > 0) {
			this.capacidad = capacidad;	
		}
		
	}
	private void setCantidadDeVecesAlquilado(Integer cantidadDeVecesAlquilado) {
		if (cantidadDeVecesAlquilado >= 0) {
			this.cantidadDeVecesAlquilado = cantidadDeVecesAlquilado;
		}
	}
	
	private boolean esHorarioValido(int horario) {
		return horario >= 0 && horario < 24;
	}
	
}