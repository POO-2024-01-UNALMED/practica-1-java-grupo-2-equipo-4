package gestorAplicación;

import java.util.ArrayList;

public class Inventario {
	private ArrayList <Pasillo> bodegas=new ArrayList<Pasillo>();
	private Tienda tienda;
	private Proveedor proveedor;
	
	public Inventario(Tienda tienda) {
		this.tienda = tienda;
	}

	public Inventario(ArrayList<Pasillo> bodegas, Tienda tienda, Proveedor proveedor) {
		this.bodegas = bodegas;
		this.tienda = tienda;
		this.proveedor = proveedor;
	}

	public ArrayList <Producto> solicitarInventario() {
		ArrayList <Producto> Inventario=new ArrayList<Producto>();
		for (Pasillo i:bodegas) {
			for (Producto p:i.getProductos()) {
				Inventario.add(p);
			}
		}
		return Inventario;
	}
	
	public ArrayList<Pasillo> getBodegas() {
		return bodegas;
	}

	public void setBodegas(ArrayList<Pasillo> bodegas) {
		this.bodegas = bodegas;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public void contactarProvedor() {
		
	}
	
	public int contarProductosEnIventario() {
		return 1;
	}
	
	public ArrayList<Pasillo> getProductos() {
		return bodegas;
	}
	
	public void setProductos(ArrayList<Pasillo> bodegas) {
		this.bodegas=bodegas;
	}
	
	public Tienda getTienda() {
		return tienda;
	}
	
	public void setTienda(Tienda tienda) {
		this.tienda=tienda;
	}
	
}
