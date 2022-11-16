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
import excepciones.CostoInvalidoException;
import excepciones.PrecioVentaInvalidoException;
import excepciones.PrecioVentaMenorAlCostoException;
import modelo.Pedido;
import modelo.Producto;
import negocio.BeerHouse;
import testCajaNegra.BeerHouseEscenarioSinDatos;
//no es necesario hacer un escenario ya que beerhouse se construye con 
public class TestAgregaMesaComandaConDatos {
	private BeerHouse beerHouse;
	private EscenarioBeerHouseConDatos BHConDatos = new EscenarioBeerHouseConDatos();
	
	
	@Before
	public void setUp() throws Exception {
		this.BHConDatos.setUp();
		this.beerHouse=this.BHConDatos.getBeerHouse();
	}

	@After
	public void tearDown() throws Exception {
		BHConDatos.tearDown();
	}
	
	
	//camino 2 no se testea pues es un camino inaccesible
	
	//se printean solo las mesas 2 y 3 pero se est�n usando todas correctamente
	
	@Test
	 public void Camino_3() {
	        try {
				beerHouse.agregaMesaComanda(new Pedido(new Producto(1,"Manzana",30,100,50),3), 14); //mesa 14: mesa inexistente
				System.out.println("bien");
			} catch (MuchosProductosEnPromoException | MesaOcupadaException | MesaImposibleException
					| NoHayMesasHabilitadasException | PrecioVentaMenorAlCostoException | PrecioVentaInvalidoException | CostoInvalidoException e) {
				Assert.fail();
			}
	 }
	
	@Test
	 public void Camino_4() {
	        try {
				beerHouse.agregaMesaComanda(new Pedido(new Producto(1,"Manzana",30,100,50),3), 2); //mesa 2: libre sin mozo
				Assert.fail();
	        } catch (MuchosProductosEnPromoException | MesaOcupadaException | NoHayMesasHabilitadasException | PrecioVentaMenorAlCostoException | PrecioVentaInvalidoException | CostoInvalidoException e) {
				Assert.fail();
			} catch (MesaImposibleException e) {
				System.out.println("bien");
			}
	 }
	
	@Test
	public void Camino_5() {
        try {
			beerHouse.agregaMesaComanda(new Pedido(new Producto(1,"Manzana",30,100,50),3), 3);     //mesa 3: ocupada
			Assert.fail();
        } catch (MuchosProductosEnPromoException| MesaImposibleException | NoHayMesasHabilitadasException | PrecioVentaMenorAlCostoException | PrecioVentaInvalidoException | CostoInvalidoException e) {
			Assert.fail();
		} catch ( MesaOcupadaException e) {
			System.out.println("bien");
		} 
    }
	
	@Test
	public void Camino_6() {
        try {	
        	beerHouse.agregaMesaComanda(new Pedido(new Producto(1,"Manzana",30,100,50),3), 5);     //mesa 5: libre, con mozo, con dos productos en promo
        	Assert.fail();
        } catch (MesaOcupadaException | MesaImposibleException | NoHayMesasHabilitadasException | PrecioVentaMenorAlCostoException | PrecioVentaInvalidoException | CostoInvalidoException e) {
			Assert.fail();
		} catch ( MuchosProductosEnPromoException e) {
			System.out.println("bien");
		} 
    }
	
	@Test
	public void Camino_7() {
        try {
			beerHouse.agregaMesaComanda(new Pedido(new Producto(1,"Manzana",30,100,50),3), 6);     //mesa 6: libre, con mozo, con comanda nula
			System.out.println("bien");
		} catch (MuchosProductosEnPromoException | MesaOcupadaException | MesaImposibleException | NoHayMesasHabilitadasException | PrecioVentaMenorAlCostoException | PrecioVentaInvalidoException | CostoInvalidoException e) {
			Assert.fail();
		} 
    }
	
	@Test
	public void Camino_8() {
        try {
			beerHouse.agregaMesaComanda(new Pedido(new Producto(1,"Manzana",30,100,50),3), 7);     //mesa 7: libre, con mozo, con comanda no nula
			System.out.println("bien");
		} catch (MuchosProductosEnPromoException | MesaOcupadaException | MesaImposibleException | NoHayMesasHabilitadasException | PrecioVentaMenorAlCostoException | PrecioVentaInvalidoException | CostoInvalidoException e) {
			Assert.fail();
		} 
    }

}
