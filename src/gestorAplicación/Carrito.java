package gestorAplicación;
import java.util.*;

import gestorAplicación.Enums.Edades;

public class Carrito {
//Atributos----------------------------------------------------------------------------------------------------
	
	private ArrayList <Producto> productos=new ArrayList<Producto>();
	private Cliente cliente;
	private Tienda tienda;
	private Edades tipoCarrito;
	private double montoTotal;
	
//-------------------------------------------------------------------------------------------------------------
	
//Getters and Setters------------------------------------------------------------------------------------------
	
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	
	public void setProductos(ArrayList<Producto> productos) {
		this.productos=productos;
	}
	
	public Persona getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente=cliente;
	}
	
	public Tienda getTienda() {
		return tienda;
	}
	
	public void setTienda(Tienda tienda) {
		this.tienda=tienda;
	}
	public Edades getTipoCarrito() {
		return tipoCarrito;
	}
	
	public void setTipoCarrito(Edades tipo) {
		this.tipoCarrito=tipo;
	}
	
	public double getMontoTotal() {
		return montoTotal;
	}
	
	public void  setMontoTotal(double monto) {
		this.montoTotal= monto;
	}
	
//Contructores-------------------------------------------------------------------------------------------------
	
//-------------------------------------------------------------------------------------------------------------
	
//Metodos------------------------------------------------------------------------------------------------------
	
//-------------------------------------------------------------------------------------------------------------
}
