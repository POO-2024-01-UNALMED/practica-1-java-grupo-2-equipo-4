package gestorAplicación;
import java.util.*;


public class Pasillo {
//Atributos----------------------------------------------------------------------------------------------------
	
	private String nombre;
	private ArrayList<Producto> productos=new ArrayList<Producto>();
	private Categoria categoria;
	
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
	
//-------------------------------------------------------------------------------------------------------------

//Constructores------------------------------------------------------------------------------------------------
	
	public Pasillo(String nombre, Categoria categoria) {
		this.nombre = nombre;
		this.categoria = categoria;
	}
	
	public Pasillo(String nombre, ArrayList<Producto> productos, Categoria categoria) {
		this.nombre = nombre;
		this.productos = productos;
		this.categoria = categoria;
	}

//-------------------------------------------------------------------------------------------------------------

//Metodos------------------------------------------------------------------------------------------------------
	
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

//-------------------------------------------------------------------------------------------------------------
}
 