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
import excepciones.ComandaInexistenteException;
import excepciones.CostoInvalidoException;
import excepciones.PrecioVentaInvalidoException;
import excepciones.PrecioVentaMenorAlCostoException;

import static org.junit.Assert.*;

import modelo.Comanda;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Pedido;
import modelo.Producto;
import modelo.Recibo;
import negocio.BeerHouse;

public class TestPedido {
	private Pedido pedido;
	private BeerHouse sistema = BeerHouse.getInstancia();
	
	@Before
	public void setUp(){
		pedido = null;
		try {
			pedido = new Pedido(new Producto(1,"Pochoclo",50,300,1000),2);
		} catch (Exception e) {
			Assert.fail("El pedido se deberia haber creado exitosamente");
		}
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		Producto producto = this.pedido.getProducto();
		int cantidad = this.pedido.getCantidad();
		
		Assert.assertEquals("El producto no se cargo correctamente",producto,producto);
		Assert.assertEquals("La cantidad no se cargo correctamente",2,cantidad);
	}
	
}
