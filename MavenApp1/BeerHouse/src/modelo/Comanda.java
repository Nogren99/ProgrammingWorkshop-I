package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Comanda implements Serializable{

    private GregorianCalendar date;
    private Mesa mesa;
    private ArrayList<Pedido> orden = new ArrayList<Pedido>();
    private String estado;
    
    

	public Comanda() {
		super();
	}

	public Comanda(GregorianCalendar date, Mesa mesa, String estado) {
		super();
		try {
			//probar todo 6.1
			this.date = date;
			this.mesa = mesa;
			this.estado = estado;
		}catch (Exception e) {
			System.out.println("ERROR");
		}
		
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
	
	
    
	
    
}
