package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PersistenciaBIN  implements IPersistencia <Serializable>
{

    private FileOutputStream fileoutput;
    private FileInputStream fileinput;
    private ObjectOutputStream objectoutput;
    private ObjectInputStream objectinput;
    
    /**
	 * Abre un archivo para lectura.<br>
	 * <b>Pre: </b>nombre no puede ser null<br>
	 * <b>Post: </b>pasa a una variable el valor de FileInputStream y a otro el de ObjectInputStream<br>
	 * 
	 * @param nombre: nombre del archivo que se quiere abrir<br>
	 */

    public void abrirInput(String nombre) throws IOException
    {
        fileinput = new FileInputStream(nombre);
        objectinput = new ObjectInputStream(fileinput);

    }
    
    /**
	 * Abre un archivo para escritura.<br>
	 * <b>Pre: </b>nombre no puede ser null<br>
	 * <b>Post: </b>pasa a una variable el valor de FileOutputStream y a otro el de ObjectOutputStream<br>
	 * 
	 * @param nombre: nombre del archivo que se quiere abrir<br>
	 */

    public void abrirOutput(String nombre) throws IOException
    {
        fileoutput = new FileOutputStream(nombre);
        objectoutput = new ObjectOutputStream(fileoutput);

    }
    /**
	 * Cierra el archivo de escritura (siempre y cuando no sea null) 
	 */
    public void cerrarOutput() throws IOException
    {
        if (objectoutput != null)
            objectoutput.close();
    }
    
    /**
	 * Cierra el archivo de lectura (siempre y cuando no sea null) 
	 */

    public void cerrarInput() throws IOException
    {
        if (objectinput != null)
            objectinput.close();

    }
    
    /**
	 * Escribe un objeto en el archivo.<br>
	 * <b>Pre: </b>serializable no puede ser null<br>
	 * <b>Post: </b>llama al metodo writeObject del objectoutput (si no es null)<br>
	 * 
	 * @param serializable: objeto a escribir<br>
	 */

    public void escribir(Serializable serializable) throws IOException
    {
        if (objectoutput != null)
            objectoutput.writeObject(serializable);
    }
    
    /**
	 * Lee un objeto del archivo.<br>
	 */

    public Serializable leer() throws IOException, ClassNotFoundException
    {
        Serializable serializable = null;
        if (objectinput != null)
            serializable = (Serializable) objectinput.readObject();
        return serializable;
    }

	

}