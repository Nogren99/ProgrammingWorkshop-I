package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Comanda implements Serializable{

    private GregorianCalendar date;
    private Mesa mesa;
    private ArrayList<Pedido> orden = new ArrayList<Pedido>();
    private String estado;
    
    public Comanda() {
    	super();
    }
    
	public Comanda(Mesa mesa, String estado) {
		super();
		this.mesa = mesa;
		this.estado = estado;
	}

	public void addPedido(Pedido pedido) {
		orden.add(pedido);
	}
	
	public ArrayList<Pedido> getOrden() {
		return orden;
	}

	public void setOrden(ArrayList<Pedido> orden) {
		this.orden = orden;
	}

	public GregorianCalendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

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
