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
import excepciones.ProductoAsociadoAComandaException;
import excepciones.CostoInvalidoException;
import excepciones.PrecioVentaInvalidoException;
import excepciones.PrecioVentaMenorAlCostoException;
import modelo.Pedido;
import modelo.Producto;
import negocio.BeerHouse;
import testCajaNegra.BeerHouseEscenarioSinDatos;

public class TestEliminaProductoConDatos {
	private BeerHouse beerHouse;
	private EscenarioBeerHouseConDatos BHConDatos = new EscenarioBeerHouseConDatos();
	
	
	@Before
	public void setUp() throws Exception {
		this.BHConDatos.setUp();
		this.beerHouse=this.BHConDatos.getBeerHouse();
	}

	@After
	public void tearDown() throws Exception {
		BHConDatos.tearDown();
	}
	
	

}
