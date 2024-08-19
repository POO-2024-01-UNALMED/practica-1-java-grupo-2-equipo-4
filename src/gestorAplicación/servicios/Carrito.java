package gestorAplicación.servicios;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import gestorAplicación.servicios.Enums.Edades;
import gestorAplicación.sujetos.Cliente;
import gestorAplicación.sujetos.Persona;

public class Carrito implements Serializable{
//Atributos----------------------------------------------------------------------------------------------------
	
	private ArrayList <Producto> productos=new ArrayList<Producto>();
	private Cliente cliente;
	private Tienda tienda;
	private Edades tipoCarrito;
	private Proveedor proveedor;
//	private double montoTotal;
	private boolean pagado;
	

	//atributos para factura //
	 LocalDate fechaFacturacion;
	 ArrayList<Producto> productosFactura;

	

	private static final long serialVersionUID = 834939881526017922L;

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
	
//	public double getMontoTotal() {
//		return montoTotal;
//	}
//	
//	public void  setMontoTotal(double monto) {
//		this.montoTotal= monto;
//	}
	
//Contructores-------------------------------------------------------------------------------------------------
	
	public Carrito() {
		
	}
	
	public Carrito(Tienda tienda) {
		tienda.getCarritos().add(this);
	}
	
	
	public Carrito(Cliente cliente, Tienda tienda, Edades tipoCarrito) {
		this.cliente = cliente;
		this.tienda = tienda;
		this.tipoCarrito = tipoCarrito;
		this.fechaFacturacion = LocalDate.now();		
	}

	
	public LocalDate getFechaFacturacion() {
		return fechaFacturacion;
	}

	public void setFechaFacturacion(LocalDate fechaFacturacion) {
		this.fechaFacturacion = fechaFacturacion;
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
		if (cliente.getDinero()-(cliente.getTienda().cantidadProducto(seleccionado))*cantidad<0) {
			if (cantidad==1){
				return new StringBuilder("Producto no agregado, ya no tienes dinero para agregar este producto");
			}
			return new StringBuilder("Productos no agregados, ya no tienes dinero para agregar estos productos");
		}
		
		if (cliente.getTienda().cantidadProducto(seleccionado)<cantidad) {
			return new StringBuilder("Productos no agregados, no hay cantidad de productos suficientes, le podemos ofrecer"
					+"\n"+seleccionado.cantidadProducto()+" productos de ese tipo solamente");
		}
		for(int i=0;i<cantidad;i++) {
				productos.add(seleccionado);
				seleccionado.getPasillo().getProductos().remove(seleccionado);
		}
		return new StringBuilder("Producto "+seleccionado.getNombre()+" agregado con exito a su carrito");
	}
	
	public int contarRepeticiones(Producto productoBuscado) {
        int contador = 0;

        for (Producto producto : productos) {
            if (producto.equals(productoBuscado)) {
                contador++;
            }
        }

        return contador;
    }
	
	public void eliminarProductos(Producto producto, int cantidad) {
        int eliminados = 0;

        // Crear una copia de la lista de productos para evitar ConcurrentModificationException
        ArrayList<Producto> productosParaEliminar = new ArrayList<>();

        // Agregar los productos que se van a eliminar a una lista temporal
        for (Producto p : productos) {
            if (p.equals(producto) && eliminados < cantidad) {
                productosParaEliminar.add(p);
                eliminados++;
                if (eliminados >= cantidad) {
                    break;
                }
            }
        }

        // Eliminar los productos de la lista original
        productos.removeAll(productosParaEliminar);
        for (Pasillo pasillo : tienda.getPasillos()) {
            if (pasillo.getCategoria().equals(producto.getCategoria())) {
                // Agregar los productos eliminados al pasillo
                pasillo.getProductos().addAll(productosParaEliminar);
                break; // Asumimos que solo hay un pasillo por categoría
            }
        }
    }
	
	static double calcularTotal(ArrayList<Producto> carrito) {
        double total = 0;
        for (Producto producto : carrito) {
            total += producto.getPrecio();
        }
        return total;
    }
	
	
	
	
	
//-------------------------------------------------------------------------------------------------------------
}
