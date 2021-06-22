package formasDePago;

public class FormaDePago {

	private String codigo;
	private String descripcion;
	
	public FormaDePago (String codigo, String descripcion) {
		this.setDescripcion(descripcion);
		this.setSetCodigo(codigo);
	}

	public void setSetCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}
	
}
