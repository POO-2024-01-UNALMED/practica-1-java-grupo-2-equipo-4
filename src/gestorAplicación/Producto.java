package gestorAplicación;
import java.time.*;
import java.util.ArrayList;

import gestorAplicación.Enums.Categoria;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Producto implements Serializable {
//Atributos----------------------------------------------------------------------------------------------------
	private static final long serialVersionUID = 1L; //<---parte de serializar
	private String nombre;
	private String marca;
	private double precio;
	private int id;
	private Enums.Categoria categoria;
	private LocalDate fechaPerecer;
	private ArrayList<Pasillo> pasillos=new ArrayList<Pasillo>();
	private Enums.estadoProducto estado=Enums.estadoProducto.ACTIVO;
	private LocalDate fechaActual;
	private Tienda tienda;
	
//-------------------------------------------------------------------------------------------------------------
	//LocalDate.of(año,mes,dia)//
	
	
	
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
	
	public Enums.Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Enums.Categoria categoria) {
		this.categoria=categoria;
	}
	
	public LocalDate getFechaPerecer() {
		return fechaPerecer;
	}
	
	public void setFechaPerecer(LocalDate fecha) {
		this.fechaPerecer=fecha;
	}
	
	public Enums.estadoProducto getEstado() {
		return estado;
	}

	public void setEstado(Enums.estadoProducto estado) {
		this.estado = estado;
	}
		
	public LocalDate getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(LocalDate fechaActual) {
		this.fechaActual = fechaActual;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}


//-------------------------------------------------------------------------------------------------------------

//Constructores------------------------------------------------------------------------------------------------
		public Producto(String nombre,Categoria categoria) {
		this.categoria = categoria;
		this.nombre= nombre;
		}
		public Producto(String nombre,Categoria categoria,Tienda tienda) {
		this.categoria = categoria;
		this.nombre= nombre;
		this.tienda=tienda; // referencia a tienda que pertenece el producto
	}
	
	public Producto(String nombre,Categoria categoria,Tienda tienda,String fechaPerecer) {
		this.categoria = categoria;
		this.nombre= nombre;
		this.tienda=tienda; 
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		this.fechaPerecer = LocalDate.parse(fechaPerecer, formato); 
	}

//-------------------------------------------------------------------------------------------------------------

//Metodos------------------------------------------------------------------------------------------------------
	
	public boolean verificarDevolucion() {
		return true;
	}
	
	public void  vencerProducto() {
		//si esta caducado//
		for (Producto producto: this.tienda.obtenerTodosLosProductos()) {
			if (producto.getFechaPerecer()==producto.fechaActual){
			 producto.setEstado(Enums.estadoProducto.VENCIDO); 
			 this.tienda.getProductosVencidos().add(producto);
		    }
		}
		
		 
	}
	
	@Override
	public String toString() {
		return nombre+" de la marca "+marca+" con un costo por unidad de "+precio;
	}
	
//-------------------------------------------------------------------------------------------------------------
}
