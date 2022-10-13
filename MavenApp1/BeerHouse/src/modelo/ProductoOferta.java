package modelo;

public class ProductoOferta extends Promocion {
	private int Id;
    private Producto producto;
    private String diasDePromo;
    private boolean aplicaDosPorUno;
    private boolean aplicaDtoPorCantidad;
    private int dtoPorCantidad_CantMinima;
    private double dtoPorCantidad_PrecioUnitario;
    private boolean activa;
    
    public ProductoOferta() {
        super();
    }
}
