package servicios;

public class Servicio {

	String codigo;
	String descripcion;
	
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

	public String getDescripcion() {
		return this.descripcion;
	}
}
