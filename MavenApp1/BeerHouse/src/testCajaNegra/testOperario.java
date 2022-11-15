package testCajaNegra;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import modelo.Operario;

public class testOperario {
	private Operario operario;
	
	@Before
	public void setUp(){
		operario = null;
		try {
			operario = new Operario ("Marco","Q12345678","Marcos Lopez",true);
		} catch (Exception e) {
			Assert.fail("El operario se deberia haber creado correctamente");
		}
	}
    
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		String username = this.operario.getUsername();
		String password = this.operario.getPassword();
		String NyA = this.operario.getNyA();
		boolean activo = this.operario.isActivo();
		byte categoria = this.operario.getCategoria();
		
		Assert.assertEquals("El nombre y apellido no se cargo correctamente","Marco",username);
		Assert.assertEquals("El nombre y apellido no se cargo correctamente","Q12345678",password);
		Assert.assertEquals("El nombre y apellido no se cargo correctamente","Marcos Lopez",NyA);
		Assert.assertEquals("El valor activo no se cargo correctamente",true,activo);
		Assert.assertEquals("La categoria de hijos no se cargo correctamente",10,categoria);

	}
	
}
