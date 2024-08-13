package gestorAplicación.sujetos;

import gestorAplicación.servicios.Tienda;

public class Domiciliario extends Empleado{
	
	String vehiculo;
	//Contructores------------------------------------------------------------------------------------------------

	public Domiciliario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Domiciliario(String nombre, int id, int edad, String genero, double liquidacion, Tienda tienda,
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

}
