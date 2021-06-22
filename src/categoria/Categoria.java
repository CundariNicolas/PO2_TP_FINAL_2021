package categoria;


public abstract class Categoria {

	String descripcion;
	
	Categoria (String descripcion){
		this.descripcion = descripcion;
	}
	public String getDescripcion() {
		return this.descripcion;
	}
}
