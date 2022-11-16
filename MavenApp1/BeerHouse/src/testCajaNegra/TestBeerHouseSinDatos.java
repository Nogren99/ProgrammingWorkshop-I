package testCajaNegra;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.EstadoInvalidoException;
import excepciones.HijosInvalidosException;
import excepciones.MesaNulaException;
import excepciones.MesaOcupadaException;
import excepciones.ComandaInexistenteException;
import modelo.Mesa;
import modelo.Mozo;
import negocio.BeerHouse;

public class TestBeerHouseSinDatos {
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
	public void cerrarMesaNull() {
		
		if(this.beerHouse.getMesa().isEmpty())
			try {
				beerHouse.cerrarMesa(null);
				Assert.fail("Deberia mostrar MesaNulaException");
			} catch (MesaNulaException e1) {
				System.out.println("todo ok");
			} catch (ComandaInexistenteException e1) {
				Assert.fail("No deberia mostrar comandaInexistenteExeption");
			}
	}

}
