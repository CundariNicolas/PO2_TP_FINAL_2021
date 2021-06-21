package categoria;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import calificacion.Calificacion;
import usuario.Usuario;

public abstract class Categoria {
	
	protected String aplicableA;
	
	private String nombreDeCategoria;
	
	private Map<Usuario,Calificacion> calificaciones;
	
	public abstract String aplicableA();
	
	public String nombre() {
	return this.nombreDeCategoria;
	}
	
	Categoria(String nombre){
		this.nombreDeCategoria = nombre;
	}
	
	public Double promedioDePuntaje() {
		return this.sumaDeCalificaciones() / this.calificaciones.size();	
	}
	
	private double sumaDeCalificaciones() {
		double sumaDeCalificaciones=0;
		Iterator<Usuario> usuarios = calificaciones.keySet().iterator();
		while(usuarios.hasNext()) {
			sumaDeCalificaciones=  calificaciones.get(usuarios.next()).puntaje;
		}
		return sumaDeCalificaciones;
	}
	
	public void addCalificacion(Usuario usuario, Calificacion calificacion) {
		this.calificaciones.put(usuario,calificacion);
	}
	
	public Calificacion verCalificacionDeUn(Usuario unUsuario) {
		return this.calificaciones.get(unUsuario);
	}
	
	public boolean esIgualA(Categoria otraCategoria) {
		return this.nombre() == otraCategoria.nombre();
	}

	public Categoria estasEn(Set<Categoria> categorias) {
		Categoria categoriaBuscada = null;
		for (Categoria categoria:categorias) {
			if (this.esIgualA(categoria)) {
				categoriaBuscada = categoria;
			}
		}
		return categoriaBuscada;
	}
	
	public Map<Usuario,Calificacion> getCalificaciones () {
		return this.calificaciones;
		
	}
	
}
