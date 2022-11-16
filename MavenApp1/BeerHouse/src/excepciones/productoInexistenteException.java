package excepciones;

public class productoInexistenteException extends Exception {

	public productoInexistenteException(String mensajito) {
        super(mensajito);
    }
}
