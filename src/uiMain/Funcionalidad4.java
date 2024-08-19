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
	    
	    public  static Tienda adminitrarTienda(Tienda tienda) {
	    	
	    	return tienda;
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
	            	print("Lista de Proveedores:");
	            	
	    	        int contador = 1;
	    	        
	    	        for (Proveedor proveedor : tienda.getProveedores()) {
	    	            System.out.println(contador + ". " + proveedor);
	    	            contador++;
	    	        }
	    	        
	            	print("seleccione un proveedor"); 
	            	
	            	int opcionProveedor = sc.nextInt();
	            	
	            	if (opcionProveedor == 1) {
	            	    // Código para la opción 1
	            	} else if (opcionProveedor == 2) {
	            	    // Código para la opción 2
	            	} else if (opcionProveedor == 3) {
	            	    // Código para la opción 3
	            	} else if (opcionProveedor == 4) {
	            	    // Código para la opción 4
	            	} else {
	            	    // Código para cualquier otra opción
	            	}

	            	
	            case 5:
	            	Main.escogerFuncionalidad(usuario);
	    			break;
	            default:
	                System.out.println("Opción no válida");
	                break;
	        }
	    }
		
}

