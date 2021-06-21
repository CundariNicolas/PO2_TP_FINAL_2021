package sitio;

import java.util.ArrayList;
import java.util.stream.Collectors;

import publicacion.Publicacion;

public class CriterioPrecio implements CriterioBusqueda{
	private Integer precioDesde;
	private Integer precioHasta;
	@Override
	public ArrayList<Publicacion> lasQueCumplen(ArrayList<Publicacion> publicaciones) {
		return publicaciones.stream().filter(p -> p.getPrecio().stream().allMatch( d -> d.getPrecio() >= precioDesde && d.getPrecio() <= precioHasta)).collect(Collectors.toCollection(ArrayList::new));

		
	}
}
