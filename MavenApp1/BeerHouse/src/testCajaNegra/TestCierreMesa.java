package testCajaNegra;

import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.MesaNulaException;
import excepciones.SinPromoAsociadaException;
import excepciones.ComandaInexistenteException;
import modelo.Comanda;
import modelo.Mesa;
import modelo.Mozo;
import negocio.BeerHouse;

public class TestCierreMesa {
	private BeerHouse sistema = BeerHouse.getInstancia();
	private BeerHouse beerHouse;
	private BeerHouseEscenarioConDatos BHDatos = new BeerHouseEscenarioConDatos();
	
	@Before
	public void setUp(){
		this.BHDatos.setUp();
		this.beerHouse=this.BHDatos.getBeerHouse();
	}
	
	@After
	public void tearDown() throws Exception {
		BHDatos.tearDown();
	}
	
	@Test
	public void cerrarMesaCorrecta() {
		try {
			sistema.cerrarMesa(beerHouse.getMesa().get(1));
			System.out.println("Todo OK");
		} catch (MesaNulaException e) {
			Assert.fail("No deberia mostrar MesaNulaException");
			
		} catch (ComandaInexistenteException e) {
			Assert.fail("No deberia mostrar ComandaInexistenteException");
		}
	}
	

	
	@Test
	public void cerrarMesaSinComandaAsignada() {
		try {
			sistema.cerrarMesa(beerHouse.getMesa().get(0));
			Assert.fail("Deberia mostrar comandaInexistenteExeption");
		} catch (MesaNulaException e) {
			Assert.fail("No deberia mostrar MesaNulaException");
		} catch (ComandaInexistenteException e) {
			System.out.println("Todo OK");
		}
	}
	
	@Test
	public void grabaMesaCorrecta() {
		try {
			sistema.cerrarMesa(beerHouse.getMesa().get(1));
			Assert.assertEquals("La mesa asociada a la comanda deberia estar libre","Libre",beerHouse.getMesa().get(1).getEstado());
			System.out.println("Todo OK");
		} catch (MesaNulaException e) {
			Assert.fail("No deberia mostrar MesaNulaException");
			
		} catch (ComandaInexistenteException e) {
			Assert.fail("No deberia mostrar ComandaInexistenteException");
		}
	}
	
}


