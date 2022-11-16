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
import presentacion.ControladorPersistencia;
import vista.IVista;

public class TestVentanaContrasenaInvalida
{
	Robot robot;
	Controlador controlador;
	ControladorPersistencia controladorPersistencia;
	BeerHouse sistema;
	@Before
	public void setUp() throws Exception
	{
		robot = new Robot();
        controlador = new Controlador();
        controladorPersistencia = new ControladorPersistencia();
        sistema = BeerHouse.getInstancia();
	}

	@Before
	public void testPersistencia()
    {
        Component ventana = (Component) controladorPersistencia.getVista();
		robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JButton leerPersistencia = (JButton) TestUtils.getComponentForName(ventana, "btnLeerPersistencia");
        TestUtils.clickComponent(leerPersistencia, robot);
        ((IVista) ventana).cerrar();
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
        TestUtils.tipeaTexto("Jose", robot);
        TestUtils.clickComponent(contrasena, robot);
        TestUtils.tipeaTexto("aaa", robot);
        TestUtils.clickComponent(aceptarLog, robot);
        //verifico los resultados
        Assert.assertNull("El nombre de usuario deber\u00eda ser null", controlador.getUser());
	}}
