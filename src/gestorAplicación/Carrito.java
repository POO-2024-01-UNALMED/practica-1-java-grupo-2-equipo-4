package gestorAplicación;

import java.util.*;

public class Carrito {
	private ArrayList <Producto> productos=new ArrayList<Producto>();
	private Cliente cliente;
	private Tienda tienda;
	private TipoEdad tipoCarrito;
	private dooble montoTotal;
	
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	
	public void setProductos(ArrayList<Producto> productos) {
		this.productos=productos;
	}
	
	public Persona getCliente() {
		return cliente;
	}
	
	public void setCliente(Persona cliente) {
		this.cliente=cliente;
	}
	
	public Tienda getTienda() {
		return tienda;
	}
	
	public void setTienda(Tienda tienda) {
		this.tienda=tienda;
	}
	public TipoEdad getTipoCarrito() {
		return tipoCarrito;
	}
	
	public void setTipo(TipoEdad tipo) {
		this.tipoCarrito=tipo;
	}
	
	public dooble getMontoTotal() {
		return montoTotal;
	}
	
	public void  setMontoTotal(dooble monto) {
		this.montoTotal= monto;
	}
}
