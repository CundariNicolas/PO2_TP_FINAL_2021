package reserva;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import inmueble.FormaDePago;
import publicacion.Observer;
import publicacion.Periodo;
import publicacion.PrecioPeriodo;
import publicacion.Publicacion;
import usuario.Usuario;

public class Reserva {
	private Calendar fecgaHoraReserva;
	private Publicacion publicacion;
	private Periodo periodo;
	private PrecioPeriodo precio;
	private FormaDePago formaDePago;
	private Usuario inquilino;
	private List<Observer> observadorCancelacion;
	private EstadoReserva estado;
	
	public Reserva(Publicacion publicacion, Periodo periodo, PrecioPeriodo precio,
			FormaDePago formaDePago, Usuario inquilino) {
		super();
		this.fecgaHoraReserva = Calendar.getInstance();
		this.publicacion = publicacion;
		this.periodo = periodo;
		this.precio = precio;
		this.formaDePago = formaDePago;
		this.inquilino = inquilino;
		this.estado = EstadoInicial.getInstance();
		this.observadorCancelacion = new ArrayList<Observer>();
	}
	
	public Reserva reservaCondicional(Publicacion publicacion, Periodo periodo, PrecioPeriodo precio,
			FormaDePago formaDePago, Usuario inquilino) {
		Reserva reserva = new Reserva(publicacion, periodo, precio, formaDePago, inquilino);
		reserva.setEstado(EstadoCondicional.getInstance());
		return reserva;
	}
	
	protected void setEstado(EstadoReserva estado) {
		this.estado = estado;
	}

	public List<Observer> getObservadorCancelacion() {
		return observadorCancelacion;
	}

	public void suscribirCancelacionReserva(Observer observadorCancelacion) {
		this.observadorCancelacion.add(observadorCancelacion);
	}

	public Calendar getFecgaHoraReserva() {
		return fecgaHoraReserva;
	}

	public Publicacion getPublicacion() {
		return publicacion;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public PrecioPeriodo getPrecio() {
		return precio;
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
	
	private void aplicarCancelacion() {
		// implementar
	}
	
	public void aceptar() {
		this.estado.aceptar(this);
	}
	
	public void rechazar() {
		this.estado.rechazar(this);
	}
	
	public void cancelar() {
		this.estado.cacelar(this);
	}
	
	protected void consolidar() {
		this.getPublicacion().registrarOcupacion(this.getPeriodo());
	}
	

}
