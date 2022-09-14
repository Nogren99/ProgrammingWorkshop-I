package modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Recibo {
    
    private GregorianCalendar fecha;
    private Mesa mesa;
    ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    ArrayList<Promocion> promociones = new ArrayList<Promocion>();
    private double total;
    private String formaDePago;
    
    
    public Recibo() {
        super();
    }
}
