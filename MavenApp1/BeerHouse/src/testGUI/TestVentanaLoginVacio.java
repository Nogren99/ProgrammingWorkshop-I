package testGUI;

import java.awt.Component;
import java.awt.Robot;

import javax.swing.JButton;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import negocio.BeerHouse;
import presentacion.Controlador;

public class TestVentanaLoginVacio
{
	Robot robot;
	Controlador controlador;
	//FalsoOptionPane op;
	BeerHouse sistema;
	
	@Before
	public void setUp() throws Exception
	{
		robot = new Robot();
        controlador = new Controlador();
        sistema = BeerHouse.getInstancia();
        //op = new FalsoOptionPane();
	}
	
	@Test
	public void testLogin()
	{
		Component ventana = (Component) controlador.getVista();
		robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(ventana, "btnNewButton");
        //lleno los JTextField
        TestUtils.clickComponent(aceptarLog, robot);
        //verifico los resultados
        Assert.assertNull("Usuario actual deber\u00eda ser null", controlador.getUser());
        //Assert.assertEquals("ERROR No exist\u00eds", op.getMensaje());
	}


}
