package categoria;

import java.util.Map;

import calificacion.Calificable;
import calificacion.Calificacion;
import usuario.Usuario;

public class CategoriaInmueble extends Categoria implements Calificable{

	public CategoriaInmueble(String nombre) {
		super(nombre);
	}

	@Override
	public String aplicableA() {
		// TODO Auto-generated method stub
		return "Inmueble";
	}

	@Override
	public void setCalificacion(Usuario unUsuario, Categoria unaCategoria, Calificacion UnaCalificacion) {
		//ver si se puede evitar Categoria
			if (unaCategoria.nombre() == this.nombre()) {
				this.addCalificacion(unUsuario, UnaCalificacion);
			}
	}

	@Override
	public Map<Usuario, Calificacion> getCalificaciones(Categoria unaCategoria) {
		return this.getCalificaciones();
	}

}
