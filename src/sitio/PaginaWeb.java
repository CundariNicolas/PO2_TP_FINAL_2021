package sitio;

import java.util.Comparator;

import publicacion.Publicacion;
import reserva.Reserva;

public class PaginaWeb implements Observador{
	private Publicacion publicacion;

	public PaginaWeb(Publicacion publicacion) {
		super();
		this.publicacion = publicacion;
	}

	@Override
	public Publicacion getPublicacion() {
		return this.publicacion;
	}

	@Override
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
