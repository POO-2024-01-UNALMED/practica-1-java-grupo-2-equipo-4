package gestorAplicación.sujetos;

import java.io.Serializable;

import gestorAplicación.servicios.Tienda;

public abstract class Empleado extends Persona implements Serializable{
//Atributos----------------------------------------------------------------------------------------------------
	
	protected double liquidacion;
	protected Tienda tienda;
	protected boolean prestacionSalud;
	protected boolean prestacionPension;
	
//-------------------------------------------------------------------------------------------------------------

//Getters and Setters------------------------------------------------------------------------------------------
	
//-------------------------------------------------------------------------------------------------------------

//Constructores------------------------------------------------------------------------------------------------
	
	protected Empleado(){
		super();
	}
	
	protected Empleado(String nombre, int id, int edad, String genero, double liquidacion, Tienda tienda, 
			boolean prestacionSalud, boolean prestacionPension) {
		super(nombre, id, edad, genero);
		this.liquidacion=liquidacion;
		this.prestacionSalud=prestacionSalud;
		this.prestacionPension=prestacionPension;
	}
	
//-------------------------------------------------------------------------------------------------------------
	
//Metodos------------------------------------------------------------------------------------------------------
	
	protected abstract void buscoChamba();
	protected abstract double cantidadPago();

	public abstract boolean validarCriterios();
	
//-------------------------------------------------------------------------------------------------------------
}
