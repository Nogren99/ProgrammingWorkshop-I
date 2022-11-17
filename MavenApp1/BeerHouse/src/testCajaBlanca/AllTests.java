package testCajaBlanca;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAgregaMesaComandaConDatos.class, TestAgregaMesaComandaSinDatos.class,
		TestEliminaProductoConDatos.class, TestEliminaProductoSinDatos.class })
public class AllTests {

}
