package uiMain;

import uiMain.Main;
import java.util.ArrayList;
import java.util.Scanner;
import gestorAplicación.servicios.Producto;
import gestorAplicación.servicios.Proveedor;
import gestorAplicación.servicios.Tienda;
import gestorAplicación.servicios.Enums.Categoria;
import gestorAplicación.sujetos.Cliente;
import gestorAplicación.sujetos.Persona;

import static uiMain.Main.print;
import static uiMain.Main.escaner;
import gestorAplicación.sujetos.Cliente;
import gestorAplicación.sujetos.Persona;
import gestorAplicación.servicios.Producto;
import gestorAplicación.servicios.Tienda;
import gestorAplicación.servicios.Enums.Categoria;
public class Funcionalidad4 extends Identidad {	
	static Scanner sc = new Scanner(System.in);
	static Persona usuario = identificarPersona();
	
	
	    public  static Tienda seleccionTienda() {
	    	System.out.println("------------------ REVISION DE TIENDA -----------------");
	// seleccion de tiendas para administrar //    	
	    	print("Tus tiendas ");
	    	
	    	Tienda tienda=null;
	    	int contT = 1;

	    	for(Tienda i: usuario.getTiendas()) {
	    		print(contT+ ". "+i.getNombre());
	    		contT++;
	    	}
	    	
	    	contT--;
	    	
	    	print("Seleccione una tienda para administrar");
	    	int decs = escaner(contT);
	    		    	
	    	for (int i = 0; i < contT; i++) {
	           if(i+1 == decs ) {
	        	   tienda = usuario.getTiendas().get(i);
	        	   break;
	           }
	        }	
	    	return tienda;
	    }
	    
	  // seleccion de acciones en tienda //
	    
	    public  static void adminitrarTienda(Tienda tienda) {
	    	
	    	
	    	System.out.println("que deasea ver?");
	    	System.out.println("1.Total de productos en el inventario\n"
					+ "2.Productos vencidos\n"
					+ "3.Marcar producto como defectuoso\n"
					+ "4.Reabastecimiento\n");   	
	    	
	        int opcion = escaner();
	        
	        switch (opcion) {
	            case 1: // productosUnicos contiene todos los productos sin repetición //   
	            	
	                System.out.println("Todos los productos se mostraran a continuacion...");
	                
	                ArrayList<Producto> productos = tienda.obtenerTodosLosProductos();
	                ArrayList<Producto> productosUnicos = new ArrayList<>();

	                for (Producto producto : productos) {
	                    if (!productosUnicos.contains(producto)) {
	                        productosUnicos.add(producto);
	                    }
	                }
	                	
	                for (Producto i:productosUnicos) {
	                	System.out.println(i.getNombre());
	                }
	                
	            case 2:
	            	System.out.println("Todos los productos vencidos se mostraran a continuacion...");
	            	
	            	tienda.vencerProducto();
	            	ArrayList<Producto> productosVencidos = tienda.getProductosVencidos();
	         
	            	 for (Producto i:productosVencidos) {
		                	System.out.println(i.getNombre());
		             }	            	 
	            	
	            case 3:
	            	System.out.println("Marcar producto como defectuoso");
	            	
	            case 4: 
	            	print("Reabastecimiento");   
	            	print("Proveedores disponibles:");
	            	
	                for (int i = 0; i < tienda.getProveedores().size(); i++) {
	                    System.out.println((i + 1) + ". " + tienda.getProveedores().get(i).getNombre());
	                }

	                System.out.print("Seleccione el número del proveedor que desea elegir: ");
	                int seleccion = escaner() - 1;

	                Proveedor proveedorSeleccionado = null;
	                if (seleccion >= 0 && seleccion < tienda.getProveedores().size()) {
	                    proveedorSeleccionado = tienda.getProveedores().get(seleccion);
	                    
	                    System.out.println("Proveedor seleccionado: " + proveedorSeleccionado.getNombre());
	                    
	                } else {
	                    System.out.println("Selección inválida.");
	                }
	            	
	            	 System.out.println("Productos disponibles para pedido:");
	                 ArrayList<Producto> entrega = proveedorSeleccionado.getEntrega();
	                 for (int i = 0; i < entrega.size(); i++) {
	                     System.out.println((i + 1) + ". " + entrega.get(i));
	                 }

	                 System.out.print("Seleccione el número del producto que desea pedir: ");
	                 int seleccion2 = escaner() - 1;

	                 if (seleccion2 >= 0 && seleccion2 < entrega.size()) {
	                     Producto productoSeleccionado = entrega.get(seleccion2);
	                     
	                     System.out.print("Ingrese la cantidad que desea pedir: ");
	                     int cantidad = escaner();

	                     for (int i = 0; i < cantidad; i++) {
	                         try {
	                             Producto productoClonado = (Producto) productoSeleccionado.clone();
	                             tienda.agregarProducto(productoClonado);
	                         } catch (CloneNotSupportedException e) {
	                             e.printStackTrace();
	                         }
	                     }

	                     System.out.println("Productos agregados al pasillo correspondiente.");
	                 } else {
	                     System.out.println("Selección inválida.");
	                 }

	                 sc.close();
	             
	            	
	            case 5:
	            	
	    			break;
	            default:
	                System.out.println("Opción no válida");
	                break;
	        }
	    }
		
}

