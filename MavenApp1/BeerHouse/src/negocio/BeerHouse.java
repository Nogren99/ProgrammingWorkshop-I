package negocio;

import java.io.IOException;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

import javax.swing.JOptionPane;

import org.junit.Assert;

import excepciones.CantComensalesException;
import excepciones.EstadoInvalidoException;
import excepciones.HijosInvalidosException;
import excepciones.MesaImposibleException;
import excepciones.MesaNulaException;
import excepciones.MesaOcupadaException;
import excepciones.MuchosProductosEnPromoException;
import excepciones.NoHayMesasHabilitadasException;
import excepciones.NoMozosActivosException;
import excepciones.PasswordInvalidaException;
import excepciones.ProductoAsociadoAComandaException;
import excepciones.SinPromoAsociadaException;
import excepciones.UsuarioInactivoException;
import excepciones.UsuarioInexistenteException;
import excepciones.ComandaInexistenteException;
import excepciones.CostoInvalidoException;
import excepciones.MesaRepetidaException;
import excepciones.PrecioVentaInvalidoException;
import modelo.Admin;
import modelo.Comanda;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Pedido;
import modelo.Producto;
import modelo.Promocion;
import modelo.Recibo;
import modelo.Usuario;
import persistencia.BeerHouseDTO;
import persistencia.IPersistencia;

import persistencia.PersistenciaBIN;
import vista.VentanaABM;

/**
 * @author Nico
 * Invariante de clase: Los atributos de tipo ArrayList mozos, mesa, operario, producto y promociones siempre serán distintos de null
 */


public class BeerHouse implements Serializable{

    private static BeerHouse instancia;
    private ArrayList<Mozo> mozos = new ArrayList<Mozo>();
    private ArrayList<Mesa> mesa = new ArrayList<Mesa>();
    private ArrayList<Operario> operario = new ArrayList<Operario>();
    private ArrayList<Producto> producto = new ArrayList<Producto>();
    private ArrayList<Promocion> promociones = new ArrayList<Promocion>();
    private double sueldo;
    
