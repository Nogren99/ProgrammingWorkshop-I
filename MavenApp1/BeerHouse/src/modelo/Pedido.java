package modelo;

import java.time.format.DateTimeFormatter;
import java.io.Serializable;
import java.time.LocalDateTime;

import java.util.GregorianCalendar;

/**
 * @author Nico
 * Clase que representa un pedido que se asociar� a una comanda. Contiene un producto y una cantidad.
 *
 */

public class Pedido implements Serializable{
    private Producto producto;
    private int cantidad;
    private GregorianCalendar date;
    
    public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public GregorianCalendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	public Pedido(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return  producto.getNombre() + ", cantidad=" + cantidad + "]";
	}
	
	public Pedido() {
        super();
    }
	
}
