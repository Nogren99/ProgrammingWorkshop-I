package presentacion;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

import javax.swing.JOptionPane;

import excepciones.CantComensalesException;
import excepciones.EstadoInvalidoException;
import excepciones.HijosInvalidosException;
import excepciones.MesaImposibleException;
import excepciones.MesaNulaException;
import excepciones.MesaOcupadaException;
import excepciones.MuchosProductosEnPromoException;
import excepciones.NoHayMesasHabilitadasException;
import excepciones.PasswordInvalidaException;
import excepciones.ProductoAsociadoAComandaException;
import excepciones.SinPromosException;
import excepciones.ComandaInexistenteException;
import excepciones.CostoInvalidoException;
import excepciones.MesaRepetidaException;
import excepciones.PrecioVentaInvalidoException;
import excepciones.PrecioVentaMenorAlCostoException;
import excepciones.ProductoInexistenteException;
import excepciones.SinPromoAsociadaException;
import modelo.Comanda;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Pedido;
import modelo.Producto;
import modelo.ProductoOferta;
import modelo.Promocion;
import modelo.Recibo;
import modelo.TemporalOferta;
import negocio.BeerHouse;
import vista.IVista;
import vista.VentanaABM;
import vista.VentanaAdmin;
import vista.VentanaAsignacion;
import vista.VentanaAsignacionComanda;
import vista.VentanaCerrarMesa;
import vista.VentanaEstadisticas;
import vista.VentanaOperario;
import vista.VentanaPromocion;
import vista.VistaLogin;

public class Controlador implements ActionListener {
    private IVista vista;
    private Operario user;
    private BeerHouse sistema = BeerHouse.getInstancia();

    public Controlador() {
        this.vista = new VistaLogin();
        this.vista.setActionListener(this);
        this.vista.mostrar();
    }
    
    public IVista getVista()
	{
		return vista;
	}

	private void setVista(IVista vista) {
    	this.vista=vista;
    	this.vista.setActionListener(this);
    	this.vista.mostrar();
    }

    public Operario getUser()
	{
		return user;
	}

	public void setUser(Operario user)
	{
		this.user = user;
	}

