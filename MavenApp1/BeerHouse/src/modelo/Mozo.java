package modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Mozo {
	
	private String NyA;
    private GregorianCalendar date;
    private int hijos;
    private byte estado;
    private ArrayList<Mesa> mesas = new ArrayList<Mesa>();
    
    
    
    public Mozo() {
        super();
    }


    /**
     * contrato
     * @param nyA
     * @param date - el mozo debe ser mayor de 18 años
     * @param hijos - la cant de hijos debe ser >= 0
     */
	public Mozo(String nyA, GregorianCalendar date, int hijos) {
		super();
		NyA = nyA;
		this.date = date;
		this.hijos = hijos;
	}
	
	
	
}
