package modelo;

import java.io.Serializable;

public abstract class Promocion implements Serializable {
	protected Producto producto;


	public Producto getProducto() {
		return producto;
	}


	public abstract double calculaPrecio(int cant,String promo);
}
