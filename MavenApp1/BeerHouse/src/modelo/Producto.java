package modelo;

import java.io.Serializable;

import excepciones.UsuarioInactivoException;
import excepciones.UsuarioInexistenteException;
import excepciones.costoInvalidoException;
import excepciones.precioVentaInvalidoException;
import excepciones.precioVentaMenorAlCostoException;



/**
 * @author Nico
 * <br>
 * Clase que representa un producto de la cervecería. Contiene un id, precio de costo y venta, su nombre y su stock actual.
 *
 */
public class Producto implements Serializable{
	private int Id;
    private String nombre;
    private double costo;
    private double venta;
    private int stock;
    
    public Producto() {
        super();
    }

    
    
    public int getId() {
		return Id;
	}



	public double getCosto() {
		return costo;
	}



	public double getVenta() {
		return venta;
	}



	public void setId(int id) {
		Id = id;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public void setCosto(double costo) throws costoInvalidoException {
		if(costo>0)
			this.costo = costo;
		else 
			throw new costoInvalidoException("Costo INVALIDO , debe ser mayor a 0");
	}



	public void setVenta(double venta) throws precioVentaInvalidoException {
		if(venta>0)
			this.venta = venta;
		else
			throw new precioVentaInvalidoException("Precio de venta INVALIDO, debe ser mayor a 0");
	}



	public void setStock(int stock) {
		this.stock = stock;
	}



	/**
     * F 4.1.1
     * <b>Post: </b> el precio de venta es menor al costo y ambos son mayores o iguales a 0<br>
     * @param id
     * @param nombre
     * @param costo
     * @param venta
     * @param stock
     * @throws precioVentaMenorAlCostoException
     * 
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
			if(venta<=0)
				throw new precioVentaInvalidoException("Precio de venta INVALIDO, debe ser mayor a 0");
			else
				if(costo<=0)
					throw new costoInvalidoException("Costo INVALIDO , debe ser mayor a 0");
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
