package gestorAplicación.servicios;

import gestorAplicación.servicios.Enums.TipoCaja;
import gestorAplicación.sujetos.Cliente;
import gestorAplicación.sujetos.Empleado;
import java.io.Serializable;

public class Caja implements Serializable{
//Atributos----------------------------------------------------------------------------------------------------
	private Empleado empleado;
	private String nombre;
	private int estado=2;
	private Enums.TipoCaja tipo;
	private Tienda tienda;
	private String descuento;
	private Cliente cliente;
	
	private static final long serialVersionUID = 5268347727015736706L;
//-------------------------------------------------------------------------------------------------------------
//holi
	
//Getters and Setters------------------------------------------------------------------------------------------
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public int getEstado() {
		return estado;
	}
	
	public void setEstado(int estado) {
		this.estado=estado;
	}
	
	public Enums.TipoCaja getTipo() {
		return tipo;
	}
	
	public void setTipo(Enums.TipoCaja tipo) {
		this.tipo=tipo;
	}
	
	public Tienda getTienda() {
		return tienda;
	}
	
	public void setTienda(Tienda tienda) {
		this.tienda=tienda;
	}
	
	public String getDescuento() {
		return descuento;
	}
	
	public void setDescuento(String descuento) {
		this.descuento=descuento;		
		
	}
	
	public Empleado getEmpleado() {
		return empleado;
	}
	
	public void setEmpleado(Empleado empleado) {
		this.empleado=empleado;
	}

//-------------------------------------------------------------------------------------------------------------

//Constructores------------------------------------------------------------------------------------------------
	
	public Caja(){
		
	}
	
	public Caja(String nombre, Enums.TipoCaja tipo, Tienda tienda){
		this.nombre=nombre;
		this.tipo=tipo;
		this.tienda=tienda;
		tienda.getCajas().add(this);
	}

//Metodos------------------------------------------------------------------------------------------------------
	
//-------------------------------------------------------------------------------------------------------------
}
