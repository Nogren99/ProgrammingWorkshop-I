package testCajaNegra;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestBeerHouse.class, TestBeerHouseSinDatos.class, TestCierreMesa.class, TestMesa.class, TestMozo.class,
		TestOperario.class, TestPedido.class, TestProducto.class, TestProductoOferta.class })
public class AllTests {

}
