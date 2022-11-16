package modelo;

import java.io.Serializable;

/**
 * @author Nico
 * <br>
 * Clase que representa un usuario administrador del sistema de cervecer�a 
 * <br>
 */

public class Admin extends Operario  {
	
	/**
	 * Crea el usuario Admin
	 * @param username
	 * @param password
	 * @param nyA
	 * @param activo
	 */
	
	public Admin(String username, String password, String nyA, boolean activo) {
		super(username, password, null, true);
		this.categoria=20;
	}

}
