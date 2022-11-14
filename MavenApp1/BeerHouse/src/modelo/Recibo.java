package modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;


/**
 * @author Nico
 * <br>
 * Clase que representa un recibo de la cervecería. Se generará durante el cierre de mesas. Contiene una colección de pedidos, una colección de promociones aplicadas, un precio total, la mesa en la que fue efectuado, la fecha del día y la forma de pago.
 * <br>
 */
public class Recibo {
    private GregorianCalendar fecha;
    private Mesa mesa;
    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    private ArrayList<Promocion> promociones = new ArrayList<Promocion>();
    private double total;
    private String formaDePago;

    public Recibo() {
        super();
    }

	/**
	 * ¿Cual recibo?
	 */
	public Recibo(GregorianCalendar fecha, Mesa mesa, ArrayList<Pedido> pedidos, ArrayList<Promocion> promociones,
			double total, String formaDePago){
		super();
		this.fecha = fecha;
		this.mesa = mesa;
		this.pedidos = pedidos;
		this.promociones = promociones;
		this.total = total;
		this.formaDePago = formaDePago;
	}

	public GregorianCalendar getFecha(){
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha){
		this.fecha = fecha;
	}

	public Mesa getMesa(){
		return mesa;
	}

	public void setMesa(Mesa mesa){
		this.mesa = mesa;
	}

	public ArrayList<Pedido> getPedidos(){
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos){
		this.pedidos = pedidos;
	}

	public ArrayList<Promocion> getPromociones(){
		return promociones;
	}

	public void setPromociones(ArrayList<Promocion> promociones){
		this.promociones = promociones;
	}

	public double getTotal(){
		return total;
	}

	public void setTotal(double total){
		this.total = total;
	}

	public String getFormaDePago(){
		return formaDePago;
	}

	public void setFormaDePago(String formaDePago){
		this.formaDePago = formaDePago;
	}
    
}
