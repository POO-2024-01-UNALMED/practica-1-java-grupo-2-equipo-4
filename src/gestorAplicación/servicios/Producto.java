package gestorAplicación.servicios;
import java.time.*;
import java.util.ArrayList;

import gestorAplicación.servicios.Enums.Categoria;
import gestorAplicación.servicios.Enums.EstadoProducto;
import gestorAplicación.servicios.Enums.Tamaño;

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
	private Tamaño tamaño;
	private int id;
	private Categoria categoria;
	private LocalDate fechaPerecer;
	private ArrayList<Pasillo> pasillos=new ArrayList<Pasillo>();
	private EstadoProducto estado=EstadoProducto.ACTIVO;
	private static LocalDate fechaActual=LocalDate.now();
	private Tienda tienda;
	
//-------------------------------------------------------------------------------------------------------------
	//LocalDate.of(año,mes,dia)//
	
	
	
//Getters and Setters------------------------------------------------------------------------------------------
	
	
	public String getNombre() {
		return nombre;
	}

	public Tamaño getTamaño() {
		return tamaño;
	}


	public void setTamaño(Tamaño tamaño) {
		this.tamaño = tamaño;
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
	
	public EstadoProducto getEstado() {
		return estado;
	}

	public void setEstado(EstadoProducto estado) {
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
	
	public Producto(String nombre,String marca,double precio,Categoria categoria,int id) {
		this(nombre,categoria);
		this.precio=precio;
		this.marca=marca;
		this.precio=precio;
		this.categoria=categoria;
		this.id=id;
	}
	
	public Producto(String nombre,Categoria categoria,Tienda tienda) {
		this.categoria = categoria;
		this.nombre= nombre;
		this.tienda=tienda;// referencia a tienda que pertenece el producto
	}
	
	public Producto(String nombre, String marca, double precio,Categoria categoria, Tienda tienda,String fechaPerecer, int id) {
		this(nombre, marca, precio, categoria,id);
		this.tienda=tienda; 
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		this.fechaPerecer = LocalDate.parse(fechaPerecer, formato); 
	}

//-------------------------------------------------------------------------------------------------------------

//Metodos------------------------------------------------------------------------------------------------------
	
	public boolean verificarDevolucion() {
		return true;
	}
	

	
	@Override
	public String toString() {
		return nombre+" de la marca "+marca+" con un costo por unidad de $"+precio;
	}
	
//-------------------------------------------------------------------------------------------------------------
}
