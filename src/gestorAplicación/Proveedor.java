package gestorAplicación;

import java.util.*;

public class Proveedor {
	private String nombre;
	private ArrayList<Producto> entrega=new ArrayList<Producto>();
	private Categoria tipo;
	private Tienda tienda;
	private Inventario inventario;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public ArrayList<Producto> getEntrega() {
		return entrega;
	}
	
	public void setEntrega(ArrayList<Producto> entrega) {
		this.entrega=entrega;
	}
	
	public Categoria getTipo() {
		return tipo;
	}
	
	public void setTipo(Categoria tipo) {
		this.tipo=tipo;
	}
	
	public Tienda getTienda() {
		return tienda;
	}
	
	public void setTienda(Tienda tienda) {
		this.tienda=tienda;
	}
	
	public Inventario getInventario() {
		return inventario;
	}
	
	public void setInventario(Inventario inventario) {
		this.inventario=inventario;
	}
	
	public void proveerTienda(Tienda tienda) {
		
	}
	
	public void informarRebastecimiento(Producto producto) {
		
	}
}
