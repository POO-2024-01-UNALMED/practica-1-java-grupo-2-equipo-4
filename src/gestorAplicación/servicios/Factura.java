package gestorAplicación.servicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import gestorAplicación.servicios.*;
import gestorAplicación.sujetos.*;

public class Factura {
    LocalDate fechaFacturacion;
    ArrayList<Producto> productos;

    //constructor //
    
    Factura(Carrito carrito) {
    	
        this.fechaFacturacion = LocalDate.now();
        this.productos = new ArrayList<>(carrito.getProductos());
    }

    // getters and setters//
    
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public LocalDate getFechaFacturacion() {
        return fechaFacturacion;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
    
    //methods//

    public Map<String, Integer> obtenerContadorProductos() {
        Map<String, Integer> contadorProductos = new HashMap<>();

        for (Producto producto : productos) {
            String clave = producto.getNombre() + "\t" + producto.getTamaño() + "\t" + producto.getPrecio();
            contadorProductos.put(clave, contadorProductos.getOrDefault(clave, 0) + 1);
        }

        return contadorProductos;
    }
}
