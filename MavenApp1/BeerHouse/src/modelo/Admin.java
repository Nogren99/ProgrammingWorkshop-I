package modelo;

import java.io.Serializable;



/**
 * @author Nico
 * <br>
 * Clase que representa un usuario administrador del sistema de cervecerķa 
 * <br>
 */
public class Admin extends Operario  {

	public Admin(String username, String password, String nyA, boolean activo) {
		super(username, password, null, true);
		this.categoria=20;
	}
    

}
