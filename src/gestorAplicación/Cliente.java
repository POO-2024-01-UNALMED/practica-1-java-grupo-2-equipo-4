package gestorAplicación;

public class Cliente extends Persona {
	
	public boolean mayorEdad() {
		int edadCliente = getEdad();
		if (edadCliente<18 ) {
			return false;
		} else {
			return true;
		}
	}


}
