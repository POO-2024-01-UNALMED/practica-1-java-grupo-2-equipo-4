package gestorAplicación.servicios;

import java.util.ArrayList;
import java.util.Objects;
import gestorAplicación.servicios.Enums.Categoria;
import gestorAplicación.servicios.Enums.EstadoProducto;
import gestorAplicación.servicios.Enums.Tamaño;
import gestorAplicación.servicios.Enums.Edades;
import gestorAplicación.sujetos.Cliente;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class Producto implements Serializable,Cloneable {
//Atributos----------------------------------------------------------------------------------------------------
	private static final long serialVersionUID = 1L; //<---parte de serializar
	
	private String nombre;
	private String marca;
	private double precio;
	private Tamaño tamaño;
	private Edades edadValida;
	private int id;
	private Categoria categoria;
	private String descripcion;
	private LocalDate fechaPerecer;
	private Pasillo pasillo;
	private Tienda tienda;
	
	private EstadoProducto estado=EstadoProducto.ACTIVO;
	private static LocalDate fechaActual=LocalDate.now();


	
	
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
	
	public  Edades getEdades() {
        return edadValida;
    }

    public void setEdades(Edades edades) {
        this.edadValida = edades;
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
		
	}

	public Producto(String nombre,String marca,double precio,Categoria categoria,int id, Enums.Edades edades,String descripcion,Pasillo pasillo) {
		this(nombre,categoria,pasillo);
		this.precio=precio;
		this.marca=marca;
		this.precio=precio;
		this.categoria=categoria;
		this.id=id;
		this.edadValida=edades;
		this.descripcion=descripcion;
		this.pasillo=pasillo;
	}
	
	public Producto(String nombre,String marca,double precio,Categoria categoria,int id, Enums.Edades edades,String descripcion,Tamaño tamaño) {
		this(nombre,categoria);
		this.precio=precio;
		this.marca=marca;
		this.precio=precio;
		this.categoria=categoria;
		this.id=id;
		this.edadValida=edades;
		this.descripcion=descripcion;
		this.tamaño=tamaño;
	}
	


	public Producto(String nombre, String marca, double precio,Categoria categoria, Tienda tienda,String fechaPerecer, int id, Edades edades,String descripcion,Tamaño tamaño) {
		this(nombre, marca, precio, categoria,id,edades,descripcion,tamaño);
		this.tienda=tienda; 
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		this.fechaPerecer = LocalDate.parse(fechaPerecer, formato); 
		
	}
	
	public Producto(String nombre, double precio, Categoria categoria, int id, Edades edadValida, String descripcion) {
		this.nombre=nombre;
		this.precio=precio;
		this.categoria=categoria;
		this.id=id;
		this.edadValida=edadValida;
		this.descripcion=descripcion;
	}	
//-------------------------------------------------------------------------------------------------------------
		//clonable //
	
	public Producto(String nombre, String marca, double precio, Tamaño tamaño, Edades categoriaEdad, Categoria categoriaAlimento, String descripcion, String fechaPerecer, int id) {
		this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.tamaño = tamaño;
        this.edadValida = categoriaEdad;
        this.categoria = categoriaAlimento;
        this.descripcion = descripcion;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		this.fechaPerecer = LocalDate.parse(fechaPerecer, formato); 
        this.id = id;
	}

	@Override
	public Producto clone() {
        try {
            return (Producto) super.clone();
        } catch (CloneNotSupportedException e) {         
            throw new RuntimeException(e);
        }
    }
	
	
//Metodos------------------------------------------------------------------------------------------------------
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Producto producto = (Producto) obj;
	    return id==producto.id;  // Asegúrate de que 'id' es único y comparable
	}

	@Override
	public int hashCode() {
	    return Objects.hash(id);  // Utiliza el mismo campo que en equals()
	}
	
	public void asignarPasilloYPonerEnTienda(Pasillo pasillo) {
        this.pasillo = pasillo;
        pasillo.getProductos().add(this);
    }

    public void asignarTienda(Tienda tienda) {
        this.tienda = tienda;
    }
	   
	public int cantidadProducto() {
	    	int cantidad=0;
	    	for (Pasillo i:getTienda().getPasillos()) {
				for (Producto j:i.getProductos()){
					if (j.equals(this)) {
						cantidad++;
					}
				}
			}
	    	return cantidad;
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
                if (cliente.mayorEdad() && producto.getEdades() == Edades.ADULTOS  ||  producto.getEdades() == Edades.MENORES ) {
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
        return nombre + "\t" + marca + "\t" + tamaño + "\t" + precio;
    }
	
//-------------------------------------------------------------------------------------------------------------
}
