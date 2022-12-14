package modelo;

import java.io.Serializable;

/**
 * @author Nico
 * <br>
 * Clase que representa un usuario del sistema de la cervecer�a. Contiene nombre de usuario y contrase�a. 
 * <br>
 *
 */

public abstract class Usuario implements Serializable{
    private String username;
    private String password;

    public Usuario(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [username=" + username + ", password=" + password + "]";
	}

}
