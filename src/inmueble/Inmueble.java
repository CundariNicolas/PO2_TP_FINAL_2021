package inmueble;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import calificacion.Calificable;
import calificacion.Calificacion;
import formasDePago.FormaDePago;
import politicaCancelacion.PoliticaDeCancelacion;
import tipoInmueble.TipoDeInmueble;
import usuario.Usuario;
import servicios.Servicio;


public class Inmueble implements Calificable{
	
	private ArrayList<Calificacion> calificaciones; 
	private ArrayList<FormaDePago> formaDePago;
	private TipoDeInmueble tipo; 
	private Integer superficie;
	private String pais;
	private String ciudad;
	private String direccion ;
	private ArrayList <Servicio> servicios;
	private Integer capacidad; 
	private int checkIN;
	private int checkOUT;
	private Integer cantidadDeVecesAlquilado;
	private PoliticaDeCancelacion politicaCancelacion;

	public Inmueble(TipoDeInmueble tipoInmueble,double superficie, 
			String pais, String ciudad,String direccion, 
			ArrayList<Servicio> servicios, int capacidad) {
	}
	
	public void setModoDePago (ArrayList <FormaDePago> formasDePago) {
			
		this.formaDePago = formasDePago;
	}
	
	public void aumentarCantidadVecesAlquilado() {
		this.cantidadDeVecesAlquilado = this.getCantidadDeVecesAlquilado() + 1;
	}

	public Integer getCantidadVecesAlquilado() {
		return this.cantidadDeVecesAlquilado;
	}
	

	public ArrayList<FormaDePago> getFormaDePago() {
		return formaDePago;
	}
	
	
	public void setFormaDePago(ArrayList<FormaDePago> formaDePago) {
		this.formaDePago = formaDePago;
	}
	
	public TipoDeInmueble getTipo() {
		return tipo;
	}

	
	public void setTipo(TipoDeInmueble tipo) {
		this.tipo = tipo;
	} 
		
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
	
	@Override
	public void setCalificacion(Calificacion unaCalificacion) {
		this.getCalificaciones().add(unaCalificacion);
	}
	
	@Override
	public List <Calificacion> getCalificaciones() {
		return this.getCalificaciones();
		
	}

	public int getCheckOUT() {
		return this.checkOUT;
	}
	
	
}