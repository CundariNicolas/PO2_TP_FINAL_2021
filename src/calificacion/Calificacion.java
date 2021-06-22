package calificacion;

import categoria.Categoria;
import usuario.Usuario;

public class Calificacion  {
	
	Categoria categoria;
	Integer puntaje;
	String comentario;
	Usuario origen;
	
	
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
	/*
	public boolean esDelMismoUsuario(Usuario unUsuario){
		return this.getOrigen() == unUsuario;
	}
	
	public boolean esDeLaMismaCategoria(Categoria unaCategoria){
		return this.getCategoria() == unaCategoria;
	}
	
	public List<Calificacion> filtraElUsuarioDeUnaLista(Usuario unUsuario, List<Calificacion> unalista) {
		return unalista.stream().filter(unaCalificacion-> unaCalificacion.getOrigen() == unUsuario)
				.collect(Collectors.toList());
	}
	
	public List<Calificacion> filtraCategoriasDeUnaLista (Categoria unaCategoria, List<Calificacion> unalista) {
		return unalista.stream().filter(unaCalificacion-> unaCalificacion.getCategoria() == unaCategoria)
				.collect(Collectors.toList());
	}
	
	public List<Calificacion> filtraPuntajeDeUnaLista (int puntaje, List<Calificacion> unalista) {
		return unalista.stream().filter(unaCalificacion-> unaCalificacion.getPuntaje() == puntaje)
				.collect(Collectors.toList());
	}
	
	public Opinion getOpinion() {
		return this.opinion;
	}
	*/
	

