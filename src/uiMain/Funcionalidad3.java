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
import gestorAplicación.servicios.Enums.Genero;
import gestorAplicación.servicios.Enums.RazonDevolucion;
import gestorAplicación.servicios.Enums.TipoCaja;
import gestorAplicación.sujetos.Cliente;
import gestorAplicación.sujetos.Persona;
import gestorAplicación.sujetos.*;
import static uiMain.Main.print;
import static uiMain.Main.escaner;
import static uiMain.Main.lineas;

public class Funcionalidad3 extends Identidad {
	public static void impresionFacturas() {
		Persona persona = identificarPersona();
		ArrayList<Tienda> tiendas = persona.getTiendas();
		Map<String, Integer> conteoTiendas = new HashMap<>();
	        for (Tienda tienda : tiendas) {
	            conteoTiendas.put(tienda.getNombre(), conteoTiendas.getOrDefault(tienda.getNombre(), 0) + 1);
	        }
	        System.out.println("Número de Facturas");
	        System.out.println("+-----+----------------+-----------------+");
	        System.out.println("| No. | Nombre         | Cantidad         |");
	        System.out.println("+-----+----------------+-----------------+");

	        int numero = 1;
	        for (Map.Entry<String, Integer> entry : conteoTiendas.entrySet()) {
	            System.out.printf("| %-3d | %-14s | %-15d |%n", numero, entry.getKey(), entry.getValue());
	            numero++;
	        }

	        // Imprimir línea final
	        System.out.println("+-----+----------------+-----------------+");

	        // Solicitar selección del usuario
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Seleccione el número de la tienda: ");
	        int seleccion = scanner.nextInt();
	        scanner.close();

	        // Validar selección
	        if (seleccion < 1 || seleccion > conteoTiendas.size()) {
	            System.out.println("Selección inválida.");
	        } else {
	            // Obtener el nombre de la tienda seleccionada
	            String tiendaSeleccionada = (String) conteoTiendas.keySet().toArray()[seleccion - 1];
	            System.out.println("Has seleccionado la tienda: " + tiendaSeleccionada);
	        }
	} 
		 
		 
		 public static void funcionalidad() {
			 Cliente cliente = seleccionRol();			 
			 if (cliente != null) {
				 // logica para cliente //	//utilizar cliente 	//	
				 seleccionCliente();
				 
			 } else {
				 //logica para dueño
				 seleccionDueno();
			 }				 				 
		 }
		 
		 public static void seleccionDueno() {
			 Tienda tienda = seleccionarTiendaDueno(persona);
			 imprimirCarritosPagados(tienda);
		 }
		 
		 
		 public static void seleccionCliente() {
			 ArrayList<Tienda> tiendasConCliente = Tienda.tiendasConCliente(cliente);
			 Tienda tienda = seleccionarTiendaCliente(tiendasConCliente);
			 System.out.println("Que desea consultar ");
			 System.out.println("1. Facturas pagadas ");
			 System.out.println("2. Facturas por pagar  ");
			 System.out.println("3. Volver ");
			 
			 int opcion = escaner(2);
			 
			 switch (opcion){
			 	case 1:
			 		Carrito carrito = seleccionarCarritoPagado(tienda);
			 		imprimirFacturaCompleta(carrito);
			 		System.out.println("Seleccione una opcion");
			 		System.out.println("1. Realizar devolucion");
			 		System.out.println("2. Volver ");
			 		System.out.println("3. volver al menu principal");
			 		
			 		int opcionCase1 = escaner(3);
			 		switch (opcionCase1) {
			 			case 1:
			 				System.out.println("Seleccione el Producto que desea devolver:  ");
			 				imprimirFacturaCompleta(carrito);
			 				int index = escaner(carrito);
			 						
			 				break;
			 			case 2:
			 				seleccionCliente();
			 				break;
			 			case 3:
			 				Main.escogerFuncionalidad();
			 				break;
			 		}
			 		
			 		break;
			 		
			 	case 2:
			 		break;
			 		
			 	case 3:
			 		funcionalidad();
			 		break;
			 }
		 }
		 
		 
		 public static void imprimirFacturaCompleta(Carrito carrito) {
		        Map<String, Integer> resumenProductos = new HashMap<>();
		        for (Producto producto : carrito.getProductos()) {
		            String clave = producto.getNombre() + " " + producto.getMarca() + " " + producto.getTamaño() + " " + producto.getPrecio();
		            resumenProductos.put(clave, resumenProductos.getOrDefault(clave, 0) + 1);
		        }

		        for (Map.Entry<String, Integer> entry : resumenProductos.entrySet()) {
		            System.out.println(entry.getKey() + " Cantidad: " + entry.getValue());
		        }
		    }
		 
