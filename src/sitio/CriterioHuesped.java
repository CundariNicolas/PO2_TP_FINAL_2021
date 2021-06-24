package sitio;

import java.util.ArrayList;
import java.util.stream.Collectors;

import publicacion.Publicacion;

public class CriterioHuesped implements CriterioBusqueda {
	
	private Integer cantidad;
	
	
	/**Retorna una instancia de CriterioHuesped que representa la busqueda a
	 * partir de la cantidad de huespedes
	 * @param cantidad Integer
	 * @return CriterioBusqueda
	 */
	public CriterioHuesped(Integer cant) {
		this.cantidad = cant;
	}
	
	@Override
	/**Retorna un ArrayList<Publicacion> con las publicaciones que cumplen con este criterio de busqueda representado en el objeto
	 * @param publicaciones ArrayList<Publicacion>
	 * @return ArrayList<Publicacion>
	 */
	public ArrayList<Publicacion> lasQueCumplen(ArrayList<Publicacion> publicaciones) {
		
		return publicaciones.stream().filter(p -> p.getInmueble().getCapacidad() >= cantidad).collect(Collectors.toCollection(ArrayList::new));

	}

}
