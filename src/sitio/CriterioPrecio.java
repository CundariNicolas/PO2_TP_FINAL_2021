package sitio;

import java.util.ArrayList;
import java.util.stream.Collectors;

import publicacion.Publicacion;

public class CriterioPrecio implements CriterioBusqueda{
	private double precioDesde;
	private double precioHasta;
	
	
	/**Retorna una instancia de CriterioPrecio que representa la busqueda
	 * desde {@code precioDesde} inicial hasta {@code precioHasta}
	 * 
	 * @param desde double
	 * @param hasta double
	 * @return CriterioBusqueda
	 */
	public CriterioPrecio(double desde, double hasta) {
		this.precioDesde = desde;
		this.precioHasta = hasta;
	}
	
	
	@Override
	/**Retorna un ArrayList<Publicacion> con las publicaciones que cumplen con este criterio de busqueda representado en el objeto
	 *(desde {@code precioDesde} inicial hasta {@code precioHasta})
	 * @param publicaciones ArrayList<Publicacion>
	 * @return ArrayList<Publicacion>
	 */
	public ArrayList<Publicacion> lasQueCumplen(ArrayList<Publicacion> publicaciones) {
		return publicaciones.stream()
				.filter(p -> p.getPrecio().stream().allMatch( d -> d.getPrecio() >= precioDesde && d.getPrecio() <= precioHasta))
				.collect(Collectors.toCollection(ArrayList::new));

		
	}
}
