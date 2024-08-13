package gestorAplicación.sujetos;

import gestorAplicación.servicios.Tienda;

public class Persona {
//Atributos----------------------------------------------------------------------------------------------------
	
	private String nombre;
	private int id;
	private int edad;
	private String genero;
	private Tienda tienda;

//-------------------------------------------------------------------------------------------------------------

//Getters and Setters------------------------------------------------------------------------------------------
	
	public Tienda getTienda() {
		return tienda;
	}
	
	public void setTienda(Tienda tienda) {
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

	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero=genero;
	}
	
//-------------------------------------------------------------------------------------------------------------

//Contructores-------------------------------------------------------------------------------------------------
	
	protected Persona() {
		
	}
	
	protected Persona(String nombre, int id, int edad, String genero) {
		this.nombre = nombre;
		this.id = id;
		this.edad = edad;
		this.genero = genero;
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
