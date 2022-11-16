package modelo;

import java.io.Serializable;

import excepciones.UsuarioInactivoException;
import excepciones.UsuarioInexistenteException;


/**
 * @author Nico
 * <br>
 * Clase que representa a un usuario operario del sistema de cervecer�a.
 * <br>
 *
 */

public class Operario extends Usuario{
	private String NyA;
    private boolean activo;
    protected byte categoria;

    /**
	 * Crea a un operario
	 * @param username
	 * @param password
	 * @param nyA
	 * @param activo
	 */
    
    public Operario(String username, String password, String nyA, boolean activo) {
		super(username, password);
		NyA = nyA;
		this.activo = activo;
		this.categoria=10;
	}
    
    /**
	 * Devuelve el nombre y apellido del operario
	 * @return NyA
	 */
    
	public String getNyA() {
		return NyA;
	}

	public void setNyA(String nyA) {
		NyA = nyA;
	}

	/**
	 * Devuelve la categor\u00eda del operario
	 * @return activo
	 */
	
	public byte getCategoria() {
		return categoria;
	}

	public void setActivo(boolean activo) {
		if (activo)
			this.activo = true;
		else
			this.activo=false;
	}

	/**
	 * Devuelve si el operario est\u00e1 activo
	 * @return activo
	 */
	
	public boolean isActivo() {
		return activo;
    }

	@Override
	public String toString() {
		return "Operario "+ super.toString() +" [NyA=" + NyA + ", activo=" + activo + ", categoria=" + categoria + "]";
	}
	
}
