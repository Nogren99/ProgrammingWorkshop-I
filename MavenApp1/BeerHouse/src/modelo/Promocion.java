package modelo;

import java.io.Serializable;

public abstract class Promocion implements Serializable {
	protected Producto producto;
	protected boolean activo;


	public Producto getProducto() {
		return producto;
	}


	public boolean isActivo() {
		return activo;
	}


	public abstract double calculaPrecio(int cant,String promo);
}
