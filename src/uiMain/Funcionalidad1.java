package uiMain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import gestorAplicación.sujetos.Cliente;
import gestorAplicación.sujetos.Persona;
import gestorAplicación.servicios.Carrito;
import gestorAplicación.servicios.Producto;
import gestorAplicación.servicios.Tienda;
import gestorAplicación.servicios.Enums.Membresia;
import gestorAplicación.servicios.Enums.Categoria;
import gestorAplicación.servicios.Enums.Edades;
import static uiMain.Main.lineas;
import static uiMain.Main.escaner;
import static uiMain.Main.print;

public class Funcionalidad1 extends Identidad{
    
    //Implementación de scanner para hacer el proceso más fácil y verificar las entradas

    static Scanner sc = new Scanner(System.in);

 // ---------------------------------------------------------------------------------------------------------------------------------------------------

    //Este método se encarga de direccionar al cliente hacia la consulta que desea realizar 
    public static void consultasEco() {
    	Cliente cliente= (Cliente)Identidad.identificarPersona();
    	lineas();
        print("Ha seleccionado Ecosistema de Consultas Personalizadas. Elija una opción:");
        print("1. Consulta general de productos\n" +
              "2. Consulta de productos por categoría\n" +
              "3. Consulta de membresías\n" +
              "4. Volver");
        print("");
        print("Escoja un número: ");

        int consulta = escaner(4); // Usando escaner con rango para asegurar la entrada correcta.

        print("Opción seleccionada: " + consulta);

        switch (consulta) {
            case 1:
                consultaGeneralProductos(cliente);
                break;
            case 2:
                consultaPorCategoria(cliente);
                break;
            case 3:
                consultaMembresias(cliente);
                break;
            case 4:
                Main.escogerFuncionalidad();
                break;
            default:
                print("Opción no válida");
        }
    }
    
