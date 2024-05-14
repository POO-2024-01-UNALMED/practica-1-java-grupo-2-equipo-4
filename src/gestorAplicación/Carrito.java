package gestorAplicación;

import java.util.*;

public class Carrito {
//Atributos----------------------------------------------------------------------------------------------------
	
	private ArrayList <Producto> productos=new ArrayList<Producto>();
	private Cliente cliente;
	private Tienda tienda;
	private TipoEdad tipoCarrito;
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
	public TipoEdad getTipoCarrito() {
		return tipoCarrito;
	}
	
	public void setTipoCarrito(TipoEdad tipo) {
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
