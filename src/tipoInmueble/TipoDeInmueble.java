package tipoInmueble;

public class TipoDeInmueble {
	
	String codigo;
	String descripcion;
	
	TipoDeInmueble(String codigo, String descripcion) {
		this.setCodigo(codigo);
		this.setDescripcion(descripcion);
	}

	public String codigoDescripcion() {
		return this.descripcion;
	}
	private void setDescripcion (String descripcion) {
		this.descripcion = descripcion;
	}
	
	private void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
