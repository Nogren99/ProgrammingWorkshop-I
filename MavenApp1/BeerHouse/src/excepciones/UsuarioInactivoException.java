package excepciones;

public class UsuarioInactivoException extends Exception{
	private String userName;
	
	public UsuarioInactivoException(String mensajito) {
		super(mensajito);
		
	}
	

}
