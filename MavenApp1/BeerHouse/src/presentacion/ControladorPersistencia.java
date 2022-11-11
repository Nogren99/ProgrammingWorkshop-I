package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import negocio.BeerHouse;
import vista.IVista;
import vista.VentanaPersistir;


public class ControladorPersistencia implements ActionListener{
	private BeerHouse sistema = BeerHouse.getInstancia();
	private IVista vista;
	public ControladorPersistencia() {
		this.vista = new VentanaPersistir();
		this.vista.setActionListener(this);
		this.vista.mostrar();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		 if(comando.equalsIgnoreCase("Persistir")) {
			try {
				sistema.escribirPersistencia();
				this.vista.cerrar();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (comando.equalsIgnoreCase("LeerPersistencia")) {
			try {
				sistema.leerPersistencia();
				this.vista.cerrar();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	public void setVista(IVista vista) {
		this.vista = vista;
		this.vista.setActionListener(this);
		this.vista.mostrar();
	}

}