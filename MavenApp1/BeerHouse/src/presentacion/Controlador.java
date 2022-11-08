package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        } else if (comando.equalsIgnoreCase("Mozos")) {
        		this.vista.cerrar();
        		this.setVista(new VentanaABM());
        } else if (comando.equalsIgnoreCase("Mesas")) {
        		this.vista.cerrar();
        		this.setVista(new VentanaABM());
        } else if (comando.equalsIgnoreCase("Productos en venta")) {
        		this.vista.cerrar();
        		this.setVista(new VentanaABM());
        }

    }


}
