package calificacion;

import categoria.Categoria;
import usuario.Usuario;

public class Calificacion  {
	
	Categoria categoria;
	Integer puntaje;
	String comentario;
	Usuario origen;
	
	/**
	 * 
	 * @param unaCategoria
	 */
	
	Calificacion (Categoria unaCategoria) {
		this.setCategoria(unaCategoria);
	}
	
	/**
	 *  Devuelve la categoria a la que pertences
	 * 
	 * @return Categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}
	
	/**
	 * Configura la categoria de la clase
	 * @param categoria
	 * @return void
	 */
	public void setCategoria(Categoria categoria) {
		
		this.categoria = categoria;
	}
	
	/**
	 *  Devuelve el puntaje de la clase, este es de 1 a 5
	 * @return integer
	 */
	public Integer getPuntaje() {
		return puntaje;
	}
	
	/**
	 * Si es un valor valido puntajo lo setean en la clase, Sino hace nada
	 * @param puntaje integer
	 */
	public void setPuntaje(Integer puntaje) {
		if (this.puntajeAdmitido(puntaje)) {
			this.puntaje = puntaje;	
		}
	}
	
	/**
	 * 
	 * @return un string que representa el comentario
	 */
	public String getComentario() {
		return comentario;
	}
	
	/**
	 * Configura el 
	 * @param comentario Tipo String
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	/**
	 * Devuelve el usuario asignado
	 * @return Usuario {@link Usuario}
	 */
	public Usuario getOrigen() {
		return origen;
	}
	
	/**
	 * Configura el Origen de la Calificaion 
	 * @param origen tipo Usuario {@link Usuario}
	 * 
	 */
	public void setOrigen(Usuario origen) {
		this.origen = origen;
	}
	
	/**
	 * Verifica si el puntaje es mayor que cero y menos o igual que 5
	 * Son lo valores admitidos del puntaje
	 * 
	 * @param puntaje  int
	 * @return boolean 
	 */
	private boolean puntajeAdmitido(int puntaje) {
		return puntaje > 0 && puntaje <= 5;
		
	}
}
	