		 public static Carrito seleccionarCarritoPagado(Tienda tienda) {
		        ArrayList<Carrito> carritosPagados = new ArrayList<>();
		        int contador = 1;

		        for (Carrito carrito : tienda.getCarritos()) {
		            if (carrito.isPagado()) {
		                carritosPagados.add(carrito);
		                System.out.println(contador + ". Fecha: " + carrito.getFechaFacturacion() + ", Cantidad de productos: " + carrito.getProductos().size());
		                contador++;
		            }
		        }

		        if (carritosPagados.isEmpty()) {
		            System.out.println("No hay carritos pagados.");
		            return null;
		        }

		        
		        System.out.print("Seleccione el número del carrito que desea consultar: ");
		        int seleccion = escaner();

		        return carritosPagados.get(seleccion - 1);
		    }
			
		 public static void imprimirCarritosPagados(Tienda tienda) {
			 System.out.println("estas son todas las facturas pagadas en su tienda");
		        int contador = 1;
		        for (Carrito carrito : tienda.getCarritos()) {
		            if (carrito.isPagado()) {
		                System.out.println(contador + ". Fecha: " + carrito.getFechaFacturacion() + ", Cliente: " + carrito.getCliente().getNombre());
		                contador++;
		            }
		        }
		    }		 		 
		 
		 public static Cliente seleccionRol() {
			 System.out.println("ver facturas como:");
             System.out.println("1. Cliente");
             System.out.println("2. Dueño");
             
             int opcionUsuario = escaner();
             
             if(opcionUsuario == 1) {
            	Cliente cliente = (Cliente) persona;  
            	return cliente;
             }  return  null;
             
		 }
		 
		 public static Tienda seleccionarTiendaCliente(ArrayList<Tienda> tiendasConCliente) {
		        if (tiendasConCliente.isEmpty()) {
		            System.out.println("No hay tiendas disponibles.");
		            return null;
		        }

		        System.out.println("Estas son las tiendas disponibles:");
		        for (int i = 0; i < tiendasConCliente.size(); i++) {
		            System.out.println((i + 1) + ". " + tiendasConCliente.get(i).getNombre());
		        }

		        System.out.print("Seleccione el número de la tienda que desea consultar: ");
		        int seleccion = escaner();

		        return tiendasConCliente.get(seleccion - 1);
		    }
		 
		 
		  static public Tienda seleccionarTiendaDueno(Persona persona) {
		        if (persona.getTiendas().isEmpty()) {
		            System.out.println("No es dueño de ninguna tienda.");
		            return null;
		        }

		       
		        System.out.println("Seleccione una tienda de la lista:");
		        for (int i = 0; i < persona.getTiendas().size(); i++) {
		            System.out.println((i + 1) + ". " + persona.getTiendas().get(i).getNombre());
		        }

		        int seleccion = escaner();
		        if (seleccion < 1 || seleccion > persona.getTiendas().size()) {
		            System.out.println("Selección inválida.");
		            return null;
		        }

		        return persona.getTiendas().get(seleccion - 1);
		    }  
		 
		 
		 
		  
		  
		 /// de aqui pa abajo es caca //
		 
		 
		 
		 
		 public static void imprimirFacturasCliente(Cliente cliente, boolean pagadas) {
		        ArrayList<Carrito> facturas = cliente.obtenerFacturas(pagadas);
		        int numeroFactura = 1;
		        for (Carrito carrito : facturas) {
		            System.out.printf("%d. %s%n", numeroFactura, carrito.getFechaFacturacion());
		            numeroFactura++;
		        }
		    }

