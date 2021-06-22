package calificacion;

import java.util.List;
import usuario.Usuario;

public interface Calificable {
	
	public void setCalificacion(Usuario unUsuario, String comentario, int puntaje);

	public List <Calificacion> getCalificaciones();

}
