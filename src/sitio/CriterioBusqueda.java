package sitio;

import java.util.ArrayList;

import publicacion.Publicacion;

public interface CriterioBusqueda {
	public ArrayList<Publicacion> lasQueCumplen(ArrayList<Publicacion> publicaciones);

}
