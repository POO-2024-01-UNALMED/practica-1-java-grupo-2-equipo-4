package gestorAplicación.servicios;
import java.io.Serializable;
import java.util.*;

import gestorAplicación.servicios.Enums.Edades;
import gestorAplicación.sujetos.Cliente;
import gestorAplicación.sujetos.Persona;

public class Carrito implements Serializable{
//Atributos----------------------------------------------------------------------------------------------------
	private static final long serialVersionUID = 834939881526017922L;
	private ArrayList <Producto> productos=new ArrayList<Producto>();
	private Cliente cliente;
	private Proveedor proveedor;
	private Tienda tienda;
	private Edades tipoCarrito;
	private double montoTotal;
	private boolean pagado;
	
//-------------------------------------------------------------------------------------------------------------
	
//Getters and Setters------------------------------------------------------------------------------------------

	
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	
	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
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
	
	public Carrito(Tienda tienda) {
		tienda.getCarritos().add(this);
	}
//-------------------------------------------------------------------------------------------------------------
	
//Metodos------------------------------------------------------------------------------------------------------
	
//-------------------------------------------------------------------------------------------------------------
}
