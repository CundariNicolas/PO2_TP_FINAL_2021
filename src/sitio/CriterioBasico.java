package sitio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import publicacion.Publicacion;

public class CriterioBasico {
	private String ciudad;
	private Calendar fechaDesde;
	private Calendar fechaHasta;
	private ArrayList<CriterioBusqueda> criterioExtra;
	
	public CriterioBasico(String ciudad, Calendar fechaDesde, Calendar fechaHasta) {
		this.ciudad = ciudad;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.criterioExtra = new ArrayList<CriterioBusqueda>();
	}
	
	public void addCriterio(CriterioBusqueda criterio) {
		this.criterioExtra.add(criterio);
	}
	 
	public ArrayList<Publicacion> lasQueCumplen(ArrayList<Publicacion> publicaciones){
		
		
		if(!this.criterioExtra.isEmpty()) {
			return this.criteriosExtra(publicaciones).stream()
					.filter(p -> p.getCiudadInmueble() == this.ciudad && p.estaLibreEntre(fechaDesde, fechaHasta))
					.distinct()
					.collect(Collectors.toCollection(ArrayList::new));
			
			
			}
		else {
			return criterioBasico(publicaciones);
		}
		
		
		 
		
		
	}
	
	private ArrayList<Publicacion> criterioBasico(ArrayList<Publicacion >publicaciones) {
		return publicaciones.stream().filter(p -> p.getCiudadInmueble() == this.ciudad && p.estaLibreEntre(fechaDesde, fechaHasta)).collect(Collectors.toCollection(ArrayList::new));
	}
	
	private ArrayList<Publicacion> criteriosExtra(ArrayList<Publicacion> publicaciones) {
		return this.criterioExtra.stream().flatMap(crit -> crit.lasQueCumplen(publicaciones).stream()).collect(Collectors.toCollection(ArrayList::new));
	}

	
	
	// Las que cumplen estas tres condiciones
}
