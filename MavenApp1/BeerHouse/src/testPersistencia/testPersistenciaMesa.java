package testPersistencia;

import static org.junit.Assert.*;

import org.junit.Test;

import excepciones.CantComensalesException;

import  org.junit.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.TreeSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.Mesa;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;

public class testPersistenciaMesa {
private  IPersistencia persistencia = new PersistenciaBIN();
private ArrayList<Mesa> mesas = new ArrayList<Mesa>();

	@Before
	public void setUp() throws Exception     {
        File archivo = new File("DatosPrueba.bin");
        if (archivo.exists())
            archivo.delete();
    }

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCrearArchivo() {
		try {
			persistencia.abrirOutput("DatosPrueba.bin");
			File archivo = new File("DatosPrueba.bin");
			Assert.assertTrue("El archivo deberia existir",archivo.exists());
		} catch (IOException e) {
		Assert.fail("No debe fallar: "+e.getMessage());
		}
	}
	
	@Test
	public void testEscrituraMesasVacio() {
		 try {
	         persistencia.abrirOutput("DatosPrueba.bin");
	         persistencia.escribir(this.mesas);
	         persistencia.cerrarOutput();
	     } catch (IOException e) {
	         Assert.fail("Error en la escritura vacia");
	     }
	}
	
	@Test
	public void testEscrituraConMesas() {
		try {
	         persistencia.abrirOutput("DatosPrueba.bin");
	         this.completaConMesasCorrectas(this.mesas);
	         persistencia.escribir(this.mesas);
	         persistencia.cerrarOutput();
	     } catch (IOException e) {
	         Assert.fail("Error en la escritura de mesas");
	     }
	}
	
	@Test
	public void despersistirSinArchivo() {
		try {
			persistencia.abrirInput("Datooz.bin");
            this.mesas = (ArrayList<Mesa>) persistencia.leer();
            Assert.fail("Deberia tirar error porque no existe el archivo");
        } catch (Exception e) {        
        }
	}

	@Test
	public void despersistirConArchivo() {
		try {
            persistencia.abrirInput("DatosPrueba.bin");
            this.mesas = (ArrayList<Mesa>) persistencia.leer();
            persistencia.cerrarInput();
        } catch (Exception e) {
           Assert.fail("No deberia tirar error porque el archivo ya existe");
        }
	}

	@Test
	private void completaConMesasCorrectas(ArrayList<Mesa> mesas) {
		try {
			this.mesas.add( new Mesa(2,3,"libre"));
			this.mesas.add( new Mesa(1,1,"libre"));
		}catch (CantComensalesException e) {
			Assert.fail("No deberia lanzar esta exepcion");
		}	
	}
	
	@Test
	private void completaConMesasIncorrectas(ArrayList<Mesa> mesas) {
		try {
			this.mesas.add( new Mesa(4,1,"libre"));
			Assert.fail("Deberia lanzar CantidadDeComensales exepcion");
		}catch (CantComensalesException e) {
			System.out.println(e.getMessage());//ESTA BIEN LANZAR UN SYSOUT???
		}	
	}
	
}