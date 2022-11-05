package negocio;

import modelo.Admin;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Producto;
import modelo.Usuario;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import excepciones.UsuarioInactivoException;
import excepciones.UsuarioInexistenteException;

public class BeerHouse {

    private static BeerHouse instancia;
    private ArrayList<Mozo> mozos = new ArrayList<Mozo>();
    private ArrayList<Mesa> mesa = new ArrayList<Mesa>();
    private ArrayList<Operario> operario = new ArrayList<Operario>();
    private ArrayList<Producto> producto = new ArrayList<Producto>();
    private double sueldo;

    private BeerHouse() {

    }

    public static BeerHouse getInstancia() {
        if (instancia == null)
            instancia = new BeerHouse();
        return instancia;
    }

    public void agregaOperario(Operario operario) {
        this.operario.add(operario);
    }


    
    public Usuario login(String username, String password) throws UsuarioInactivoException,
                                                                  UsuarioInexistenteException {
        if (operario.isEmpty() && username.equals("ADMIN") && password.equals("ADMIN1234")) {
            String nuevaPassword = JOptionPane.showInputDialog(null, "Ingrese nueva password");
            String nombreAdmin = JOptionPane.showInputDialog(null,"¿Quien sos?");
            estaActivo(nombreAdmin);
            return new Admin(username, nuevaPassword,nombreAdmin,true);
        } else {
            int i = 0;
            while (i < operario.size() && !operario.get(i)
                                                   .getUsername()
                                                   .equals(username) && !operario.get(i)
                                                                                 .getPassword()
                                                                                 .equals(password)) {
                //System.out.println("Analizando username "+ operario.get(i).getUsername() + "password "+ operario.get(i).getPassword());
                i++;
            }

            System.out.println("Elemento:" + i);

            if (i < operario.size()) { //se encontró usuario. verificar activo
                if (operario.get(i).isActivo())
                    return operario.get(i);
                else
                    throw new UsuarioInactivoException("Usuario iNativo");
            } else //no se encontro el usuario. lanzar excepcion (despues crearla)
                throw new UsuarioInexistenteException("No existis");
        }
    }

    private void estaActivo(String nombreAdmin) {
		// Buscar en el array de operarios , el nombre del admin para marcarlo como activo
    	if(operario.contains(nombreAdmin)) {
    		operario.get(operario.indexOf(nombreAdmin)).setActivo(true);
    	}
		
	}

	public void agregarMozo(Mozo mozo) {
        this.mozos.add(mozo);
    }


    public void eliminaMozo(Mozo mozo) {
        this.mozos.remove(mozo);
    }

    public Mozo modificaMozo(Mozo mozo) {
        int i = 0;
        while (i < mozos.size() && !mozos.get(i).equals(mozo))
            i++;

        if (i < mozos.size())
            return this.mozos.get(i); //devuelvo mozo que luego modificaré con alguna ventana MVC
        else
            return null;
    }

    /**
     * F 1.1.1 && 1.1.2
     * @param hijos
     * @return
     */
    public double sueldo(int hijos) {
		if(hijos==0)
			return sueldo;
		else
			return sueldo+sueldo*hijos*0.05;
    }
    

}
