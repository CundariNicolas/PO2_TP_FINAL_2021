package inmueble;

import java.util.ArrayList;

import formasDePago.FormaDePago;
import politicaCancelacion.PoliticaDeCancelacion;
import tipoInmueble.TipoDeInmueble;
import servicios.Servicio;

public class Inmueble {
	private ArrayList<FormaDePago> formaDePago;
	
	private TipoDeInmueble tipo; 

	private Integer superficie;

	private  String pais;

	private String ciudad;

	private String direccion ;

	private ArrayList <Servicio> servicios; //

	private Integer capacidad; 
/*
	private Calendar checkIN;
// Esto se va hacer en la publicacion
	private Calendar checkOUT;
*/
	private Integer cantidadDeVecesAlquilado;

	private PoliticaDeCancelacion politicaCancelacion;

	
	public Inmueble(TipoDeInmueble tipoInmueble,float superficie, 
			String pais, String ciudad,String direccion, 
			Servicio servicios, int capacidad) {
		
	}
	
	
	
	public void setModoDePago (ArrayList <FormaDePago> formasDePago) {
		if (formasDePago.isEmpty()) {
			throw new IllegalArgumentException("Tiene que haber Al menos una forma de Pago");
		}
		
		this.formaDePago = formasDePago;
	}
	public void aumentarCantidadVecesAlquilado() {
		this.cantidadDeVecesAlquilado = this.getCantidadDeVecesAlquilado() + 1;
	}


	public Integer getCantidadVecesAlquilado() {
		return 1;
	}

	public ArrayList<FormaDePago> getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(ArrayList<FormaDePago> formaDePago) {
		this.formaDePago = formaDePago;
	}

	public TipoInmueble getTipo() {
		return tipo;
	}

	public void setTipo(TipoInmueble tipo) {
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

	public ArrayList<Servicios> getServicios() {
		return servicios;
	}

	public void setServicios(ArrayList<Servicios> servicios) {
		this.servicios = servicios;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public Calendar getCheckIN() {
		return checkIN;
	}

	public void setCheckIN(Calendar checkIN) {
		this.checkIN = checkIN;
	}

	public Calendar getCheckOUT() {
		return checkOUT;
	}

	public void setCheckOUT(Calendar checkOUT) {
		this.checkOUT = checkOUT;
	}

	public Integer getCantidadDeVecesAlquilado() {
		return cantidadDeVecesAlquilado;
	}

	public void setCantidadDeVecesAlquilado(Integer cantidadDeVecesAlquilado) {
		this.cantidadDeVecesAlquilado = cantidadDeVecesAlquilado;
	}

	public PoliticaCancelacion getPoliticaCancelacion() {
		return politicaCancelacion;
	}

	public void setPoliticaCancelacion(PoliticaCancelacion politicaCancelacion) {
		this.politicaCancelacion = politicaCancelacion;
	}
	
	
	
}