    public BeerHouse() {
    	this.verificaInvariante();
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
    
    /**
     * Método que da de alta un mozo. Recibe nombre, hijos y estado. Verifica que estado sea 1, 2 o 3 y los hijos sean mayor o igual a 0.
     * Lanza EstadoInvalidoException si el estado no es 1, 2 o 3. Lanza HijosInvalidosException si la cantidad de hijos es negativa.
     * <b>Pre: </b>numero es un entero.<br>
     * mozo distinto de null.<br>
     * efectuado la ronda de contrataciones.<br>
     * <b>Post: </b>el mozo es asignado a una mesa.<br>
     * @param numero.
     * @param mozo.
     * @throws EstadoInvalidoException 
     * @throws HijosInvalidosException 
     * @throws PasswordInvalidaException 
     * @throws MesaOcupadaException.
     */
    
    public Mozo altaMozo(String nombre, int hijos, int estado) throws EstadoInvalidoException, HijosInvalidosException {
    	Mozo mozo = null;
    	if(hijos>=0) {
    		if(estado==0 || estado==1 || estado ==2) {
                this.mozos.add(new Mozo(nombre, new GregorianCalendar(),hijos,estado));
    		}else 
    			throw new EstadoInvalidoException("El estado debe ser 1, 2 o 3");	
    	} else 
    		throw new HijosInvalidosException("No se puede tener hijos negativos");
    	this.verificaInvariante();
    	return mozo;
    }
    
/**
 * <b> Pre: </b> Username, pass, name distintos de null.  <br>
 * Método que da de alta a un operario. Verifica que la password sea válida. Lanza PasswordInvalidaException en caso contrario.
 * @param username
 * @param pass
 * @param name
 * @param activo
 * @return
 * @throws PasswordInvalidaException
 */
    
    public Operario altaOpe (String username, String pass, String name, boolean activo) throws PasswordInvalidaException {
    	Operario ope = null;
    	if(pass.length()>6 && pass.length()<12&& pass.matches(".*\\d+.*") && pass.chars().anyMatch(Character::isUpperCase) ) {
    		ope=new Operario(username,pass,name,activo);
    		this.operario.add(ope);
    	} else
    		throw new PasswordInvalidaException("Contraseï¿½a invalida.");
    	this.verificaInvariante();
    	return ope;
    }
    /**
<<<<<<< Updated upstream
     * numero es un entero
=======
     * Método que asigna un mozo a una mesa. Recibe un numero y un mozo, lanza MesaOcupadaException si el número ingresado por parámetro representa una mesa con estado ocupado.
     * <b> Pre: </b> numero es un entero
     * Mozo distinto de null
>>>>>>> Stashed changes
     * @param numero
     * @param mozo
     * @throws MesaOcupadaException
     */
    public void asignaMM(int numero,Mozo mozo) throws MesaOcupadaException {
    	boolean ok=true;
    	Assert.assertTrue(numero>0);
    	Assert.assertNotNull(mozo);
    	Iterator<Mesa> IteradorMesa = mesa.iterator();
    	while(IteradorMesa.hasNext() && ok ) { 
    		Mesa messa = IteradorMesa.next();
    		System.out.println(messa);
    		if (messa.getNumero()==numero) {	
        		messa.setMozo(mozo);
        		ok=false;
        	}
    	}
    	if (ok) {
    		throw new MesaOcupadaException("Ese numero no corresponde a una mesa");
    	}
    	this.verificaInvariante();
    }
    
    public void modificaIDProducto(Producto producto, int ID) {
    	producto.setId(ID);
    }
    
    public void modificaPrecioCosto(Producto producto, float precioCosto) {// hay inflacion ahre
    	try {
			producto.setCosto(precioCosto);
		} catch (CostoInvalidoException e) {
			e.printStackTrace();
		}
    }
    
    public void modificaPrecioVenta(Producto producto, float precioVenta) {
    	try {
			producto.setVenta(precioVenta);
		} catch (PrecioVentaInvalidoException e) {
			e.printStackTrace();
		}
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
    
    /**
     * Método que elimina un producto de la colección en caso de que sea posible. 
     * Verifica que no esté asociado a ninguna comanda.
     * Lanza ProductoAsociadoAComandaException si éste está asociado a la comanda de alguna mesa.
     * <b>Pre: </b> producto distinto de null <br>
     * @param producto
     * @throws ProductoAsociadoAComandaException
     */
    public void eliminaProducto(Producto producto)  throws ProductoAsociadoAComandaException{
    	boolean ok=true;
    	Iterator<Mesa> Iterador = mesa.iterator();
    	Assert.assertNotNull(producto);
    	//si en el arraylist mesa,hay una mesa que contiene una comanda, en la cual su arraylist contiene un pedido que tenga un producto igual al selccionado
		//se elimina
    	while(Iterador.hasNext() && ok) { //me fijo en cada mesa
    		Mesa m = Iterador.next();
    		System.out.println(m.toString());
    		Comanda comanda= m.getComanda();
    		if(comanda!=null) { //comanda de cada mesa
    			ArrayList<Pedido> pedidos= comanda.getOrden(); //pedidos de cada comanda
    			Iterator<Pedido> IteradorPed = pedidos.iterator();
    			while(IteradorPed.hasNext() && ok) {
    				Pedido p = IteradorPed.next();
    				if(pedidos!=null && p.getProducto()==producto ) { //producto del pedido	
            			ok=false;
            			throw new ProductoAsociadoAComandaException("No se puede eliminar el producto, pertenece a una comanda");
                    	}
            		}
    			}	
    	}
    	if(ok) {
    		this.producto.remove(producto);
    	}
    }
    
    public void agregaOperario(Operario operario) {
        this.operario.add(operario);
    }

    public ArrayList<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(ArrayList<Promocion> promociones) {
		this.promociones = promociones;
	}

    public void inicializaMesas() { //despues ver como manejamos esto
    	for (int i=2; i<20;i++) {
    		try {
				this.creaMesa(new Mesa(i,i+1,"libre"));
			} catch (CantComensalesException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
    
    /**
     * 
     * @param mesa
     */

    public void creaMesa(Mesa mesa) {
    	this.mesa.add(mesa);
    }
    
    
    
    /**
     * Método que agrega una mesa al sistema dado un número de mesa y cantidad de sillas. <br>
     * Verifica que el número de mesa no exista en el sistema y que la cantidad de comensales sea válida. <br>
     * Lanza MesaRepetidaException si la mesa ya existía. <br>
     * Lanza CantComensalesException si la cantidad de comensales es inválida. <br>
     * 
     * @param numero
     * @param sillas
     * @return
     * @throws MesaRepetidaException
     * @throws CantComensalesException
     */
    public Mesa agregaMesa(int numero,int sillas) throws MesaRepetidaException, CantComensalesException {
    	Mesa mesaNueva=null;
        Iterator<Mesa> Iterador = mesa.iterator();
        boolean existe=false;
        while(Iterador.hasNext() && !existe) { 
            Mesa m = Iterador.next();
            if(m.getNumero()==numero) {
            	existe=true;
            }
        }
        if(existe)
        	throw new MesaRepetidaException("Esa mesa ya existe!!");
        else{
        	try {
				mesaNueva = new Mesa(numero,sillas,"Libre");
				this.mesa.add(mesaNueva);
			} catch (CantComensalesException e) {
				throw new CantComensalesException(e.getMessage());
			}
        }
        this.verificaInvariante();
        return mesaNueva;
    }
    
    /**
     * Método que realiza el loguin de un usuario al sistema. 
     * Lanza una Exception en caso de que el usuario se encuentre inactivo, no exista o bien no haya operarios registrados en el sistema.
     *<b>Pre: </b>username no es vacio ni null<br>
     * password no es vacio ni null<br>
     * efectuado la ronda de contrataciones.<br>
     * <b>Post: </b> En el primer ingreso se debe recibir username="ADMIN" y password="1234".<br>
	 * el usuario ingresa al sistema correctamente <br>
     * en el primer ingreso del admin se cambia la password<br>
     * @param username
     * @param password
     * @return
     * @throws Exception 
     */
    public Usuario login(String username, String password) throws Exception{
    	//System.out.println("username: "+ username + " password: "+ password);
    	Assert.assertNotNull(password);
    	Assert.assertNotNull(username);
    	Assert.assertNotEquals("Password no puede ser vacia", "", password);
    	Assert.assertNotEquals("Username no puede ser vacio", "", username);
        if (operario.isEmpty() && username.equals("ADMIN") && password.equals("ADMIN1234")) {
            String nuevaPassword = JOptionPane.showInputDialog(null, "Ingrese nueva password");
            String nombreAdmin = JOptionPane.showInputDialog(null,"\u00bfQuien sos?");
            estaActivo(nombreAdmin);
            return new Admin(username, nuevaPassword,nombreAdmin,true);
        } else {
        	if (!operario.isEmpty()){
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
        	else
        		throw new Exception("Sin operarios");
        }
    }

    /**
     * Método que setea como activo a un operario dado su nombre.
     * @param nombreAdmin
     */
    
    private void estaActivo(String nombreAdmin) {
    	if(operario.contains(nombreAdmin)) {
    		operario.get(operario.indexOf(nombreAdmin)).setActivo(true);
    	}
	}
    
    /**
     * Método que verifica si hay mesas habilitadas
     * <b> Retorna false si hay mesas habilitadas. Lanza NoHayMesasHabilitadasException si la colección de mesas está vacía
     * @return
     * @throws NoHayMesasHabilitadasException
     */
    
    public boolean mesasVacias() throws NoHayMesasHabilitadasException{
    	if(this.mesa.isEmpty())
    		throw new NoHayMesasHabilitadasException("No hay mesas habilitadas");
    	else
    		return false;
    }
    
    
    /**
     * Método que verifica si hay mozos en el sistema
     * <b> Post: </b> Retorna false si hay mozos en el sistema. Lanza NoMozosActivosException si no hay mozos en el sistema.
     * @return
     * @throws NoMozosActivosException
     */
    public boolean mososVacios() throws NoMozosActivosException{
    	if(this.mozos.isEmpty())
    		throw new NoMozosActivosException("No hay mosos activos");
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
    
	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public static void setInstancia(BeerHouse instancia) {
		BeerHouse.instancia = instancia;
	}
	
	/**
	 * Método que asocia una mesa a una comanda. Verifica que exista en la colección del sistema.
	 * @param mesa
	 * @param comanda
	 */

	public void asociarComanda(Mesa mesa, Comanda comanda) {
        int i = 0;
        while (i < this.mesa.size() && !this.mesa.get(i).equals(mesa))
            i++;
        if (i < this.mesa.size()) {
            this.mesa.get(i).setComanda(comanda);
            this.mesa.get(i).setEstado("Ocupada");
        }
        this.verificaInvariante();
    }
    
	/**
	 * Método que retorna el volumen de venta mayor entre todos los mozos
	 * @return
	 */
	
	public double mayorVolumenDeVenta() {
		double max = 0.0;
		for (Mozo mozo : mozos)
			if (mozo.getVolumenDeVenta()>max)
				max=mozo.getVolumenDeVenta();
		this.verificaInvariante();
		return max;
    }
	
	/**
	 * Método que retorna el volumen de venta menor entre todos los mozos
	 * @return
	 */
	public double menorVolumenDeVenta() {
		double min = 999999.0;
		for (Mozo mozo : mozos)
			if (mozo.getVolumenDeVenta()<min)
				min=mozo.getVolumenDeVenta();
		this.verificaInvariante();
		return min;
    }
	
	/**
	 * Método que retorna el día actual de la semana
	 * <b> Post: </b> Retorna el día actual de la semana como String
	 * @return
	 */
	
	private String dayConverter() {
		LocalDate today = LocalDate.now();
    	DayOfWeek dayOfWeek = today.getDayOfWeek();
    	switch(dayOfWeek.getValue()) {
    	case 1:
    		return "Lunes";
    	case 2:
    		return "Martes";
    	case 3:
    		return "Miercoles";
    	case 4:
    		return "Jueves";
    	case 5:
    		return "Viernes";
    	case 6:
    		return "Sabado";
    	default:
    		return "Domingo";
    	}
	}
	
	/**
	 * <b>Pre: </b>Mozo distinto de null.<br>
     * <b>Post: </b>Devuelve el mozo con el mayor volumen de venta.<br>
	 * @return max
	 */
	public Mozo mozoMayorVolumen() { //verificar si no hay mosos?
		Assert.assertNotNull(mozos);
		Iterator<Mozo> iterador = this.mozos.iterator();
		Mozo max = null;
		double ventaMax=-1;
		while (iterador.hasNext()) {
			Mozo aux = iterador.next();
			if (aux.getVolumenDeVenta()>ventaMax) {
				ventaMax=aux.getVolumenDeVenta();
				max=aux;
			}
		}
		this.verificaInvariante();
		return max;
	}
	/**
	 * <b>Pre: </b>Mozo distinto de null.<br>
     * <b>Post: </b>Devuelve el mozo con el menor volumen de venta.<br>
	 * @return min
	 */
	public Mozo mozoMenorVolumen() { //verificar si no hay mosos?
		Iterator<Mozo> iterador = this.mozos.iterator();
		Mozo min = null;
		double ventaMin=99999;
		while (iterador.hasNext()) {
			Mozo aux = iterador.next();
			if (aux.getVolumenDeVenta()<ventaMin) {
				ventaMin=aux.getVolumenDeVenta();
				min=aux;
			}
		}
		this.verificaInvariante();
		return min;
	}
	
	/**
	 * *<b>Pre: </b>comanda distinta de null.<br>
     * mesa distinta de null.<br>
     * pedido distinto de null.<br>
     * <b>Post: </b>devuelve el precio total de la comanda.<br>
	 * @param mesa
	 * @return
	 */
	public double precioComanda(Mesa mesa)throws ComandaInexistenteException{
		double total = 0;
		if(mesa.getComanda()!=null) {
			ArrayList<Pedido> pedido = mesa.getComanda().getOrden();
			Iterator<Pedido> iterador = pedido.iterator();
			while(iterador.hasNext()) {
				Pedido p = iterador.next();
				//Iterator<Promocion> iteradorPromo = promociones.iterator();
				int i=0;
				while(i<promociones.size() && !promociones.get(i).getProducto().equals(p.getProducto()))
					i++;
				if(i<promociones.size()) {
					total+=promociones.get(i).calculaPrecio(p.getCantidad(), dayConverter());
				}else {
					total+=p.getCantidad()*p.getProducto().getVenta();
				}
			}
			this.verificaInvariante();
			return total;
		}else
			throw new ComandaInexistenteException("Mesa sin comanda asignada");

		
			
	}
	
	/**
     * <b>Post: </b>devuelve si un producto se encuentra en promo en la comanda.<br>
	 * @param comanda
	 * @return
	 */
	
	public boolean verificaPromo(Comanda comanda) {
		boolean search=true;
		if(comanda!=null) {
			ArrayList<Pedido> pedidos = comanda.getOrden();
			Iterator<Pedido> iteratorPedido  = pedidos.iterator(); //pedidos de la comanda de la mesa a evaluar
			while(iteratorPedido.hasNext() && search) {
				Pedido ped = iteratorPedido.next();
				Iterator<Promocion> promo = promociones.iterator();
		    	while(promo.hasNext() && search) {
		    		Promocion prom =promo.next();
		    		if(ped.getProducto()==prom.getProducto() && prom.isActivo()) { //si hay un producto en promocion y esta activo
		    			search=false;
		    		}
		    	}
			}
		}
		return search;
	}
	
	
	/**
	 * 
	 * <b>Pre:</b> Pedido distinto de null <br>
	 * Producto distinto de null <br>
	 * numeroMesa entero mayor o igual a 0<br>
	 * @param pedido
	 * @param producto
	 * @param numeroMesa
	 */
	public void agregaMesaComanda(Pedido pedido,int numeroMesa) throws MuchosProductosEnPromoException , MesaOcupadaException ,  MesaImposibleException, NoHayMesasHabilitadasException{
		boolean search=true;
		if(mesa.size()!=0) {
			Iterator<Mesa> IteradorMesa = mesa.iterator();
        	while(IteradorMesa.hasNext() && search) { 
                Mesa m = IteradorMesa.next();
                if(m.getNumero()==numeroMesa ) {
                	if(m.getMozo()!=null) {
                		if(m.getMozo().getEstado()==0 && m.getEstado().equalsIgnoreCase("libre")) { //la mesa asociada encuentra un mozo asociado y se fija q este activo	
                        	if(verificaPromo(m.getComanda())) {
                        		if(m.getComanda()==null) {
	                            	Comanda	comanda = new Comanda();
	                            	m.setComanda(comanda);
	                            	m.getComanda().setDate(new GregorianCalendar());
	                            	m.getComanda().setEstado("abierta");
                            	}
                            	m.getComanda().addPedido(pedido);
                            	actualizaStock(pedido.getProducto(), pedido.getCantidad());
                            	//JOptionPane.showMessageDialog(null, "Mesa: "+ m.getNumero() + "asignada con ï¿½xito");
                            	search=false;
                        	}else
                        		throw new MuchosProductosEnPromoException("No pueden haber dos o mas productos en promocion en la misma comanda");
                        }else
                        	throw new MesaOcupadaException(" Mesa ocupada");
                	}else
                    	throw new  MesaImposibleException("Imposible seleccionar esa mesa");
                }
        	}
    	}else {
    		throw new NoHayMesasHabilitadasException(" No hay mesas habilitadas");
    	}
	}
	/** <b> Pre: Recibe null o una mesa con estado "Ocupada" </b>
	 * <b> Post:</b> Cierra la mesa y carga sus datos estadï¿½sticos en caso de ser correcta o lanza excepciï¿½n si es mesa nula o comanda inexistente. 
	 * @param mesa
	 * 
	 * 
	 */
	
	public void cerrarMesa(Mesa mesa) throws MesaNulaException, ComandaInexistenteException{
		if(mesa!=null && mesa.getComanda()!=null) {
    		mesa.setEstado("Libre");

			try {
				mesa.addConsumoTotal(this.precioComanda(mesa));
				mesa.getMozo().setVolumenDeVenta( this.precioComanda(mesa) );
				mesa.addUso();
			} catch (ComandaInexistenteException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
    		
    	}else if (mesa==null)
    		throw new MesaNulaException("No seleccionaste ninguna mesa");
    	else
    		throw new ComandaInexistenteException("Esta mesa no tiene una comanda asignada");   			
	}
	
	/**
	 * <b>Pre: </b> Recibe una mesa no nula con una comanda no nula y un String correspondiente a una forma de pago del recibo.
	 * <b>Post: </b> Devuelve el recibo correspondiende a una mesa cerrada.
	 * @param mesa
	 * @param formaPago
	 * @return
	 */
	
	public Recibo generaRecibo (Mesa mesa, String formaPago) {
			Recibo r=null;
			try {
				r = new Recibo(new GregorianCalendar(), mesa, mesa.getComanda().getOrden(), null, this.precioComanda(mesa), null);
				r.setFormaDePago(formaPago);
			} catch (ComandaInexistenteException e) {
			}
			return r;
	}
	
	public void escribirPersistencia() throws IOException{ // catchear excepcion en el main
        BeerHouseDTO beerDTO = new BeerHouseDTO();
        beerDTO.setMesa(this.mesa);
        beerDTO.setMozos(this.mozos);
        beerDTO.setOperario(this.operario);
        beerDTO.setProducto(this.producto);
        beerDTO.setPromociones(this.promociones);
        IPersistencia persistencia = new PersistenciaBIN();
        persistencia.abrirOutput("Datos.bin");
        System.out.println("Creando archivo de escritura");
        persistencia.escribir(beerDTO);
        System.out.println("Datos grabados exitosamente");
        persistencia.cerrarOutput();
        System.out.println("Archivo cerrado");
        this.verificaInvariante();
    }
	
	public void leerPersistencia() throws ClassNotFoundException, IOException, Exception{
        IPersistencia persistencia = new PersistenciaBIN();
        persistencia.abrirInput("Datos.bin");
        System.out.println("Archivo abierto");
        BeerHouseDTO beerDTO = (BeerHouseDTO) persistencia.leer();
        System.out.println("Datos recuperados");
        persistencia.cerrarInput();
        System.out.println("Archivo cerrado");
        this.promociones=beerDTO.getPromociones();
        this.mesa=beerDTO.getMesa();
        this.mozos=beerDTO.getMozos();
        this.operario=beerDTO.getOperario();
        this.producto=beerDTO.getProducto();
        this.verificaInvariante();
    }
	
	private void verificaInvariante() {
		Assert.assertNotNull(mesa);
		Assert.assertNotNull(mozos);
		Assert.assertNotNull(operario);
		Assert.assertNotNull(producto);	
		Assert.assertNotNull(promociones);
	}
	
}
