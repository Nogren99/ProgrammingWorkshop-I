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
			} catch (MuchosProductosEnPromoException | MesaOcupadaException | MesaImposibleException
					| NoHayMesasHabilitadasException | PrecioVentaMenorAlCostoException | PrecioVentaInvalidoException | CostoInvalidoException e) {
				Assert.fail();
			}
	 }


}
