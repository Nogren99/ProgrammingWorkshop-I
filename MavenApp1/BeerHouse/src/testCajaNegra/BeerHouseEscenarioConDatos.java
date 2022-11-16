package testCajaNegra;

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
import excepciones.CostoInvalidoException;
import excepciones.PrecioVentaInvalidoException;
import excepciones.PrecioVentaMenorAlCostoException;
import junit.framework.Assert;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Producto;
import modelo.Pedido;
import negocio.BeerHouse;

public class BeerHouseEscenarioConDatos
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
            e.printStackTrace();
        }
        try {
            beerHouse.creaMesa(new Mesa (3,4,"libre"));
        } catch (CantComensalesException e) {
            Assert.fail("No deberia tirar ninguna excepcion, los constructores ya han sido testeados");
            e.printStackTrace();
        }
        
        
        beerHouse.agregaOperario(new Operario ("Marco","Q12345678","Marcos Lopez",true));
        try {
            beerHouse.agregaProducto(new Producto(12,"Pochoclo",10,20,5));
        } catch (PrecioVentaMenorAlCostoException | PrecioVentaInvalidoException | CostoInvalidoException e) {
            Assert.fail("No deberia tirar ninguna excepcion, los constructores ya han sido testeados");
            e.printStackTrace();
        }
        try {
            beerHouse.agregaProducto(new Producto(24,"Pollo",50,500,10));
        } catch (PrecioVentaMenorAlCostoException | PrecioVentaInvalidoException | CostoInvalidoException e) {
            Assert.fail("No deberia tirar ninguna excepcion, los constructores ya han sido testeados");
            e.printStackTrace();
        }
        beerHouse.agregarMozo(new Mozo("Jose", new GregorianCalendar(),2,0));

        try {
        	beerHouse.asignaMM(3, beerHouse.getMozos().get(0));
			beerHouse.agregaMesaComanda(new Pedido(beerHouse.getProducto().get(0),1) ,3);
		} catch (MuchosProductosEnPromoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MesaOcupadaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MesaImposibleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoHayMesasHabilitadasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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