package sitio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.stream.Collectors;
import publicacion.Publicacion;

public class CriterioBasico {
	private String ciudad;
	private Calendar fechaDesde;
	private Calendar fechaHasta;
	private ArrayList<CriterioBusqueda> criterioExtra;
	
	/**
	 * Representa el criterio de busqueda basico para buscar entre las publicaciones
	 * @param ciudad String
	 * @param fechaDesde Calendar
	 * @param fechaHasta Calendar
	 * @return CriterioBasico
	 */
	public CriterioBasico(String ciudad, Calendar fechaDesde, Calendar fechaHasta) {
		this.ciudad = ciudad;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.criterioExtra = new ArrayList<CriterioBusqueda>();
	}
	
	
	/**
	 * Agrega criterios extra a la busqueda basica
	 * @param criterio CriterioBusqueda
	 * @return void
	 */
	public void addCriterio(CriterioBusqueda criterio) {
		this.criterioExtra.add(criterio);
	}
	 
	
	/**
	 * Retorna un ArrayList<Publicacion> de las publicaciones que cumplen con los criterios basicos y los criterios extra
	 * @param publicaciones ArrayList<Publicacion>
	 * @return ArrayList<Publicacion>
	 */
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
	
	/**
	 * Retorna un ArrayList<Publicacion> que cumple con el criterio basico
	 * @param publicaciones ArrayList<Publicacion>
	 * @return ArrayList<Publicacion>
	 */
	private ArrayList<Publicacion> criterioBasico(ArrayList<Publicacion >publicaciones) {
		return publicaciones.stream().filter(p -> p.getCiudadInmueble() == this.ciudad && p.estaLibreEntre(fechaDesde, fechaHasta)).collect(Collectors.toCollection(ArrayList::new));
	}
	
	/**
	 * Retorna un ArrayList<Publicacion> que cumple con todos criterio extra
	 * @param publicaciones ArrayList<Publicacion>
	 * @return ArrayList<Publicacion>
	 */
	private ArrayList<Publicacion> criteriosExtra(ArrayList<Publicacion> publicaciones) {
		return this.criterioExtra.stream().flatMap(crit -> crit.lasQueCumplen(publicaciones).stream()).collect(Collectors.toCollection(ArrayList::new));
	}

	
	
	
}
