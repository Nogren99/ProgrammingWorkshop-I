package testCajaNegra;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import modelo.Mozo;

public class testMozo {
	private Mozo mozo;
	
	@Before
	public void setUp(){
		mozo = null;
		try {
			 mozo = new Mozo ("Mirta",new GregorianCalendar(), 2, 0);
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
		GregorianCalendar date = this.mozo.getDate();
		int hijos = this.mozo.getHijos();
		byte estado = this.mozo.getEstado();
		double volumenDeVenta = this.mozo.getVolumenDeVenta();
		Assert.assertEquals("El nombre y apellido no se cargo correctamente","Mirta",NyA);
		Assert.assertEquals("El domicilio no se cargo correctamente","Marconi 2345",date);
		Assert.assertEquals("La cantidad de hijos no se cargo correctamente",2,hijos);
		Assert.assertEquals("El estado no se cargo correctamente",0,estado);
		//Assert.assertEquals("El volumen de venta no se cargo correctamente",0.0,volumenDeVenta);
	}
	
}
