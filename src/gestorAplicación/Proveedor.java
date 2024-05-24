package gestorAplicación;

import java.util.*;

public class Proveedor {
//Atributos----------------------------------------------------------------------------------------------------
	
	private String nombre;
	private ArrayList<Producto> entrega=new ArrayList<Producto>();
	private Categoria tipo;
	private Tienda tienda;
	private ArrayList <Pasillo> pasillos=new ArrayList<Pasillo>();

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
	
	public ArrayList <Pasillo> getPasillos() {
		return pasillos;
	}
	
	public void setPasillos(ArrayList<Pasillo> pasillos) {
		this.pasillos=pasillos;
	}

//-------------------------------------------------------------------------------------------------------------

//Constructores------------------------------------------------------------------------------------------------

	public Proveedor(String nombre, ArrayList<Producto> entrega, Categoria tipo, Tienda tienda, ArrayList <Pasillo> pasillos) {
	super();
	this.nombre = nombre;
	this.entrega = entrega;
	this.tipo = tipo;
	this.tienda = tienda;
	this.pasillos = pasillos;
}
//-------------------------------------------------------------------------------------------------------------
	
//Metodos------------------------------------------------------------------------------------------------------

	public void informarRebastecimiento(Producto producto) {
		
	}

//-------------------------------------------------------------------------------------------------------------
}
