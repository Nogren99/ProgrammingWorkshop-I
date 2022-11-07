package negocio;

import modelo.Admin;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Producto;
import modelo.Usuario;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import excepciones.MesaRepetidaException;
import excepciones.NoMesasHabilitadasException;
import excepciones.NoMososActivosException;
import excepciones.UsuarioInactivoException;
import excepciones.UsuarioInexistenteException;

public class BeerHouse {

    private static BeerHouse instancia;
    private ArrayList<Mozo> mozos = new ArrayList<Mozo>();
    private ArrayList<Mesa> mesas = new ArrayList<Mesa>();
    private ArrayList<Operario> operarios = new ArrayList<Operario>();
    private ArrayList<Producto> productos = new ArrayList<Producto>();
    private double sueldo;

    private BeerHouse() {

    }

    public static BeerHouse getInstancia() {
        if (instancia == null)
            instancia = new BeerHouse();
        return instancia;
    }

    public void agregaOperario(Operario operario) {
        this.operarios.add(operario);
    }
    
    public Usuario login(String username, String password) throws UsuarioInactivoException, UsuarioInexistenteException{
        if (operarios.isEmpty() && username.equals("ADMIN") && password.equals("ADMIN1234")) {
            String nuevaPassword = JOptionPane.showInputDialog(null, "Ingrese nueva password");
            String nombreAdmin = JOptionPane.showInputDialog(null,"\u00bfQuien sos?");
            estaActivo(nombreAdmin);
            return new Admin(username, nuevaPassword,nombreAdmin,true);
        } else {
            int i = 0;
            while (i < operarios.size() && !operarios.get(i).getUsername().equals(username) && !operarios.get(i).getPassword().equals(password)) {
                //System.out.println("Analizando username "+ operario.get(i).getUsername() + "password "+ operario.get(i).getPassword());
                i++;
            }
            System.out.println("Elemento:" + i);
            if (i < operarios.size()) { //se encontr\u00f3 usuario. verificar activo
                if (operarios.get(i).isActivo())
                    return operarios.get(i);
                else
                    throw new UsuarioInactivoException("Usuario iNativo");
            } else //no se encontr\u00f3 el usuario. lanzar excepci\u00f3n (despues crearla)
                throw new UsuarioInexistenteException("No existis");
        }
    }

    private void estaActivo(String nombreAdmin) {
		// Buscar en el array de operarios , el nombre del admin para marcarlo como activo
    	if(operarios.contains(nombreAdmin)) {
    		operarios.get(operarios.indexOf(nombreAdmin)).setActivo(true);
    	}
		
	}
    
    public boolean mesasVacias() throws NoMesasHabilitadasException{
    	if(this.mesas.isEmpty())
    		throw new NoMesasHabilitadasException("No hay mesas habilitadas");
    	else
    		return false;
    }
    
    public boolean mososVacios() throws NoMososActivosException{
    	if(this.mozos.isEmpty())
    		throw new NoMososActivosException("No hay mosos activos");
    	else
    		return false;
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
            return this.mozos.get(i); //devuelvo mozo que luego modificar\u00e1 con alguna ventana MVC
        else
            return null;
    }

    public void agregarMesa(Mesa mesa) throws MesaRepetidaException{
    //Chequeamos que no sea vacia?
	//Chequeamos que sea positiva?
		if(this.mesas.contains(mesa))
	        	throw new MesaRepetidaException("El nro de mesa NO puede repetirse");
		else
			this.mesas.add(mesa);
    }

    public void eliminaMesa(Mesa mesa) {
        this.mesas.remove(mesa);
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
