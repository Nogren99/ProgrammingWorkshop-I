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




	/**
	 * Calcula el precio dependiendo del tipo de oferta
	 * @param cant
	 * @param promo
	 * @return
	 */
	public abstract double calculaPrecio(int cant,String promo);
}
