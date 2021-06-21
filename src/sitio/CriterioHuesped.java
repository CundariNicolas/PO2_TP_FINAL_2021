package sitio;

import java.util.ArrayList;
import java.util.stream.Collectors;

import publicacion.Publicacion;

public class CriterioHuesped implements CriterioBusqueda {
	
	private Integer cantidad;
	
	public CriterioHuesped(Integer cant) {
		this.cantidad = cant;
	}
	
	@Override
	public ArrayList<Publicacion> lasQueCumplen(ArrayList<Publicacion> publicaciones) {
		
		return publicaciones.stream().filter(p -> p.getInmueble().getCapacidad() >= cantidad).collect(Collectors.toCollection(ArrayList::new));

	}

}
