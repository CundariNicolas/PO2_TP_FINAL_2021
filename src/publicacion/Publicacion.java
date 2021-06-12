package publicacion;

import java.util.ArrayList;
import java.util.Calendar;

import inmueble.FormaDePago;
import inmueble.Inmueble;

public class Publicacion {
	private Inmueble inmueble;
	private Calendar fechaInicio;
	private Calendar fechaFin;
	private Calendar checkIn;
	private Calendar checkOut;
	private ArrayList<Foto> fotos;
	private ArrayList<PrecioPeriodo> precio;
	private ArrayList<Periodo> periodoOcupado;
	private ArrayList<Observer> observadorBajaPrecio;
	
	public Publicacion(Inmueble inmueble, Calendar inicio, Calendar fin, Calendar checkIn, Calendar checkOut, ArrayList<Foto> fotos, ArrayList<PrecioPeriodo> precio) {
		this.inmueble = inmueble;
		this.fechaInicio = inicio;
		this.fechaFin = fin;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.setFotos(fotos);
		this.setPrecio(precio);
		this.periodoOcupado = new ArrayList<Periodo>();
		this.observadorBajaPrecio = new ArrayList<Observer>();
		
	}
	
	public void registrarOcupacion(Periodo periodoOcupacion) {
		/**
		 * Registra una ocupación en un periodo dado
		 * El periodo dado no debería estar ocupado para poder llevarse a cabo
		 */
		if(this.estaDisponibleEntre(periodoOcupacion)) {
			periodoOcupado.add(periodoOcupacion);
		}
		
	}
	private boolean estaDisponibleEntre(Periodo periodo) {
		/** Indica si está disponible en el periodo dado
		 * Verdadero si el periodo a ocupar esta disponible, no debe coincidir con ningun periodo ocupado ya reservado
		 * 
		 */
		return this.getPeriodosOcupados().stream().allMatch(ocupado -> this.estaLibreAntes(ocupado, periodo) || this.estaLibreDespues(ocupado, periodo));
	}
	
	
	/* estaLibreAntes */
	boolean estaLibreAntes(Periodo ocupado, Periodo periodo) {
		/**Indica si el periodo a ocupar esta libre antes del periodo ocupado, que no exista una interseccion entre los dias de los periodos
		 * 
		 */
		return  this.elInicioAOcuparEstaAntesOElMismoDia(ocupado, periodo) && this.elFinEstaAntesDelInicioOcupado(ocupado, periodo) ;
	}
	
	
	
	boolean elFinEstaAntesDelInicioOcupado(Periodo ocupado, Periodo periodo) {
		return ocupado.getFechaInicio().after(periodo.getFechaFin());
	}
	boolean elInicioAOcuparEstaAntesOElMismoDia(Periodo ocupado, Periodo periodo) {
		return ocupado.getFechaInicio().after(periodo.getFechaInicio());
	}
	
	
	
	
	
	public ArrayList<FormaDePago> medioDePagoHabilitado(){
		return inmueble.getFormaDePago();
	}
	
	
	
	
	
	/* estaLibreDespues */
	
	boolean estaLibreDespues(Periodo ocupado, Periodo periodo) {
		/**
		 * indica si el periodo a ocupare sta libre despues del periodo ocupado, si es el mismo dia
		 * se asume como desocupado, que no exista interseccion entre los dias de ambos periodos
		 */
		return this.elInicioAOcuparEstaDespuesOElMismoDia(ocupado, periodo) && this.elFinAOcuparEstaDespuesOElMismoDia(ocupado, periodo);
	}
	
	/*  asd asd aasdads */
	/** asd*/
	
	private boolean elFinAOcuparEstaDespuesOElMismoDia(Periodo ocupado, Periodo periodo) {
		
		return ocupado.getFechaFin().before(periodo.getFechaFin()) ;
	}
	
	
	
	
	

	private boolean elInicioAOcuparEstaDespuesOElMismoDia(Periodo ocupado, Periodo periodo) {
		/**
		 * Indica si la fecha del fin del periodo ocupado esta antes del inicio del periodo o es el mismo dia
		 */
		return (ocupado.getFechaFin().before(periodo.getFechaInicio()) );
	}
	
	
	
	
	
	
	
	
	
	

	public void notificarBajaDePrecio() {
		this.observadorBajaPrecio.stream().forEach(obs -> obs.publish("Bajo el precio"));
		
	}
	
	public void suscribirBajaDePrecio(Observer observador1) {
		this.observadorBajaPrecio.add(observador1);
	}
	
	

	
	
	
	
	
	// GETTERS AND SETTERS
	public ArrayList<Periodo> getPeriodosOcupados() {
		
		return periodoOcupado;
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public Calendar getFechaInicioPublicacion() {
		return fechaInicio;
	}

	public Calendar getFechaFin() {
		return fechaFin;
	}

	public Calendar getCheckIn() {
		return checkIn;
	}

	public Calendar getCheckOut() {
		return checkOut;
	}

	public ArrayList<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(ArrayList<Foto> fotos) {
		this.fotos = fotos;
	}

	public ArrayList<PrecioPeriodo> getPrecio() {
		return precio;
	}

	public void setPrecio(ArrayList<PrecioPeriodo> precio) {
		this.precio = precio;
	}
	

}