 // ---------------------------------------------------------------------------------------------------------------------------------------------------
    //Este método permite al cliente realizar una consulta general de productos en las tiendas disponibles,
    //seleccionando una tienda para explorar los productos o regresar al menú principal.
    public static void consultaGeneralProductos(Cliente cliente) {
        if (Tienda.buscarTienda()) {
        	print("Selecciona una de las tiendas que tenemos disponibles para ti" );
            ArrayList<Tienda> tiendas = Tienda.revisionTienda(Tienda.getTiendas());
            printTablaTiendas(tiendas);
            print("Selecciona una tienda:");
            int tiendaSeleccionada = escaner(tiendas.size() + 1); 

            if (tiendaSeleccionada == tiendas.size() + 1) { // Verificar si la opción seleccionada es "Volver"
                consultasEco();
            } else {
                Tienda tienda = tiendas.get(tiendaSeleccionada - 1);
                print("¿Deseas usar un presupuesto por defecto o ingresar uno personalizado?");
                print("1. Presupuesto por defecto");
                print("2. Presupuesto personalizado");

                int opcionPresupuesto = escaner(2);
                if (opcionPresupuesto == 1) {
                    Cliente.asignaciones(cliente, tienda);
                } else if (opcionPresupuesto == 2) {
                    print("Ingresa la cantidad de dinero que deseas asignar:");
                    double cantidadPersonalizada = sc.nextDouble(); // Método para obtener la cantidad de dinero del usuario
                    Cliente.asignaciones(cliente, tienda,cantidadPersonalizada);
                }
                print("Has seleccionado la tienda: " + tienda.getNombre());
                print("Esta servira para escoger productos en la funcionalidad 2");
                print("1. Desea chismosear la descripcion de productos en la tienda");
                print("2. Desea ir al menu principal para empezar a hacer sus compras");
                print("3. Volver a escoger tienda");
                print("");
                print("Escoja un número: ");
                int decision=escaner(3);
                switch(decision) {
                case 1:
                	seleccionarProducto(listaProductos(tienda,cliente,null),cliente);
                	break;
                case 2:
                	Main.escogerFuncionalidad();
                	break;
                case 3:
                	consultasEco();
                	break;
                }
            }
            
        } else {
            print("Lo sentimos, no hay tiendas disponibles en este momento.");
        }
    }
    
    
 // ---------------------------------------------------------------------------------------------------------------------------------------------------
    //Este método permite al cliente consultar las categorías de productos disponibles en las tiendas, seleccionar una tienda 
    //y realizar acciones adicionales, como explorar los productos de esa tienda o regresar al menú principal.
    public static void consultaPorCategoria(Cliente cliente) {
        if (Tienda.buscarTienda()) {
            print("Selecciona una de las categorías disponibles en nuestras tiendas:");
            printTablaCategorias();

            int categoriaSeleccionada = escaner(Categoria.values().length);

            ArrayList<Tienda> tiendas = busquedaCategoria(categoriaSeleccionada);
            if (tiendas != null && !tiendas.isEmpty()) {
                printTablaTiendas(tiendas);
                
                print("Selecciona una tienda:");
                int tiendaSeleccionada = escaner(tiendas.size() + 1); 

                if (tiendaSeleccionada == tiendas.size() + 1) { // Verificar si la opción seleccionada es "Volver"
                    consultasEco();
                } else {
                    Tienda tienda = tiendas.get(tiendaSeleccionada - 1);
                    print("¿Deseas usar un presupuesto por defecto o ingresar uno personalizado?");
                    print("1. Presupuesto por defecto");
                    print("2. Presupuesto personalizado");

                    int opcionPresupuesto = escaner(2);
                    if (opcionPresupuesto == 1) {
                        Cliente.asignaciones(cliente, tienda);
                    } else if (opcionPresupuesto == 2) {
                        print("Ingresa la cantidad de dinero que deseas asignar:");
                        double cantidadPersonalizada = sc.nextDouble(); // Método para obtener la cantidad de dinero del usuario
                        Cliente.asignaciones(cliente, tienda,cantidadPersonalizada);
                    }
                  
                    print("Has seleccionado la tienda: " + tienda.getNombre());
                    print("Esta servira para escoger productos en la funcionalidad 2");
                    print("1. Desea chismosear la descripcion de productos en la tienda");
                    print("2. Desea ir al menu principal para empezar a hacer sus compras");
                    print("3. Volver a escoger tienda");
                    print("");
                    print("Escoja un número: ");
                    int decision=escaner(3);
                    switch(decision) {
                    case 1:
                    	seleccionarProducto(listaProductos(tienda,cliente,Categoria.values()[categoriaSeleccionada - 1]),cliente);
                    	break;
                    case 2:
                    	Main.escogerFuncionalidad();
                    	break;
                    case 3:
                    	consultasEco();
                    	break;
                  
                    }
                }
            } else {
                print("No hay tiendas disponibles para la categoría seleccionada.");
            }
        } else {
        	print("Lo sentimos, no hay tiendas disponibles en este momento.");
        }
              
    }

