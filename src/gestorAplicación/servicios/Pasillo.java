package gestorAplicación.servicios;
import java.util.*;

import gestorAplicación.servicios.Enums.Categoria;

import java.io.Serializable; 

public class Pasillo implements Serializable{
//Atributos----------------------------------------------------------------------------------------------------
	
	private String nombre;
	private ArrayList<Producto> productos=new ArrayList<Producto>();
	private Categoria categoria;
	private Tienda tienda;
//	private ArrayList <Proveedor> proveedores=new ArrayList<Proveedor>();
	
	private static final long serialVersionUID = 1L;
//-------------------------------------------------------------------------------------------------------------

//Getters and Setters------------------------------------------------------------------------------------------
	
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
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Tienda getTienda() {
		return tienda;
	}
	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	
//-------------------------------------------------------------------------------------------------------------

//Constructores------------------------------------------------------------------------------------------------
	
	public Pasillo(String nombre, Categoria categoria) {
		this.nombre = nombre;
		this.categoria = categoria;
	}
	
	public Pasillo(String nombre, Categoria categoria,Tienda tienda) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.tienda = tienda;
		tienda.getPasillos().add(this);
	}
	
	
	
	public Pasillo(String nombre, ArrayList<Producto> productos, Categoria categoria, Tienda tienda) {
		this.nombre = nombre;
		this.productos = productos;
		this.categoria = categoria;
		this.tienda = tienda;
		tienda.getPasillos().add(this);
	}

//-------------------------------------------------------------------------------------------------------------

//Metodos------------------------------------------------------------------------------------------------------
	
	public void asignarTienda(Tienda tienda) {
        this.tienda = tienda;
        tienda.getPasillos().add(this);
    }
	
	public static int cantidadProducto(ArrayList<Producto> productos,int id) {
		int contador = 0;
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                contador++;
            }
        }

        return contador;
	}
	
	public static boolean verificarDisponibilidad(ArrayList<Producto> listaProductos, int id, int cantidadSolicitada) {
        int cantidad = cantidadProducto(listaProductos, id);
        return cantidadSolicitada <= cantidad;
    }

	public void agregarProducto(Producto producto) {
		getProductos().add(producto);
	}
	
//-------------------------------------------------------------------------------------------------------------
}
 
