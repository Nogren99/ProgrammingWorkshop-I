package negocio;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import excepciones.CantComensalesException;
import excepciones.MesaOcupadaException;
import excepciones.NoMesasHabilitadasException;
import excepciones.NoMososActivosException;
import excepciones.UsuarioInactivoException;
import excepciones.UsuarioInexistenteException;
//zayrux 
import modelo.Admin;
import modelo.Comanda;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Producto;
import modelo.Promocion;
import modelo.Usuario;
import persistencia.IPersistencia;

import persistencia.PersistenciaBIN;

public class BeerHouse implements Serializable{

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
    
    public void actualizaStock(Producto producto, int cant) { //throws no hay suficiente stock
    	producto.setStock(producto.getStock()-cant);
    }
    
    public void asignaCM(Comanda comanda, Mesa mesa) {
    	mesa.setComanda(comanda); //despues validar y eso
    }

    public void asignaMM(Mesa mesa, Mozo mozo) throws MesaOcupadaException {
    	if (mesa.getEstado().equals("Libre")) {	
    		mesa.setMozo(mozo);
    		mesa.setEstado("Ocupada");
    	}
    	else
    		throw new MesaOcupadaException("Esta mesa no está libre!");
    }
    
    public void modificaIDProducto(Producto producto, int ID) {
    	producto.setId(ID);
    }
    
    public void modificaPrecioCosto(Producto producto, float precioCosto) {// hay inflacion ahre
    	producto.setCosto(precioCosto);
    }
    
    public void modificaPrecioVenta(Producto producto, float precioVenta) {
    	producto.setVenta(precioVenta);
    }
    
    public void modificaNombreProducto(Producto producto, String nombre) {
    	producto.setNombre(nombre);
    }
    
    public void modificaStockProducto(Producto producto, int stock) {
    	producto.setStock(stock);
    }
    
    public void agregaProducto(Producto producto) {
    	this.producto.add(producto);
    }
    
    public void eliminaProducto(Producto producto) {
    	this.producto.remove(producto);
    }
    
    public void agregaOperario(Operario operario) {
        this.operario.add(operario);
    }

    public void inicializaMesas() { //despues ver como manejamos esto
    	for (int i=1; i<50;i++) {
    		//this.agregaMesa(new Mesa(i,3,"libre"));
    	}
    }
    
    public void modificaNumeroMesa(Mesa mesa,int numero) { //verificar que no exista ya. ver si lo validamos en el controlador o mandamos excepcion desde aca
    	mesa.setNumero(numero);
    }
    
    public void modificaSillasMesa(Mesa mesa, int sillas) {
    	mesa.setComensales(sillas);
    }
    
    public void modificaEstadoMesa(Mesa mesa, String estado) {
    	mesa.setEstado(estado);
    }
    
    public void eliminaMesa(Mesa mesa) {
    	this.mesa.remove(mesa);
    }
    
    public void agregaMesa(Mesa mesa) {
    	this.mesa.add(mesa);
    }
    
    public Usuario login(String username, String password) throws UsuarioInactivoException, UsuarioInexistenteException{
    	//System.out.println("username: "+ username + " password: "+ password);
        if (operario.isEmpty() && username.equals("ADMIN") && password.equals("ADMIN1234")) {
            String nuevaPassword = JOptionPane.showInputDialog(null, "Ingrese nueva password");
            String nombreAdmin = JOptionPane.showInputDialog(null,"\u00bfQuien sos?");
            estaActivo(nombreAdmin);
            return new Admin(username, nuevaPassword,nombreAdmin,true);
        } else {
            int i = 0;
            boolean flag = operario.get(i).getUsername().equals(username) && operario.get(i).getPassword().equals(password);
            while (i < operario.size() && !flag) {
                System.out.println("Analizando username "+ operario.get(i).getUsername() + "password "+ operario.get(i).getPassword());
                i++;
                if (i<operario.size())
                	flag = operario.get(i).getUsername().equals(username) && operario.get(i).getPassword().equals(password);
            }
            if (i < operario.size()) { //se encontr\u00f3 usuario. verificar activo
                if (operario.get(i).isActivo())
                    return operario.get(i);
                else
                    throw new UsuarioInactivoException("Usuario iNativo");
            } else //no se encontr\u00f3 el usuario. lanzar excepci\u00f3n (despues crearla)
                throw new UsuarioInexistenteException("No existis");
        }
    }

