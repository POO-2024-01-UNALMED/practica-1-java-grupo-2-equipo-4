package gestorAplicación.sujetos;

import java.io.Serializable;

import gestorAplicación.servicios.Tienda;
import gestorAplicación.servicios.Enums.Genero;
import gestorAplicación.servicios.Enums.TipoEmpleado;

public class Conserje extends Empleado implements Serializable {

	
	private static final long serialVersionUID = -8101559432401102040L;
	
	public Conserje(String nombre, int id, int edad, Genero genero, double liquidacion, Tienda tienda,
			boolean prestacionSalud, boolean prestacionPension) {
		super(nombre, id, edad, genero, liquidacion, tienda, prestacionSalud, prestacionPension,TipoEmpleado.CONSERJE);
		Tienda.getDesempleados().add(this);
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
