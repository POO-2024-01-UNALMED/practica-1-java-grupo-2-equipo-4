package gestorAplicación;
import java.time.*;

public class Producto {
	private String nombre;
	private double precio;
	private int id;
	private Categoria categoria;
	private String fechaPerecer;
	
	
	
	public Producto(String nombre,Categoria categoria) {
		this.categoria = categoria;
		this.nombre= nombre;
	}
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio=precio;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria=categoria;
	}
	
	public String getFechaPerecer() {
		return fechaPerecer;
	}
	
	public void setFechaPerecer(String fecha) {
		this.fechaPerecer=fecha;
	}
	
	public boolean verificarDisponibilidad(int cantidadSolicitada) {
		
		if (catidadSolicitada<cantidad){
			return true;
		}
		else {
			return false;
		}
		
			
	}
	
	public boolean verificarDevolucion() {
		return true;
	}
	
	

}
