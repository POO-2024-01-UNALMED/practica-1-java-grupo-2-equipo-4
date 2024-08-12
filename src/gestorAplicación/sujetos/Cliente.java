package gestorAplicación.sujetos;

import java.util.ArrayList;

import gestorAplicación.servicios.Carrito;
import gestorAplicación.servicios.Enums;
import gestorAplicación.servicios.Enums.Edades;
import gestorAplicación.servicios.Tienda;

public class Cliente extends Persona {
//Atributos----------------------------------------------------------------------------------------------------
	private Enums.Edades membresia;
	private float dinero;
	private Carrito carrito;
	private ArrayList <Carrito> facturas= new ArrayList<Carrito>();
	private static ArrayList <Cliente> clientes= new ArrayList<Cliente>();
	
//-------------------------------------------------------------------------------------------------------------
	
//Getters and Setters------------------------------------------------------------------------------------------
	
	public Carrito getCarrito() {
		return carrito;
	}
	
	public void setTienda(Tienda tienda) {
		super.setTienda(tienda);
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

	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public static void setClientes(ArrayList<Cliente> clientes) {
		Cliente.clientes = clientes;
	}
	
//-------------------------------------------------------------------------------------------------------------
	
//Constructores------------------------------------------------------------------------------------------------
	
	public Cliente() {
	}
	
	public Cliente(String nombre, int id, int edad, String genero, float dinero, Carrito carrito) {
		super(nombre, id, edad,genero);
		this.dinero = dinero;
		this.carrito = carrito;
	}

//-------------------------------------------------------------------------------------------------------------

//Metodos------------------------------------------------------------------------------------------------------
	
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

//-------------------------------------------------------------------------------------------------------------
}
