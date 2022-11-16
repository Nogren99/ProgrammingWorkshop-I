package testCajaNegra;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.EstadoInvalidoException;
import excepciones.HijosInvalidosException;
import excepciones.MesaOcupadaException;
import excepciones.ProductoAsociadoAComandaException;
import excepciones.comandaInexistenteExeption;
import modelo.Mozo;
import negocio.BeerHouse;

public class TestBeerHouse {
	
	private BeerHouse beerHouse;
	private BeerHouseEscenarioConDatos BHDatos = new BeerHouseEscenarioConDatos();

	@Before
	public void setUp() throws Exception {
		this.BHDatos.setUp();
		this.beerHouse=this.BHDatos.getBeerHouse();//nose
	}

	@After
	public void tearDown() throws Exception {
		BHDatos.tearDown();
	}

	//asginaMM
	
	@Test
	public void asignaMMcorrecto() {
		try {
			beerHouse.asignaMM( beerHouse.getMesa().get(0).getNumero(),beerHouse.getMozos().get(0));
		} catch (MesaOcupadaException e) {
			Assert.fail("No deberia lanzar MesaOcupadaException");
		}
	}
	
	@Test
	public void asignaMMMozoInvalido() {
		try {
			beerHouse.asignaMM( beerHouse.getMesa().get(0).getNumero(),null);
			Assert.fail("No deberia poder reaalizarse MesaOcupadaException");
		} catch (MesaOcupadaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void asignaMMNoCorrespondeAMesa() {
		try {
			beerHouse.asignaMM( 999,beerHouse.getMozos().get(0));
			Assert.fail("No deberia lanzar poder realizarse");
		} catch (MesaOcupadaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void asignaMMINCORRECTO() {
		try {
			beerHouse.asignaMM(2,null);
		} catch (MesaOcupadaException e) {
			Assert.fail("No deberia lanzar MesaOcupadaException");
		}
	}
	

	
	//precioComanda
	
	
	@Test
	public void precioComanda() {
		try {
			beerHouse.precioComanda(beerHouse.getMesa().get(1));
		}catch (comandaInexistenteExeption e) {
			Assert.fail("No deberia lanzar comandaInexistenteExeption ");
		}
	}
	
	@Test
	public void precioComandaInexistente() {
		try {
			beerHouse.precioComanda(beerHouse.getMesa().get(0));
			Assert.fail("No deberia poder realizarse");
		}catch (comandaInexistenteExeption e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	//altaMozo
	
	
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
	
	
	//eliminaProducto
	
	
	@Test
	public void eliminaProductoInvalido() {
		try {
			beerHouse.eliminaProducto(beerHouse.getProducto().get(0));
			Assert.fail("No deberia permitirse, producto en comanda");
		}catch(ProductoAsociadoAComandaException e) {
			Assert.fail("Todo ok");
		}
	}
	
	@Test
	public void eliminaProductoValido() {
		try {
			beerHouse.eliminaProducto(beerHouse.getProducto().get(1));
		}catch(ProductoAsociadoAComandaException e) {
			Assert.fail("No deberia tirar  ProductoAsociadoAComandaException");
		}
	}

}
