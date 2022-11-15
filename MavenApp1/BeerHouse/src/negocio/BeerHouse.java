package negocio;

import java.io.IOException;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

import javax.swing.JOptionPane;

import excepciones.CantComensalesException;
import excepciones.MesaImposibleException;
import excepciones.MesaNulaException;
import excepciones.MesaOcupadaException;
import excepciones.MuchosProductosEnPromoException;
import excepciones.NoHayMesasHabilitadasException;
import excepciones.NoMesasHabilitadasException;
import excepciones.NoMozosActivosException;
import excepciones.NumeroInvalidoException;
import excepciones.UsuarioInactivoException;
import excepciones.UsuarioInexistenteException;
import excepciones.comandaInexistenteExeption;
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

public class BeerHouse implements Serializable{

    private static BeerHouse instancia;
    private ArrayList<Mozo> mozos = new ArrayList<Mozo>();
    private ArrayList<Mesa> mesa = new ArrayList<Mesa>();
    private ArrayList<Operario> operario = new ArrayList<Operario>();
    private ArrayList<Producto> producto = new ArrayList<Producto>();
    private ArrayList<Promocion> promociones = new ArrayList<Promocion>();
    private double sueldo;
    
    private BeerHouse() {}

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
     * <b>Pre: </b>numero es un entero.<br>
     * mozo distinto de null.<br>
     * efectuado la ronda de contrataciones.<br>
     * <b>Post: </b>el mozo es asignado a una mesa.<br>
     * @param numero.
     * @param mozo.
     * @throws MesaOcupadaException.
     */
    public void asignaMM(int numero,Mozo mozo) throws MesaOcupadaException {
    	boolean ok=true;
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

    public ArrayList<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(ArrayList<Promocion> promociones) {
		this.promociones = promociones;
	}

    public void inicializaMesas() { //despues ver como manejamos esto
    	for (int i=2; i<20;i++) {
    		try {
				this.agregaMesa(new Mesa(i,i,"libre"));
			} catch (CantComensalesException e) {
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
    
    public void agregaMesa(Mesa mesa) {
    	this.mesa.add(mesa);
    }
    
    /**
     *<b>Pre: </b>username no es vacio ni null<br>
     * password no es vacio ni null<br>
     * efectuado la ronda de contrataciones.<br>
     * <b>Post: </b> En el primer ingreso se debe recibir username="ADMIN" y password="1234".<br>
	 * el usuario ingresa al sistema correctamente <br>
     * en el primer ingreso del admin se cambia la password<br>
     * @param username
     * @param password
     * @return
     * @throws UsuarioInactivoException
     * @throws UsuarioInexistenteException
     */
    public Usuario login(String username, String password) throws UsuarioInactivoException, UsuarioInexistenteException{
    	
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
            if (i < operario.size()) { //se encontró usuario. verificar activo
                if (operario.get(i).isActivo())
                    return operario.get(i);
                else
                    throw new UsuarioInactivoException("Usuario inactivo");
            } else 
                throw new UsuarioInexistenteException("Usuario inexistente");
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
	public double precioComanda(Mesa mesa)throws comandaInexistenteExeption{
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
			return total;
		}else
			throw new comandaInexistenteExeption("Mesa sin comanda asignada");

		
			
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
	 * @throws NumeroInvalidoException ,MuchosProductosEnPromoException , MesaOcupadaException ,  MesaImposibleException, NoHayMesasHabilitadasException
	 */
	public void agregaMesaComanda(Pedido pedido,Producto producto,int numeroMesa) throws MuchosProductosEnPromoException , MesaOcupadaException ,  MesaImposibleException, NoHayMesasHabilitadasException, NumeroInvalidoException{
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
                            	JOptionPane.showMessageDialog(null, "Mesa: "+ m.getNumero() + "asignada con éxito");
                            	search=false;
                        	}else
                        		throw new MuchosProductosEnPromoException("No pueden haber dos o mas productos en promocion en la misma comanda");
                        }else
                        	throw new MesaOcupadaException(" Mesa ocupada");
                	}else
                    	throw new  MesaImposibleException("Imposible seleccionar esa mesa");
                }
        	}
        	if(search)
        		throw new NumeroInvalidoException("Ese numero no corresponde a una mesa habilitada"); 
    	}else {
    		throw new NoHayMesasHabilitadasException(" No hay mesas habilitadas");
    	}
	}
	/** <b> Pre: Recibe null o una mesa con estado "Ocupada" </b>
	 * <b> Post:</b> Cierra la mesa y carga sus datos estadísticos en caso de ser correcta o lanza excepción si es mesa nula o comanda inexistente. 
	 * @param mesa
	 * 
	 * 
	 */
	public void cerrarMesa(Mesa mesa) throws MesaNulaException, comandaInexistenteExeption{
		if(mesa!=null && mesa.getComanda()!=null) {
    		mesa.setEstado("Libre");
			mesa.addConsumoTotal(this.precioComanda(mesa));
			mesa.getMozo().setVolumenDeVenta( this.precioComanda(mesa) );
			mesa.addUso();
    	}else if (mesa==null)
    		throw new MesaNulaException("No seleccionaste ninguna mesa");
    	else
    		throw new comandaInexistenteExeption("Esta mesa no tiene una comanda asignada");
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
				
			} catch (comandaInexistenteExeption e) {
				//nunca entrará aquí por precondición
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
    }
	
}
