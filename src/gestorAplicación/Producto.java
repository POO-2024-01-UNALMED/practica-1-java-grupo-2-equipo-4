package gestorAplicación;
import java.time.*;
import java.util.ArrayList;


public class Producto {
//Atributos----------------------------------------------------------------------------------------------------
	
	private String nombre;
	private double precio;
	private int id;
	private Categoria categoria;
	private String fechaPerecer;

//-------------------------------------------------------------------------------------------------------------

//Getters and Setters------------------------------------------------------------------------------------------
	
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
	
//-------------------------------------------------------------------------------------------------------------

//Constructores------------------------------------------------------------------------------------------------
	
	public Producto(String nombre,Categoria categoria) {
		this.categoria = categoria;
		this.nombre= nombre;
	}

//-------------------------------------------------------------------------------------------------------------

//Metodos------------------------------------------------------------------------------------------------------
	
	public boolean verificarDevolucion() {
		return true;
	}
	
//-------------------------------------------------------------------------------------------------------------
}
