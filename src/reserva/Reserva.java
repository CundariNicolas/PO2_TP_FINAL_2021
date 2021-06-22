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
	
	public static Reserva reservaCondicional(Publicacion publicacion, Calendar fechaInicio, Calendar FechaFin, ArrayList<PrecioDiaOcupacion> precios,
			FormaDePago formaDePago, Usuario inquilino) {
		Reserva reserva = new Reserva(publicacion, fechaInicio, FechaFin, precios, formaDePago, inquilino);
		reserva.setEstado(EstadoCondicional.getInstance());
		return reserva;
	}
	
	protected void setEstado(EstadoReserva estado) {
		this.estado = estado;
	}

	public Calendar getFecgaHoraReserva() {
		return fecgaHoraReserva;
	}

	public Publicacion getPublicacion() {
		return publicacion;
	}

	public Calendar getFechaInicio() {
		return this.fechaInicio;
	}
	
	public Calendar getFechaFin() {
		return this.fechaFin;
	}

	public ArrayList<PrecioDiaOcupacion> getPrecios() {
		return this.precios;
	}

	public FormaDePago getFormaDePago() {
		return formaDePago;
	}

	public Usuario getInquilino() {
		return inquilino;
	}
	
	
	public void enviarA(String email) {
		/*
		 Se envia la reserva por mail al email 
		*/
	}
		
	public void aceptar() {
		this.estado.aceptar(this);
	}
	
	public void rechazar() {
		this.estado.rechazar(this);
	}
	
	public void cancelar() {
		this.estado.cancelar(this);
	}
	
	public Boolean esFutura() {
		return this.getFechaInicio().after(Calendar.getInstance());
	}

	public Boolean esDeCiudad(String ciudad) {
		return this.getPublicacion().getCiudadInmueble() == ciudad;
	}

	public Boolean esCondicional() {
		return this.estado.esCondicional();
	}
	
	public Boolean estaFinalizada() {
		return this.estado.estaFinalizada(this);
	}

	public Double precioTotalReserva() {
		Double precioAcumulado = 0.0;
		for (PrecioDiaOcupacion precio : this.getPrecios()) {
			precioAcumulado += precio.getPrecio();
		}
		return precioAcumulado;
			
	}

	public double valorEnCantidadDeDias(int cantidadDeDias) {
		double precioAcumulado = 0.0;
		for(int inicio=0; inicio < cantidadDeDias ; inicio++) {
			precioAcumulado += this.getPrecios().get(inicio).getPrecio();	
		}
		return precioAcumulado;
	}

	public EstadoReserva getEstado() {
		return this.estado;
	}
	
}
