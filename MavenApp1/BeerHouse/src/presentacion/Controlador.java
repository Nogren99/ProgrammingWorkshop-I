package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vistas.IVista;
import vistas.VistaLogin;

public class Controlador implements ActionListener{
	
	private IVista vista;
	
	public Controlador() {
		this.vista= new VistaLogin();
		this.vista.setActionListener(this);
		this.vista.mostrar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		System.out.println("Comando: "+ comando);
		
		if (comando.equalsIgnoreCase("Ingresar")) {
			System.out.println("Ingresando...");
			this.vista.cerrar();
		}
		
	}
	

}
