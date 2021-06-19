package sitio;

import publicacion.Publicacion;

public interface Observador {
	
	public Publicacion getPublicacion();

	public void notificar();

}
