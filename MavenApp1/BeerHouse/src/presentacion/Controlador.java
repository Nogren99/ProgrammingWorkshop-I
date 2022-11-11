package presentacion;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import excepciones.MesaOcupadaException;
import excepciones.costoInvalidoException;
import excepciones.precioVentaInvalidoException;
import excepciones.precioVentaMenorAlCostoException;
import modelo.Comanda;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Pedido;
import modelo.Producto;
import negocio.BeerHouse;
import vista.IVista;
import vista.VentanaABM;
import vista.VentanaAdmin;
import vista.VentanaAsignacion;
import vista.VentanaAsignacionComanda;
import vista.VentanaEstadisticas;
import vista.VentanaOperario;
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
    
    private void setVista(IVista vista) {
    	this.vista=vista;
    	this.vista.setActionListener(this);
    	this.vista.mostrar();
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
        } else if (comando.equalsIgnoreCase("Operarios")) {
        		this.vista.cerrar();
        		this.setVista(new VentanaABM());
        		VentanaABM ventABM = (VentanaABM) this.vista;
        		Iterator<Operario> iterador = sistema.getOperario().iterator();
        		
        		while (iterador.hasNext())
    			{
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
        		
        		while (iterador.hasNext())
    			{
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
        		
        		while (iterador.hasNext())
    			{
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
        		
        		while (iterador.hasNext())
    			{
        			Producto producto = iterador.next();
        			ventABM.getModeloLista().addElement(producto);
    			}
        		ventABM.getBtnAlta().setActionCommand("AltaProd");
        		ventABM.getBtnbaja().setActionCommand("BajaProd");
        		ventABM.getBtnModif().setActionCommand("ModifProd");
        		
        		ventABM.repaint();
        		
        		
        } else if (comando.equalsIgnoreCase("AltaOpe")) {
        		this.vista.cerrar();
        		String name=JOptionPane.showInputDialog(null,"Ingresa nombre y apellido del nuevo operario");   
        		String username=JOptionPane.showInputDialog(null,"Ingresa username del nuevo operario");
        		String pass=JOptionPane.showInputDialog(null,"Ingresa contrase\u00f1a del nuevo operario");
        		if(pass.length()>6 && pass.length()<12
        				&& pass.matches(".*\\d+.*") // contiene al menos un digito
        				&& pass.chars().anyMatch(Character::isUpperCase) //contiene al menos una mayuscula
        				) {
        			
        			int dialogResult = JOptionPane.showConfirmDialog(null, "\u00bfEs activo?", "Escoger", JOptionPane.YES_NO_OPTION);
            		boolean activo=false;
            		if (dialogResult == JOptionPane.YES_OPTION)
            			activo=true;
            		
            		Operario ope = new Operario(username,pass,name,activo);
            		sistema.agregaOperario(ope);
            		this.setVista(new VentanaABM());
            		VentanaABM ventABM = (VentanaABM) this.vista;
            		ventABM.getModeloLista().addElement(ope);
            		
            		ventABM.getBtnAlta().setActionCommand("AltaOpe");
            		ventABM.getBtnbaja().setActionCommand("BajaOpe");
            		ventABM.getBtnModif().setActionCommand("ModifOpe");
            		ventABM.repaint();
            		
        			
        		}else {
        			JOptionPane.showMessageDialog(null, "La contrase\\u00f1a debe contener entre 6 y 12 caracteres. Con al menos 1 dígito y 1 mayúscula");
        			this.setVista(new VentanaABM());
            		VentanaABM ventABM = (VentanaABM) this.vista;
            		ventABM.getBtnAlta().setActionCommand("AltaOpe");
            		ventABM.getBtnbaja().setActionCommand("BajaOpe");
            		ventABM.getBtnModif().setActionCommand("ModifOpe");
            		ventABM.repaint();
        			
        		}
        		
        		
        		
        		//this.setVista(new VistaLogin());    		
        } else if (comando.equalsIgnoreCase("BajaOpe")) {
        	VentanaABM ventABM = (VentanaABM) this.vista;
        	sistema.eliminaOperario((Operario) ventABM.getList().getSelectedValue());
        	ventABM.getModeloLista().removeElement(ventABM.getList().getSelectedValue());
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
        			JOptionPane.showMessageDialog(null, "La contrase\\u00f1a debe contener entre 6 y 12 caracteres. Con al menos 1 dígito y 1 mayúscula");
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
        	
        	
    		while (iterador.hasNext())
			{
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
        	
        	if(hijos>=0) {
        		int edad = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa la edad del nuevo mozo"));
        		if(edad>18) {
        			int estado = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa estado del nuevo mozo"));
                	Mozo mozo = new Mozo(name,new GregorianCalendar(),hijos);
                	sistema.agregarMozo(mozo);
                	VentanaABM ventABM = (VentanaABM) this.vista;       		
            		ventABM.getModeloLista().addElement(mozo);
            		ventABM.repaint();
        		}else {
        			JOptionPane.showMessageDialog(null, "El mozo debe ser mayor de 18 años");
            		VentanaABM ventABM = (VentanaABM) this.vista;
            		ventABM.repaint();
        		}
        	}else {
        		JOptionPane.showMessageDialog(null, "La cantidad de bendis debe ser mayor o igual a ");
        		VentanaABM ventABM = (VentanaABM) this.vista;
        		ventABM.repaint();
        	}
        		
        } else if (comando.equalsIgnoreCase("BajaMozo")){
        	VentanaABM ventABM = (VentanaABM) this.vista;
        	sistema.eliminaMozo((Mozo) ventABM.getList().getSelectedValue());
        	ventABM.getModeloLista().removeElement(ventABM.getList().getSelectedValue());
        	ventABM.repaint();	
        	
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
        		sistema.modificaEstadoMozo(mozo, estado);
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
    	int numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa numero de mesa")); //verificar que no se repita, esto se los dejo a ustedes muchachos 
    	int sillas = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa cantidad de sillas"));
    	
    	Mesa mesa = new Mesa(numero,sillas,"Libre");
    	sistema.agregaMesa(mesa);
    	
    	VentanaABM ventABM = (VentanaABM) this.vista;
		ventABM.getModeloLista().addElement(mesa);
		ventABM.repaint();	
    } else if (comando.equalsIgnoreCase("BajaMesa")) {   	
    	VentanaABM ventABM = (VentanaABM) this.vista;
    	sistema.eliminaMesa((Mesa) ventABM.getList().getSelectedValue());
    	ventABM.getModeloLista().removeElement(ventABM.getList().getSelectedValue());
    	ventABM.repaint();
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
    	
    	int id = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa ID de producto")); //verificar que no se repita, esto se los dejo a ustedes muchachos 
    	String name= (JOptionPane.showInputDialog(null,"Ingresa nombre de producto"));
    	float precioCosto = Float.parseFloat(JOptionPane.showInputDialog(null,"Ingresa precio de costo"));
    	float precioVenta = Float.parseFloat(JOptionPane.showInputDialog(null,"Ingresa precio de venta"));
    	int stock = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa stock inicial"));
    	
    	Producto producto=null;
		try {
			producto = new Producto(id,name,precioCosto,precioVenta,stock);
		} catch (precioVentaMenorAlCostoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (precioVentaInvalidoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (costoInvalidoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	sistema.agregaProducto(producto);
    	
    	VentanaABM ventABM = (VentanaABM) this.vista;
		ventABM.getModeloLista().addElement(producto);
		ventABM.repaint();	
    	
    } else if (comando.equalsIgnoreCase("BajaProd")) {
    	VentanaABM ventABM = (VentanaABM) this.vista;
    	sistema.eliminaProducto((Producto) ventABM.getList().getSelectedValue());
    	ventABM.getModeloLista().removeElement(ventABM.getList().getSelectedValue());
    	ventABM.repaint();
    } else if (comando.equalsIgnoreCase("ModifProd")) {
    	VentanaABM ventABM = (VentanaABM) this.vista;
    	Producto producto = (Producto) ventABM.getList().getSelectedValue();
    	System.out.println(producto.toString());
    	this.vista.cerrar();
    	
    	String[] opcionesModificar = {"ID", "Nombre", "Precio costo","Precio venta","Stock inicial"};
    	int i = JOptionPane.showOptionDialog(null, "\u00bfQu\u00e9 elemento deseas modificar?", "Clickea una opci\u00f3n", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesModificar, opcionesModificar[0])+1;
    	switch(i) {
    	case 1: 
    		int id=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa nuevo ID del producto"));
    		sistema.modificaIDProducto(producto, id);
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
    	
    } else if (comando.equalsIgnoreCase("AsignacionMM")) {
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
    	try {
			sistema.asignaMM(sistema.getMesa().get(numero), (Mozo) ventAsignacion.getList().getSelectedValue()); //tambien hay que validar que no sea un valor invalido (negativos o numeros muy altos) pero lo hare con el jspinner en la ventana
			JOptionPane.showInputDialog(null,"¡Mesa asignada con éxito!");
		} catch (MesaOcupadaException e1) {
			JOptionPane.showInputDialog(null,e1.getMessage());
		}
    	
    	
    } else if (comando.equalsIgnoreCase("Atras")) {
    	this.vista.cerrar();
    	this.setVista(new VentanaAdmin());
    } else if (comando.equalsIgnoreCase("Salir")) {
    	this.vista.cerrar();
    	this.setVista(new VentanaOperario());
    } else if (comando.equalsIgnoreCase("AsignacionCM")) {
    	this.vista.cerrar();
    	this.setVista(new VentanaAsignacionComanda());
    	
    	VentanaAsignacionComanda ventAsignacionComanda = (VentanaAsignacionComanda) this.vista;
    	Iterator<Producto> iterador = sistema.getProducto().iterator();
    	
    	while (iterador.hasNext()) {
    		ventAsignacionComanda.getModeloLista().addElement(iterador.next());
    	}
    	
    	ventAsignacionComanda.repaint();
    } else if (comando.equalsIgnoreCase("AgregarAComanda")) {
    	VentanaAsignacionComanda ventAsignacionComanda = (VentanaAsignacionComanda) this.vista;
    	Comanda comanda = new Comanda();
    	Pedido pedido = new Pedido((Producto) ventAsignacionComanda.getList().getSelectedValue(),(int) ventAsignacionComanda.getSpinner_1().getValue());
    	
    	sistema.actualizaStock(pedido.getProducto(), pedido.getCantidad());
    	ventAsignacionComanda.repaint();
    	
    	comanda.addPedido(pedido);
    	
    	
    	ventAsignacionComanda.getTextPane().setText(ventAsignacionComanda.getTextPane().getText()+"\n"+pedido.toString());
    }
    }
}



