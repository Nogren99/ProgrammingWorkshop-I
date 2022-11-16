package testGUI;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestPrimerIngreso.class, TestVentanaLoginUsuarioIncorrecto.class, TestVentana.class, TestVentanaLoginUsuario.class, TestVentanaContrasenaIncorrecta.class,
		TestVentanaContrasenaInvalida.class, TestVentanaLoginVacio.class,
		TestVentanaUsuarioInactivo.class })
public class AllTests {

}
