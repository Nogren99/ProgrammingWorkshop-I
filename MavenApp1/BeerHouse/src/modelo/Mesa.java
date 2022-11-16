package modelo;

import java.io.Serializable;



import excepciones.CantComensalesException;

/**
 * @author Nico
 * <br>
 * Clase que representa una mesa de la cervecer�a. Se vincula con un mozo y contiene una comanda.
 *
 */

public class Mesa implements Serializable{
	private int numero;
    private int comensales;
    private Mozo mozo;
    private String estado;
    private Comanda comanda;
    private double consumoTotal;
    private int cantUso;
    
    /**
	 * Pre: La cantidad de comensales debe ser >=2 cuando el nro de mesa es > 1.
	 * Post: Mesa creada
	 * @param numero
	 * @param comensales
	 * @param estado
	 * @throws CantComensalesException
	 */
    
	public Mesa(int numero, int comensales, String estado) throws CantComensalesException{
		super();
		if( (comensales>=2 && numero>1) || numero<=1 ) {
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

	/**
	 * Devuelve el consumo de la mesa
	 * @return consumoTotal
	 */
	
	public double getConsumoTotal() {
		return consumoTotal;
	}

	/**
	 * @return cantUso
	 */
	
	public int getCantUso() {
		return cantUso;
	}

	public void addConsumoTotal(double monto) {
		this.consumoTotal+=monto;
	}
	
	public void addUso() {
		this.cantUso++;
	}

	/**
	 * Devuelve el n\u00famero de mesa
	 * @return numero
	 */
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * Devuelve la cantidad de comenzales de la mesa
	 * @return comenzales
	 */
	
	public int getComensales() {
		return comensales;
	}

	public void setComensales(int comensales) {
		this.comensales = comensales;
	}

	/**
	 * Devuelve el mozo de la mesa
	 * @return mozo
	 */
	
	public Mozo getMozo() {
		return mozo;
	}

	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}

	/**
	 * Devuelve el estado de la mesa
	 * @return estado
	 */
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Devuelve la comanda de la mesa
	 * @return comanda
	 */
	
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
