package uiMain;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import gestorAplicación.servicios.*;
import gestorAplicación.sujetos.*;
import java.util.Scanner;

import gestorAplicación.servicios.Producto;
import gestorAplicación.servicios.Tienda;
import gestorAplicación.servicios.Factura;
import gestorAplicación.servicios.Enums.Categoria;
import gestorAplicación.sujetos.Cliente;
import gestorAplicación.sujetos.Persona;

import static uiMain.Main.print;
import static uiMain.Main.escaner;
import static uiMain.Main.lineas;

public class Funcionalidad3 extends Identidad {
	
	public static void mostrarFacturas() {
		Persona persona = identificarPersona();
		print("Este es el registro de sus facturas ");
		
		print("1. Ver las facturas de compras que he hecho");
		print("2. Ver las facturas de mis tiendas");
		int decision=escaner(2);
		switch(decision) {
		case 1:
			System.out.println(persona.imprimirFacturas((Cliente)persona));
			break;
		case 2:
			System.out.println(persona.imprimirFacturas(persona));
			break;
		}	
		
	}
	
	// este metodo imprime la factura 
	
	//        fecha de facturacion 
	//   Nombre   Tamaño   Precio   Cantidad
	 
	
	public static void imprimirFactura(Cliente cliente) {
        System.out.println("Fecha de Facturación: " + cliente.getCarrito().getFechaFacturacion());
        System.out.println("Productos:");
        System.out.println("Nombre\tTamaño\tPrecio\tCantidad");

        Map<String, Integer> contadorProductos = cliente.obtenerContadorProductos(cliente);

        for (Map.Entry<String, Integer> entry : contadorProductos.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}

