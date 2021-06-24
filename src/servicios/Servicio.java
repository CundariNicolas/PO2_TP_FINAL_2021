package servicios;

public class Servicio {

	String codigo;
	String descripcion;
	/**
	 * Construcor de la Clase Servicio
	 * 
	 * @param codigo String codigo Interno de control
	 * @param descripcion String representado el nombre de un servicios por ejemplo: "luz", unico parametro
	 */
	Servicio (String codigo, String descripcion) {
		this.setCodigo(codigo);
		this.setDescripcion(descripcion);
	}

	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	private void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Devuelve un String que representa el servicio por ejemplo "Luz"
	 * @return String
	 */
	public String getDescripcion() {
		return this.descripcion;
	}
}
