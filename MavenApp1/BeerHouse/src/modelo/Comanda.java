package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;



/**
 * @author Nico
 * <br>
 * Clase que representa la comanda de una mesa. Contiene una mesa, una colección de pedidos, la fecha actual y el estado.
 */
public class Comanda implements Serializable{

    private GregorianCalendar date;
    private Mesa mesa;
    private ArrayList<Pedido> orden = new ArrayList<Pedido>();
    private String estado;
    
    public Comanda() {
    	super();
    }
    /**
	 * Constructor que genera la comanda
	 * @param mesa
	 * @param estado
	 */
	public Comanda(Mesa mesa, String estado) {
		super();
		this.mesa = mesa;
		this.estado = estado;
	}

	/**
	 * Agrega un pedido a la comanda
	 * @param pedido
	 */
	public void addPedido(Pedido pedido) {
		orden.add(pedido);
	}
	
	/**
	 * Devuelve una lista de pedidos.
	 * @return orden
	 */
	public ArrayList<Pedido> getOrden() {
		return orden;
	}

	public void setOrden(ArrayList<Pedido> orden) {
		this.orden = orden;
	}

	/**
	 * Devuelve la fecha de la comanda.
	 * @return date
	 */
	public GregorianCalendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	/**
	 * Devuelve la mesa de la comanda.
	 * @return mesa
	 */
	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	/**
	 * Devuelve el estado de la comanda.
	 * @return estado
	 */
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Comanda [date="+ date.get(Calendar.DATE)+ " / " + date.get(Calendar.MONTH)+ " / " + date.get(Calendar.YEAR)+ ", mesa=" + mesa + ", orden=" + orden + ", estado=" + estado + "]";
	}
	 
}
