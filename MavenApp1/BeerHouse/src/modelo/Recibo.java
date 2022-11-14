package modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;

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
