package publicacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.stream.Stream;

import formasDePago.FormaDePago;
import inmueble.Inmueble;
import reserva.Reserva;
import sitio.Observador;
import usuario.Usuario;

public class Publicacion {
	private Inmueble inmueble;
	private Calendar fechaInicio;
	private Calendar fechaFin;
	private ArrayList<Foto> fotos;
	private ArrayList<PrecioDiaOcupacion> preciopordiaocupado;
	private ArrayList<Observador> observadorBajaPrecio;
	private Usuario propietario;
	
	public Publicacion(Usuario propietario, Inmueble inmueble, Calendar inicio, Calendar fin, ArrayList<Foto> fotos, ArrayList<PrecioDiaOcupacion> precio) {
		this.propietario = propietario;
		this.inmueble = inmueble;
		this.fechaInicio = inicio;
		this.fechaFin = fin;
		this.setFotos(fotos);
		this.setPrecioPeriodo(precio);
		this.preciopordiaocupado = new ArrayList<PrecioDiaOcupacion>();
		this.observadorBajaPrecio = new ArrayList<Observador>();
		
	}
	
	public void registrarOcupacion(Calendar fechainicio, Calendar fechaFin) {
		/**
		 * Registra una ocupaci�n en un periodo dado
		 * El periodo dado no deber�a estar ocupado para poder llevarse a cabo
		 */
		
		preciopordiaocupado.forEach(dia -> {
			if(dia.getFecha().after(fechainicio) || dia.getFecha().equals(fechaFin) && dia.getFecha().before(fechainicio) || dia.getFecha().equals(fechaFin)) {
				dia.setOcupado();
			}
		});
		
	}
	
	
	public void registrarCancelacion(Calendar fechaInicio2, Calendar fechaFin2) {
		preciopordiaocupado.forEach(dia -> {
			if(dia.getFecha().after(fechaInicio2) || dia.getFecha().equals(fechaFin2) && dia.getFecha().before(fechaInicio2) || dia.getFecha().equals(fechaFin2)) {
				dia.setLibre();
			}
		});
		
	}
	
	public boolean estaLibreEntre(Calendar fechaDesde, Calendar fechaHasta) {
		
		return getPeriodoEspecificado(fechaDesde, fechaHasta).allMatch( p -> !p.estaOcupado());
	}
	
	
	public ArrayList<FormaDePago> medioDePagoHabilitado(){
		return inmueble.getFormaDePago();
	}
	
	
	public void notificarBajaEnPrecio() {
		
		
	}
	
	public void setPrecioPeriodo(ArrayList<PrecioDiaOcupacion> precio2) {
		this.preciopordiaocupado = precio2;
	}
	
	
	public boolean disponibleHoy(Calendar fechaActual) {
		return this.preciopordiaocupado.stream().filter(d -> d.getFecha().equals(fechaActual)).findFirst().get().estaOcupado();
	}
	
	public double precioEnPeriodo(Calendar inicio, Calendar fin) {
		return getPeriodoEspecificado(inicio, fin).map(p -> p.getPrecio()).reduce((double) 0, (a,b) -> a+b);
	}
	
	public void aplicarPoliticaCancelacion(Reserva reserva) {
		this.inmueble.getPoliticaCancelacion().aplicar(reserva);		
	}
	
	private Stream<PrecioDiaOcupacion> getPeriodoEspecificado(Calendar inicio, Calendar fin){
		return this.preciopordiaocupado.stream().filter(p -> p.getFecha().after(inicio) || p.getFecha().equals(inicio) && p.getFecha().before(fin) || p.getFecha().equals(fin));
	}
	

	

	
	
	/** private boolean estaDisponibleEntre(Periodo periodo) {
		/** Indica si est� disponible en el periodo dado
		 * Verdadero si el periodo a ocupar esta disponible, no debe coincidir con ningun periodo ocupado ya reservado
		 * 
		 
		return this.getPeriodosOcupados().stream().allMatch(ocupado -> this.estaLibreAntes(ocupado, periodo) || this.estaLibreDespues(ocupado, periodo));
	}
	
	
	/* estaLibreAntes 
	boolean estaLibreAntes(Periodo ocupado, Periodo periodo) {
		/**Indica si el periodo a ocupar esta libre antes del periodo ocupado, que no exista una interseccion entre los dias de los periodos
		 * 
		 
		return  this.elInicioAOcuparEstaAntesOElMismoDia(ocupado, periodo) && this.elFinEstaAntesDelInicioOcupado(ocupado, periodo) ;
	}
	
	
	
	boolean elFinEstaAntesDelInicioOcupado(Periodo ocupado, Periodo periodo) {
		return ocupado.getFechaInicio().after(periodo.getFechaFin());
	}
	boolean elInicioAOcuparEstaAntesOElMismoDia(Periodo ocupado, Periodo periodo) {
		return ocupado.getFechaInicio().after(periodo.getFechaInicio());
	}
	
	
	*/
	
	
	
	
	
	
	/* estaLibreDespues 
	
	boolean estaLibreDespues(Periodo ocupado, Periodo periodo) {
		/**
		 * indica si el periodo a ocupare sta libre despues del periodo ocupado, si es el mismo dia
		 * se asume como desocupado, que no exista interseccion entre los dias de ambos periodos
		 
		return this.elInicioAOcuparEstaDespuesOElMismoDia(ocupado, periodo) && this.elFinAOcuparEstaDespuesOElMismoDia(ocupado, periodo);
	}
	
	
	private boolean elFinAOcuparEstaDespuesOElMismoDia(Periodo ocupado, Periodo periodo) {
		
		return ocupado.getFechaFin().before(periodo.getFechaFin()) ;
	}
	
	
	
	
	

	private boolean elInicioAOcuparEstaDespuesOElMismoDia(Periodo ocupado, Periodo periodo) {
		/**
		 * Indica si la fecha del fin del periodo ocupado esta antes del inicio del periodo o es el mismo dia
		 
		return (ocupado.getFechaFin().before(periodo.getFechaInicio()) );
	}
	
	
	
	
	*/
	
	
	
	


	
	
	// GETTERS AND SETTERS
	
	public Inmueble getInmueble() {
		return inmueble;
	}

	public Calendar getFechaInicioPublicacion() {
		return fechaInicio;
	}

	public Calendar getFechaFin() {
		return fechaFin;
	}

	public ArrayList<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(ArrayList<Foto> fotos) {
		this.fotos = fotos;
	}

	public ArrayList<PrecioDiaOcupacion> getPrecio() {
		return preciopordiaocupado;
	}

	
	public String getCiudadInmueble() {
		return this.inmueble.getCiudad();
	}

	


	public Usuario getPropietario() {
		
		return propietario;
	}

	

}
