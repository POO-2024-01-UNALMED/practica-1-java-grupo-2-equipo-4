package gestorAplicación.servicios;


import java.util.*;
import java.io.Serializable;

public class Proveedor implements Serializable{
//Atributos----------------------------------------------------------------------------------------------------
	
	private String nombre;
	private ArrayList<Producto> entrega=new ArrayList<Producto>();
	private Enums tipo;
	private Tienda tienda;
	private ArrayList <Pasillo> pasillos=new ArrayList<Pasillo>();
	private static final long serialVersionUID = 1L;
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
	
	public Enums getTipo() {
		return tipo;
	}
	
	public void setTipo(Enums tipo) {
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

	public Proveedor(String nombre, ArrayList<Producto> entrega, Enums tipo, Tienda tienda, ArrayList <Pasillo> pasillos) {
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

// metodo scanner y print -----------------------------------------------------------------------------------------

//-------------------------------------------------------------------------------------------------------------
}



