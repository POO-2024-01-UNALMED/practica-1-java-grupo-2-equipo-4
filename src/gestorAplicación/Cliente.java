package gestorAplicación;

public class Cliente extends Persona {
	private float dinero;
	private Carrito carrito;
	
	public Cliente() {
	}
	
	public Cliente(String nombre, int id, int edad, Tienda tienda, String genero, float dinero, Carrito carrito) {
		super(nombre, id, edad, tienda, genero);
		this.dinero = dinero;
		this.carrito = carrito;
	}

	public float getDinero() {
		return dinero;
	}
	
	public void setDinero(float dinero) {
		this.dinero=dinero;
	}
	
	public boolean mayorEdad() {
		int edadCliente = getEdad();
		if (edadCliente<18 ) {
			return false;
		} else {
			return true;
		}
	}


}
