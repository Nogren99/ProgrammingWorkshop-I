package modelo;

public class Operario extends Usuario{
	private boolean activo;
	
	public Operario(String username, String password) {
		super(username, password);
		this.activo=true;
	}

	public boolean isActivo() {
		return activo;
	}
	
}
