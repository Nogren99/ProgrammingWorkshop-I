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
    
	
    
}
