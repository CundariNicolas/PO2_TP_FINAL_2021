package categoria;

public class CategoriaUsuario extends Categoria {

	CategoriaUsuario(String nombre) {
		super(nombre);
	}

	@Override
	public String aplicableA() {
		return "Usuario";
	}

}
