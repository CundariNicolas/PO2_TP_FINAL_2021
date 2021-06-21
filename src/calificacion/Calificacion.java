package calificacion;

import categoria.Categoria;
import usuario.Usuario;

public class Calificacion {
	
	private Categoria categoria;

	private int puntaje;

	private String comentario;

	private Usuario origen;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
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
	
}
