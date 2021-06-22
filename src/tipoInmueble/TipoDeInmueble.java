package tipoInmueble;

public class TipoDeInmueble {

	String descripcion;
	
	public TipoDeInmueble(String descripcion) {
		this.setDescripcion(descripcion);
	}

	public String codigoDescripcion() {
		return this.descripcion;
	}
	
	private void setDescripcion (String descripcion) {
		this.descripcion = descripcion;
	}

}