 // ---------------------------------------------------------------------------------------------------------------------------------------------------
    //Este método que permite a un cliente consultar y gestionar su membresía.
    //Dependiendo de la membresía actual del cliente, el método proporciona 
    //información sobre los beneficios, permite mejorar la membresía o 
    //seleccionar una nueva membresía si el cliente no tiene una.
    public static void consultaMembresias(Cliente cliente) {
        if (Tienda.buscarTienda()) {
        	if (cliente.mayorEdad() ) {
        		 if (cliente.getMembresia() != null) {
        		        // Mostrar beneficios de la membresía actual
        		        String perfilDemografico = Cliente.PerfilDemografico(cliente);
        		        String beneficios = Cliente.getMensajePorPerfil(perfilDemografico,cliente.getMembresia());
        		        
        		        	print("Tu membresía actual es: " + cliente.getMembresia());
        		        	print("Beneficios: " + beneficios);

        		        if (cliente.getMembresia() == Membresia.VIP) {
        		            // Mostrar beneficios VIP y mensaje de agradecimiento
        		            	print("¡Gracias por ser un cliente VIP! Disfruta de todos los beneficios exclusivos.");
        		            	print("Recuerda ir a revisar alguna tienda esto servirá para escoger productos en la funcionalidad 2");
        			        	print("");
        		                print("1. Desea ir al menu principal");
        		                print("2. Volver al menu de consulta");
        		                print("");
        		                print("Escoja un número: ");
        		                
        		                int decision=escaner(2);
        		                switch(decision) {
        		                case 1:
        		                	Main.escogerFuncionalidad();
        		                	break;
        		                case 2:
        		                	consultasEco();
        		                	break;
        		                }	
        		            	
        		        } else {
        		            // Ofrecer mejorar la membresía
        		        	print("¿Te gustaría mejorar tu membresía?");
        		        	print("1. Si");
        		        	print("2. No");
        		        	 print("");
        		             print("Escoja un número: ");
        		        	 int decision=escaner(2);
                             switch(decision) {
                             case 1:
                             	print("Puedes mejorar tu membresia a: ");
                             	Membresia nuevaMembresia = printTablaMembresias(cliente);
                             	double costoEvolucion = Cliente.calcularCostoEvolucion(cliente.getMembresia(), nuevaMembresia);
                             	print("Esto costará " + costoEvolucion + " y tu saldo actual es " + cliente.getDinero());
            		        	print("1. Si");
            		        	print("2. No");
            		        	 print("");
            		             print("Escoja un número: ");
            		        	 int decisionest=escaner(2);
                                 switch(decisionest) {
                                 case 1:
                                	print(Cliente.evolucionarMembresia(cliente, nuevaMembresia));
                                    print("");
             		                print("1. Desea ir al menu principal");
             		                print("2. Volver al menu de consulta");
             		                print("");
             		                print("Escoja un número: ");
             		                int decisiones=escaner(2);
             		                switch(decisiones) {
             		                case 1:
             		                	Main.escogerFuncionalidad();
             		                	break;
             		                case 2:
             		                	consultasEco();
             		                	break;
             		                }	
                                
                                 case 2:
                                	 Main.escogerFuncionalidad();
                                 	break;
                                 }
                             }
        		        }
        		    } else {
        		        // Cliente sin membresía
        		        	print("No tienes una membresía. ¿Te gustaría elegir una?");
        		        printTablaMembresias();
        		        print("");
        		        print("Escoja un número: ");
        		        
        		        int decision=escaner(4);
                        switch(decision) {
                        case 1:
                        	primeraMembresia(cliente,Membresia.BASICO);
                        	break;
                        case 2:
                        	primeraMembresia(cliente,Membresia.PREMIUM);
                        	break;
                        case 3:
                        	primeraMembresia(cliente,Membresia.VIP);
                        	break;	
                        case 4:
                        	consultasEco();
                        	break;
                      
                        }
        		       
        		    }
        		}
        		
        		
	        	
	         
        	else if (!cliente.mayorEdad()) {
	        	print("Lo sentimos, no puedes obtener una membresía ya que eres menor de edad.");
	        	print("");
	        	print("Recuerda ir a revisar alguna tienda esto servirá para escoger productos en la funcionalidad 2");
	        	print("");
                print("1. Desea ir al menu principal");
                print("2. Volver al menu de consulta");
                print("");
                print("Escoja un número: ");
                int decision=escaner(3);
                switch(decision) {
                case 1:
                	Main.escogerFuncionalidad();
                	break;
                case 2:
                	consultasEco();
                	break;
                }	
            
            } 
	        else {
            print("Lo sentimos, no hay tiendas disponibles en este momento.");
            }
        }
    }

