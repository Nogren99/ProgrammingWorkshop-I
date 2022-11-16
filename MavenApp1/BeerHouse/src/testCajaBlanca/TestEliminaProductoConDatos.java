package testCajaBlanca;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.MesaImposibleException;
import excepciones.MesaOcupadaException;
import excepciones.MuchosProductosEnPromoException;
import excepciones.NoHayMesasHabilitadasException;
import excepciones.ProductoAsociadoAComandaException;
import excepciones.CantComensalesException;
import excepciones.CostoInvalidoException;
import excepciones.PrecioVentaInvalidoException;
import excepciones.PrecioVentaMenorAlCostoException;
import modelo.Comanda;
import modelo.Mesa;
import modelo.Pedido;
import modelo.Producto;
import negocio.BeerHouse;
import testCajaNegra.BeerHouseEscenarioSinDatos;

public class TestEliminaProductoConDatos {
	private BeerHouse beerHouse = new BeerHouse();
	Producto producto;

	
	
	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void Camino_3() {
		beerHouse.getMesa().clear();
		this.addProducto();
		this.escenario3();
		try {
			beerHouse.eliminaProducto(this.producto);
			System.out.println("bien");
		} catch (ProductoAsociadoAComandaException e) {
			Assert.fail("No deberia lanzar ProductoAsociadoAComandaException");
		}
	}
	
	@Test
	public void Camino_4() {
		beerHouse.getMesa().clear();
		this.addProducto();
		this.escenario4();
		try {
			beerHouse.eliminaProducto(this.producto);
			System.out.println("bien");
		} catch (ProductoAsociadoAComandaException e) {
			Assert.fail("No deberia lanzar ProductoAsociadoAComandaException");
		}
	}
	
	
	@Test
	public void Camino_5() {
		beerHouse.getMesa().clear();
		this.addProducto();
		this.escenario5();
		try {
			beerHouse.eliminaProducto(this.producto);
			System.out.println("bien");
		} catch (ProductoAsociadoAComandaException e) {
			Assert.fail("No deberia lanzar ProductoAsociadoAComandaException");
		}
	}
	
	
	@Test
	public void Camino_6() {
		beerHouse.getMesa().clear();
		this.addProducto();
		this.escenario6();
		try {
			beerHouse.eliminaProducto(this.producto);
			Assert.fail("No deberia ejecutarse sin excepciones");
		} catch (ProductoAsociadoAComandaException e) {
			System.out.println("bien");
		}
	}
	
	
	
	
	private void escenario3() {  //beerhouse tiene una mesa con comanda nula
		try {
			this.beerHouse.getMesa().add(new Mesa(1,4,"libre"));
		} catch (CantComensalesException e) {
			Assert.fail("No deberia lanzar CantComensalesException");
		}
	}
	
	private void escenario4() { //beerhouse tiene una mesa con comanda sin pedidos
		try {
			Mesa mesa = new Mesa(1,4,"libre");
			this.beerHouse.getMesa().add(mesa);
			mesa.setComanda(new Comanda());
		} catch (CantComensalesException e) {
			Assert.fail("No deberia lanzar CantComensalesException");
		}
	}
	
	private void escenario5() { //beerhouse tiene una mesa con comanda con pedidos sin nuestro producto a eliminar
			Mesa mesa;
			try {
				mesa = new Mesa(1,4,"libre");
				this.beerHouse.getMesa().add(mesa);
				Comanda comanda = new Comanda();
				comanda.addPedido(new Pedido(new Producto(8,"Granola",30,50,300),10));
				mesa.setComanda(comanda);
			} catch (CantComensalesException e) {
				Assert.fail("No deberia lanzar CantComensalesException");
			} catch (PrecioVentaMenorAlCostoException e) {
				Assert.fail("No deberia lanzar PrecioVentaMenorAlCostoException");
			} catch (PrecioVentaInvalidoException e) {
				Assert.fail("No deberia lanzar PrecioVentaInvalidoException");
			} catch (CostoInvalidoException e) {
				Assert.fail("No deberia lanzar CostoInvalidoException");
			}
	}
	
	private void escenario6() { //beerhouse tiene una mesa con comanda con pedidos y con nuestro producto a eliminar
		try {
			Mesa mesa = new Mesa(1,4,"libre");
			this.beerHouse.getMesa().add(mesa);
			Comanda comanda = new Comanda();
			comanda.addPedido(new Pedido(this.producto,1));
			mesa.setComanda(comanda);
		} catch (CantComensalesException e) {
			Assert.fail();
		}
	}
	
	
	
	
	//metodo que se invocara previo a cada test pues es precondicion que el producto exista
	//no lo hago en el setup porque con cada test lo estaré eliminando
	private void addProducto() {
			Producto producto;
			try {
				producto = new Producto(7,"Maiz",5,20,200);
				this.beerHouse.getProducto().add(producto);
				this.producto=producto;
			} catch (PrecioVentaMenorAlCostoException e) {
				Assert.fail("No deberia lanzar PrecioVentaMenorAlCostoException");
			} catch (PrecioVentaInvalidoException e) {
				Assert.fail("No deberia lanzar PrecioVentaInvalidoException");
			} catch (CostoInvalidoException e) {
				Assert.fail("No deberia lanzar CostoInvalidoException");
			}	
	}
}
