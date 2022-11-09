package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JOptionPane;

import modelo.Operario;
import negocio.BeerHouse;
import vista.IVista;
import vista.VentanaABM;
import vista.VentanaAdmin;
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
        	if (user.getCategoria()==20)      //es correcto esto? hay una mejor forma de diferenciar admin de operario?
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
        } else if (comando.equalsIgnoreCase("Estadísticas")) {
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
        				ventABM.getModeloLista().addElement(iterador.next());
    			}
        		ventABM.repaint();
        } else if (comando.equalsIgnoreCase("Mozos")) {
        		this.vista.cerrar();
        		this.setVista(new VentanaABM());
        } else if (comando.equalsIgnoreCase("Mesas")) {
        		this.vista.cerrar();
        		this.setVista(new VentanaABM());
        } else if (comando.equalsIgnoreCase("Productos en venta")) {
        		this.vista.cerrar();
        		this.setVista(new VentanaABM());
        } else if (comando.equalsIgnoreCase("Alta")) {
        		this.vista.cerrar();
        		String name=JOptionPane.showInputDialog(null,"Ingresa nombre y apellido del nuevo operario");   
        		String username=JOptionPane.showInputDialog(null,"Ingresa username del nuevo operario");
        		String pass=JOptionPane.showInputDialog(null,"Ingresa contraseña del nuevo operario");
        		int dialogResult = JOptionPane.showConfirmDialog(null, "¿Es activo?", "Escoger", JOptionPane.YES_NO_OPTION);
        		boolean activo=false;
        		if (dialogResult == JOptionPane.YES_OPTION)
        			activo=true;
        		
        		sistema.agregaOperario(new Operario(username,pass,name,activo));
        		this.setVista(new VistaLogin());
        		
        }

    }


}
