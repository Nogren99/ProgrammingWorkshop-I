package modelo;

import excepciones.UsuarioInactivoException;
import excepciones.UsuarioInexistenteException;

public class Operario extends Usuario {
	
	private String NyA;
    private boolean activo;
    protected byte categoria;

    
    
    public Operario(String username, String password, String nyA, boolean activo) {
		super(username, password);
		NyA = nyA;
		this.activo = activo;
		this.categoria=10;
	}

    
    

	public byte getCategoria() {
		return categoria;
	}

	public void setActivo(boolean activo) {
		if (activo)
			this.activo = true;
		else
			this.activo=false;
	}


	public boolean isActivo() {

		return activo;
		
        
    }


	
	
	
}
