package categoria;

public class CategoriaInmueble extends Categoria {

	CategoriaInmueble(String nombre) {
		super(nombre);
	}

	@Override
	public String aplicableA() {
		// TODO Auto-generated method stub
		return "Inmueble";
	}

}
