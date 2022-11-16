package testCajaNegra;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.MesaImposibleException;
import excepciones.MesaNulaException;
import excepciones.MesaOcupadaException;
import excepciones.SinPromoAsociadaException;
import excepciones.CantComensalesException;
import excepciones.ComandaInexistenteException;

import static org.junit.Assert.*;

import modelo.Comanda;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Pedido;
import modelo.Recibo;
import negocio.BeerHouse;

public class TestMesa {
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
	public void testConstructor() {
		int numero = this.mesa.getNumero();
		int comensales = this.mesa.getComensales();
		String estado = this.mesa.getEstado();
		double consumoTotal = this.mesa.getConsumoTotal();
		int cantUso = this.mesa.getCantUso();
		Assert.assertEquals("El numero de mesa no se cargo correctamente",2,numero);
		Assert.assertEquals("La cantidad de comensales no se cargo correctamente",4,comensales);
		Assert.assertEquals("El estado no se cargo correctamente","libre",estado);
		//Assert.assertEquals("El consumo total no se cargo correctamente",0,consumoTotal);
		Assert.assertEquals("El volumen de venta no se cargo correctamente",0,cantUso);
	}
	
	@Test
	public void testConstructorInvalido() {
		Mesa mesaInvalida;
		try {
			mesa = new Mesa(10,1,"libre");
			Assert.fail("No deberia poder crearse");
		} catch (CantComensalesException e) {
			System.out.println("todo ok");
		}
		
	}
	
	
	
	@Test
	public void testAsignaMM() {
		try {
			sistema.asignaMM(99, new Mozo("Mirta",new GregorianCalendar(), 2, 0));
			Assert.fail("Deberia tirar MesaOcupadaException. No debe poder agregarse a una mesa inexistente");
		} catch (MesaOcupadaException e) {	
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void precioComanda(){
		try {
			sistema.precioComanda(this.mesa);
			Assert.fail("Se deberia tirar comandaInexistenteExeption");
		} catch (ComandaInexistenteException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
