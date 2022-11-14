package modelo;

import java.io.Serializable;

public class Admin extends Operario  {

	public Admin(String username, String password, String nyA, boolean activo) {
		super(username, password, null, true);
		this.categoria=20;
	}
    
	public void darDeAlta(){}
	
}
