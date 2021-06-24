package sitio;

import publicacion.Publicacion;

public class PaginaWeb implements Observador{
	private Publicacion publicacion;

	/**
	 * Craa una paina web con la publicacion por la cual se suscribe
	 * 
	 * @param PaginaWeb
	 */
	public PaginaWeb(Publicacion publicacion) {
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
		String mensaje = "";
		mensaje = "No te pierdas esta oferta Un inmueble ";
		mensaje	= mensaje + this.getPublicacion().getInmueble();
		mensaje = mensaje + " a tan sólo ";
		mensaje = mensaje +	this.getPublicacion().getPrecio().stream().findFirst().get().getPrecio();
		mensaje = mensaje + " pesos.";
		/*
		 APP_EXTERNA.publish(String mensaje);
		 */
		
	}
	

}
