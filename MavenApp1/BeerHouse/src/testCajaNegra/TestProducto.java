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
import excepciones.MuchosProductosEnPromoException;
import excepciones.NoHayMesasHabilitadasException;
import excepciones.comandaInexistenteExeption;
import excepciones.costoInvalidoException;
import excepciones.precioVentaInvalidoException;
import excepciones.precioVentaMenorAlCostoException;

import static org.junit.Assert.*;

import modelo.Comanda;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Pedido;
import modelo.Producto;
import modelo.Recibo;
import negocio.BeerHouse;

public class TestProducto {
	private Producto productoCorrecto;

	@Before
	public void setUp(){
		productoCorrecto=null;
		try {
			productoCorrecto = new Producto(1,"Pochoclo",50,300,1000);
		} catch (precioVentaMenorAlCostoException e) {
			Assert.fail("No deberia mostrar precioVentaMenorAlCostoExceptio");
		} catch (precioVentaInvalidoException e) {
			Assert.fail("No deberia mostrar precioVentaInvalidoException");
		} catch (costoInvalidoException e) {
			Assert.fail("No deberia mostrar costoInvalidoException");
		}
	}
    
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testConstructorExitoso() {
		int id = this.productoCorrecto.getId();
		String nombre = this.productoCorrecto.getNombre();
		double costo = this.productoCorrecto.getCosto();
		double venta = this.productoCorrecto.getVenta();
		double stock = this.productoCorrecto.getStock();
		
		Assert.assertEquals("El numero de ID no se cargo correctamente",1,id);
		Assert.assertEquals("El nombre no se cargo correctamente","Pochoclo",nombre);
		Assert.assertEquals("El costo no se cargo correctamente",50,costo);
		Assert.assertEquals("El precio de venta no se cargo correctamente",300,venta);
		Assert.assertEquals("El stock de venta no se cargo correctamente",1000,stock);

	}
	
	@Test
	public void testConstructorFallidoPrecioCompra() {
		 Producto producto;
		try {
			producto = new Producto(1,"Pochoclo",0,50,1000);
			int id = producto.getId();
			String nombre = producto.getNombre();
			double costo = producto.getCosto();
			double venta = producto.getVenta();
			double stock = producto.getStock();
		} catch (precioVentaMenorAlCostoException e) {
			Assert.fail("No deberia mostrar precioVentaMenorAlCostoException");
		} catch (precioVentaInvalidoException e) {
			Assert.fail("No deberia mostrar precioVentaInvalidoException");
		} catch (costoInvalidoException e) {
			System.out.println("todo ok");
		}
		
	}
	
	@Test
	public void testConstructorFallidoPrecioVenta() {
		 Producto producto;
		try {
			producto = new Producto(1,"Pochoclo",300,0,1000);
			int id = producto.getId();
			String nombre = producto.getNombre();
			double costo = producto.getCosto();
			double venta = producto.getVenta();
			double stock = producto.getStock();
		} catch (precioVentaMenorAlCostoException e) {
			Assert.fail("No deberia mostrar precioVentaMenorAlCostoException");
		} catch (precioVentaInvalidoException e) {
			System.out.println("todo ok");
		} catch (costoInvalidoException e) {
			Assert.fail("No deberia mostrar costoInvalidoException");
		}
		
	}
	
	@Test
	public void testConstructorFallidoVentaMenorAlCosto() {
		 Producto producto;
		try {
			producto = new Producto(1,"Pochoclo",300,50,1000);
			int id = producto.getId();
			String nombre = producto.getNombre();
			double costo = producto.getCosto();
			double venta = producto.getVenta();
			double stock = producto.getStock();
		} catch (precioVentaMenorAlCostoException e) {
			System.out.println("todo ok");
		} catch (precioVentaInvalidoException e) {
			Assert.fail("No deberia mostrar precioVentaInvalidoException");
		} catch (costoInvalidoException e) {
			Assert.fail("No deberia mostrar costoInvalidoException");
		}
		
	}
	
	@Test
	public void testSetcostoCorrecto() {
		try {
			productoCorrecto.setCosto(1);
		} catch (costoInvalidoException e) {
			Assert.fail("No deberia tirar costoInvalidoException");
		}
		
	}
	
	@Test
	public void testSetcostoIncorrecto() {
		try {
			productoCorrecto.setCosto(0);
			Assert.fail("No deberia poder setear");
		} catch (costoInvalidoException e) {
			System.out.println("todo ok");
		}
		
	}
	
	@Test
	public void testSetventaCorrecto() {
		try {
			productoCorrecto.setVenta(2);;
		} catch (precioVentaInvalidoException e) {
			Assert.fail("No deberia tirar costoInvalidoException");
		}
		
	}
	
	@Test
	public void testSetventaIncorrecto() {
		try {
			productoCorrecto.setVenta(0);
			Assert.fail("No deberia poder setear");
		} catch (precioVentaInvalidoException e) {
			System.out.println("todo ok");
		}
		
	}
	
}
