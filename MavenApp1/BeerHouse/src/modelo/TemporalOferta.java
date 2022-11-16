package modelo;

/**
 * @author Nico
 * <br>
 * Clase que representa una promoci�n temporal.
 * <br>
 *
 */

public class TemporalOferta extends Promocion {
	private String nombre;
	private String formaPago;
    private int porcentajeDescuento;
    private String diasDePromo;
    private boolean esAcumulable;

	public TemporalOferta(Producto producto,String nombre, String formaPago,String diasDePromo, int porcentajeDescuento,boolean esAcumulable,  boolean activo
			) {
		super();
		this.producto = producto;
		this.nombre = nombre;
		this.formaPago = formaPago;
		this.porcentajeDescuento = porcentajeDescuento;
		this.diasDePromo = diasDePromo;
		this.activo = activo;
		this.esAcumulable = esAcumulable;
	}

    @Override
	public String toString() {
		return "TemporalOferta [nombre=" + nombre + ", formaPago=" + formaPago + ", porcentajeDescuento="
				+ porcentajeDescuento + ", diasDePromo=" + diasDePromo + ", activo=" + activo + ", esAcumulable="
				+ esAcumulable + "]";
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public int getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(int porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public String getDiasDePromo() {
		return diasDePromo;
	}

	public void setDiasDePromo(String diasDePromo) {
		this.diasDePromo = diasDePromo;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public boolean isEsAcumulable() {
		return esAcumulable;
	}

	public void setEsAcumulable(boolean esAcumulable) {
		this.esAcumulable = esAcumulable;
	}

	/**
	 *<b>Pre: </b>cant es un entero positivo<br>
	 *Promo es una cadena no vacia con el dia de promocion<br>
	 */
	
	@Override
	public double calculaPrecio(int cant,String promo) {
		if(activo && promo == this.diasDePromo) {
			return cant * (  this.producto.getVenta() * this.porcentajeDescuento / 100  );
		}else
			return cant*this.producto.getVenta();
	}
	
}
