package test;

import static org.junit.Assert.fail;

import java.awt.Component;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import negocio.BeerHouse;
import presentacion.Controlador;
//import util.Mensajes;
import presentacion.ControladorPersistencia;

public class TestVentana
{
	Robot robot;
	Controlador controlador;
	ControladorPersistencia controladorPersistencia;
	BeerHouse sistema;
	@Before
	public void setUp() throws Exception {
        robot = new Robot();
        controlador = new Controlador();
        //controladorPersistencia = new ControladorPersistencia();
        sistema = BeerHouse.getInstancia();
        sistema.inicializaMesas();
    }
	@Test
	public void testLogOk()
    {
        Component ventana = (Component) controlador.getVista();
		robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(ventana, "textField");
        JPasswordField contrasena =
            (JPasswordField) TestUtils.getComponentForName(ventana, "passwordField");
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(ventana, "btnNewButton");

        //lleno los JTextField
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("ADMIN", robot);
        TestUtils.clickComponent(contrasena, robot);
        TestUtils.tipeaTexto("ADMIN1234", robot);
        TestUtils.clickComponent(aceptarLog, robot);
        //verifico los resultados
        Assert.assertEquals("Deberia coincidir el nombre de usuario con el nombre ingresado", "ADMIN", controlador.getUser().getUsername());
    }
	@Test
	public void test()
	{
		fail("Not yet implemented");
	}

}
