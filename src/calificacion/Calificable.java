package calificacion;

import java.util.Map;

import categoria.Categoria;
import usuario.Usuario;

public interface Calificable {
	
	public void setCalificacion(Usuario unUsuario, Categoria unaCategoria, Calificacion UnaCalificacion);

	public Map<Usuario,Calificacion> getCalificaciones(Categoria unaCategoria);

}
