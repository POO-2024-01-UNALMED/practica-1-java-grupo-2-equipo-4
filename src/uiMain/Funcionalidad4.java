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
import static uiMain.Funcionalidad1.printTablaProductos;
import static uiMain.Main.print;
import static uiMain.Main.escaner;
import gestorAplicación.sujetos.Cliente;
import gestorAplicación.sujetos.Persona;
import gestorAplicación.servicios.Producto;
import gestorAplicación.servicios.Tienda;
import gestorAplicación.servicios.Enums.Categoria;
import java.util.HashSet;

public class Funcionalidad4 extends Identidad implements Cloneable {
	
	static Scanner sc = new Scanner(System.in);
	
	
	static Persona usuario = identificarPersona();
	    public  static void seleccionTienda() {
	    	
	    	System.out.println("------------------ REVISION DE TIENDA -----------------");
	// seleccion de tiendas para administrar //  
	    	
			if(usuario.getTiendas().size()==0) {
				print("No tienes niguna tienda registrada "); 
				print("Que desea hacer ");
				print("1. Cambiar de usuario");
				print("2. Volver al Menu principal");
				
				int valor= escaner();
				switch (valor) {
					case 1:
						usuario=null;
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
	    	adminitrarTienda(tienda);
	    }
	    
	  // seleccion de acciones en tienda //
	    
	    public  static void adminitrarTienda(Tienda tienda) {	    	
	    	
	    	System.out.println("que deasea ver?");
	    	System.out.println("1. Total de productos en el inventario\n"
					+ "2. Productos vencidos\n"
					+ "3. Marcar producto como defectuoso\n"
					+ "4. Reabastecimiento\n"
					+ "5. Seleccionar otra tienda"
					+ "6. Volver al menu principal");   	
	    	
	        int opcion = escaner(6);
	        
	        switch (opcion) {
	            case 1: // productosUnicos contiene todos los productos sin repetición //   
	            	
	                System.out.println("Todos los productos se mostraran a continuacion...");
	                
	                ArrayList<Producto> productos = tienda.obtenerTodosLosProductos();
	                ArrayList<Producto> productosUnicos = new ArrayList<Producto>();
	                HashSet<String> nombres = new HashSet<>();
	                
	                for (Producto producto : productos) {
	                    if (!nombres.contains(producto.getNombre())) {
	                        nombres.add(producto.getNombre());
	                        productosUnicos.add(producto);
	                    }
	                }
	                
	                if(productosUnicos.size()>0) {
	                	printTablaProductos(productosUnicos);
	                
	                }else {	                
		                	System.out.println("La tienda no tiene ningun producto");
	                }
	                
	              
	                System.out.println("Seleccione una opcion");
	                System.out.println("1.Seleccionar otra tienda");
	                System.out.println("2. Volver a menu principal");
	                System.out.println("3. Volver atras");
	                
	                int opcionCase1 = escaner(3);
	                
	                switch(opcionCase1) {
	                	case 1:	                		
	                		seleccionTienda();
	                		break;
	                		
	                	case 2:                		
	                		Main.escogerFuncionalidad();
							break;
							
	                	case 3:	
	                		adminitrarTienda(tienda);
	                		break;
	                }
	                
	                break;
	                
	            case 2: // muestra todos los productos vencidos //
	            	System.out.println("Todos los productos vencidos se mostraran a continuacion...");
	            	
	            	tienda.vencerProducto();
	            	ArrayList<Producto> productosVencidos = tienda.getProductosVencidos();
	         
	            	 for (Producto i:productosVencidos) {
		                	System.out.println(i.getNombre());
		             }	
	            	 
	            	    System.out.println("Seleccione una opcion");
		                System.out.println("1.Seleccionar otra tienda");
		                System.out.println("2. Volver a menu principal");
		                System.out.println("3. Volver atras");
		                
		                int opcionCase2 = escaner(3);
		                
		                switch(opcionCase2) {		                
		                	case 1:	                		
		                		seleccionTienda();
		                		break;
		                		
		                	case 2:                		
		                		Main.escogerFuncionalidad();
								break;
								
		                	case 3:	
		                		adminitrarTienda(tienda);
		                		break;
		                }
		                
	            	break;
	            	
	            case 3: // muestra los productos devueltos y los elimina o regresa//
	            	System.out.println("Productos devueltos");
	            	
	            	
	            	System.out.println("Seleccione una opcion");
	                System.out.println("1.Seleccionar otra tienda");
	                System.out.println("2. Volver a menu principal");
	                System.out.println("3. Volver atras");
	                
	                int opcionCase3 = escaner(3);
	                
	                switch(opcionCase3) {		                
	                	case 1:	                		
	                		seleccionTienda();
	                		break;
	                		
	                	case 2:                		
	                		Main.escogerFuncionalidad();
							break;
							
	                	case 3:	
	                		adminitrarTienda(tienda);
	                		break;
	                }
	                
	            	break;
	            	
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
	                          Producto productoClonado = (Producto) productoSeleccionado.clone();
	                          tienda.agregarProducto(productoClonado);                             	                         
	                     }

	                     System.out.println("Productos agregados al pasillo correspondiente.");
	                 } else {
	                     System.out.println("Selección inválida.");
	                 }

	                 sc.close();
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
		                		adminitrarTienda(tienda);
		                		break;
		                }
		                
	             break;
	            	
	            case 5:
	            	seleccionTienda();
	    			break;
	            case 6:
	            	Main.escogerFuncionalidad();
	            	break;
	            	
	            default:
	                System.out.println("Opción no válida");
	                break;
	        }
	    }
	    
	    // Método para imprimir los productos en formato tabla ASCII
	    
	    public static void printTablaProductos(ArrayList<Producto> productos) {
	        print("+------------------------------------+");
	        print("| No. |      Nombre de Producto      |");
	        print("+------------------------------------+");

	        int anchoCelda = 28; // Ancho de la celda para el nombre del producto
	        for (int i = 0; i < productos.size(); i++) {
	            String nombreProducto = productos.get(i).getNombre();
	            int espacios = (anchoCelda - nombreProducto.length()) / 2;

	            // Relleno a izquierda y derecha para centrar el nombre del producto
	            String paddingIzquierdo = " ".repeat(Math.max(0, espacios));
	            String paddingDerecho = " ".repeat(Math.max(0, espacios + (anchoCelda - nombreProducto.length()) % 2));

	            print(String.format("| %-3d |%s%s%s|", i + 1, paddingIzquierdo, nombreProducto, paddingDerecho));
	        
	        }	        
	        print("+------------------------------------+");
	    }
	
}

