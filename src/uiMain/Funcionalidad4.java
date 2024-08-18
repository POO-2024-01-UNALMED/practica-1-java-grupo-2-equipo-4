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
	Persona usuario = identificarPersona();
	    public  void mai() {
	    	System.out.println("------------------ REVISION DE TIENDA -----------------");
	    	System.out.println("seleccione una opcion");
	    	System.out.println("1.Total de productos en el inventario\n"
					+ "2.Productos para vencer\n"
					+ "3.Marcar producto como defectuoso\n"
					+ "4.Reabastecimiento\n");
	    	
	    	
	        int opcion = escaner();
	        switch (opcion) {
	            case 1:
	                System.out.println("Todos los productos se mostraran a continuacion...");
	                ArrayList<Producto> productos = usuario.getTienda().obtenerTodosLosProductos();
	                for (Producto i:productos) {
	                	System.out.println(i.getNombre());
	                }
	                
	            case 2:
	            	System.out.println("Todos los productos vencidos se mostraran a continuacion...");
	            	
	            	cliente.getTienda().vencerProducto();
	            	ArrayList<Producto> productosVencidos = cliente.getTienda().getProductosVencidos();
	         
	            	 for (Producto i:productosVencidos) {
		                	System.out.println(i.getNombre());
		                }
	            	 
	            	
	            case 3:
	            	System.out.println("marcar producto como defectuoso");
	            	
	            case 4: 
	            	System.out.println("reabastecimiento");
	            	System.out.println("seleccione un proveedor");
	            	usuario.getTienda().getProveedores().get(1).imprimirProveedores();
	            	int opcionProveedor = sc.nextInt();
	            	if (opcionProveedor== 1) {
	            		
	            	}
	            	else {
	            	
	            	}
	            	else {
	            		
	            	}
	            	else {
	            		
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

