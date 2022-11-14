package modelo;

import java.io.Serializable;

import excepciones.CantComensalesException;

public class Mesa implements Serializable{
	private int numero;
    private int comensales;
    private Mozo mozo;
    private String estado;
    private Comanda comanda;
    private double consumoTotal;
    private int cantUso;
    
	public Mesa(int numero, int comensales, String estado) throws CantComensalesException{
		super();
		if( (comensales>=2 && numero>1) || numero<=1 ) { //la cantidad de comensales debe ser > =2 cuando el nro de mesa es > 1
			this.numero = numero;
			this.comensales = comensales;
			this.mozo=null;
			this.estado = estado;
			this.cantUso=0;
			this.consumoTotal=0;        
		}else {		
			throw new CantComensalesException("La cantidad de comensales no es la indicada dado el nro. de mesa");
		}	
	}


	
	public double getConsumoTotal() {
		return consumoTotal;
	}



	public int getCantUso() {
		return cantUso;
	}

	public void addConsumoTotal(double monto) {
		this.consumoTotal+=monto;
	}
	
	public void addUso() {
		this.cantUso++;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public int getComensales() {
		return comensales;
	}


	public void setComensales(int comensales) {
		this.comensales = comensales;
	}


	public Mozo getMozo() {
		return mozo;
	}


	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Comanda getComanda() {
		return comanda;
	}


	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}


	@Override
	public String toString() {
		return "Mesa [numero=" + numero + ", comensales=" + comensales + ", mozo=" + mozo + ", estado=" + estado
				+ ", comanda=" + comanda + "]";
	}


	
    
    
}
