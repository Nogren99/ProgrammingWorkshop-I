package testCajaNegra;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.CantComensalesException;

import static org.junit.Assert.*;

import modelo.Comanda;
import modelo.Mesa;
import modelo.Mozo;

public class testMesaInvalida {
	private Mesa mesa;
	
	@Before
	public void setUp(){
		mesa = null;
		try {
			 mesa = new Mesa (10,1,"libre");
			 Assert.fail("Se deberia tirar una excepcion");
		} catch (CantComensalesException e) {
		}
	}
		
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		int cantUso = this.mesa.getCantUso();
		Assert.assertNotEquals(0, cantUso);
	}
	
}
