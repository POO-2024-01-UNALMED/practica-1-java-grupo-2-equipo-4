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

    Factura() {
        this.fechaFacturacion = LocalDate.now();
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void imprimirFactura() {
        System.out.println("Fecha de Facturación: " + fechaFacturacion);
        System.out.println("Productos:");
        System.out.println("Nombre\tTamaño\tPrecio\tCantidad");

        // Usar un mapa para contar la cantidad de cada producto
        Map<String, Integer> contadorProductos = new HashMap<>();

        for (Producto producto : productos) {
            String clave = producto.getNombre() + "\t" + producto.getTamaño() + "\t" + producto.getPrecio();
            contadorProductos.put(clave, contadorProductos.getOrDefault(clave, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : contadorProductos.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Factura factura = new Factura();

     
        factura.imprimirFactura();
    }

}
