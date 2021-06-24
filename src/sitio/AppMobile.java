package sitio;

import publicacion.Publicacion;

public class AppMobile implements Observador{
	private Publicacion publicacion;

	/**
	 * Craa una app mobile con la publicacion por la cual se suscribe
	 * 
	 * @param publiAppMobile
	 */
	public AppMobile(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	@Override
	/**
	 * Devuleve la pubicacion suscripta
	 * 
	 * @re Publicacion
	 */
	public Publicacion getPublicacion() {
		return this.publicacion;
	}

	@Override
	/**
	 * Notifica al "sistema externo" el cambio 
	 */
	public void notificar() {
		String mensaje = "Se ha cancelado una resserva en " + this.getPublicacion().getCiudadInmueble();
		String color = "Azul";
		Integer fontSize = 14;
		/*
		 APP_EXTERNA.popUp(mensaje, color, fontSize);
		 */
		
	}
	
	

}
