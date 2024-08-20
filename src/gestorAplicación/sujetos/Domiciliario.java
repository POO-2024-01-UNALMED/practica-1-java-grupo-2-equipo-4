package gestorAplicación.sujetos;

import java.io.Serializable;
import java.util.Map;

import gestorAplicación.servicios.Enums.Genero;
import gestorAplicación.servicios.Enums.TipoEmpleado;
import gestorAplicación.servicios.Tienda;

public class Domiciliario extends Empleado implements Serializable{

	private static final long serialVersionUID = 1708181192964755820L;
	private String vehiculo;
	private boolean licencia;
	//Contructores------------------------------------------------------------------------------------------------

//	public Domiciliario() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	public Domiciliario(String nombre, int id, int edad, Genero genero, double liquidacion, Tienda tienda,
			double p ,boolean prestacionSalud, boolean prestacionPension,boolean licencia,String vehiculo) {
		super();
		this.vehiculo=vehiculo;
		this.licencia=licencia;
		Tienda.getDesempleados().add(this);
		// TODO Auto-generated constructor stub
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
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
		if((this.licencia==true)&&(this.getVehiculo()!=null)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
