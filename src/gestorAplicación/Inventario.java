package gestorAplicación;

import java.util.ArrayList;

public class Inventario {
	private String nombre;
	private ArrayList <Pasillo> bodegas=new ArrayList<Pasillo>();
	private Tienda tienda;
	private Categoria categoria;
	
	public Inventario(String nombre, ArrayList<Pasillo> bodegas, Tienda tienda, Categoria categoria) {
		this.nombre = nombre;
		this.bodegas = bodegas;
		this.tienda = tienda;
		this.categoria = categoria;
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
	
	public void contactarProvedor() {
		
	}
	
	public int contarProductosEnIventario() {
		return 1;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
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
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria=categoria;
	}
}