    private void estaActivo(String nombreAdmin) {
		// Buscar en el array de operarios , el nombre del admin para marcarlo como activo
    	if(operario.contains(nombreAdmin)) {
    		operario.get(operario.indexOf(nombreAdmin)).setActivo(true);
    	}
		
	}

    
    
    public boolean mesasVacias() throws NoMesasHabilitadasException{
    	if(this.mesa.isEmpty())
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

    public void modificaNombreMozo(Mozo mozo, String name) {
    	mozo.setNyA(name);
    }
    
    public void modificaHijosMozo(Mozo mozo,int hijos) {
    	mozo.setHijos(hijos);
    }
    
    public void modificaEstadoMozo(Mozo mozo, int estado) {
    	mozo.setEstado((byte) estado);
    }
    
    public void modificaUsernameOpe(Operario ope,String username) {
    	ope.setUsername(username);
    }
    
    public void modificaPasswordOpe(Operario ope,String password) {
    	ope.setPassword(password);
    }
    
    public void modificaEstadoOpe(Operario ope,boolean activo) {
    	ope.setActivo(activo);
    }
    
    public void modificaNombre(Operario ope, String name) {
    	ope.setNyA(name); 	
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

	public ArrayList<Operario> getOperario() {
		return operario;
	}

	
	
	public ArrayList<Mozo> getMozos() {
		return mozos;
	}

	public ArrayList<Mesa> getMesa() {
		return mesa;
	}

	public void eliminaOperario(Operario ope) {
		operario.remove(ope);
	}

	public ArrayList<Producto> getProducto() {
		return producto;
	}
    
	public void asociarComanda(Mesa mesa, Comanda comanda) {
        int i = 0;
        while (i < this.mesa.size() && !this.mesa.get(i).equals(mesa))
            i++;
        if (i < this.mesa.size()) {
            this.mesa.get(i).setComanda(comanda);
            this.mesa.get(i).setEstado("Ocupada");
        }
    }
    
	public double mayorVolumenDeVenta() {
		double max = 0.0;
		for (Mozo mozo : mozos)
			if (mozo.getVolumenDeVenta()>max)
				max=mozo.getVolumenDeVenta();
		return max;
    }
	
	public double menorVolumenDeVenta() {
		double min = 999999.0;
		for (Mozo mozo : mozos)
			if (mozo.getVolumenDeVenta()<min)
				min=mozo.getVolumenDeVenta();
		return min;
    }
	
	public void escribirPersistencia() throws IOException
	{ // catchear excepcion en el main
		IPersistencia persistencia = new PersistenciaBIN();
		persistencia.abrirOutput("Datos.bin");
		System.out.println("Creando archivo de escritura");
		persistencia.escribir(this);
		System.out.println("Datos grabados exitosamente");
		persistencia.cerrarOutput();
		System.out.println("Archivo cerrado");
	}
	
	
	
	public void leerPersistencia() throws ClassNotFoundException, IOException, Exception
	{
		IPersistencia persistencia = new PersistenciaBIN();
		persistencia.abrirInput("Datos.bin");
		System.out.println("Archivo abierto");
		BeerHouse auxiliar = (BeerHouse) persistencia.leer();
		System.out.println("Datos recuperados");
		persistencia.cerrarInput();
		System.out.println("Archivo cerrado");
		
		this.mesa=auxiliar.getMesa();
		this.mozos=auxiliar.getMozos();
		this.operario=auxiliar.getOperario();
		this.producto=auxiliar.getProducto();
	}
	

	
}
