package excepciones;

public class UsuarioInexistenteException extends Exception {
    private String userName;

    public UsuarioInexistenteException(String mensajito) {
        super(mensajito);

    }


}
