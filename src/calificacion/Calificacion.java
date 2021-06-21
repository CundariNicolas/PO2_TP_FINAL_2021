package calificacion;

public class Calificacion  {
	
	private int puntaje;
	private String comentario;
	
	Calificacion (int puntaje, String comentario) {
		this.puntaje= puntaje;
		this.comentario = comentario;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public String getComentario() {
		return comentario;
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
	

