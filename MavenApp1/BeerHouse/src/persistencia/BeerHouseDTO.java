package persistencia;

import java.io.Serializable;
import java.util.ArrayList;

import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Producto;
import modelo.Promocion;

public class BeerHouseDTO implements Serializable {

    private ArrayList<Mozo> mozos = new ArrayList<Mozo>();
    private ArrayList<Mesa> mesa = new ArrayList<Mesa>();
    private ArrayList<Operario> operario = new ArrayList<Operario>();
    private ArrayList<Producto> producto = new ArrayList<Producto>();
    private ArrayList<Promocion> promociones = new ArrayList<Promocion>();

    public ArrayList<Promocion> getPromociones() {
		return promociones;
	}
	public void setPromociones(ArrayList<Promocion> promociones) {
		this.promociones = promociones;
	}
	public ArrayList<Mozo> getMozos() {
        return mozos;
    }
    public void setMozos(ArrayList<Mozo> mozos) {
        this.mozos = mozos;
    }
    public ArrayList<Mesa> getMesa() {
        return mesa;
    }
    public void setMesa(ArrayList<Mesa> mesa) {
        this.mesa = mesa;
    }
    public ArrayList<Operario> getOperario() {
        return operario;
    }
    public void setOperario(ArrayList<Operario> operario) {
        this.operario = operario;
    }
    public ArrayList<Producto> getProducto() {
        return producto;
    }
    public void setProducto(ArrayList<Producto> producto) {
        this.producto = producto;
    }

}