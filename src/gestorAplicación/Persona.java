package gestorAplicación;

public class Persona {
//Atributos----------------------------------------------------------------------------------------------------
	
	private String nombre;
	private int id;
	private int edad;
//	private Tienda tienda;  decidir que va primero la persona o tienda 
	private String genero;

//-------------------------------------------------------------------------------------------------------------

//Getters and Setters------------------------------------------------------------------------------------------
	
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
	
	public Persona() {
		
	}
	
	public Persona(String nombre, int id, int edad, String genero) {
		this.nombre = nombre;
		this.id = id;
		this.edad = edad;
		
		this.genero = genero;
	}

//-------------------------------------------------------------------------------------------------------------

//Metodos------------------------------------------------------------------------------------------------------
		
	public boolean confirmarEdad(int edad) {
		if(edad >= 18) {
			return true;
		}else {
			return false;
		}
		
	}

//-------------------------------------------------------------------------------------------------------------
}
