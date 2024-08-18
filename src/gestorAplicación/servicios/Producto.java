package gestorAplicación.servicios;
import java.time.*;
import java.util.ArrayList;

import gestorAplicación.servicios.Enums.Categoria;
import gestorAplicación.servicios.Enums.EstadoProducto;
import gestorAplicación.servicios.Enums.Tamaño;
import gestorAplicación.servicios.Enums.Edades;
import gestorAplicación.sujetos.Cliente;
import gestorAplicación.sujetos.Persona;

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
	private Enums.Edades edades;
	private int id;
	private Categoria categoria;
	private String descripcion;
	private LocalDate fechaPerecer;
	private ArrayList<Pasillo> pasillos=new ArrayList<Pasillo>();
	private Pasillo pasillo;
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

	public Pasillo getPasillo() {
		return pasillo;
	}

	public void setPasillo(Pasillo pasillo) {
		this.pasillo = pasillo;
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
		Producto.fechaActual = fechaActual;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	
	public  Enums.Edades getEdades() {
        return edades;
    }

    public void setEdades( Enums.Edades edades) {
        this.edades = edades;
    }
    
    public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



//Constructores------------------------------------------------------------------------------------------------
	public Producto(String nombre,Categoria categoria,Pasillo pasillo) {
		this.categoria = categoria;
		this.nombre= nombre;
		this.pasillo=pasillo;
		pasillo.getProductos().add(this);
	}
	
	public Producto(String nombre,Categoria categoria) {
		this.categoria = categoria;
		this.nombre= nombre;
		pasillo.getProductos().add(this);
	}
	

	public Producto(String nombre,String marca,double precio,Categoria categoria,int id, Enums.Edades edades,String descripcion,Pasillo pasillo) {
		this(nombre,categoria,pasillo);
		this.precio=precio;
		this.marca=marca;
		this.precio=precio;
		this.categoria=categoria;
		this.id=id;
		this.edades=edades;
		this.descripcion=descripcion;
		this.pasillo=pasillo;
	}
	
	public Producto(String nombre,String marca,double precio,Categoria categoria,int id, Enums.Edades edades,String descripcion) {
		this(nombre,categoria);
		this.precio=precio;
		this.marca=marca;
		this.precio=precio;
		this.categoria=categoria;
		this.id=id;
		this.edades=edades;
		this.descripcion=descripcion;
	}
	
	public Producto(String nombre,Categoria categoria,Tienda tienda,Pasillo pasillo) {
		this.categoria = categoria;
		this.nombre= nombre;
		this.tienda=tienda;// referencia a tienda que pertenece el producto
		this.pasillo=pasillo;
		pasillo.getProductos().add(this);
	}
	

	public Producto(String nombre, String marca, double precio,Categoria categoria, Tienda tienda,String fechaPerecer, int id, Enums.Edades edades,String descripcion,Pasillo pasillo) {
		this(nombre, marca, precio, categoria,id,edades,descripcion,pasillo);
		this.tienda=tienda; 
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		this.fechaPerecer = LocalDate.parse(fechaPerecer, formato); 
	}

	public Producto(String nombre, String marca, double precio,Categoria categoria, Tienda tienda,String fechaPerecer, int id, Enums.Edades edades,String descripcion) {
		this(nombre, marca, precio, categoria,id,edades,descripcion);
		this.tienda=tienda; 
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		this.fechaPerecer = LocalDate.parse(fechaPerecer, formato); 
	}
//-------------------------------------------------------------------------------------------------------------

//Metodos------------------------------------------------------------------------------------------------------
	
	public boolean verificarDevolucion() {
		return true;
	}
	

	// Método para filtrar productos según la edad del cliente
    public static ArrayList<Producto> filtrarPorEdad(ArrayList<Producto> productos, Cliente cliente) {
        ArrayList<Producto> productosAdecuados = new ArrayList<>();

        for (Producto producto : productos) {
            if (cliente.mayorEdad() && producto.getEdades() == Edades.ADULTOS) {
                productosAdecuados.add(producto);
            } else if (!cliente.mayorEdad() && producto.getEdades() == Edades.MENORES) {
                productosAdecuados.add(producto);
            }
        }

        return productosAdecuados;
    }
    
    // Método para filtrar productos por edad y categoría
    public static ArrayList<Producto> filtrarPorEdadYCategoria(ArrayList<Producto> productos, Cliente cliente, Categoria categoria) {
        ArrayList<Producto> productosAdecuados = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.getCategoria() == categoria) {
                if (cliente.mayorEdad() && producto.getEdades() == Edades.ADULTOS) {
                    productosAdecuados.add(producto);
                } else if (!cliente.mayorEdad() && producto.getEdades() == Edades.MENORES) {
                    productosAdecuados.add(producto);
                }
            }
        }

        return productosAdecuados;
    }

	@Override
	public String toString() {
		return nombre+" de la marca "+marca+" con un costo por unidad de $"+precio+" y de tamaño "+tamaño.getTamaño();
	}
	
//-------------------------------------------------------------------------------------------------------------
}
