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

    
    
    public void setId(int id) {
		Id = id;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public void setCosto(double costo) {
		this.costo = costo;
	}



	public void setVenta(double venta) {
		this.venta = venta;
	}



	public void setStock(int stock) {
		this.stock = stock;
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
		super(); //esto no va en la clase producto. deberia ir al agregar en beerhouse yo opino, o bien en la ventana
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

	public String getNombre() {
		return nombre;
	}

	

	public int getStock() {
		return stock;
	}



	@Override
	public String toString() {
		return  nombre + "     ["+"Id=" + Id +  ", costo=" + costo + ", venta=" + venta + ", stock="
				+ stock + "]";
	}
	
	
    

    
}
