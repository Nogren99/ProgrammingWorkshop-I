package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;




/**
 * @author Nico
 * <br>
 * Clase que representa a un mozo de la cervecería.
 * <br>
 */
public class Mozo implements Serializable{
	
	private String NyA;
    private GregorianCalendar date;
    private int hijos;
    private byte estado;    
    private double volumenDeVenta;
    
    /**
     * Constructor que crea un mozo
     * @param nyA
     * @param date - el mozo debe ser mayor de 18 a\u00f1os
     * @param hijos - la cant de hijos debe ser >= 0
     * @param volumenDeVenta - Volumen de venta del mozo
     */
	public Mozo(String nyA, GregorianCalendar date, int hijos) {
		super();
		this.NyA=nyA;
		this.date = date;
		this.hijos = hijos;
		this.volumenDeVenta = 0.0;
	}
	/**
	 * Devuelve el nombre y apellido del mozo
	 * @return NyA
	 */
	public String getNyA() {
		return NyA;
	}

	public void setNyA(String nyA) {
		NyA = nyA;
	}
	/**
	 * Devuelve la fecha de nacimiento del mozo
	 * @return date
	 */
	public GregorianCalendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	}
	/**
	 * Devuelve la cantidad de hijos
	 * @return hijos
	 */
	public int getHijos() {
		return hijos;
	}
	
	public void setHijos(int hijos) {
		this.hijos = hijos;
	}
	/**
	 * Devuelve el estado del mozo (0 = Activo, 1 = De Franco, 2 = Ausente)
	 * @return estado
	 */
	public byte getEstado() {
		return estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}
	/**
	 * Devuelve el volumen de venta del mozo
	 * @return volumenDeVenta
	 */
	public double getVolumenDeVenta() {
		return volumenDeVenta;
	}

	public void setVolumenDeVenta(double volumenDeVenta) {
		this.volumenDeVenta += volumenDeVenta;
	}

	@Override
	public String toString() {
		String est = null;
		switch(estado) {
		case 0:
			est="Activo";
			break;
		
		case 1:
			est="De franco";
			break;
		
		case 2:
			est="Ausente";
			break;
		}
		return "Mozo [NyA=" + NyA + ", Nacimiento=" + date.get(Calendar.DATE)+ " / " + date.get(Calendar.MONTH)+ " / " + date.get(Calendar.YEAR)+", hijos=" + hijos + ", estado=" + est + ", volumenDeVenta="
				+ volumenDeVenta + "]";
	}

	
	
}
