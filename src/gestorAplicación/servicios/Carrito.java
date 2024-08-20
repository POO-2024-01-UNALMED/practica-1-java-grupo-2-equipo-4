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
	private boolean pagado;
	private double precioTotal;
	//atributos para factura //
	private LocalDate fechaFacturacion;

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
	
	public LocalDate getFechaFacturacion() {
		return fechaFacturacion;
	}

	public void setFechaFacturacion(LocalDate fechaFacturacion) {
		this.fechaFacturacion = fechaFacturacion;
	}


	
	

//Contructores-------------------------------------------------------------------------------------------------
	

	public Carrito() {
		
	}
	
	Carrito(Date fechaFacturacion, Cliente cliente, boolean pagado, Tienda tienda) {
        this.productos = new ArrayList<>();
        this.fechaFacturacion = LocalDate.now();
        this.cliente = cliente;
        this.pagado = pagado;
        this.tienda = tienda;
    }
	
	
	public Carrito(Tienda tienda) {
		tienda.getFacturas().add(this);
	}
	
	
	public Carrito(Cliente cliente, Tienda tienda, Edades tipoCarrito) {
		this.cliente = cliente;
		this.tienda = tienda;
		this.tipoCarrito = tipoCarrito;
		this.fechaFacturacion = LocalDate.now();		
	}

	
	
	
	
//-------------------------------------------------------------------------------------------------------------
	
//Metodos------------------------------------------------------------------------------------------------------
	
	

	public StringBuilder agregarAlCarrito(Producto seleccionado, int cantidad) {
		int tamañoMaximo;
		double montoActual=0;
		for(Producto z:productos) {
			montoActual+=z.getPrecio();
		}
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
		if (cliente.getDinero()-montoActual-((seleccionado.getPrecio())*cantidad)<0) {
			if (cantidad==1){
				return new StringBuilder("Producto no agregado, ya no tienes dinero para agregar este producto");
			}
			return new StringBuilder("Productos no agregados, ya no tienes dinero para agregar estos productos");
		}
		
		if (cliente.getTienda().cantidadProducto(seleccionado)<cantidad) {
			return new StringBuilder("Productos no agregados, no hay cantidad de productos suficientes, le podemos ofrecer"
					+"\n"+seleccionado.cantidadProducto()+" productos de ese tipo solamente");
		}
		for (int i = 0; i < cantidad; i++) {
		    // Obtener la tienda y el pasillo
		    Tienda tienda = this.tienda;
		    Pasillo pasillo = seleccionado.getPasillo();  // Obtener el pasillo del producto seleccionado

		    // Buscar el pasillo en la tienda que coincida con el pasillo del producto seleccionado
		    for (Pasillo p : tienda.getPasillos()) {
		        if (p.equals(pasillo)) {
		            pasillo = p;
		            break;  // Salir del bucle una vez encontrado el pasillo
		        }
		    }

		    // Ahora que tienes el pasillo correcto, intenta eliminar el producto
		    if (pasillo.getProductos().remove(seleccionado)) {
		        productos.add(seleccionado.clone());  // Agregar el producto eliminado a la lista de productos
		    } else {
		        // Si no se pudo eliminar (por ejemplo, si ya no queda ninguna instancia), terminar el bucle
		        break;
		    }
		}
		return new StringBuilder("Producto/Productos "+seleccionado.getNombre()+" agregado con exito a su carrito");
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
	
	public void eliminarProductos(Producto seleccionado, int cantidad) {
        Tienda tienda = this.tienda; // Obtener la tienda asociada al carrito
        Pasillo pasillo = seleccionado.getPasillo(); // Obtener el pasillo original del producto seleccionado
        
        // Buscar el pasillo en la tienda que coincida con el pasillo del producto seleccionado
        for (Pasillo p : tienda.getPasillos()) {
            if (p.equals(pasillo)) {
                pasillo = p;
                break; // Salir del bucle una vez encontrado el pasillo
            }
        }

        // Eliminar los productos del carrito y agregarlos al pasillo
        for (int i = 0; i < cantidad; i++) {
            if (productos.remove(seleccionado)) { // Eliminar producto del carrito
                pasillo.getProductos().add(seleccionado.clone()); // Agregar producto clonado al pasillo
            } else {
                System.out.println("No hay suficientes productos en el carrito para eliminar.");
                break; // Si no se pudo eliminar, salir del bucle
            }
        }
    }

	
	 public static double calcularTotal(ArrayList<Producto> carrito) {
        double total = 0;
        for (Producto producto : carrito) {
            total += producto.getPrecio();
        }
        return total;
      }
	}
	// metodos para factura //

    
    public String generarDetallesFactura(double descuentoMembresia, boolean ganoJuego) {
        StringBuilder detalles = new StringBuilder();
        detalles.append("Factura:\n");
        detalles.append("+-----+--------------------+---------------+----------+------------+----------+\n");
        detalles.append("| No. | Producto           | Marca         | Tamaño   | Categoría  | Precio   |\n");
        detalles.append("+-----+--------------------+---------------+----------+------------+----------+\n");

        int numeroProducto = 1;
        for (Producto producto : productos) {
            detalles.append(String.format("| %-3d | %-18s | %-13s | %-8s | %-10s | %-8.2f |\n",
                numeroProducto,
                producto.getNombre(),
                producto.getMarca(),
                producto.getTamaño().getTamaño(),
                producto.getCategoria().getTexto(),
                producto.getPrecio()
            ));
            numeroProducto++;
        }
        detalles.append("+-----+--------------------+---------------+----------+------------+----------+\n");

        // Mostrar descuentos
        detalles.append(String.format("Descuento por membresía: %.2f%%\n", descuentoMembresia * 100));
        if (ganoJuego) {
            detalles.append("Descuento adicional por ganar el juego: 10%\n");
        }

        detalles.append(String.format("Precio final: %.2f\n", precioTotal * (1 - descuentoMembresia) * (ganoJuego ? 0.9 : 1.0)));
        return detalles.toString();
    }
    
    	
    
    public void eliminarCarrito() {
        // Devolver los productos al inventario
        for (Producto producto : productos) {
            // Asumimos que existe un método en la clase Tienda para devolver productos
            producto.getPasillo().getProductos().add(producto);
        }
        // Eliminar el carrito
        productos.clear();
        precioTotal = 0.0;
        pagado = false;
    }
    
    public void incrementarCosto(double numero) {
    	precioTotal+=numero;
    }
	
}	
	
	
//-------------------------------------------------------------------------------------------------------------

