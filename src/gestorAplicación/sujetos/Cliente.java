package gestorAplicación.sujetos;

import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicación.servicios.Carrito;
import gestorAplicación.servicios.Enums;
import gestorAplicación.servicios.Enums.Edades;
import gestorAplicación.servicios.Enums.Genero;
import gestorAplicación.servicios.Tienda;

public class Cliente extends Persona implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = -6750540194444988134L;
//Atributos----------------------------------------------------------------------------------------------------
	
	private Edades membresia;
	private Tienda tienda;
	private float dinero;
	private Carrito carrito;
	private ArrayList <Carrito> facturas= new ArrayList<Carrito>();

	
//-------------------------------------------------------------------------------------------------------------
	
//Getters and Setters------------------------------------------------------------------------------------------
	
	public Carrito getCarrito() {
		return carrito;
	}	

	public Tienda getTienda() {
		return this.tienda;
	}


	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}


	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}
	
	public float getDinero() {
		return dinero;
	}
	
	public void setDinero(float dinero) {
		this.dinero=dinero;
	}
	
	public ArrayList<Carrito> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<Carrito> facturas) {
		this.facturas = facturas;
	}

	
	
//-------------------------------------------------------------------------------------------------------------
	
//Constructores------------------------------------------------------------------------------------------------
	
	public Cliente() {
	}
	
	public Cliente(String nombre, int id, int edad, Genero genero, float dinero, Carrito carrito) {
		super(nombre, id, edad,genero);
		this.dinero = dinero;
		this.carrito = carrito;
	}

//-------------------------------------------------------------------------------------------------------------

//Metodos------------------------------------------------------------------------------------------------------
	
	public Cliente(String nombre, int p, int edad, Genero genero1) {
		super(nombre, p, edad, genero1);
	}

	public static int existeCliente(String nombre) {
		int contador=0;
		for (Cliente i:clientes) {
			if (i.getNombre()==nombre) {
				return contador;
			}
			contador++;
		}
		return -1;
	}
	
	public StringBuilder imprimirFacturas(Persona cliente) {
		StringBuilder texto=new StringBuilder();
		
	}
	
	public StringBuilder imprimirFacturas(Cliente cliente) {
		StringBuilder texto=new StringBuilder();
		int contador=1;
		for(Carrito i:cliente.getFacturas()) {
			if(!i.isPagado()) {
				texto.append(contador+". Factura de la tienda "+i.getTienda().getNombre()+" con "+i.getProductos().size()+" productos\n");
			}
			contador++;
		}
		return texto;
	}

//-------------------------------------------------------------------------------------------------------------
}
