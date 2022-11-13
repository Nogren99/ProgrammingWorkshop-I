package modelo;

import java.io.Serializable;

public abstract class Promocion implements Serializable {
	
	
	public abstract double calculaPrecio(int cant,String promo);
}
