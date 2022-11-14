package modelo;

import java.io.Serializable;

import excepciones.UsuarioInactivoException;
import excepciones.UsuarioInexistenteException;



/**
 * @author Nico
 * <br>
 * Clase que representa a un usuario operario del sistema de cervecería.
 * <br>
 *
 */
public class Operario extends Usuario{
	
	private String NyA;
    private boolean activo;
    protected byte categoria;

    
    
    public Operario(String username, String password, String nyA, boolean activo) {
		super(username, password);
		NyA = nyA;
		this.activo = activo;
		this.categoria=10;
	}

    
    

	public String getNyA() {
		return NyA;
	}




	public void setNyA(String nyA) {
		NyA = nyA;
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




	@Override
	public String toString() {
		return "Operario "+ super.toString() +" [NyA=" + NyA + ", activo=" + activo + ", categoria=" + categoria + "]";
	}




	

	





/* 	@Override
	public String toString() {
		return "Operario [NyA=" + NyA + ", activo=" + activo + ", categoria=" + categoria + "]";
	} */

	
	
	
	
}
