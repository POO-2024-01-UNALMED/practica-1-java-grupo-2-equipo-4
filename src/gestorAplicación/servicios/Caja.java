package gestorAplicación.servicios;

import gestorAplicación.servicios.Enums.TipoCaja;
import gestorAplicación.sujetos.Cajero;
import gestorAplicación.sujetos.Cliente;
import java.io.Serializable;

public class Caja implements Serializable{
//Atributos----------------------------------------------------------------------------------------------------
	
	private String nombre;
	private int estado=2;
	private TipoCaja tipo;
	private Tienda tienda;
	private Cajero cajero;
	private Cliente cliente;

	
	private static final long serialVersionUID = 5268347727015736706L;
//-------------------------------------------------------------------------------------------------------------
	
//Getters and Setters------------------------------------------------------------------------------------------
	
	public String getNombre() {
		return nombre;
	}
	
	public Cajero getCajero() {
		return cajero;
	}

	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
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
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente=cliente;
	}

//-------------------------------------------------------------------------------------------------------------

//Constructores------------------------------------------------------------------------------------------------
	
	public Caja(){
		
	}
	
	public Caja(String nombre, TipoCaja tipo, Tienda tienda){
		this.nombre=nombre;
		this.tipo=tipo;
		this.tienda=tienda;
		tienda.getCajas().add(this);
	}

//Metodos------------------------------------------------------------------------------------------------------
	
//-------------------------------------------------------------------------------------------------------------
}
