package sitio;

import java.util.ArrayList;
import java.util.Calendar;
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
	}
	
	public void addCriterio(CriterioBusqueda criterio) {
		this.criterioExtra.add(criterio);
	}
	
	public ArrayList<Publicacion> lasQueCumplen(ArrayList<Publicacion> publicaciones){
		Stream<Publicacion> aplicados = publicaciones.stream().filter(p -> p.getCiudadInmueble() == this.ciudad && p.estaLibreEntre(fechaDesde, fechaHasta));
		Stream<Publicacion> aplicar = Stream.empty();
		criterioExtra.forEach(crit -> Stream.concat(aplicar,crit.lasQueCumplen(publicaciones).stream()));
		
		return Stream.concat(aplicados, aplicar).distinct().collect(Collectors.toCollection(ArrayList::new));
	}
	
	// Las que cumplen estas tres condiciones
}
