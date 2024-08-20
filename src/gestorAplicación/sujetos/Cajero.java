package gestorAplicación.sujetos;
import java.io.Serializable;

import gestorAplicación.servicios.Enums.Genero;
import gestorAplicación.servicios.Enums.TipoEmpleado;
import gestorAplicación.servicios.Tienda;

public class Cajero extends Empleado implements Serializable{
//Contructores------------------------------------------------------------------------------------------------
	private static final long serialVersionUID = 1L;

	public Cajero() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cajero(String nombre, int id, int edad, Genero genero, double liquidacion, Tienda tienda,
			boolean prestacionSalud, boolean prestacionPension) {
		super(nombre, id, edad, genero, liquidacion, tienda, prestacionSalud, prestacionPension,TipoEmpleado.CAJERO);
		Tienda.getDesempleados().add(this);
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
		if((this.experiencia>=2)&&this.getEdad()<=25){
			return true;
		}else {
			return false;
		}
	}
	
}
