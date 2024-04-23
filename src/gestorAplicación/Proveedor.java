package gestorAplicación;

import java.util.*;

public class Proveedor {
//Atributos----------------------------------------------------------------------------------------------------
	
	private String nombre;
	private ArrayList<Producto> entrega=new ArrayList<Producto>();
	private Categoria tipo;
	private Tienda tienda;
	private Inventario inventario;

//-------------------------------------------------------------------------------------------------------------
	
//Getters and Setters------------------------------------------------------------------------------------------
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public ArrayList<Producto> getEntrega() {
		return entrega;
	}
	
	public void setEntrega(ArrayList<Producto> entrega) {
		this.entrega=entrega;
	}
	
	public Categoria getTipo() {
		return tipo;
	}
	
	public void setTipo(Categoria tipo) {
		this.tipo=tipo;
	}
	
	public Tienda getTienda() {
		return tienda;
	}
	
	public void setTienda(Tienda tienda) {
		this.tienda=tienda;
	}
	
	public Inventario getInventario() {
		return inventario;
	}
	
	public void setInventario(Inventario inventario) {
		this.inventario=inventario;
	}

//-------------------------------------------------------------------------------------------------------------

//Constructores------------------------------------------------------------------------------------------------

	public Proveedor(String nombre, ArrayList<Producto> entrega, Categoria tipo, Tienda tienda, Inventario inventario) {
	super();
	this.nombre = nombre;
	this.entrega = entrega;
	this.tipo = tipo;
	this.tienda = tienda;
	this.inventario = inventario;
}
//-------------------------------------------------------------------------------------------------------------
	
//Metodos------------------------------------------------------------------------------------------------------
	
	public Producto crearProducto(Tienda tienda,String nombre,Categoria categoria) {	
		Producto a1= new Producto(nombre,categoria);
		return a1;		
	}
	
	

	public void informarRebastecimiento(Producto producto) {
		
	}

//-------------------------------------------------------------------------------------------------------------
}