		    public static void imprimirFacturaDetalle(Carrito carrito) {
		        System.out.println("Fecha de Facturación: " + carrito.getFechaFacturacion());
		        System.out.println("Productos:");
		        System.out.printf("%-20s %-20s %-10s %-10s %-10s%n", "Nombre", "Marca", "Tamaño", "Precio", "Cantidad");

		        Map<String, Integer> contadorProductos = new HashMap<>();
		        for (Producto producto : carrito.getProductos()) {
		            String clave = producto.getNombre() + "\t" + producto.getMarca() + "\t" + producto.getTamaño() + "\t" + producto.getPrecio();
		            contadorProductos.put(clave, contadorProductos.getOrDefault(clave, 0) + 1);
		        }

		        for (Map.Entry<String, Integer> entry : contadorProductos.entrySet()) {
		            String[] partes = entry.getKey().split("\t");
		            System.out.printf("%-20s %-20s %-10s %-10s %-10d%n", partes[0], partes[1], partes[2], partes[3], entry.getValue());
		        }
		    }

		    public static void imprimirFacturasPersona(Persona persona) {
		        int numeroFactura = 1;
		        for (Tienda tienda : persona.getTiendas()) {
		            for (Carrito carrito : tienda.getCarritos()) {
		                if (carrito.isPagado()) {
		                    System.out.printf("%d. %s - %s%n", numeroFactura, carrito.getFechaFacturacion(), carrito.getCliente().getNombre());
		                    numeroFactura++;
		                }
		            }
		        }
		    }
		    
		 //		 public static void administrarRecibos() {
//			 System.out.println("------------------ Administrar recibos  -----------------");
//			 System.out.println("Seleccione una opcion");
//			 System.out.println("Administrar recibos de:");
//			 System.out.println("1. Dueño ");
//			 System.out.println("2. Cliente ");
//			 
//		     int opcion = escaner(2);
//
//		     switch (opcion) {
//		            case 1:
//		            	Tienda tiendaDueno=seleccionTienda();
//		            	imprimirFacturasDueno(persona);
//		                break;
//		            case 2:
//		            	obtenerContadorProductos((Cliente) persona);
//		                break;
//		            default:
//		                System.out.println("Opción no válida. Por favor, seleccione 1 o 2.");
//		                break;
//		        }
//
//		 }
		    
		    
		 
		    
	 
