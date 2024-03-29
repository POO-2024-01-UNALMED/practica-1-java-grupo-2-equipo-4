package gestorAplicación;
import java.time.*;

public class Producto {
	private int cantidad;
	private double precio;
	private int id;
	private Categoria categoria;
	private String fechaPerecer;
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad=cantidad;
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
	
	public boolean verificarDisponibilidad() {
		if (cantidad>0){
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
