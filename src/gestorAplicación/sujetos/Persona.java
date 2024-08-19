package gestorAplicación.sujetos;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Map;

import gestorAplicación.servicios.Enums.Genero;
import gestorAplicación.servicios.Carrito;
import gestorAplicación.servicios.Tienda;
//import gestorAplicación.servicios.Factura;
import static gestorAplicación.servicios.Enums.Genero;

public abstract class Persona implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -9139003303968753009L;
//Atributos----------------------------------------------------------------------------------------------------
	
	private String nombre;
	private int id;
	private int edad;
	private Genero genero;
	private ArrayList<Tienda> tiendas=new ArrayList<Tienda>();
	private static ArrayList <Persona> personas=new ArrayList<Persona>();
	
	// estaba en cliente pero identificar usuario es clase Persona //
//	private ArrayList <Factura> facturas= new ArrayList<>();

//-------------------------------------------------------------------------------------------------------------

//Getters and Setters------------------------------------------------------------------------------------------
	
	

	public static ArrayList<Persona> getPersonas() {
		return personas;
	}
	public static void setPersonas(ArrayList<Persona> persona) {
		personas = persona;
	}
//	public ArrayList<Factura> getFacturas1() {
//		return facturas;
//	}

	
	
//	public void setFacturas1(ArrayList<Factura> facturas) {
//		this.facturas = facturas;
//	}


	
	public ArrayList<Tienda> getTiendas() {
		return tiendas;
	}
	
	public  void setTiendas(ArrayList<Tienda> tienda) {
		this.tiendas=tienda;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad=edad;
	}

	public Genero getGenero() {
		return genero;
	}
	
	public void setGenero(Genero genero) {
		this.genero=genero;
	}
	
//-------------------------------------------------------------------------------------------------------------

//Contructores-------------------------------------------------------------------------------------------------
	
	public Persona() {
		
	}
	
	public Persona(String nombre, int id, int edad, Genero genero) {
		this.nombre = nombre;
		this.id = id;
		this.edad = edad;
		this.genero = genero;
		Persona.getPersonas().add(this);
	}
	
	
//-------------------------------------------------------------------------------------------------------------

//Metodos------------------------------------------------------------------------------------------------------
		
	abstract public StringBuilder obtenerContadorProductos(Persona cliente);
	
	abstract public Map<String, Integer> obtenerContadorProductos(Cliente cliente);
	
	public boolean mayorEdad() {
		int edadCliente = getEdad();
		if (edadCliente<18) {
			return false;
		} else {
			return true;
		}
	}
	

//-------------------------------------------------------------------------------------------------------------
}
