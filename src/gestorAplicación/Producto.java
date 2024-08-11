package gestorAplicación;
import java.time.*;
import java.util.ArrayList;
import java.io.Serializable; 


public class Producto implements Serializable {
//Atributos----------------------------------------------------------------------------------------------------
	private static final long serialVersionUID = 1L; //<---parte de serializar
	private String nombre;
	private String marca;
	private double precio;
	private int id;
	private Categoria categoria;
	private String fechaPerecer;
	private ArrayList<Pasillo> pasillos=new ArrayList<Pasillo>();

//-------------------------------------------------------------------------------------------------------------
/*	Tienda del barrio 
	mango      s 1000    120 und. disp ****/
	
	
	
//Getters and Setters------------------------------------------------------------------------------------------
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}		
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
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
