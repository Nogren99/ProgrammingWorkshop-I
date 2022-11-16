package testGUI;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestPrimerIngreso.class, TestVentana.class, TestVentanaContrasenaIncorrecta.class,
		TestVentanaContrasenaInvalida.class, TestVentanaLoginUsuario.class, TestVentanaLoginUsuarioIncorrecto.class,
		TestVentanaUsuarioInactivo.class })
public class AllTests {

}
