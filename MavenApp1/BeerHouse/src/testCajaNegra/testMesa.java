package testCajaNegra;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import modelo.Comanda;
import modelo.Mesa;
import modelo.Mozo;

public class testMesa {
	private Mesa mesa;
	
	@Before
	public void setUp(){
		mesa = null;
		try {
			 mesa = new Mesa (2,4,"libre");
		} catch (Exception e) {
			Assert.fail("La mesa se deberia haber creado correctamente");
		}
	}
    

    //private Mozo mozo;!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //private Comanda comanda;!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //private double consumoTotal;!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private int cantUso;
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		int numero = this.mesa.getNumero();
		int comensales = this.mesa.getComensales();
		String estado = this.mesa.getEstado();
		double consumoTotal = this.mesa.getConsumoTotal();
		int cantUso = this.mesa.getCantUso();
		
		Assert.assertEquals("El numero de mesa no se cargo correctamente",2,numero);
		Assert.assertEquals("La cantidad de comensales no se cargo correctamente",4,comensales);
		Assert.assertEquals("El estado no se cargo correctamente","libre",estado);
		Assert.assertEquals("El consumo total no se cargo correctamente",0,consumoTotal);
		Assert.assertEquals("El volumen de venta no se cargo correctamente",0,cantUso);
	}
	
}
