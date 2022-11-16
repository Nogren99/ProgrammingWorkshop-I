package modelo;

import java.io.Serializable;

/**
 * @author Nico
 * <br>
 * Clase padre que representa a un producto en promoci�n. Posteriormente se determinar� mediante sus clases hijas qu� tipo de promoci�n se aplicar�.
 * <br>
 *
 */

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
