package gestorAplicación;

public class Cliente extends Persona {
//Atributos----------------------------------------------------------------------------------------------------
	
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
	//nota: error porque borre tienda de persona,
	//esto causaba problemas al crear una tienda con dueño y un dueño con tienda
	//en el main uno se debe crear primero como parametro del otro att jordan 
	
	public Cliente(String nombre, int id, int edad, Tienda tienda, String genero, float dinero, Carrito carrito) {
		super(nombre, id, edad, tienda, genero);
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
