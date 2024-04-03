package gestorAplicación;

public class Persona {
	private String nombre;
	private int id;
	private int edad;
	private Tienda tienda;
	private String genero;
	
	public Persona() {
	}
	
	public Persona(String nombre, int id, int edad, Tienda tienda, String genero) {
		this.nombre = nombre;
		this.id = id;
		this.edad = edad;
		this.tienda = tienda;
		this.genero = genero;
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
	
	public Tienda getTienda() {
		return tienda;
	}
	
	public void setTienda(Tienda tienda) {
		this.tienda=tienda;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero=genero;
	}
	
}