 // ---------------------------------------------------------------------------------------------------------------------------------------------------
    //Este método se encarga de revisar si hay tiendas para la categoría seleccionada para esto llama a un método en tienda 
    //que te entrega la lista de las tiendas que pertenecen a la categoría a buscar.
    public static ArrayList<Tienda> busquedaCategoria(int categoria) {
        Categoria cat = Categoria.values()[categoria - 1];
        ArrayList<Tienda> tiendas = Tienda.categoriaTienda(cat);

        if (tiendas.size() > 0) {
            print("Estas tiendas tienen tu categoría");
        } else {
            print("No hay tiendas disponibles de la categoría " + cat + ".");
        }
        return tiendas;
    }

 // ---------------------------------------------------------------------------------------------------------------------------------------------------
    /*Este método obtiene y filtra los productos disponibles en una tienda específica,
      basándose en la edad del cliente y en una categoría opcional. Si la categoría es 
      nula, se filtrarán los productos solo por la edad del cliente. Si se proporciona
      una categoría, se filtrarán los productos por edad y categoría.*/
    public static  ArrayList<Producto> listaProductos(Tienda tienda, Cliente cliente, Categoria categoria) {
        ArrayList<Producto> productos = tienda.obtenerTodosLosProductos();
        ArrayList<Producto> productosAdecuados;
        
        

        if (categoria == null) {
            // Si no se proporciona una categoría, filtrar solo por edad
            productosAdecuados = Producto.filtrarPorEdad(productos, cliente);
            
        } else {
            // Si se proporciona una categoría, filtrar por edad y categoría
            productosAdecuados = Producto.filtrarPorEdadYCategoria(productos, cliente, categoria);
        }
        
        
        
        if (productosAdecuados.size() > 0) {
        	 printTablaProductos(productosAdecuados);
            return productosAdecuados;
        } else {
            print("No hay productos disponibles para su grupo de edad" +
                  (categoria != null ? " en esta categoría." : "."));
            
        }

        print("");
        print("Desea elegir otra tienda?");
        print("1. Sí");
        print("2. No");
        print("");
        print("Escoja un número: ");
        int opcion = escaner(2);

        if (opcion == 1) {
            consultaPorCategoria(cliente);
            return null;
        } else {
            consultasEco();
            return null;
        }
    }

