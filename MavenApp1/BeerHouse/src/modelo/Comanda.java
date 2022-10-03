package modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Comanda {

    private GregorianCalendar date;
    private Mesa mesa;
    ArrayList<Pedido> orden = new ArrayList<Pedido>();
    private String estado;

    public Comanda() {
        super();
    }
}
