package modelo;

import excepciones.UsuarioInactivoException;
import excepciones.UsuarioInexistenteException;
import excepciones.costoInvalidoException;
import excepciones.precioVentaInvalidoException;
import excepciones.precioVentaMenorAlCostoException;

public class Producto {
	private int Id;
    private String nombre;
    private double costo;
    private double venta;
    private int stock;
    
    public Producto() {
        super();
    }

    /**
     * F 4.1.1
     * @param id
     * @param nombre
     * @param costo
     * @param venta
     * @param stock
     * @throws precioVentaMenorAlCostoException
     */
	public Producto(int id, String nombre, double costo, double venta, int stock) throws precioVentaMenorAlCostoException , precioVentaInvalidoException, costoInvalidoException{
		super();
		if(venta>costo && venta>0 && costo>0) {
			Id = id;
			this.nombre = nombre;
			this.costo = costo;
			this.venta = venta;
			this.stock = stock;
		}else {
			if(venta<0)
				throw new precioVentaInvalidoException("Precio de venta INVALIDO");
			else
				if(costo<0)
					throw new costoInvalidoException("costo INVALIDO");
				else 
					if (venta<costo)
						throw new precioVentaMenorAlCostoException("Precio de venta menor al costo");
		}
		
	}
    

    
}