 // --------------------------------------------------------------------------------------------------------------------------------------------------- 
   /* Este método permite al cliente seleccionar un producto de una lista proporcionada para ver sus detalles.
      Después de mostrar los detalles del producto, se le da la opción de elegir otro producto o regresar al menú principal.*/ 
    public static void seleccionarProducto(ArrayList<Producto> productos,Cliente cliente) {
        print("Seleccione un producto para ver sus detalles:");
        print("");
        print("Escoja un número: ");
        
        int seleccionProducto = escaner(8);
        if(seleccionProducto== productos.size()+1 ) {
        	consultaPorCategoria(cliente);
        }
        else {
        // Obtener el producto seleccionado
        Producto productoSeleccionado = productos.get(seleccionProducto - 1);

        // Mostrar detalles del producto en tabla ASCII
        printDetallesProducto(productoSeleccionado);
        
        // Volver al menú de consultas después de mostrar los detalles
        print("¿Desea elegir otro producto?");
        print("1. Sí");
        print("2. No");
        print("");
        print("Escoja un número: ");

        int opcion = escaner(2);

        if (opcion == 1) {
        	printTablaProductos(productos);
            seleccionarProducto(productos,cliente); // Volver a elegir otro producto
        } else {
        	Main.escogerFuncionalidad(); // Regresar al menú principal
        }
        }
    }
  // ---------------------------------------------------------------------------------------------------------------------------------------------------
   // Método que gestiona la selección y compra de una membresía para un cliente
    public static void primeraMembresia(Cliente cliente, Membresia membresia) {
        Scanner scanner = new Scanner(System.in);
        String mensaje = "";

        // Obtener perfil demográfico
        String perfilDemografico = Cliente.PerfilDemografico(cliente);

        switch (membresia) {
            case BASICO:
                mensaje += Cliente.getMensajePorPerfil(perfilDemografico, Membresia.BASICO);
                print("El costo de la membresía es: $" + Membresia.BASICO.getPrecio());
                break;
            case PREMIUM:
                mensaje += Cliente.getMensajePorPerfil(perfilDemografico, Membresia.PREMIUM);
                print("El costo de la membresía es: $" + Membresia.PREMIUM.getPrecio() );
                break;
            case VIP:
                mensaje += Cliente.getMensajePorPerfil(perfilDemografico, Membresia.VIP);
                print("El costo de la membresía es: $" + Membresia.VIP.getPrecio() );
                break;
            default:
                mensaje = "Ha ocurrido un error.";
                break;
        }

        // Mostrar beneficios de la membresía seleccionada
        print(mensaje);
        
        

        // Preguntar si desea comprar la membresía
        print("¿Deseas comprar esta membresía?");
        print("1. Sí");
        print("2. No");
        print("");
        print("Escoja un número: ");

        int decision = escaner(2);
        switch (decision) {
            case 1:
                // Verificar si el cliente tiene suficiente dinero para la membresía seleccionada
                double costo = Cliente.calcularCostoEvolucion(cliente.getMembresia(), membresia);
                if (cliente.getDinero() >= costo) {
                    cliente.setDinero(cliente.getDinero() - costo); // Deduce el costo del saldo del cliente
                    cliente.setMembresia(membresia); // Actualiza la membresía del cliente
                    print("¡Felicidades! Ahora eres miembro de la membresía " + membresia.toString());
                    // Volver al menú principal o consultar otra membresía
                    print("1. Volver al menú principal");
                    print("2. Consultar otra membresía");
                    print("");
                    print("Escoja un número: ");
                    int siguientePaso = escaner(2);
                    if (siguientePaso == 1) {
                        Main.escogerFuncionalidad();
                    } else {
                        consultaMembresias(cliente);
                    }
                } else {
                    print("Lo siento, no tienes suficiente saldo para comprar esta membresía.");
                    print("1. Volver al menú principal");
                    print("2. Consultar otra membresía");
                    print("");
                    print("Escoja un número: ");
                    int siguientePaso = escaner(2);
                    if (siguientePaso == 1) {
                        Main.escogerFuncionalidad();
                    } else {
                        consultaMembresias(cliente);
                    }
                }
                break;
            case 2:
                // Volver al menú principal o consultar otra membresía
                print("¿Deseas volver al menú principal o consultar otra membresía?");
                print("1. Volver al menú principal");
                print("2. Consultar otra membresía");
                print("");
                print("Escoja un número: ");
                int opcion = escaner(2);
                if (opcion == 1) {
                    Main.escogerFuncionalidad();
                } else {
                    consultaMembresias(cliente);
                }
                break;
            default:
                print("Opción no válida. Inténtelo de nuevo.");
                primeraMembresia(cliente, membresia); // Volver a intentar la selección
                break;
        }
        scanner.close();
    }
    

 // ---------------------------------------------------------------------------------------------------------------------------------------------------
    // Método para imprimir las tiendas en formato tabla ASCII
    public static void printTablaTiendas(ArrayList<Tienda> tiendas) {
        print("+------------------------------------+");
        print("| No. |       Nombre de Tienda       |");
        print("+------------------------------------+");

        int anchoCelda = 28; // Ancho de la celda para el nombre de la tienda

        for (int i = 0; i < tiendas.size(); i++) {
            String nombreTienda = tiendas.get(i).getNombre();
            int espacios = (anchoCelda - nombreTienda.length()) / 2;

            // Relleno a izquierda y derecha para centrar el nombre de la tienda
            String paddingIzquierdo = " ".repeat(Math.max(0, espacios));
            String paddingDerecho = " ".repeat(Math.max(0, espacios + (anchoCelda - nombreTienda.length()) % 2));

            print(String.format("| %-3d |%s%s%s|", i + 1, paddingIzquierdo, nombreTienda, paddingDerecho));
        }
        int numeroVolver = tiendas.size() + 1;
        String opcionVolver = "Volver";
        int espaciosVolver = (anchoCelda - opcionVolver.length()) / 2;
        String paddingIzquierdoVolver = " ".repeat(Math.max(0, espaciosVolver));
        String paddingDerechoVolver = " ".repeat(Math.max(0, espaciosVolver + (anchoCelda - opcionVolver.length()) % 2));

        print(String.format("| %-3d |%s%s%s|", numeroVolver, paddingIzquierdoVolver, opcionVolver, paddingDerechoVolver));
        print("+------------------------------------+");
    }

