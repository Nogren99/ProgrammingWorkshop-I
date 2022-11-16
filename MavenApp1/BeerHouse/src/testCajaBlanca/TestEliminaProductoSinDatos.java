package testCajaBlanca;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.ProductoAsociadoAComandaException;
import modelo.Producto;
import negocio.BeerHouse;
import testCajaNegra.BeerHouseEscenarioSinDatos;

public class TestEliminaProductoSinDatos {

	private BeerHouse beerHouse;
	private BeerHouseEscenarioSinDatos BHSinDatos = new BeerHouseEscenarioSinDatos();
	
	
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
		 try {
			beerHouse.eliminaProducto(new Producto());
		} catch (ProductoAsociadoAComandaException e) {
			Assert.fail();
		}
	        
	 }

}
