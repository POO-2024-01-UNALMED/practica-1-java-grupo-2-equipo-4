package uiMain;

import uiMain.Main;
import java.util.ArrayList;
import java.util.Scanner;
import gestorAplicación.servicios.Producto;
import gestorAplicación.servicios.Tienda;
import gestorAplicación.servicios.Enums.Categoria;
import gestorAplicación.sujetos.Cliente;
import static uiMain.Main.print;
import static uiMain.Main.escaner;

public class Funcionalidad4 {	
	static Scanner sc = new Scanner(System.in);
	    public static void main(Cliente cliente) {
	    	System.out.println("------------------ REVISION DE TIENDA -----------------");
	    	System.out.println("seleccione una opcion");
	    	System.out.println("1.Total de productos en el inventario\n"
					+ "2.Productos para vencer\n"
					+ "3.Marcar producto como defectuoso\n"
					+ "4.Reabastecimiento\n");
	    	
	    	
	        int opcion = sc.nextInt();
	        switch (opcion) {
	            case 1:
	                System.out.println("Todos los productos se mostraran a continuacion...");
	                ArrayList<Producto> productos = cliente.getTienda().obtenerTodosLosProductos();
	                for (Producto i:productos) {
	                	System.out.println(i.getNombre());
	                }
	                break;
	            case 2:
	            	System.out.println("Todos los productos vencidos se mostraran a continuacion...");
	            	
	            	cliente.getTienda().vencerProducto();
	            	ArrayList<Producto> productosVencidos = cliente.getTienda().getProductosVencidos();
	         
	            	 for (Producto i:productosVencidos) {
		                	System.out.println(i.getNombre());
		                }
	            	 
	            	break;
	            	
	            default:
	                System.out.println("Opción no válida");
	                break;
	        }
	    }
	}

