package gestorAplicación;
import java.util.*;

public class Pasillo {
	private String nombre;
	private ArrayList<Producto> productos=new ArrayList<Producto>();
	private Tienda tienda;
	private Cliente cliente;
	private Categoria categoria;
	
	public Pasillo(String nombre, Tienda tienda, Categoria categoria) {
		this.nombre = nombre;
		this.tienda = tienda;
		this.categoria = categoria;
	}
	
	public Pasillo(String nombre, ArrayList<Producto> productos, Tienda tienda, Cliente cliente, Categoria categoria) {
		this.nombre = nombre;
		this.productos = productos;
		this.tienda = tienda;
		this.cliente = cliente;
		this.categoria = categoria;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	public Tienda getTienda() {
		return tienda;
	}
	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public int cantidadProducto(int id) {}
}
