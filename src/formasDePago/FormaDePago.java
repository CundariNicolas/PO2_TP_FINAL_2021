package formasDePago;

public class FormaDePago {

	private String codigo;
	private String descripcion;
	
	/**
	 * Constructor de una Forma de Pago 
	 * Representa a las fomar de pago como Tarjeta de Debito , MercadoPago, etc 
	 * @param codigo String
	 * @param descripcion String 
	 */
	public FormaDePago (String codigo, String descripcion) {
		this.setDescripcion(descripcion);
		this.setSetCodigo(codigo);
	}

	/**
	 * Codigo interno de referencia sobre la forma de pago
	 * 
	 * @param codigo String
	 */
	public void setSetCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 *  configura del metodo de pago representado por un String 
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	/**
	 * 
	 * @return String que representa el cofigo de la forma de pago
	 */
	public String getCodigo() {
		return this.codigo;
	}
	
	/**
	 *  
	 * @return String representa la descripcion de la forma de pago Ejem "Mercado Libre", "Tarjeta de Debito", etc..
	 */

	public String getDescripcion() {
		return this.descripcion;
	}
	
}
