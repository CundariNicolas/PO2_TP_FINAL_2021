package tipoInmueble;

public class TipoDeInmueble {

	String descripcion;
	
	/**
	 *  Contructor de la clase TipoDeInmueble 
	 * @param descripcion String que represetna el tipo de inmueble por ejemplo "PH" o "Departamento"
	 */
	public TipoDeInmueble(String descripcion) {
		this.setDescripcion(descripcion);
	}
	/**
	 * 
	 * @return String que represetna el tipo de inmueble por ejemplo "PH" o "Departamento" 
	 */
	public String codigoDescripcion() {
		return this.descripcion;
	}
	
	private void setDescripcion (String descripcion) {
		this.descripcion = descripcion;
	}

}
