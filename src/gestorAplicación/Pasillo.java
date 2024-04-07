package gestorAplicación;
import java.util.*;


public class Pasillo {
	private String nombre;
	private ArrayList<Producto> productos=new ArrayList<Producto>();
	
	private Cliente cliente;
	private Categoria categoria;
	
	
	public Pasillo(String nombre,  Categoria categoria) {
		this.nombre = nombre;
		
		this.categoria = categoria;
	}
	
	public Pasillo(String nombre, ArrayList<Producto> productos,  Cliente cliente, Categoria categoria) {
		this.nombre = nombre;
		this.productos = productos;
		
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
	
//	public int cantidadProducto(int id) {}
//       cuando continues quita el comentario
}