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
	
	public Carrito() {
		
	}
//-------------------------------------------------------------------------------------------------------------
	
//Metodos------------------------------------------------------------------------------------------------------
	
	public StringBuilder agregarAlCarrito(Producto seleccionado, int cantidad) {
		int tamañoMaximo;
		if (tipoCarrito==Edades.ADULTOS) {
			tamañoMaximo=15;
		}
		else {
			tamañoMaximo=5;
		}
		if (!cliente.mayorEdad() && seleccionado.getEdades()==Edades.ADULTOS) {
			return new StringBuilder("Producto no agregado, no tienes la edad valida para este producto");
		}
		if (productos.size()>=tamañoMaximo) {
			return new StringBuilder("Producto no agregado, ya no tienes espacio en el carrito");
		}
		if (cliente.getDinero()-(seleccionado.getPrecio())*cantidad<0) {
			if (cantidad==1){
				return new StringBuilder("Producto no agregado, ya no tienes dinero para agregar este producto");
			}
			return new StringBuilder("Productos no agregados, ya no tienes dinero para agregar estos productos");
		}
		
		if (seleccionado.cantidadProducto()<cantidad) {
			return new StringBuilder("Productos no agregados, no hay cantidad de productos suficientes, le podemos ofrecer"
					+"\n"+seleccionado.cantidadProducto()+" productos de ese tipo solamente");
		}
		for(int i=0;i<cantidad;i++) {
				productos.add(seleccionado);
				for(Pasillo k:cliente.getTienda().getPasillos()) {
					k.getProductos().remove(seleccionado);
				}
		}
		return new StringBuilder("Producto "+seleccionado.getNombre()+" agregado con exito a su carrito");
	}
	
//-------------------------------------------------------------------------------------------------------------
}
