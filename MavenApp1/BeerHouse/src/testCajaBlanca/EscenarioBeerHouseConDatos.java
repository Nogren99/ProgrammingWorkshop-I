package testCajaBlanca;

import java.util.GregorianCalendar;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.CantComensalesException;
import excepciones.EstadoInvalidoException;
import excepciones.HijosInvalidosException;
import excepciones.MesaImposibleException;
import excepciones.MesaOcupadaException;
import excepciones.MuchosProductosEnPromoException;
import excepciones.NoHayMesasHabilitadasException;
import excepciones.PasswordInvalidaException;
import excepciones.SinPromosException;
import excepciones.costoInvalidoException;
import excepciones.precioVentaInvalidoException;
import excepciones.precioVentaMenorAlCostoException;
import excepciones.productoInexistenteException;
import junit.framework.Assert;
import modelo.Comanda;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Producto;
import modelo.ProductoOferta;
import modelo.Pedido;
import negocio.BeerHouse;

public class EscenarioBeerHouseConDatos
{
    BeerHouse beerHouse = new BeerHouse();

    public BeerHouse getBeerHouse() {
		return beerHouse;
	}

	public void BeerHouse(){
    }

	@Before
    public void setUp()
    {
        try {
            beerHouse.creaMesa(new Mesa (2,4,"libre"));
        } catch (CantComensalesException e) {
            Assert.fail("No deberia tirar ninguna excepcion, los constructores ya han sido testeados");
        }
        try {
        	Mesa mesa = new Mesa (3,4,"Ocupada");
        	mesa.setMozo(new Mozo("Rodolfo", new GregorianCalendar(),2,0));
            beerHouse.creaMesa(mesa);
        } catch (CantComensalesException e) {
            Assert.fail("No deberia tirar ninguna excepcion, los constructores ya han sido testeados");
        }
        
        try {
        	Mesa mesa = new Mesa (4,4,"libre");
        	mesa.setMozo(new Mozo("Rodolfo", new GregorianCalendar(),2,0));
            beerHouse.creaMesa(mesa);
        } catch (CantComensalesException e) {
            Assert.fail("No deberia tirar ninguna excepcion, los constructores ya han sido testeados");
        }

        try {
        	Mesa mesa = new Mesa (5,4,"libre");
        	mesa.setMozo(new Mozo("Rodolfo", new GregorianCalendar(),2,0));
            Producto producto = new Producto(2,"Pollo",100,200,30);
            beerHouse.agregaProducto(producto);
            Producto producto1 = new Producto(3,"Macciato",100,200,30);
            beerHouse.agregaProducto(producto1);
            beerHouse.getPromociones().add(new ProductoOferta(3,producto,"Lunes",true,false,5,80,true));
    		beerHouse.getPromociones().add(new ProductoOferta(3,producto1,"Lunes",true,false,5,80,true));
        	Comanda comanda = new Comanda();
        	comanda.addPedido(new Pedido(producto,3));
        	comanda.addPedido(new Pedido(producto1,2));
        	mesa.setComanda(comanda);
            beerHouse.creaMesa(mesa);
        } catch (CantComensalesException | precioVentaMenorAlCostoException | precioVentaInvalidoException | costoInvalidoException | SinPromosException | productoInexistenteException e) {
            Assert.fail("No deberia tirar ninguna excepcion, los constructores ya han sido testeados");
        }
        
        try {
        	Mesa mesa = new Mesa (6,4,"libre");
        	mesa.setMozo(new Mozo("Rodolfo", new GregorianCalendar(),2,0));
        	mesa.setComanda(null);
            beerHouse.creaMesa(mesa);
        } catch (CantComensalesException e) {
            Assert.fail("No deberia tirar ninguna excepcion, los constructores ya han sido testeados");
        }
        
        try {
        	Mesa mesa = new Mesa (7,4,"libre");
        	mesa.setMozo(new Mozo("Rodolfo", new GregorianCalendar(),2,0));
        	mesa.setComanda(new Comanda());
            beerHouse.creaMesa(mesa);
        } catch (CantComensalesException e) {
            Assert.fail("No deberia tirar ninguna excepcion, los constructores ya han sido testeados");
        }
        
        
        
        beerHouse.agregaOperario(new Operario ("Marco","Q12345678","Marcos Lopez",true));
        try {
            beerHouse.agregaProducto(new Producto(12,"Pochoclo",10,20,5));
        } catch (precioVentaMenorAlCostoException | precioVentaInvalidoException | costoInvalidoException e) {
            Assert.fail("No deberia tirar ninguna excepcion, los constructores ya han sido testeados");
        }
        try {
            beerHouse.agregaProducto(new Producto(24,"Pollo",50,500,10));
        } catch (precioVentaMenorAlCostoException | precioVentaInvalidoException | costoInvalidoException e) {
            Assert.fail("No deberia tirar ninguna excepcion, los constructores ya han sido testeados");
        }
        beerHouse.agregarMozo(new Mozo("Jose", new GregorianCalendar(),2,0));

        try {
        	beerHouse.asignaMM(3, beerHouse.getMozos().get(0));
			beerHouse.agregaMesaComanda(new Pedido(beerHouse.getProducto().get(0),1) ,3);
		} catch (MuchosProductosEnPromoException e) {
		} catch (MesaOcupadaException e) {
		} catch (MesaImposibleException e) {
		} catch (NoHayMesasHabilitadasException e) {
		}
    }

	@After
    public void tearDown()
    {
        beerHouse.getMesa().clear();
        beerHouse.getOperario().clear();
        beerHouse.getProducto().clear();
        beerHouse.getMozos().clear();
    }
    
    

}