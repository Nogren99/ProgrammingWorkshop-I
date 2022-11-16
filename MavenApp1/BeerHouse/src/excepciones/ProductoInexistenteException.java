package excepciones;

public class ProductoInexistenteException extends Exception {

	public ProductoInexistenteException(String mensajito) {
        super(mensajito);
    }
}