	@Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        System.out.println("Comando: " + comando);
        if (comando.equalsIgnoreCase("Ingresar")) {
        	VistaLogin vistalogin = (VistaLogin) this.vista;
        	try {
                user = (Operario) sistema.login(vistalogin.getTextField().getText(),vistalogin.getPasswordField().getText());
                sistema.agregaOperario(user);
                System.out.println("LOGIN CORRECTO \n Username: "+ user.getUsername() + "password: "+ user.getPassword());
                this.vista.cerrar();
        	if (user.getCategoria()==20)      //es correcto esto? hay una mejor forma de diferenciar admin de operario? cambiar 20
        		this.setVista(new VentanaAdmin());
        	else
        		this.setVista(new VentanaOperario());
            } catch (Exception ex) {
            	 this.vista.cerrar();
            	 JOptionPane.showMessageDialog(null,"ERROR " + ex.getMessage()); 
            	 this.setVista(new VistaLogin());
            }  	
        }else if (comando.equalsIgnoreCase("Desloguearse")) { //para 6.1
        		 this.vista.cerrar();
        		 this.setVista(new VistaLogin());
        } else if (comando.equalsIgnoreCase("Estad\u00edsticas")) {
        		this.vista.cerrar();
        		this.setVista(new VentanaEstadisticas());
        		VentanaEstadisticas ventEstadisticas = (VentanaEstadisticas) this.vista;
        		ventEstadisticas.getLblMasVentas().setText("Mayor volumen de ventas: "+ sistema.mozoMayorVolumen().getNyA());
        		ventEstadisticas.getLblMasVentas().setText("Menor volumen de ventas: "+ sistema.mozoMenorVolumen().getNyA());
        		Iterator<Mozo> iterador = sistema.getMozos().iterator();
        		while (iterador.hasNext())	{
            		Mozo mozo = iterador.next();
            		ventEstadisticas.getModeloListaEmpleados().addElement(mozo);
        		}
        		Iterator<Mesa> iteradorMesa = sistema.getMesa().iterator();
        		while (iteradorMesa.hasNext()) {
        			Mesa mesa = iteradorMesa.next();
        			ventEstadisticas.getModeloListaMesas().addElement(mesa);  			
        		}
        	/*	boolean vacio=true;
        		ventEstadisticas.getBtnEmpleado().setEnabled(false);
        		 while (vacio) {
        			 vacio = ventEstadisticas.getListaEmpleados().isSelectionEmpty();		 
        		 }
        		 ventEstadisticas.getBtnEmpleado().setEnabled(true); */
        } else if (comando.equalsIgnoreCase("VerEmpleado")) {
        	VentanaEstadisticas ventEstadisticas = (VentanaEstadisticas) this.vista;
        	Mozo mozo = (Mozo) ventEstadisticas.getListaEmpleados().getSelectedValue();
        	if (mozo!=null)
        		JOptionPane.showMessageDialog(null, mozo.getNyA() +"\n"+ "Volumen de ventas: "+ mozo.getVolumenDeVenta()); 
        	else
        		JOptionPane.showMessageDialog(null, "Debes seleccionar un elemento de la lista");
        } else if (comando.equalsIgnoreCase("VerMesa")) {
        	VentanaEstadisticas ventEstadisticas = (VentanaEstadisticas) this.vista;
        	Mesa mesa = (Mesa) ventEstadisticas.getListaMesas().getSelectedValue();
        	if (mesa!=null)
        		JOptionPane.showMessageDialog(null, "Mesa numero "+ mesa.getNumero() +"\n"+ " Consumo total: "+ mesa.getConsumoTotal() +"\n"+ "Veces utilizada:"+ mesa.getCantUso() +"\n"+ "Promedio: "+ mesa.getConsumoTotal()/mesa.getCantUso());
        	else
        		JOptionPane.showMessageDialog(null, "Debes seleccionar un elemento de la lista");
        }       
        else if (comando.equalsIgnoreCase("Operarios")) {
        		this.vista.cerrar();
        		this.setVista(new VentanaABM());
        		VentanaABM ventABM = (VentanaABM) this.vista;
        		Iterator<Operario> iterador = sistema.getOperario().iterator();
        		while (iterador.hasNext()){
        			Operario ope = iterador.next();
        			if (ope.getCategoria()!=20)     //para que no salga el operario admin en la lista
        				ventABM.getModeloLista().addElement(ope);
    			}
        		ventABM.getBtnAlta().setActionCommand("AltaOpe");
        		ventABM.getBtnbaja().setActionCommand("BajaOpe");
        		ventABM.getBtnModif().setActionCommand("ModifOpe");
        		ventABM.repaint();
        } else if (comando.equalsIgnoreCase("Mozos")) {
        		this.vista.cerrar();
        		this.setVista(new VentanaABM());
        		VentanaABM ventABM = (VentanaABM) this.vista;
        		Iterator<Mozo> iterador = sistema.getMozos().iterator();
        		while (iterador.hasNext()){
        			Mozo mozo = iterador.next();
        			ventABM.getModeloLista().addElement(mozo);
    			}
        		ventABM.getBtnAlta().setActionCommand("AltaMozo");
        		ventABM.getBtnbaja().setActionCommand("BajaMozo");
        		ventABM.getBtnModif().setActionCommand("ModifMozo");
        		ventABM.repaint();	
        } else if (comando.equalsIgnoreCase("Mesas")) {
        		this.vista.cerrar();
        		this.setVista(new VentanaABM());
        		VentanaABM ventABM = (VentanaABM) this.vista;
        		Iterator<Mesa> iterador = sistema.getMesa().iterator();
        		while (iterador.hasNext()){
        			Mesa mesa = iterador.next();
        			ventABM.getModeloLista().addElement(mesa);
    			}
        		ventABM.getBtnAlta().setActionCommand("AltaMesa");
        		ventABM.getBtnbaja().setActionCommand("BajaMesa");
        		ventABM.getBtnModif().setActionCommand("ModifMesa");
        		ventABM.repaint();	
        } else if (comando.equalsIgnoreCase("Productos")) {
        		this.vista.cerrar();
        		this.setVista(new VentanaABM());
        		VentanaABM ventABM = (VentanaABM) this.vista;
        		Iterator<Producto> iterador = sistema.getProducto().iterator();
        		while (iterador.hasNext()){
        			Producto producto = iterador.next();
        			ventABM.getModeloLista().addElement(producto);
    			}
        		ventABM.getBtnAlta().setActionCommand("AltaProd");
        		ventABM.getBtnbaja().setActionCommand("BajaProd");
        		ventABM.getBtnModif().setActionCommand("ModifProd");
        		ventABM.repaint();
        } else if (comando.equalsIgnoreCase("AltaOpe")) {
        		String name=JOptionPane.showInputDialog(null,"Ingresa nombre y apellido del nuevo operario");   
        		String username=JOptionPane.showInputDialog(null,"Ingresa username del nuevo operario");
        		String pass=JOptionPane.showInputDialog(null,"Ingresa contrase\u00f1a del nuevo operario");
        			int dialogResult = JOptionPane.showConfirmDialog(null, "\u00bfEs activo?", "Escoger", JOptionPane.YES_NO_OPTION);
            		boolean activo=false;
            		if (dialogResult == JOptionPane.YES_OPTION)
            			activo=true;
            		Operario ope;
					try {
						ope = sistema.altaOpe(username, pass, username, activo);
						//this.setVista(new VentanaABM());
						VentanaABM ventABM = (VentanaABM) this.vista;
						ventABM.getModeloLista().addElement(ope);
						ventABM.getBtnAlta().setActionCommand("AltaOpe");
						ventABM.getBtnbaja().setActionCommand("BajaOpe");
						ventABM.getBtnModif().setActionCommand("ModifOpe");
						ventABM.repaint();	
					} catch (PasswordInvalidaException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
            		
        		//this.setVista(new VistaLogin());    		
        } else if (comando.equalsIgnoreCase("BajaOpe")) {
        	VentanaABM ventABM = (VentanaABM) this.vista;
        	Operario ope = (Operario) ventABM.getList().getSelectedValue();
        	if (ope!=null) {
        		System.out.println(ope.toString());
	        	sistema.eliminaOperario((Operario) ventABM.getList().getSelectedValue());
	        	ventABM.getModeloLista().removeElement(ventABM.getList().getSelectedValue());
        	}else 
        		JOptionPane.showMessageDialog(ventABM, "Debe seleccionar un operario de la lista");
        	ventABM.repaint();
        } else if (comando.equalsIgnoreCase("ModifOpe")) {
        	VentanaABM ventABM = (VentanaABM) this.vista;
        	Operario ope = (Operario) ventABM.getList().getSelectedValue();
        	if (ope!=null) {
        		System.out.println(ope.toString());
        	this.vista.cerrar();
        	String[] opcionesModificar = {"Username", "Password", "Estado","Nombre y Apellido"};
        	int i = JOptionPane.showOptionDialog(null, "\u00bfQu\u00e9 elemento deseas modificar?", "Clickea una opci\u00f3n", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesModificar, opcionesModificar[0])+1;
        	switch(i) {
        	case 1: 
        		String username=JOptionPane.showInputDialog(null,"Ingresa nuevo username del operario");
        		sistema.modificaUsernameOpe(ope, username);
        	break;
        	case 2:
        		String pass=JOptionPane.showInputDialog(null,"Ingresa nueva password del operario");
        		if(pass.length()>6 && pass.length()<12
        				&& pass.matches(".*\\d+.*") // contiene al menos un digito
        				&& pass.chars().anyMatch(Character::isUpperCase) //contiene al menos una mayuscula
        				) 
        			sistema.modificaPasswordOpe(ope, pass);
        		else
        			JOptionPane.showMessageDialog(null, "La contrase\u00f1a debe contener entre 6 y 12 caracteres. Con al menos 1 d\u00EDgito y 1 may\u00FAscula");
        	break;
        	case 3:
        		int dialogResult = JOptionPane.showConfirmDialog(null, "\u00bfEs activo?", "Escoger", JOptionPane.YES_NO_OPTION);
        		boolean activo=false;
        		if (dialogResult == JOptionPane.YES_OPTION)
        			activo=true;
        		sistema.modificaEstadoOpe(ope, activo);
        		break;
        	case 4:
        		String nya=JOptionPane.showInputDialog(null,"Ingresa nuevo nombre y apellido del operario");
        		sistema.modificaNombre(ope, nya);
        	}
        	this.setVista(new VentanaABM());
        	Iterator<Operario> iterador = sistema.getOperario().iterator();
        	ventABM = (VentanaABM) this.vista;
    		while (iterador.hasNext()){
    			Operario ope1 = iterador.next();
    			if (ope1.getCategoria()!=20)     //para que no salga el operario admin en la lista
    				ventABM.getModeloLista().addElement(ope1);
			}
    		ventABM.getBtnAlta().setActionCommand("AltaOpe");
    		ventABM.getBtnbaja().setActionCommand("BajaOpe");
    		ventABM.getBtnModif().setActionCommand("ModifOpe");
    		ventABM.repaint();
    		}
        	else
        		JOptionPane.showMessageDialog(ventABM, "Debe seleccionar un operario de la lista");
        } else if (comando.equalsIgnoreCase("AltaMozo")) {
        	
        	String name=JOptionPane.showInputDialog(null,"Ingresa nombre y apellido del nuevo mozo");  
        	int hijos = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa cantidad de bendiciones del nuevo mozo"));
        	int estado = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa estado del nuevo mozo"));
        	Mozo mozo;
			try {
				mozo = sistema.altaMozo(name, hijos, estado);
				VentanaABM ventABM = (VentanaABM) this.vista;       		
				ventABM.getModeloLista().addElement(mozo);
				ventABM.repaint();
			} catch (EstadoInvalidoException | HijosInvalidosException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
            		
        } else if (comando.equalsIgnoreCase("BajaMozo")){
        	VentanaABM ventABM = (VentanaABM) this.vista;
        	Mozo mozo = (Mozo) ventABM.getList().getSelectedValue();
        	if(mozo!=null) {
        		this.vista.cerrar();
        		sistema.eliminaMozo((Mozo) ventABM.getList().getSelectedValue());
            	ventABM.getModeloLista().removeElement(ventABM.getList().getSelectedValue());
            	ventABM.repaint();
        	}else {
        		JOptionPane.showMessageDialog(ventABM, "Debe seleccionar un mozo de la lista");
        	}
        } else if (comando.equalsIgnoreCase("ModifMozo")) {
        	VentanaABM ventABM = (VentanaABM) this.vista;
        	Mozo mozo = (Mozo) ventABM.getList().getSelectedValue();
        	if (mozo!=null) {
        	System.out.println(mozo.toString());
        	this.vista.cerrar();
        	String[] opcionesModificar = {"Nombre", "Cantidad de hijos", "Estado"};
        	int i = JOptionPane.showOptionDialog(null, "\u00bfQu\u00e9 elemento deseas modificar?", "Clickea una opci\u00f3n", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesModificar, opcionesModificar[0])+1;
        	switch(i) {
        	case 1: 
        		String name=JOptionPane.showInputDialog(null,"Ingresa nuevo nombre del mozo");
        		sistema.modificaNombreMozo(mozo, name);
        	break;
        	case 2:
        		int hijos= Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa cantidad de hijos"));
        		if(hijos>=0) {
        			sistema.modificaHijosMozo(mozo, hijos);
            	}else {
            		JOptionPane.showMessageDialog(null, "La cantidad de hijos debe ser >= 0");
            	}	
        	break;
        	case 3:
        		int estado= Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa estado"));
        		if(estado==0 || estado==1 || estado ==2)
        			sistema.modificaEstadoMozo(mozo, estado);
    			else
    				JOptionPane.showMessageDialog(null, "Estado Invalido (0=Activo ; 1=De franco ; 2 =Ausente)");
        		break; 
        }
        	this.setVista(new VentanaABM());
        	Iterator<Mozo> iterador = sistema.getMozos().iterator();
        	ventABM = (VentanaABM) this.vista;
    		while (iterador.hasNext())	{
	    		mozo = iterador.next();
	    		ventABM.getModeloLista().addElement(mozo);
			}
    		ventABM.getBtnAlta().setActionCommand("AltaMozo");
    		ventABM.getBtnbaja().setActionCommand("BajaMozo");
    		ventABM.getBtnModif().setActionCommand("ModifMozo");
    		ventABM.repaint();
    		}
        	else
        		JOptionPane.showMessageDialog(ventABM, "Debe seleccionar un mozo de la lista");
    } else if (comando.equalsIgnoreCase("AltaMesa")) {
    	int numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa numero de mesa"));
    	int sillas = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa cantidad de comensales"));
    	Mesa mesa=null;
    	try {
			mesa=sistema.agregaMesa(numero,sillas);
			VentanaABM ventABM = (VentanaABM) this.vista;
			ventABM.getModeloLista().addElement(mesa);
			ventABM.repaint();
		} catch (MesaRepetidaException | CantComensalesException e1) {
			JOptionPane.showMessageDialog(null,e1.getMessage());
		}
    } else if (comando.equalsIgnoreCase("BajaMesa")) {   	
    	VentanaABM ventABM = (VentanaABM) this.vista;
    	Mesa mesa = (Mesa) ventABM.getList().getSelectedValue();
    	if(mesa!=null) {
    		sistema.eliminaMesa((Mesa) ventABM.getList().getSelectedValue());
        	ventABM.getModeloLista().removeElement(ventABM.getList().getSelectedValue());
        	ventABM.repaint();
    	}else
    		JOptionPane.showMessageDialog(ventABM, "Debe seleccionar una mesa de la lista");
    } else if (comando.equalsIgnoreCase("ModifMesa")) {
    	VentanaABM ventABM = (VentanaABM) this.vista;
    	Mesa mesa = (Mesa) ventABM.getList().getSelectedValue();
    	if (mesa!=null) {
    	System.out.println(mesa.toString());
    	this.vista.cerrar();
    	String[] opcionesModificar = {"N\u00famero", "Cantidad de sillas", "Estado"}; //aca no puse asignar mozo porque eso lo hacen los operarios desde su ventana
    	int i = JOptionPane.showOptionDialog(null, "\u00bfQu\u00e9 elemento deseas modificar?", "Clickea una opci\u00f3n", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesModificar, opcionesModificar[0])+1;
    	switch(i) {
    	case 1: 
    		int numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa numero de mesa"));
    		ArrayList<Mesa> mesas= sistema.getMesa();
            Iterator<Mesa> Iterador = mesas.iterator();
            boolean existe=false;
            while(Iterador.hasNext()) { 
                Mesa m = Iterador.next();
                if(m.getNumero()==numero) {
                	existe=true;
                	JOptionPane.showMessageDialog(null,"�Esa mesa ya existe!");
                }
            }
            if(!existe) 
            	sistema.modificaNumeroMesa(mesa, numero);
    	break;
    	case 2:
    		int sillas= Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa cantidad de sillas"));
    		sistema.modificaSillasMesa(mesa, sillas);
    	break;
    	case 3:
    		String[] opciones = {"Libre", "Ocupada", "Inhabilitada"};
    		i = JOptionPane.showOptionDialog(null, "Nuevo estado:", "Clickea una opci\u00f3n", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0])+1;
    		String eleccion=null;
    		switch (i) {
    		case 1: eleccion="Libre";
    		break;
    		case 2: eleccion="Ocupada";
    		break;
    		case 3: eleccion="Inhabilitada";
    		break;
    		}
    		sistema.modificaEstadoMesa(mesa, eleccion);
    		break;      	    	
    }
    	this.setVista(new VentanaABM());
    	Iterator<Mesa> iterador = sistema.getMesa().iterator();
    	ventABM = (VentanaABM) this.vista;
		while (iterador.hasNext())	{
    		mesa= iterador.next();
    		ventABM.getModeloLista().addElement(mesa);
		}
		ventABM.getBtnAlta().setActionCommand("AltaMesa");
		ventABM.getBtnbaja().setActionCommand("BajaMesa");
		ventABM.getBtnModif().setActionCommand("ModifMesa");
		ventABM.repaint();
		}
    	else
    		JOptionPane.showMessageDialog(ventABM, "Debe seleccionar una mesa de la lista");
    } else if (comando.equalsIgnoreCase("AltaProd")) {
    	int ID = Integer.parseInt(JOptionPane.showInputDialog(null,"Numero de Id"));
    	boolean existe=false;
		ArrayList<Producto> productos= sistema.getProducto();
        Iterator<Producto> Iterador = productos.iterator();
        while(Iterador.hasNext()) { 
            Producto p = Iterador.next();
            if(p.getId()==ID) {
            	existe=true;
            	JOptionPane.showMessageDialog(null, "YA EXISTE ESE ID");
            }
        }
        if(!existe) {
        	String name= (JOptionPane.showInputDialog(null,"Ingresa nombre de producto"));
        	float precioCosto = Float.parseFloat(JOptionPane.showInputDialog(null,"Ingresa precio de costo"));
        	float precioVenta = Float.parseFloat(JOptionPane.showInputDialog(null,"Ingresa precio de venta"));
        	int stock = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa stock inicial"));
        	Producto producto=null;
    		try {
    			producto = new Producto(sistema.getProducto().size()+1,name,precioCosto,precioVenta,stock);
    			JOptionPane.showMessageDialog(null, "Producto agregado satisfactoriamente");
    		} catch (PrecioVentaMenorAlCostoException e1) {
    			JOptionPane.showMessageDialog(null, e1.getMessage());
    		} catch (PrecioVentaInvalidoException e1) {
    			JOptionPane.showMessageDialog(null, e1.getMessage());
    		} catch (CostoInvalidoException e1) {
    			JOptionPane.showMessageDialog(null, e1.getMessage());
    		}
        	sistema.agregaProducto(producto);
        	
        	VentanaABM ventABM = (VentanaABM) this.vista;
    		ventABM.getModeloLista().addElement(producto);
    		ventABM.repaint();	
        }	
    } else if (comando.equalsIgnoreCase("BajaProd")) {
    	VentanaABM ventABM = (VentanaABM) this.vista;
    	Producto producto = (Producto) ventABM.getList().getSelectedValue();
    	if (producto!=null) {
	    	try {
				sistema.eliminaProducto(producto);
				ventABM.getModeloLista().removeElement(ventABM.getList().getSelectedValue());
				ventABM.repaint();
			} catch (ProductoAsociadoAComandaException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}	
    	}else
    		JOptionPane.showMessageDialog(ventABM, "Debes seleccionar un producto de la lista");
    } else if (comando.equalsIgnoreCase("ModifProd")) {
    	VentanaABM ventABM = (VentanaABM) this.vista;
    	Producto producto = (Producto) ventABM.getList().getSelectedValue();
    	if(producto!=null) {
    	System.out.println(producto.toString());
    	this.vista.cerrar();
    	String[] opcionesModificar = {"ID", "Nombre", "Precio costo","Precio venta","Stock inicial"};
    	int i = JOptionPane.showOptionDialog(null, "\u00bfQu\u00e9 elemento deseas modificar?", "Clickea una opci\u00f3n", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesModificar, opcionesModificar[0])+1;
    	switch(i) {
    	case 1: 
    		int ID = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa numero de ID"));
    		boolean existe=false;
    		ArrayList<Producto> productos= sistema.getProducto();
            Iterator<Producto> Iterador = productos.iterator();
            while(Iterador.hasNext()) { 
                Producto p = Iterador.next();
                if(p.getStock()==ID) {
                	existe=true;
                	JOptionPane.showMessageDialog(null, "YA EXISTE ESE ID");
                }
            }
            if(!existe) {
            	sistema.modificaIDProducto(producto, ID);
            	JOptionPane.showMessageDialog(ventABM, "El ID ha sido actualizado satisfactoriamente");
            }
    	break;
    	case 2:
    		String name=JOptionPane.showInputDialog(null,"Ingresa nuevo nombre del producto");
    		sistema.modificaNombreProducto(producto, name);
    	break;
    	case 3:
    		float precioCosto=Float.parseFloat(JOptionPane.showInputDialog(null,"Ingresa nuevo precio de costo"));
    		sistema.modificaPrecioCosto(producto, precioCosto);
    		break; 
    	case 4:
    		float precioVenta=Float.parseFloat(JOptionPane.showInputDialog(null,"Ingresa nuevo precio de venta"));
    		sistema.modificaPrecioVenta(producto, precioVenta);
    		break;
    	case 5:
    		int stock=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa nuevo stock del producto"));
    		sistema.modificaStockProducto(producto, stock);
    		break;
    }
    	this.setVista(new VentanaABM());
    	Iterator<Producto> iterador = sistema.getProducto().iterator();
    	ventABM = (VentanaABM) this.vista;
		while (iterador.hasNext())	{
    		producto = iterador.next();
    		ventABM.getModeloLista().addElement(producto);
		}
		ventABM.getBtnAlta().setActionCommand("AltaProd");
		ventABM.getBtnbaja().setActionCommand("BajaProd");
		ventABM.getBtnModif().setActionCommand("ModifProd");
		ventABM.repaint();
    	}else
    		JOptionPane.showMessageDialog(ventABM, "Debe seleccionar un producto de la lista");
    } else if (comando.equalsIgnoreCase("AsignacionMM")) { //ASIGNAMM ------------------------------------
    	this.vista.cerrar();
    	this.setVista(new VentanaAsignacion());
    	VentanaAsignacion ventAsignacion = (VentanaAsignacion) this.vista;
    	Iterator<Mozo> iterador = sistema.getMozos().iterator();
    	while (iterador.hasNext()) {
    		ventAsignacion.getModeloLista().addElement(iterador.next());
    	}
    	ventAsignacion.repaint();
    } else if (comando.equalsIgnoreCase("AsignarMM")) {
        VentanaAsignacion ventAsignacion = (VentanaAsignacion) this.vista;
        Integer number = (Integer) ventAsignacion.getSpinner().getValue();
        int numero = number.intValue();
        if((Mozo) ventAsignacion.getList().getSelectedValue()!=null) {
            try {
                sistema.asignaMM(numero, (Mozo) ventAsignacion.getList().getSelectedValue());
                JOptionPane.showMessageDialog(null,"Mesa asignada con exito!");
            } catch (MesaOcupadaException e1) {
                JOptionPane.showMessageDialog(null,e1.getMessage());
            }
        }else
            JOptionPane.showMessageDialog(null,"Debes seleccionar un mozo valido de la lista");
    } else if (comando.equalsIgnoreCase("Atras")) {
    	this.vista.cerrar();
    	this.setVista(new VentanaAdmin());
    } else if (comando.equalsIgnoreCase("Salir")) {
    	this.vista.cerrar();
    	this.setVista(new VentanaOperario());
    } else if (comando.equalsIgnoreCase("AsignacionCM")) { //ASIGNAR COMANDA MESA
    	this.vista.cerrar();
    	this.setVista(new VentanaAsignacionComanda());
    	VentanaAsignacionComanda ventAsignacionComanda = (VentanaAsignacionComanda) this.vista;
    	Iterator<Producto> iterador = sistema.getProducto().iterator();
    	while (iterador.hasNext()) {
    		ventAsignacionComanda.getModeloLista().addElement(iterador.next());
    	}
    	ventAsignacionComanda.repaint();
    } else if (comando.equalsIgnoreCase("AgregarAComanda")) { // PRIMER BOTONCITO
    	VentanaAsignacionComanda ventAsignacionComanda = (VentanaAsignacionComanda) this.vista;
    	Producto producto =(Producto) ventAsignacionComanda.getList().getSelectedValue();
    	int cantidadProductos=(int) ventAsignacionComanda.getSpinner_1().getValue();
    	if(producto!=null) {
    		
    		if(cantidadProductos <= producto.getStock()) {
        		Pedido pedido = new Pedido(producto,cantidadProductos);
            	ventAsignacionComanda.getTextPane().setText(ventAsignacionComanda.getTextPane().getText()+"\n"+pedido.toString());
            	ventAsignacionComanda.repaint();	
            	int numeroMesa=(int) ventAsignacionComanda.getSpinner().getValue();
            	try {
					sistema.agregaMesaComanda(pedido,numeroMesa);
				} catch (MuchosProductosEnPromoException | MesaOcupadaException | MesaImposibleException
						| NoHayMesasHabilitadasException e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
    		}else
    			JOptionPane.showMessageDialog(null, "No hay suficiente stock");
        }else
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
    	
    	
    }else if (comando.equalsIgnoreCase("Promociones")) {
    	this.vista.cerrar();
    	this.setVista(new VentanaPromocion());
    	VentanaPromocion ventProm = (VentanaPromocion) this.vista;
		Iterator<Producto> iterador = sistema.getProducto().iterator();
		while (iterador.hasNext()){
			Producto producto = iterador.next();
			ventProm.getModeloLista_1().addElement(producto);
			ventProm.getModeloLista_2().addElement(producto);
			ventProm.repaint();
		}
		Iterator<Promocion> iteradorProm = sistema.getPromociones().iterator();
		while (iteradorProm.hasNext()){
			Promocion prom = iteradorProm.next();
			ventProm.getModeloLista().addElement(prom);
			ventProm.repaint();
		}
		
		
		
		
		ventProm.getBtnNuevaPromocion().setActionCommand("NuevaPromo");
		ventProm.getbtnNuevaOfertaTemp().setActionCommand("PromoTemp");
		ventProm.repaint();
    }else if (comando.equalsIgnoreCase("NuevaPromo")) {
    	VentanaPromocion ventProm = (VentanaPromocion) this.vista;
    	ArrayList<Promocion> promociones= sistema.getPromociones();
		boolean dosPorUno =ventProm.getRdbtnNewRadioButton().isSelected();
		boolean descuentoCantidad=ventProm.getRdbtnNewRadioButton_2().isSelected();
		String diaspromo=(String)ventProm.getSpinner_3().getValue(); 
		Producto temporal=(Producto) ventProm.getList_1().getSelectedValue(); 
		boolean activa =ventProm.getRdbtnNewRadioButton_4().isSelected();
		ProductoOferta prod;
			
		try {
			prod = new ProductoOferta((int)ventProm.getSpinner().getValue(), temporal, diaspromo, dosPorUno, descuentoCantidad,(int) ventProm.getSpinner_1().getValue(),(double)ventProm.getSpinner_2().getValue(), activa);
			promociones.add(prod);
		} catch (SinPromosException e1) {
			JOptionPane.showMessageDialog(null,e1.getMessage());
		} catch (ProductoInexistenteException e1) {
			JOptionPane.showMessageDialog(null,e1.getMessage());
		}

    }else if (comando.equalsIgnoreCase("PromoTemp")) {
    	VentanaPromocion ventProm = (VentanaPromocion) this.vista;
    	ArrayList<Promocion> promociones= sistema.getPromociones();
    	String diaspromo=(String)ventProm.getSpinner_3().getValue(); 
    	Producto producto =(Producto)ventProm.getList_2().getSelectedValue();
    	TemporalOferta prod = new TemporalOferta(producto,producto.getNombre(), ventProm.getTextField_1().getText(), diaspromo,(int)ventProm.getSpinner_4().getValue() , ventProm.getRdbtnNewRadioButton_6().isSelected(), ventProm.getRdbtnNewRadioButton_10().isSelected());
    	promociones.add(prod);
    	JOptionPane.showMessageDialog(null, "Oferta temporal agregada satisfactoriamente");
    }else if (comando.equalsIgnoreCase("Cerrar Mesa")) {
    	this.vista.cerrar();
    	this.setVista(new VentanaCerrarMesa());
    	VentanaCerrarMesa ventClose = (VentanaCerrarMesa) this.vista;
    	Iterator<Mesa> iterador = sistema.getMesa().iterator();
		while (iterador.hasNext()){
			Mesa mesa = iterador.next();
			if (mesa.getEstado().equalsIgnoreCase("Ocupada")) {
				ventClose.getModeloLista().addElement(mesa);
			}
		}
		ventClose.repaint();
    }else if (comando.equalsIgnoreCase("CerrarMesaSeleccionada")) {
    	VentanaCerrarMesa ventClose = (VentanaCerrarMesa) this.vista;
    	
    	try {
			sistema.cerrarMesa((Mesa) ventClose.getList().getSelectedValue());
			String[] opcionesPago = {"Efectivo", "Tarjeta", "Mercado Pago", "Cuenta DNI"};
			int i = JOptionPane.showOptionDialog(null, "\u00bfM\u00e9todo de pago?", "Clickea una opci\u00f3n", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesPago, opcionesPago[0])+1;
			JOptionPane.showMessageDialog(null, ((Recibo) sistema.generaRecibo((Mesa) ventClose.getList().getSelectedValue(), opcionesPago[i-1])).toString());		
			JOptionPane.showMessageDialog(null, "Mesa cerrada!");
			ventClose.repaint();
		} catch (MesaNulaException | ComandaInexistenteException | SinPromoAsociadaException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}

    	}
    }
}
