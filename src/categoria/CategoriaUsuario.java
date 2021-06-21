package categoria;

import java.util.Map;

import calificacion.Calificable;
import calificacion.Calificacion;
import usuario.Usuario;

public class CategoriaUsuario extends Categoria implements Calificable {

	CategoriaUsuario(String nombre) {
		super(nombre);
	}

	@Override
	public String aplicableA() {
		return "Usuario";
	}

	@Override
	public void setCalificacion(Usuario unUsuario, Categoria unaCategoria, Calificacion UnaCalificacion) {
			if (unaCategoria.nombre() == this.nombre()) {
				this.addCalificacion(unUsuario, UnaCalificacion);
			}
	}

	@Override
	public Map<Usuario, Calificacion> getCalificaciones(Categoria unaCategoria) {
		return this.getCalificaciones();
	}

}
