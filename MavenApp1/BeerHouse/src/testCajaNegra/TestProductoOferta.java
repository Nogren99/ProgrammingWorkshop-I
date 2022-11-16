package testCajaNegra;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.SinPromosException;
import excepciones.costoInvalidoException;
import excepciones.precioVentaInvalidoException;
import excepciones.precioVentaMenorAlCostoException;
import excepciones.productoInexistenteException;
import modelo.Producto;
import modelo.ProductoOferta;

public class TestProductoOferta {
	private ProductoOferta productoOfertaCorrecto;

	@Before
	public void setUp() throws Exception {
		productoOfertaCorrecto=null;
		try {
			productoOfertaCorrecto= new ProductoOferta(1,new Producto(1,"Pochoclo",50,300,1000), "Lunes", true, true, 2, 50, true);
		}catch(SinPromosException e1) {
			Assert.fail("No deberia mostrar SinPromosException");
		}catch(productoInexistenteException e2) {
			Assert.fail("No deberia mostrar productoInexistenteException");
		}

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructorExitoso() {
		int id = this.productoOfertaCorrecto.getId();
		Producto producto = this.productoOfertaCorrecto.getProducto();
		boolean AplicaDosPorUno = this.productoOfertaCorrecto.isAplicaDosPorUno();
		boolean AplicaDtoPorCantidad = this.productoOfertaCorrecto.isAplicaDtoPorCantidad();
		int DtoPorCantidad_CantMinima = this.productoOfertaCorrecto.getDtoPorCantidad_CantMinima();
		double DtoPorCantidad_PrecioUnitario = this.productoOfertaCorrecto.getDtoPorCantidad_PrecioUnitario();
		boolean activo = this.productoOfertaCorrecto.isActivo();
		
		Assert.assertEquals("El numero de ID no se cargo correctamente",1,id);
		Assert.assertEquals("La promo no se cargo correctamente",true,AplicaDosPorUno);
		Assert.assertEquals("La promo no se cargo correctamente",true,AplicaDtoPorCantidad);
		Assert.assertEquals("la cantidad de venta no se cargo correctamente",2,DtoPorCantidad_CantMinima);
		Assert.assertEquals("Precio unitario no se cargo correctamente",50,DtoPorCantidad_PrecioUnitario);
		Assert.assertEquals("El stock de venta no se cargo correctamente",true,activo);
	}
	
	@Test
	public void testConstructorFallidoSinPromos() {
		ProductoOferta productoO=null;
		
		try {
			productoO= new ProductoOferta(1,new Producto(1,"Pochoclo",50,300,1000), "Lunes", false, false, 2, 50, true);
		} catch (SinPromosException e) {
			System.out.println("todo ok");
		} catch (productoInexistenteException e) {
			Assert.fail("No deberia mostrar productoInexistenteException");
		} catch (precioVentaMenorAlCostoException e) {
			Assert.fail("No deberia mostrar precioVentaMenorAlCostoExceptio");
		} catch (precioVentaInvalidoException e) {
			Assert.fail("No deberia mostrar precioVentaInvalidoException");
		} catch (costoInvalidoException e) {
			Assert.fail("No deberia mostrar costoInvalidoException");
		}
			

	}
	
	@Test
	public void testConstructorFallidoProductoNulo() {
		ProductoOferta productoO=null;
		
		try {
			productoO= new ProductoOferta(1,null, "Lunes", true, true, 2, 50, true);
		} catch (SinPromosException e) {
			Assert.fail("SinPromosException");
		} catch (productoInexistenteException e) {
			System.out.println("todo ok");
		} 
	}

}
