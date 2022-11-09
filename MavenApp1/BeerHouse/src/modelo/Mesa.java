package modelo;

public class Mesa {
	private int numero;
    private int comensales;
    private Mozo mozo;
    private String estado;
    private Comanda comanda;
    
    
	public Mesa(int numero, int comensales, Mozo mozo, String estado) {
		super();
		this.numero = numero;
		this.comensales = comensales;
		this.mozo = mozo;
		this.estado = estado;
	}


	public int getComensales()
	{
		return comensales;
	}


	public void setComensales(int comensales)
	{
		this.comensales = comensales;
	}


	public Mozo getMozo()
	{
		return mozo;
	}


	public void setMozo(Mozo mozo)
	{
		this.mozo = mozo;
	}


	public String getEstado()
	{
		return estado;
	}


	public void setEstado(String estado)
	{
		this.estado = estado;
	}


	public Comanda getComanda()
	{
		return comanda;
	}


	public void setComanda(Comanda comanda)
	{
		this.comanda = comanda;
	}


	public int getNumero()
	{
		return numero;
	}
    
}