 // ---------------------------------------------------------------------------------------------------------------------------------------------------

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
        int numeroVolver = productos.size() + 1;
        String opcionVolver = "Volver";
        int espaciosVolver = (anchoCelda - opcionVolver.length()) / 2;
        String paddingIzquierdoVolver = " ".repeat(Math.max(0, espaciosVolver));
        String paddingDerechoVolver = " ".repeat(Math.max(0, espaciosVolver + (anchoCelda - opcionVolver.length()) % 2));

        print(String.format("| %-3d |%s%s%s|", numeroVolver, paddingIzquierdoVolver, opcionVolver, paddingDerechoVolver));
        print("+------------------------------------+");
    }

 // ---------------------------------------------------------------------------------------------------------------------------------------------------
   
    // Método para imprimir las categorias en formato tabla ASCII
    public static void printTablaCategorias() {
        print("+--------------------------+");
        print("| No. |      Categoría     |");
        print("+--------------------------+");
        int anchoCelda = 20; // Ancho de la celda para la categoría
        int contador = 1;
        for (Categoria categoria : Categoria.values()) {
            String categoriaTexto = categoria.toString();
            int espacios = (anchoCelda - categoriaTexto.length()) / 2;
            
            // Si la longitud es impar, añade un espacio adicional al final
            String paddingIzquierdo = " ".repeat(Math.max(0, espacios));
            String paddingDerecho = " ".repeat(Math.max(0, espacios + (anchoCelda - categoriaTexto.length()) % 2));
            
            print(String.format("| %-3d |%s%s%s|", contador, paddingIzquierdo, categoriaTexto, paddingDerecho));
            contador++;
        }
        print("+--------------------------+");
        
    }
 // ---------------------------------------------------------------------------------------------------------------------------------------------------
    
	 // Método para imprimir los detalles del producto en formato tabla ASCII
	    public static void printDetallesProducto(Producto producto) {
	    	int anchoTabla = 44; 

	        // Crea la tabla con formato
	        print("+--------------------------------------------+");
	        print("|            Detalles del Producto           |");
	        print("+--------------------------------------------+");
	        print("  Nombre:        " + ajustarTexto(producto.getNombre(), anchoTabla ));
	        print("  Marca:         " + ajustarTexto(producto.getMarca(), anchoTabla ));
	        print("  Precio:        $" + String.format("%.2f", producto.getPrecio())); 
	        print("  Descripción:   " + ajustarTexto(producto.getDescripcion(), anchoTabla) );
	        print("  Tamaño:        " + ajustarTexto(producto.getTamaño().toString(),anchoTabla));
	        print("+--------------------------------------------+");
	    }
	    
	    public static String ajustarTexto(String texto, int ancho) {
	        if (texto.length() > ancho) {
	            return texto.substring(0, ancho - 3) + "..."; // Acorta el texto si es demasiado largo
	        } else {
	            return texto + " ".repeat(ancho - texto.length()); // Añade espacios para ajustar el texto
	        }
	    }
	    
	    // Método para imprimir las membresias en formato tabla ASCII
	    public static void printTablaMembresias() {
	        print("+--------------------------+");
	        print("| No. |  Tipo de Membresía |");
	        print("+--------------------------+");
	        int anchoCelda = 20; // Ancho de la celda para el tipo de membresía
	        int contador = 1;
	        for (Membresia membresia : Membresia.values()) {
	            String membresiaTexto = membresia.toString();
	            int espacios = (anchoCelda - membresiaTexto.length()) / 2;
	            
	            // Si la longitud es impar, añade un espacio adicional al final
	            String paddingIzquierdo = " ".repeat(Math.max(0, espacios));
	            String paddingDerecho = " ".repeat(Math.max(0, espacios + (anchoCelda - membresiaTexto.length()) % 2));
	            
	            print(String.format("| %-3d |%s%s%s|", contador, paddingIzquierdo, membresiaTexto, paddingDerecho));
	            contador++;
	        }
	        int numeroVolver = contador;
	        String opcionVolver = "Volver";
	        int espaciosVolver = (anchoCelda - opcionVolver.length()) / 2;
	        String paddingIzquierdoVolver = " ".repeat(Math.max(0, espaciosVolver));
	        String paddingDerechoVolver = " ".repeat(Math.max(0, espaciosVolver + (anchoCelda - opcionVolver.length()) % 2));

	        print(String.format("| %-3d |%s%s%s|", numeroVolver, paddingIzquierdoVolver, opcionVolver, paddingDerechoVolver));
	        print("+--------------------------+");
	    }
	    
	    public static Membresia printTablaMembresias(Cliente cliente) {
	        print("+--------------------------+");
	        print("| No. |  Tipo de Membresía |");
	        print("+--------------------------+");
	        int anchoCelda = 20; // Ancho de la celda para el tipo de membresía
	        int contador = 1;
	        Map<Integer, Membresia> opciones = new HashMap<>(); // Mapa para rastrear las opciones disponibles

	        // Definir un orden lógico de membresías usando ArrayList
	        ArrayList<Membresia> ordenMembresias = new ArrayList<>();
	        ordenMembresias.add(Membresia.BASICO);
	        ordenMembresias.add(Membresia.PREMIUM);
	        ordenMembresias.add(Membresia.VIP);

	        // Obtener la posición de la membresía actual del cliente en la lista
	        int indiceMembresiaActual = ordenMembresias.indexOf(cliente.getMembresia());

	        // Mostrar solo las membresías superiores a la actual
	        for (int i = indiceMembresiaActual + 1; i < ordenMembresias.size(); i++) {
	            Membresia membresia = ordenMembresias.get(i);
	            String membresiaTexto = membresia.toString();
	            int espacios = (anchoCelda - membresiaTexto.length()) / 2;
	            String paddingIzquierdo = " ".repeat(Math.max(0, espacios));
	            String paddingDerecho = " ".repeat(Math.max(0, espacios + (anchoCelda - membresiaTexto.length()) % 2));

	            print(String.format("| %-3d |%s%s%s|", contador, paddingIzquierdo, membresiaTexto, paddingDerecho));
	            opciones.put(contador, membresia);
	            contador++;
	        }

	        int numeroVolver = contador;
	        String opcionVolver = "Volver";
	        int espaciosVolver = (anchoCelda - opcionVolver.length()) / 2;
	        String paddingIzquierdoVolver = " ".repeat(Math.max(0, espaciosVolver));
	        String paddingDerechoVolver = " ".repeat(Math.max(0, espaciosVolver + (anchoCelda - opcionVolver.length()) % 2));

	        print(String.format("| %-3d |%s%s%s|", numeroVolver, paddingIzquierdoVolver, opcionVolver, paddingDerechoVolver));
	        print("+--------------------------+");

	        int seleccion = escaner(contador); // Leer selección del cliente

	        // Si el cliente selecciona "Volver", retornamos null o lo llevamos al menú anterior
	        if (seleccion == numeroVolver) {
	            print("Volviendo al menú anterior...");
	            return null;
	        }

	        return opciones.get(seleccion); // Devolver la membresía seleccionada
	    }





    
}


