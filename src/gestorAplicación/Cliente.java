package gestorAplicación;

public class Cliente extends Persona {
//Atributos----------------------------------------------------------------------------------------------------
	private TipoEdad membresia;
	private float dinero;
	private Carrito carrito;
	
//-------------------------------------------------------------------------------------------------------------
	
//Getters and Setters------------------------------------------------------------------------------------------
	
	public Carrito getCarrito() {
		return carrito;
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
