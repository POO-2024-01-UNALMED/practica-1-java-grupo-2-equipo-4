package gestorAplicación.sujetos;
import gestorAplicación.servicios.Enums.Genero;
import gestorAplicación.servicios.Tienda;

public class Cajero extends Empleado {
	//Contructores------------------------------------------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Cajero() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cajero(String nombre, int id, int edad, Genero genero, double liquidacion, Tienda tienda,
			boolean prestacionSalud, boolean prestacionPension) {
		super(nombre, id, edad, genero, liquidacion, tienda, prestacionSalud, prestacionPension);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void buscoChamba() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected double cantidadPago() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean validarCriterios() {
		return false;
	}

	@Override
	public StringBuilder imprimirFacturas(Persona cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StringBuilder imprimirFacturas(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

}
