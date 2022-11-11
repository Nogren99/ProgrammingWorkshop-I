package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Mozo implements Serializable{
	
	private String NyA;
    private GregorianCalendar date;
    private int hijos;
    private byte estado;    
    private double volumenDeVenta;
    
    /**
     * contrato
     * @param nyA
     * @param date - el mozo debe ser mayor de 18 a\u00f1os
     * @param hijos - la cant de hijos debe ser >= 0
     */
	public Mozo(String nyA, GregorianCalendar date, int hijos) {
		super();
		this.NyA=nyA;
		this.date = date;
		this.hijos = hijos;
		this.volumenDeVenta = 0.0;
	}

	public String getNyA() {
		return NyA;
	}

	public void setNyA(String nyA) {
		NyA = nyA;
	}

	public GregorianCalendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	public int getHijos() {
		return hijos;
	}

	public void setHijos(int hijos) {
		this.hijos = hijos;
	}

	public byte getEstado() {
		return estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public double getVolumenDeVenta() {
		return volumenDeVenta;
	}

	public void setVolumenDeVenta(double volumenDeVenta) {
		this.volumenDeVenta = volumenDeVenta;
	}

	@Override
	public String toString() {
		return "Mozo [NyA=" + NyA + ", date=" + date + ", hijos=" + hijos + ", estado=" + estado + ", volumenDeVenta="
				+ volumenDeVenta + "]";
	}

	
	
}