		 public  static Tienda seleccionTienda() {
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
		
//		 public static void imprimirFacturasDueno(Persona cliente) {
//		        System.out.println("Estas son las facturas en su tienda");
//
//		        int numeroFactura = 1;
//		        for (Tienda tienda : cliente.getTiendas()) {
//		            for (Carrito carrito : tienda.getCarritos()) {
//		                System.out.println(numeroFactura + ". " + carrito.getFechaFacturacion() + " - " + carrito.getCliente().getNombre());
//		                numeroFactura++;
//		            }
//		        }
//		    }
//	 
//	
//	public static void imprimirFactura(Cliente cliente) {
//        System.out.println( cliente.getCarrito().getFechaFacturacion());
//
//        System.out.println("Nombre\tTamaño\tPrecio\tCantidad");
//
//        Map<String, Integer> contadorProductos = cliente.obtenerContadorProductos(cliente);
//
//        for (Map.Entry<String, Integer> entry : contadorProductos.entrySet()) {
//            System.out.println(entry.getKey() + "\t" + entry.getValue());
//        }
//    }
//	
//	public static void imprimirFactura(Persona cliente) {
//		
//		System.out.println("Estas son las facturas en su tienda");	
//		
//        System.out.println("Fecha de Facturación: " + cliente.getCarrito().getFechaFacturacion());
//        System.out.println("Productos:");
//        System.out.println("Nombre\tTamaño\tPrecio\tCantidad");
//
//        Map<String, Integer> contadorProductos = cliente.obtenerContadorProductos(cliente);
//
//        for (Map.Entry<String, Integer> entry : contadorProductos.entrySet()) {
//            System.out.println(entry.getKey() + "\t" + entry.getValue());
//        }
//    }
	
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
	

	public boolean tresEnRaya() {
		Scanner sc = new Scanner(System.in);

        // Juego de Tres en Raya
        Juego juegoTresEnRaya = new TresEnRaya();
        juegoTresEnRaya.iniciar();
        while (!juegoTresEnRaya.haGanado() && !juegoTresEnRaya.haPerdido()) {
            System.out.println(juegoTresEnRaya.obtenerEstado());
            System.out.print("Elige una posición (0-8): ");
            int posicion = sc.nextInt();
            juegoTresEnRaya.jugar(posicion);
        }
        System.out.println(juegoTresEnRaya.obtenerEstado());
        System.out.println(juegoTresEnRaya.haGanado() ? "¡Ganaste!" : "¡Perdiste!");
        if((juegoTresEnRaya.haGanado() ? "¡Ganaste!" : "¡Perdiste!").equals("¡Ganaste!")) {
        	return true;
        }
        else {
        	return false;
        }
	}
	
	public boolean juegoAhorcado() {
		Juego juegoAhorcado = new Ahorcado("java");
        juegoAhorcado.iniciar();
        while (!juegoAhorcado.haGanado() && !juegoAhorcado.haPerdido()) {
            System.out.println(juegoAhorcado.obtenerEstado());
            System.out.print("Introduce una letra: ");
            char letra = sc.next().charAt(0);
            juegoAhorcado.jugar(letra);
        }
        System.out.println(juegoAhorcado.obtenerEstado());
        System.out.println(juegoAhorcado.haGanado() ? "¡Ganaste!" : "¡Perdiste!");
        if((juegoAhorcado.haGanado() ? "¡Ganaste!" : "¡Perdiste!").equals("¡Ganaste!")) {
        	return true;
        }
        else {
        	return false;
        }
	}
	
	
	public static void seleccionarCaja(Cliente cliente, Carrito carrito) {
	    Scanner sc = new Scanner(System.in);
	    ArrayList<Caja> cajas = cliente.getTienda().cajasDisponibles();
	    
	    while (true) {
	        if (cajas.isEmpty()) {
	            System.out.println("No hay cajas disponibles.");
	            System.out.println("1. Esperar a que una caja esté disponible.");
	            System.out.println("2. No pagar y salir.");
	            System.out.print("Seleccione una opción: ");
	            int opcion = sc.nextInt();
	            
	            if (opcion == 1) {
	                asignarEmpleado(); // Método para asignar un empleado a una caja
	                continue; // Repetir el proceso después de asignar un empleado
	            } else if (opcion == 2) {
	                System.out.println("Ha decidido no pagar. Saliendo del proceso.");
	                return; // Salir del método
	            } else {
	                System.out.println("Opción no válida. Inténtelo de nuevo.");
	                continue;
	            }
	        }

	        System.out.println("Seleccione una caja para pagar:");
	        for (int i = 0; i < cajas.size(); i++) {
	            Caja caja = cajas.get(i);
	            System.out.printf("%d. Caja: %s, Tipo: %s, Empleado: %s\n", 
	                              i + 1, caja.getNombre(), caja.getTipo(), caja.getEmpleado().getNombre());
	        }
	        
	        System.out.print("Seleccione el número de la caja: ");
	        int seleccion = sc.nextInt();
	        
	        if (seleccion > 0 && seleccion <= cajas.size()) {
	            Caja cajaSeleccionada = cajas.get(seleccion - 1);

	            if (cajaSeleccionada.getTipo() == TipoCaja.RAPIDA && cliente.getCarrito().getProductos().size() > 5) {
	                System.out.println("No puede usar la caja rápida porque tiene más de 5 productos.");
	                System.out.println("Por favor, seleccione otra caja.");
	                continue;
	            }

	            System.out.println("Ha seleccionado la caja: " + cajaSeleccionada.getNombre());
	            break; // Caja seleccionada correctamente, salir del bucle
	        } else {
	            System.out.println("Selección inválida. Inténtelo de nuevo.");
	        }
	    }  
	}
	
	

}

