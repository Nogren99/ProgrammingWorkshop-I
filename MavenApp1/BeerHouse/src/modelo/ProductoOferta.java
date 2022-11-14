package modelo;

public class ProductoOferta extends Promocion {
	private int Id;
    
    private String diasDePromo;
    private boolean aplicaDosPorUno;
    private boolean aplicaDtoPorCantidad;
    private int dtoPorCantidad_CantMinima;
    private double dtoPorCantidad_PrecioUnitario;
   
    

	public ProductoOferta(int id, Producto producto, String diasDePromo, boolean aplicaDosPorUno,
			boolean aplicaDtoPorCantidad, int dtoPorCantidad_CantMinima, double dtoPorCantidad_PrecioUnitario,
			boolean activo) {
		super();
		Id = id;
		this.producto = producto;
		this.diasDePromo = diasDePromo;
		this.aplicaDosPorUno = aplicaDosPorUno;
		this.aplicaDtoPorCantidad = aplicaDtoPorCantidad;
		this.dtoPorCantidad_CantMinima = dtoPorCantidad_CantMinima;
		this.dtoPorCantidad_PrecioUnitario = dtoPorCantidad_PrecioUnitario;
		this.activo = activo;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public String getDiasDePromo() {
		return diasDePromo;
	}

	public void setDiasDePromo(String diasDePromo) {
		this.diasDePromo = diasDePromo;
	}

	public boolean isAplicaDosPorUno() {
		return aplicaDosPorUno;
	}

	public void setAplicaDosPorUno(boolean aplicaDosPorUno) {
		this.aplicaDosPorUno = aplicaDosPorUno;
	}

	public boolean isAplicaDtoPorCantidad() {
		return aplicaDtoPorCantidad;
	}

	public void setAplicaDtoPorCantidad(boolean aplicaDtoPorCantidad) {
		this.aplicaDtoPorCantidad = aplicaDtoPorCantidad;
	}

	public int getDtoPorCantidad_CantMinima() {
		return dtoPorCantidad_CantMinima;
	}

	public void setDtoPorCantidad_CantMinima(int dtoPorCantidad_CantMinima) {
		this.dtoPorCantidad_CantMinima = dtoPorCantidad_CantMinima;
	}

	public double getDtoPorCantidad_PrecioUnitario() {
		return dtoPorCantidad_PrecioUnitario;
	}

	public void setDtoPorCantidad_PrecioUnitario(double dtoPorCantidad_PrecioUnitario) {
		this.dtoPorCantidad_PrecioUnitario = dtoPorCantidad_PrecioUnitario;
	}


	@Override
	public double calculaPrecio(int cant,String promo) {
		double aux=0;
		
		if(promo==this.diasDePromo && activo) {
			if(this.aplicaDosPorUno && cant%2==0) 
				aux=(this.producto.getVenta()*cant)/2;
			if(this.aplicaDtoPorCantidad && cant>this.dtoPorCantidad_CantMinima) {
				aux=this.dtoPorCantidad_PrecioUnitario*cant;
			}
		}else
			aux=cant*this.producto.getVenta();

		return aux;
		
	}

	@Override
	public String toString() {
		return "ProductoOferta [Id=" + Id + ", diasDePromo=" + diasDePromo + ", aplicaDosPorUno=" + aplicaDosPorUno
				+ ", aplicaDtoPorCantidad=" + aplicaDtoPorCantidad + ", dtoPorCantidad_CantMinima="
				+ dtoPorCantidad_CantMinima + ", dtoPorCantidad_PrecioUnitario=" + dtoPorCantidad_PrecioUnitario
				+ ", activa=" + activo + "]";
	}
}
