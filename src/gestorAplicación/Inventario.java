package gestorAplicación;

import java.util.ArrayList;

public class Inventario {
	private String nombre;
	private ArrayList <ArrayList<Producto>> productos=new ArrayList<ArrayList<Producto>>();
	private Tienda tienda;
	
	public String solicitarInventario() {
		return "Nada por ahora";
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public ArrayList<ArrayList<Producto>> getProductos() {
		return productos;
	}
	
	public void setProductos(ArrayList<ArrayList<Producto>> productos) {
		this.productos=productos;
	}
	
	public Tienda getTienda() {
		return tienda;
	}
	
	public void setTienda(Tienda tienda) {
		this.tienda=tienda;
	}
}
