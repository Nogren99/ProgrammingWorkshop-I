package testGUI;

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

public class TestPrimerIngreso
{
	Robot robot;
	Controlador controlador;
	BeerHouse sistema;
	
	@Before
	public void setUp() throws Exception {
        robot = new Robot();
        controlador = new Controlador();
        sistema = BeerHouse.getInstancia(); 
    }
	
	@Test
	public void testLogin()
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

}
