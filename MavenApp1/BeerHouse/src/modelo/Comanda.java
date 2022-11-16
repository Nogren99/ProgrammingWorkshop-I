package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Nico
 * <br>
 * Clase que representa la comanda de una mesa. Contiene una colecci\u00f3n de pedidos, la fecha actual y el estado.
 */

public class Comanda implements Serializable{
    private GregorianCalendar date;
    private ArrayList<Pedido> orden = new ArrayList<Pedido>();
    private String estado;
    
    public Comanda() {
    	super();
    }
    
    /**
	 * Constructor que genera la comanda
	 * @param estado
	 */
    
	public Comanda(String estado) {
		super();
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
		return "Comanda [date=" + date + ", orden=" + orden + ", estado=" + estado + "]";
	}
 
}
