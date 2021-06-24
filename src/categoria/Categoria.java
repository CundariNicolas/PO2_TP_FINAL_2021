package categoria;


public abstract class Categoria {

	String descripcion;
	/**
	 * Contructor de Clase
	 * @param descripcion tipo String
	 */
	Categoria (String descripcion){
		this.descripcion = descripcion;
	}
	
	/**
	 *  Descripcion de la clase
	 * @return String 
	 */
	public String getDescripcion() {
		return this.descripcion;
	}
}
