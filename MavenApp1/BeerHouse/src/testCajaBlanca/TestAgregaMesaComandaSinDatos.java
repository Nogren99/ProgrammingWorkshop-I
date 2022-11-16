package testCajaBlanca;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.MesaImposibleException;
import excepciones.MesaOcupadaException;
import excepciones.MuchosProductosEnPromoException;
import excepciones.NoHayMesasHabilitadasException;
import excepciones.CostoInvalidoException;
import excepciones.PrecioVentaInvalidoException;
import excepciones.PrecioVentaMenorAlCostoException;
import modelo.Pedido;
import modelo.Producto;
import negocio.BeerHouse;
import testCajaNegra.BeerHouseEscenarioSinDatos;

public class TestAgregaMesaComandaSinDatos {
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
	 public void Camino_1() {
	       
				try {
					beerHouse.agregaMesaComanda(new Pedido(new Producto(1,"Manzana",30,100,50),3), 5);
					Assert.fail("No deberia ejecutarse sin lanzar excepciones");
				} catch (MuchosProductosEnPromoException e) {
					Assert.fail("No deberia lanzar MuchosProductosEnPromoException");
				} catch (MesaOcupadaException e) {
					Assert.fail("No deberia lanzar MesaOcupadaException");
				} catch (MesaImposibleException e) {
					Assert.fail("No deberia lanzar MesaImposibleException");
				} catch (NoHayMesasHabilitadasException e) {
					System.out.println("bien");
				} catch (PrecioVentaMenorAlCostoException e) {
					Assert.fail("No deberia lanzar PrecioVentaMenorAlCostoException");
				} catch (PrecioVentaInvalidoException e) {
					Assert.fail("No deberia lanzar PrecioVentaInvalidoException");
				} catch (CostoInvalidoException e) {
					Assert.fail("No deberia lanzar CostoInvalidoException");
				}
				
		
	 }


}
