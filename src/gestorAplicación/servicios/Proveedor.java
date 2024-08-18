package gestorAplicación.servicios;


import java.util.*;

import gestorAplicación.servicios.Enums.Categoria;

import java.io.Serializable;

public class Proveedor implements Serializable{
//Atributos----------------------------------------------------------------------------------------------------
	
	private String nombre;
	private ArrayList<Producto> entrega=new ArrayList<Producto>();
	private Enums.Categoria tipo;
	private ArrayList<Tienda> tiendas;
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
	
	public Enums.Categoria getTipo() {
		return tipo;
	}
	
	public void setTipo(Enums.Categoria tipo) {
		this.tipo=tipo;
	}
	
	public ArrayList<Tienda> getTienda() {
		return this.tiendas;
	}
	
	public void setTienda(ArrayList<Tienda> tiendas) {
		this.tiendas=tiendas;
	}
	
	public ArrayList <Pasillo> getPasillos() {
		return pasillos;
	}
	
	public void setPasillos(ArrayList<Pasillo> pasillos) {
		this.pasillos=pasillos;
	}

//-------------------------------------------------------------------------------------------------------------

//Constructores------------------------------------------------------------------------------------------------

	public Proveedor(String nombre, ArrayList<Producto> entrega, Categoria tipo, ArrayList<Tienda> tiendas, ArrayList <Pasillo> pasillos) {
	super();
	this.nombre = nombre;
	this.entrega = entrega;
	this.tipo = tipo;
	this.tiendas = tiendas;
	Tienda.getProveedores().add(this);
	this.pasillos = pasillos;
}
//-------------------------------------------------------------------------------------------------------------
	
//Metodos------------------------------------------------------------------------------------------------------

	public void informarRebastecimiento(Producto producto) {
		
	}
	
	public void imprimirProveedores(ArrayList<Proveedor> proveedores) {
        System.out.println("Lista de Proveedores:");
        int contador = 1;
        for (Proveedor proveedor : proveedores) {
            System.out.println(contador + ". " + proveedor);
            contador++;
        }
    }
	
	
	public String toString(){
		return this.nombre+"con categoria"+this.tipo;
	}

// metodo scanner y print -----------------------------------------------------------------------------------------

//-------------------------------------------------------------------------------------------------------------
}



