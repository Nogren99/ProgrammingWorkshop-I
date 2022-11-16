package testCajaBlanca;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.CostoInvalidoException;
import excepciones.PrecioVentaInvalidoException;
import excepciones.PrecioVentaMenorAlCostoException;
import excepciones.ProductoAsociadoAComandaException;
import modelo.Producto;
import negocio.BeerHouse;
import testCajaNegra.BeerHouseEscenarioSinDatos;

public class TestEliminaProductoSinDatos {

	private BeerHouse beerHouse;
	private BeerHouseEscenarioSinDatos BHSinDatos = new BeerHouseEscenarioSinDatos();
	private Producto producto;
	
	@Before
	public void setUp() throws Exception {
		this.BHSinDatos.setUp();
		this.beerHouse=this.BHSinDatos.getBeerHouse();
	}

	@After
	public void tearDown() throws Exception {
		BHSinDatos.tearDown();
	}

	 @Test
	 public void Camino_2() {
		 this.addProducto();
		 try {
			beerHouse.eliminaProducto(this.producto);
		} catch (ProductoAsociadoAComandaException e) {
			Assert.fail("No deberia lanzar ProductoAsociadoAComandaException");
		}
	        
	 }
	 
	//metodo que se invocara previo a cada test pues es precondicion que el producto exista
		//no lo hago en el setup porque con cada test lo estaré eliminando
		private void addProducto() {

				Producto producto;
				try {
					producto = new Producto(7,"Maiz",5,20,200);
					this.beerHouse.getProducto().add(producto);
					this.producto=producto;
				} catch (PrecioVentaMenorAlCostoException e) {
					Assert.fail("No deberia lanzar PrecioVentaMenorAlCostoException");
				} catch (PrecioVentaInvalidoException e) {
					Assert.fail("No deberia lanzar PrecioVentaInvalidoException");
				} catch (CostoInvalidoException e) {
					Assert.fail("No deberia lanzar CostoInvalidoException");
				}
				
			
		}

}
