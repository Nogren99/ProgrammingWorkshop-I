package modelo;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import java.util.GregorianCalendar;

public class Pedido {

    private Producto producto;
    private int cantidad;
    private GregorianCalendar date;

    public Pedido() {
        super();
        /*
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        */
    }
}
