package calificacion;

import categoria.Categoria;
import usuario.Usuario;

public class Calificacion  {
	
	Categoria categoria;
	Integer puntaje;
	String comentario;
	Usuario origen;
	
	Calificacion (Categoria unaCategoria) {
		this.setCategoria(unaCategoria);
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Integer getPuntaje() { 
		return puntaje;
	}
	public void setPuntaje(Integer puntaje) {
		if (this.puntajeAdmitido(puntaje)) {
			this.puntaje = puntaje;	
		}
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Usuario getOrigen() {
		return origen;
	}
	public void setOrigen(Usuario origen) {
		this.origen = origen;
	}
	
	private boolean puntajeAdmitido(int puntaje) {
		return puntaje > 0 && puntaje <= 5;
		
	}
}
	

