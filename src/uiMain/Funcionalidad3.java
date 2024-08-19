package uiMain;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import gestorAplicación.servicios.*;
import gestorAplicación.sujetos.*;
import java.util.Scanner;

import gestorAplicación.servicios.Enums.Categoria;
import gestorAplicación.servicios.Enums.EstadoProducto;
import gestorAplicación.servicios.Enums.RazonDevolucion;
import gestorAplicación.sujetos.Cliente;
import gestorAplicación.sujetos.Persona;
import gestorAplicación.sujetos.*;
import static uiMain.Main.print;
import static uiMain.Main.escaner;
import static uiMain.Main.lineas;

public class Funcionalidad3 extends Identidad {
		 static Persona persona = identificarPersona();
		 
		 public static void administrarRecibos() {
			 System.out.println("------------------ Administrar recibos  -----------------");
			 System.out.println("Seleccione una opcion");
			 System.out.println("Administrar recibos de:");
			 System.out.println("1. Dueño ");
			 System.out.println("2. Cliente ");
			 
		     int opcion = escaner(2);

		     switch (opcion) {
		            case 1:
		            	seleccionTienda();
		                break;
		            case 2:
		            	
		                break;
		            default:
		                System.out.println("Opción no válida. Por favor, seleccione 1 o 2.");
		                break;
		        }

		 }
		 
		 public  static Tienda seleccionTienda() {
			 System.out.println("------------------ Pago de recibos  -----------------");
		// seleccion de tiendas para comprar //  
		    	
				if(persona.getTiendas().size()==0) {
					print("No tienes niguna tienda registrada "); 
					print("Que desea hacer ");
					print("1. Cambiar de usuario");
					print("2. Volver al Menu principal");
					
					int valor= escaner();
					switch (valor) {
						case 1:
							persona=null;
							seleccionTienda();
							break;
						case 2:
							Main.escogerFuncionalidad();
							break;
					}
				}
		    	
		    	print("Tiendas disponibles: ");
		    	
		    	Tienda tienda=null;
		    	int contT = 1;

		    	for(Tienda i: persona.getTiendas()) {
		    		print(contT+ ". "+i.getNombre());
		    		contT++;
		    	}
		    	
		    	contT--;
		    	
		    	print("Seleccione una tienda para administrar");
		    	int decs = escaner(contT);
		    		    	
		    	for (int i = 0; i < contT; i++) {
		           if(i+1 == decs ) {
		        	   tienda = persona.getTiendas().get(i);
		        	   break;
		           }
		        }	
		    	return tienda;
		    }
		 
//	public static void mostrarFacturas() {
//	
//		print("Este es el registro de sus facturas ");
//		
//		print("1. Ver las facturas de compras que he hecho");
//		print("2. Ver las facturas de mis tiendas");
//		int decision=escaner(2);
//		switch(decision) {
//		case 1:
//			System.out.println("Nombre del Producto\tTamaño\tPrecio\tCantidad");
//			System.out.println(persona.obtenerContadorProductos((Cliente)persona));
//			break;
//		case 2:
//			System.out.println("Nombre del Producto\tTamaño\tPrecio\tCantidad");
//			System.out.println(persona.obtenerContadorProductos(persona));
//			break;
//		}	
		
//	}
	
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
	
	public static void imprimirFactura(Persona cliente) {
		
		System.out.println("Estas son las facturas en su tienda");	
		
        System.out.println("Fecha de Facturación: " + cliente.getCarrito().getFechaFacturacion());
        System.out.println("Productos:");
        System.out.println("Nombre\tTamaño\tPrecio\tCantidad");

        Map<String, Integer> contadorProductos = cliente.obtenerContadorProductos(cliente);

        for (Map.Entry<String, Integer> entry : contadorProductos.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
	
	public static void realizarDevolicion() {
		Tienda tienda = seleccionTienda();
		System.out.println("Realizar una devolucion");
		System.out.println("Seleccione una de sus compras anteriores");
		
		System.out.println("Compras anteriores en la tienda:");
	    int index = 1;
	    for (Carrito carrito : tienda.getCarritos()) {
	        System.out.println(index + ". " + carrito.getFechaFacturacion());
	        index++;
	    }
	    
	    System.out.print("Ingrese el número de la compra que desea seleccionar: ");
	    int indiceCarrito = escaner(index) - 1;
	    
	    Carrito carritoSeleccionado = tienda.getCarritos().get(indiceCarrito);	                
	 
	    System.out.println("Productos en el carrito seleccionado:");
	    index = 1;
	    for (Producto producto : carritoSeleccionado.getProductos()) {
	        System.out.println(index + ". " + producto);
	        index++;
	    }
	
	    System.out.print("Ingrese el número del producto que desea devolver: ");
	    int indiceProducto = escaner() - 1;
	
	    Producto productoSeleccionado = carritoSeleccionado.getProductos().get(indiceProducto);
	
	    // Solicitar la razón de la devolución
	    System.out.println("Razones de devolución:");
	    for (RazonDevolucion razon : RazonDevolucion.values()) {
	        System.out.println(razon.ordinal() + 1 + ". " + razon);
	    }
	    System.out.print("Ingrese el número de la razón de la devolución: ");
	    int indiceRazon = escaner() - 1;
	
	    RazonDevolucion razonDevolucion = RazonDevolucion.values()[indiceRazon];
	
	    // Cambiar el estado del producto si es defectuoso
	    if (razonDevolucion == RazonDevolucion.DEFECTUOSO) {
	        productoSeleccionado.setEstado(EstadoProducto.DEFECTUOSO);
	    }
	
	    // Agregar el producto seleccionado a la lista de productos devueltos
	    tienda.getProductosDevueltos().add(productoSeleccionado);
	
	    // Imprimir productos devueltos
	    System.out.println("Producto devuelto exitosamente");
	    System.out.println("Seleccione una opcion");
	    System.out.println("1.Seleccionar otra tienda");
        System.out.println("2. Volver a menu principal");
        System.out.println("3. Volver atras");        
        
        int opcionCase4 = escaner(3);
        
        switch(opcionCase4) {		                
        	case 1:	                		
        		seleccionTienda();
        		break;
        		
        	case 2:                		
        		Main.escogerFuncionalidad();
				break;
				
        	case 3:	
        		// opcion anterior a realizar devolucion //;
        		break;
        }
	}
}

