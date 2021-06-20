package sitio;

import publicacion.Publicacion;

public class PaginaWeb implements Observador{
	private Publicacion publicacion;

	@Override
	public Publicacion getPublicacion() {
		return this.publicacion;
	}

	@Override
	public void notificar() {
		String mensaje = "";
		mensaje = "No te pierdas esta oferta Un inmueble ";
		mensaje	= mensaje + this.getPublicacion().getDescripcionTipoInmueble();
		mensaje = mensaje + " a tan sólo ";
		mensaje = mensaje + this.getPublicacion().getPrecio().stream().min(precioDia -> precioDia.getPrecio());
		mensaje = mensaje + " pesos.";
		/*
		 APP_EXTERNA.publish(String mensaje);
		 */
		
	}
	

}
