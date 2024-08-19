package gestorAplicación.sujetos;

import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicación.servicios.Carrito;
import gestorAplicación.servicios.Enums;
import gestorAplicación.servicios.Enums.Edades;
import gestorAplicación.servicios.Enums.Genero;
import gestorAplicación.servicios.Producto;
import gestorAplicación.servicios.Tienda;

public class Cliente extends Persona implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = -6750540194444988134L;
//Atributos----------------------------------------------------------------------------------------------------
	
	private Edades membresia;
	private Tienda tienda;
	private float dinero;
	private Carrito carrito;
	private ArrayList <Carrito> facturas= new ArrayList<Carrito>();

	
//-------------------------------------------------------------------------------------------------------------
	
//Getters and Setters------------------------------------------------------------------------------------------
	
	public Carrito getCarrito() {
		return carrito;
	}	

	public Tienda getTienda() {
		return this.tienda;
	}


	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}


	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}
	
	public float getDinero() {
		return dinero;
	}
	
	public void setDinero(float dinero) {
		this.dinero=dinero;
	}
	
	public ArrayList<Carrito> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<Carrito> facturas) {
		this.facturas = facturas;
	}

	
	
//-------------------------------------------------------------------------------------------------------------
	
//Constructores------------------------------------------------------------------------------------------------
	
	public Cliente() {
	}
	
	public Cliente(String nombre, int id, int edad, Genero genero, float dinero, Carrito carrito) {
		super(nombre, id, edad,genero);
		this.dinero = dinero;
		this.carrito = carrito;
		super.getPersonas().add(this);
	}

//-------------------------------------------------------------------------------------------------------------

//Metodos------------------------------------------------------------------------------------------------------
	
	public Cliente(String nombre, int p, int edad, Genero genero1) {
		super(nombre, p, edad, genero1);
	}

	
	
	public static int existeCliente(String nombre) {
		int contador=0;
		for (Persona i:getPersonas()) {
			if (i.getNombre()==nombre) {
				return contador;
			}
			contador++;
		}
		return -1;
	}
	
	public StringBuilder imprimirFacturas(Persona cliente) {
		StringBuilder texto=new StringBuilder();
		int contador=1;
		if(cliente.getTiendas().size()==0) {
			texto.append("Usted no tiene ninguna tienda a la que revisarle facturas");
			return texto;
		}
		for(Tienda i: cliente.getTiendas()) {
			texto.append("Estos son los productos que ha vendido su tienda\n");
			if(i.getProductosVendidos().size()==0) {
				texto.append("Su tienda no ha vendido ningun producto");
			}
			else {
			for(Producto p:i.getProductosVendidos()) {
				texto.append(p.toString()+"\n");
			}
			}
			texto.append("Estas son las facturas que ha pagado usted a los proveedores\n");
			if(i.getProductosComprados().size()==0) {
				texto.append("Su tienda no ha pedido ningun producto del proveedor");
			}
			else {
			for(Carrito c:i.getProductosComprados()) {
				if(c.isPagado()) {
				texto.append("Factura del proveedor "+c.getProveedor().getNombre()+" con "+c.getProductos().size()+" productos PAGADA\n");
				}
			}
			for(Carrito c:i.getProductosComprados()) {
				if(!c.isPagado()) {
				texto.append(contador+". Factura del proveedor "+c.getProveedor().getNombre()+" con "+c.getProductos().size()+" productos NO PAGADA\n");
				}
				contador++;
			}
			}
		}
		return texto;
	}
	
	public StringBuilder imprimirFacturas(Cliente cliente) {
		StringBuilder texto=new StringBuilder();
		int contador=1;
		for(Carrito i:cliente.getFacturas()) {
			texto.append("Estas son las facturas que ha pagado usted\n");
			if(i.isPagado()) {
				texto.append(contador+". Factura de la tienda "+i.getTienda().getNombre()+" con "+i.getProductos().size()+" productos\n");
			}
			contador++;
		}
		contador=1;
		for(Carrito i:cliente.getFacturas()) {
			texto.append("Estas son las facturas sin pagar\n");
			if(!i.isPagado()) {
				texto.append(contador+". Factura de la tienda "+i.getTienda().getNombre()+" con "+i.getProductos().size()+" productos\n");
			}
			contador++;
		}
		return texto;
	}

//-------------------------------------------------------------------------------------------------------------
}
