package gestorAplicación.sujetos;

import java.io.Serializable;

import gestorAplicación.servicios.Enums.Genero;
import gestorAplicación.servicios.Tienda;

public class Domiciliario extends Empleado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1708181192964755820L;
	String vehiculo;
	boolean licencia;
	//Contructores------------------------------------------------------------------------------------------------

	public Domiciliario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Domiciliario(String nombre, int id, int edad, Genero genero, double liquidacion, Tienda tienda,
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
		if(this.licencia!=false) {
			return true;
		}
		else {
			return false;
		}
	}
}
