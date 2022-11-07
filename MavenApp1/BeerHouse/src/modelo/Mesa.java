package modelo;

import excepciones.CantComensalesException;

public class Mesa {
	private int numero;
    private int comensales;
    private Mozo mozo;
    private String estado;
    private Comanda comanda;
    
    
	public Mesa(int numero, int comensales, Mozo mozo, String estado) throws CantComensalesException {
		super();
		this.numero = numero;
		this.comensales = comensales;
		if(this.numero>1 && this.comensales<=1)
			throw new CantComensalesException("La cantidad de comensales no es la indicada dado el nro. de mesa");
		this.mozo = mozo;
		this.estado = estado;
	}
    
	public void AsignaMozoMesa(Mozo mozo) {
		this.mozo = mozo;
	}

	public int getComensales() {
		return comensales;
	}

	public Mozo getMozo() throws MesaSinMozoException{
		if(this.mozo.equals(null))
			throw new MesaSinMozoException("La mesa indicada no tiene mozo asociado");
		else	
			return mozo;
	}

	public String getEstado() {
		return estado;
	}

	public Comanda getComanda() {
		return comanda;
	}
    
}
