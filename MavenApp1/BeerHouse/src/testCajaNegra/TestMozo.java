package testCajaNegra;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import modelo.Mozo;

public class TestMozo {
	private Mozo mozo;
	
	@Before
	public void setUp(){
		mozo = null;
		try {
			 mozo = new Mozo ("Jose",new GregorianCalendar(), 2, 0);
			 mozo.setEstado((byte) 0);
		} catch (Exception e) {
			Assert.fail("El mozo se deberia haber creado correctamente");
		}
	}
    
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testConstructor() {
		String NyA = this.mozo.getNyA();
		int hijos = this.mozo.getHijos();
		byte estado = this.mozo.getEstado();
		
		Assert.assertEquals("El nombre y apellido no se cargo correctamente","Jose",NyA);
		Assert.assertEquals("La cantidad de hijos no se cargo correctamente",2,hijos);
		Assert.assertEquals("El estado no se cargo correctamente",0,estado);
	}
	
}
