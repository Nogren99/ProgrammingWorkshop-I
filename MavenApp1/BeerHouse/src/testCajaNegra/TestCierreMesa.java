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
import modelo.Mesa;
import modelo.Mozo;
import negocio.BeerHouse;

public class TestCierreMesa {
	private Mesa mesa;
	private BeerHouse sistema = BeerHouse.getInstancia();
	
	@Before
	public void setUp(){
		mesa = null;
		try {
			 mesa = new Mesa (2,4,"libre");
		} catch (Exception e) {
			Assert.fail("La mesa se deberia haber creado correctamente");
		}
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void cerrarMesaCorrecta(Mesa mesa) {
		try {
			sistema.cerrarMesa(this.mesa);
			System.out.println("Todo OK");
		} catch (MesaNulaException e) {
			Assert.fail("No deberia mostrar MesaNulaException");
			e.printStackTrace();
		} catch (ComandaInexistenteException e) {
			Assert.fail("No deberia mostrar MesaNulaException");
		}catch (SinPromoAsociadaException e) {
			Assert.fail("No deberia mostrar SinPromoAsociadaException");
		}
	}
	
	@Test
	public void cerrarMesaNull(Mesa mesa) {
		this.mesa.setEstado("Ocupada");
		try {
			sistema.cerrarMesa(this.mesa);
			Assert.fail("Deberia mostrar MesaNulaException");
		} catch (MesaNulaException e) {
			System.out.println("Todo OK");
		} catch (ComandaInexistenteException e) {
			Assert.fail("No deberia mostrar comandaInexistenteExeption");
		}catch (SinPromoAsociadaException e) {
			Assert.fail("No deberia mostrar SinPromoAsociadaException");
		}
	}
	
	@Test
	public void cerrarMesaSinComandaAsignada(Mesa mesa) {
		try {
			sistema.cerrarMesa(this.mesa);
			Assert.fail("Deberia mostrar comandaInexistenteExeption");
		} catch (MesaNulaException e) {
			Assert.fail("No deberia mostrar MesaNulaException");
		} catch (ComandaInexistenteException e) {
			System.out.println("Todo OK");
		}catch (SinPromoAsociadaException e) {
			Assert.fail("No deberia mostrar SinPromoAsociadaException");
		}
	}
	
	@Test
	public void grabaMesaCorrecta(Mesa mesa) {
		try {
			sistema.cerrarMesa(this.mesa);
			Assert.assertEquals("La mesa asociada a la comanda deberia estar libre","Libre",this.mesa.getEstado());
			System.out.println("Todo OK");
		} catch (MesaNulaException e) {
			Assert.fail("No deberia mostrar MesaNulaException");
			e.printStackTrace();
		} catch (ComandaInexistenteException e) {
			Assert.fail("No deberia mostrar MesaNulaException");
		}catch (SinPromoAsociadaException e) {
			Assert.fail("No deberia mostrar SinPromoAsociadaException");
		}
	}
	
}


