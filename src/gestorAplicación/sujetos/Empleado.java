package gestorAplicación.sujetos;

import java.io.Serializable;
import java.util.Map;

import gestorAplicación.servicios.Enums.Genero;
import gestorAplicación.servicios.Enums.TipoEmpleado;
import gestorAplicación.servicios.Tienda;

public abstract class Empleado extends Persona implements Serializable{
//Atributos----------------------------------------------------------------------------------------------------
	
	private static final long serialVersionUID = 1006554030509380019L;
	protected double liquidacion;
	protected boolean prestacionSalud;
	protected boolean prestacionPension;
	protected int experiencia;
	private TipoEmpleado tipo;
	
//-------------------------------------------------------------------------------------------------------------

//Getters and Setters------------------------------------------------------------------------------------------
	
//-------------------------------------------------------------------------------------------------------------

//Constructores------------------------------------------------------------------------------------------------
	
	protected Empleado(){
		super();
	}
	
	protected Empleado(String nombre, int id, int edad, Genero genero, double liquidacion, Tienda tienda, 
			boolean prestacionSalud, boolean prestacionPension,TipoEmpleado tipo) {
		super(nombre, id, edad, genero);
		this.liquidacion=liquidacion;
		this.prestacionSalud=prestacionSalud;
		this.prestacionPension=prestacionPension;
		this.setTipo(tipo);
	}
	
//-------------------------------------------------------------------------------------------------------------
	
//Metodos------------------------------------------------------------------------------------------------------
	
	public TipoEmpleado getTipo() {
		return tipo;
	}

	public void setTipo(TipoEmpleado tipo) {
		this.tipo = tipo;
	}

	protected abstract void buscoChamba();
	protected abstract double cantidadPago();
	public abstract boolean validarCriterios();
	
	
	@Override
	public StringBuilder obtenerContadorProductos(Persona cliente) {
		StringBuilder texto=new StringBuilder();
		return texto.append("Su pago es de: "+this.cantidadPago());
	}
	@Override
	public Map<String, Integer> obtenerContadorProductos(Cliente cliente) {
		return null;
	}

//-------------------------------------------------------------------------------------------------------------
}
