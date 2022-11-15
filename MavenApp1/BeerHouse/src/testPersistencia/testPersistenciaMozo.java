package testPersistencia;

import static org.junit.Assert.*;

import org.junit.Test;


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
import modelo.Mozo;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;

public class testPersistenciaMozo {
private  IPersistencia persistencia = new PersistenciaBIN();
private ArrayList<Mozo> mozos = new ArrayList<Mozo>();

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
	public void testEscrituraMozosVacio() {
		 try {
	         persistencia.abrirOutput("DatosPrueba.bin");
	         persistencia.escribir(this.mozos);
	         persistencia.cerrarOutput();
	     } catch (IOException e) {
	         Assert.fail("Error en la escritura vacia");
	     }
	}
	
	@Test
	public void testEscrituraConMozos() {
		try {
	         persistencia.abrirOutput("DatosPrueba.bin");
	         this.completaConMozos(this.mozos);
	         persistencia.escribir(this.mozos);
	         persistencia.cerrarOutput();
	     } catch (IOException e) {
	         Assert.fail("Error en la escritura de mozos");
	     }
	}
	
	@Test
	public void despersistirSinArchivo() {
		try {
			persistencia.abrirInput("Datooz.bin");
            this.mozos = (ArrayList<Mozo>) persistencia.leer();
            Assert.fail("Deberia tirar error porque no existe el archivo");
        } catch (Exception e) {        
        }
	}

	@Test
	public void despersistirConArchivo() {
		try {
            persistencia.abrirInput("DatosPrueba.bin");
            this.mozos = (ArrayList<Mozo>) persistencia.leer();
            persistencia.cerrarInput();
        } catch (Exception e) {
           Assert.fail("No deberia tirar error porque el archivo ya existe");
        }
	}
	
	@Test
	private void completaConMozos(ArrayList<Mozo> mozos) {
		try {
			this.mozos.add( new Mozo(null,new GregorianCalendar(),-1));
			this.mozos.add(new Mozo("AlexandraConX",new GregorianCalendar(),1));
		}catch (Exception e) {
			Assert.fail("No deberia lanzar esta exepcion");
		}	
	}
	
}