package modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Comanda {

    private GregorianCalendar date;
    private Mesa mesa;
    ArrayList<Pedido> orden = new ArrayList<Pedido>();
    private String estado;

	public Comanda(GregorianCalendar date, Mesa mesa, String estado) {
		super();
		this.mesa = mesa;
		//this.date = date;
		this.estado = estado;
	}
    
    
}
