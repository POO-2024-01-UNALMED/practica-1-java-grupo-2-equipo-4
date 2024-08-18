package gestorAplicación.sujetos;

import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicación.servicios.Enums.Genero;
import gestorAplicación.servicios.Tienda;
import static gestorAplicación.servicios.Enums.Genero;

public class Persona implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -9139003303968753009L;
//Atributos----------------------------------------------------------------------------------------------------
	private String nombre;
	private int id;
	private int edad;
	private Genero genero;
	private Tienda tienda;
	private static ArrayList <Persona > personas=new ArrayList<>();

//-------------------------------------------------------------------------------------------------------------

//Getters and Setters------------------------------------------------------------------------------------------
	
	

	public static ArrayList<Persona> getPersonas() {
		return personas;
	}

	public static void setPersonas(ArrayList<Persona> persona) {
		personas = persona;
	}
	
	public Tienda getTienda() {
			return tienda;
		}
	
	public  void setTienda(Tienda tienda) {
		this.tienda=tienda;
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
		personas.add(this);
	}
	
//-------------------------------------------------------------------------------------------------------------

//Metodos------------------------------------------------------------------------------------------------------
		
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
