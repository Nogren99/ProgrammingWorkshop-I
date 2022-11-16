package testCajaNegra;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.EstadoInvalidoException;
import excepciones.HijosInvalidosException;
import excepciones.MesaOcupadaException;
import excepciones.comandaInexistenteExeption;
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
	public void asignaMMINCORRECTO() {
		try {
			beerHouse.asignaMM(beerHouse.getMesa().get(0).getNumero(),beerHouse.getMozos().get(0));
		} catch (MesaOcupadaException e) {
			Assert.fail("No deberia lanzar MesaOcupadaException");
		}
	}
	

	
	public void precioComanda() {
		try {
			beerHouse.precioComanda(beerHouse.getMesa().get(1));
		}catch (comandaInexistenteExeption e) {
			Assert.fail("No deberia lanzar comandaInexistenteExeption ");
		}
	}
	
	public void precioComandaInexistente() {
		try {
			beerHouse.precioComanda(beerHouse.getMesa().get(0));
			Assert.fail("No deberia poder realizarse");
		}catch (comandaInexistenteExeption e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	@Test
    public void altaMozo() {
    	try {
    		beerHouse.altaMozo("Jose", 2, 0);
    	}catch(EstadoInvalidoException e) {
    		Assert.fail("Deberia haber creado correctamente ");
    	}catch (HijosInvalidosException e) {
    		Assert.fail("Deberia haber creado correctamente ");
    	}
    }
	
	@Test
    public void altaMozoHijosInvalidos() {
    	try {
    		beerHouse.altaMozo("Jose", -1, 0);
    		Assert.fail("No deberia crearse ");
    	}catch(EstadoInvalidoException e) {
    		Assert.fail("Deberia haber creado correctamente ");
    	}catch (HijosInvalidosException e) {
    		System.out.println(e.getMessage());
    	}
    }
	
	@Test
    public void altaMozoEstadoInvalido() {
    	try {
    		beerHouse.altaMozo("Jose", 2, 999);
    		Assert.fail("No deberia crearse ");
    	}catch(EstadoInvalidoException e) {
    		System.out.println(e.getMessage());
    	}catch (HijosInvalidosException e) {
    		Assert.fail("Deberia haber creado correctamente ");
    	}
    }

}
