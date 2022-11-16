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
import excepciones.costoInvalidoException;
import excepciones.precioVentaInvalidoException;
import excepciones.precioVentaMenorAlCostoException;
import junit.framework.Assert;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Producto;
import modelo.Pedido;
import negocio.BeerHouse;

public class BeerHouseEscenarioSinDatos
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
		beerHouse.getMesa().clear();
        beerHouse.getOperario().clear();
        beerHouse.getProducto().clear();
        beerHouse.getMozos().clear();
        beerHouse.getPromociones().clear();
    }

	@After
    public void tearDown()
    {
        
    }
    
    

}