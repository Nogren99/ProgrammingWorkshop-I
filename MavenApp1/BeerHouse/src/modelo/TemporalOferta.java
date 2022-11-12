package modelo;

public class TemporalOferta extends Promocion {
	private String nombre;
    private String formaPago;
    private int porcentajeDescuento;
    private String diasDePromo;
    private boolean activo;
    private boolean esAcumulable;
    

	public TemporalOferta(String nombre, String formaPago, int porcentajeDescuento, String diasDePromo, boolean activo,
			boolean esAcumulable) {
		super();
		this.nombre = nombre;
		this.formaPago = formaPago;
		this.porcentajeDescuento = porcentajeDescuento;
		this.diasDePromo = diasDePromo;
		this.activo = activo;
		this.esAcumulable = esAcumulable;
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
}
