package calificacion;

import java.util.List;

import usuario.Usuario;


public interface Calificable {
	
	public void setCalificacion(Calificacion unaCalificaion);
	public List <Calificacion> getCalificaciones();
	int compareTo(Usuario o);

}
