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
    
    private BeerHouse() {
		
	}
    
    public static BeerHouse getInstancia() {
    	if (instancia==null)
    		instancia= new BeerHouse();
    	return instancia;	
    }
    
    public void agregaOperario(Operario operario) {
    	this.operario.add(operario);
    }
    
    

	public Usuario login(String username, String password) throws UsuarioInactivoException, UsuarioInexistenteException{
    	if (operario.isEmpty() && username.equals("ADMIN") && password.equals("ADMIN1234")) {
    		String nuevaPassword=JOptionPane.showInputDialog(null,"Ingrese nueva password");  
    		return new Admin(username,nuevaPassword);
    	} else {
    		int i=0;
    		while (i<operario.size() && !operario.get(i).getUsername().equals(username) && !operario.get(i).getPassword().equals(password)) {
    			//System.out.println("Analizando username "+ operario.get(i).getUsername() + "password "+ operario.get(i).getPassword());
    			i++;
    		}
	
    		System.out.println("Elemento:"+ i);
    		
    		if (i<operario.size()) { //se encontró usuario. verificar activo
    			if (operario.get(i).isActivo())
    				return operario.get(i);
    			else
    				throw new UsuarioInactivoException("Usuario iNativo");
    		} else  //no se encontro el usuario. lanzar excepcion (despues crearla)
    			throw new UsuarioInexistenteException("No existis");
    	}
    }
  
}
