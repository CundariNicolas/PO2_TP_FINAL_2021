package publicacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;
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
		this.preciopordiaocupado = precio;
		this.observadorBajaPrecio = new ArrayList<Observador>();
		
	}
	
	public void registrarOcupacion(Calendar fechainicio, Calendar fechaFin) {
		/**
		 *
		 */
		
		this.preciopordiaocupado.forEach(dia -> {
			if((dia.getFecha().after(fechainicio) || dia.getFecha().equals(fechainicio)) && (dia.getFecha().before(fechaFin) || dia.getFecha().equals(fechaFin))) {
				dia.setOcupado();
			}
		});
		
	}
	
	
	public void registrarCancelacion(Calendar fechaInicio2, Calendar fechaFin2) {
		preciopordiaocupado.forEach(dia -> {
			if((dia.getFecha().after(fechaInicio2) || dia.getFecha().equals(fechaInicio2)) && (dia.getFecha().before(fechaFin2) || dia.getFecha().equals(fechaFin2))) {
				dia.setLibre();
			}
		});
		
	}
	
	public boolean estaLibreEntre(Calendar fechaDesde, Calendar fechaHasta) {
		
		return getPeriodoEspecificado(fechaDesde, fechaHasta).allMatch( p -> !p.estaOcupado());
	}
	
	
	public Set<FormaDePago> medioDePagoHabilitado(){
		return inmueble.getFormaDePago();
	}
	
	
	public void notificarBajaEnPrecio() {
		
		
	}
	
	public void setPrecioPeriodo(ArrayList<PrecioDiaOcupacion> precio2) {
		this.preciopordiaocupado = precio2; // revisar
	}
	
	
	public boolean disponibleHoy(Calendar fechaActual) {
		return !this.preciopordiaocupado.stream().filter(d -> d.getFecha().equals(fechaActual)).findFirst().get().estaOcupado();
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
